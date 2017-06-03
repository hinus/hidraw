package cn.hinus.hidraw.shape;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 * Created by hinus on 2017/6/3.
 */
public class Rect extends AbstractShape {

    private double width;
    private double height;

    private boolean withBorder;
    private double borderWidth;

    private boolean isFilled;
    private Color color;

    public Rect(double x, double y, double width, double height) {
        super(0);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public static Rect makeRect(double x, double y, double width, double height, boolean isFilled) {
        Rect r = new Rect(x, y, width, height);
        r.withBorder = false;
        r.isFilled = isFilled;
        r.color = Color.rgb(127, 127, 127);
        return r;
    }

    @Override
    public void draw(GraphicsContext gc) {
        double x = this.x + this.offsetX;
        double y = this.y + this.offsetY;

        if (withBorder) {
            gc.strokeRect(x, y, width, height);
        }

        if (isFilled) {
            Paint oldColor = gc.getFill();
            gc.setFill(color);
            gc.fillRect(x, y, width, height);
            gc.setFill(oldColor);
        }

        if (isSelected) {
            Paint old = gc.getStroke();
            gc.setStroke(Color.BLACK);
            gc.strokeRect(x - 5, y - 5, this.width + 10, this.height + 10);
            gc.setStroke(old);
        }
    }

    @Override
    public boolean inShape(double x, double y) {
        return (this.x < x && this.x + width > x && this.y < y && this.y + height > y);
    }
}
