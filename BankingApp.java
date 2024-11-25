import BankAccount.BalanceDialog;
import BankAccount.BankAccount;
import BankAccount.DepositDialog;
import BankAccount.TransferDialog;
import BankAccount.WithdrawDialog;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class BankingApp extends Application {

    // Store accounts in a map
    private static final Map<String, BankAccount> accounts = new HashMap<>();
    private static int accountCounter = 1001; // Unique account numbers

    @Override
    public void start(Stage primaryStage) {
        // Login Screen
        Label loginLabel = new Label("Enter your Account Number:");
        TextField accountNumberField = new TextField();
        Button loginButton = new Button("Login");
        Button createAccountButton = new Button("Create New Account");

        // Event for Login
        loginButton.setOnAction(e -> {
            String accountNumber = accountNumberField.getText();
            if (accounts.containsKey(accountNumber)) {
                // Open Dashboard for the logged-in account
                openDashboard(primaryStage, accounts.get(accountNumber));
            } else {
                showError("Invalid Account Number. Please try again.");
            }
        });

        // Event for Create New Account
        createAccountButton.setOnAction(e -> openCreateAccountDialog(primaryStage));

        VBox loginLayout = new VBox(10);
        loginLayout.getChildren().addAll(loginLabel, accountNumberField, loginButton, createAccountButton);

        Scene loginScene = new Scene(loginLayout, 600, 500);
        primaryStage.setTitle("Simple Banking System");
        primaryStage.setScene(loginScene);
        primaryStage.show();
    }

    private void openDashboard(Stage stage, BankAccount account) {
        // Dashboard
        Label welcomeLabel = new Label("Welcome, Account " + account.getAccountNumber());
        Button depositButton = new Button("Deposit");
        Button withdrawButton = new Button("Withdraw");
        Button balanceButton = new Button("Check Balance");
        Button historyButton = new Button("Transaction History");
        Button transferButton = new Button("Transfer Money");
        Button logoutButton = new Button("Logout");

        // Event handlers for dashboard buttons
        depositButton.setOnAction(e -> openDepositDialog(account));
        withdrawButton.setOnAction(e -> openWithdrawDialog(account));
        balanceButton.setOnAction(e -> checkBalance(account));
        transferButton.setOnAction(e -> openTransferDialog(account));
        logoutButton.setOnAction(e -> start(stage)); // Return to login screen

        VBox dashboardLayout = new VBox(10);
        dashboardLayout.getChildren().addAll(welcomeLabel, depositButton, withdrawButton, balanceButton, historyButton, transferButton, logoutButton);

        Scene dashboardScene = new Scene(dashboardLayout, 600, 800);
        stage.setScene(dashboardScene);
        stage.setTitle("Dashboard");
    }

    private void openCreateAccountDialog(Stage stage) {
        Stage dialog = new Stage();

        Label nameLabel = new Label("Enter your Name:");
        TextField nameField = new TextField();
        Label depositLabel = new Label("Initial Deposit:");
        TextField depositField = new TextField();
        Button createButton = new Button("Create Account");

        createButton.setOnAction(e -> {
            String name = nameField.getText();
            try {
                double initialDeposit = Double.parseDouble(depositField.getText());
                if (name.isEmpty() || initialDeposit < 0) {
                    showError("Invalid input. Please provide valid details.");
                    return;
                }

                // Create a new account
                String accountNumber = String.valueOf(accountCounter++);
                BankAccount newAccount = new BankAccount(accountNumber, name, initialDeposit);
                accounts.put(accountNumber, newAccount);

                showInfo("Account created successfully! Your Account Number is: " + accountNumber);
                dialog.close();
            } catch (NumberFormatException ex) {
                showError("Please enter a valid deposit amount.");
            }
        });

        VBox createAccountLayout = new VBox(10);
        createAccountLayout.getChildren().addAll(nameLabel, nameField, depositLabel, depositField, createButton);

        Scene scene = new Scene(createAccountLayout, 500, 600);
        dialog.setScene(scene);
        dialog.setTitle("Create New Account");
        dialog.show();
    }

    private void openDepositDialog(BankAccount account) {
        DepositDialog.show();
    }

    private void openWithdrawDialog(BankAccount account) {
        WithdrawDialog.show();
    }

    private void checkBalance(BankAccount account) {
        BalanceDialog.show();
    }


    private void openTransferDialog(BankAccount account) {
        TransferDialog.show();
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.show();
    }

    private void showInfo(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
