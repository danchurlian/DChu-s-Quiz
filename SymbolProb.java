import java.util.HashMap;
import java.util.ArrayList;

public class SymbolProb extends Problem{
    private HashMap<Character, Integer> values = new HashMap<Character, Integer>();
    private String order = "";
    private String answer = "";

    public SymbolProb(int problemNumber, int difficulty) {
        super(problemNumber, difficulty);

        ArrayList<Character> symbols = getAvailableSymbols();
        ArrayList<Integer> nums = getAvailableNumbers();

        while (symbols.size() > 0) {
            int ranSymbolIndex = (int)(Math.random() * symbols.size());
            int ranNumberIndex = (int)(Math.random() * nums.size());
            values.put(symbols.remove(ranSymbolIndex), nums.remove(ranNumberIndex));
        }

        setOrder();
        setAnswer();
    }

    private void setOrder() {
        int numDigits = 3;
        switch (difficulty) {
            case 2:
                numDigits = 5;
                break;
            case 3:
                numDigits = 10;
                break;
            default:
                break;
        }

        ArrayList<Character> symbols = getAvailableSymbols();
        for (int i = 0; i < numDigits; i++) {
            int random = (int)(Math.random() * symbols.size());
            char chosenSymbol = symbols.remove(random);
            order += chosenSymbol;
        }
    }

    private void setAnswer() {
        for (char sym: order.toCharArray()) {
            int value = values.get(sym);
            answer += value;
        }
    }

    private static ArrayList<Character> getAvailableSymbols() {
        ArrayList<Character> availableSymbols = new ArrayList<Character>();
        availableSymbols.add('?');
        availableSymbols.add('!');
        availableSymbols.add('@');
        availableSymbols.add('#');
        availableSymbols.add('$');
        availableSymbols.add('%');
        availableSymbols.add('^');
        availableSymbols.add('&');
        availableSymbols.add('*');
        availableSymbols.add('+');
        return availableSymbols;
    }

    private static ArrayList<Integer> getAvailableNumbers() {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (int i = 0; i <= 9; i++)
            nums.add(i);
        return nums;
    }

    public void display() {
        System.out.println(problemNumber+ ". In the table below, each symbol represents a digit from 0 to 9: \n");

        for (HashMap.Entry<Character, Integer> entry: values.entrySet()) {
            System.out.println(entry.getKey()+ " = " +entry.getValue());
        }
        
        System.out.println("\nHere is the encoded digit: " +order);
        System.out.print("What is the decoded number? ");
    }

    @Override
    public boolean checkIfCorrect(String input) {
        return input.equals(answer);
    }
}
