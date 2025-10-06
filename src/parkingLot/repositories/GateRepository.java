package parkingLot.repositories;

import parkingLot.models.Gate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.ToLongFunction;

public class GateRepository {
    private Map<Long,Gate>gates = new HashMap<>();

    public Optional<Gate> getGateById(Long gateId){
        return Optional.of(gates.get(gateId));
    }
}
