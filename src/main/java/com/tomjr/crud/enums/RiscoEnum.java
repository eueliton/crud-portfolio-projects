package com.tomjr.crud.enums;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public enum RiscoEnum {

    BAIXO_RISCO(1, "Baixo Risco"),
    MEDIO_RISCO(2, "Médio Risco"),
    ALTO_RISCO(3, "Alto Risco");

    private final Integer id;
    private final String name;

    RiscoEnum(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static List<String> getListName() {
        List<String> lista = new ArrayList<>();
        for (RiscoEnum v : values()) {
            lista.add(v.name);
        }
        return lista;
    }

    public static String getNameById(Integer statusId) {
        for (RiscoEnum v : values()) {
            if (v.id.equals(statusId)) {
                return v.name;
            }
        }
        return null;
    }

    public static RiscoEnum getById(Integer dbData) {
        return Stream.of(RiscoEnum.values()).filter(type -> dbData.intValue() == type.getId()).findFirst()
                .orElse(null);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
