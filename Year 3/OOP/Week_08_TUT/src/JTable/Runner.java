package JTable;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.ArrayList;

public class Runner extends JFrame {

    public static void main(String[] args) {
        Person teacher = new Teacher("Jacob", new Date(12, 12, 2000), 12000.00);
        System.out.println(teacher);

        Person student = new Student("Jake",new Date(29, 10,2002),2022312,"Computer Science");
        System.out.println(student);

        ArrayList <Person> arrayList = new ArrayList<>();
        arrayList.add(teacher);
        arrayList.add(student);

        PersonTableModel model = new PersonTableModel(arrayList);

        JTable myTable = new JTable();
        myTable.getColumnModel().getColumn(2).setCellRenderer(new DefaultTableCellRenderer() {
            Color originalColor = null;

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component renderer = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                if (value == "Teacher") {
                    renderer.setBackground(Color.GREEN);
                } else {
                    renderer.setBackground(Color.BLUE);
                }
                return renderer;
            }
        });
    }
}
