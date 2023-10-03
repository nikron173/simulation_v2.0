package com.nikron.simulation_v2.entity;

import java.util.List;

public class Predator extends Creature {

    public Predator(boolean isStaticObject, boolean isResourceObject, Coordinates coordinates,
                    int heath, int speed, int attack, boolean isResourceForHunter) {
        super(isStaticObject, isResourceObject, coordinates, heath, speed, attack, isResourceForHunter);
    }

    @Override
    public void makeMove(com.nikron.simulation_v2.Map map) {
        List<Coordinates> listMove = getShortListMovesCoordinates(getCoordinates(),
                map.getAllHerbivore().stream().map(Entity::getCoordinates).toList(), map.getMap());
        if (listMove == null) return;
        if (getSpeed() < listMove.size()){
            map.removeEntityMap(this.getCoordinates());
            setCoordinates(listMove.get(listMove.size()-getSpeed()));
            map.addEntityMap(this.getCoordinates(), this);
        } else {
            Creature creature = (Creature)map.getEntityMap(listMove.get(0));
            if (creature.getHeath() > getAttack()){
                creature.setHeath(creature.getHeath() - getAttack());
                if (listMove.size() > 1) {
                    map.removeEntityMap(this.getCoordinates());
                    setCoordinates(listMove.get(1));
                    map.addEntityMap(this.getCoordinates(), this);
                }
            } else {
                map.removeEntityMap(listMove.get(0));
                map.removeEntityMap(this.getCoordinates());
                setCoordinates(listMove.get(0));
                map.addEntityMap(this.getCoordinates(),this);
                setHeath(getHeath()+1);
            }
        }
        setHeath(getHeath()-1);
    }

    @Override
    public String toString() {
        return "\uD83E\uDD8A";
    }
}
