package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;


public class Controller extends Pane {
    ObservableList<String> comboBoxList = FXCollections
            .observableArrayList("Celsius", "Fahrenheit", "Kelvin");

    @FXML
    private TextField textField1;
    @FXML
    private TextField textField2;

    @FXML
    private ComboBox leftComBox;
    @FXML
    private ComboBox rightComBox;

    @FXML
    private Label formulaIndicator;

    @FXML
    private Text equalSign;
    @FXML
    private Text theFormula;

    public Controller() {

    }
    @FXML
    private void initialize() {
        leftComBox.setValue("Celsius");
        leftComBox.setItems(comboBoxList);

        rightComBox.setValue("Fahrenheit");
        rightComBox.setItems(comboBoxList);

        textField1.setText("");
        textField2.setText("");
        theFormula.setText("(" + textField1.getText() + "°C x 9/5) + 32 = " + textField2.getText() + "°F");
    }

    @FXML
    private void celsiusToFahrenheit(){
        leftComBox.setValue("Celsius");
        leftComBox.setItems(comboBoxList);

        rightComBox.setValue("Fahrenheit");
        rightComBox.setItems(comboBoxList);

        double celsius = Double.valueOf(textField1.getText());
        double fahrenheit= ((celsius * (double) 9 / 5)) + 32;

        if(textField1.getText() == ""){
            textField2.setText("");
        }
        else{
            String strFahrenheit = String.valueOf(fahrenheit);
            textField2.setText(strFahrenheit);
        }
        theFormula.setText("(" + textField1.getText() + "°C x 9/5) + 32 = " + textField2.getText() + "°F");
    }

    @FXML
    private void celsiusToKelvin(){
        leftComBox.setValue("Celsius");
        leftComBox.setItems(comboBoxList);

        rightComBox.setValue("Kelvin");
        rightComBox.setItems(comboBoxList);

        double celsius = Double.valueOf(textField1.getText());
        double kelvin = celsius + 273.15;

        if(textField1.getText() == ""){
            textField2.setText("");
        }
        else{
            String strKelvin = String.valueOf(kelvin);
            textField2.setText(strKelvin);
        }
        theFormula.setText(textField1.getText() + "°C + 273.15 = " + textField2.getText() + "K");
    }


    @FXML
    private void fahrenheitToCelsius(){
        leftComBox.setValue("Fahrenheit");
        leftComBox.setItems(comboBoxList);

        rightComBox.setValue("Celsius");
        rightComBox.setItems(comboBoxList);

        double fahrenheit = Double.valueOf(textField1.getText());
        double celsius= (fahrenheit - 32) * ((double) 5 / 9);

        if(textField1.getText() == ""){
            textField2.setText("");
        }
        else{
            String strCelsius = String.valueOf(celsius);
            textField2.setText(strCelsius);
        }
        theFormula.setText("(" + textField1.getText() + "°F - 32) x 5/9 = " + textField2.getText() + "°C");
    }

    @FXML
    private void fahrenheitToKelvin(){
        leftComBox.setValue("Fahrenheit");
        leftComBox.setItems(comboBoxList);

        rightComBox.setValue("Kelvin");
        rightComBox.setItems(comboBoxList);

        double fahrenheit = Double.valueOf(textField1.getText());
        double kelvin= ((fahrenheit - 32) * ((double) 5 / 9)) + 273.15;

        if(textField1.getText() == ""){
            textField2.setText("");
        }
        else{
            String strKelvin = String.valueOf(kelvin);
            textField2.setText(strKelvin);
        }
        theFormula.setText("(" + textField1.getText() + "°F - 32) x 5/9 + 273.15 = " + textField2.getText() + "K");
    }

    @FXML
    private void kelvinToCelsius(){
        leftComBox.setValue("Kelvin");
        leftComBox.setItems(comboBoxList);

        rightComBox.setValue("Celsius");
        rightComBox.setItems(comboBoxList);

        double kelvin = Double.valueOf(textField1.getText());
        double celsius= kelvin - 273.15;

        if(textField1.getText() == ""){
            textField2.setText("");
        }
        else{
            String strCelsius = String.valueOf(celsius);
            textField2.setText(strCelsius);
        }
        theFormula.setText(textField1.getText() + "K - 273.15 = " + textField2.getText() + "°C");
    }

    @FXML
    private void kelvinToFahrenheit(){
        leftComBox.setValue("Kelvin");
        leftComBox.setItems(comboBoxList);

        rightComBox.setValue("Fahrenheit");
        rightComBox.setItems(comboBoxList);

        double kelvin = Double.valueOf(textField1.getText());
        double fahrenheit= ((kelvin - 273.15) * (double) 9 / 5) + 32;

        if(textField1.getText() == ""){
            textField2.setText("");
        }
        else{
            String strFahrenheit = String.valueOf(fahrenheit);
            textField2.setText(strFahrenheit);
        }
        theFormula.setText("(" + textField1.getText() + "K - 273.15) x 9/5 + 32 = " + textField2.getText() + "°F");
    }

    @FXML
    private void comBox1TemperatureDegreeChoice(){
        if(leftComBox.getValue().equals("Celsius") && rightComBox.getValue().equals("Fahrenheit")){
            celsiusToFahrenheit();
        }
        else if(leftComBox.getValue().equals("Celsius") && rightComBox.getValue().equals("Celsius")){
            rightComBox.setValue("Fahrenheit");
            rightComBox.setItems(comboBoxList);
            celsiusToFahrenheit();
        }
        else if(leftComBox.getValue().equals("Celsius") && rightComBox.getValue().equals("Kelvin")) {
            celsiusToKelvin();
        }
        else if(leftComBox.getValue().equals("Fahrenheit") && rightComBox.getValue().equals("Celsius")){
            fahrenheitToCelsius();
        }
        else if(leftComBox.getValue().equals("Fahrenheit") && rightComBox.getValue().equals("Fahrenheit")){
            rightComBox.setValue("Celsius");
            rightComBox.setItems(comboBoxList);
            fahrenheitToCelsius();
        }
        else if(leftComBox.getValue().equals("Fahrenheit") && rightComBox.getValue().equals("Kelvin")){
            fahrenheitToKelvin();
        }
        else if(leftComBox.getValue().equals("Kelvin") && rightComBox.getValue().equals("Celsius")){
            kelvinToCelsius();
        }
        else if(leftComBox.getValue().equals("Kelvin") && rightComBox.getValue().equals("Fahrenheit")){
            kelvinToFahrenheit();
        }
        else if(leftComBox.getValue().equals("Kelvin") && rightComBox.getValue().equals("Kelvin")){
            rightComBox.setValue("Fahrenheit");
            rightComBox.setItems(comboBoxList);
            kelvinToFahrenheit();
        }
    }

    @FXML
    private void comBox2TemperatureDegreeChoice(){
        if(rightComBox.getValue().equals("Celsius") && leftComBox.getValue().equals("Fahrenheit")){
            fahrenheitToCelsius();
        }
        else if(rightComBox.getValue().equals("Celsius") && leftComBox.getValue().equals("Kelvin")){
            kelvinToCelsius();
        }
        else if(rightComBox.getValue().equals("Celsius") && leftComBox.getValue().equals("Celsius")){
            leftComBox.setValue("Fahrenheit");
            leftComBox.setItems(comboBoxList);
            fahrenheitToCelsius();
        }
        else if(rightComBox.getValue().equals("Fahrenheit") && leftComBox.getValue().equals("Celsius")){
            celsiusToFahrenheit();
        }
        else if(rightComBox.getValue().equals("Fahrenheit") && leftComBox.getValue().equals("Kelvin")){
            kelvinToFahrenheit();
        }
        else if(rightComBox.getValue().equals("Fahrenheit") && leftComBox.getValue().equals("Fahrenheit")){
            leftComBox.setValue("Celsius");
            leftComBox.setItems(comboBoxList);
            celsiusToFahrenheit();
        }
        else if(rightComBox.getValue().equals("Kelvin") && leftComBox.getValue().equals("Celsius")){
            celsiusToKelvin();
        }
        else if(rightComBox.getValue().equals("Kelvin") && leftComBox.getValue().equals("Fahrenheit")){
            fahrenheitToKelvin();
        }
        else if(rightComBox.getValue().equals("Kelvin") && leftComBox.getValue().equals("Kelvin")){
            leftComBox.setValue("Celsius");
            leftComBox.setItems(comboBoxList);
            celsiusToKelvin();
        }
    }
}