package main;

public class SmsNotification implements Notification {

	@Override
	public int send() throws Exception {
		System.out.println("SMS Sent!");
		return 1;
	}

	@Override
	public int getStatus(String status) throws Exception {
		System.out.println("Status: "+status);
		return 1;
	}

}
