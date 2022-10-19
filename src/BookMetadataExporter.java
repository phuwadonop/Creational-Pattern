import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.PrintStream;

public abstract class BookMetadataExporter extends BookCollection {

    BookMetadataFormatter formatter;

    public void export(PrintStream stream) throws ParserConfigurationException, IOException {
        formatter = createFormatter();
        for (Book b : books) {
            formatter.append(b);
        }
        stream.print(formatter.getMetadataString());
    }

    public abstract BookMetadataFormatter createFormatter() throws ParserConfigurationException, IOException;
}
