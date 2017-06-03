package cn.hinus.hidraw.event;


import cn.hinus.hidraw.Controller;
import cn.hinus.hidraw.Model;
import cn.hinus.hidraw.View;
import javafx.event.EventHandler;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;

/**
 * Created by hinus on 2017/6/3.
 */
public class CanvasMouseDrag implements EventHandler<MouseEvent> {
    @Override
    public void handle(MouseEvent event) {
        //System.out.println("drag event");
        Controller.getInstance().updateDragPos(event.getX(), event.getY());
    }
}
