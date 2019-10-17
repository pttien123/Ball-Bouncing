/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmlball;

import java.awt.event.KeyListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;

/**
 *
 * @author Admin
 */
public class FXMLDocumentController implements Initializable {
    
    private int dx,dy;
    private int duration;
    private Random rand = new Random();
    private ArrayList<Ball> arrBall;
    
   
    @FXML
    private Pane pane;
    
    @FXML
    private Button btPlay;
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO             
        dx = rand.nextInt(40);
        dy = rand.nextInt(40);
        duration = rand.nextInt(501);
        Ball b = new Ball(pane,dx,dy,duration);
        pane.getChildren().add(b.getImageView());
        arrBall = new ArrayList<Ball>();
        arrBall.add(b);            
    }   
    
   @FXML
    public void btEnterKeyPressed(KeyEvent e){
        System.out.println("Bat duoc su kien roi");
        if(e.getCode().equals(KeyCode.ENTER) ){
            dx = rand.nextInt(40);
            dy = rand.nextInt(40);
            duration = rand.nextInt(501);
            Ball b = new Ball(pane, dx, dy, duration);
            arrBall.add(b);
            pane.getChildren().add(b.getImageView());
            if(btPlay.getText().equals("Pause")){
                b.play();
            }
        }
    }
      
    @FXML
    public void btPlayHandler(ActionEvent event) {    
         
        if(btPlay.getText().trim().equals("Play")){
            for(Ball b:arrBall){
                b.play();
            }
            btPlay.setText("Pause"); 
        }
        else{
            for(Ball b:arrBall){
                b.pause();
            }
            btPlay.setText("Play");             
        }        
    }
}
