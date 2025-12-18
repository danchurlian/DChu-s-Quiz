public class Problem {
    protected int answer;
    protected int problemNumber;
    protected int difficulty;
    
    public Problem(int problemNumber, int difficulty) {
        this.answer = 0;
        this.problemNumber = problemNumber;
        this.difficulty = difficulty;
    }

    public void display() {
        System.out.println(problemNumber+ ". Displaying problem...");
    }

    protected boolean inputIsValid(String input) {
        return Utils.isNumeric(input);
    }

    public boolean checkIfCorrect(String ans) {
        if (!inputIsValid(ans))
            return false;

        return Integer.parseInt(ans) == answer;
    }    
}
