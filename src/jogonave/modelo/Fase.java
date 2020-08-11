/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogonave.modelo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Dedo
 */
public class Fase extends JPanel implements ActionListener{
    
    private Image fundo;
    private Player player;
    private Timer timer;
    private List<Enemy1> enemy1;
    private List<TiroInimigo1> tiroInimigo1;
    private boolean emJogo;
    
    public Fase(){
        setFocusable(true);
        setDoubleBuffered(true);
        
        ImageIcon referencia = new ImageIcon("res\\fundo.jpg");
        fundo = referencia.getImage().getScaledInstance(1024, 720, 100);   
        player = new Player();
        player.load();
        addKeyListener(new TecladoAdapter());
        timer = new Timer(5, this);
        timer.start();
        inicializaInimigos();
        emJogo = true;
    }
    
    public void inicializaInimigos(){
    
        int coordenadas[] = new int[40];
        int coordenadas2[] = new int[120];
        enemy1 = new ArrayList<Enemy1>();
        tiroInimigo1 = new ArrayList<TiroInimigo1>();
        
        for(int i = 0; i < coordenadas.length; i++){        
            int x = (int)(Math.random()*8000+1024);
            int y = (int)(Math.random()*620+0);
            enemy1.add(new Enemy1(x, y));
        }
        
        for(int j = 0; j < coordenadas2.length; j++){        
            int x = (int)(Math.random()*24000+1024);
            int y = (int)(Math.random()*620+0);
            tiroInimigo1.add(new TiroInimigo1(x, y));
        }
    }
    
    
    public void paint(Graphics g){
        Graphics2D graficos = (Graphics2D) g;
        if(emJogo==true){
            graficos.drawImage(fundo, 0, 0, null);
            graficos.drawImage(player.getImagem(), player.getX(), player.getY(), this);

            List<Tiro> tiros = player.getTiros();
            for(int i = 0; i< tiros.size(); i++){
                Tiro m = tiros.get(i);
                m.load();
                graficos.drawImage(m.getImagem(), m.getX(), m.getY(), this);        
            }

            for (int o = 0; o < enemy1.size(); o++) {
                Enemy1 in = enemy1.get(o);
                in.load();
                graficos.drawImage(in.getImagem(), in.getX(), in.getY(), this);
            }

            for (int p = 0; p < tiroInimigo1.size(); p++) {
                TiroInimigo1 tirIn = tiroInimigo1.get(p);
                tirIn.load();
                graficos.drawImage(tirIn.getImagem(), tirIn.getX(), tirIn.getY(), this);
            }
        }
        else{
            ImageIcon fimJogo = new ImageIcon("res\\game_over.png");            
            graficos.drawImage(fimJogo.getImage(), 0, 0, null);
        }
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        player.update();
        List<Tiro> tiros = player.getTiros();
        for(int i = 0; i< tiros.size(); i++){
            Tiro m = tiros.get(i);
            if(m.isIsVisible()){
                m.update();
            }
            else {
                tiros.remove(i);
            }
        
        }
        
        for (int o = 0; o < enemy1.size(); o++) {
            Enemy1 in = enemy1.get(o);
            if(in.isIsVisible()){
                in.update();
            }
            else {
                enemy1.remove(o);
            }
        }
        
        for (int p = 0; p < tiroInimigo1.size(); p++) {
            TiroInimigo1 tirIn = tiroInimigo1.get(p);
            if(tirIn.isIsVisible()){
                tirIn.update();
            }
            else {
                tiroInimigo1.remove(p);
            }
        }
        checarColisoes();
        repaint();
    }
    
    public void checarColisoes(){
        Rectangle formaNave = player.getBounds();
        Rectangle formaEnemy1;
        Rectangle formaTiro;
        Rectangle formaTiroInimigo1;
        
        for (int i = 0; i < enemy1.size(); i++) {
            Enemy1 tempEnemy1 = enemy1.get(i);            
            formaEnemy1 = tempEnemy1.getBounds();
            
            if(formaNave.intersects(formaEnemy1)){
                player.setIsVisible(false);
                tempEnemy1.setIsVisible(false);
                emJogo = false;            
            }
            
        }
        
        for (int h = 0; h < tiroInimigo1.size(); h++) {
            TiroInimigo1 tempTiroInimigo1 = tiroInimigo1.get(h);
            formaTiroInimigo1 = tempTiroInimigo1.getBounds();
            
            if(formaNave.intersects(formaTiroInimigo1)){
                player.setIsVisible(false);
                tempTiroInimigo1.setIsVisible(false);
                emJogo = false; }
        
        }
        
        List<Tiro> tiros = player.getTiros();
        for (int j = 0; j < tiros.size(); j++) {
            Tiro tempTiro = tiros.get(j);
            formaTiro = tempTiro.getBounds();
            for (int l = 0; l < enemy1.size(); l++) {
                Enemy1 tempEnemy1 = enemy1.get(l);
                formaEnemy1 = tempEnemy1.getBounds();
                if(formaTiro.intersects(formaEnemy1)){
                    
                    tempEnemy1.setIsVisible(false);
                    tempTiro.setIsVisible(false);
                }
            }
        }
    }
    
    private class TecladoAdapter extends KeyAdapter{
        
        @Override
        public void keyPressed(KeyEvent e){
            player.keyPressed(e);                 
        }
        
        @Override
        public void keyReleased(KeyEvent e){
            player.keyRelease(e);        
        }
    
    
    }
    
}
