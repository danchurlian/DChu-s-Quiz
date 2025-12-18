import java.util.*;

public class Driver {
    private static Scanner inputRead = new Scanner(System.in);
    private static int difficultyNum = 1;
    private static int numProblems = 10;
    private static int numCorrect = 0;
    private static int lastProblemType = 0;
    public static void main(String[] args) {
        Utils.clearScreen();
        displayTitle();
        difficultyNum = getDifficultyChoice();
        numProblems = calculateNumProblems();

        Utils.clearScreen();

        System.out.println("Difficulty number: " +difficultyNum);
        System.out.println("Number of problems: " +numProblems);

        Utils.waitFor(1);
        begin();
        end();
    }

    // User chooses their own difficulty.
    /** 
        @return the difficulty number.
    */
    private static int getDifficultyChoice() {
        boolean valid = false;
        int choice = 1;
        try {
            System.out.println("Choose a difficulty [\"1\" --> Easy] [\"2\" --> Medium] [\"3\" --> Hard] ");
            choice = inputRead.nextInt();
            inputRead.nextLine();

            if (choice >= 1 && choice <= 3)
                valid = true;
        }
        catch(InputMismatchException e) {
            valid = false;
            inputRead.nextLine();
        }
        
        return valid ? choice : getDifficultyChoice();
    }

    
    private static int calculateNumProblems() {
        switch (difficultyNum) {
            case 2:
                return 15;
            case 3:
                return 20;
            default:
                return 10;
        }
    }


    private static void begin() {
        for (int i = 1; i <= numProblems; i++) {
            askProblem(i);
        }
    }


    private static void askProblem(int problemNumber) {
        Problem prob = getRandomProblem(problemNumber);
        Utils.clearScreen();
        prob.display();
        
        String userInput = inputRead.nextLine();
        boolean correct = prob.checkIfCorrect(userInput);
        String resultingMessage = correct ? "Correct!" : "Wrong!";
        System.out.println(resultingMessage);

        if (correct)
            numCorrect++;
        Utils.waitFor(.8);
    }


    /**
     * Returns a randomly generated problem.
     * @param problemNumber
     * @return a random problem.
     */
    private static Problem getRandomProblem(int problemNumber) {
        String[] list = {"Calculation", "Symbol", "MemorySum", "MemoryRecall", "Board", "AlgebraSystem"};
        int random = (int)(Math.random() * list.length);
        // random = (int)(Math.random() * 2 + 4);

        if (random == lastProblemType)
            return getRandomProblem(problemNumber);
        lastProblemType = random;

        switch (random) {
            case 0:
                return new CalculationProb(problemNumber, difficultyNum);

            case 1:
                return new SymbolProb(problemNumber, difficultyNum);

            case 2:
                return new MemorySum(problemNumber, difficultyNum);
            
            case 3:
                return new MemoryRecall(problemNumber, difficultyNum);
            
            case 4:
                return new BoardProb(problemNumber, difficultyNum, 11, 11);
            case 5:
                return new AlgebraSystem(problemNumber, difficultyNum);
            default:
                return new Problem(problemNumber, difficultyNum);
        }
    }

    private static void end() {
        Utils.clearScreen();
        System.out.println("Game ended!");
        Utils.waitFor(2);

        System.err.println("Score: " +numCorrect+ " / " +numProblems);
    }

    private static void displayTitle() {
        System.out.println(  "██████╗  ██████╗██╗  ██╗██╗   ██╗███████╗     ██████╗ ██╗   ██╗██╗███████╗");
        System.out.println(  "██╔══██╗██╔════╝██║  ██║██║   ██║██╔════╝    ██╔═══██╗██║   ██║██║╚══███╔╝");
        System.out.println(  "██║  ██║██║     ███████║██║   ██║███████╗    ██║   ██║██║   ██║██║  ███╔╝ ");
        System.out.println(  "██║  ██║██║     ██╔══██║██║   ██║╚════██║    ██║▄▄ ██║██║   ██║██║ ███╔╝  ");
        System.out.println(  "██████╔╝╚██████╗██║  ██║╚██████╔╝███████║    ╚██████╔╝╚██████╔╝██║███████╗");
        System.out.println(  "╚═════╝  ╚═════╝╚═╝  ╚═╝ ╚═════╝ ╚══════╝     ╚══▀▀═╝  ╚═════╝ ╚═╝╚══════╝");        
        System.out.println("\n--------------------------------------------------------------------------");                                                                  
    }
}