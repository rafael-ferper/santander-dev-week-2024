package ferper.rafael.sdw24.adapters.in;

import ferper.rafael.sdw24.application.AskChampionsUseCase;
import ferper.rafael.sdw24.application.ListChampionsUseCase;
import ferper.rafael.sdw24.domain.model.Champion;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Campeões", description = "Endpoints do domínio de Campeões do LOL.")
@RestController
@RequestMapping("/champions")
public record ListChampionsRestController(ListChampionsUseCase useCase) {

    @GetMapping
    public List<Champion> findAllChampions() {
        return useCase.findAll();
    }
}
