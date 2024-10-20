package com.potato.recipe;import org.junit.jupiter.api.BeforeEach;import org.junit.jupiter.api.Test;import org.springframework.boot.test.context.SpringBootTest;import static org.mockito.Mockito.mock;@SpringBootTestclass RecipeApplicationTests {	private UserTests userTests;	private RecipeTests recipeTests;	@BeforeEach	void setUp() {		userTests = mock(UserTests.class);		recipeTests = mock(RecipeTests.class);	}	@Test	void testUserScenario() {		userTests.testDuplicate_whenUserIsDuplicate();		userTests.testSignUp();		userTests.testLogin();	}}