package Service;

import Service.Custom.Impl.bookImpl;

public class subFacutory {
    private static subFacutory factory;


    private subFacutory(){}
    
    public static subFacutory getInstance(){
        if(factory  == null){
            factory = new subFacutory();
        }
        
        return factory;
    
    }
    
    public SuperService getservice(serviceType type){
        switch (type) {
            case BOOK:
                return  new bookImpl();
            
            default:
                 return null;
        }
    }
    public enum  serviceType{
        BOOK
    }
}
