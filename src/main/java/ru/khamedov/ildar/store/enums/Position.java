package ru.khamedov.ildar.store.enums;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Position {
    Seller("продавец"),
    Storekeeper("кладовщик");
    private String name;

    private Position(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public static Position getPosition(String name){
       return Arrays.asList(Position.values()).stream().filter(p->p.getName().equals(name)).collect(Collectors.toList()).get(0);
    }
}
