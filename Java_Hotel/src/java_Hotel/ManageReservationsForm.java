package java_Hotel;

import javax.swing.*;

public class ManageReservationsForm {
    private JPanel manageReservationsPanel;

    void showGUI(){
        JFrame frame=new JFrame();
        //frame.setLocationRelativeTo(null);
        frame.setContentPane(manageReservationsPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setSize(300,300);
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

    }
}
