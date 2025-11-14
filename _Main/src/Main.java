public class Main {

    public static void main(String[] args) {
        String[] a = {"bidding:feeds_key:8712c5e3ba5f2af63a57f771b464b08e",
            "bidding:feeds_key:f1b211ee776f7fe4dc214eff748056a5_total",
            "bidding:feeds_key:8712c5e3ba5f2af63a57f771b464b08e_total",
            "bidding:feeds_key:9d47efdfc23b7929594a44f158ffb71f",
            "bidding:feeds_key:9d47efdfc23b7929594a44f158ffb71f_total",
            "bidding:feeds_key:f1b211ee776f7fe4dc214eff748056a5"};
        for (String iter : a) {
            System.out.println("del " + "\"" + iter + "\"");
        }
    }
}