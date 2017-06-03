package cn.hinus.hidraw.event;

import cn.hinus.hidraw.Controller;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Created by hinus on 2017/6/4.
 */
public class CanvasMouseRelease implements EventHandler<MouseEvent> {
    @Override
    public void handle(MouseEvent event) {
        System.out.println(event);
        Controller.getInstance().updateDragDone();
    }
}
