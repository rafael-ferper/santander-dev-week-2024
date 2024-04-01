package ferper.rafael.sdw24.application;

import ferper.rafael.sdw24.domain.model.Champions;
import ferper.rafael.sdw24.domain.ports.ChampionsRepository;

import java.util.List;

public record ListChampionsUseCase(ChampionsRepository repository) {

    public List<Champions> findAll() {
        return repository.findAll();
    }
}
