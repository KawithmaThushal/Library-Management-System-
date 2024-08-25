package Service;

import Service.Custom.Impl.bookImpl;
import Service.Custom.Impl.bookreturncustmimpl;
import Service.Custom.Impl.homeServiceImpl;
import Service.Custom.Impl.loginServiceimpl;
import Service.Custom.Impl.memberimpl;
import Service.Custom.Impl.releasebookimpl;

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

            case MEMBER:
            return   new memberimpl();
            case RELEASE:
            return   new releasebookimpl();
            case RETURN:
            return new bookreturncustmimpl();

            case LOGIN:
            return new loginServiceimpl();

            case HOME:
            return new homeServiceImpl();
            default:
                 return null;
        }
    }
    public enum  serviceType{
        BOOK,
        MEMBER,
        RELEASE,
        RETURN,
        LOGIN,
        HOME
       
    }
}
