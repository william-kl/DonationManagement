package com.group3.DonationManagementSystem.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "email")) // email should be unique
public class User {

	// region VARIABLES
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "First name can't be empty and it should have at least 2 characters")
	@Size(min = 2)
	private String firstName;

	@NotEmpty(message = "Last name can't be empty and it should have at least 2 characters")
	@Size(min = 2)
	@Column(name = "last_name")
	private String lastName;

	@NotEmpty(message = "Email address can't be empty and it should contain @")
	private String email;
	private Boolean active;

	@NotEmpty(message = "Password can't be empty and it should have at least 6 characters")
	@Size(min = 6)
	private String password;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST) // eager: whenever retrieve user, retrieve roles
	@JoinTable(
			name = "users_roles", 
			joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), 
			inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
			) // manytomany, create 3rd table
	private Collection<Role> roles; // cascade: whenever parent(user) changes, apply to its children(role)

	@OneToMany(mappedBy = "user",
			cascade = CascadeType.ALL,
			fetch = FetchType.EAGER
			)//orphanRemoval = true
	private Set<Transaction> transactionSet;
	// endregion

	// region CONSTRUCTOR(S)
	public User() {
		this.active = true;
	}

	public User(String firstName, String lastName, String email, String password, Collection<Role> roles) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.roles = roles;
		active = true;
  }
	
  public User(String firstName, String lastName, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		active = true;
	}

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
	
	public void addRole(Role role) {
		this.roles.add(role);
	}
	
	public void removeRole(Role role) {
		this.roles.remove(role);
	}

	public Set<Transaction> getTransactionSet() {
		return transactionSet;
	}

	public void setTransactionSet(Set<Transaction> transactionSet) {
		this.transactionSet = transactionSet;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
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

		sb.append("User:\n");
		sb.append("User Id: ").append(id).append("\n");
		sb.append("First Name: ").append(firstName).append("\n");
		sb.append("Last Name: ").append(lastName).append("\n");
		sb.append("Email: ").append(email).append("\n");
		sb.append("Password: ").append(password).append("\n");
		sb.append("Is active: ").append(active ? "True" : "False").append("\n");
		sb.append("Roles:\n");
		for (Role role: roles) {
			sb.append(role).append(" ");
		}
//		sb.append("\nTransaction List:\n");
//		for (Transaction transaction : transactionSet) {
//			sb.append(transaction).append("\n");
//		}

		return sb.toString();
	}
}
