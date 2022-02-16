package com.bitcamp.jpa.member.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.jpa.member.domain.MemberEntity;
import com.bitcamp.jpa.member.domain.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/member")
public class MemberRestController {

	// final을 붙였을 때 -> 생성자에서 초기화를 해주어야 한다.
	// 생성자 코드가 생략되었을 때
	// -> @RequiredArgsConstructor 애노테이션을 통해 lombok이 constructor를 만들어서 처리해준다.
	private final MemberRepository repository;

	// @Autowired 없이 주입이 된다.
//	public MemberRestController(MemberRepository repository) {
//		this.repository = repository;
//	}
	
	// 전체 리스트 출력
	@GetMapping
	public List<MemberEntity> getMemberList(){
		return repository.findAll();
	}
	
	@PostMapping
	public String memberInsert() {
		
		MemberEntity entity = MemberEntity.builder()
				.idx(0)
				.userid("cool@gmail.com")
				.password("1234")
				.username("COOL")
				.photo("minions.png")
				.regdate(new Date().toString())
				.role("ADMIN")
				.build();
		
		return repository.saveAndFlush(entity).toString();
		
	}
	
	@GetMapping("/{idx}")
	public Optional<MemberEntity> getMember(@PathVariable("idx") Long idx) {
		return repository.findById(idx);
	}
	
	@PutMapping("/{idx}")
	public String memberUpdate(@PathVariable("idx") Long idx) {
		
		MemberEntity entity = MemberEntity.builder()
				.idx(idx)
				.userid("hot@gmail.com")
				.password("0000")
				.username("HOT")
				.photo("minion1.jpg")
				.regdate(new Date().toString())
				.role("MEMBER")
				.build();
		
		return repository.saveAndFlush(entity).toString();
		
	}
	
	@DeleteMapping("/{idx}")
	public void memberDelete(@PathVariable("idx") Long idx) {
		// MemberEntity entity = MemberEntity.builder().idx(idx).build();
		repository.delete(MemberEntity.builder().idx(idx).build());
	}
	
}
