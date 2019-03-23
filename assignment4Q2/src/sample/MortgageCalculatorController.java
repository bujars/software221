/**
 * Sample Skeleton for 'sample.fxml' Controller Class
 */

import java.math.BigDecimal; /*This is because price is monitary*/
import javafx.event.ActionEvent; /*This needs to be imported to handle events, such as a button click*/
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import java.math.RoundingMode; /*To specify how BigDecimal is formatted*/
import java.text.NumberFormat; /*To let us write dollar values*/

public class MortgageCalculatorController{

    @FXML // fx:id="interestRateTextField"
    private TextField interestRateTextField; // Value injected by FXMLLoader

    @FXML // fx:id="downPaymentAmountTextField"
    private TextField downPaymentAmountTextField; // Value injected by FXMLLoader

    @FXML // fx:id="downPaymentTextField"
    private TextField downPaymentTextField; // Value injected by FXMLLoader

    @FXML // fx:id="purchasePriceTextField"
    private TextField purchasePriceTextField; // Value injected by FXMLLoader

    @FXML // fx:id="monthlyAmountTextField"
    private TextField monthlyAmountTextField; // Value injected by FXMLLoader

    @FXML // fx:id="yearAmountSlider"
    private Slider yearAmountSlider; // Value injected by FXMLLoader

    /*This will store the slider value. Its preinitalized to default*/
    private BigDecimal yearAmount = new BigDecimal(20);

    /*Note this function is so that we can convert our BigDecimal Result into a string to be printed*/
    private static final NumberFormat currency = NumberFormat.getCurrencyInstance();




    @FXML
    public void calculateMortgageAmount(ActionEvent event) {
        /*THIS function gets the price, interest rate, etc and returns the monthly amount to be paid.
        Treat interest rate as something the user would need to know and just calculate it by multiplying. */

        /*NOTICE this is going in an try block because we want to make sure that the user is inputing numbers.
        Note a BigDecimal is just a number*/
        try {
            BigDecimal purchasePrice = new BigDecimal(purchasePriceTextField.getText());

            /*NOTE still not sure why I have two different down payments but was listed in the instructions.*/
            BigDecimal downPaymentAmount = new BigDecimal(downPaymentAmountTextField.getText());
            BigDecimal downPayment = new BigDecimal(downPaymentTextField.getText());
            BigDecimal interestRate = new BigDecimal(interestRateTextField.getText());
            BigDecimal result = downPayment.add(downPaymentAmount);
            result = result.add(purchasePrice);
            result = result.add(interestRate);

            monthlyAmountTextField.setText(currency.format(result));
        } catch(NumberFormatException num){

        }
    }

    /* NOTE function initiate looks to see if the slider is changed, and changes the  yearAmountSlider value accordingly.*/
    public void initiate() {

    }

}
