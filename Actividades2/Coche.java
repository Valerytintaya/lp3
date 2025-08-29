public class Coche {
    // Atributos
    public String color;
    private int modelo;
    protected String marca, anio;
	protected double precio;
    private int velocidadMaxima;
    private int potenciaMotor;
    private boolean enMarcha;

    // Constructor
    public Coche(int modelo, String m , String a, double p,int velocidadMaxima, int potenciaMotor) {
        this.modelo = modelo;
        this.marca=m;
        this.anio=a;
        this.precio=p;
        this.velocidadMaxima = velocidadMaxima;
        this.potenciaMotor = potenciaMotor;
        this.enMarcha = false; // El coche comienza apagado
        
    }
    
    public Coche() {
    	 this.modelo = 2009;
         this.marca="nissan";
         this.anio="2000";
         this.precio=1000;
         this.velocidadMaxima = 129;
         this.potenciaMotor = 300;
         this.enMarcha = false;
    	
    }
    
    public Coche(int modelo, String m , String a, double p) {
    	this.modelo = modelo;
        this.marca=m;
        this.anio=a;
        this.precio=p;
        this.velocidadMaxima = 129;
        this.potenciaMotor = 1000;
        this.enMarcha = false;
   }

    // Métodos
    public void acelerar() {
        if (enMarcha) {
            System.out.println("El coche " + modelo + " está acelerando.");
        } else {
            System.out.println("Primero enciende el coche.");
        }
    }

    public void frenar() {
        if (enMarcha) {
            System.out.println("El coche " + modelo + " está frenando.");
        } else {
            System.out.println("El coche está apagado, no se puede frenar.");
        }
    }

    public void encender() {
        enMarcha = true;
        System.out.println("El coche " + modelo + " se ha encendido.");
    }

    public void apagar() {
        enMarcha = false;
        System.out.println("El coche " + modelo + " se ha apagado.");
    }
    
    public void setModelo(int nuevo) {
    	modelo=nuevo;
    	System.out.println("modelo cambiado....");
    }
    
    public int getmodelo() {
    	return modelo;
    }
    
    public void descuento(int descuento) {
    	if (modelo<2010) {
    		precio=precio*(100-descuento)/100;
    		System.out.println("descuento....");
    		System.out.println("precio: "+precio);
    		
    	}else {
    	System.out.println("NO hay descuento");
    	}
    }
}