package com.pinapoll.tests;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import com.pinapoll.models.Poll;

public class PinaPollTests {
	
	@Test
	public void SimplePollModelTest() {
		
		Poll publicPoll = new Poll();
		publicPoll.setId(0);
		publicPoll.setIsPublic(true);
		
		Poll privatePoll = new Poll();
		privatePoll.setId(1);
		privatePoll.setIsPublic(false);
		
		assertNotEquals(privatePoll.getIsPublic(), publicPoll.getIsPublic());
	}
	
	

}
