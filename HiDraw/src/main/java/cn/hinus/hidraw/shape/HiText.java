package cn.hinus.hidraw.shape;

import com.sun.javafx.scene.control.skin.Utils;
import javafx.geometry.Bounds;
import javafx.geometry.VPos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * Created by hinus on 2017/6/4.
 */
public class HiText extends AbstractShape {
    String text;
    Text layout;
    Font font;

    private HiText(String text, double x, double y, String fontFamily, double fontSize) {
        this.text = text;
        this.x = x;
        this.y = y;

        this.font = Font.font(fontFamily, fontSize);
        this.layout = new Text(text);
        layout.setFont(font);
    }

    public static HiText makeText(String text, double x, double y, String fontFamily, double size) {
        HiText t = new HiText(text, x, y, fontFamily, size);
        return t;
    }

    @Override
    public void draw(GraphicsContext gc) {
        Bounds bounds = layout.getLayoutBounds();
        double width = bounds.getWidth();
        double height = bounds.getHeight();

        double x = this.x + this.offsetX;
        double y = this.y + this.offsetY;

        Font old = gc.getFont();
        gc.setFont(this.font);
        gc.strokeRect(x - 5, y - 5, width + 10, height + 10);
        gc.fillText(text, x, y);
        gc.setTextBaseline(VPos.TOP);
        gc.setFont(old);

        if (isSelected) {
            gc.strokeRect(x - 10, y - 10, width + 20, height + 20);
        }
    }

    @Override
    public boolean inShape(double x, double y) {
        System.out.println(layout.getLayoutX() + " and " + x + " and " + this.x);
        return layout.getLayoutBounds().contains(x - this.x, y - this.y);
    }
}
