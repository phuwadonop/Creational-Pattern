import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class CSVBookMetadataExporter extends BookMetadataExporter{
    @Override
    public BookMetadataFormatter createFormatter() throws ParserConfigurationException, IOException {
        return new CSVBookMetadataFormatter();
    }
}
