package GUI;

import business.Business;
import business.Task;
import business.TaskList;
import business.ordering.Order;
import users.Worker;

import javax.swing.*;
import java.awt.*;

public class TasksUI extends JFrame {
    public TasksUI(Worker user, Business business) {
        setTitle("TasksUI");
        setSize(460,680);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(bottomPanel, BorderLayout.SOUTH);
        JScrollPane scrollPane = new JScrollPane(topPanel);
        add(scrollPane, BorderLayout.CENTER);

        loadPanel(user, user.getTaskList(),topPanel);

        JButton button = new JButton("Back");
        button.setPreferredSize(new Dimension(100, 30));
        button.addActionListener(e->{
            new DashboardUI(user,business);
            dispose();
        });
        JButton addButton = new JButton("Add Task");
        addButton.setPreferredSize(new Dimension(100, 30));
        addButton.addActionListener(e->{
            //new DashboardUI(user,business);
            //dispose();
        });

        button.setBackground(Color.BLUE);
        button.setForeground(Color.WHITE);
        addButton.setBackground(Color.BLUE);
        addButton.setForeground(Color.WHITE);


        bottomPanel.add(button);
        bottomPanel.add(addButton);

        setVisible(true);

    }



    private void loadPanel(Worker user, TaskList tasks,JPanel panel){
        for (Task task : tasks.getTasks()) {
            JPanel itemPanel = createItemPanel(task, user);
            panel.add(itemPanel);

        }
        panel.revalidate();
        panel.repaint();
    }
    private JPanel createItemPanel(Task task, Worker user) {
        Color LIGHT_BLUE = new Color(173, 216, 230);

        JPanel itemPanel = new JPanel(new BorderLayout());
        itemPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 120));

        JTextArea taskDesc = new JTextArea(task.getDescription());
        taskDesc.setLineWrap(true);
        taskDesc.setEditable(false);
        taskDesc.setWrapStyleWord(true);
        taskDesc.setBackground(LIGHT_BLUE);

        JScrollPane scrollPane = new JScrollPane(taskDesc);
        scrollPane.setPreferredSize(new Dimension(300, 100));

        JButton doneButton = new JButton("Done");
        doneButton.setBackground(Color.BLUE);
        doneButton.setForeground(Color.WHITE);
        doneButton.setPreferredSize(new Dimension(75, 25));
        doneButton.addActionListener(e-> {
            if(task instanceof Order){
                ((Order) task).setOrderFinish();
            }
            user.getTaskList().removeTask(task);
        });

        itemPanel.add(scrollPane, BorderLayout.CENTER);
        itemPanel.add(doneButton, BorderLayout.EAST);
        return itemPanel;
    }
}


