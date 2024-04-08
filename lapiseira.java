import java.text.DecimalFormat;

public class Lead {
    private float thickness; //calibre
    private String hardness; //dureza
    private int size; //tamanho em mm

    public Lead(float thickness, String hardness, int size) {
        this.thickness = thickness;
        this.hardness  = hardness;
        this.size = size;
    }

    public float getThickness() {
        return this.thickness;
    }

    public String getHardness() {
        return this.hardness;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int usagePerSheet() {// retorna o gasto em milímetros para uma página escrita
        switch (hardness) {
            case "HB":
                return 1;
            
            case "2B":
                return 2;
            
            case "4B":
                return 4;
            
            case "6B":
                return 6;
        }
        return 0;
    }

    public String toString() {
        DecimalFormat form = new DecimalFormat("0.0");
        return form.format(thickness) + ":" + hardness + ":" + size;
    }
}







public class Pencil {
    private float thickness;
    private Lead tip;
    
    public Pencil(float thickness) {
        this.thickness = thickness;
        this.tip = null;
    }

    public float getThickness() {
        return this.thickness;
    }

    public void setThickness(float value) {
        this.thickness = value;
    }

    public boolean hasLead() {
        if (this.tip != null) {
            return true;
        }
        else {
        return false;
        }
    }

    /*
    # Lead lead é um parâmetro de método que representa a ponta de grafite que 
    você deseja inserir na lapiseira quando chama o método insert(Lead lead). 
    Este parâmetro lead é uma referência a uma instância da classe Lead que 
    você fornece ao chamar o método insert.
    
    Lead tip é um atributo (ou membro) da classe Pencil que representa a ponta
    de grafite atualmente inserida na lapiseira. Quando você insere uma nova ponta
    de grafite usando o método insert, você está atualizando o valor deste atributo 
    tip para referenciar a nova ponta de grafite que você inseriu.
    
    # uma variável de um tipo de classe armazena
    uma referência a um objeto daquela classe. 
    Essa referência permite que você acesse e manipule o objeto 
    subjacente por meio de métodos e atributos.
    */

    public boolean insert(Lead ponta) { 
        if (hasLead() ) {
            IO.println("fail: ja existe grafite");
            return false;
        }
        if (this.thickness != ponta.getThickness()) {
            IO.println("fail: calibre incompativel");
            return false;
        }
        
        this.tip = ponta;
        return true;
    }

    public Lead remove() {
        Lead tip2 = this.tip;
        if (hasLead()) {
            this.tip = null;
            return tip2;
        }
        return null;
    }

    public void writePage() {
        if (hasLead()) {
            int gasto = tip.usagePerSheet();
            int tamanho = tip.getSize();
            
            if (tamanho <= 10 ) {
                IO.println("fail: tamanho insuficiente");
            }    
            else if (tamanho >= 10 + gasto) {
               tip.setSize(tamanho - gasto);
            }
            else if (tamanho > 10 && tamanho < 10 + gasto) {
                tip.setSize(10);
                IO.println("fail: folha incompleta");
            }
        }
        else {
            IO.println("fail: nao existe grafite");
        }
    }
    
    public String toString() {
        String saida = "calibre: " + thickness + ", grafite: ";
        if (tip != null)
            saida += "[" + tip + "]";
        else
            saida += "null";
        return saida;
    }
}









class Solver {
    public static void main (String[] args) {
        Pencil pencil = new Pencil( (float) 0.0 );

        while (true) {
            String[] line = IO.inputPartsPrintingLine();

            if      ( line[0].equals("end")    )  { break;                                                                               }
            else if ( line[0].equals("show")   )  { IO.println( pencil.toString() );                                                     }
            else if ( line[0].equals("init")   )  { pencil = new Pencil( IO.strToFloat(line[1]) );                                       }
            else if ( line[0].equals("insert") )  { pencil.insert( new Lead( IO.strToFloat(line[1]), line[2], IO.strToInt(line[3]) ) );  }
            else if ( line[0].equals("remove") )  { pencil.remove();                                                                     }
            else if ( line[0].equals("write")  )  { pencil.writePage();                                                                  }
            else                                  { IO.println("fail: comando invalido");                                                }
        }
    }
}









import java.util.Scanner;

class IO {
    //print
    static public void println() {
        System.out.println();
    }
    static public void println(Object str) { //Object para também aceitar int, float, double, ...
        System.out.println(str);
    }
    static public void print(Object str) { //Object para também aceitar int, float, double, ...
        System.out.print(str);
    }
    static public void printf(String str, Object... args) {
        System.out.printf(str, args);
    }

    //input
    static private Scanner scan = new Scanner(System.in);

    static public String input() {
        return scan.nextLine();
    }
    static public int inputInt() {
        return Integer.parseInt( scan.nextLine() );
    }
    static public float inputFloat() {
        return Float.parseFloat( scan.nextLine() );
    }
    static public double inputDouble() {
        return Double.parseDouble( scan.nextLine() );
    }

    //input split
    static public String[] inputParts() {
        return scan.nextLine().split(" ");
    }
    static public String[] inputPartsPrintingLine() {
        String line = IO.input();
        IO.println("$" + line);
        return line.split(" ");
    }

    //conversores
    static public int strToInt( String str ) {
        return Integer.parseInt( str );
    }
    static public float strToFloat( String str ) {
        return Float.parseFloat( str );
    }
    static public double strToDouble( String str ) {
        return Double.parseDouble( str );
    }

    //inputNext (leitura termina ao detectar um espaço) (cuidado ao misturar nextLine com next)
    static public String inputNext() {
        return scan.next();
    }
    static public int inputNextInt() {
        return scan.nextInt();
    }
    static public float inputNextFloat() {
        return scan.nextFloat();
    }
    static public double inputNextDouble() {
        return scan.nextDouble();
    }
}

class Out {
    public void println(String str) {
        System.out.println(str);
    }
    public void print(String str) {
        System.out.print(str);
    }
    public void printf(String str, Object... args) {
        System.out.printf(str, args);
    }
}

class Teste {
    static public Out out = new Out();
}
