import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

public class JSONBookMetadataFormatter implements BookMetadataFormatter {

    private StringWriter writer;
    private JSONObject collection;
    private JSONArray objs;

    public JSONBookMetadataFormatter() throws IOException {
        reset();
    }

    @Override
    public BookMetadataFormatter reset() {
        this.writer = new StringWriter();
        this.collection = new JSONObject();
        this.objs = new JSONArray();
        this.collection.put("Books",objs);
        return this;
    }

    @Override
    public BookMetadataFormatter append(Book b) throws IOException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Book.Metadata.ISBN,b.getISBN());
        jsonObject.put(Book.Metadata.TITLE,b.getTitle());
        jsonObject.put(Book.Metadata.PUBLISHER,b.getPublisher());
        jsonObject.put(Book.Metadata.AUTHORS,List.of(b.getAuthors()));
        this.objs.add(jsonObject);
        return this;
    }

    @Override
    public String getMetadataString() throws IOException {
        JSONValue.writeJSONString(this.collection, this.writer);
        return this.writer.toString();
    }
}
