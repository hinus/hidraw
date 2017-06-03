package cn.hinus.hidraw;

import cn.hinus.hidraw.shape.AbstractShape;
import cn.hinus.hidraw.shape.ShapeComparator;

import java.util.ArrayList;

/**
 * Created by hinus on 2017/6/3.
 */
public class Model {
    private static Model m;

    private Model() {
    }

    ArrayList<AbstractShape> shapes = new ArrayList<>(10);

    void addShape(AbstractShape s) {
        if (s == null)
            return;

        shapes.add(s);
        shapes.sort(new ShapeComparator());
    }

    public ArrayList<AbstractShape> getShapes() {
        return shapes;
    }

    public static Model getInstance() {
        if (m == null)
            m = new Model();

        return m;
    }

    public void markSelected(double x, double y) {
        for (AbstractShape s : shapes) {
            if (s.inShape(x, y))
                s.setSelected(true);
            else
                s.setSelected(false);
        }
    }

    public void updateSelected(double x, double y) {
        //System.out.println("offset is " + x + " offset y is " + y);
        for (AbstractShape s : shapes) {
            if (s.getSelected()) {
                s.setOffsetX(x);
                s.setOffsetY(y);
                //s.setX(x);
                //s.setY(y);
            }
        }
    }

    public void updateDragDone() {
        for (AbstractShape s : shapes) {
            s.updateDragDown();
        }
    }
}
