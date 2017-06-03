package cn.hinus.hidraw.event;

import cn.hinus.hidraw.Controller;
import cn.hinus.hidraw.Model;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

/**
 * Created by hinus on 2017/6/3.
 */
public class CanvasMouseLeftClicked implements EventHandler<MouseEvent>{
    private Canvas canvas;

    public CanvasMouseLeftClicked(Canvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void handle(MouseEvent event) {
        //System.out.println(event);
        Controller.getInstance().addShape(event.getX(), event.getY());
    }
}
