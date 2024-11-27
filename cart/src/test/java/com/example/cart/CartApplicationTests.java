package com.example.cart;


import com.example.cart.model.CartItem;
import com.example.cart.repository.CartRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@SpringBootTest
@AutoConfigureMockMvc
class CartApplicationTests {
//
//	@Autowired
//	private MockMvc mockMvc;
//
//	@Autowired
//	private CartRepository cartRepository;
//
//	@Test
//	public void testAddItem() throws Exception {
//		String cartItemJson = "{\"product\": \"Book\", \"quantity\": 2}";
//		mockMvc.perform(post("/cart/add")
//						.contentType(MediaType.APPLICATION_JSON)
//						.content(cartItemJson))
//				.andExpect(status().isOk())
//				.andExpect(jsonPath("$.product").value("Book"))
//				.andExpect(jsonPath("$.quantity").value(2));
//	}
//
//	@Test
//	public void testGetItem() throws Exception {
//		CartItem item = new CartItem();
//		item.setProduct("Laptop");
//		item.setQuantity(1);
//		cartRepository.save(item);
//
//		mockMvc.perform(get("/cart/" + item.getId()))
//				.andExpect(status().isOk())
//				.andExpect(jsonPath("$.product").value("Laptop"))
//				.andExpect(jsonPath("$.quantity").value(1));
//	}


}
