import controllers.HospitalController;

public class Main {
    public static void main(String[] args) {
        System.out.println("Booting System...");
        HospitalController controller = new HospitalController();
        controller.startSystem();
    }
}
