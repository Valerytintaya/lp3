public class Main {
	public static void main(String[] args) {
		Coche obj1 = new Coche(2013,"CX-5","1990",100, 
        180, 40);
		Coche obj2 = new Coche(2014,"CX-5","1990",100);
		Coche obj3 = new Coche();
		obj1.encender();
		obj1.acelerar();
		obj1.frenar();
		obj1.apagar();
		///////////////////////////////
		int nuevo=obj1.getmodelo();
		System.out.println("El modelo :"+nuevo);
		
		obj1.setModelo(2010);
		nuevo=obj1.getmodelo();
		System.out.println("El modelo :"+nuevo);
		
		obj3.descuento(20);
	}
}

