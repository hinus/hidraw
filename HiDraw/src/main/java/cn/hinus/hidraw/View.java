package cn.hinus.hidraw;

import cn.hinus.hidraw.shape.AbstractShape;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

/**
 * Created by hinus on 2017/6/3.
 */
public class View {
    Canvas canvas;
    private static View v;

    private View(Canvas canvas) {
        this.canvas = canvas;
    }

    public void updateModel(Model m) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        m.getShapes().stream().forEach((AbstractShape s) -> s.draw(gc));
    }

    public static View getInstance() {
        return v;
    }

    public static View getInstance(Canvas canvas) {
        if (v == null)
            v = new View(canvas);

        return v;
    }
}
