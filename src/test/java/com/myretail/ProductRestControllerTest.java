package com.myretail;

import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myretail.product.ProductService;

public class ProductRestControllerTest {

	private static final int UNKNOWN_ID = Integer.MAX_VALUE;

	private MockMvc mockMvc;

	@Mock
	private ProductService productService;

	@InjectMocks
	private ProductRestController productRestController;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(productRestController).build();
	}

	// =========================================== Get All Users
	// ==========================================

	// @Test
	// public void test_get_all_success() throws Exception {
	//
	// Price price1 = new Price();
	// price1.setCurrency_code("USD");
	// price1.setValue( 9.99);
	// Price price2 = new Price();
	// price2.setCurrency_code("USD");
	// price2.setValue(12.99);
	//
	// Product product1 = new Product(100000, "Daenerys Targaryen");
	// Product product2 = new Product(200000, "John Snow");
	//
	// product1.setPrice(price1);
	// product2.setPrice(price2);
	////
	//// when(productService.getByProductId(100000)).thenReturn(product1);
	////
	//// mockMvc.perform(get("/api/v1/products/100000")).andExpect(status().isOk())
	//// .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
	//// .andExpect(jsonPath("$.id ", is(100000))).andExpect(jsonPath("$.name",
	// is("Daenerys Targaryen")))
	//// .andExpect(jsonPath("$.current_price.currency_code",
	// is("USD"))).andExpect(jsonPath("$.current_price.value", is(9.99)));
	////
	//// when(productService.getByProductId(200000)).thenReturn(product2);
	//// mockMvc.perform(get("/api/v1/products/200000")).andExpect(status().isOk())
	//// .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
	//// .andExpect(jsonPath("$.id ", is(200000))).andExpect(jsonPath("$.name",
	// is("John Snow")))
	//// .andExpect(jsonPath("$.current_price.currency_code", is("USD")))
	//// .andExpect(jsonPath("$.current_price.value", is(12.99)));
	//
	//// verifyNoMoreInteractions(productService);
	// }

	//
	// @Test
	// public void test_get_by_id_fail_404_not_found() throws Exception {
	//
	// when(productService.getByProductId(1)).thenThrow(new
	// PriceServiceException(1001)) ;
	//
	// mockMvc.perform(get("/api/v1/products/{id}", 1))
	// .andExpect(new PriceServiceException(1001));
	//
	// // verify(productService, times(1)).getByProductId(1);
	// verifyNoMoreInteractions(productService);
	// }
	//

	// =========================================== Get User By ID
	// =========================================

	/*
	 * @Test public void test_get_by_id_success() throws Exception { User user =
	 * new User(1, "Daenerys Targaryen");
	 * 
	 * when(productService.findById(1)).thenReturn(user);
	 * 
	 * mockMvc.perform(get("/users/{id}", 1)) .andExpect(status().isOk())
	 * .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
	 * .andExpect(jsonPath("$.id", is(1))) .andExpect(jsonPath("$.username",
	 * is("Daenerys Targaryen")));
	 * 
	 * verify(productService, times(1)).findById(1);
	 * verifyNoMoreInteractions(productService); }
	 * 
	 * @Test public void test_get_by_id_fail_404_not_found() throws Exception {
	 * 
	 * when(productService.findById(1)).thenReturn(null);
	 * 
	 * mockMvc.perform(get("/users/{id}", 1)) .andExpect(status().isNotFound());
	 * 
	 * verify(productService, times(1)).findById(1);
	 * verifyNoMoreInteractions(productService); }
	 * 
	 * // =========================================== Create New User
	 * ========================================
	 * 
	 * @Test public void test_create_user_success() throws Exception { User user
	 * = new User("Arya Stark");
	 * 
	 * when(productService.exists(user)).thenReturn(false);
	 * doNothing().when(productService).create(user);
	 * 
	 * mockMvc.perform( post("/users") .contentType(MediaType.APPLICATION_JSON)
	 * .content(asJsonString(user))) .andExpect(status().isCreated())
	 * .andExpect(header().string("location",
	 * containsString("http://localhost/users/")));
	 * 
	 * verify(productService, times(1)).exists(user); verify(productService,
	 * times(1)).create(user); verifyNoMoreInteractions(productService); }
	 * 
	 * @Test public void test_create_user_fail_409_conflict() throws Exception {
	 * User user = new User("username exists");
	 * 
	 * when(productService.exists(user)).thenReturn(true);
	 * 
	 * mockMvc.perform( post("/users") .contentType(MediaType.APPLICATION_JSON)
	 * .content(asJsonString(user))) .andExpect(status().isConflict());
	 * 
	 * verify(productService, times(1)).exists(user);
	 * verifyNoMoreInteractions(productService); }
	 * 
	 * // =========================================== Update Existing User
	 * ===================================
	 * 
	 * @Test public void test_update_user_success() throws Exception { User user
	 * = new User(1, "Arya Stark");
	 * 
	 * when(productService.findById(user.getId())).thenReturn(user);
	 * doNothing().when(productService).update(user);
	 * 
	 * mockMvc.perform( put("/users/{id}", user.getId())
	 * .contentType(MediaType.APPLICATION_JSON) .content(asJsonString(user)))
	 * .andExpect(status().isOk());
	 * 
	 * verify(productService, times(1)).findById(user.getId());
	 * verify(productService, times(1)).update(user);
	 * verifyNoMoreInteractions(productService); }
	 * 
	 * @Test public void test_update_user_fail_404_not_found() throws Exception
	 * { User user = new User(UNKNOWN_ID, "user not found");
	 * 
	 * when(productService.findById(user.getId())).thenReturn(null);
	 * 
	 * mockMvc.perform( put("/users/{id}", user.getId())
	 * .contentType(MediaType.APPLICATION_JSON) .content(asJsonString(user)))
	 * .andExpect(status().isNotFound());
	 * 
	 * verify(productService, times(1)).findById(user.getId());
	 * verifyNoMoreInteractions(productService); }
	 * 
	 * // =========================================== Delete User
	 * ============================================
	 * 
	 * @Test public void test_delete_user_success() throws Exception { User user
	 * = new User(1, "Arya Stark");
	 * 
	 * when(productService.findById(user.getId())).thenReturn(user);
	 * doNothing().when(productService).delete(user.getId());
	 * 
	 * mockMvc.perform( delete("/users/{id}", user.getId()))
	 * .andExpect(status().isOk());
	 * 
	 * verify(productService, times(1)).findById(user.getId());
	 * verify(productService, times(1)).delete(user.getId());
	 * verifyNoMoreInteractions(productService); }
	 * 
	 * @Test public void test_delete_user_fail_404_not_found() throws Exception
	 * { User user = new User(UNKNOWN_ID, "user not found");
	 * 
	 * when(productService.findById(user.getId())).thenReturn(null);
	 * 
	 * mockMvc.perform( delete("/users/{id}", user.getId()))
	 * .andExpect(status().isNotFound());
	 * 
	 * verify(productService, times(1)).findById(user.getId());
	 * verifyNoMoreInteractions(productService); }
	 * 
	 * // =========================================== CORS Headers
	 * ===========================================
	 * 
	 * @Test public void test_cors_headers() throws Exception {
	 * mockMvc.perform(get("/users"))
	 * .andExpect(header().string("Access-Control-Allow-Origin", "*"))
	 * .andExpect(header().string("Access-Control-Allow-Methods",
	 * "POST, GET, PUT, OPTIONS, DELETE"))
	 * .andExpect(header().string("Access-Control-Allow-Headers", "*"))
	 * .andExpect(header().string("Access-Control-Max-Age", "3600")); }
	 * 
	 */
	/*
	 * converts a Java object into JSON representation
	 */

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}