package br.com.cemim.salesreport.application;

import br.com.cemim.salesreport.application.Application;
import br.com.cemim.salesreport.application.Watcher;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringApp implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringApp.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        String home = System.getProperty("user.home");
        String inputPath = home + "/data/in";
        String outputPath = home + "/data/out";

        Application application = new Application(inputPath, outputPath);
        application.run();

        Watcher watcher = new Watcher(application, inputPath);
        watcher.watch();
    }

}
