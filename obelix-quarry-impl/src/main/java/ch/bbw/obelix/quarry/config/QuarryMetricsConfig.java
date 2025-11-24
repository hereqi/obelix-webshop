package ch.bbw.obelix.quarry.config;

import ch.bbw.obelix.quarry.repository.MenhirRepository;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.binder.MeterBinder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuarryMetricsConfig {

	@Bean
	MeterBinder menhirCountGauge(MenhirRepository menhirRepository) {
		// KI Hilfe: Gauge via Repository::count (aktuelle DB-Stand).
		return registry -> Gauge.builder("obelix.menhir.count", menhirRepository, MenhirRepository::count)
				.description("Anzahl Hinkelsteine")
				.register(registry);
	}
}


