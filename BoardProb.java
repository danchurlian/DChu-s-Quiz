import java.util.ArrayList;
public class BoardProb extends Problem{
    private int rows;
    private int cols;
    private int amountToPlace;
    private char emptySpaceChar = '.';
    private String[][] grid;
    private ArrayList<Integer> numsInMap = new ArrayList<Integer>();
    private int randomNum;
    private int problemOption;

    private String question = "What is the answer?";


    public BoardProb(int problemNumber, int difficulty, int rows, int cols) {
        super(problemNumber, difficulty);
        this.rows = rows;
        this.cols = cols;
        this.amountToPlace = getAmountToPlace();
        
        initBoard();
        initAnswer();
    }


    // Generates a random version of the Board Problem and computes the answer.
    private void initAnswer() {
        problemOption = (int)(Math.random() * 4 + 1);
        answer = 0;
        switch (problemOption) {
            case 1:
                randomNum = (int)(Math.random() * 10);
                question = "How many " +randomNum+ "'s are in the map?";
                for (int n: numsInMap) {
                    if (n == randomNum)
                        answer++;
                }
                break;
            case 2:
                randomNum = (int)(Math.random() * 10);
                question = "How many numbers in the map are less than " +randomNum+ "?";
                for (int n: numsInMap) {
                    if (n < randomNum)
                        answer++;
                }
                break;
            case 3:
                randomNum = (int)(Math.random() * 10);
                question = "How many numbers in the map are greater than " +randomNum+ "?";
                for (int n: numsInMap) {
                    if (n > randomNum)
                        answer++;
                }
                break;

            case 4:            
                int randomNum = (int)(Math.random() * 3 + 2);
                question = "How many numbers in the map are multiples of " +randomNum+ "?";
                for (int n: numsInMap) {
                    if (n % randomNum == 0)
                        answer++;
                }
                break;
            case 5:
                question = "Which number in the map is the highest?";
                answer = numsInMap.get(0);
                for (int n: numsInMap) {
                    if (n > answer)
                        answer = n;
                }
                break;
            case 6:
                question = "Which number is the lowest?";
                answer = 10;
                for (int n: numsInMap) {
                    if (n < answer)
                        answer = n;
                }
                break;
            default:
                break;
        }
        // System.out.println(numsInMap);
        // System.out.println(question+ " " +answer);
    }
    private int getAmountToPlace() {
        switch (difficulty) {
            case 1:
                return 8;
            case 2:
                return 14;
            case 3:
                return 20;
            default:
                return 8;
        }
    }


    private void setRandomSpot() {
        int random = (int)(Math.random() * 9 + 1);
        int chosenRow = (int)(Math.random() * rows);
        int chosenCol = (int)(Math.random() * cols);

        if (!grid[chosenRow][chosenCol].equals("" + emptySpaceChar))
            setRandomSpot();
        
        grid[chosenRow][chosenCol] = "" + random;

        numsInMap.add(random);
    }

    private void fillBoard() {
        for (int i = 0; i < amountToPlace; i++) {
            setRandomSpot();
        }
    }

    private void initBoard() {
        grid = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = "" + emptySpaceChar;
            }
        }

        fillBoard();
    }

    private void displayBoard() {
        for (String[] row: grid) {
            String lineStr = "";
            for (String slotVal: row)
                lineStr += slotVal + " ";
            System.out.println(lineStr);
        }
    }

    public void display() {
        System.out.println(problemNumber+ ". Refer to the following map of numbers.");

        displayBoard();

        System.out.println(question);
    }
}
