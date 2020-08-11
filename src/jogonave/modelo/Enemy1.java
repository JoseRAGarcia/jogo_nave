/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogonave.modelo;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author Dedo
 */
public class Enemy1 {
    private Image imagem;
    private int x, y;
    private int largura, altura;
    private boolean isVisible;
            
    //private static final int LARGURA = 938;
    private static int VELOCIDADE = 1;
    
    public Enemy1(int x, int y){
        this.x = x;
        this.y = y;
        isVisible = true;
                   
    }
    
    public void load(){
        ImageIcon referencia = new ImageIcon("res\\inimigo1.png");
        imagem = referencia.getImage();
        
        this.largura = getImagem().getHeight(null)/2;
        this.altura = getImagem().getWidth(null)/2;
    }
    
    public void update(){
        this.x -= getVELOCIDADE();
            //if(this.getX() > LARGURA){
               // setIsVisible(false);
            //}
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x, y, largura, altura);    
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

    /**
     * @return the VELOCIDADE
     */
    public static int getVELOCIDADE() {
        return VELOCIDADE;
    }

    /**
     * @param aVELOCIDADE the VELOCIDADE to set
     */
    public static void setVELOCIDADE(int aVELOCIDADE) {
        VELOCIDADE = aVELOCIDADE;
    }

    /**
     * @return the imagem
     */
    public Image getImagem() {
        return imagem;
    }
    
    
    
}
