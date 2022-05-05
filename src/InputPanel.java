import javax.swing.*;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputPanel extends JFrame {
    static JLabel InformationDog, InformationFood;
    static JTextField Food, TDog;
    boolean setDog  = false;
    boolean setFood = false;
    boolean BoolStart   = false;
    XY foodPosition = new XY();
    XY dogPosition  = new XY();
    public InputPanel()
    {
        super("Поля ввода");
        Graphics h;
        InformationDog = new JLabel();
        InformationDog.setText("Введите коорднаты собаки");
        InformationFood = new JLabel();
        InformationFood.setText("Введите координыти еды");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Food = new JTextField(25);
        TDog = new JTextField(25);
        JButton start = new JButton();
        start.setText("start");
        start.setSize(2, 10);
        JButton smell = new JButton();
        smell.setText("smell");
        smell.setSize(2, 10);
        JPanel contents = new JPanel(new FlowLayout(FlowLayout.LEFT)){
            Graphics2D g2;
            protected void paintComponent(Graphics g ){
                super.paintComponent(g);
                g2=(Graphics2D)g;
                g2.setColor(Color.BLACK);
                g2.drawLine(4, 99+10, 305, 99+10);
                g2.drawLine(4, 400+10, 305, 400+10);
                g2.drawLine(305, 400+10, 305, 99+10);
                g2.drawLine(4, 99+10, 4, 400+10);
                for(int i=0;i<20;i++){
                    for(int j=0;j<20;j++){
                        if(Park.map[j][i]==0){
                            float[] HSB = new float[3];
                            Color.RGBtoHSB(12,106,31, HSB);
                            g2.setColor(Color.getHSBColor(HSB[0],HSB[1],HSB[2]));
                        }else if(Park.map[j][i]==1){
                            float[] HSB = new float[3];
                            Color.RGBtoHSB(11,139,37, HSB);
                            g2.setColor(Color.getHSBColor(HSB[0],HSB[1],HSB[2]));
                        }
                        else{
                            float[] HSB = new float[3];
                            Color.RGBtoHSB(139,11 ,11, HSB);
                            g2.setColor(Color.getHSBColor(HSB[0],HSB[1],HSB[2]));
                        }
                        g2.fillRect(5+15*i, 100+15*j+10, 15, 15);
                    }
                }
if(setDog){
    float[] HSB = new float[3];
    Color.RGBtoHSB(144,48 ,7, HSB);
    g2.setColor(Color.getHSBColor(HSB[0],HSB[1],HSB[2]));

                g2.fillRect(5+15*dogPosition.y, 100+15*dogPosition.x+10, 15, 15);
}
if(setFood){
    float[] HSB = new float[3];
    Color.RGBtoHSB(250,9 ,7, HSB);
    g2.setColor(Color.getHSBColor(HSB[0],HSB[1],HSB[2]));
    g2.fillRect(5+15*foodPosition.y, 100+15*foodPosition.x+10, 15, 15);
}
                if(BoolStart){
                    for(int i =0; i<20;i++)
                        for(int j=0;j<20;j++){
                            if(Dog.SymbolOut[j][i]=='*') {
                                float[] HSB = new float[3];
                                Color.RGBtoHSB(50, 9, 7, HSB);
                                g2.setColor(Color.getHSBColor(HSB[0], HSB[1], HSB[2]));
                                g2.fillRect(5 + 15 * i, 100 + 15 * j+10, 15, 15);
                            }
                        }
                }
            }
        };
        KeyStroke showSmellMap = KeyStroke.getKeyStroke("ctrl N");
        InputMap inputMap = contents.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        ActionMap actionMap = contents.getActionMap();
        inputMap.put(showSmellMap,"smell");
        actionMap.put("smell",new showSmeelMap());
        TDog.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] pos = TDog.getText().split(" ");

                dogPosition.x =Integer.parseInt(pos[1]);
                dogPosition.y = Integer.parseInt(pos[0]);
                setDog = true;
                contents.update(contents.getGraphics());
            }
        });
        Food.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] pos = Food.getText().split(" ");
                foodPosition.x =Integer.parseInt(pos[1]);
                foodPosition.y = Integer.parseInt(pos[0]);
                setFood = true;
                contents.update(contents.getGraphics());
            }
        });
          start.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e) {
                  Park.reload();
                  BoolStart = true;
                  Dog.Walk(foodPosition,dogPosition);//запуск работы
                  contents.update(contents.getGraphics());
              }
          });
        smell.addActionListener(new showSmeelMap());
        contents.add(InformationDog);
        contents.add(TDog);
        contents.add(smell);
        contents.add(InformationFood);
        contents.add(Food);
        contents.add(start);

        setContentPane(contents);
        // Определяем размер окна и выводим его на экран
        setSize(400, 500);
        setVisible(true);
    }



    public static void main(String[] args){

    }
    static class showSmeelMap extends AbstractAction {


        @Override
        public void actionPerformed(ActionEvent e) {
            new SmellMap();
        }

        @Override
        public boolean accept(Object sender) {
            return super.accept(sender);
        }
    }
}