/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package GEView;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Jorge
 */
public class GEAddTeamPanel extends JPanel {

    /**
     * Variable declaration
     */
    private JTextField name, money, members, gastosFijos, gastosVariables;
    private JPanel j;
    private JButton add;

    /**
     * Constructor
     */
    public GEAddTeamPanel() {

        this.setLayout(new BorderLayout());

        name = new JTextField();
        money = new JTextField();
        members = new JTextField();
        gastosFijos = new JTextField();
        gastosVariables = new JTextField();
        add = new JButton("Agregar");

        j = new JPanel();

        j.setLayout(new GridLayout(0, 2));
        j.add(new JLabel("Nombre: "));
        j.add(name);
        j.add(new JLabel("Dinero: "));
        j.add(money);
        j.add(new JLabel("Numero de abonados: "));
        j.add(members);
        j.add(new JLabel("Gastos Fijos Anuales"));
        j.add(gastosFijos);
        j.add(new JLabel("Gastos Variables Anuales"));
        j.add(gastosVariables);

        this.add(j, "Center");
        this.add(add, "South");
    }

    public Vector<String> returnData() {
        Vector<String> retval = new Vector<>();
        retval.add("-1");
        retval.add(name.getText());
        retval.add(money.getText());
        retval.add(members.getText());
        retval.add(gastosFijos.getText());
        retval.add(gastosVariables.getText());
        return retval;
    }

    public void setActionListeners(ActionListener al) {
        add.setActionCommand("ADDT");
        add.addActionListener(al);
    }
}
