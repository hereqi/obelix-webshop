package ch.bbw.obelix.quarry.controller;

import ch.bbw.obelix.quarry.api.QuarryApi;
import ch.bbw.obelix.quarry.api.dto.MenhirDto;
import ch.bbw.obelix.quarry.entity.MenhirEntity;
import ch.bbw.obelix.quarry.repository.MenhirRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class QuarryController implements QuarryApi {

	private final MenhirRepository menhirRepository;

	public QuarryController(MenhirRepository menhirRepository) {
		this.menhirRepository = menhirRepository;
	}

	@Override
	public List<MenhirDto> getAllMenhirs() {
		return menhirRepository.findAll().stream().map(MenhirEntity::toDto).toList();
	}

	@Override
	public MenhirDto getMenhirById(UUID menhirId) {
		return menhirRepository.findById(menhirId)
				.map(MenhirEntity::toDto)
				.orElseThrow(() -> new RuntimeException("unknown menhir with id " + menhirId));
	}

	@Override
	public void deleteById(UUID menhirId) {
		menhirRepository.deleteById(menhirId);
	}
}


