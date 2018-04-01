package tests;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;

import static org.hamcrest.CoreMatchers.*;
//import static org.hamcrest.number.OrderingComparison;


/**
 * 'Hamcrest matchers is a personal preference. What Hamcrest gives
	you that standard assertions don’t provide is a human-readable description of an
	assertion failure.'
 * @author artur
 *

	BLACK BOX TEST: U¯YWAMY JEDYNIE ZEWNÊTRZNEGO API OBIEKTU DO TESTOWANIA, (UZAJEMY ¯E) NIE ZNAMY IMPLEMENTACJI OBIEKTU I ZACHOWUJEMY SIÊ JAK KLIENT TEGO API

	WHITE BOX TEST: ZNAMY IMPLEMENTACJE OBIEKTU, KTÓRY TESTUJEMY I TESTUJEMY GO ZE ŒWIADOMOŒCI¥ JAK DZIA£A KOD WEWN¥TRZ.


 */

public class HarmcestTest {
	
	private List<String> list;
	
	@Before
	public void initializeVars() {
		list = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			list.add("element: " + i);
		}
	}
	
	@Test
	public void shouldContain() {
		assertThat(list, hasItem(anyOf(equalTo("element: 1"), equalTo("two"),
				equalTo("three"))));
	}
	
	@Test
	public void shouldNotNull() {
		assertThat(list, notNullValue());
	}
	
//	@Test
//	public void shouldSizeGreater() {
//		org.hamcrest.CoreMatchers.
//		assertThat(list.size(), greaterThan(5));
//	}

}
