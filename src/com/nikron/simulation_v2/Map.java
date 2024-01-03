package com.nikron.simulation_v2;

import com.nikron.simulation_v2.entity.Creature;
import com.nikron.simulation_v2.entity.Entity;
import com.nikron.simulation_v2.entity.Point;

import java.util.HashMap;
import java.util.List;

public class Map {
    private java.util.Map<Point, Entity> entityMap;

    public Map(java.util.Map<Point, Entity> entityMap) {
        this.entityMap = entityMap;
    }

    public void addEntity(Point point, Entity entity){
        entityMap.put(point, entity);
    }
    public Entity getEntity(Point point){
        return entityMap.get(point);
    }

    public void removeEntity(Point point){
        entityMap.remove(point);
    }

    public List<Creature> getCreatures(){
        return entityMap.values().stream().filter(x -> x instanceof Creature).map(x -> (Creature) x).toList();
    }
}
