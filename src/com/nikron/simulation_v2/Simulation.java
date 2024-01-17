package com.nikron.simulation_v2;

public class Simulation {
    private Map map;
    private Actions actions;
    private Render render;
    private int maxX;
    private int maxY;

    public Simulation(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
        this.map = new Map();
        this.actions = new Actions(maxX, maxY, map);
        actions.initActions();
        this.render = new Render(map.getEntityMap(), maxX, maxY);
    }

    public void startSimulation(){
        try {
            while (true){
                nextTurn();
                Thread.sleep(5000);
            }
        } catch (InterruptedException e){
            System.out.println(e);
        }
    }

    public void pauseSimulation(){

    }

    private void nextTurn(){
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
