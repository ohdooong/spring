package com.example.lesson07.entity; // JPA일때 entity

import java.time.ZonedDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString		// 객체를 출력할 때 모든 내용이 보여진다.    // 안하면 StudentEntity@asivk3251 이런식으로 출력됨.
@AllArgsConstructor // 파라미터가 모두 있는 생성자
@NoArgsConstructor //  파라미터 없는 기본 생성자
@Getter
@Builder(toBuilder = true) // setter의 대용   // toBuiler true 수정 허용
@Entity // 이 객체는 엔티티다.  (JPA <-> DB와의 통신 할때 그 사이에 있음.)
@Table(name="new_student") // 사용하지 않으면 클래스이름을 테이블명으로 인식한다.
public class StudentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@Column(name="phoneNumber")
	private String phoneNumber;
	
	private String email;
	
	@Column(name="dreamJob")
	private String dreamJob;
	
	@UpdateTimestamp // 시간을 넣지 않아도 현재 시간으로 자동으로 들어감
	@Column(name="createdAt", updatable = false) // 업데이트 시 생성시간은 변경되면 안되므로 변경안되게 설정.
	private ZonedDateTime createdAt;
	
	@UpdateTimestamp
	@Column(name="updatedAt")
	private ZonedDateTime updatedAt;
}
