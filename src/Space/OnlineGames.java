package Space;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class OnlineGames extends JFrame implements MouseListener{
    private JPanel onlinePartybg;
    private JPanel tblappearence;
    private JLabel lblonlineParty;
    public JTable tblOnlineparty;
    OnlineGames(){
        declaration();

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("Online Parties");
        this.setSize(400,300);
        this.setResizable(true);
        this.add(onlinePartybg);
        onlinePartybg.setLayout(new BorderLayout());
        tblappearence.setLayout(new BoxLayout(tblappearence, BoxLayout.PAGE_AXIS));

        appearence();

        onlinePartybg.setBorder(new EmptyBorder(0,20,20,20));
        onlinePartybg.add(lblonlineParty,BorderLayout.NORTH);
        onlinePartybg.add(tblappearence,BorderLayout.CENTER);
        tblappearence.add(tblOnlineparty.getTableHeader());
        tblappearence.add(tblOnlineparty);
    }

    private void appearence() {
        onlinePartybg.setBackground(Color.BLACK);

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
        tblOnlineparty.addMouseListener(this);
    }

    private void declaration() {
        String[] colummNames = {"Available Parties","Join"};
        Object[][] info ={{"SPACEEEEE","0"},{"ss","1"},{"xXDalaGodXx","2"}};
        lblonlineParty = new JLabel();
        onlinePartybg = new JPanel();
        tblOnlineparty = new JTable(info,colummNames);
        tblappearence = new JPanel();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        String a= (String) tblOnlineparty.getValueAt(tblOnlineparty.getSelectedRow(),0);
        System.out.println(a);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
