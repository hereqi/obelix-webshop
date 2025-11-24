package ch.bbw.obelix.webshop.config;

import ch.bbw.obelix.quarry.api.QuarryApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class QuarryClientConfig {

	@Bean
	WebClient quarryWebClient(@Value("${quarry.base-url}") String baseUrl) {
		return WebClient.builder().baseUrl(baseUrl).build();
	}

	@Bean
	QuarryApi quarryClient(WebClient quarryWebClient) {
		// KI Hilfe: builderFor(adapter) statt create().
		var adapter = WebClientAdapter.create(quarryWebClient);
		var factory = HttpServiceProxyFactory.builderFor(adapter).build();
		return factory.createClient(QuarryApi.class);
	}
}


