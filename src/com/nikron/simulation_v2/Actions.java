package com.nikron.simulation_v2;

import com.nikron.simulation_v2.entity.Creature;
import com.nikron.simulation_v2.entity.Entity;
import com.nikron.simulation_v2.entity.Grass;
import com.nikron.simulation_v2.entity.Herbivore;
import com.nikron.simulation_v2.entity.Point;
import com.nikron.simulation_v2.entity.Predator;
import com.nikron.simulation_v2.entity.Rock;
import com.nikron.simulation_v2.entity.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Actions {
    private int maxX;
    private int maxY;
    private Random random = new Random();
    private com.nikron.simulation_v2.Map map;
    private FindPath findPath;

    public Actions(int maxX, int maxY, com.nikron.simulation_v2.Map map) {
        this.maxX = maxX;
        this.maxY = maxY;
        this.map = map;
        this.findPath = new FindPath(maxX, maxY, map);
    }

    public void initActions() {
        int entityCount = ((int) Math.sqrt(maxX * maxY)) - 2;
        List<Entity> trees = generateEntity(Tree.class, entityCount);
        List<Entity> grasses = generateEntity(Grass.class, entityCount);
        List<Entity> rocks = generateEntity(Rock.class, entityCount);
        List<Entity> herbivores = generateEntity(Herbivore.class, entityCount);
        List<Entity> predators = generateEntity(Predator.class, entityCount + 1);
        List<Entity> fullEntity = new ArrayList<>();
        fullEntity.addAll(trees);
        fullEntity.addAll(grasses);
        fullEntity.addAll(rocks);
        fullEntity.addAll(herbivores);
        fullEntity.addAll(predators);
        for (Entity entity : fullEntity) {
            map.addEntity(entity.getPoint(), entity);
        }
    }

    public void turnActions() {
        for(Object o : map.getCreatures(Herbivore.class)){
            Creature creature = (Creature) o;
            List<Point> path = null;
            for(Object ot : map.getCreatures(Grass.class)){
                Grass grass = (Grass) ot;
                List<Point> tmpPath = getPathToEntity(creature, grass);
                if (path == null || !tmpPath.isEmpty() && tmpPath.size() < path.size()){
                    path = tmpPath;
                }
            }
            System.out.println();
        }
    }

    private List<Entity> generateEntity(Class clazz, int count) {
        List<Entity> genEntity = new ArrayList<>();
        switch (clazz.getSimpleName()) {
            case "Grass" -> {
                for (int i = 0; i < count; i++) {
                    Point tmpPoint = new Point(random.nextInt(maxX + 1), random.nextInt(maxY + 1));
                    while (Objects.nonNull(map.getEntity(tmpPoint))) {
                        tmpPoint = new Point(random.nextInt(maxX + 1), random.nextInt(maxY + 1));
                    }
                    map.addEntity(tmpPoint, new Grass(tmpPoint));
                }
            }
            case "Rock" -> {
                for (int i = 0; i < count; i++) {
                    Point tmpPoint = new Point(random.nextInt(maxX + 1), random.nextInt(maxY + 1));
                    while (Objects.nonNull(map.getEntity(tmpPoint))) {
                        tmpPoint = new Point(random.nextInt(maxX + 1), random.nextInt(maxY + 1));
                    }
                    map.addEntity(tmpPoint, new Rock(tmpPoint));
                }
            }
            case "Tree" -> {
                for (int i = 0; i < count; i++) {
                    Point tmpPoint = new Point(random.nextInt(maxX + 1), random.nextInt(maxY + 1));
                    while (Objects.nonNull(map.getEntity(tmpPoint))) {
                        tmpPoint = new Point(random.nextInt(maxX + 1), random.nextInt(maxY + 1));
                    }
                    map.addEntity(tmpPoint, new Tree(tmpPoint));
                }
            }
            case "Herbivore" -> {
                for (int i = 0; i < count; i++) {
                    Point tmpPoint = new Point(random.nextInt(maxX + 1), random.nextInt(maxY + 1));
                    while (Objects.nonNull(map.getEntity(tmpPoint))) {
                        tmpPoint = new Point(random.nextInt(maxX + 1), random.nextInt(maxY + 1));
                    }
                    map.addEntity(tmpPoint, new Herbivore(tmpPoint, 1, 3));
                }
            }
            case "Predator" -> {
                for (int i = 0; i < count; i++) {
                    Point tmpPoint = new Point(random.nextInt(maxX + 1), random.nextInt(maxY + 1));
                    while (Objects.nonNull(map.getEntity(tmpPoint))) {
                        tmpPoint = new Point(random.nextInt(maxX + 1), random.nextInt(maxY + 1));
                    }
                    map.addEntity(tmpPoint, new Predator(tmpPoint, 1, 2, 1));
                }
            }
        }
        return genEntity;
    }

    private List<Point> getPathToEntity(Entity start, Entity end){
        return findPath.find(start, end);
    }
}
