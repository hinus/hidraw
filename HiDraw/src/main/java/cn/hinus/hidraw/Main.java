package cn.hinus.hidraw;

import cn.hinus.hidraw.event.*;
import cn.hinus.hidraw.util.PaintTool;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane mainPane = new BorderPane();
        Canvas canvas = new Canvas(800, 750);

        mainPane.setCenter(canvas);
        Scene scene = new Scene(mainPane, 1000, 750);

        initPropertyPanel(mainPane);
        initMVC(canvas);
        initSceneAction(scene);
        initCanvasAction(canvas);

        canvas.setOnKeyTyped(new PaintToolAction());


        primaryStage.setTitle("HiDraw");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void initMVC(Canvas canvas) {
        View.getInstance(canvas);
        Controller.getInstance().setPaintType(PaintTool.PaintType.RECT);
    }

    public void initPropertyPanel(BorderPane mainPane) {
        GridPane grid = new GridPane();
        ScrollPane sp = new ScrollPane(grid);

        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(0, 10, 0, 10));

        CheckBox fill = new CheckBox("fill");

        fill.setOnAction((ActionEvent e) -> {
            Controller.getInstance().setFill(fill.isSelected());
        });

        grid.add(fill, 0, 0, 2, 1);

        TextField width = new TextField();
        width.setPrefColumnCount(3);
        width.setOnKeyReleased((KeyEvent e) -> {
            String t = width.getText();
            if (t == null || t.equals(""))
                return;

            Controller.getInstance().setWidth(Double.valueOf(t));
        });
        grid.add(new Text("width"), 0, 1);
        grid.add(width, 1, 1);

        TextField height = new TextField();
        height.setPrefColumnCount(3);
        height.setOnKeyReleased((KeyEvent e) -> {
            String t = height.getText();
            if (t == null || t.equals(""))
                return;

            Controller.getInstance().setHeight(Double.valueOf(t));
        });
        grid.add(new Text("height"), 0, 2);
        grid.add(height, 1, 2);

        mainPane.setRight(sp);
    }

    public void initSceneAction(Scene scene) {
        scene.setOnKeyPressed(new PaintToolAction());
    }

    public void initCanvasAction(Canvas canvas) {
        canvas.setOnMousePressed(new CanvasMouseLeftClicked(canvas));
        canvas.setOnDragDetected(new CanvasDragDetected());
        canvas.setOnMouseDragged(new CanvasMouseDrag());
        canvas.setOnMouseReleased(new CanvasMouseRelease());

        //canvas.setOnDragExited(new CanvasDragDone());
        //canvas.setOnMouseDragReleased(new CanvasMouseDrag());
    }
}