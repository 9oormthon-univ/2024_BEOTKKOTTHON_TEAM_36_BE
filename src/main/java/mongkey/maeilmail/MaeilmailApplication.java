package mongkey.maeilmail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MaeilmailApplication {

    public static void main(String[] args) {
        SpringApplication.run(MaeilmailApplication.class, args);
    }

}
