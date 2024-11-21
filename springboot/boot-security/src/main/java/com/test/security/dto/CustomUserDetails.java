package com.test.security.dto;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.test.security.entity.Member;

import lombok.Getter;

//인증 사용자 정보 객체 > principal
@Getter
public class CustomUserDetails implements UserDetails {
	
//	시큐리티가 제공하는 기본정보 외의 사용자 추가정보를 담는 용
//	- 이전 수업(UserDTO)
//	- 현재 수업(Member Entity)
	private Member member;
	
	public CustomUserDetails(Member member) {
		this.member = member;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		authorities.add(new GrantedAuthority() {

			@Override
			public String getAuthority() {
				return member.getRole();
			}
			
		});
		
		return authorities;
	}

	@Override
	public String getPassword() {
		return this.member.getPassword();
	}

	@Override
	public String getUsername() {
		return this.member.getUsername();
	}

//	현재 계정이 만료된 계정인지 활동중인 계정인지 구분하는 메서드
	@Override
	public boolean isAccountNonExpired() {
		
//		DB > 컬럼 존재(ing)
//		계정 만료 유무?
		
//		return UserDetails.super.isAccountNonExpired();
//		원래는 DB에서 받아와서 계정의 만료 정보를 리턴해줘야함
		return true;
//		return false;
//		로그인을 시도해도 탈퇴했기 때문에 로그인 처리를 해주지 않음
	}
	
	@Override
	public boolean isAccountNonLocked() {
		
//		계정 잠금 상태
		
//		return UserDetails.super.isAccountNonLocked();
//		원래는 DB에서 받아와서 계정의 잠금 정보를 리턴해줘야함
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		
//		자격 증명(암호) 만료 상태
//		회원가입 후/비밀번호를 변경 후 60, 90, 120일 암호 변경을 강제화 할 때 사용
//		return UserDetails.super.isCredentialsNonExpired();
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		
//		사용 유무
		return true;
	}
}
