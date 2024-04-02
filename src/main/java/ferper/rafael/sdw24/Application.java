package ferper.rafael.sdw24;

import ferper.rafael.sdw24.application.AskChampionsUseCase;
import ferper.rafael.sdw24.application.ListChampionsUseCase;
import ferper.rafael.sdw24.domain.ports.ChampionsRepository;
import ferper.rafael.sdw24.domain.ports.GenerativeAiApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Bean
	public ListChampionsUseCase provideListChampionsUseCase(ChampionsRepository repository) {
		return new ListChampionsUseCase(repository);
	}

	@Bean
	public AskChampionsUseCase provideAskChampionsUseCase(ChampionsRepository repository, GenerativeAiApi genAiApi) {
		return new AskChampionsUseCase(repository, genAiApi);
	}
}
