package com.imryuik.crowdfunding.web;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/creator", produces={"application/json", "text/xml"})
@CrossOrigin
public class CreatorController {
}
