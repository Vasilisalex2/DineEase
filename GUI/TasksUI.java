package GUI;

import business.*;
import business.ordering.Order;
import users.Worker;

import javax.swing.*;
import java.awt.*;

public class TasksUI extends JFrame {
    public TasksUI(Worker user, Business business,DineEase app,Point location) {
        setTitle("TasksUI");
        setSize(460,680);
        setLocation(location);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(bottomPanel, BorderLayout.SOUTH);
        JScrollPane scrollPane = new JScrollPane(topPanel);
        add(scrollPane, BorderLayout.CENTER);

        loadPanel(user, user.getTaskList(),topPanel);

        JDialog popup = new JDialog();

        JButton button = new JButton("Back");
        button.setPreferredSize(new Dimension(100, 30));
        button.addActionListener(e->{
            new DashboardUI(user,business,app,this.getLocation());
            popup.dispose();
            dispose();
        });
        JButton addButton = new JButton("Add Task");
        addButton.setPreferredSize(new Dimension(100, 30));
        addButton.addActionListener(e->{
            if (popup.isVisible()) {
                popup.setVisible(false);
                showPopup(popup,user,topPanel);
            } else {
                showPopup(popup,user,topPanel);
            }
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
            JPanel itemPanel = createItemPanel(task, user,tasks,panel);
            panel.add(itemPanel);

        }
        panel.revalidate();
        panel.repaint();
    }
    private JPanel createItemPanel(Task task, Worker user, TaskList tasks,JPanel panel) {
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
            panel.removeAll();
            panel.revalidate();
            panel.repaint();
            loadPanel( user,  tasks, panel);
        });

        itemPanel.add(scrollPane, BorderLayout.CENTER);
        itemPanel.add(doneButton, BorderLayout.EAST);
        return itemPanel;
    }

    private void showPopup(JDialog popup,Worker user,JPanel outsidePanel) {
        popup.setTitle("Create Task");
        popup.setSize(300, 200);
        popup.setLocationRelativeTo(this);

        popup.getContentPane().removeAll();

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(5, 5));

        JTextArea taskDescField = new JTextArea();
        popup.add(new JLabel("Task Description:"),BorderLayout.NORTH);
        taskDescField.setLineWrap(true);
        taskDescField.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(taskDescField);
        panel.add(scrollPane);

        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add");
        addButton.setBackground(Color.BLUE);
        addButton.setForeground(Color.WHITE);
        addButton.addActionListener(e -> {
            String taskDesc = taskDescField.getText();
            if(!taskDesc.isEmpty()){
                user.addToTaskList(new GeneralTask(taskDesc, GeneralTask.taskType.random));
                popup.dispose();
                outsidePanel.removeAll();
                loadPanel( user,  user.getTaskList(), outsidePanel);
            }

        });
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBackground(Color.BLUE);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.addActionListener(e -> popup.dispose());

        buttonPanel.add(addButton);
        buttonPanel.add(cancelButton);

        popup.add(panel, BorderLayout.CENTER);
        popup.add(buttonPanel, BorderLayout.SOUTH);
        popup.setVisible(true);
    }
}


