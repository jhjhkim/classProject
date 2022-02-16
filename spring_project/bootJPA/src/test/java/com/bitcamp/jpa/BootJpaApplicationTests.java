package com.bitcamp.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bitcamp.jpa.member.domain.MemberEntity;
import com.bitcamp.jpa.member.domain.MemberRepository;

@SpringBootTest
class BootJpaApplicationTests {

	@Autowired
	MemberRepository repository;
	
	@Test
	void contextLoads() {
	}

	@Test
	void 회원정보생성() {

		MemberEntity entity = MemberEntity.builder()
				.idx(111)
				// .userid("cool@gmail.com")
				// .password("1234")
				// .username("COOL")
				// .photo("minions.png")
				// .regdate(new Date().toString())
				.role("ADMIN").build();
		// System.out.println(entity);

	}

	@Test
	void 회원정보생성및데이터가져오기() {
		
		MemberEntity entity = MemberEntity.builder()
				.idx(0)
				.userid("cool@gmail.com")
				.password("1234")
				.username("COOL")
				.photo("minions.png")
				.regdate(new Date().toString())
				.role("ADMIN").build();
		
		repository.saveAndFlush(entity);
		System.out.println("저장 완료!");
		
		List<MemberEntity> list = repository.findAll();
		
		MemberEntity memberEntity = list.get(0);
		System.out.println(memberEntity);
		
		assertThat(memberEntity.getUserid()).isEqualTo("cool@gmail.com");
		assertThat(memberEntity.getRole()).isEqualTo("ADMIN");
		
	}
}
