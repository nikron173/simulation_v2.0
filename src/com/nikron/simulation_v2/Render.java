package com.nikron.simulation_v2;

import com.nikron.simulation_v2.entity.Entity;
import com.nikron.simulation_v2.entity.Point;

import java.util.Map;

public class Render {
    private java.util.Map<Point, Entity> map;
    private int maxY;
    private int maxX;

    public Render(Map<Point, Entity> map, int maxX, int maxY) {
        this.map = map;
        this.maxY = maxY;
        this.maxX = maxX;
    }

    public void render() {
        for (int i = 0; i < maxY; i++) {
            for (int j = 0; j < maxX; j++) {
                Point point = new Point(j, i);
                if (map.containsKey(point)) {
                    System.out.print(map.get(point).toString());
                } else {
                    System.out.print("_");
                }
            }
            System.out.println();
        }
        System.out.println("==============================================");
    }
}
