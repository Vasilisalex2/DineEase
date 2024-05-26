package GUI;

import business.Business;
import business.GeneralTask;
import business.ordering.Dish;
import business.ordering.Menu;
import users.Customer;
import users.Person;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.ArrayList;

public class MenuUI extends JFrame {
    //Menu menu{
    private boolean butDisable;
    public MenuUI(Person user,Business business, Menu menu, Point location){
        butDisable = false;

        setTitle("Menu");
        setSize(460,680);
        setLocation(location);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setLayout(null);
        JPanel panel1 = new JPanel();
        panel1.setSize(300, 600);

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.BLUE);
        JButton butBasket = new JButton("Basket");
        JButton butWaiter = new JButton("Call Waiter");
        butBasket.addActionListener(e -> {
            new BasketUI(user,business);
            dispose();
        });
        butWaiter.addActionListener(e -> {
            if(user instanceof Customer){
                if(!butDisable && ((Customer) user).isCheckedIN()){
                    GeneralTask callWaiter = new GeneralTask("Table Call",GeneralTask.taskType.tableCall);
                    callWaiter.setTable(((Customer)user).getTable());
                    butDisable = true;
                }
            }
        });
        panel2.add(butBasket);
        panel2.add(butWaiter);

        String col = "Dishes";

        ArrayList<Dish> dishes = menu.getMenu();

        Object[][] data = new Object[dishes.size()][1];
        for (int i = 0; i < dishes.size(); i++) {
            data[i][0] = dishes.get(i);
        }


        String[] columnNames = { "Dishes" };
        JTable table = new JTable(data, columnNames);
        // Set custom renderer and editor for each cell
        table.setDefaultRenderer(Object.class, new ButtonRenderer());
        table.setDefaultEditor(Object.class, new ButtonEditor(user,business, new JCheckBox()));

        JScrollPane scrollPane = new JScrollPane(table);
        panel1.add(scrollPane, BorderLayout.CENTER);

        add(panel1,BorderLayout.NORTH);
        add(panel2, BorderLayout.SOUTH);

        setVisible(true);

    }


}



// Custom renderer for displaying buttons
class ButtonRenderer extends JButton implements TableCellRenderer {
    private Dish dish;
    public ButtonRenderer() {
        setOpaque(true);
    }

    //public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
      //  return null;
    //}
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        dish = (Dish) value;
        setText(value != null ? dish.getName() : "");
        return this;
    }
}

// Custom editor for handling button clicks
class ButtonEditor extends DefaultCellEditor {
    private JButton button;
    private String label;
    private boolean isPushed;
    private Dish dish;

    public ButtonEditor(Person user, Business business, JCheckBox checkBox) {
        super(checkBox);
        button = new JButton();
        //button.setOpaque(true);
        button.addActionListener(e -> {
            new DishUI(user,business,dish,new Point(0,0));
            fireEditingStopped();
            //frane.dispose();
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        dish = (Dish) value;
        button.setText((dish == null) ? "" : dish.getName());
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        return dish;
    }

    /*@Override
    public boolean stopCellEditing() {
        isPushed = false;
        return super.stopCellEditing();
    }*/

}
