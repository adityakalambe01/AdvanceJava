package BasicJDBC_02;

public class ProductNotFoundException extends Exception{
    ProductNotFoundException(String message){
        super(message);
    }
    ProductNotFoundException(){
        super("Not Found");
    }
}
