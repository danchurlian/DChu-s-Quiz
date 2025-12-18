import java.util.*;
public class AlgebraSystem extends Problem {
    private ArrayList<String> equations = new ArrayList<String>();
    private Map<String, Integer> values = new HashMap<String, Integer>();

    public AlgebraSystem(int problemNumber, int difficulty) {
        super(problemNumber, difficulty);

        initVariables();
        initEquations();
    }

    private void initVariables() {
        values.put("w", (int)(Math.random() * 9 + 1));
        values.put("x", (int)(Math.random() * 9 + 1));
        values.put("y", (int)(Math.random() * 9 + 1));
        values.put("z", (int)(Math.random() * 9 + 1));
    }

    private String newTerm(String var, int coef) {
        if (coef == 1)
            return " " +var;
        return coef + var;
    }
    
    private String newEquation(ArrayList<String> varsUsing, boolean showRightSide) {
        // Get random coefficient for each variable.
        String equation = "";
        int rightSideVal = 0;
        for (int i = 0; i < varsUsing.size(); i++) {
            String var = varsUsing.get(i);
            int coef = (int)(Math.random() * 4 + 1);
            rightSideVal += coef * values.get(var);
            
            String term = newTerm(var, coef);
            equation += term;

            if (i == varsUsing.size() - 1)
                equation += " = ";
            else
                equation += " + ";
        }

        if (showRightSide) {
            equation += rightSideVal;
        }
        else {
            equation += "?";
            answer = rightSideVal;
        }

        return equation;
    }

    private void initEquations() {
        String[] allVarsUsed;
        ArrayList<String> varsUsing = new ArrayList<String>();

        switch (difficulty) {
            case 2:
                allVarsUsed = new String[] {"x", "y", "z"};
                break;
            case 3:
                allVarsUsed = new String[] {"w", "x", "y", "z"};
                break;
            default:
                allVarsUsed = new String[] {"x", "y"};
                break;
        }

        for (String var: allVarsUsed) {
            varsUsing.add(var);
            equations.add(newEquation(varsUsing, true));
        }
        equations.add(newEquation(varsUsing, false));
    }

    public void display() {
        System.out.println(problemNumber+ ". What is the value of the \"?\" as shown in the last equation?");
        for (String eqStr: equations) {
            System.out.println(eqStr);
        }

        System.out.print("Answer: ");
    }
}
