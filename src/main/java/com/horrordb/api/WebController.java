package com.horrordb.api;

import com.horrordb.entity.WebElement;
import com.horrordb.entity.WebSeries;
import com.horrordb.jpa.SeriesRepository;
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

    @Autowired
    SeriesRepository seriesRepository;

    //public WebController(WebRepository wsRepository){ this.webRepository = wsRepository; }

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

    @GetMapping("/serieslist")
    public ResponseEntity<List<WebSeries>> getWebSeries(@RequestParam(required = false) String title) {
        try {
            List<WebSeries> ws = new ArrayList<>();

            if (title == null)
                seriesRepository.findAll().forEach(ws::add);
            else
                seriesRepository.findByNameContaining(title).forEach(ws::add);

            if (ws.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(ws, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/weblist")
    void addWebElement(@RequestBody WebElement we) {
        webRepository.save(we);
    }

    @PostMapping("/serieslist")
    void addWebSeries(@RequestBody WebSeries ws) {
        seriesRepository.save(ws);
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

    @GetMapping("/serieslist/{id}")
    public ResponseEntity<WebSeries> getWebSeriesById(@PathVariable("id") long id) {
        Optional<WebSeries> wsData = seriesRepository.findById(id);

        if (wsData.isPresent()) {
            return new ResponseEntity<>(wsData.get(), HttpStatus.OK);
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
