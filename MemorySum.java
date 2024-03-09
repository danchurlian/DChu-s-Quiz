public class MemorySum extends MemoryProb {
    protected double waitTime = 1;
    public MemorySum(int problemNum, int difficulty) {
        super(problemNum, difficulty);
        setNums();
    }

    private void setNums() {
        int numsLength = 3;
        switch (difficulty) {
            case 2:
                numsLength = 4;
                waitTime = .6;
                break;
            case 3:
                numsLength = 6;
                waitTime = .33;
            default:
                break;
        }

        for (int i = 0; i < numsLength; i++) {
            int random = (int)(Math.random() * 10);
            nums.add(random);

            answer += random;
        }
    }

    public void display() {
        System.out.println(problemNumber+ ". Pay attention to " +nums.size()+ " numbers that are about to flash on the screen one by one.");
        Utils.waitFor(2);
        showNums(waitTime);
        System.out.println("What is the sum of these numbers?");
    }
}
