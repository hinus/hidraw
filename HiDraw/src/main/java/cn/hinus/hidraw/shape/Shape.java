package cn.hinus.hidraw.shape;

import javafx.scene.canvas.GraphicsContext;

/**
 * Created by hinus on 2017/6/3.
 */
public interface Shape {
    void draw(GraphicsContext gc);
    void setSelected(boolean isSelected);
    boolean getSelected();
    boolean inShape(double x, double y);
    void setX(double x);
    void setY(double y);

    void setOffsetX(double offsetX);
    void setOffsetY(double offsetY);

    void updateDragDown();
}
