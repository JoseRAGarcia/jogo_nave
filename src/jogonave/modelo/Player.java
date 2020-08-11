/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogonave.modelo;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.List;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Dedo
 */
public class Player {
    private int x ,y;
    private int dx, dy;
    private Image imagem;
    private int altura, largura;
    private List <Tiro> tiros;
    private boolean isVisible;
    private int velocidade;
    
    public Player(){
        this.x = 100;
        this.y = 100;   
        isVisible = true;
        velocidade = 3;
        
        tiros = new ArrayList<Tiro>();       
    }
    
    public void load(){
        ImageIcon referencia = new ImageIcon("res\\citizen.png");
        imagem = referencia.getImage();
        altura = getImagem().getHeight(null)/2;
        largura = getImagem().getWidth(null)/2;    
    }
    
    public void update(){
        x += dx;
        y += dy;    
    }
    
    public void tiroSimples(){
        this.getTiros().add(new Tiro(x+largura, y+(altura/2)));
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x, y, largura, altura);    
    }
    
    public void keyPressed(KeyEvent tecla){
        int codigo = tecla.getKeyCode();
        
        if(codigo == KeyEvent.VK_SPACE){
            tiroSimples();        
        }
               
        if(codigo == KeyEvent.VK_UP){
            dy = -velocidade;        
        }
        if(codigo == KeyEvent.VK_DOWN){
            dy = velocidade;        
        }
        if(codigo == KeyEvent.VK_LEFT){
            dx = -velocidade;        
        }
        if(codigo == KeyEvent.VK_RIGHT){
            dx = velocidade;        
        }        
    }
    
    public void keyRelease(KeyEvent tecla){
        int codigo = tecla.getKeyCode();
        
        if(codigo == KeyEvent.VK_UP){
            dy = 0;        
        }
        if(codigo == KeyEvent.VK_DOWN){
            dy = 0;        
        }
        if(codigo == KeyEvent.VK_LEFT){
            dx = 0;        
        }
        if(codigo == KeyEvent.VK_RIGHT){
            dx = 0;        
        }        
    }

    
    
    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @return the imagem
     */
    public Image getImagem() {
        return imagem;
    }

    /**
     * @return the tiros
     */
    public List <Tiro> getTiros() {
        return tiros;
    }

    /**
     * @return the isVisible
     */
    public boolean isIsVisible() {
        return isVisible;
    }

    /**
     * @param isVisible the isVisible to set
     */
    public void setIsVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }
    
    
    
}
