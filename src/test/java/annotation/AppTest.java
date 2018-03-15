package annotation;

import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;

import com.annotation.demo.Product;


/**
 * Unit test for simple App.
 */

public class AppTest  {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	private Validator validator;
	 
    @Before
    public void setUp() throws Exception {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }
	
	@Test
	public void testStoreNumber(){
		Product product = new Product();
		product.setStoreNumber("12345");
		// when
        Set<ConstraintViolation<Product>> violations = validator.validate(product);
        // then
        assertEquals(1, violations.size());
        product.setStoreNumber("1234");
        Set<ConstraintViolation<Product>> violation1 = validator.validate(product);
        assertEquals(0, violation1.size());
        
        product.setStoreNumber("");
        Set<ConstraintViolation<Product>> violation2 = validator.validate(product);
        assertEquals(1, violation2.size());
        
	}
	
}
