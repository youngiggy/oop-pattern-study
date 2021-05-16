package oop.section07;

import java.util.List;

public class QueryResponse {
    private final List<String> list;

    public QueryResponse(List<String> list) {
        this.list = list;
    }

    public List<String> getList() {
        return list;
    }

    public boolean isEqual(QueryResponse queryResponse) {
        return queryResponse.getList().size() == list.size();
    }
}

