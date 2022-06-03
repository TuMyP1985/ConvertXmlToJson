package web;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.ws.rs.Consumes;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
public class ConvectorRestController {

    @PostMapping("/convert")
    public ResponseEntity<String> convertToJson(@RequestParam String text_xml) {

        JSONObject json = XML.toJSONObject(text_xml);
        String jsonString = json.toString(4);

        return ResponseEntity.ok().body(jsonString);

    }

    @PostMapping("/convertFile")
    @Consumes(MediaType.MULTIPART_FORM_DATA_VALUE)
    public @ResponseBody ResponseEntity  convertFile(
            @RequestParam MultipartFile  file
    )  {
        try {
            String text_xml = new String(file.getBytes(), StandardCharsets.UTF_8);
            JSONObject json = XML.toJSONObject(text_xml);
            String jsonString = json.toString(4);

            return new ResponseEntity(jsonString.getBytes(), HttpStatus.OK);

        }catch (Exception e) {
            return new ResponseEntity("bad file",HttpStatus.BAD_REQUEST);
        }
    }
}

