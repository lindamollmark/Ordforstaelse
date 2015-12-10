package com.mathhelper.math;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.Model;

import com.mathhelper.math.controller.HomeController;
import com.mathhelper.math.core.model.Player;

@RunWith(MockitoJUnitRunner.class)
public class HomeControllerTest {

	private HomeController homeController;
	@Mock private Player player;
	private String name;
	private ModelClass model;
	
	@Before
	public void before(){
		homeController = new HomeController();
		name = "Arne";	
		model = new ModelClass();
		homeController.gameSite(name, model);
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
