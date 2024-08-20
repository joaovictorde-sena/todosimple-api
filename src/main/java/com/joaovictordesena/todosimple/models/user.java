package com.joaovictordesena.todosimple.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.tomcat.jni.User;
import org.aspectj.weaver.ast.Instanceof;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@Entity
@Table(name = User.TABLE_NAME)
public class user {
    public interface CreateUser{

    }
    public interface  UpdateUser {
    }

    public static final String TABLE_NAME = "user";
    //para não retornar a senha para o front end, o usuário não vai ver sua senha exibida na tela, apenas escrevê-la
    @JsonProperty(access = Access.WRITE_ONLY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id", unique = true)
    private Long id;

    @Column(name = "username", length = 100, nullable = false, unique = true)
    @NotNull(groups = CreateUser.class)
    @NotEmpty(groups = CreateUser.class)
    @Size(groups = CreateUser.class, min = 2, max = 100)
    private String username;

    @Column(name = "password", length = 60, nullable = false)
    //verificação para criação e atualização de senha, não utilizado no username pois nessa regra de negócios não vamos
    //atualizar o usuário, só a senha
    @NotNull(groups = {CreateUser.class, UpdateUser.class})
    @NotEmpty(groups = {CreateUser.class, UpdateUser.class})
    @Size(groups = {CreateUser.class, UpdateUser.class}, min = 8, max = 60)
    private String password;


    //private List<Task> tasks = new ArrayList<Task>();


    public user() {
    }

    //quando alguém criar o usuário, ele vai cair nesse construtor
    public user(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public boolean equals(Object obj) {
      if(obj == this)
        return true;
      if(!(obj Instanceof User))
        return false;
      if(obj == null)
        return false;
      User other = (User) obj;
      if(this.id == null)
        if(other.id!= null)
            return false;
        else if(!this.id.equals(other.id))
            return false;
      return Objects.equals(this.id, other.id) & Objects.equals(this.username, other.username)
            && Objects.equals(this.password, other.password);
      
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null)  ? 0 : this.id.hashCode());
        return result;
    }



   

}
