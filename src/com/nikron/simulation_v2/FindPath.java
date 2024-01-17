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

        queue.add(start.getPoint());
        visited.add(start.getPoint());
        Point[] parent = new Point[maxX * maxY];
        parent[start.getPoint().getX() * maxY + start.getPoint().getY()] = null;

        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();
            if (currentPoint.equals(end.getPoint())) {
                Point p = end.getPoint();
                while (p != null) {
                    path.add(p);
                    p = parent[p.getX() * maxY + p.getY()];
                }
                Collections.reverse(path);
                return path;
            }
            List<Point> generatedPoints = new ArrayList<>();
            generatedPoints.add(new Point(currentPoint.getX() - 1, currentPoint.getY()));
            generatedPoints.add(new Point(currentPoint.getX(), currentPoint.getY() - 1));
            generatedPoints.add(new Point(currentPoint.getX() + 1, currentPoint.getY()));
            generatedPoints.add(new Point(currentPoint.getX(), currentPoint.getY() + 1));
            for (int i = 0; i < generatedPoints.size(); i++) {
                Point tmpPoint = generatedPoints.get(i);
                if (tmpPoint.getX() < 0 || tmpPoint.getY() < 0 ||
                        tmpPoint.getX() >= maxX || tmpPoint.getY() >= maxY ||
                        (Objects.nonNull(map.getEntity(tmpPoint)) && !tmpPoint.equals(end.getPoint()))) {
                    generatedPoints.remove(tmpPoint);
                    i--;
                }
            }

            for (Point p : generatedPoints) {
                if (!visited.contains(p)) {
                    visited.add(p);
                    queue.add(p);
                    parent[p.getX() * maxY + p.getY()] = currentPoint;
                }
            }
        }
        return path;
    }
}
