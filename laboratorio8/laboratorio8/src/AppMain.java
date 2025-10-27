import dao.ClienteDAO;
import dao.VehiculoDAO;
import gestor.GestorClientes;
import gestor.GestorVehiculos;
import modelo.Cliente;
import modelo.Vehiculo;

import java.util.*;
import java.util.function.Predicate;
import java.sql.SQLException;
import java.util.Comparator;

public class AppMain {
    private static final String ADMIN_KEY = "1234"; 
    private static Scanner sc = new Scanner(System.in);
    private static ClienteDAO clienteDAO = new ClienteDAO();
    private static VehiculoDAO vehDAO = new VehiculoDAO();
    private static GestorClientes gestorClientes = new GestorClientes();
    private static GestorVehiculos gestorVehiculos = new GestorVehiculos();

    public static void main(String[] args) throws Exception {
        gestorClientes.setLista(clienteDAO.findAll());
        gestorVehiculos.setLista(vehDAO.findAll());

        while(true) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Gestión Clientes (CRUD)");
            System.out.println("2. Gestión Vehículos (CRUD)");
            System.out.println("0. SALIR");
            System.out.print("Opción: ");
            String opt = sc.nextLine();
            switch(opt) {
                case "1": menuClientes(); break;
                case "2": menuVehiculos(); break;
                case "0": System.out.println("Saliendo..."); return;
                default: System.out.println("Opción inválida.");
            }
        }
    }

    private static boolean confirmarCambio() {
        System.out.print("Ingrese la clave para confirmar: ");
        String k = sc.nextLine();
        boolean ok = ADMIN_KEY.equals(k);
        if (!ok) System.out.println("Clave incorrecta. Operación cancelada.");
        return ok;
    }

    private static void menuClientes() {
        try {
            while(true) {
                System.out.println("\n-- Clientes --");
                System.out.println("1. Listar todos");
                System.out.println("2. Crear cliente");
                System.out.println("3. Actualizar cliente");
                System.out.println("4. Eliminar cliente");
                System.out.println("5. Consultar en memoria (gestor)");
                System.out.println("0. Volver");
                System.out.print("Opción: ");
                String op = sc.nextLine();
                if ("0".equals(op)) break;
                switch(op) {
                    case "1":
                        List<Cliente> all = clienteDAO.findAll();
                        all.forEach(System.out::println);
                        break;
                    case "2":
                        System.out.print("Nombre: "); String nombre = sc.nextLine();
                        System.out.print("Tel: "); String tel = sc.nextLine();
                        System.out.print("Correo: "); String correo = sc.nextLine();
                        Cliente nuevo = new Cliente(nombre,tel,correo);
                        if (confirmarCambio()) {
                            int id = clienteDAO.create(nuevo);
                            System.out.println("Creado con ID: "+id);
                            gestorClientes.setLista(clienteDAO.findAll());
                        }
                        break;
                    case "3":
                        System.out.print("ID cliente a actualizar: ");
                        int idUp = Integer.parseInt(sc.nextLine());
                        Cliente c = clienteDAO.findById(idUp);
                        if (c==null) { System.out.println("No existe."); break; }
                        System.out.print("Nuevo nombre ("+c.getNombre()+"): "); String n2 = sc.nextLine();
                        if (!n2.trim().isEmpty()) c.setNombre(n2);
                        System.out.print("Nuevo tel ("+c.getTelefono()+"): "); String t2 = sc.nextLine();
                        if (!t2.trim().isEmpty()) c.setTelefono(t2);
                        System.out.print("Nuevo correo ("+c.getCorreo()+"): "); String co2 = sc.nextLine();
                        if (!co2.trim().isEmpty()) c.setCorreo(co2);
                        if (confirmarCambio()) {
                            if (clienteDAO.update(c)) {
                                System.out.println("Actualizado.");
                                gestorClientes.setLista(clienteDAO.findAll());
                            }
                        }
                        break;
                    case "4":
                        System.out.print("ID cliente a eliminar: "); int idDel = Integer.parseInt(sc.nextLine());
                        if (confirmarCambio()) {
                            if (clienteDAO.delete(idDel)) {
                                System.out.println("Eliminado.");
                                gestorClientes.setLista(clienteDAO.findAll());
                            } else System.out.println("No eliminado.");
                        }
                        break;
                    case "5":
                        // Demo: pedir campos, filtro y orden simple
                        System.out.print("Campos a mostrar (coma separados, opciones: cliente_id,nombre,telefono,correo): ");
                        String[] campos = sc.nextLine().split(",");
                        System.out.print("Filtro por nombre contiene (dejar vacío = ninguno): ");
                        String filtro = sc.nextLine();
                        Predicate<Cliente> pred = filtro.trim().isEmpty() ? null : c1 -> c1.getNombre().toLowerCase().contains(filtro.toLowerCase());
                        System.out.print("Ordenar por nombre asc/desc (asc/desc/ninguno): ");
                        String ord = sc.nextLine();
                        Comparator<Cliente> cmp = null;
                        if ("asc".equalsIgnoreCase(ord)) cmp = Comparator.comparing(Cliente::getNombre);
                        else if ("desc".equalsIgnoreCase(ord)) cmp = Comparator.comparing(Cliente::getNombre).reversed();
                        System.out.print("Límite (-1 sin límite): "); int lim = Integer.parseInt(sc.nextLine());
                        List<Map<String,Object>> res = gestorClientes.query(campos, pred, cmp, lim);
                        res.forEach(row -> System.out.println(row));
                        break;
                    default: System.out.println("Opción inválida.");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static void menuVehiculos() {
        try {
            while(true) {
                System.out.println("\n-- Vehículos --");
                System.out.println("1. Listar todos");
                System.out.println("2. Crear vehículo");
                System.out.println("3. Actualizar vehículo");
                System.out.println("4. Eliminar vehículo");
                System.out.println("5. Consultar en memoria (gestor)");
                System.out.println("0. Volver");
                System.out.print("Opción: ");
                String op = sc.nextLine();
                if ("0".equals(op)) break;
                switch(op) {
                    case "1":
                        vehDAO.findAll().forEach(System.out::println);
                        break;
                    case "2":
                        System.out.print("Marca: "); String marca = sc.nextLine();
                        System.out.print("Modelo: "); String modelo = sc.nextLine();
                        System.out.print("Año: "); int ano = Integer.parseInt(sc.nextLine());
                        System.out.print("Estado (1 disp,0 no): "); int est = Integer.parseInt(sc.nextLine());
                        System.out.print("id_tipo: "); int t = Integer.parseInt(sc.nextLine());
                        System.out.print("num_puertas: "); int pu = Integer.parseInt(sc.nextLine());
                        System.out.print("num_asientos: "); int as = Integer.parseInt(sc.nextLine());
                        System.out.print("sucursal_id: "); int suc = Integer.parseInt(sc.nextLine());
                        Vehiculo vNuevo = new Vehiculo(marca,modelo,ano,est,t,pu,as,suc);
                        if (confirmarCambio()) {
                            vehDAO.create(vNuevo);
                            gestorVehiculos.setLista(vehDAO.findAll());
                            System.out.println("Vehículo creado.");
                        }
                        break;
                    case "3":
                        System.out.print("ID vehículo a actualizar: ");
                        int idUp = Integer.parseInt(sc.nextLine());
                        Vehiculo v = vehDAO.findById(idUp);
                        if (v==null) { System.out.println("No existe."); break; }
                        System.out.print("Marca ("+v.getMarca()+"): "); String m2 = sc.nextLine();
                        if (!m2.trim().isEmpty()) v = new Vehiculo(v.getVehiculoId(), m2, v.getModelo(), v.getAno(), v.getEstado(), v.getIdTipo(), v.getNumPuertas(), v.getNumAsientos(), v.getIdSucursal());
                        // (para acortar se deja una actualización mínima)
                        if (confirmarCambio()) {
                            if (vehDAO.update(v)) {
                                System.out.println("Vehículo actualizado.");
                                gestorVehiculos.setLista(vehDAO.findAll());
                            }
                        }
                        break;
                    case "4":
                        System.out.print("ID vehículo a eliminar: ");
                        int idDel = Integer.parseInt(sc.nextLine());
                        if (confirmarCambio()) {
                            if (vehDAO.delete(idDel)) {
                                System.out.println("Eliminado.");
                                gestorVehiculos.setLista(vehDAO.findAll());
                            } else System.out.println("No eliminado.");
                        }
                        break;
                    case "5":
                        System.out.print("Campos a mostrar (vehiculo_id,marca,modelo,ano,estado,id_tipo,num_puertas,num_asientos,sucursal_id): ");
                        String[] campos = sc.nextLine().split(",");
                        System.out.print("Filtro por marca contiene (vacío ninguno): ");
                        String filt = sc.nextLine();
                        Predicate<Vehiculo> pred = filt.trim().isEmpty() ? null : v2 -> v2.getMarca().toLowerCase().contains(filt.toLowerCase());
                        System.out.print("Orden name asc/desc/ninguno: ");
                        String ord = sc.nextLine();
                        Comparator<Vehiculo> cmp = null;
                        if ("asc".equalsIgnoreCase(ord)) cmp = Comparator.comparing(Vehiculo::getMarca);
                        else if ("desc".equalsIgnoreCase(ord)) cmp = Comparator.comparing(Vehiculo::getMarca).reversed();
                        System.out.print("Límite (-1 sin límite): "); int lim = Integer.parseInt(sc.nextLine());
                        List<Map<String,Object>> res = gestorVehiculos.query(campos, pred, cmp, lim);
                        res.forEach(System.out::println);
                        break;
                    default: System.out.println("Opción inválida.");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
