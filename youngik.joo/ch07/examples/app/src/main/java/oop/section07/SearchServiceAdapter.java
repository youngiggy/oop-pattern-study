package oop.section07;

public class SearchServiceAdapter implements SearchService{
    private Tolr tolr;

    public SearchServiceAdapter(Tolr tolr) {
        this.tolr = tolr;
    }
    @Override
    public SearchResult search() {
        return new SearchResult(tolr.query().getList());
    }
}
