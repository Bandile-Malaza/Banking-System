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

public class TransferDialog {
    public static void show() {
        Stage stage = new Stage();

        Label recipientLabel = new Label("Enter recipient's account number:");
        TextField recipientField = new TextField();
        Label amountLabel = new Label("Enter amount to transfer:");
        TextField amountField = new TextField();
        Button confirmButton = new Button("Transfer");

        confirmButton.setOnAction(e -> {
            try {
                String recipient = recipientField.getText();
                double amount = Double.parseDouble(amountField.getText());

                if (amount > 0 && !recipient.isEmpty()) {
                    boolean success = BankAccount.transferTo(recipient, amount); // Replace with actual method
                    if (success) {
                        showSuccess("Transfer successful!");
                    } else {
                        showError("Insufficient funds or invalid recipient.");
                    }
                } else {
                    showError("Invalid input. Please check recipient and amount.");
                }
            } catch (NumberFormatException ex) {
                showError("Please enter a valid amount.");
            }
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(recipientLabel, recipientField, amountLabel, amountField, confirmButton);

        Scene scene = new Scene(layout, 300, 200);
        stage.setScene(scene);
        stage.setTitle("Transfer Money");
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
