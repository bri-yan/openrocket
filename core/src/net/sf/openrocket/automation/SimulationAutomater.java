package net.sf.openrocket.automation;

import net.sf.openrocket.document.Simulation;
import net.sf.openrocket.simulation.FlightData;
import net.sf.openrocket.simulation.exception.SimulationException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SimulationAutomater {
    private final HashMap<Double, List<Simulation>> data = new HashMap<>();
    private final Simulation simulation;

    public SimulationAutomater(Simulation simulation) {
        this.simulation = simulation.copy();
    }

    public void adjustBlank(double start, double end, double increment) throws SimulationException {
        for (double i = start; i < end; i += increment) {
            //TODO: figure out how to adjust simulation from start to end adding by increment
            simulation.simulate(); // simulate with adjusted conditions

            FlightData result = this.simulation.getSimulatedData(); // get flight data
            if (data.get(result.getMaxAltitude()) == null) {
                ArrayList<Simulation> sims = new ArrayList<>();
                sims.add(simulation.copy());
                data.put(result.getMaxAltitude(), sims);
            } else {
                data.get(result.getMaxAltitude()).add(simulation.copy())
            }
        }


    }
}
