package com.nikron.simulation_v2;

import com.nikron.simulation_v2.util.ClearConsole;

public class Simulation {
    private Map map;
    private Actions actions;
    private Render render;
    private int maxX;
    private int maxY;
    private volatile boolean isPause = false;

    public Simulation(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
        this.map = new Map();
        this.actions = new Actions(maxX, maxY, map);
        actions.initActions();
        this.render = new Render(map.getEntityMap(), maxX, maxY);
    }

    public void startSimulation() {
        try {
            int round = 1;
            while (true) {
                while (isPause){
                    Thread.sleep(1000);
                }
                System.out.println("Round " + round);
                nextTurn();
                if (map.isWinHerbivores()) {
                    System.out.println("Win Herbivores");
                    break;
                }
                if (map.isWinPredators()) {
                    System.out.println("Win Predators");
                    break;
                }
                round++;
                Thread.sleep(3000);
//                ClearConsole.clear();
            }
        } catch (InterruptedException e) {
        }
    }

    public void pauseSimulation(boolean state) {
        isPause = state;
    }

    private synchronized void nextTurn() {
        actions.turnActions();
        render.render();
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }
}
