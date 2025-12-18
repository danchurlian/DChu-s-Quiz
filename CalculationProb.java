public class CalculationProb extends Problem {
    private int num1;
    private int num2;
    private char operator;

    public CalculationProb(int problemNumber, int difficulty) {
        super(problemNumber, difficulty);
        this.operator = getRandomOperator();
        setRandomNumbers();
    }

    private char getRandomOperator() {
        char[] list = {'+', '-', 'x', '/'};
        int ranIndex = (int)(Math.random() * 4);
        return list[ranIndex];
    }

    private void setRandomNumbers() {
        num1 = (int)(Math.random() * 9 + 1);
        num2 = (int)(Math.random() * 9 + 1);

        switch (operator) {
            case '+':
                answer = num1 + num2;
                break;
            case '-':
                answer = num1 - num2;
                break;
            case 'x':
                answer = num1 * num2;
                break;
            case '/':
                num1 *= num2;
                answer = num1 / num2;
                break;
            default:
                answer = num1;
                break;
        }
    }

    public void display() {
        System.out.print(problemNumber+ ". " +num1+ " " +operator+ " " +num2+ " = ");
    }
}
