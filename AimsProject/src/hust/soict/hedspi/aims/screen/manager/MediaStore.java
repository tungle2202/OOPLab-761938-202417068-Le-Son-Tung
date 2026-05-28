package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MediaStore  extends JPanel {
    private Media media;
    private JFrame parentFrame;

    public MediaStore(Media media, JFrame parentFrame){
        this.media = media;
        this.parentFrame = parentFrame;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("$" + media.getCost());
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        if(media instanceof Playable){
            JButton playButton = new JButton("Play");
            playButton.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    JDialog playDialog = new JDialog(parentFrame, "Playing Media", true);
                    playDialog.setLayout(new BorderLayout());
                    playDialog.add(new JLabel("Playing: " + media.getTitle()), BorderLayout.CENTER);
                    playDialog.setSize(300, 150);
                    playDialog.setLocationRelativeTo(parentFrame);
                    playDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    playDialog.setVisible(true);
                }
            });
            container.add(playButton);
        }
        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

}