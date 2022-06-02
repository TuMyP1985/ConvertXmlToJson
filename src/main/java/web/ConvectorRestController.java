package web;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping(value = "/convert", produces = MediaType.APPLICATION_JSON_VALUE)
public class ConvectorRestController {

    @PostMapping("")
    public ResponseEntity<String> convertToJson(@RequestParam String text_xml) {

        JSONObject json = XML.toJSONObject(text_xml);
        String jsonString = json.toString(4);

        return ResponseEntity.ok().body(jsonString);

    }
}

