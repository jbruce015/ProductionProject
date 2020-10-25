import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SelectionModel;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    @FXML
    private Button getProduct;

    @FXML
    private ComboBox<String> typeBox;

    @FXML
    //Creating an event handler to button click event to print out added product
    public void addProduct(ActionEvent actionEvent) {
       System.out.println("Product added");
    }
    @FXML
    //Creating an event handler to button click event to print out recorded Production
    public void recordProduction(ActionEvent actionEvent) {
        System.out.println("Production recorded");
    }


    //Initialize method to populate choices in ComboBox
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        typeBox.getItems().addAll("1","2","3","4","5","6","7","8","9","10");
        typeBox.setEditable(true);
        typeBox.getSelectionModel().selectFirst();
    }

    public void initialize(){
        connectToDatabase();

    }

    public void connectToDatabase() {
        final String JDBC_DRIVER = "org.h2.Driver";
        final String DB_URL = "jdbc:h2:./res/H2PP";

        //  Database credentials
        final String USER = "";
        final String PASS = "";
        Connection conn = null;
        Statement stmt = null;

        String productType = "Audio";
        String productManufacturer = "Apple";
        String productName = "Ipod";

        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 3: Execute a query
            System.out.println("Adding product");

            final String sql = "INSERT INTO Product(type, manufacturer, name) VALUES ( ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, productType);
            ps.setString(2, productManufacturer);
            ps.setString(3, productName);

            ps.executeUpdate();
            System.out.println(" Product added");

            // STEP 4: Clean-up environment
            stmt.close();
            conn.close();



        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}

