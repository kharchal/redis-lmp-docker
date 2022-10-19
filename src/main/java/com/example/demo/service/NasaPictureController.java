package com.example.demo.service;

import com.example.demo.client.MarsApiClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.IMAGE_JPEG_VALUE;

@RestController
@AllArgsConstructor
@Slf4j
public class NasaPictureController {
    MarsApiClient marsApiClient;

    @GetMapping(value = "${mars.api.get.larg.pics}", produces = IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getLargestPicture(@RequestParam(name="sol") Integer sol,
                                                    @RequestParam(required = false) String camera) {

        log.info("requested largest pic for sol: {}, camera: {}", sol, camera);
        byte[] body = marsApiClient.getLargestPicture(sol, camera);
        log.info("provided largest pic");
        return ResponseEntity.ok(body);
    }
}