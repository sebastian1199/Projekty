import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class Slides {

    Vector<ImageIcon> slidevec = new Vector<>();
    int slide_index = 0;
    AirlineSystem system ;
    JLabel slideshowLabel;


    public Slides(AirlineSystem system)
    {
        this.system=system;
        slideshowLabel=system.getSlideshowLabel();
    }

    public void setslideshow() {
        slidevec.add(new ImageIcon(new ImageIcon("slideplane1.jpg").getImage().getScaledInstance(700, 400,
                Image.SCALE_DEFAULT)));
        slidevec.add(new ImageIcon(new ImageIcon("slideplane2.jpg").getImage().getScaledInstance(700, 400,
                Image.SCALE_DEFAULT)));
        slidevec.add(new ImageIcon(new ImageIcon("slideplane4.jpg").getImage().getScaledInstance(700, 400,
                Image.SCALE_DEFAULT)));
        slidevec.add(new ImageIcon(new ImageIcon("slideplane5.jpg").getImage().getScaledInstance(700, 400,
                Image.SCALE_DEFAULT)));
        slidevec.add(new ImageIcon(new ImageIcon("slideplane6.jpg").getImage().getScaledInstance(700, 400,
                Image.SCALE_DEFAULT)));
        slidevec.add(new ImageIcon(new ImageIcon("slideplane3.jpg").getImage().getScaledInstance(700, 400,
                Image.SCALE_DEFAULT)));

        slideshowLabel.setText("");
        slideshowLabel.setIcon(slidevec.get(0));
        delay();
    }

    public void delay() {
        Timer myTimer = new Timer(6000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                slideshowLabel.setIcon(slidevec.get(++slide_index));
                if (slide_index == slidevec.size() - 1) {
                    slide_index = -1;
                }
            }
        });
        myTimer.start();
    }

}
