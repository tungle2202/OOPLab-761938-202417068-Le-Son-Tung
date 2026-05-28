package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCompactDiscToStoreScreen extends JPanel {
    private JTextField tfInputName;
    private JTextField tfInputCategory;
    private JTextField tfInputCost;
    private String name, category;
    private float cost;

    private JTextField tfOutput;

    public AddCompactDiscToStoreScreen(Store store){
        setLayout(new GridLayout(4,2));

        add(new JLabel("Enter CD Name:"));
        tfInputName = new JTextField(10);
        add(tfInputName);
        tfInputName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                name = tfInputName.getText();
            }
        });

        add(new JLabel("Enter Category:"));
        tfInputCategory = new JTextField(10);
        add(tfInputCategory);
        tfInputCategory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                category = tfInputCategory.getText();
            }
        });

        add(new JLabel("Enter Cost:"));
        tfInputCost = new JTextField(10);
        add(tfInputCost);
        tfInputCost.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cost = Float.parseFloat(tfInputCost.getText());
            }
        });

        JButton addBtn = new JButton("Add");
        add(addBtn);
        tfOutput = new JTextField(10);
        add(tfOutput);
        tfOutput.setEditable(false);
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                tfOutput.setText(store.add(new CompactDisc(name, category, cost)));
            }
        });


    }


}
