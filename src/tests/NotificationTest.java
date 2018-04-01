package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import main.Notification;
import main.NotificationSender;
import main.NotificationSenderDefault;

@RunWith(MockitoJUnitRunner.class)
public class NotificationTest {

	@Mock
	Notification mockNotification;
	
	
	@Test
	public void shouldReturnOne() throws Exception {
		when(mockNotification.send()).thenReturn(1);
		NotificationSender ns = new NotificationSenderDefault(mockNotification);
		assertEquals(1, ns.sendAll());
	}
	
	@Test
	public void shouldReturnMinusOne() throws Exception {
		when(mockNotification.send()).thenThrow(Exception.class);
		NotificationSender ns = new NotificationSenderDefault(mockNotification);
		assertEquals(-1, ns.sendAll());
	}
}
