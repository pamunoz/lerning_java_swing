package com.pfariasmunoz.swing.gui;

import com.pfariasmunoz.swing.model.Person;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TablePanel extends JPanel {
    
    private JTable table;
    private PersonTableModel tableModel;
    private JPopupMenu popup;
    private PersonTableListener personTableListener;

    public TablePanel() {
        tableModel = new PersonTableModel();
        table = new JTable(tableModel);
        popup = new JPopupMenu();
        
        JMenuItem removeItem = new JMenuItem("Delete row");
        popup.add(removeItem);
        
        table.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                
                int row = table.rowAtPoint(e.getPoint());
                
                table.getSelectionModel().setSelectionInterval(row, row);
                
                if(e.getButton() == MouseEvent.BUTTON3) {
                    popup.show(table, e.getX(), e.getY());
                }                
            }
        });
        
        removeItem.addActionListener(l -> {
            int row = table.getSelectedRow();
            
            if(personTableListener != null) {
                personTableListener.rowDeleted(row);
                tableModel.fireTableRowsDeleted(row, row);
            }
            
            System.out.println(row);
        });
        
        setLayout(new BorderLayout());
        
        add(new JScrollPane(table), BorderLayout.CENTER);
    }
    
    public void setData(List<Person> db) {
        tableModel.setData(db);
    }
    
    public void refresh() {
        tableModel.fireTableDataChanged();
    }
    
    public void setPersonTableListener(PersonTableListener listener) {
        this.personTableListener = listener;
    }
}
