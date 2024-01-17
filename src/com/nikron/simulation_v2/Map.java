package com.nikron.simulation_v2;

import com.nikron.simulation_v2.entity.Creature;
import com.nikron.simulation_v2.entity.Entity;
import com.nikron.simulation_v2.entity.Point;

import java.util.HashMap;
import java.util.List;

public class Map {
    private java.util.Map<Point, Entity> entityMap = new HashMap<>();

    public void addEntity(Point point, Entity entity) {
        entityMap.put(point, entity);
    }

    public Entity getEntity(Point point) {
        return entityMap.get(point);
    }

    public void removeEntity(Point point) {
        entityMap.remove(point);
    }

    public List<Object> getCreatures(Class clazz) {
        return entityMap.values()
                .stream()
                .filter(clazz::isInstance)
                .map(x -> clazz.cast(x)).toList();
    }

    public java.util.Map<Point, Entity> getEntityMap() {
        return entityMap;
    }
}
