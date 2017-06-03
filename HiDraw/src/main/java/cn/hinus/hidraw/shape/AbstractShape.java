package cn.hinus.hidraw.shape;

import java.util.Comparator;

/**
 * Created by hinus on 2017/6/3.
 */
public abstract class AbstractShape implements Shape {
    private int layer;
    protected boolean isSelected;

    protected double x;
    protected double y;

    protected double offsetX;
    protected double offsetY;

    public AbstractShape(int layer) {
        this.layer = layer;
    }

    public AbstractShape() {
    }

    public int getLayer() {
        return layer;
    }

    @Override
    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    @Override
    public boolean getSelected() {
        return isSelected;
    }

    @Override
    public void setX(double x) {
        this.x = x;
    }

    @Override
    public void setY(double y) {
        this.y = y;
    }

    @Override
    public void setOffsetX(double offsetX) {
        System.out.println("offset is " + offsetX + " target x is " + (this.x + offsetX));
        this.offsetX = offsetX;
    }

    @Override
    public void setOffsetY(double offsetY) {
        this.offsetY = offsetY;
    }

    @Override
    public void updateDragDown() {
        this.x += this.offsetX;
        this.y += this.offsetY;
        this.offsetX = 0;
        this.offsetY = 0;
    }
}


