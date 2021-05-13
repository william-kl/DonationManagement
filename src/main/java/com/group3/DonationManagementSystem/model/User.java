package com.group3.DonationManagementSystem.model;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "email")) // email should be unique
public class User {

	// region VARIABLES
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String firstName;
	private String lastName;
	private String email;
	private String password;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL) // eager: whenever retrieve user, retrieve roles
	@JoinTable(
			name = "users_roles", 
			joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), 
			inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
			) // manytomany, create 3rd table
	private Collection<Role> roles; // cascade: whenever parent(user) changes, apply to its children(role)

	@OneToMany(mappedBy = "user",
			cascade = CascadeType.ALL,
			fetch = FetchType.EAGER,
			orphanRemoval = true)
	private Set<Transaction> transactionSet;
	// endregion

	// region CONSTRUCTOR(S)
	public User() {}

	public User(String firstName, String lastName, String email, String password, Collection<Role> roles) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}
	// endregion

	// region GETTERS/SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public Set<Transaction> getTransactionSet() {
		return transactionSet;
	}

	public void setTransactionSet(Set<Transaction> transactionSet) {
		this.transactionSet = transactionSet;
	}
	// endregion

	// region METHODS
	public void addTransactionEntry(Transaction transaction) {
		if (transaction != null) {
			if (transactionSet == null) {
				transactionSet = new HashSet<>();
			}
			transaction.setUser(this);
			transactionSet.add(transaction);
		}
	}
	// endregion

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append("User:/n")
				.append("User Id: ").append(id).append("/n")
				.append("First Name: ").append(firstName).append("/n")
				.append("Last Name: ").append(lastName).append("/n")
				.append("Email: ").append(email).append("/n")
				.append("Password: ").append(password).append("/n")
				.append("Roles:/n");

		for (Role role: roles) {
			sb.append(role).append(" ");
		}

		sb.append("/nTransaction List:/n");

		for (Transaction transaction : transactionSet) {
			sb.append(transaction).append("/n");
		}

		return sb.toString();
	}
}
