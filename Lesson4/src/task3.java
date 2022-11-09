import java.util.*;
import java.util.logging.Logger;

import static java.lang.Character.isDigit;

//Реализовать алгоритм перевода из инфиксной записи в постфиксную для арифметического выражения.
public class task3 {
    public static void main(String[] args) {
        Logger lg = Logger.getAnonymousLogger();
        String infixExample = "20 - 4 * (2 + 6) / 2 ^ 3 + 2".replace(" ", "");
        lg.info("Infix example -> " + infixExample);

        ArrayList<String> operatorContainer = new ArrayList<>();
        operatorContainer.add("^");
        operatorContainer.add("*");
        operatorContainer.add("/");
        operatorContainer.add("+");
        operatorContainer.add("-");

        var postfixExample = infixToPostfix(infixExample, operatorContainer);
        lg.info("Postfix example -> " + postfixExample);
        lg.info("Solution -> " + getSolution(postfixExample));
    }

    public static String infixToPostfix(String infix, ArrayList<String> operators) {
        String[] arrInfix = infix.split("");

        Queue<String> queue = new LinkedList<>();
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < arrInfix.length; i++) {
            if (arrInfix[i].chars().allMatch(Character::isDigit)) {
                StringBuilder temp = new StringBuilder();
                int j = i;
                while (arrInfix[j].chars().allMatch(Character::isDigit)) {
                    temp.append(arrInfix[j]);
                    j++;
                    if (j == arrInfix.length) break;
                }
                i = j - 1;
                queue.add(temp.toString());
            } else if (operators.contains(arrInfix[i])) {
                if (stack.isEmpty() || stack.peek().equals("(")) {
                    stack.push(arrInfix[i]);
                } else {
                    int currentPrior = getPrior(operators.indexOf(arrInfix[i]));
                    int peekPrior = getPrior(operators.indexOf(stack.peek()));
                    if (currentPrior < peekPrior) {
                        stack.push(arrInfix[i]);
                    } else {
                        int stackSize = stack.size();
                        for (int j = 0; j < stackSize; j++) {
                            queue.add(stack.pop());
                            if (stack.isEmpty()) {
                                stack.push(arrInfix[i]);
                                break;
                            } else if (stack.peek().equals("(")) {
                                stack.push(arrInfix[i]);
                                break;
                            }
                            peekPrior = getPrior(operators.indexOf(stack.peek()));
                            if (currentPrior < peekPrior) {
                                stack.push(arrInfix[i]);
                                break;
                            }
                        }
                    }
                }
            } else if (arrInfix[i].equals("(")) {
                stack.push(arrInfix[i]);
            } else if (arrInfix[i].equals(")")) {
                for (int j = 0; j < stack.size(); j++) {
                    queue.add(stack.pop());
                    if (stack.peek().equals("(")) {
                        stack.pop();
                        break;
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
        StringBuilder result = new StringBuilder();
        for (String e : queue) {
            result.append(e).append(" ");
        }
        return result.toString();
    }

    public static int getPrior(int x) {
        if (x == 0) {
            return 0;
        } else if (x == 1 || x == 2) {
            return 1;
        } else return 2;
    }

    public static String getSolution(String example) {
        var arrExample = example.split(" ");
        int result = 0;
        Stack<Integer> stack = new Stack<>();

        for (String s : arrExample) {
            if (isDigit(s.charAt(0))) {
                stack.push(Integer.parseInt(s));
            } else {
                switch (s) {
                    case "+":
                        result = stack.pop() + stack.pop();
                        stack.push(result);
                        break;
                    case "-":
                        result = -stack.pop() + stack.pop();
                        stack.push(result);
                        break;
                    case "*":
                        result = stack.pop() * stack.pop();
                        stack.push(result);
                        break;
                    case "/":
                        try {
                            result = stack.remove(stack.size() - 2) / stack.pop();
                            stack.push(result);
                            break;
                        } catch (ArithmeticException e) {
                            return "Делить на ноль нельзя!";
                        }
                    case "^":
                        int a = stack.remove(stack.size() - 2);
                        int b = stack.pop();
                        result = 1;
                        for (int i = 0; i < b; i++) {
                            result = result * a;
                        }
                        stack.push(result);
                        break;
                    default:
                        break;
                }
            }
        }
        return String.valueOf(stack.pop());
    }
}
