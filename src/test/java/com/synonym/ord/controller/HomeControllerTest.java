package com.synonym.ord.controller;

import com.synonym.ord.core.model.Player;
import com.synonym.ord.core.service.PlayerService;
import com.synonym.ord.core.service.WordService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HomeControllerTest {

	@Mock private Player player;
	private String name;
	private ModelClass model;
	@Mock private HttpServletRequest request;
	@Mock private HttpSession session;
	@Mock private PlayerService ps;
	@Mock
	private WordService wordService;
	 
	@Before
	public void before(){
		final HomeController homeController = new HomeController(ps, wordService);
        name = "Arne";
		model = new ModelClass();
		when(ps.addPlayer(Matchers.anyObject())).thenReturn(player);
		when(request.getSession()).thenReturn(session);
		doNothing().doThrow(new RuntimeException()).when(session).setAttribute(Matchers.anyString(), Matchers.anyObject());

		homeController.gameSite(name, model, request);
	}

	@Test
    public void shouldSetPlayerNameToAttribute() {

		assertEquals(name, model.getAttribute("playerName"));
	}

	private static class ModelClass implements Model{

        private Map<String, Object> modelAttribute = new HashMap<>();

		@Override
        public Model addAttribute(final String attributeName, Object attributeValue) {
			modelAttribute.put(attributeName, attributeValue);
			return null;
		}

		@Override
        public Model addAttribute(final Object attributeValue) {
			return null;
		}

		@Override
        public Model addAllAttributes(final Collection<?> attributeValues) {
			return null;
		}

		@Override
        public Model addAllAttributes(final Map<String, ?> attributes) {
			return null;
		}

		@Override
        public Model mergeAttributes(final Map<String, ?> attributes) {
			return null;
		}

		@Override
        public boolean containsAttribute(final String attributeName) {
			return false;
		}

		@Override
		public Map<String, Object> asMap() {
			return null;
		}

        private String getAttribute(final String attributeName) {
			Object attribute = modelAttribute.get(attributeName);
			return attribute.toString();
		}
	}

}
