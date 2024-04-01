package ferper.rafael.sdw24.application;

import ferper.rafael.sdw24.domain.exception.ChampionNotFoundException;
import ferper.rafael.sdw24.domain.model.Champion;
import ferper.rafael.sdw24.domain.ports.ChampionsRepository;

import java.util.List;

public record AskChampionsUseCase(ChampionsRepository repository) {

    public String askChampion(Long championId, String question) {

        Champion champion = repository.findById(championId)
                .orElseThrow(() -> new ChampionNotFoundException(championId));

        String championContext = champion.generateContextByQuestion(question);

        // TODO: Evoluir a lógica de negócio para considerar a integração com IAs Generativas.

        return championContext;
    }
}
