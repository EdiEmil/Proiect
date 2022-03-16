package java_Hotel;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class MainForm {
    private JPanel mainFormPanel;
    private JButton clientsButton;
    private JButton resservationsButton;
    private JButton roomsButton;
    private JList list1;

    public MainForm() {

        clientsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             // open the manage clients form
                ManageClientsForm clientsForm = new ManageClientsForm();
                clientsForm.showGUI();
            }
        });
        resservationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManageReservationsForm reservationsForm = new ManageReservationsForm();
                reservationsForm .showGUI();
            }
        });
        roomsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               ManageRoomsForm roomsForm = new ManageRoomsForm();
                roomsForm .showGUI();
            }
        });
    }

    void showGUI(){
        JFrame frame=new JFrame();
        //frame.setLocationRelativeTo(null);
        frame.setContentPane(mainFormPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setSize(300,300);
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

}

}
