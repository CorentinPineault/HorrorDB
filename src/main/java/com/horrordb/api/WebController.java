package com.horrordb.api;

import com.horrordb.entity.WebSeries;
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

    //public WebController(WebRepository wsRepository){ this.webRepository = wsRepository; }

    @GetMapping("/webseries")
    public ResponseEntity<List<WebSeries>> getWebSeries(@RequestParam(required = false) String title) {
        try {
            List<WebSeries> ws = new ArrayList<>();

            if (title == null)
                webRepository.findAll().forEach(ws::add);
            else
                webRepository.findByNameContaining(title).forEach(ws::add);

            if (ws.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(ws, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/webseries")
    void addWebSeries(@RequestBody WebSeries webseries) {
        webRepository.save(webseries);
    }

    @GetMapping("/webseries/{id}")
    public ResponseEntity<WebSeries> getWebSeriesById(@PathVariable("id") long id) {
        Optional<WebSeries> wsData = webRepository.findById(id);

        if (wsData.isPresent()) {
            return new ResponseEntity<>(wsData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/webseries/{id}")
    public ResponseEntity<WebSeries> updateTutorial(@PathVariable("id") long id, @RequestBody WebSeries ws) {
        Optional<WebSeries> wsData = webRepository.findById(id);

        if (wsData.isPresent()) {
            WebSeries _ws = wsData.get();
            _ws.setName(ws.getName());
            _ws.setDesc(ws.getDesc());
            _ws.setStartDate(ws.getStartDate());
            _ws.setEndDate(ws.getEndDate());
            _ws.setLink(ws.getLink());
            return new ResponseEntity<>(webRepository.save(_ws), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/webseries/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
        try {
            webRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
