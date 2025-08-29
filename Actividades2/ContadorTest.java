class Contador{

    static int nContadores = 0;

    static int ultimoContador = 0;
    int valor;
    int acumulador;
    static int VALOR_INICIAL;


    public Contador(int valor) {
        this.valor = valor;
        acumulador += valor;
        nContadores++;                  // aumentar contador de objetos
        ultimoContador = this.valor;    // guardar valor del último creado
    }

    public Contador() {
        this(Contador.VALOR_INICIAL);
    }

   
    public static String acumulador() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'acumulador'");
    }

    public String getValor() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getValor'");
    }
    
};

public class ContadorTest {
    public static void main(String[] args) {
        Contador c1 = new Contador(3);
        Contador c2 = new Contador();
        Contador c3 = new Contador(7);

        System.out.println("Valor de c1: " + c1.getValor());          // 3
        System.out.println("Valor de c2: " + c2.getValor());          // 10
        System.out.println("Valor de c3: " + c3.getValor());          // 7

        System.out.println("Acumulador: " + Contador.acumulador());   // 20
        System.out.println("Número de contadores: " + Contador.nContadores); // 3
        System.out.println("Último contador creado: " + Contador.ultimoContador); // 7
    }
}
