package java_Hotel;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ManageClientsForm  {
    private JPanel manageClientsPanel;
    private JTextField idTextField;
    private JTextField firstNameTextField;
    private JTextField lastNameTextField;
    private JTextField phoneTextField;
    private JTextField emailTextField;
    private JButton addNewClientButton;
    private JButton editButton;
    private JButton removeButton;
    private JButton clearFieldsButton;
    private JPanel manageClientsPanel1;
    private JTable table1;


    Client client = new Client();



    public ManageClientsForm() {


        addNewClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String fname = firstNameTextField.getText();
                String lname = lastNameTextField.getText();
                String phone = phoneTextField.getText();
                String email = emailTextField.getText();
                 if(fname.trim().equals("") || lname.trim().equals("") || phone.trim().equals("")){
                     JOptionPane.showMessageDialog(manageClientsPanel,"Required Fields","Empty Fields",JOptionPane.WARNING_MESSAGE);
                 } else {
                     if(client.addClient(fname,lname,phone,email)){
                         JOptionPane.showMessageDialog(manageClientsPanel,"New Client Added Successfully","Add Client",JOptionPane.INFORMATION_MESSAGE);
                     }else {
                         JOptionPane.showMessageDialog(manageClientsPanel,"Client Not Added Successfully","Add Client Error",JOptionPane.ERROR_MESSAGE);
                     }
                 }

            }
        });
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                DefaultTableModel model =(DefaultTableModel) table1.getModel();
                int rIndex = table1.getSelectedRow();
                idTextField.setText(model.getValueAt(rIndex,0).toString());
                firstNameTextField.setText(model.getValueAt(rIndex,1).toString());
                lastNameTextField.setText(model.getValueAt(rIndex,2).toString());
                phoneTextField.setText(model.getValueAt(rIndex,3).toString());
                emailTextField.setText(model.getValueAt(rIndex,4).toString());
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id= Integer.valueOf(idTextField.getText());
                String fname = firstNameTextField.getText();
                String lname = lastNameTextField.getText();
                String phone = phoneTextField.getText();
                String email = emailTextField.getText();

                if(fname.trim().equals("") || lname.trim().equals("") || phone.trim().equals("")){
                    JOptionPane.showMessageDialog(manageClientsPanel,"Required Fields","Empty Fields",JOptionPane.WARNING_MESSAGE);
                } else {
                    if(client.editClient(id,fname,lname,phone,email)){
                        JOptionPane.showMessageDialog(manageClientsPanel,"Client Data Updated Successfully","Edit Client",JOptionPane.INFORMATION_MESSAGE);
                    }else {
                        JOptionPane.showMessageDialog(manageClientsPanel,"Client Not Updated","Edit Client Error",JOptionPane.ERROR_MESSAGE);
                    }
                }
                table1.setModel(new DefaultTableModel(null,new Object[]{"ID","First Name","Last Name","Phone","Email"}));
                client.fillClientTable(table1);
            }
        });
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {


                    int id = Integer.parseInt(idTextField.getText());
                    if (client.removeClient(id)) {
                        JOptionPane.showMessageDialog(manageClientsPanel, "Client Deleted Successfully", "Remove Client", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(manageClientsPanel, "Client Not Deleted", "Remove Client Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(manageClientsPanel,ex.getMessage()+" Enter the client ID");
                }
            }
        });
        clearFieldsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                idTextField.setText("");
               firstNameTextField.setText("");
               lastNameTextField.setText("");
               phoneTextField.setText("");
               emailTextField.setText("");
            }
        });

    }

    //public void  ManageClientsForm(){
    //    createTable();
    //}

    private void createTable(){

        table1.setModel(new DefaultTableModel(
                null,
                new String[]{"ID","First Name","Last Name","Phone","Email"}
        ));
        client.fillClientTable(table1);
    }


    void showGUI(){
        JFrame frame=new JFrame();
        //frame.setLocationRelativeTo(null);
        frame.setContentPane(manageClientsPanel);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setSize(300,300);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        createTable();
        // white border to the clear fields button
        Border border = BorderFactory.createMatteBorder(2,2,2,2, Color.white);
        clearFieldsButton.setBorder(border);



    }


}
