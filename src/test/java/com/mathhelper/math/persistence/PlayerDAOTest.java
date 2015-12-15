package com.mathhelper.math.persistence;

import static org.junit.Assert.assertEquals;

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
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class PlayerDAOTest {
	
	@Autowired
	@Qualifier("getTestPlayerDAO")
	private PlayerDAO playerDAO;
	
	@Before
	public void before(){
	}		
	
	@Test
	public void shouldReturnPlayer() throws Exception {
		Player player = new Player("Fred");
		
		playerDAO.addPlayer(player);
		Player returned = playerDAO.getPlayer("Fred");
		
		assertEquals(player.getName(), returned.getName());
	}
}
