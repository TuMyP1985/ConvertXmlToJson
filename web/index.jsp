<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>My convector</title>
  </head>
  <body>

  <form  method="post" action="convert">
    <p><b>Input your xml:</b></p>
    <p><textarea rows="100" cols="100" required name="text_xml" id="text_xml">

        <?xml version="1.0" encoding="UTF-8"?>
          <PropertyList>
            <Property>
              <Name>CommandTimeout</Name>
              <Value>60</Value>
              <Description>Setting the timeout(in seconds)</Description>
              <DefaultValue></DefaultValue>
            </Property>
            <Property>
              <Name>Address</Name>
              <Value>0.0.0.0</Value>
              <Description>ip:port</Description>
              <DefaultValue></DefaultValue>
            </Property>
          </PropertyList>

    </textarea></p>

    <p><input type="submit" value="get json"></p>

  </form>



  </body>
</html>
