package main;

public class SmsNotification implements Notification {

	@Override
	public int send() throws Exception {
		System.out.println("SMS Sent!");
		return 1;
	}

}
