import javax.xml.parsers.ParserConfigurationException;

public class XMLBookMetadataExporter extends BookMetadataExporter {
    @Override
    public BookMetadataFormatter createFormatter() throws ParserConfigurationException {
        return new XMLBookMetadataFormatter();
    }
}
