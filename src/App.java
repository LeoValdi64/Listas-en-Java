import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application {

    private Celda celda = new Celda();

    @Override
    public void start(Stage primaryStage) throws Exception {

        int numFilas = 10;
        int numColumnas = 10;

        TextField[][] celdas = new TextField[numFilas][numColumnas];
        GridPane grid = new GridPane();

        // Añadir letras en la parte superior
        for (int j = 0; j < numColumnas; j++) {
            Label label = new Label(Character.toString((char) ('A' + j)));
            label.setAlignment(Pos.CENTER);
            label.setMaxWidth(Double.MAX_VALUE); // Ajusta este valor según el tamaño de tus celdas
            label.setMinHeight(20); // Ajusta este valor según el tamaño de tus celdas
            GridPane.setRowIndex(label, 0);
            GridPane.setColumnIndex(label, j + 1);
            grid.getChildren().add(label);
        }

        // Añadir números a la izquierda
        for (int i = 0; i < numFilas; i++) {
            Label label = new Label(Integer.toString(i + 1));
            label.setAlignment(Pos.CENTER);
            label.setMinWidth(20);
            GridPane.setRowIndex(label, i + 1); // +1 para dejar espacio para las letras arriba
            GridPane.setColumnIndex(label, 0);
            grid.getChildren().add(label);
        }

        // Añadir celdas
        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColumnas; j++) {
                TextField textField = new TextField();
                textField.setOnKeyTyped(manejarEscritura);
                GridPane.setRowIndex(textField, i + 1); // +1 por las letras
                GridPane.setColumnIndex(textField, j + 1); // +1 por los números
                celdas[i][j] = textField;
                grid.getChildren().add(textField);
                
            }
        }


        grid.setGridLinesVisible(true);
        // Aquí puedes añadir más estilos según necesites

        Scene scene = new Scene(grid, 800, Double.MAX_VALUE);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    //Evento de escribir en la celda
    EventHandler<KeyEvent> manejarEscritura = new EventHandler<KeyEvent>() {
    @Override
    public void handle(KeyEvent event) {
        TextField textField = (TextField) event.getSource();
        int fila = GridPane.getRowIndex(textField) - 1; // -1 porque la primera fila son las etiquetas
        int columna = GridPane.getColumnIndex(textField) - 1; // -1 porque la primera columna son las etiquetas
        celda.add(fila, columna, textField.getText());
        System.out.println(celda.toString());
        
    }
};


    public static void main(String[] args) {
        launch(args);
    }

}