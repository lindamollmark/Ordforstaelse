package com.mathhelper.math.persistence;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mathhelper.math.core.model.Player;
import com.mathhelper.math.persistence.PlayerDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class PlayerDAOTest {
	
	@Autowired
	@Qualifier("getTestPlayerDAO")
	private PlayerDAO playerDAO;
	
	private Player player;
	
	@Before
	public void before(){
		player = new Player("Fred");
	}		
	
	@Test
	public void shouldAddAndReturnPlayer() throws Exception {		
		playerDAO.addPlayer(player);
		Player returned = getPlayer(player.getName());
		
		assertEquals(player.getName(), returned.getName());
	}

	private Player getPlayer(String name) {
		return playerDAO.getPlayer(name);
	}
	
	@Test
	public void shouldUpdatePlayer() throws Exception {

		playerDAO.addPlayer(player);
		Player returned = getPlayer(player.getName());
		returned.setName("Fredag");
		playerDAO.updatePlayer(returned);
		
		Player updated = getPlayer(returned.getName());
		
		assertEquals(returned.getId(), updated.getId());
		assertEquals(returned.getName(), updated.getName());
		
	}
}
