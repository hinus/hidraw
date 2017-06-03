package cn.hinus.hidraw.event;

import cn.hinus.hidraw.Controller;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Created by hinus on 2017/6/3.
 */
public class CanvasDragDetected implements EventHandler<MouseEvent> {
    @Override
    public void handle(MouseEvent event) {
        System.out.println("drag begin");
        Controller.getInstance().setDragBegin(event.getX(), event.getY());
        event.consume();
    }
}
