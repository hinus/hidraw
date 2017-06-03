package cn.hinus.hidraw.event;

import cn.hinus.hidraw.Controller;
import cn.hinus.hidraw.Model;
import cn.hinus.hidraw.View;
import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;

/**
 * Created by hinus on 2017/6/4.
 */
public class CanvasDragDone implements EventHandler<DragEvent> {
    @Override
    public void handle(DragEvent event) {
        System.out.println(event);
        Controller.getInstance().updateDragDone();
    }
}
