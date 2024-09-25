package com.leucine.entity;

import jakarta.persistence.*;

@Entity
public class Faculty{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String photo;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    private String officeHours;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getOfficeHours() {
		return officeHours;
	}

	public void setOfficeHours(String officeHours) {
		this.officeHours = officeHours;
	}

	@Override
	public String toString() {
		return "Faculty [id=" + id + ", user=" + user + ", photo=" + photo + ", officeHours=" + officeHours + "]";
	}

	public Faculty(int id, User user, String photo, Department department, String officeHours) {
		super();
		this.id = id;
		this.user = user;
		this.photo = photo;
		this.department = department;
		this.officeHours = officeHours;
	}

	public Faculty() {
		super();
		// TODO Auto-generated constructor stub
	}

    
}
