package Day02_BasicJDBC_ProductRetrieve;

public class ProductNotFoundException extends Exception{
    ProductNotFoundException(String message){
        super(message);
    }
    ProductNotFoundException(){
        super("Not Found");
    }
}
