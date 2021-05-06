package Space;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class OnlineGames extends JPanel {
    private JPanel tblappearence;
    private JLabel lblonlineParty;
    public JTable tblOnlineparty;
    OnlineGames(){

        declaration();
        this.setOpaque(false);
        this.setLayout(new BorderLayout());
        tblappearence.setLayout(new BoxLayout(tblappearence, BoxLayout.PAGE_AXIS));

        appearence();

        this.setBorder(new EmptyBorder(0,20,20,20));
        this.add(lblonlineParty,BorderLayout.NORTH);
        this.add(tblappearence,BorderLayout.CENTER);
        tblappearence.add(tblOnlineparty.getTableHeader());
        tblappearence.add(tblOnlineparty);

        final RowPopup pop = new RowPopup(tblOnlineparty);
        tblOnlineparty.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if(SwingUtilities.isLeftMouseButton(e)){
                    pop.show(e.getComponent(),e.getX(),e.getY());
                }
            }
        });
    }

    private void appearence() {

        lblonlineParty.setText("<html><h1>Online Parties</h1></html>");
        lblonlineParty.setForeground(Color.white);
        lblonlineParty.setFont(new Font("SEGOE UI",Font.ITALIC,12));
        lblonlineParty.setMaximumSize(new Dimension(130,50));

        tblOnlineparty.setBackground(Color.BLACK);
        tblOnlineparty.setForeground(Color.white);
        tblOnlineparty.setGridColor(Color.WHITE);
        tblOnlineparty.getTableHeader().setForeground(Color.white);
        tblOnlineparty.getTableHeader().setBackground(Color.BLACK);
        tblOnlineparty.setBorder(new LineBorder(Color.white));
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        tblOnlineparty.getTableHeader().setFont(new Font("SEGOE UI",Font.BOLD,14));
        tblOnlineparty.getColumnModel().getColumn(0).setCellRenderer(renderer);
        tblOnlineparty.getColumnModel().getColumn(1).setCellRenderer(renderer);
        tblOnlineparty.setDefaultEditor(Object.class,null);
        tblappearence.setOpaque(false);
    }

    private void declaration() {
        String[] colummNames = {"Available Parties","Members"};
        Object[][] info ={{"SPACEEEEE","0"},{"ss","1"},{"xXDalaGodXx","2"}};
        lblonlineParty = new JLabel();
        tblOnlineparty = new JTable(info,colummNames);
        tblappearence = new JPanel();
    }
    class  RowPopup extends JPopupMenu{
        public RowPopup(JTable table){
            JMenuItem join = new JMenuItem("Join");
            join.addActionListener(new ActionListener() {
                @Override
                public void  actionPerformed(ActionEvent arg0){
                    JOptionPane.showMessageDialog(join,"Joining...");
                }
            });
            add(join);
        }

    }

}
