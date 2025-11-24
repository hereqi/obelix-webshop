package ch.bbw.obelix.quarry.api;

import ch.bbw.obelix.quarry.api.dto.MenhirDto;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;
import java.util.UUID;

@HttpExchange
public interface QuarryApi {
	@GetExchange("/api/menhirs")
	List<MenhirDto> getAllMenhirs();

	@GetExchange("/api/menhirs/{menhirId}")
	MenhirDto getMenhirById(UUID menhirId);

	@DeleteExchange("/api/quarry/{menhirId}")
	void deleteById(UUID menhirId);
}
