import java.io.IOException;

public interface BookMetadataFormatter {
    BookMetadataFormatter reset();
    BookMetadataFormatter append(Book b) throws IOException;
    String getMetadataString() throws IOException;
}
