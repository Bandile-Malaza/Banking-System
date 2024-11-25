/**
 * 
 */
package BankAccount;

/**
 * 
 */
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BalanceDialog {
    public static void show() {
        Stage stage = new Stage();

        // Mock balance, replace with actual method to fetch balance from BankAccount
        double balance = 0;
		try {
			balance = BankAccount.getBalance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Assume this is a static method for now

        Label balanceLabel = new Label("Your current balance is: R" + balance);

        VBox layout = new VBox(10);
        layout.getChildren().add(balanceLabel);

        Scene scene = new Scene(layout, 400, 300);
        stage.setScene(scene);
        stage.setTitle("Check Balance");
        stage.show();
    }
}
