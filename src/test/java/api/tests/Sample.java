package api.tests;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sample {
    static Comparator<tomato> COMPARE_TOMATOES = (tomato t1, tomato t2)-> {

        return new CompareToBuilder()
                .append(t1.getTaste(),t2.getTaste())
                .append(t1.getColor(),t2.getColor())
                .append(t1.getName(),t2.getName())
                .toComparison();

    };


    public static void main(String[] args) {
        List<tomato> list = new ArrayList<>();
        list.add(new tomato("red", "fluffy","sweet"));
        list.add(new tomato("green", "george", "spicy"));
        list.add(new tomato("blue", "Eggroll", "tangy"));

        Collections.sort(list,COMPARE_TOMATOES);

        for (tomato t: list){
            System.out.println(t);
        }

    }
}

class tomato{

    private String color;
    private String name;
    private String taste;

    public tomato(String color, String name, String taste) {
        this.color = color;
        this.name = name;
        this.taste = taste;
    }

    @Override
    public String toString() {
        return "My Name is "+getName()+"\n and I taste...\n"+getTaste();
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public String getTaste() {
        return taste;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        tomato tomato = (tomato) o;

        return new EqualsBuilder()
                .append(color, tomato.color)
                .append(name, tomato.name)
                .append(taste, tomato.taste)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(color)
                .append(name)
                .append(taste)
                .toHashCode();
    }
}

