import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class Controller {

    @FXML
    private Label lblOutput;
    @FXML
    private Button addProduct, recordProduction;

    public void sayHello() {
        lblOutput.setText("Hello FXML!");

    }
    //Creating an event handler to button click event to print out "Add product"
    public void addProduct(javafx.event.ActionEvent actionEvent) {
        System.out.println("Add Product");
    }
    //Creating an event handler to button click event to print out "Record Production"
    public void recordProduction(ActionEvent actionEvent) {
        System.out.println("Record Production");
    }
}