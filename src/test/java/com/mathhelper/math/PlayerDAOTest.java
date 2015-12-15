package com.mathhelper.math;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.mathhelper.math.core.model.Player;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class PlayerDAOTest {
	
	@Autowired private PlayerDAO playerDAO;
			
	
	@Test
	public void shouldReturnPlayer() throws Exception {
		Player player = new Player("Linda");
		
		playerDAO.addPlayer(player);
		Player returned = playerDAO.getPlayer("Linda");
		
		assertEquals(player.getName(), returned.getName());
	}
}
