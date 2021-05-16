package oop.section07;

import java.util.List;

public class SearchResult {
    private final List<String> list;

    public SearchResult(List<String> list) {
        this.list = list;
    }

    public List<String> getList() {
        return list;
    }

    public boolean isEqual(SearchResult searchResult) {
        return searchResult.getList().size() == list.size();
    }
}

