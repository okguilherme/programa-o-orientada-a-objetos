import java.util.Scanner;
class Brinquedo {
    public static void main (String[] args) {
        
        Pet pet = new Pet(20, 20, 20);
        Scanner scan = new Scanner(System.in);
        
        while(true) {
            String line = scan.nextLine();
            System.out.println("$" + line);
            String []arg = line.split(" ");
            
            if (arg[0].equals("end")) {
                break;
            }
            else if (arg[0].equals("init")) {
                int num1 = Integer.parseInt(arg[1]);
                int num2 = Integer.parseInt(arg[2]);
                int num3 = Integer.parseInt(arg[3]);
                pet = new Pet(num1, num2, num3);
            }
            else if (arg[0].equals("play")) {
                pet.play();                
            }
            else if (arg[0].equals("eat")) {
                pet.eat();    
            }
            else if (arg[0].equals("sleep")) {
                pet.sleep();
            }
            else if (arg[0].equals("shower")) {
                pet.shower();
            }
            else if (arg[0].equals("show")) {
                System.out.println(pet.imprimir());
            }
        }
    }
}
class Pet {
    private boolean alive;
    private int clean;
    private int cleanMax;
    private int energy;
    private int energyMax;
    private int hungry;
    private int hungryMax;
    private int age;
    private int diamonds;
    
    public Pet(int energyMax, int saciedadeMax, int limpezaMax) { // init
        this.clean = limpezaMax;
        this.cleanMax = limpezaMax;
        this.energy = energyMax;
        this.energyMax = energyMax;
        this.hungry = saciedadeMax;
        this.hungryMax = saciedadeMax;
        this.age = 0;
        this.diamonds = 0;
        this.alive = true;
    }
    public String imprimir () { // retorna os parâmetros do Pet
        String str = ("E:" + energy + "/" + energyMax + ", S:" +
        hungry + "/" + hungryMax + ", L:" + clean + "/" + cleanMax +
        ", D:" + diamonds + ", I:" + age);
        return str;
    }
    private boolean testAlive() { // verifica se o pet esta vivo
        if (this.alive) {
            return true;
        }
        else {
            System.out.println("fail: pet esta morto");
            return false;
        }
    }
    private void testEstado() { // verifica os atributos 
        if (this.energy <= 0) {
            this.alive = false;
            System.out.println("fail: pet morreu de fraqueza");
            this.energy = 0;
        }
        if (this.clean <= 0) {
            this.alive = false;
            System.out.println("fail: pet morreu de sujeira");
            this.clean = 0;
        }
        if (this.hungry <= 0) {
            this.alive = false;
            System.out.println("fail: pet morreu de fome");
            this.hungry = 0;
        }
    }
    public void eat() {
        if (testAlive()) {
            this.energy -= 1;
            this.clean -= 2;
            this.hungry += 4;
            this.age += 1;
            if (this.hungry > this.hungryMax) {
                this.hungry = this.hungryMax;
            }
        }
    }
    public void play () {
        if (testAlive()) {
            this.energy -= 2;
            this.hungry -= 1;
            this.clean -= 3;
            this.diamonds += 1;
            this.age += 1;
            testEstado();
            }
        }
    public void shower () {
        if (testAlive()) {
            this.energy -= 3;
            this.hungry -= 1;
            this.clean = cleanMax;
            this.age += 2;
        }
    }
    public void sleep () { 
        if (testAlive()) {
            int nturnos = (this.energyMax - this.energy);
            if (this.energyMax-5 >= this.energy) {
                this.energy = this.energyMax;
                this.hungry -= 1;
                this.age += nturnos;
            }
            else {
                System.out.println("fail: nao esta com sono");
            }
        }
    }
}
