package gestor;

import modelo.Cliente;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GestorClientes {
    private List<Cliente> lista = new ArrayList<>();

    public void setLista(List<Cliente> l){ this.lista = new ArrayList<>(l); }
    public List<Cliente> getLista(){ return lista; }


    public List<Map<String,Object>> query(String[] fieldsToShow,
                                          Predicate<Cliente> filter,
                                          Comparator<Cliente> orderBy,
                                          int limit) {
        Stream<Cliente> stream = lista.stream();
        if (filter != null) stream = stream.filter(filter);
        if (orderBy != null) stream = stream.sorted(orderBy);
        if (limit > -1) stream = stream.limit(limit);

        return stream.map(c -> {
            Map<String,Object> row = new LinkedHashMap<>();
            for (String f: fieldsToShow) {
                switch(f) {
                    case "cliente_id": row.put("cliente_id", c.getClienteId()); break;
                    case "nombre": row.put("nombre", c.getNombre()); break;
                    case "telefono": row.put("telefono", c.getTelefono()); break;
                    case "correo": row.put("correo", c.getCorreo()); break;
                    default: row.put(f, null);
                }
            }
            return row;
        }).collect(Collectors.toList());
    }
}
