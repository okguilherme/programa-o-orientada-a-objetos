import java.util.Scanner;
class Calculator {
    int battery;
    int batteryMax;
    float display;
    
    Calculator(int batteryMax) {
        this.batteryMax = batteryMax;
        battery = 0;
        display = 0;
    }
    public void Charge(int value) {
        battery += value;
        if (battery >= batteryMax) {
            battery = batteryMax;
        }
        // if (valeu + battery >= batteryMax) {
        //     battery = batteryMax;
        // }
        // else {
        //     battery += value;
        // }
    }
    public void Sum(int a, int b) {
        if (useBattery()) {
            display = a + b;
        }
    }
    public void Division(int num, int den) {
        if (den == 0) {
            System.out.println("fail: divisao por zero");
            battery--;
            return;
        }

        if (useBattery()){
            display = (float) num / den;
        }
        // if (den == 0) {
        //     System.out.println("fail: divisao por zero");
        //     battery--;
        // }
        // else if (useBattery()){
        //     display = (float) num / den;
        // }
    }
    public boolean useBattery() {
        if (battery <= 0) {
            System.out.println("fail: bateria insuficiente");
            return false;
        }

        battery--;
        return true;
        // if (battery > 0) {
        //     battery--;
        //     return true;
        // }
        // else {
        //     System.out.println("fail: bateria insuficiente");
        //     return false;
        // }
    }
    public String Imprimir() {
        String str = String.format("display = %.2f, battery = %d", display, battery);
        return str;
    }
}
class Solver {
    public static void main (String[] arg) {
        Calculator calculator = new Calculator(0);
        Scanner scan = new Scanner(System.in);
        
        while (true) {
            String line = scan.nextLine();
            System.out.println("$" + line);
            String[] args = line.split(" ");

            if (args[0].equals("end")) {
                break;
            }
            else if (args[0].equals("init")) {
                calculator = new Calculator(Integer.parseInt(args[1]));
            }
            else if (args[0].equals("show")) {
                System.out.println(calculator.Imprimir());
            }
            else if (args[0].equals("charge")) {
                calculator.Charge(Integer.parseInt(args[1]));
            }
            else if (args[0].equals("sum")) {
                int num1 = (Integer.parseInt(args[1]));
                int num2 = (Integer.parseInt(args[2]));
                calculator.Sum(num1, num2);
            }
            else if (args[0].equals("div")) {
                int num1 = (Integer.parseInt(args[1]));
                int num2 = (Integer.parseInt(args[2]));
                calculator.Division(num1, num2);
            }
        }
    }
}
