package com.synonym.ord.core;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.synonym.ord.core.model.Player;
import com.synonym.ord.core.service.PlayerService;
import com.synonym.ord.persistence.PlayerDAO;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class PlayerServiceTest {

	private PlayerService ps;
	@Mock @Qualifier("getTestPlayerDAO") private PlayerDAO playDAO;
	private Player player = new Player("Gunnar");

	@Before
	public void before(){
		ps = new PlayerService(playDAO);
	}

	@Test
	public void shouldAddPlayer() throws Exception {
		ps.addPlayer(player);

		verify(playDAO).addPlayer(player);
	}

	@Test
	public void shouldAddPlayerIfPlayerDoesntExist() throws Exception {
		when(playDAO.getPlayer(player.getName())).thenReturn(null);
		ps.addPlayer(player);

		verify(playDAO).addPlayer(player);
	}

	@Test
	public void shouldUpdatePlayerIfPlayerExcist() throws Exception {
		when(playDAO.getPlayer(player.getName())).thenReturn(player);
		ps.addPlayer(player);
		
		verify(playDAO).updatePlayer(player);
	}

}
