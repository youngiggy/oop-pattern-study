package oop.section07;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SearchAdapterTest {
    @Test
    void canSearchByTolr() {
        ArrayList<String> allContents = new ArrayList<>(Arrays.asList("test", "hello"));
        Tolr tolr = new Tolr(allContents);
        QueryResponse queryResponse = tolr.query();
        assertEquals(allContents.size(), queryResponse.getList().size());
    }

    @Test
    void canSearchByTolrClient() {
        ArrayList<String> allContents = new ArrayList<>(Arrays.asList("test", "hello"));
        Tolr tolr = new Tolr(allContents);
        SearchService searchServiceAdapter = new SearchServiceAdapter(tolr);

        SearchResult searchResult = searchServiceAdapter.search();
        assertTrue(searchResult.isEqual(new SearchResult(tolr.query().getList())));
    }

    @Test
    void canSearchByChildOfTolr() {
        ArrayList<String> allContents = new ArrayList<>(Arrays.asList("test", "hello"));
        Tolr tolr = new Tolr(allContents);
        SearchService searchServiceAdapter = new SearchServiceChildAdapter(allContents);

        SearchResult searchResult = searchServiceAdapter.search();
        assertTrue(searchResult.isEqual(new SearchResult(tolr.query().getList())));
    }

}
