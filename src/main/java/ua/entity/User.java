package ua.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User extends AbstractEntityId {

    private String firstName;
    
    private String lastName;
    
    private String login;
    
    private String password;
    
    private Integer age;
    
    @OneToMany(mappedBy = "user")
    private List<Rent> orders;
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Rent> getOrders() {
		return orders;
	}

	public void setOrders(List<Rent> orders) {
		this.orders = orders;
	}
}
