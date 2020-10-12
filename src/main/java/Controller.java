import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Controller {

    public void initializeDataBase() {
        final String JDBC_DRIVER = "org.h2.Driver";
        final String DB_URL = "jdbc:h2:./resources/H2PP";

        //  Database credentials
        final String USER = "";
        final String PASS = "";
        Connection conn = null;
        Statement stmt = null;

        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 3: Execute a query
            stmt = conn.createStatement();

            String sql = "SELECT * FROM PRODUCT";

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }

            // STEP 4: Clean-up environment
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private Label lblOutput;
    @FXML
    private Button addProduct, recordProduction;

    public void sayHello() {
        lblOutput.setText("Hello FXML!");

    }

    //Creating an event handler to button click event to print out added product
    public void addProduct(javafx.event.ActionEvent actionEvent) {
        System.out.println("Product added");
    }

    //Creating an event handler to button click event to print out recorded Production
    public void recordProduction(ActionEvent actionEvent) {
        System.out.println("Production recorded");
    }
}

