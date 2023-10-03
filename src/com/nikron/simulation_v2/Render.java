package com.nikron.simulation_v2;

import com.nikron.simulation_v2.entity.Coordinates;
import com.nikron.simulation_v2.entity.Entity;

public class Render {
    //for example map 6x8
    public static void renderMap(Map map){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                Entity entity = map.getEntityMap(new Coordinates(j, i));
                if (entity == null){
                    System.out.print("_");
                } else {
                    System.out.print(entity);
                }
            }
            System.out.println();
        }
        System.out.println("=====================================");
    }
}
