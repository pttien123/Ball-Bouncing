/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmlball;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 *
 * @author Admin
 */
public class Ball {  
    
    private static final String PATH = "/image/ball.png";    
    private int dx = 0;
    private int dy = 0;
    
    private double borderWidth,borderHeight;
    private Timeline timeline;
    private ImageView imgView;
    
    //Constructor - ham khoi tao
    Ball(Pane pane, int dx, int dy, int duration){
        Image img = new Image(PATH);
        this.borderWidth = pane.getPrefWidth() - img.getWidth();
        this.borderHeight = pane.getPrefHeight() - img.getHeight();
        this.imgView = new ImageView(img);        
        this.dx = dx;
        this.dy = dy;
        
        timeline = new Timeline(new KeyFrame(new Duration(duration), e->{
            if(imgView.getX() <= 0){                
                this.dx = -dx;
                setDx(dx);
            }
                
            if(imgView.getX() >= borderWidth){
                setDx(-dx);
            }
                
            if(imgView.getY() >= borderHeight){
                setDy(-dy);
            }
            if(imgView.getY() <= 0){
                this.dy = -dy;              
                setDy(dy);     
            }
            
            imgView.setX(imgView.getX() + getDx());            
            imgView.setY(imgView.getY() + getDy());
        }));
        timeline.setCycleCount(-1);
        
    }
    
     /**
     * @return the dx
     */
    public int getDx() {
        return dx;
    }

   
    /**
     * @return the dy
     */
    public int getDy() {
        return dy;
    }
/**
     * @param dx the dx to set
     */
    public void setDx(int dx) {
        this.dx = dx;
    }

    /**
     * @param dy the dy to set
     */
    public void setDy(int dy) {
        this.dy = dy;
    }
    
    
    public ImageView getImageView(){
        return this.imgView;
    }
    
    public boolean isPlay(){
        if(this.timeline.getStatus() == Animation.Status.RUNNING){            
            return true;
        }
        return false;
    }
    
    public void play(){
        this.timeline.play();
    }
    public void pause(){
        this.timeline.pause();
    }
    
}
