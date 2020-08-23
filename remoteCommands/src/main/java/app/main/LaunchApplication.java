package app.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

@ServletComponentScan
@SpringBootApplication(scanBasePackages = "app")
public class LaunchApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LaunchApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(LaunchApplication.class, args);
		//context.stop();
		//context.close();

	}

}
