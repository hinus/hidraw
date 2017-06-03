import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by hinus on 2017/6/3.
 */
public class DragAndDrop extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Hello Drag And Drop");

        Group root = new Group();
        Scene scene = new Scene(root, 400, 200);
        scene.setFill(Color.LIGHTGREEN);

        final Text source = new Text(50, 100, "DRAG ME");
        source.setScaleX(2.0);
        source.setScaleY(2.0);

        final Text target = new Text(250, 100, "DROP HERE");
        target.setScaleX(2.0);
        target.setScaleY(2.0);

        source.setOnDragDetected((MouseEvent event) -> {
            /* drag was detected, start drag-and-drop gesture*/
            System.out.println("onDragDetected");

            /* allow any transfer mode */
            Dragboard db = source.startDragAndDrop(TransferMode.ANY);

            /* put a string on dragboard */
            ClipboardContent content = new ClipboardContent();
            content.putString(source.getText());
            db.setContent(content);

            event.consume();
        });

        target.setOnDragOver((DragEvent event) -> {
            /* data is dragged over the target */
            System.out.println("onDragOver");

            /* accept it only if it is  not dragged from the same node
            * and if it has a string data */
            if (event.getGestureSource() != target &&
                    event.getDragboard().hasString()) {
                /* allow for both copying and moving, whatever user chooses */
                event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
            }

            event.consume();
        });

        target.setOnDragEntered((DragEvent event) -> {
            /* the drag-and-drop gesture entered the target */
            System.out.println("onDragEntered");
            /* show to the user that it is an actual gesture target */
            if (event.getGestureSource() != target &&
                    event.getDragboard().hasString()) {
                target.setFill(Color.GREEN);
            }

            event.consume();
        });

        target.setOnDragExited((DragEvent event) -> {
            /* mouse moved away, remove the graphical cues */
            target.setFill(Color.BLACK);

            event.consume();
        });

        target.setOnDragDropped((DragEvent event) -> {
            /* data dropped */
            System.out.println("onDragDropped");
            /* if there is a string data on dragboard, read it and use it */
            Dragboard db = event.getDragboard();
            boolean success = false;
            if (db.hasString()) {
                target.setText(db.getString());
                success = true;
            }
            /* let the source know whether the string was successfully
            * transferred and used */
            event.setDropCompleted(success);

            event.consume();
        });

        source.setOnDragDone((DragEvent event) -> {
            /* the drag-and-drop gesture ended */
            System.out.println("onDragDone");
            /* if the data was successfully moved, clear it */
            if (event.getTransferMode() == TransferMode.MOVE) {
                source.setText("");
            }

            event.consume();
        });

        root.getChildren().add(source);
        root.getChildren().add(target);
        stage.setScene(scene);
        stage.show();
    }
}
