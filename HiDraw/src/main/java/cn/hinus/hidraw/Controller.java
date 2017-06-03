package cn.hinus.hidraw;

import cn.hinus.hidraw.shape.Circle;
import cn.hinus.hidraw.shape.Rect;
import cn.hinus.hidraw.util.PaintTool;
import javafx.scene.paint.Color;

/**
 * Created by hinus on 2017/6/3.
 */
public class Controller {
    private PaintTool.PaintType globalPaintType;

    // 元素属性
    private boolean isFill;
    private double width;
    private double height;
    private Color borderColor;
    private Color fillColor;

    // 与鼠标拖拽有关的属性
    private double dragBeginX;
    private double dragBeginY;

    private Controller() {
    }

    private static Controller c;

    public static Controller getInstance() {
        if (c == null)
            c = new Controller();

        return c;
    }

    public void setPaintType (PaintTool.PaintType paintType) {
        globalPaintType = paintType;
        System.out.println("paintType is " + paintType);
    }

    public void addShape(double x, double y) {
        Model m = Model.getInstance();
        View v = View.getInstance();

        if (globalPaintType == PaintTool.PaintType.RECT) {
            m.getShapes().add(Rect.makeRect(x, y, this.width, this.height, this.isFill));
        }
        else if (globalPaintType == PaintTool.PaintType.CIRCLE) {
            m.getShapes().add(Circle.makeCircle(x, y, this.width, this.height, this.isFill));
        }
        else if (globalPaintType == PaintTool.PaintType.SELECT) {
            m.markSelected(x, y);
        }
        v.updateModel(m);
    }

    public void setFill(boolean isFill) {
        this.isFill = isFill;
        System.out.println("current fill is " + this.isFill);
    }

    public void setWidth(double width) {
        System.out.println("Width is " + width);
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setDragBegin(double x, double y) {
        this.dragBeginX = x;
        this.dragBeginY = y;
    }

    public void updateDragPos(double x, double y) {
        if (this.dragBeginX < 0 || this.dragBeginY < 0)
            return;

        Model.getInstance().updateSelected(x - this.dragBeginX, y - this.dragBeginY);
        //System.out.println(x - dragBeginX);
        //System.out.println(y - dragBeginY);
       // Model.getInstance().updateSelected(x, y);
        View.getInstance().updateModel(Model.getInstance());
    }

    public void updateDragDone() {
        this.dragBeginY = -1;
        this.dragBeginX = -1;

        Model.getInstance().updateDragDone();
        View.getInstance().updateModel(Model.getInstance());
    }
}
