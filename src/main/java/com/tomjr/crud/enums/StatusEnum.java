package com.tomjr.crud.enums;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public enum StatusEnum {
    EM_ANALISE(1, "Em Análise"),
    ANALISE_REALIZADA(2, "Análise Realizada"),
    ANALISE_APROVADA(3, "Análise Aprovada"),

    INICIADO(4, "Iniciado"),

    PLANEJADO(5, "Planejado"),

    EM_ANDAMENTO(6, "Em Andamento"),

    ENCERRADO(7, "Encerrado"),

    CANCELADO(8, "Cancelado");


    private final Integer id;
    private final String name;

    StatusEnum(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static List<String> getListName() {
        List<String> lista = new ArrayList<>();
        for (StatusEnum v : values()) {
            lista.add(v.name);
        }
        return lista;
    }

    public static String getNameById(Integer statusId) {
        for (StatusEnum v : values()) {
            if (v.id.equals(statusId)) {
                return v.name;
            }
        }
        return null;
    }

    public static StatusEnum getById(Integer dbData) {
        return Stream.of(StatusEnum.values()).filter(type -> dbData.intValue() == type.getId()).findFirst()
                .orElse(null);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
