package com.assignment.phonebook.service;

import com.assignment.phonebook.ExceptionHandling.BadRequest;
import com.assignment.phonebook.ExceptionHandling.NotFound;
import com.assignment.phonebook.entity.Phonebook;
import com.assignment.phonebook.repository.PhonebookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class PhonebookService {
    @Autowired
    private PhonebookRepository phonebookRepository;

    @Transactional
    public ResponseEntity<Object> createPhonebook(Phonebook contact){
        try {
            ValidationService valid = new ValidationService();
            if (!phonebookRepository.existsByPhoneNumber(contact.getPhoneNumber())){
                contact.setId(null == phonebookRepository.findMaxId()? String.valueOf(0) : phonebookRepository.findMaxId() + 1);
                if(!valid.validatePhone(contact))
                    throw new BadRequest("Invalid Phone number, please re-check and enter the correct format");
                if(!valid.validateName(contact))
                    throw new BadRequest("Invalid Full name, please re-check and enter the correct format");
                File log = new File("log.txt");
                try{
                    if(!log.exists()){
                        log.createNewFile();
                    }
                    PrintWriter out = new PrintWriter(new FileWriter(log, true));
                    out.append("New Phonebook Record has been created:- \n"+
                            "Name: "+contact.getName()+", Phone number: "+contact.getPhoneNumber()+", Created Date: "+new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date())+"\n\n");
                    out.close();
                }catch(IOException e){
                    System.out.println("Could not log!!");
                }
                phonebookRepository.save(contact);
                return new ResponseEntity<>("Phonebook is created successfully", HttpStatus.OK);
            }else {
                throw new BadRequest("Phonebook already exists");
            }
        }catch (Exception e){
            throw e;
        }
    }

    public List<Phonebook> readContacts() {
        File log = new File("log.txt");
        try{
            if(!log.exists()){
                log.createNewFile();
            }
            PrintWriter out = new PrintWriter(new FileWriter(log, true));
            out.append("Phonebook records have been viewed on "+new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date())+"\n\n");
            out.close();
        }catch(IOException e){
            System.out.println("Could not log!!");
        }
        return phonebookRepository.findAll();
    }

    @Transactional
    public ResponseEntity<Object> deleteByNumber(Phonebook contact){
        if (phonebookRepository.existsByPhoneNumber(contact.getPhoneNumber())){
            try {
                List<Phonebook> contacts = phonebookRepository.findByPhoneNumber(contact.getPhoneNumber());
                contacts.stream().forEach(p -> {
                    phonebookRepository.delete(p);
                });
                File log = new File("log.txt");
                try{
                    if(!log.exists()){
                        log.createNewFile();
                    }
                    PrintWriter out = new PrintWriter(new FileWriter(log, true));
                    out.append("Phonebook Record has been deleted:- \n"+
                            "Name: "+contacts.get(0).getName()+", Phone number: "+contact.getPhoneNumber()+", Deleted Date: "+new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date())+"\n\n");
                    out.close();
                }catch(IOException e){
                    System.out.println("Could not log!!");
                }
                return new ResponseEntity<>("Contact Record is deleted successfully", HttpStatus.OK);
            }catch (Exception e){
                throw e;
            }
        }else {
            String phoneNumber = contact.getPhoneNumber();
            throw new NotFound(phoneNumber+" is not a valid number in the database");
        }
    }

    @Transactional
    public ResponseEntity<Object> deleteByName(Phonebook contact){
        if (phonebookRepository.existsByName(contact.getName())){
            try {
                List<Phonebook> contacts = phonebookRepository.findByName(contact.getName());
                contacts.stream().forEach(p -> {
                    phonebookRepository.delete(p);
                });
                File log = new File("log.txt");
                try{
                    if(!log.exists()){
                        log.createNewFile();
                    }
                    PrintWriter out = new PrintWriter(new FileWriter(log, true));
                    out.append("Phonebook Record has been deleted:- \n"+
                            "Name: "+contact.getName()+", Phone number: "+contacts.get(0).getPhoneNumber()+", Deleted Date: "+new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date())+"\n\n");
                    out.close();
                }catch(IOException e){
                    System.out.println("Could not log!!");
                }
                return new ResponseEntity<>("Contact Record is deleted successfully", HttpStatus.OK);
            }catch (Exception e){
                throw e;
            }
        }else {
            String name = contact.getName();
            throw new NotFound(name+" is not a valid name in the database");
        }
    }
}
