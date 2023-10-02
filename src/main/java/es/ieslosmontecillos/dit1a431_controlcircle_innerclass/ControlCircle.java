package es.ieslosmontecillos.dit1a431_controlcircle_innerclass;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ControlCircle extends Application {
    @Override
    public void start(Stage stage) {
        //Scene
        BorderPane borderPane = new BorderPane();
        stage.setTitle("ControlCircle");

        //Circle
        Circle circle = new Circle(25, new Color(0,0,0,0));
        circle.setStroke(Color.BLACK);
        borderPane.setCenter(circle);

        //Buttons
        HBox hbox = new HBox(10);
        hbox.setAlignment(Pos.CENTER);
        Button btnEnlarge = new Button("Enlarge");
        Button btnShrink = new Button("Shrink");
        hbox.getChildren().addAll( btnEnlarge, btnShrink);
        borderPane.setBottom(hbox);

        //Buttons Action
        class EnlargeHandler implements EventHandler<ActionEvent> {
            @Override
            public void handle(ActionEvent e) {
                circle.setRadius(circle.getRadius() + 2);
            }
        }
        class ShrinkHandler implements EventHandler<ActionEvent> {
            @Override
            public void handle(ActionEvent e) {
                circle.setRadius(circle.getRadius() - 2);
            }
        }
        //Buttons set on Action
        btnEnlarge.setOnAction(new EnlargeHandler());
        btnShrink.setOnAction(new ShrinkHandler());


        Scene scene = new Scene(borderPane, 320, 240);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }


}