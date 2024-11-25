/**
 * 
 */
package BankAccount;

/**
 * 
 */
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DepositDialog {
    public static void show() {
        Stage stage = new Stage();

        Label depositLabel = new Label("Enter amount to deposit:");
        TextField depositField = new TextField();
        Button confirmButton = new Button("Deposit");

        confirmButton.setOnAction(e -> {
            try {
                double amount = Double.parseDouble(depositField.getText());
                if (amount > 0) {
                    // Call BankAccount deposit method
                    System.out.println("Deposited: R" + amount);
                } else {
                    showError("Invalid amount");
                }
            } catch (NumberFormatException ex) {
                showError("Please enter a valid number");
            }
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(depositLabel, depositField, confirmButton);

        Scene scene = new Scene(layout, 300, 150);
        stage.setScene(scene);
        stage.setTitle("Deposit Money");
        stage.show();
    }

    private static void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.show();
    }
}

