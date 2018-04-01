package main;

public class NotificationSenderDefault implements NotificationSender {
	
	private Notification n;
	
	public NotificationSenderDefault(Notification n) {
		this.n = n;
	}

	@Override
	public int sendAll() {
		int result;
		try {
			result = n.send();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
		return result;
	}

}
