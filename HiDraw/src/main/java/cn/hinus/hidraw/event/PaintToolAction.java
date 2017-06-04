package cn.hinus.hidraw.event;

import cn.hinus.hidraw.Controller;
import cn.hinus.hidraw.util.PaintTool;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;


/**
 * Created by hinus on 2017/6/3.
 */
public class PaintToolAction implements EventHandler<KeyEvent> {
    @Override
    public void handle(KeyEvent event) {
        switch (event.getCode()) {
            case V:
                Controller.getInstance().setPaintType(PaintTool.PaintType.SELECT);
                break;
            case R:
                Controller.getInstance().setPaintType(PaintTool.PaintType.RECT);
                break;
            case C:
                Controller.getInstance().setPaintType(PaintTool.PaintType.CIRCLE);
                break;
            case T:
                Controller.getInstance().setPaintType(PaintTool.PaintType.TEXT);
                break;
            default:
                break;
        }
    }
}
