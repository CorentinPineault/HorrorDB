package com.horrordb.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.googlecode.jmapper.JMapper;
import com.horrordb.entity.WebSeries;
import com.horrordb.entity.dto.WebSeriesDto;
import com.horrordb.jpa.WebSeriesRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class WebSeriesController {

    @Autowired
    WebSeriesRepository webSeriesRepository;

    JMapper<WebSeriesDto, WebSeries> webSeriesMapper = new JMapper<>(WebSeriesDto.class, WebSeries.class);


    @GetMapping("/serieslist")
    public ResponseEntity<List<WebSeries>> getWebSeries(@RequestParam(required = false) String title) {
        try {
            List<WebSeries> ws = new ArrayList<>();

            if (title == null)
                webSeriesRepository.findAll().forEach(ws::add);
            else
                webSeriesRepository.findByNameContaining(title).forEach(ws::add);

            if (ws.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(ws, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/serieslist")
    void addWebSeries(@RequestBody WebSeries ws) {
        webSeriesRepository.save(ws);
    }

    @GetMapping("/serieslist/{id}")
    public ResponseEntity<WebSeries> getWebSeriesById(@PathVariable("id") long id) {
        Optional<WebSeries> wsData = webSeriesRepository.findById(id);

        if (wsData.isPresent()) {
            return new ResponseEntity<>(wsData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
