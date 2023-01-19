import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.application.Application;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class MyFxApp extends Application {
    int i;
    Image latestImage;
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("My First JavaFX App");

        Image image = new Image( new FileInputStream("spongebob.png"));
        Image image2 = new Image(new FileInputStream("patrick.png"));
        Image image3 = new Image(new FileInputStream("mrkrabs2.png"));
        Image image4 = new Image(new FileInputStream("squid2.png"));
        Image image5 = new Image(new FileInputStream("bubblebass.png"));


        List<Image> list = new ArrayList<Image>();
        list.add(image);
        list.add(image2);
        list.add(image3);
        list.add(image4);
        list.add(image5);
        i = 0;
        latestImage = list.get(i);

        ImageView imageView = new ImageView(latestImage);

        Button addimageButton = new Button("Change the image!");
        addimageButton.setOnAction(e -> {
           i = i + 1;
           if (i < 5) {
               latestImage = list.get(i);
               imageView.setImage(latestImage);
           }
           else {
            addimageButton.setText("Ran out of images!");
           }
        });

        Button deleteimageButton = new Button("Go back an image!");
        deleteimageButton.setOnAction(e -> {
           i = i - 1;
           if (i > 0) {
               latestImage = list.get(i);
               imageView.setImage(latestImage);
           }
            else {
             deleteimageButton.setText("Can't go back further!");
           }
        });

        ChoiceBox imageBox = new ChoiceBox();
        imageBox.getItems().add("Spongebob");
        imageBox.getItems().add("Patrick");
        imageBox.getItems().add("Squidward");
        imageBox.getItems().add("Mr. Krabs");
        imageBox.getItems().add("Bubble Bass");

        imageBox.setOnAction(e -> {
            int selectedIndex = imageBox.getSelectionModel().getSelectedIndex();
            latestImage = list.get(selectedIndex);
            imageView.setImage(latestImage);
        });

        Label label = new Label("Welcome to the image viewer!");


        FileChooser fileChooser = new FileChooser();
        Button chooserButton = new Button("Select File");
        chooserButton.setOnAction(e -> {
            File selectedFile = fileChooser.showOpenDialog(primaryStage);
        });

        VBox vBox = new VBox(imageView, label, addimageButton, deleteimageButton, imageBox, chooserButton);

        Scene scene = new Scene(vBox, 400, 700);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}