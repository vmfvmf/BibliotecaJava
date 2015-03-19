import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
  
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import lib.jdb.control.jdbtable.JDBTable;
  
/**
 * A simple renderer class for JTable component.
 * @author www.codejava.net
 *
 */
public class CustomTable extends JLabel implements TableCellRenderer {
  
    public static void setDefaulttable(JDBTable jDBTable){
        jDBTable.setDefaultRenderer(Object.class, tabelaPadrao());
        jDBTable.getTableHeader().setDefaultRenderer(new CustomTable());
    }
    
    public static DefaultTableCellRenderer tabelaPadrao(){
        return new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table,
                    Object value, boolean isSelected, boolean hasFocus,
                    int row, int column) {
                Component c = super.getTableCellRendererComponent(table,
                        value, isSelected, hasFocus, row, column);
                
                c.setBackground(isSelected ? new Color(17, 12, 198) : row % 2 == 0
                        ?  new Color(245, 247, 248) : new Color(226, 242, 251));
                return c;
            };
            @Override
            public void setHorizontalAlignment(int alignment) {
                super.setHorizontalAlignment(SwingConstants.CENTER); 
            };
        };
     
    }
    
    public CustomTable() {
        setFont(new Font("Noto Sans", Font.PLAIN, 12));
        setForeground(Color.BLACK);
        setBorder(BorderFactory.createLineBorder(Color.gray));
        setBackground(new Color(211,228,237));
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setText(value.toString());
        setHorizontalAlignment(CENTER);
        return this;
    }
  
}