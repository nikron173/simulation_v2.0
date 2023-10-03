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
        int step = 0;
        while (true){
            step++;
            nextTurn();
            Render.renderMap(map);
            if (actions.checkWinHerbivore(map)){
                System.out.println("Win Herbivores. Done step: " + step);
                break;
            } else if (actions.checkWinPredator(map)) {
                System.out.println("Win Predators. Done step: " + step);
                break;
            }
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
