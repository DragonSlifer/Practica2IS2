/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package GEView;

import java.util.Vector;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Jorge
 */
public class GEShowTeamInfoPanel extends JPanel {

    private JTextArea info;

    public GEShowTeamInfoPanel() {
        info = new JTextArea();
        info.setEditable(false);
        this.add(info);
    }

    public void putInfo(Vector<String> s) {
        if (s.size() > 0) {
            for (int i = 0; i < s.size(); i++) {
                info.append(s.elementAt(i) + "\n");
            }
        } else {
            info.setText("There's no Info");
        }
    }
}
