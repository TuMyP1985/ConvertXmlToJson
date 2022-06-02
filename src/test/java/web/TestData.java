package web;

import org.json.JSONObject;
import org.json.XML;

public class TestData {
    public static final String TEST_STRING_XML =
            " <?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "          <PropertyList>\n" +
            "            <Property>\n" +
            "              <Name>CommandTimeout</Name>\n" +
            "              <Value>60</Value>\n" +
            "              <Description>Setting the timeout(in seconds)</Description>\n" +
            "              <DefaultValue></DefaultValue>\n" +
            "            </Property>\n" +
            "            <Property>\n" +
            "              <Name>Address</Name>\n" +
            "              <Value>0.0.0.0</Value>\n" +
            "              <Description>ip:port</Description>\n" +
            "              <DefaultValue></DefaultValue>\n" +
            "            </Property>\n" +
            "          </PropertyList>";
    public static final String TEST_STRING_JSON = XML.toJSONObject(TEST_STRING_XML).toString(4);

}
