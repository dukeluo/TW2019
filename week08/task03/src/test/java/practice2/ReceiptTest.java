package practice2;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ReceiptTest {

    @Test
    public void should_get_correct_grand_total() throws Exception {
        //Given
        Receipt receipt = new Receipt();
        List<Product> products = asList(new Product(123,100, 0.2),
                new Product(222,50, 0.1),
                new Product(345,80, 0.2),
                new Product(656,90, 0.1));

        List<OrderItem> productCounts = asList(new OrderItem(123, 1),
                new OrderItem(222, 2),
                new OrderItem(345, 1),
                new OrderItem(656, 3));

        //When
        double grandTotal = receipt.CalculateGrandTotal(products, productCounts);
        double expectedTotal = 524.7;

        //Then
        assertThat(grandTotal, is(expectedTotal));
    }
}