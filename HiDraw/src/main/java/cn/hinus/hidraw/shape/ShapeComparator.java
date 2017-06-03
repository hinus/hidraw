package cn.hinus.hidraw.shape;

import java.util.Comparator;

/**
 * Created by hinus on 2017/6/3.
 */
public class ShapeComparator implements Comparator<AbstractShape> {
    @Override
    public int compare(AbstractShape o1, AbstractShape o2) {
        if (o1.getLayer() < o2.getLayer())
            return -1;
        else if (o1.getLayer() == o2.getLayer())
            return 0;
        else
            return 1;
    }
}
