package oop.section07;

import java.util.List;

public class Tolr {
    private final List<String> list;

    public Tolr(List<String> list) {
        this.list = list;
    }
    public QueryResponse query() {
        return new QueryResponse(list);
    }
}
