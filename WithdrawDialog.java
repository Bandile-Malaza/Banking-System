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

public class WithdrawDialog {
    public static void show() {
        Stage stage = new Stage();

        Label amountLabel = new Label("Enter amount to withdraw:");
        TextField amountField = new TextField();
        Button confirmButton = new Button("Withdraw");

        confirmButton.setOnAction(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());

                if (amount > 0) {
                    boolean success = BankAccount.withdraw(amount); // Replace with actual method
                    if (success) {
                        showSuccess("Withdrawal successful! New balance: $" + BankAccount.getBalance());
                    } else {
                        showError("Insufficient funds.");
                    }
                } else {
                    showError("Invalid amount. Please enter a positive value.");
                }
            } catch (NumberFormatException ex) {
                showError("Please enter a valid amount.");
            }
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(amountLabel, amountField, confirmButton);

        Scene scene = new Scene(layout, 300, 150);
        stage.setScene(scene);
        stage.setTitle("Withdraw Money");
        stage.show();
    }

    private static void showSuccess(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.show();
    }

    private static void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.show();
    }
}

