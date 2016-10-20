/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package GEView;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Jorge
 */
public class GEMovePlayerPanel extends JPanel {

    JComboBox teamTo, players;
    JTextField teamAt, importe;
    JButton transfer;

    public GEMovePlayerPanel() {
        teamTo = new JComboBox();
        players = new JComboBox();
        teamAt = new JTextField();
        transfer = new JButton("Transferir");
        importe = new JTextField();
        teamAt.setEditable(false);

        this.setLayout(new GridLayout(0, 2));
        this.add(new JLabel("Equipo Actual"));
        this.add(teamAt);
        this.add(new JLabel("Jugador: "));
        this.add(players);
        this.add(new JLabel("Equipo destino"));
        this.add(teamTo);
        this.add(new JLabel("Importe"));
        this.add(importe);
        this.add(new JLabel("Pulsa para Transferir"));
        this.add(transfer);
    }

    public boolean withoutTeams() {
        boolean empty = true;
        if (teamTo.getItemCount() == 0) ///< Esta vacio
        {
            empty = false;
        }
        return empty;
    }

    public boolean withoutPlayers() {
        boolean empty = true;
        if (players.getItemCount() == 0) ///< Esta vacio
        {
            empty = false;
        }
        return empty;
    }

    public void addTeams(Vector<String> team) {

        this.teamTo = new JComboBox(team);

    }

    public void addPlayers(Vector<String> player) {
        DefaultComboBoxModel model = new DefaultComboBoxModel(player);
        players.setModel(model);

    }

    public void setActionListeners(ActionListener al) {
        transfer.setActionCommand("GEMPPT");
        transfer.addActionListener(al);
    }

    public Vector<String> returnData() {
        Vector<String> retval = new Vector<>();
        retval.add(teamAt.getText());
        retval.add((String) players.getSelectedItem());
        retval.add((String) teamTo.getSelectedItem());
        retval.add(importe.getText());
        return retval;
    }
}
