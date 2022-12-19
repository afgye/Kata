package arabian;

import java.awt.datatransfer.StringSelection;
import java.util.Scanner;
public class CalculatorArabian {
    public static void main(String[] args) {
        Converter converter = new Converter();
        String[] action = {"+", "-", "/", "*"};
        String[] regexActions = {"\\+", "-", "/", "\\*"};
        Scanner scn = new Scanner(System.in);
        System.out.print("Input: ");
        String exp = scn.nextLine();
        int actionIndex=-1;

        for (int i = 0; true;) {
            if(exp.contains(action[i]))
                actionIndex = i;
            break;
        }for (int i = 1; i < action.length;) {
            if (exp.contains(action[i])) {
                actionIndex = i;
                break;
            }
            break;
        }for (int i = 2; i < action.length;) {
            if(exp.contains(action[i]))
                actionIndex = i;
            break;
        }for (int i = 3; true;) {
            if (exp.contains(action[i])) {
                actionIndex = i;
                break;
            }
            break;
        }

        if (actionIndex==-1){
            System.out.println("throws Exception //т.к. строка не является математической операцией");
            return;

        }
        String[] data = exp.split(regexActions[actionIndex]);

        if (converter.isRoman(data[0]) == converter.isRoman(data[1])) {
            int a, b;


            a = Integer.parseInt(data[0]);
            b = Integer.parseInt(data[1]);

            int result;
            switch(action[actionIndex]){
                case "+":
                result = a+b;
                break;
                case "-":
                    result = a-b;
                    break;
                case "*":
                    result = a*b;
                    break;
                default:
                case "/":
                    result = a/b;
                    break;
            }
            System.out.println("Output " +result);
        }else{
            System.out.println("throws Exception //т.к. используются одновременно разные системы счисления");
        }

        }
    }





