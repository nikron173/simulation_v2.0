package com.nikron.simulation_v2;

import com.nikron.simulation_v2.entity.Entity;
import com.nikron.simulation_v2.entity.Point;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class FindPath {
    private final int maxX;
    private final int maxY;
    private Map map;

    public FindPath(int maxX, int maxY, Map map) {
        this.maxX = maxX;
        this.maxY = maxY;
        this.map = map;
    }

    public List<Point> find(Entity start, Entity end) {
        Queue<Point> queue = new ArrayDeque<>();
        List<Point> path = new ArrayList<>();
        List<Point> visited = new ArrayList<>();
        TreePoint parent = new TreePoint(start.getPoint());

        queue.add(start.getPoint());
        path.add(start.getPoint());
        visited.add(start.getPoint());
        while (!queue.isEmpty()) {
            Point currentPoint = queue.remove();
            if (currentPoint.equals(end.getPoint())) {
                while (parent != null) {
                    path.add(parent.getValue());
                    parent = parent.getParent();
                }
                Collections.reverse(path);
                return path;
            }
            //Generated new points
            List<Point> generatedPoints = new ArrayList<>();
            generatedPoints.add(new Point(currentPoint.getX() - 1, currentPoint.getY()));
            generatedPoints.add(new Point(currentPoint.getX(), currentPoint.getY() - 1));
            generatedPoints.add(new Point(currentPoint.getX() + 1, currentPoint.getY()));
            generatedPoints.add(new Point(currentPoint.getX(), currentPoint.getY() + 1));
            for (int i = 0; i < generatedPoints.size(); i++) {
                Point tmpPoint = generatedPoints.get(i);
                if (tmpPoint.getX() < 0 || tmpPoint.getY() < 0 ||
                        tmpPoint.getX() >= maxX || tmpPoint.getY() >= maxY ||
                        Objects.nonNull(map.getEntity(tmpPoint))) {
                    generatedPoints.remove(tmpPoint);
                    i--;
                }
            }

            for (Point p : generatedPoints) {
                if (!visited.contains(p)) {
                    visited.add(p);
                    queue.add(p);
                    TreePoint tp = new TreePoint(p);
                    tp.setParent(parent);
                    parent.setChild(tp);
                    parent = tp;
                }
            }
        }
        System.out.println(path);
        return path;
    }
}
