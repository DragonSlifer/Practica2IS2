/*
 *  GEMainClass
 *  Clase principal del programa.
 */
package GEMain;

import GEController.GEController;
import GEModel.GEModel;
import GEView.GEViewMain;

/**
 *
 * @author Jorge
 */
public class GEMainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GEViewMain view = new GEViewMain();
        GEModel model = new GEModel();
        GEController controller = new GEController(model, view);

        view.makeVisible(true,500,500);
    }

}
