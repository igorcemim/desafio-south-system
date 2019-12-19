package br.com.cemim.salesreport.business;

import lombok.Data;

@Data
public class Salesman {

    private String cpf;

    private String name;

    private double salary;

    private double sales;

    public void addSale(double sale) {
        sales += sale;
    }

}
