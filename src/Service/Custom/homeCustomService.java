package Service.Custom;

import Service.SuperService;

public interface homeCustomService extends SuperService{
    
    int getTotalBooks() throws Exception; 
    int getOverdueBook() throws Exception; 
    int getbarrowedbook() throws Exception; 
}
