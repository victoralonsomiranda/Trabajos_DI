package com.example.apivictor;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.util.Callback;
import javafx.util.StringConverter;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML   private Button  botonFavoritos, botonIrNoticia;

    @FXML   private MenuItem menuContact;

    @FXML   private ImageView imagenNoticia;

    @FXML   private Label labelAuthor, labelDescription, labelName, labelTitle;

    @FXML   private ListView<Noticia> listviewAutores;

    @FXML   private Spinner<Noticia> spinnerNoticia;

    @FXML   private RadioMenuItem colorBlack, colorBlue, colorGreen, colorRed, sincolor;

    @FXML
    private BorderPane pantallaPrincipal;

    private Background backgroundEleccion;

    private ToggleGroup grupoMenu, grupoFondos;


    private ObservableList<Noticia> listaNoticias, listaNoticiasFavorita;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        asociarDatos();
        acciones();
    }

    private void instancias() {
        listaNoticias = FXCollections.observableArrayList();
        listaNoticiasFavorita = FXCollections.observableArrayList();
        grupoFondos = new ToggleGroup();
        grupoFondos.getToggles().addAll(colorBlack,colorBlue,colorGreen,colorRed,sincolor);
    }


    private void asociarDatos() {
                String urlquery="https://newsapi.org/v2/everything?domains=wsj.com&apiKey=9890600f8c8a49079fae842c907976c5";
        try{
            URL url = new URL(urlquery);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));//3
            StringBuilder lectura = new StringBuilder();
            String linea = null;

            while((linea = bufferedReader.readLine())!=null){
                lectura.append(linea);
            }

            JSONObject jsonGeneral = new JSONObject(lectura.toString());
            JSONArray arrayResultados = jsonGeneral.getJSONArray("articles");
            for (int i = 0; i < arrayResultados.length(); i++) {
                JSONObject resultado = arrayResultados.getJSONObject(i);
                JSONObject noticia = resultado.getJSONObject("source");
                String name = noticia.getString("name");
                String title = resultado.getString("title");
                String description = resultado.getString("description");
                String link = resultado.getString("url");
                String image = resultado.getString("urlToImage");
                Object author = resultado.get("author");
                String authornombre = author.getClass().getName();

                listaNoticias.add(new Noticia(name,authornombre,title,description,link,image));
            }
            spinnerNoticia.setValueFactory(new SpinnerValueFactory.ListSpinnerValueFactory<>(listaNoticias));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void acciones() {
        botonFavoritos.setOnAction(new ManejoPulsaciones());
        listviewAutores.cellFactoryProperty();
        spinnerNoticia.getValueFactory().valueProperty().addListener(new ChangeListener<Noticia>() {
            @Override
            public void changed(ObservableValue<? extends Noticia> observable, Noticia oldValue, Noticia newValue) {
                labelName.setText(newValue.getName());
                labelTitle.setText(newValue.getTitle());
                labelDescription.setText(newValue.getDescription());
                imagenNoticia.setImage(new Image(newValue.getImage()));
                //botonIrNoticia.setText(newValue.getLink());
                WebView webView = new WebView();

                WebEngine webEngine = webView.getEngine();
                webEngine.load("http://www.google.com");

                StackPane root = new StackPane();
                root.getChildren().add(webView);

                

                /*
                botonIrNoticia.setOnAction(e -> {
                    try {
                        Desktop.getDesktop().browse(new URI("http://www.enlace.com"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                });*/

            }
        });

        grupoFondos.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                String eleccion=null;
                RadioMenuItem radioSeleccionado = (RadioMenuItem) grupoFondos.getSelectedToggle();
                if(radioSeleccionado == colorBlack){eleccion = "black.jpg";}
                else if(radioSeleccionado == colorBlue){eleccion = "blue.jpg";}
                else if(radioSeleccionado == colorGreen){eleccion = "green.jpg";}
                else if(radioSeleccionado == colorRed){eleccion = "red.jpg";}
                else if(radioSeleccionado == sincolor){eleccion = "sincolor.jpg";}
                BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true);

                Background background = new Background(new BackgroundImage(new Image(getClass().getResourceAsStream(eleccion)),
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundPosition.CENTER,
                        bSize));
                pantallaPrincipal.setBackground(background);
                backgroundEleccion=background;
            }
        });
    }

    private class ManejoPulsaciones implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            if (event.getSource() == botonFavoritos) {
                listaNoticiasFavorita.add(spinnerNoticia.getValue());
                listviewAutores.setItems(listaNoticiasFavorita);
            }
        }
    }
}