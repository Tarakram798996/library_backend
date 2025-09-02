package com.libraryexample.library.service;

import com.libraryexample.library.model.Member;
import com.libraryexample.library.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    public MemberRepository memberRepository;


    public Member save(Member member) {
        return memberRepository.save(member);
    }

    public List<Member> getAll() {
        return memberRepository.findAll();
    }


    public Member getById(int id) {
        return memberRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Book not found with id " + id));
    }

    @Transactional
    public Member updateMem(Member member, int id) {
        Member curMem = memberRepository.findById(id)
                        .orElseThrow(()-> new RuntimeException("Book not found with id " + id));
        curMem.setAddress(member.getAddress());
        curMem.setEmail(member.getEmail());
        curMem.setName(member.getName());
        curMem.setPhone(member.getPhone());
        curMem.setJoinDate(member.getJoinDate());

        return memberRepository.save(curMem);
    }

    public void deleteMem(int id) {
        memberRepository.deleteById(id);
    }
}
