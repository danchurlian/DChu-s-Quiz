import java.util.ArrayList;
public class MemoryProb extends Problem {
    protected ArrayList<Integer> nums = new ArrayList<Integer>();
    protected double waitTime = 1;

    public MemoryProb(int problemNum, int difficulty) {
        super(problemNum, difficulty);
    }

    public void showNums(double waitTime) {
        Utils.clearScreen();
        for (int num: nums) {
            System.out.println(num);
            Utils.waitFor(waitTime);
            Utils.clearScreen();
        }
    }
}
