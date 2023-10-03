package com.nikron.simulation_v2.entity;

import java.util.List;

public class Herbivore extends Creature {

    public Herbivore(boolean isStaticObject, boolean isResourceObject, Coordinates coordinates,
                     int heath, int speed, int attack, boolean isResourceForHunter) {
        super(isStaticObject, isResourceObject, coordinates, heath, speed, attack, isResourceForHunter);
    }

    @Override
    public void makeMove(com.nikron.simulation_v2.Map map) {
        List<Coordinates> listMove = getShortListMovesCoordinates(getCoordinates(),
                map.getAllGrass().stream().map(Entity::getCoordinates).toList(), map.getMap());
        if (listMove == null) return;
        if (getSpeed() < listMove.size()){
            map.removeEntityMap(this.getCoordinates());
            setCoordinates(listMove.get(listMove.size()-getSpeed()));
            map.addEntityMap(this.getCoordinates(), this);
        } else {
            map.removeEntityMap(listMove.get(0));
            map.removeEntityMap(this.getCoordinates());
            setCoordinates(listMove.get(0));
            setHeath(getHeath()+1);
            map.addEntityMap(this.getCoordinates(), this);
        }
        setHeath(getHeath()-1);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC07";
    }
}
