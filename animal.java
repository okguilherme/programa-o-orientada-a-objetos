import java.util.Scanner;
class Animal {
    String especie;
    String barulho;
    int idade;
    
    Animal (String especie, String barulho) {
        this.especie = especie;
        this.barulho = barulho;
        this.idade = 0;
    }
    
    public String FazerBarulho() {
        if (idade == 0) {
            return "---";
        }
        
        else if (idade == 4) {
            return "RIP";    
        }
        
        else {
            return barulho;
        }
    }
    
    public void Envelhecer(int nivel) {
        idade += nivel;
        
        if (idade >= 4) {
            System.out.printf("warning: %s morreu\n", especie);    
            idade = 4;
        }
    }
    
    public String imp() {
        String str = (especie + ":" + idade + ":" + barulho);
        return str;
    }
    
}
class Solver {
    public static void main(String [] arg) {
        
        Animal CriarAnimal = new Animal(" ", " ");
        Scanner scan = new Scanner(System.in);
        
        CriarAnimal = new Animal("gato", "miauuu");
        CriarAnimal.Envelhecer(2);
        System.out.println(CriarAnimal.imp());
        }
}
