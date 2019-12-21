package br.com.cemim.salesreport;

import br.com.cemim.salesreport.application.Application;
import br.com.cemim.salesreport.application.Watcher;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringApp implements CommandLineRunner {

    @Value("${teste.data.in}")
    private String inputPath;

    @Value("${teste.data.out}")
    private String outputPath;

    public static void main(String[] args) {
        SpringApplication.run(SpringApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Application application = new Application(inputPath, outputPath);
        application.run();

        Watcher watcher = new Watcher(application, inputPath);
        watcher.watch();
    }

}
