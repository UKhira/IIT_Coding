package JavaFX_Pack.Table;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.Objects;

public class Table extends JFrame{
    public static void main(String[] args) {
        String[] columnNames = {"City", "Country", "Population"};
        String [][] data = {{"London","United Kingdom", "8825000"},
                {"Paris", "France", "2206000"},
                {"Madrid", "Spain", "3166000"},
                {"Rome", "Italy", "287300"}};

        JTable table = new JTable();
        TableModel model = new DefaultTableModel(data, columnNames);
        table.setModel(model);

        JScrollPane scrollPane =  new JScrollPane(table);
        table.setGridColor(Color.BLACK);

        JFrame frame = new JFrame("My Table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(scrollPane);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
