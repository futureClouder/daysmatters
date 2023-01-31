import javax.swing.*;
import java.awt.*;


public class UI
{
    public static void main(String[] args)
    {
       JFrame jFrame = new JFrame("DaysMatter");
       jFrame.setSize(400,300);
       jFrame.setVisible(true);
       jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       JPanel jPanel = new JPanel();
       jFrame.add(jPanel);
       JButton button = new JButton("时间差模式");
       jPanel.add(button);
       button.setMargin(new Insets(20,30,50,40));
       
       JButton jButton = new JButton("倒计时模式");
       jPanel.add(jButton);



    }
}
