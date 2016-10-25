/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package GEView;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Jorge
 */
public class GEChangeDemarcationPanel extends JPanel {

    private JTextField player_name, act, demarcation;
    private JButton search, change;

    public GEChangeDemarcationPanel() {

        this.setLayout(new GridLayout(0, 3));

        player_name = new JTextField();
        act = new JTextField();
        act.setEditable(false);
        demarcation = new JTextField();
        
        search = new JButton("Buscar Jugador");
        change = new JButton("Cambiar Demarcacion");
        
        this.add(new JLabel("Nombre del jugador"));
        this.add(player_name);
        this.add(search);
        this.add(new JLabel("Demarcacion actual"));
        this.add(act);
        this.add(new JLabel(" "));
        this.add(new JLabel("Nueva demarcacion"));
        this.add(demarcation);
        this.add(change);
    }

    public String getPlayer_name() {
        return player_name.getText();
    }

    public void setPlayer_name(String player_name) {
        this.player_name.setText(player_name);
    }

    public String getDemarcation() {
        return demarcation.getText();
    }

    public void setDemarcation(String demarcation) {
        this.demarcation.setText(demarcation);
    }

    public String getAct() {
        return act.getText();
    }

    public void setAct(String act) {
        this.act.setText(act);
    }

    public JButton getSearch() {
        return search;
    }

    public void setSearch(JButton search) {
        this.search = search;
    }

    public JButton getChange() {
        return change;
    }

    public void setChange(JButton change) {
        this.change = change;
    }

    public void addActionListener(ActionListener al) {
        change.setActionCommand("cdpchange");
        search.setActionCommand("cdpsearch");
        change.addActionListener(al);
        search.addActionListener(al);
    }

}
