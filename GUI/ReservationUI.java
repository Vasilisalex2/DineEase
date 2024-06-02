package GUI;

import business.Business;
import business.Reservation;
import business.Table;
import users.Customer;
import users.Person;
import users.Worker;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Comparator;

public class ReservationUI extends JFrame {
    public ReservationUI(Person user, Business business,Point location) {
        JDialog popup = new JDialog();

        setTitle("Reservation UI");
        setSize(460, 680);
        setLocation(location);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(bottomPanel, BorderLayout.SOUTH);
        JScrollPane scrollPane = new JScrollPane(topPanel);
        add(scrollPane, BorderLayout.CENTER);

        loadPanel(topPanel, business, business.getTables(),popup,user);

        JButton button = new JButton("Back");
        button.setPreferredSize(new Dimension(100, 30));
        button.addActionListener(e -> {
            if (user instanceof Customer) {
                new BusinessUI((Customer) user, business,this.getLocation());
                popup.dispose();
            } else {
                new DashboardUI(user, business,this.getLocation());
                popup.dispose();
            }
            dispose();
        });

        button.setBackground(Color.BLUE);
        button.setForeground(Color.WHITE);
        bottomPanel.add(button);


        setVisible(true);
    }

    private void loadPanel(JPanel panel, Business business, ArrayList<Table> tables,JDialog popup, Person user) {
        for (Table table : tables) {
            JButton tableButton = new JButton(Integer.toString(table.getTableId()));

            tableButton.addActionListener(e -> {
                if (popup.isVisible()) {
                    popup.setVisible(false);
                    showPopup(table, popup,business,user);
                } else {
                    showPopup(table, popup,business,user);
                }
            });

            tableButton.setBackground(Color.BLUE);
            tableButton.setForeground(Color.WHITE);

            panel.add(tableButton);
        }
        panel.revalidate();
        panel.repaint();
    }

    private void showPopup(Table table, JDialog popup, Business business, Person user) {
        popup.getContentPane().removeAll();
        popup.setTitle("Table " + table.getTableId());
        popup.setSize(300, 400);
        popup.setLocationRelativeTo(this);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JPanel reservationPanel = new JPanel();
        reservationPanel.setLayout(new BoxLayout(reservationPanel, BoxLayout.Y_AXIS));

       updateReservationPanel(reservationPanel,table,user);

        JScrollPane scroll = new JScrollPane(reservationPanel);
        mainPanel.add(scroll);

        JPanel inputPanel = new JPanel();

        JLabel dayLabel = new JLabel("Day:");
        JTextField dayField = new JTextField(2);
        inputPanel.add(dayLabel);
        inputPanel.add(dayField);

        JLabel monthLabel = new JLabel("Month:");
        JTextField monthField = new JTextField(2);
        inputPanel.add(monthLabel);
        inputPanel.add(monthField);

        JLabel yearLabel = new JLabel("Year:");
        JTextField yearField = new JTextField(4);
        inputPanel.add(yearLabel);
        inputPanel.add(yearField);

        JLabel startHourLabel = new JLabel("Start Hour:");
        JTextField startHourField = new JTextField(2);
        inputPanel.add(startHourLabel);
        inputPanel.add(startHourField);

        JLabel startMinuteLabel = new JLabel("Start Minute:");
        JTextField startMinuteField = new JTextField(2);
        inputPanel.add(startMinuteLabel);
        inputPanel.add(startMinuteField);

        JLabel endHourLabel = new JLabel("End Hour:");
        JTextField endHourField = new JTextField(2);
        inputPanel.add(endHourLabel);
        inputPanel.add(endHourField);

        JLabel endMinuteLabel = new JLabel("End Minute:");
        JTextField endMinuteField = new JTextField(2);
        inputPanel.add(endMinuteLabel);
        inputPanel.add(endMinuteField);

        mainPanel.add(inputPanel);

        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        JButton okButton = new JButton("OK");
        okButton.addActionListener(e -> {
            int day = Integer.parseInt(dayField.getText());
            int month = Integer.parseInt(monthField.getText());
            int year = Integer.parseInt(yearField.getText());

            int startHour = Integer.parseInt(startHourField.getText());
            int startMinute = Integer.parseInt(startMinuteField.getText());

            int endHour = Integer.parseInt(endHourField.getText());
            int endMinute = Integer.parseInt(endMinuteField.getText());

            try {
                LocalDate chosenDate = LocalDate.of(year, month, day);

                LocalTime startTime = LocalTime.of(startHour, startMinute);

                LocalTime endTime = LocalTime.of(endHour, endMinute);

                table.addReservation(new Reservation(business, user.getID(), chosenDate, startTime, endTime, user.getID(), table.getTableId()));

                updateReservationPanel(reservationPanel, table,user);

            } catch (DateTimeParseException e2) {
                System.out.println("Invalid input: " + e2.getMessage());
            }
        });
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> popup.dispose());
        cancelButton.setBackground(Color.BLUE);
        cancelButton.setForeground(Color.WHITE);

        okButton.setBackground(Color.BLUE);
        okButton.setForeground(Color.WHITE);

        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);

        popup.add(mainPanel);
        popup.add(buttonPanel, BorderLayout.SOUTH);

        popup.setVisible(true);

    }

    private void updateReservationPanel(JPanel reservationPanel, Table table, Person user) {
        reservationPanel.removeAll();

        ArrayList<Reservation> reservations = table.getReservations();

        reservations.sort(Comparator.comparing(Reservation::getDate).thenComparing(Reservation::getStartTime));

        for (Reservation reservation : reservations) {
            JPanel reservationRow = new JPanel();
            reservationRow.setLayout(new FlowLayout(FlowLayout.LEFT));

            JLabel dateLabel = new JLabel("Date:");
            JLabel dateValue = new JLabel(reservation.getDate().toString());
            JLabel startTimeLabel = new JLabel("Start Time:");
            JLabel startTimeValue = new JLabel(reservation.getStartTime().toString());
            JLabel endTimeLabel = new JLabel("End Time:");
            JLabel endTimeValue = new JLabel(reservation.getEndTime().toString());

            reservationRow.add(dateLabel);
            reservationRow.add(dateValue);
            reservationRow.add(startTimeLabel);
            reservationRow.add(startTimeValue);
            reservationRow.add(endTimeLabel);
            reservationRow.add(endTimeValue);

            if (user instanceof Worker) {
                JButton removeButton = new JButton("Remove");
                removeButton.setBackground(Color.BLUE);
                removeButton.setForeground(Color.WHITE);
                removeButton.addActionListener(e -> {
                    table.removeReservation(reservation);
                    updateReservationPanel(reservationPanel, table, user);
                });
                reservationRow.add(removeButton);
            }

            reservationPanel.add(reservationRow);
        }

        reservationPanel.revalidate();
        reservationPanel.repaint();
    }





}
