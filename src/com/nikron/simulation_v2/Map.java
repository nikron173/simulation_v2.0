package com.nikron.simulation_v2;

import com.nikron.simulation_v2.entity.Coordinates;
import com.nikron.simulation_v2.entity.Creature;
import com.nikron.simulation_v2.entity.Entity;

import java.util.HashMap;
import java.util.List;

public class Map {
    private java.util.Map<Coordinates, Entity> map = new HashMap<>();

    public java.util.Map<Coordinates, Entity> getMap() {
        return map;
    }

    public void addEntityMap(Coordinates coordinates, Entity entity){
        map.put(coordinates, entity);
    }

    public void removeEntityMap(Coordinates coordinates){
        map.remove(coordinates);
    }

    public Entity getEntityMap(Coordinates coordinates){
        return map.get(coordinates);
    }

    public List<Creature> getAllCreatures(){
        return map.values().stream()
                .filter(entity -> entity instanceof Creature)
                .map(x -> (Creature) x)
                .toList();
    }
}
