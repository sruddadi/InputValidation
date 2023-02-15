package com.assignment.phonebook.controller;

import com.assignment.phonebook.entity.Phonebook;
import com.assignment.phonebook.service.PhonebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PhonebookController {

    @Autowired
    private PhonebookService phonebookService;

    @RequestMapping(value = "info", method = RequestMethod.GET)
    public String Info() {

        return "The application is up...";
    }

    @RequestMapping(value = "createphonebook", method = RequestMethod.POST)
    public ResponseEntity<Object> createPhonebook(@RequestBody @Valid Phonebook contact) {

        return phonebookService.createPhonebook(contact);
    }

    @RequestMapping(value = "readContacts", method = RequestMethod.GET)
    public List<Phonebook> readContacts() {

        return phonebookService.readContacts();
    }

    @RequestMapping(value = "deleteByNumber", method = RequestMethod.PUT)
    public ResponseEntity<Object> deleteByNumber(@RequestBody Phonebook contact) {

        return phonebookService.deleteByNumber(contact);
    }

    @RequestMapping(value = "deleteByName", method = RequestMethod.PUT)
    public ResponseEntity<Object> deleteByName(@RequestBody Phonebook contact) {

        return phonebookService.deleteByName(contact);
    }
}
