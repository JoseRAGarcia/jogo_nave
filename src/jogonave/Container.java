
package jogonave;

import javax.swing.JFrame;
import jogonave.modelo.Fase;

/**
 *
 * @author Dedo
 */
public class Container extends JFrame{
    
    public Container(){
        iniciarJogo();
        setTitle("Jogo Nave");
        setSize(1024, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
    
    public void iniciarJogo(){
            
        
        add(new Fase());
    
    }
    
    
}
