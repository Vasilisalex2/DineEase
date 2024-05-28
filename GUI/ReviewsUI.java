package GUI;

import business.Business;
import business.StoreRating;
import business.Table;
import users.Customer;
import users.Owner;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ReviewsUI extends JFrame {
    public ReviewsUI(Customer user, Business business){
        setTitle("Reviews UI");
        setSize(460,680);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(topPanel);
        add(scrollPane, BorderLayout.CENTER);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        add(centerPanel, BorderLayout.SOUTH);

        JTextArea reviewInput = new JTextArea();
        reviewInput.setLineWrap(true); // Enable line wrapping
        reviewInput.setWrapStyleWord(true); // Wrap at word boundaries
        JScrollPane scrollPaneInput = new JScrollPane(reviewInput);
        scrollPaneInput.setPreferredSize(new Dimension(450, 100));
        scrollPaneInput.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        centerPanel.add(scrollPaneInput, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        centerPanel.add(bottomPanel, BorderLayout.SOUTH);



        loadPanel(topPanel,business.getReviews());

        JButton backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(100, 30));
        backButton.addActionListener(e -> {
            new BusinessUI(user, business,this.getLocation());
            dispose();
        });

        backButton.setBackground(Color.BLUE);
        backButton.setForeground(Color.WHITE);

        JButton addReviewButton = new JButton("Create Review");
        addReviewButton.setPreferredSize(new Dimension(100, 30));
        addReviewButton.addActionListener(e -> {
            String tempReview = reviewInput.getText();
            if(!tempReview.isEmpty()){
                reviewInput.setText("");
                business.addReview(new StoreRating(user.getFullName(), tempReview));
                topPanel.removeAll();
                topPanel.revalidate();
                topPanel.repaint();
                loadPanel(topPanel,business.getReviews());
            }
        });
        addReviewButton.setPreferredSize(new Dimension(100, 30));

        addReviewButton.setBackground(Color.BLUE);
        addReviewButton.setForeground(Color.WHITE);

        bottomPanel.add(backButton);
        bottomPanel.add(Box.createRigidArea(new Dimension(20, 0))); // Add space between buttons
        bottomPanel.add(addReviewButton);


        setVisible(true);
    }
    private void loadPanel(JPanel panel,ArrayList<StoreRating> reviews){
        for (StoreRating review : reviews) {
            JPanel itemPanel = createItemPanel(review);
            itemPanel.setPreferredSize(new Dimension(0, 90));
            panel.add(itemPanel);
        }
        panel.revalidate();
        panel.repaint();
    }
    private JPanel createItemPanel(StoreRating review) {
        JPanel itemPanel = new JPanel(new BorderLayout());

        // Create a label for the business name
        JLabel nameLabel = new JLabel(review.getCustomerName());
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center align the text
        nameLabel.setFont(new Font("Arial", Font.BOLD, 16)); // Set font style and size
        nameLabel.setForeground(Color.BLUE); // Set text color

        // Create a text area for the business description
        JTextArea reviewArea = new JTextArea(review.getReview());
        reviewArea.setEditable(false); // Make text area not editable
        reviewArea.setLineWrap(true); // Enable line wrapping
        reviewArea.setBackground(new Color(173, 216, 230));
        reviewArea.setWrapStyleWord(true); // Wrap at word boundaries

        JScrollPane scrollPane = new JScrollPane(reviewArea);

        // Add components to the item panel
        itemPanel.add(nameLabel, BorderLayout.NORTH);
        itemPanel.add(scrollPane, BorderLayout.CENTER);

        return itemPanel;
    }
}

