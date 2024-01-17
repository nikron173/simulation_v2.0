package com.nikron.simulation_v2;

import com.nikron.simulation_v2.entity.Point;

public class TreePoint {
    private TreePoint parent;
    private TreePoint child;
    private Point value;

    public TreePoint(TreePoint parent, TreePoint child, Point value) {
        this.parent = parent;
        this.child = child;
        this.value = value;
    }

    public TreePoint(TreePoint parent, Point value) {
        this.parent = parent;
        this.value = value;
    }

    public TreePoint(Point value) {
        this.value = value;
    }

    public TreePoint getParent() {
        return parent;
    }

    public TreePoint getChild() {
        return child;
    }

    public Point getValue() {
        return value;
    }

    public void setParent(TreePoint parent) {
        this.parent = parent;
    }

    public void setChild(TreePoint child) {
        this.child = child;
    }

    public void setCurrent(Point value) {
        this.value = value;
    }
}
