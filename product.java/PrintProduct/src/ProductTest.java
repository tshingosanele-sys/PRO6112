
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class productTest {

    @Test

    public void GetTotalProductSales_WithValidData_ReturnsCorrectValue() {

        product product = new product("Laptop", 10);

        assertEquals(10, product.getTotalproductSales());

    }

    @Test

    public void GetAverageSales_WithValidData_ReturnsCorrectValue() {

        Product product = new Product("Laptop", 10);

        assertEquals(10.0, product.getAverageSales(), 0.01);

    }

}