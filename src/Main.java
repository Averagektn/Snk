import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Main implements ActionListener, ItemListener {

    public JMenuBar createMenuBar() {
        JMenuBar menuBar;
        JMenu filemenu, editmenu, hellomenu;
        JMenu editsubmenu;
        JMenuItem menuItem;

        menuBar = new JMenuBar();

        filemenu = new JMenu("File");
        filemenu.setMnemonic(KeyEvent.VK_F);
        filemenu.getAccessibleContext().setAccessibleDescription("This is the File menu.");
        menuBar.add(filemenu);

        menuItem = new JMenuItem("New",KeyEvent.VK_N);
        menuItem.getAccessibleContext().setAccessibleDescription("");
        menuItem.addActionListener(this);
        filemenu.add(menuItem);

        menuItem = new JMenuItem("Open File...",KeyEvent.VK_O);
        menuItem.getAccessibleContext().setAccessibleDescription("");
        menuItem.addActionListener(this);
        filemenu.add(menuItem);

        menuItem = new JMenuItem("Close",KeyEvent.VK_C);
        menuItem.getAccessibleContext().setAccessibleDescription("");
        menuItem.addActionListener(this);
        filemenu.add(menuItem);

        editmenu = new JMenu("Edit");
        editmenu.setMnemonic(KeyEvent.VK_E);
        editmenu.getAccessibleContext().setAccessibleDescription("This is the Edit menu.");
        menuBar.add(editmenu);

        menuItem = new JMenuItem("Undo Typing",KeyEvent.VK_U);
        menuItem.getAccessibleContext().setAccessibleDescription("");
        menuItem.addActionListener(this);
        editmenu.add(menuItem);

        menuItem = new JMenuItem("Redo",KeyEvent.VK_R);
        menuItem.getAccessibleContext().setAccessibleDescription("");
        menuItem.addActionListener(this);
        editmenu.add(menuItem);

        editsubmenu = new JMenu("Expand Selection To");
        editsubmenu.setMnemonic(KeyEvent.VK_X);
        editsubmenu.addActionListener(this);
        editmenu.add(editsubmenu);

        menuItem = new JMenuItem("Enclosing Element");
        menuItem.getAccessibleContext().setAccessibleDescription("");
        menuItem.addActionListener(this);
        editsubmenu.add(menuItem);

        menuItem = new JMenuItem("Next Element");
        menuItem.getAccessibleContext().setAccessibleDescription("");
        menuItem.addActionListener(this);
        editsubmenu.add(menuItem);

        menuItem = new JMenuItem("Previous Element");
        menuItem.getAccessibleContext().setAccessibleDescription("");
        menuItem.addActionListener(this);
        editsubmenu.add(menuItem);

        hellomenu = new JMenu("Hello");
        hellomenu.setMnemonic(KeyEvent.VK_F);
        hellomenu.getAccessibleContext().setAccessibleDescription("This is the File menu.");
        menuBar.add(hellomenu);

        return menuBar;
    }


    private static void createAndShowGUI() {

        JFrame frame = new JFrame("Menu balls");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocation(600, 300);
        Main smenu = new Main();
        frame.setJMenuBar(smenu.createMenuBar());

        frame.pack();
        frame.setSize(400,300);
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    @Override
    public void itemStateChanged(ItemEvent e) { }

    @Override
    public void actionPerformed(ActionEvent e) {

        JMenuItem jmi = (JMenuItem)e.getSource();
        System.out.println("menu item clicked: " + jmi.getText());
        if (jmi.getText().equalsIgnoreCase("close")) {
            System.exit(0);
        }

    }

}