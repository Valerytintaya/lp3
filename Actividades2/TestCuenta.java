import java.util.Scanner;
public class TestCuenta {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Crear cuentas
        Cuenta1[] cuentas = new Cuenta1[4];
        cuentas[0] = new CuentaAhorro("AHO001", 1000, 0.02);
        cuentas[1] = new CuentaCorriente("COR001", 1500);
        cuentas[2] = new CuentaAhorro("AHO002", 2000, 0.03);
        cuentas[3] = new CuentaCorriente("COR002", 2500);

        char opcion;
        do {
            System.out.println("\n--- MENÚ BANCO ---");
            System.out.println("D) Depositar");
            System.out.println("R) Retirar");
            System.out.println("C) Consultar");
            System.out.println("S) Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.next().toUpperCase().charAt(0);

            switch (opcion) {
                case 'D':
                    System.out.print("Ingrese número de cuenta: ");
                    String numDep = sc.next();
                    System.out.print("Monto a depositar: ");
                    double montoDep = sc.nextDouble();
                    for (Cuenta1 c : cuentas) {
                        if (c.getNumeroCuenta().equals(numDep)) {
                            c.depositar(montoDep);
                        }
                    }
                    break;

                case 'R':
                    System.out.print("Ingrese número de cuenta: ");
                    String numRet = sc.next();
                    System.out.print("Monto a retirar: ");
                    double montoRet = sc.nextDouble();
                    for (Cuenta1 c : cuentas) {
                        if (c.getNumeroCuenta().equals(numRet)) {
                            c.retirar(montoRet);
                        }
                    }
                    break;

                case 'C':
                    System.out.println("Consultando todas las cuentas...");
                    for (Cuenta1 c : cuentas) {
                        c.consultar();
                        System.out.println("Cuenta: " + c.getNumeroCuenta() + " | Saldo: " + c.getSaldo());
                    }
                    break;

                case 'S':
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 'S');

        sc.close();
    }
}
