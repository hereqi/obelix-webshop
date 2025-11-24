package ch.bbw.obelix.quarry.config;

import ch.bbw.obelix.quarry.entity.MenhirEntity;
import ch.bbw.obelix.quarry.repository.MenhirRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class QuarryDataInitializer {

	private final MenhirRepository menhirRepository;

	public QuarryDataInitializer(MenhirRepository menhirRepository) {
		this.menhirRepository = menhirRepository;
	}

	@PostConstruct
	public void initializeMenhirs() {
		if (menhirRepository.count() == 0) {
			createDefaultMenhirs();
		}
	}

	private void createDefaultMenhirs() {
		menhirRepository.deleteAll();

		var obelixSpecial = new MenhirEntity();
		obelixSpecial.setWeight(2.5);
		obelixSpecial.setStoneType("Granite Gaulois");
		obelixSpecial.setDecorativeness(MenhirEntity.Decorativeness.DECORATED);
		obelixSpecial.setDescription("Obelix's personal favorite! Perfect for throwing at Romans. ");
		menhirRepository.save(obelixSpecial);

		var getafixMasterpiece = new MenhirEntity();
		getafixMasterpiece.setWeight(4.2);
		getafixMasterpiece.setStoneType("Mystical Dolmen Stone");
		getafixMasterpiece.setDecorativeness(MenhirEntity.Decorativeness.MASTERWORK);
		getafixMasterpiece.setDescription("Blessed by Getafix himself! This menhir is rumored to " +
				"enhance magic potion brewing. Side effects may include: sudden urge to fight Romans.");
		menhirRepository.save(getafixMasterpiece);

		var touristTrap = new MenhirEntity();
		touristTrap.setWeight(1.0);
		touristTrap.setStoneType("Imported Roman Marble");
		touristTrap.setDecorativeness(MenhirEntity.Decorativeness.PLAIN);
		touristTrap.setDescription("Budget-friendly option! Made from 'liberated' Roman materials. " +
				"Perfect for beginners or those who just want to annoy Caesar. Asterix approved!");
		menhirRepository.save(touristTrap);
	}
}


