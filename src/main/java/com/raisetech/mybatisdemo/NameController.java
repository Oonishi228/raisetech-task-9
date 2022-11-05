package com.raisetech.mybatisdemo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/names")
public class NameController {
    private final NameService nameService;

    public NameController(NameService nameService) {
        this.nameService = nameService;
    }

    @GetMapping("/")
    public List<NameResponse> getNames() {
        return nameService.findAll().stream().map(NameResponse::new).toList();
    }

    @GetMapping("/{id}")
    public List<NameResponse> getId(@PathVariable("id") int id) {
        return nameService.findById(id).stream().map(NameResponse::new).toList();
    }

    @GetMapping
    public List<NameResponse> idResponse(@RequestParam("id") int id) {
        return nameService.findById(id).stream().map(NameResponse::new).toList();
    }

    @GetMapping("/a")
    public List<NameResponse> getResidence(@RequestParam("residence") String residence) {
        return nameService.findByResidence(residence).stream().map(NameResponse::new).toList();
    }
}
