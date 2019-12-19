package br.com.cemim.salesreport.application;

import java.util.ArrayList;
import java.util.List;

import br.com.cemim.salesreport.business.FileReport;
import br.com.cemim.salesreport.business.GeneralReport;
import br.com.cemim.salesreport.processor.DirectoryProcessor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {

    private String inputPath;

    private String outputPath;

    public Application(String in, String out) {
        this.inputPath = in;
        this.outputPath = out;
    }

    public void run() throws Exception {
        List<FileReport> filesReports = new ArrayList<>();
        GeneralReport generalReport = new GeneralReport();
        DirectoryProcessor directoryProcessor = new DirectoryProcessor(inputPath, generalReport, filesReports);
        log.info("Processando arquivos...\n");
        directoryProcessor.process();
        log.info("Arquivos processados.\n");

        if (filesReports.size() > 0 && generalReport != null) {
            ReportWriter reportWriter = new ReportWriter(outputPath, generalReport, filesReports);
            reportWriter.write();
        } else {
            log.info("Não há dados para gerar o relatório.");
        }
    }

}
