package com.nikron.simulation_v2;

import com.nikron.simulation_v2.util.KeyHandler;

public class Main {
    public static void main(String[] args) {
        Simulation simulation = new Simulation(10,10);
        KeyHandler keyHandler = new KeyHandler(simulation);
        Thread threadKeyHandler = new Thread(keyHandler);
        threadKeyHandler.start();
        simulation.startSimulation();
    }
}
