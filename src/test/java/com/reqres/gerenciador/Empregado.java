package com.reqres.gerenciador;

public class Empregado {
    String name;
    String job;

    public Empregado (String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }
}
