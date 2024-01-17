package com.nikron.simulation_v2;

import com.nikron.simulation_v2.entity.Creature;
import com.nikron.simulation_v2.entity.Entity;
import com.nikron.simulation_v2.entity.Point;

import java.util.ArrayList;
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

    public <T> List<T> getCreatures(Class<T> clazz) {
        List<T> objects = new ArrayList<>();
        for (Entity entity : entityMap.values()) {
            if (clazz.isInstance(entity)) {
                objects.add((T) entity);
            }
        }
        return objects;
    }

    public java.util.Map<Point, Entity> getEntityMap() {
        return entityMap;
    }

    public void setEntity(Point point, Entity entity) {
        entity.setPoint(point);
        entityMap.put(point, entity);
    }
}
