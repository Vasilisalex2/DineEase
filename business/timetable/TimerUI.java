package business.timetable;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerUI extends JFrame {
    private JLabel countdownLabel;
    private Timer timer;
    private int remainingTime;

    public TimerUI(int countdownDurationInSeconds) {
        setTitle("Countdown Timer");
        setSize(200, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        countdownLabel = new JLabel("Countdown: " + countdownDurationInSeconds);
        add(countdownLabel);

        remainingTime = countdownDurationInSeconds;

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remainingTime--;
                countdownLabel.setText("Countdown: " + remainingTime);

                if (remainingTime <= 0) {
                    ((Timer) e.getSource()).stop(); // Stop the timer when countdown reaches 0
                    JOptionPane.showMessageDialog(TimerUI.this, "Break Ended");
                    dispose();
                }
            }
        });

        timer.start();
        setVisible(true);
    }


}
