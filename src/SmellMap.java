import javax.swing.*;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class SmellMap extends JFrame {
    public SmellMap(){
        super("Карта запаха");
        JPanel contents = new JPanel(new FlowLayout(FlowLayout.LEFT)){
            Graphics2D g2;

            protected void paintComponent(Graphics g ){
                super.paintComponent(g);
                g2=(Graphics2D)g;
                for(int i=0;i<20;i++){
                    for(int j=0;j<20;j++){
                        float[] HSB = new float[3];
                        Color.RGBtoHSB(225,225-Park.SmellMap[j][i]*2,225-Park.SmellMap[j][i]*2, HSB);
                        g2.setColor(Color.getHSBColor(HSB[0],HSB[1],HSB[2]));

                    g2.fillRect(15*i, 15*j, 15, 15);
                    }
                }

        };

    };
        setContentPane(contents);
        // Определяем размер окна и выводим его на экран
        setSize(315, 335);
        setVisible(true);
    }
    }

