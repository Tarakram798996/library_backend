package com.libraryexample.library.controller;

import com.libraryexample.library.model.Member;
import com.libraryexample.library.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    MemberService memberService;

    @PostMapping
    public ResponseEntity<Member> createMember(@RequestBody Member member){
        Member createdMem = memberService.save(member);
        return new ResponseEntity<>(createdMem, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Member> getAllMem(){
        return memberService.getAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Member> getById(@PathVariable int id){
        Member member = memberService.getById(id);
        return new ResponseEntity<>(member,HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Member> updateMember(@RequestBody Member member,@PathVariable int id){
        Member updatedMem = memberService.updateMem(member,id);
        return new ResponseEntity<>(updatedMem,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public void deleteMem(@PathVariable int id){
        memberService.deleteMem(id);
    }

}
