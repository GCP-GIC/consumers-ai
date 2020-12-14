package com.cts.consumers.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "recommendationsClient", url = "https://recommendations-ai-dot-global-innovation54-1000310224.ue.r.appspot.com")
public interface RecommendationsClient {

	@RequestMapping(method = RequestMethod.GET, value = "/v1/hello")
	ResponseEntity<String> hello();
}
