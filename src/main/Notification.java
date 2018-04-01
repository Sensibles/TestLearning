package main;

public interface Notification {
	
	int send() throws Exception;
	
	int getStatus(String status) throws Exception;

}
