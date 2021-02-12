import javax.swing.*;
import java.awt.*;

public class Messages {

    public void information_window(String message)
    {
        JLabel text = new JLabel(message, JLabel.CENTER);
        JPanel messagePanel = new JPanel();
        messagePanel.setLayout(new BorderLayout());
        messagePanel.add(text, BorderLayout.CENTER);
        JOptionPane.showMessageDialog(null, messagePanel, "Information", JOptionPane.PLAIN_MESSAGE);
    }

    public void picturewindow(String file,String text) {
        ImageIcon icon = new ImageIcon(new ImageIcon(file).getImage().getScaledInstance(100, 100,
                Image.SCALE_DEFAULT));
        JLabel plane = new JLabel(icon);
        JLabel message = new JLabel(text, JLabel.CENTER);
        JPanel messagePanel = new JPanel();
        messagePanel.setLayout(new BorderLayout());
        messagePanel.add(plane, BorderLayout.NORTH);
        messagePanel.add(message, BorderLayout.SOUTH);
        JOptionPane.showMessageDialog(null, messagePanel, "Information", JOptionPane.PLAIN_MESSAGE);
    }
}
