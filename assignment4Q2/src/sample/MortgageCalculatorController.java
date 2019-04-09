/**
 * Sample Skeleton for 'sample.fxml' Controller Class
 */

import java.math.BigDecimal; /*This is because price is monitary*/

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
            BigDecimal principalAmount = purchasePrice.subtract(downPaymentAmount);

            if(downPaymentAmount.intValue() > purchasePrice.intValue()){
                throw new NumberFormatException("");
            }

            BigDecimal interestRate = new BigDecimal(interestRateTextField.getText());

            if (!(purchasePrice.compareTo(BigDecimal.ZERO) > 0) || !(downPaymentAmount.compareTo(BigDecimal.ZERO) > 0) || !(interestRate.compareTo(BigDecimal.ZERO) > 0)) {
                throw new NumberFormatException("Values must be positive");
            }


            /**Interest rate is a percentage, so convert to decimal, and then divide by the number of months in a year.*/
            interestRate = interestRate.divide(new BigDecimal("12"), 8, RoundingMode.HALF_UP).divide(new BigDecimal("100" ), 8, RoundingMode.HALF_UP);
            BigDecimal month = yearAmount.multiply(new BigDecimal("12"));
            BigDecimal rPlus1 = interestRate.add(new BigDecimal("1"));
            BigDecimal rPlus1Pow = rPlus1.pow(month.intValue());
            BigDecimal denomiator = rPlus1Pow.subtract(new BigDecimal("1.0"));
            BigDecimal numerator = rPlus1Pow.multiply(interestRate);
            BigDecimal rate = numerator.divide(denomiator, 8, RoundingMode.HALF_UP);
            BigDecimal result = principalAmount.multiply(rate);

            System.out.println(purchasePrice);
            System.out.println(downPaymentAmount);
            System.out.println(principalAmount);
            System.out.println(interestRate);
            System.out.println(rPlus1);
            System.out.println(rPlus1Pow);
            System.out.println(denomiator);
            System.out.println(numerator);
            System.out.println(rate);
            System.out.println(result);
            System.out.println(month);

            /*
            int month = 360;
            BigDecimal numerator = interestRate.multiply((interestRate.add((BigDecimal) 1.0)).pow(months));
            BigDecimal denominator= (interestRate.add(1)).pow(month);

            BigDecimal result = downPaymentAmount;
            result = result.add(purchasePrice);
            result = result.add(interestRate);
*/
            //BigDecimal result = downPaymentAmount;
            monthlyAmountTextField.setText(currency.format(result));
        } catch(NumberFormatException | ArithmeticException num){
            /**If user decides to enter data that isnt compatible, catch the error and refocus to the top. */
            purchasePriceTextField.setText("Enter amount, value only");
            downPaymentAmountTextField.setText("Enter amount, value only");
            interestRateTextField.setText("Enter amount, value only");
            purchasePriceTextField.selectAll();
            purchasePriceTextField.requestFocus();
        }
    }

    /* NOTE function initiate looks to see if the slider is changed, and changes the  yearAmountSlider value accordingly.*/
    public void initialize() {
        /** Set the rounding mode for the money. 5+ = 1 0-4 = 0  */
        currency.setRoundingMode(RoundingMode.HALF_UP);

        /**As the user changes the slider, we must listen and change the value of the year to the appropriate amount chosen.*/
        yearAmountSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                yearAmount = BigDecimal.valueOf(newValue.intValue());
            }
        });
    }

}
