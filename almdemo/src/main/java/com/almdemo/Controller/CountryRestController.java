package com.almdemo.Controller;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.almdemo.domain.Country;

@RestController
public class CountryRestController {
	
                  @RequestMapping(path = "/wb/getCountry", method= RequestMethod.GET)
                  public List<Country> getData(@PathVariable("ctcode") String  ctcode) {
                	  
                	  RestTemplate restTemplate = new RestTemplate(); 
          			ResponseEntity<List<Country>> countryResponse = restTemplate.exchange(
          					"http://api.worldbank.org/v2/country?format=json", 
          					HttpMethod.GET,
          					null,
          					new ParameterizedTypeReference<List<Country>>() {});
          			List<Country> list=countryResponse.getBody();
          			if(ctcode!=null && !ctcode.equalsIgnoreCase(""))
          			{
          				
          				List<Country> result = (List<Country>) list.stream()
          						 .filter(x -> ctcode.equals(x.getCode())) 
          						.findAny()
          						 .orElse(null);  
                    		return result;
          			}
          			  return list;
                  }
                  
}
