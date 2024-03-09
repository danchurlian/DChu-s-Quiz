public class Utils {
    public static void waitFor(double duration) {
        try {
            Thread.sleep((long)(duration * 1000));
        }
        catch (InterruptedException e) {

        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
}
