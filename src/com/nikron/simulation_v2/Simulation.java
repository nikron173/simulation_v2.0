package com.nikron.simulation_v2;

public class Simulation {
    private final Actions actions = new Actions();
    private final Map map = new Map();

    public Simulation(){
        actions.initActions(map);
        Render.renderMap(map);
    }

    private void nextTurn(){
        actions.turnActions(map);
    }

    public void startSimulation(){
        int i = 0;
        while (i != 5){
            i++;
            nextTurn();
            Render.renderMap(map);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        simulation.startSimulation();
    }
}
