package com.pinapoll.tests;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pinapoll.models.Poll;

@RunWith(SpringRunner.class)
@SpringBootTest
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
