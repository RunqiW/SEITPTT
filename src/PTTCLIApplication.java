import controller.PTTController;

/**
 *  Main method for the PTT app.
 *  @author RunQi Wang 2471061
 */

public class PTTCLIApplication {

    public static void main(String[] args){
        PTTController ctrl = new PTTController();
        ctrl.initData();
        ctrl.startPTT();
    }

}
