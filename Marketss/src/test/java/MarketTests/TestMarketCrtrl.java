package MarketTests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.market.model.Market;
import com.market.restcontroler.MarketControler;
import com.market.service.MarketService;



@RunWith(SpringRunner.class)
@WebMvcTest(value = MarketControler.class)

public class TestMarketCrtrl {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private MarketService mService;

	Market mockMarket = new Market(5,8);


	@Test
	public void getMarketById() throws Exception {

		Mockito.when(
				mService.getMarketById(Mockito.anyInt())).thenReturn(mockMarket);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/getMarketId/10").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		
	}
	
	


}