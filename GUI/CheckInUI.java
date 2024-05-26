package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckInUI extends JFrame{
    private JPanel CheckInUI;
    private JTextArea textArea1;
    private JButton cancelButton;
    private JButton continueButton;

    public CheckInUI() {

        setTitle("CheckIn UI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,200);
        setVisible(true);
        setLocationRelativeTo(null);
        setContentPane(CheckInUI);

        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuUI MenuUi = new MenuUI();
                dispose();
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StoresUI storesUI = new StoresUI();
                dispose();
            }
        });
    }
    // Method to set the reservation details in the text area
    public void setReservationDetails(String reservationDetails) {
        textArea1.setText(reservationDetails);
    }
}
