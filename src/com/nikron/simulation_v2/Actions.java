package com.nikron.simulation_v2;

import com.nikron.simulation_v2.entity.*;

import java.util.Random;

public class Actions {
    private final Random random = new Random();
    //for example map 6x8
    public void initActions(Map map){
        generatedEntity(map, Grass.class);
        generatedEntity(map, Rock.class);
        generatedEntity(map, Tree.class);
        generatedEntity(map, Herbivore.class);
        generatedEntity(map, Predator.class);
    }

    public void turnActions(Map map){
        for (var entry : map.getMap().entrySet()) {
            if (entry.getValue() instanceof Creature){
                ((Creature) entry.getValue()).makeMove();
            }
        }
        if (!checkIsResource(map)){
            addResourceObject(map);
        }
    }

    //check static resource for Herbivore
    private boolean checkIsResource(Map map){
        return map.getMap().values().stream().anyMatch(Entity::isResourceObject);
    }

    //add static resource for Herbivore
    private void addResourceObject(Map map){
        map.addEntityMap(new Coordinates(1,1),
                new Grass(true, true, new Coordinates(1,1)));
    }

    private void generatedEntity(Map map, Class<?> clazz){
        for (int i = 0; i < 5;) {
            Coordinates coordinates = new Coordinates(random.nextInt(8), random.nextInt(6));
            if (map.getEntityMap(coordinates) == null){
                switch (clazz.getSimpleName()) {
                    case "Rock" -> map.addEntityMap(coordinates, new Rock(true, false, coordinates));
                    case "Grass" -> map.addEntityMap(coordinates, new Grass(true, true, coordinates));
                    case "Tree" -> map.addEntityMap(coordinates, new Tree(true, false, coordinates));
                    case "Herbivore" -> map.addEntityMap(coordinates, new Herbivore(false, false,
                            coordinates, 5, 1, 0, true));
                    case "Predator" -> map.addEntityMap(coordinates, new Predator(false, false,
                            coordinates, 5, 1, 1, false));
                }
                i++;
            }
        }
    }
}
