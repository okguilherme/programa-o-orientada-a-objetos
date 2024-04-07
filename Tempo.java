import java.util.Scanner;
class Tempo {
    public static void main (String [] args) {
        Relogio relogio = new Relogio(0, 0, 0);
        Scanner scan = new Scanner(System.in);
        
        while (true) {
            String line = scan.nextLine();
            System.out.println("$" + line);
            String [] arg = line.split(" ");
            
            if (arg [0].equals("end")) {
                break;
            }
            else if (arg [0].equals("init")) {
                int num1 = Integer.parseInt(arg [1]);
                int num2 = Integer.parseInt(arg [2]);
                int num3 = Integer.parseInt(arg [3]);
                relogio = new Relogio(num1, num2, num3);
            }
            else if (arg [0].equals("set")) {
                int num1 = Integer.parseInt(arg [1]);
                int num2 = Integer.parseInt(arg [2]);
                int num3 = Integer.parseInt(arg [3]);
                relogio.setHora(num1);
                relogio.setMinuto(num2);
                relogio.setSegundo(num3);
            }
            else if (arg[0].equals("show")) {
                relogio.imprimir();
            }
            else if (arg [0].equals("next")) {
                relogio.nextSegundo();
            }
        }
    }
}
// Eu achei desnecessário o construtor neste exercício
// só o implementei para que se encaixasse na questão.
// Minha maior dificuldade não está sendo o código em si
// mas sim a descrição no Moodle, a forma de explicar a questão está confusa.
// Como sugestão, acho que também poderia ser incluída 
// uma explicação de como fazer a classe Solver.

class Relogio {
    
    private int hora = 0;
    private int minuto = 0;
    private int segundo = 0;
    
    public Relogio (int hora, int minuto, int segundo) {  // init - construtor
        if (hora <= 23) {
            this.hora = hora;
        }
        else {
            System.out.println("fail: hora invalida");
        }
        if (minuto <= 59 ) {
            this.minuto = minuto;
        }
        else {
            System.out.println("fail: minuto invalido");
        }
        if (segundo <= 59) {
            this.segundo = segundo;
        }
        else {
            System.out.println("fail: segundo invalido");
        }
    }
    public void setHora(int hora) {
        if (hora <= 23) {
            this.hora = hora;
        }
        else{
            System.out.println("fail: hora invalida");
        }
    }
    public void setMinuto(int minuto) {
        if (minuto <= 59) {
            this.minuto = minuto;
        }
        else {
            System.out.println("fail: minuto invalido");
        }
    }
    public void setSegundo(int segundo) {
        if (segundo <= 59) {
            this.segundo = segundo;
        }
        else {
            System.out.println("fail: segundo invalido");
        }
    }
    public void imprimir () {
        System.out.printf("%02d:%02d:%02d\n", this.hora, this.minuto, this.segundo);
    }
    public void nextSegundo() {
        this.segundo++;
        if (this.segundo == 60) {
            this.minuto++;
            this.segundo = 0;
            
            if (this.minuto == 60) {
                this.hora++;
                this.minuto = 0;
                
                if (this.hora >= 24) {
                    this.hora = 0;
                }
            }
        }
    }
}
