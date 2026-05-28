package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StoreManagerScreen extends JFrame{
    private Store store;
    private JPanel option;
    private JPanel center = null;

    JPanel createNorth(){
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }
    JMenuBar createMenuBar(){
        JMenu menu = new JMenu("Options");

        menu.add(new JMenuItem("ViewStore"));
        menu.getItem(0).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cp.remove(1);
                cp.add(viewStore(), BorderLayout.CENTER);
                cp.revalidate();
                cp.repaint();
            }
        });

        JMenu smUpdateStore = new JMenu("Update Store");
        smUpdateStore.add(new JMenuItem("Add Book"));
        smUpdateStore.add(new JMenuItem("Add CD"));
        smUpdateStore.add(new JMenuItem("Add DVD"));
        smUpdateStore.getItem(0).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cp.remove(1);
                cp.add(new AddBookToStoreScreen(store), BorderLayout.CENTER);
                cp.revalidate();
                cp.repaint();

            }
        });
        smUpdateStore.getItem(1).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cp.remove(1);
                cp.add(new AddCompactDiscToStoreScreen(store), BorderLayout.CENTER);
                cp.revalidate();
                cp.repaint();
            }
        });
        smUpdateStore.getItem(2).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cp.remove(1);
                cp.add(new AddDigitalVideoDiscToStoreScreen(store), BorderLayout.CENTER);
                cp.revalidate();
                cp.repaint();
            }
        });
        menu.add(smUpdateStore);


        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader(){
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));
        return  header;
    }

//    JPanel createCenter(){
//        JPanel center = new JPanel();
//        center.setLayout(new GridLayout(3, 3, 2, 2));
//        ArrayList<Media> mediaInStore = store.getItemsInStore();
//        for(int i = 0; i < store.getItemsInStore().size(); i++){
//            MediaStore Cell = new MediaStore(mediaInStore.get(i));
//            center.add(Cell);
//        }
//        return center;
//    }

    JPanel viewStore(){
        JPanel cp1 = new JPanel();
        cp1.setLayout(new GridLayout(3, 3, 2, 2));
        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for(int i = 0; i < store.getItemsInStore().size(); i++){
            MediaStore Cell = new MediaStore(mediaInStore.get(i), this);
            cp1.add(Cell);
        }
        return cp1;
    }

    private Container cp = null;
    public StoreManagerScreen(Store store){
        this.store = store;
        center = viewStore();
        cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(viewStore(), BorderLayout.CENTER);
        setTitle("Store");
        setSize(1024,768);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}