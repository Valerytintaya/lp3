package gestor;
import modelo.Vehiculo;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GestorVehiculos {
    private List<Vehiculo> lista = new ArrayList<>();
    public void setLista(List<Vehiculo> l){ this.lista = new ArrayList<>(l); }
    public List<Vehiculo> getLista(){ return lista; }

    public List<Map<String,Object>> query(String[] fieldsToShow,
                                          Predicate<Vehiculo> filter,
                                          Comparator<Vehiculo> orderBy,
                                          int limit) {
        Stream<Vehiculo> stream = lista.stream();
        if (filter != null) stream = stream.filter(filter);
        if (orderBy != null) stream = stream.sorted(orderBy);
        if (limit > -1) stream = stream.limit(limit);

        return stream.map(v -> {
            Map<String,Object> row = new LinkedHashMap<>();
            for (String f: fieldsToShow) {
                switch(f) {
                    case "vehiculo_id": row.put("vehiculo_id", v.getVehiculoId()); break;
                    case "marca": row.put("marca", v.getMarca()); break;
                    case "modelo": row.put("modelo", v.getModelo()); break;
                    case "ano": row.put("ano", v.getAno()); break;
                    case "estado": row.put("estado", v.getEstado()); break;
                    case "id_tipo": row.put("id_tipo", v.getIdTipo()); break;
                    case "num_puertas": row.put("num_puertas", v.getNumPuertas()); break;
                    case "num_asientos": row.put("num_asientos", v.getNumAsientos()); break;
                    case "sucursal_id": row.put("sucursal_id", v.getIdSucursal()); break;
                    default: row.put(f, null);
                }
            }
            return row;
        }).collect(Collectors.toList());
    }
}
