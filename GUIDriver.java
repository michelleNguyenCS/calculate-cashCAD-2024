/**
 * @author Michelle Nguyen
 * @version 2024-08-07
 */


/* IMPORT STATEMENTS */
import java.math.BigDecimal;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class GUIDriver extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		
		/* FONTS */
		Font f0 = new Font("Arial", 36);
		Font f1 = new Font("Arial", 24);
		
		/* INITIAL FRAME */
		VBox vbox = new VBox(20);
		vbox.setAlignment(Pos.CENTER);
		
		/* GUI SETUP */
		Scene scene = new Scene(vbox, 600, 800);
		stage.setScene(scene);
		stage.setTitle("Cashier Simulator");
		stage.show();		// Required for Interface to Launch (1/2)
		
		/* CASH REGISTER */
		
		// Total Line
		
		HBox totalHBox = new HBox(10);
		totalHBox.setAlignment(Pos.CENTER);
		
		Label feeLabel = new Label("Total:");
		feeLabel.setFont(f0);
		
		Text feeText = new Text("$XX.xx");
		feeText.setFont(f0);
		
		totalHBox.getChildren().addAll(feeLabel, feeText);
		
		// Cash Lines
		
		HBox registerHBox = new HBox();
		
		VBox col1VBox = new VBox(10);	// $100 and $2
		VBox col2VBox = new VBox(10);	// $50 and $1
		VBox col3VBox = new VBox(10);	// $20 and 25 cents
		VBox col4VBox = new VBox(10);	// $10 and 10 cents
		VBox col5VBox = new VBox(10);	// $5 and 5 cents
		
		VBox hundredVBox = new VBox(5);
		VBox fiftyVBox = new VBox(5);
		VBox twentyVBox = new VBox(5);
		VBox tenVBox = new VBox(5);
		VBox fiveVBox = new VBox(5);
		VBox toonieVBox = new VBox(5);
		VBox loonieVBox = new VBox(5);
		VBox quarterVBox = new VBox(5);
		VBox dimeVBox = new VBox(5);
		VBox nickelVBox = new VBox(5);
		
		// $100
		
		Label hundredLabel = new Label("$100");
		TextField hundredField = new TextField();
		hundredVBox.getChildren().addAll(hundredLabel, hundredField);
		
		hundredVBox.setAlignment(Pos.CENTER);
		hundredField.setAlignment(Pos.CENTER);
		
		hundredLabel.setFont(f1);
		hundredField.setFont(f1);
		
		// $2
		
		Label toonieLabel = new Label("$2");
		TextField toonieField = new TextField();
		toonieVBox.getChildren().addAll(toonieLabel, toonieField);
		
		toonieVBox.setAlignment(Pos.CENTER);
		toonieField.setAlignment(Pos.CENTER);
		
		toonieLabel.setFont(f1);
		toonieField.setFont(f1);
		
		// $50
		
		Label fiftyLabel = new Label("$50");
		TextField fiftyField = new TextField();
		fiftyVBox.getChildren().addAll(fiftyLabel, fiftyField);
		
		fiftyVBox.setAlignment(Pos.CENTER);
		fiftyField.setAlignment(Pos.CENTER);
		
		fiftyLabel.setFont(f1);
		fiftyField.setFont(f1);
		
		// $1
		
		Label loonieLabel = new Label("$1");
		TextField loonieField = new TextField();
		loonieVBox.getChildren().addAll(loonieLabel, loonieField);
		
		loonieVBox.setAlignment(Pos.CENTER);
		loonieField.setAlignment(Pos.CENTER);
		
		loonieLabel.setFont(f1);
		loonieField.setFont(f1);
		
		// $20
		
		Label twentyLabel = new Label("$20");
		TextField twentyField = new TextField();
		twentyVBox.getChildren().addAll(twentyLabel, twentyField);
		
		twentyVBox.setAlignment(Pos.CENTER);
		twentyField.setAlignment(Pos.CENTER);
		
		twentyLabel.setFont(f1);
		twentyField.setFont(f1);
		
		// $0.25
		
		Label quarterLabel = new Label("$0.25");
		TextField quarterField = new TextField();
		quarterVBox.getChildren().addAll(quarterLabel, quarterField);
		
		quarterVBox.setAlignment(Pos.CENTER);
		quarterField.setAlignment(Pos.CENTER);
		
		quarterLabel.setFont(f1);
		quarterField.setFont(f1);
		
		// $10
		
		Label tenLabel = new Label("$10");
		TextField tenField = new TextField();
		tenVBox.getChildren().addAll(tenLabel, tenField);
		
		tenVBox.setAlignment(Pos.CENTER);
		tenField.setAlignment(Pos.CENTER);
		
		tenLabel.setFont(f1);
		tenField.setFont(f1);
		
		// $0.10
		
		Label dimeLabel = new Label("$0.10");
		TextField dimeField = new TextField();
		dimeVBox.getChildren().addAll(dimeLabel, dimeField);
		
		dimeVBox.setAlignment(Pos.CENTER);
		dimeField.setAlignment(Pos.CENTER);
		
		dimeLabel.setFont(f1);
		dimeField.setFont(f1);
		
		// $5
		
		Label fiveLabel = new Label("$5");
		TextField fiveField = new TextField();
		fiveVBox.getChildren().addAll(fiveLabel, fiveField);
		
		fiveVBox.setAlignment(Pos.CENTER);
		fiveField.setAlignment(Pos.CENTER);
		
		fiveLabel.setFont(f1);
		fiveField.setFont(f1);
		
		// $0.05
		
		Label nickelLabel = new Label("$0.05");
		TextField nickelField = new TextField();
		nickelVBox.getChildren().addAll(nickelLabel, nickelField);
		
		nickelVBox.setAlignment(Pos.CENTER);
		nickelField.setAlignment(Pos.CENTER);
		
		nickelLabel.setFont(f1);
		nickelField.setFont(f1);
		
		// Adding It All Together (1)
		
		col1VBox.getChildren().addAll(hundredVBox, toonieVBox);
		col2VBox.getChildren().addAll(fiftyVBox, loonieVBox);
		col3VBox.getChildren().addAll(twentyVBox, quarterVBox);
		col4VBox.getChildren().addAll(tenVBox, dimeVBox);
		col5VBox.getChildren().addAll(fiveVBox, nickelVBox);
		
		registerHBox.getChildren().addAll(col1VBox, col2VBox, col3VBox, col4VBox, col5VBox);
		
		// Buttons
		
		HBox buttonHBox = new HBox(10);
		buttonHBox.setAlignment(Pos.CENTER);
		
		Button generateButton= new Button("Generate");
		Button submitButton = new Button("Submit");
		
		generateButton.setAlignment(Pos.CENTER);
		submitButton.setAlignment(Pos.CENTER);
		
		generateButton.setFont(f1);
		submitButton.setFont(f1);
		
		buttonHBox.getChildren().addAll(generateButton, submitButton);
		
		// Result Text
		
		Label resultLabel = new Label("...");
		resultLabel.setAlignment(Pos.CENTER);
		resultLabel.setFont(f1);
		
		// Adding It All Together (2)
		
		vbox.getChildren().addAll(totalHBox, registerHBox, buttonHBox, resultLabel);
		
		/* BUTTON CODE */
		
		generateButton.setOnAction(e -> {
			try {
				BigDecimal payment = BigDecimal.valueOf(0.00);	// Initialize variable
				payment = Cash.roundCash(Cash.randomCash());	// Generate payment
				feeText.setText(payment.toString());			// Display payment
				
				// Reset Result Label
				
				resultLabel.setText("...");
				
				// Auto-set 0
				
				hundredField.setText("0");
				fiftyField.setText("0");
				twentyField.setText("0");
				tenField.setText("0");
				fiveField.setText("0");
				
				toonieField.setText("0");
				loonieField.setText("0");
				quarterField.setText("0");
				dimeField.setText("0");
				nickelField.setText("0");
				
				// Random Cash Register
				Register register = new Register (10, 10, 10, 10, 10, 10, 10, 10, 10, 10);
				
				// Getting the Correct Answer
				Register correctAnswer = Cash.calculateChange(payment, register);
				
				submitButton.setOnAction(f -> {
					try {
						
						// Getting Player's Guess
						
						int playerHundred = Integer.valueOf(hundredField.getText());
						int playerFifty = Integer.valueOf(fiftyField.getText());
						int playerTwenty = Integer.valueOf(twentyField.getText());
						int playerTen = Integer.valueOf(tenField.getText());
						int playerFive = Integer.valueOf(fiveField.getText());
						
						int playerToonie = Integer.valueOf(toonieField.getText());
						int playerLoonie = Integer.valueOf(loonieField.getText());
						int playerQuarter = Integer.valueOf(quarterField.getText());
						int playerDime = Integer.valueOf(dimeField.getText());
						int playerNickel = Integer.valueOf(nickelField.getText());
						
						Register playerGuess = new Register(playerHundred, playerFifty, playerTwenty, 
								playerTen, playerFive, playerToonie, playerLoonie, playerQuarter, 
								playerDime, playerNickel);
						
						if (playerGuess.equals(correctAnswer))
							resultLabel.setText("nice job");
						else
							resultLabel.setText("bad math");
					} catch (Exception g) {}
				});
			} catch (Exception error) {} });
	}
	
	public static void main(String[] args) {
		launch(args);	// Required for Interface to Launch (2/2)
	}
}
