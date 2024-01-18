package com.nikron.simulation_v2.util;

import com.nikron.simulation_v2.Simulation;

import java.util.Scanner;

public class KeyHandler implements Runnable {
    private final Simulation simulation;

    public KeyHandler(Simulation simulation) {
        this.simulation = simulation;
    }


    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String userInput = "";
        while (true){
            userInput = scanner.nextLine();
            if (userInput.equals("0")){
                simulation.pauseSimulation(false);
            }
            if (userInput.equals("1")){
                simulation.pauseSimulation(true);
            }
        }
    }
}
