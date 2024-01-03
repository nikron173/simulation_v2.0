package com.nikron.simulation_v2;

import com.nikron.simulation_v2.entity.Entity;
import com.nikron.simulation_v2.entity.Point;

import java.util.Map;

public class Render {
    private java.util.Map<Point, Entity> map;
    private int height;
    private int weight;

    public Render(Map<Point, Entity> map, int height, int weight) {
        this.map = map;
        this.height = height;
        this.weight = weight;
    }

    public void render(){
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < weight; j++) {
                Point point = new Point(j, i);
                if (map.containsKey(point)){
                    System.out.print(map.get(point).toString());
                } else {
                    System.out.print("_");
                }
            }
            System.out.println();
        }
    }
}
