package Actividad;
import java.util.Random;


interface Arma {
 String getType();
 int getBaseDamage();
 int calcularDaño(int level);
}

interface Critico {
 int dañoCritico(int damage);
}

interface Elemental {
 String getElemento();
 int bonusElemental();
}


class Espada implements Arma, Critico {
 private int baseDamage;
 private double critChance = 0.2; 

 public Espada(int baseDamage) {
     this.baseDamage = baseDamage;
 }

 @Override
 public String getType() { return "Espada"; }

 @Override
 public int getBaseDamage() { return baseDamage; }

 @Override
 public int calcularDaño(int level) {
     return baseDamage + (level * 5);
 }

 @Override
 public int dañoCritico(int damage) {
     Random rand = new Random();
     if (rand.nextDouble() < critChance) {
         System.out.println("¡Golpe crítico con Espada!");
         return damage * 2;
     }
     return damage;
 }
}


class Arco implements Arma {
 private int baseDamage;

 public Arco(int baseDamage) { this.baseDamage = baseDamage; }

 @Override
 public String getType() { return "Arco"; }

 @Override
 public int getBaseDamage() { return baseDamage; }

 @Override
 public int calcularDaño(int level) {
     return baseDamage + (level * 3);
 }
}

//Hacha con crítico más alto
class Hacha implements Arma, Critico {
 private int baseDamage;
 private double critChance = 0.3; // 30% crítico

 public Hacha(int baseDamage) { this.baseDamage = baseDamage; }

 @Override
 public String getType() { return "Hacha"; }

 @Override
 public int getBaseDamage() { return baseDamage; }

 @Override
 public int calcularDaño(int level) {
     return baseDamage + (level * 4);
 }

 @Override
 public int dañoCritico(int damage) {
     Random rand = new Random();
     if (rand.nextDouble() < critChance) {
         System.out.println("¡Golpe crítico con Hacha!");
         return damage * 2;
     }
     return damage;
 }
}

class EspadaFuego extends Espada implements Elemental {
 public EspadaFuego(int baseDamage) {
     super(baseDamage);
 }

 @Override
 public String getElemento() { return "Fuego"; }

 @Override
 public int bonusElemental() { return 15; }

 @Override
 public int calcularDaño(int level) {
     return super.calcularDaño(level) + bonusElemental();
 }
}


class Personaje {
 private String nombre;
 private int vida;
 private int nivel;
 private Arma arma;

 public Personaje(String nombre, int vida, int nivel, Arma arma) {
     this.nombre = nombre;
     this.vida = vida;
     this.nivel = nivel;
     this.arma = arma;
 }

 public String getNombre() { return nombre; }
 public boolean estaVivo() { return vida > 0; }

 public void atacar(Personaje enemigo) {
     int daño = arma.calcularDaño(nivel);

     if (arma instanceof Critico) {
         daño = ((Critico) arma).dañoCritico(daño);
     }

     enemigo.recibirDaño(daño);
     System.out.println(nombre + " ataca con " + arma.getType() + " causando " + daño + " de daño a " + enemigo.getNombre());
 }

 public void recibirDaño(int daño) {
     vida -= daño;
     if (vida < 0) vida = 0;
     System.out.println(nombre + " ahora tiene " + vida + " de vida.");
 }
}


