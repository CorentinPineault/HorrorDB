package com.horrordb.api;

import com.googlecode.jmapper.JMapper;
import com.horrordb.entity.WebElement;
import com.horrordb.entity.dto.WebElementDto;
import com.horrordb.jpa.WebRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class WebController {

    @Autowired
    WebRepository webRepository;

    JMapper<WebElementDto, WebElement> webMapper = new JMapper<>(WebElementDto.class, WebElement.class);

    @GetMapping("/weblist")
    public ResponseEntity<List<WebElement>> getWebElements(@RequestParam(required = false) String title) {
        try {
            List<WebElement> wb = new ArrayList<>();

            if (title == null)
                webRepository.findAll().forEach(wb::add);
            else
                webRepository.findByNameContaining(title).forEach(wb::add);

            if (wb.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(wb, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/weblist")
    void addWebElement(@RequestBody WebElement we) {
        webRepository.save(we);
    }
    
    @GetMapping("/weblist/{id}")
    public ResponseEntity<WebElement> getWebElementsById(@PathVariable("id") long id) {
        Optional<WebElement> weData = webRepository.findById(id);

        if (weData.isPresent()) {
            return new ResponseEntity<>(weData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/weblist/{id}")
    public ResponseEntity<WebElement> updateWebElement(@PathVariable("id") long id, @RequestBody WebElement we) {
        Optional<WebElement> weData = webRepository.findById(id);

        if (weData.isPresent()) {
            WebElement _we = weData.get();
            _we.setName(we.getName());
            _we.setDesc(we.getDesc());
            _we.setLink(we.getLink());
            return new ResponseEntity<>(webRepository.save(_we), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/weblist/{id}")
    public ResponseEntity<HttpStatus> deleteWebElement(@PathVariable("id") long id) {
        try {
            webRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
