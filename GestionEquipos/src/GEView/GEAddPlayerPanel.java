/*
 * Add Player Panel
 * It is used to add a new player to the program
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
public class GEAddPlayerPanel extends JPanel {

    /**
     * Variable declaration
     */
    private JTextField name, surname, nacionality, number,bornDate,demarcacion,importe;
    private JPanel j;
    private JButton add;

    /**
     * Constructor
     */
    public GEAddPlayerPanel() {
        
        this.setLayout(new BorderLayout());

        name                = new JTextField();
        surname             = new JTextField();
        nacionality         = new JTextField();
        number              = new JTextField();
        bornDate            = new JTextField();
        demarcacion         = new JTextField();
        importe             = new JTextField();
        add                 = new JButton("Agregar");

        j = new JPanel();
        
        j.setLayout(new GridLayout(0, 2));
        j.add(new JLabel("Nombre: "));
        j.add(name);
        j.add(new JLabel("Apodo: "));
        j.add(surname);
        j.add(new JLabel("Nacionalidad: "));
        j.add(nacionality);
        j.add(new JLabel("Fecha de nacimiento: "));
        j.add(bornDate);
        j.add(new JLabel("Numero"));
        j.add(number);
        j.add(new JLabel("Demarcacion"));
        j.add(demarcacion);
        j.add(new JLabel("Importe"));
        j.add(importe);
        
        this.add(j, "Center");
        this.add(add, "South");
    }
    
    /**
     * It puts the action listener in the add button
     * @param al 
     */
    public void setActionListeners(ActionListener al){
        add.setActionCommand("ADDP");
        add.addActionListener(al);
        
    }
    
    /**
     * Returns all data from new player in a vector of strings
     * @return 
     */
    public Vector<String> returnData() {
        Vector<String> retval = new Vector<>();
        retval.add(name.getText());
        retval.add(surname.getText());
        retval.add(nacionality.getText());
        retval.add(bornDate.getText());
        retval.add(number.getText());
        retval.add(demarcacion.getText());
        retval.add(importe.getText());
        return retval;
    }
}
