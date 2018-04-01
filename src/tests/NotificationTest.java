package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.ignoreStubs;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.internal.progress.ArgumentMatcherStorage;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

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
	
	//Throwing exception
	@Test
	public void shouldReturnMinusOne() throws Exception {
		when(mockNotification.send()).thenThrow(Exception.class);
		NotificationSender ns = new NotificationSenderDefault(mockNotification);
		assertEquals(-1, ns.sendAll());
	}
	
	//Pozwala na pisanie w³aœnych implementacji funkcji
	@Test
	public void methodImplementationTest() throws Exception {
		when(mockNotification.getStatus(Matchers.startsWith("S"))).then(new Answer<Integer>() {

			@Override
			public Integer answer(InvocationOnMock invocation) throws Throwable {
				String str = (String) invocation.getArguments()[0];
				System.out.println("Argument: "+str);
				return 5;
			}
			
		});
		
		//Lambda
		when(mockNotification.getStatus(Matchers.startsWith("B"))).then( i -> {
			String str = (String) i.getArguments()[0];
			System.out.println("Argument: "+str);
			return 5;
		});
		
		
		assertEquals(5, mockNotification.getStatus("Submarine"));
		assertEquals(5, mockNotification.getStatus("Boa Snake"));
	}
	
	
	//Spy
	@Test
	public void spyTest() {
		List<String> list = new ArrayList<>();
		list.add("Foo");
		list.add("Bar");
		List<String> spyList = spy(list);
		when(spyList.size()).thenReturn(50);
		when(spyList.add(Matchers.startsWith("New"))).thenThrow(NullPointerException.class);		
		assertEquals(50, spyList.size());
	}
	
	//Spy
	@Test(expected=NullPointerException.class)
	public void spyTest2() {
		List<String> list = new ArrayList<>();
		list.add("Foo");
		list.add("Bar");
		List<String> spyList = spy(list);
		when(spyList.add(Matchers.startsWith("New"))).thenThrow(NullPointerException.class);			
		spyList.add("New item");
	}
	
	@Test
	public void spyTestClass() {
		Random rand = new Random();
		Random spyRandom = spy(rand);
		when(spyRandom.nextInt(5)).thenReturn(100);
		assertEquals(100, spyRandom.nextInt(5));
	}
	
	@Test
	public void verifyTestClass() throws Exception {
	
		mockNotification.getStatus("Artur");
		mockNotification.getStatus("Sebastian");
		mockNotification.getStatus("Bike");
		mockNotification.getStatus("Source");
		
		verify(mockNotification, times(2)).getStatus(Matchers.startsWith("S"));
		verify(mockNotification, times(3)).getStatus(Matchers.contains("e"));
	}
}

 
