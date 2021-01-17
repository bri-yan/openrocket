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
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>
#define ROOTC 30
#define minHeight 29500
#define maxHeight 37000
int main() {
	double lowerTip = 0.0;
	double upperTip = 0.0;
	double lowerHeight = 0.0;
	double upperHeight = 0.0;
	double lowerSweep = 0.0;
	double upperSweep = 0.0;
	double maxApogee = 0.0;
	double Apogee = 0.0;
	double stabOffLaunch = 0.0;
	double stabOffSep = 0.0;
	while (lowerTip <= 20) {
		while (upperTip <= 20) {
			while (lowerHeight <= 20) {
				while(upperHeight <= 20) {
					while (lowerSweep <= 20) {
						while (upperSweep <= 20) {
							if (stabOffLaunch < 1.6 && stabOffSep >= 2.25) { //stability right after stage sep should be greater than or equal 2.25
								if (upperTip + upperSweep >= ROOTC || lowerTip + lowerSweep >= ROOTC) { //maintain proper fin orientation
									upperTip += 0.1;
								}
								else {
									break;
								}
								if (Apogee > maxApogee)
									if(Apogee > minHeight && Apogee < maxHeight)
									maxApogee = Apogee;
							}
						}
						upperSweep += 0.1;
					}
					lowerSweep += 0.1;
				}
				upperHeight += 0.1;
			}
			lowerHeight += 0.1;
		}
		upperTip += 0.1;
	}
	lowerTip += 0.1;
} 
