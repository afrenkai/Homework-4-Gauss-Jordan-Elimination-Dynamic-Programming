import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class HobbitDPVisualizer extends Application {
    
    private static final int[][] gems = {
        {21, 95, 20, 82, 66, 52, 89, 35},
        {74, 40, 37, 79, 23, 14, 5, 78},
        {63, 16, 4, 31, 25, 17, 59, 32},
        {15, 92, 70, 13, 48, 77, 11, 91},
        {12, 67, 88, 22, 64, 47, 71, 56},
        {7, 30, 51, 65, 27, 94, 97, 83},
        {93, 53, 24, 46, 86, 1, 41, 10},
        {84, 99, 68, 75, 98, 44, 33, 96}
    };
    
    private static final int rows = 8;
    private static final int cols = 8;

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        int[][] dp = new int[rows][cols];
        int[][] path = new int[rows][cols];

        /// dp in row 1
        for (int j = 0; j < cols; j++) {
            dp[0][j] = gems[0][j];
            path[0][j] = -1;
        }

        
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int maxGems = dp[i - 1][j];
                int prevCol = j;
                //checks left diag
                if (j > 0 && dp[i - 1][j - 1] > maxGems) {
                    maxGems = dp[i - 1][j - 1];
                    prevCol = j - 1;
                }
                //checks right diag
                if (j < cols - 1 && dp[i - 1][j + 1] > maxGems) {
                    maxGems = dp[i - 1][j + 1];
                    prevCol = j + 1;
                }
                //updates arr and path
                dp[i][j] = gems[i][j] + maxGems;
                path[i][j] = prevCol;
            }
        }
        //max in row and col
        int maxGemsCollected = 0;
        int startCol = 0;
        for (int j = 0; j < cols; j++) {
            if (dp[rows - 1][j] > maxGemsCollected) {
                maxGemsCollected = dp[rows - 1][j];
                startCol = j;
            }
        }
        //backtrack to find path we took.
        int[] pathCols = new int[rows];
        pathCols[rows - 1] = startCol;
        for (int i = rows - 1; i > 0; i--) {
            pathCols[i - 1] = path[i][pathCols[i]];
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Label cell = new Label(String.valueOf(gems[i][j]));
                cell.setFont(Font.font("Arial", FontWeight.BOLD, 20));
                cell.setMinSize(50, 50);
                cell.setStyle("-fx-border-color: black; -fx-alignment: center;");
                if (j == pathCols[i]) {
                    cell.setTextFill(Color.WHITE);
                    cell.setStyle("-fx-background-color: green; -fx-border-color: black; -fx-alignment: center;");
                }
                gridPane.add(cell, j, i);
            }
        }
        Label info = new Label("Bilbo's starting square: Row 1, Column " + (pathCols[0] + 1) +
                               "\nTotal number of gems collected: " + maxGemsCollected +
                               "\nVault with the Arkenstone: Column " + (pathCols[rows - 1] + 1));
        info.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        
        VBox vbox = new VBox(10, gridPane, info);
        Scene scene = new Scene(vbox, 500, 550);
        
        primaryStage.setTitle("Hobbit Gem Collection Path Visualization");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
