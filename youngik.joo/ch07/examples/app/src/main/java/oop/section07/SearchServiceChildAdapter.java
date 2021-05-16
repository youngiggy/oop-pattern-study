package oop.section07;

import java.util.List;

public class SearchServiceChildAdapter extends Tolr
        implements SearchService{

    public SearchServiceChildAdapter(List<String> list) {
        super(list);
    }

    @Override
    public SearchResult search() {
        return new SearchResult(super.query().getList());
    }
}
