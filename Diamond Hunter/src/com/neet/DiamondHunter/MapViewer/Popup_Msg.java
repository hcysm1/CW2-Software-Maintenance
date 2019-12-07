package com.neet.DiamondHunter.MapViewer;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.*;
import javafx.scene.*;

public class Popup_Msg {

   /*Pupup message whenever user input incorrect value into answer field.*/
   public static void display(String title, String message){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(300);
        window.setMinHeight(80);

        Scene alert_scene = new Scene(layout);
        window.setScene(alert_scene);
        window.showAndWait();
    }


}
