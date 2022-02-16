package com.bitcamp.jpa.member.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "member")
public class MemberEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idx;
	
	@Column(length = 100, nullable = false)
	private String userid;
	
	@Column(length = 60, nullable = false)
	private String password;
	
	@Column(length = 50, nullable = false)
	private String username;
	
	@Column(length = 100, nullable = false)
	private String photo;
	
	@Column(length = 50, nullable = false)
	private String regdate;
	
	@Column(length = 10, nullable = false)
	private String role;

	@Builder
	public MemberEntity(long idx, String userid, String password, String username, String photo, String regdate,
			String role) {
		super();
		this.idx = idx;
		this.userid = userid;
		this.password = password;
		this.username = username;
		this.photo = photo;
		this.regdate = regdate;
		this.role = role;
	}
	
	
	
}
