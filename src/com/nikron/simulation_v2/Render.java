package com.nikron.simulation_v2;

import com.nikron.simulation_v2.entity.Entity;
import com.nikron.simulation_v2.entity.Point;

import java.util.Map;

public class Render {
    private static final String ANSI_RESET_COLOR = "\u001b[0m";
    private static final String ANSI_COW = "\ud83d\udc2e";
    private static final String ANSI_WOLF = "\ud83d\udc3a";
    private static final String ANSI_GRASS = "\ud83c\udf40";
    private static final String ANSI_ROCK = "\ud83e\udea8";
    private static final String ANSI_TREE = "\ud83c\udf34";
    private static final String ANSI_EMPTY = "\u25ab\ufe0f";
    private static final String ANSI_BACKGROUND = "\033[48;2;250;250;250m"; // grey

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
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < maxX; j++) {
                Point point = new Point(j, i);
                if (map.containsKey(point)) {
                    line.append(setSprite(map.get(point)));
                } else {
                    line.append(setEmptySprite());
                }
            }
            line.append(ANSI_RESET_COLOR);
            System.out.println(line + ANSI_RESET_COLOR);
        }
        System.out.println("Pause - enter 1");
        System.out.println("Continue - enter 0");
    }

    private String setEmptySprite() {
        return ANSI_BACKGROUND + ANSI_EMPTY;
    }

    private String setSprite(Entity entity) {
        switch (entity.getClass().getSimpleName()) {
            case "Herbivore" -> {
                return ANSI_BACKGROUND + ANSI_COW;
            }
            case "Predator" -> {
                return ANSI_BACKGROUND + ANSI_WOLF;
            }
            case "Grass" -> {
                return ANSI_BACKGROUND + ANSI_GRASS;
            }
            case "Rock" -> {
                return ANSI_BACKGROUND + ANSI_ROCK;
            }
            case "Tree" -> {
                return ANSI_BACKGROUND + ANSI_TREE;
            }
            default -> {
                return "";
            }
        }
    }
}
