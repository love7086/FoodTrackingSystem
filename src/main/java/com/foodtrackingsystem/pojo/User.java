/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foodtrackingsystem.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author asus
 */
@Entity
@Table(name = "userTable")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

	@Id
	@GenericGenerator(name = "userGenerator", strategy = "increment")
	@GeneratedValue(generator = "userGenerator")
	@Column(name = "userId", unique = true, nullable = false)
	private long userId;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", orphanRemoval = true)
	private Set<Comment> commentDir;

	@Column(name = "username", unique = true)
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "role")
	private String role;

	@Column(name = "emailAddress")
	private String emailAddress;

	@Column(name = "region")
	private String region;

	@Column(name = "phone")
	private long phone = 0;

	@Column(name = "gender")
	private String gender;

	@Column(name = "birthDate")
	private String birthDate;

	@Column(name = "nickname")
	private String nickname;

	@OneToOne
	@JoinColumn(name = "person")
	private Person person;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "enterprise")
	private Enterprise enterprise;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sender")
	private Set<WorkRequest> workQueue1;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "receiver")
	private Set<WorkRequest> workQueue2;

	@Column(name = "photoName")
	private String photoName;

	@Transient
	private MultipartFile photo;

	public User() {
		phone = 0;
		workQueue1 = new HashSet<WorkRequest>();
		workQueue2 = new HashSet<WorkRequest>();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	public Set<WorkRequest> getWorkQueue1() {
		return workQueue1;
	}

	public void setWorkQueue1(Set<WorkRequest> workQueue1) {
		this.workQueue1 = workQueue1;
	}

	public Set<WorkRequest> getWorkQueue2() {
		return workQueue2;
	}

	public void setWorkQueue2(Set<WorkRequest> workQueue2) {
		this.workQueue2 = workQueue2;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Override
	public String toString() {
		return username;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	public MultipartFile getPhoto() {
		return photo;
	}

	public Set<Comment> getCommentDir() {
		return commentDir;
	}

	public void setCommentDir(Set<Comment> commentDir) {
		this.commentDir = commentDir;
	}

	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}

}
