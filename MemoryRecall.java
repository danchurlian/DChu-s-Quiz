public class MemoryRecall extends MemoryProb {
    protected double waitTime = .6;
    private int ranIndex = 0;

    public MemoryRecall(int problemNumber, int difficulty) {
        super(problemNumber, difficulty);
        setNums();
        ranIndex = (int)(Math.random() * nums.size());
        answer = nums.get(ranIndex);
    }

    private void setNums() {
        int numLength = 4;
        switch (difficulty) {
            case 2:
                waitTime = .4;
                numLength = 6;
                break;
            case 3:
                waitTime = .33;
                numLength = 8;
            default:
                break;
        }

        for (int i = 0; i < numLength; i++) {
            int random = (int)(Math.random() * 10);
            nums.add(random);
        }
    }

    @Override
    public void display() {
        System.out.println(problemNumber+ ". Pay attention to " +nums.size()+ " numbers that are about to flash on the screen one by one.");
        Utils.waitFor(2);
        showNums(waitTime);

        String indexStr = "";
        switch (ranIndex) {
            case 0:
                indexStr = "1st";
                break;
            case 1:
                indexStr = "2nd";
                break;
            case 2:
                indexStr = "3rd";
                break;
            default:
                indexStr = "" +(ranIndex + 1)+ "th";
                break;
        }

        System.out.println("What was the " +indexStr+ " number shown?");
    }
}
