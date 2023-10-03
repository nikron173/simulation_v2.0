package com.nikron.simulation_v2;

import com.nikron.simulation_v2.entity.Coordinates;
import com.nikron.simulation_v2.entity.Entity;

import java.util.*;

public class AStarAlgo {
    private int x; //Координата x узла на карте
    private int y; //Координата y узла на карте
    private double g; //Расстояние от начального узла до текущего узла
    private double h; //Примерное расстояние от текущего узла до конечного узла
    private double f; //Сумма g и h
    private AStarAlgo parent; //Родительский узел, используется для восстановления пути

    public AStarAlgo(int x, int y){
        this.x = x;
        this.y = y;
    }

    public static Comparator<AStarAlgo> idComparator = Comparator.comparingDouble(AStarAlgo1 -> AStarAlgo1.f);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AStarAlgo AStarAlgo = (AStarAlgo) o;
        return x == AStarAlgo.x && y == AStarAlgo.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    //реализация алгоритма a*
    //T start - точка, откуда будет происходить движение
    //T end - конечная точка
    //List<Entity> entities - список всех объектов
    //Алгоритм возвращает список координатов, по которому надо будет пройтись до конечной точки
    public static <T> List<Coordinates> aStar(T start, T end, HashMap<Coordinates, Entity> map){
        AStarAlgo startAStarAlgo = null;
        AStarAlgo endAStarAlgo = null;

        if (start instanceof Coordinates && end instanceof Coordinates) {
            Coordinates st =  (Coordinates) start;
            startAStarAlgo = new AStarAlgo(st.getX(), st.getY());
            Coordinates ed = (Coordinates) end;
            endAStarAlgo = new AStarAlgo(ed.getX(), ed.getY());
        }

        Queue<AStarAlgo> queue = new PriorityQueue<>(idComparator);
        queue.add(startAStarAlgo);
        Set<AStarAlgo> closedAStarAlgo = new HashSet<>();

        while (!queue.isEmpty()){
            AStarAlgo currentAStarAlgo = queue.poll();

            if (currentAStarAlgo.equals(endAStarAlgo)) {
                List<Coordinates> path = new ArrayList<>();
                while (currentAStarAlgo != null) {
                    path.add(new Coordinates(currentAStarAlgo.x, currentAStarAlgo.y));
                    currentAStarAlgo = currentAStarAlgo.parent;
                }
                //удаление из пути точки старта - то есть координаты start
                path.remove(path.size()-1);
                return path;
            }

            closedAStarAlgo.add(currentAStarAlgo);
            List<AStarAlgo> neighbors = new ArrayList<>();
            for (int dx = -1; dx < 2; dx++) {
                for (int dy = -1; dy < 2; dy++) {
                    if (dx == 0 && dy == 0) continue;
                    int x = currentAStarAlgo.x + dx;
                    int y = currentAStarAlgo.y + dy;
                    // проверка выхода за границы сетки
                    // для примера пока задано 6х8
                    if (x < 0 || x >= 8 || y < 0 || y >= 6) continue;
                    //все является препятствием
                    if (map.get(new Coordinates(x, y)) != null) continue;

                    neighbors.add(new AStarAlgo(x, y));
                }
            }

            for(AStarAlgo neighbor : neighbors){
                if (closedAStarAlgo.contains(neighbor)) continue;

                double new_g = currentAStarAlgo.g + Math.sqrt(Math.pow((neighbor.x - currentAStarAlgo.x), 2) + Math.pow((neighbor.y - currentAStarAlgo.y), 2));

                if (queue.contains(neighbor)){
                    if (new_g < neighbor.g){
                        neighbor.g = new_g;
                        neighbor.h = Math.sqrt(Math.pow((endAStarAlgo.x - neighbor.x), 2) + Math.pow((endAStarAlgo.y - neighbor.y), 2));
                        neighbor.f = neighbor.g + neighbor.h;
                        neighbor.parent = currentAStarAlgo;
                    }
                } else {
                    neighbor.g = new_g;
                    neighbor.h = Math.sqrt(Math.pow((endAStarAlgo.x - neighbor.x), 2) + Math.pow((endAStarAlgo.y - neighbor.y), 2));
                    neighbor.f = neighbor.g + neighbor.h;
                    neighbor.parent = currentAStarAlgo;
                    queue.add(neighbor);
                }
            }
        }
        return null;
    }
}