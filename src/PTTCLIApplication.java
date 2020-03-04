import controller.PTTController;

public class PTTCLIApplication {

    public static void main(String[] args){
        PTTController ctrl = new PTTController();
        ctrl.initData();
        ctrl.startPTT();
    }

}
