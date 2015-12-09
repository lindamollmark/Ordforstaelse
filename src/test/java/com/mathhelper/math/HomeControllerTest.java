package com.mathhelper.math;

import static org.mockito.Mockito.verify;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.Model;

import com.mathhelper.math.controller.HomeController;
import com.mathhelper.math.core.Player;

@RunWith(MockitoJUnitRunner.class)
public class HomeControllerTest {

	private HomeController homeController;
	@Mock Player player;
	
	@Test
	@Ignore
	public void shouldsavePlayerName() throws Exception {
		homeController = new HomeController();
		Model model;
		
		 homeController.gameSite("Arne", null);
		
		verify(player).setPlayer("Arne");
		
	}
	
	
	
}
