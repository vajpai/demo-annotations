package annotation;

import java.lang.reflect.Method;

import javax.validation.Configuration;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.annotation.demo.Product;
import com.annotation.demo.StoreNumber;

/**
 * 
 * @see https://github.com/danielolszewski/blog/tree/master/spring-custom-validation
 * @see https://www.logicbig.com/tutorials/java-ee-tutorial/bean-validation/create-custom-constraint.html
 * @see http://dolszewski.com/java/custom-validation-annotation-for-multiple-types/
 */
public class App {
	
	private static void printError (
            ConstraintViolation<Product> violation) {
			System.out.println(violation.getPropertyPath() + " " + violation.getMessage());
	}
	
	public static void main(String[] args) {
		//Validate the annotations
		Product product = new Product();
		product.setStoreNumber("1234");
		Configuration<?> config = Validation.byDefaultProvider().configure();
        ValidatorFactory factory = config.buildValidatorFactory();
        Validator validator = factory.getValidator();
        validator.validate(product).stream().forEach(App::printError);
        factory.close();
		
        // read annotations
		Class<Product> productClass = Product.class;
		if (productClass.isAnnotationPresent(StoreNumber.class)) {
			StoreNumber storeNumber = (StoreNumber) productClass.getAnnotation(StoreNumber.class);
			System.out.println("Store Number:" + storeNumber.message());
		} else {
			System.out.println("---annotation not present in the class level----");
		}

		Method[] methods = productClass.getMethods();
		for (Method method : methods) {
			StoreNumber storeNumberannotation = method.getAnnotation(StoreNumber.class);
			if (null != storeNumberannotation) {
				System.out.println("Method Level Annotation==>" + storeNumberannotation.message());
			}
		}
	}
}
