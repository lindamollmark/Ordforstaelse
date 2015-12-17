package com.mathhelper.math.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.Model;

import com.mathhelper.math.core.model.Player;
import com.mathhelper.math.core.service.PlayerService;

@RunWith(MockitoJUnitRunner.class)
public class HomeControllerTest {

	private HomeController homeController;
	@Mock private Player player;
	private String name;
	private ModelClass model;
	@Mock private HttpServletRequest request;
	@Mock private HttpSession session;
	@Mock private PlayerService ps;
	 
	@Before
	public void before(){
		homeController = new HomeController(ps);
		name = "Arne";	
		model = new ModelClass();
		when(ps.addPlayer(Matchers.anyObject())).thenReturn(player);
		when(request.getSession()).thenReturn(session);
		doNothing().doThrow(new RuntimeException()).when(session).setAttribute(Matchers.anyString(), Matchers.anyObject());

		homeController.gameSite(name, model, request);
		
	}

	@Test
	public void shouldSetPlayerNameToAttribute() throws Exception {

		assertEquals(name, model.getAttribute("playerName"));
	}

	private static class ModelClass implements Model{

		Map<String, Object> modelAttribute = new HashMap<>();

		@Override
		public Model addAttribute(String attributeName, Object attributeValue) {
			modelAttribute.put(attributeName, attributeValue);
			return null;
		}

		@Override
		public Model addAttribute(Object attributeValue) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Model addAllAttributes(Collection<?> attributeValues) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Model addAllAttributes(Map<String, ?> attributes) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Model mergeAttributes(Map<String, ?> attributes) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean containsAttribute(String attributeName) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Map<String, Object> asMap() {
			// TODO Auto-generated method stub
			return null;
		}
		public String getAttribute(String attributeName){
			Object attribute = modelAttribute.get(attributeName);

			return attribute.toString();
		}
	}

}
