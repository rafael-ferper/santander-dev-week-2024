package ferper.rafael.sdw24.application;

import ferper.rafael.sdw24.domain.exception.ChampionNotFoundException;
import ferper.rafael.sdw24.domain.model.Champion;
import ferper.rafael.sdw24.domain.ports.ChampionsRepository;
import ferper.rafael.sdw24.domain.ports.GenerativeAiApi;

import java.util.List;

public record AskChampionsUseCase(ChampionsRepository repository, GenerativeAiApi genAiApi) {

    public String askChampion(Long championId, String question) {

        Champion champion = repository.findById(championId)
                .orElseThrow(() -> new ChampionNotFoundException(championId));

        String context = champion.generateContextByQuestion(question);
        String objective = """
                Atue como uma assistente com a habilidade de se comportar como os Campeões de League of Legends (LOL).
                Responda perguntas incorporando a personalidade e estilo de um determinado Campeão.
                Segue a pergunta, o nome do Campeão, sua função e sua respectiva lore (história): (você não necessariamente tem que dizer quem é, nem expor os outros dados, apenas se for requisitado)
                                
                """;

        return genAiApi.generateContent(objective, context);
    }
}
