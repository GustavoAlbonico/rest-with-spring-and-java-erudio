package br.com.erudio.data.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.erudio.serializer.GenderSerializer;

// import com.fasterxml.jackson.annotation.JsonIgnore;
// import com.fasterxml.jackson.annotation.JsonProperty;
// import com.fasterxml.jackson.annotation.JsonPropertyOrder;

// @JsonPropertyOrder({"id","first_name","last_name","address","genger"})
@JsonFilter("PersonFilter")
public class PersonDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    // @JsonProperty("first_name")
    private String firstName;

    // @JsonProperty("last_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String lastName;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String phoneNumber;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @JsonSerialize(using = GenderSerializer.class)
    private Date birthDay;

    private String address;

    // @JsonIgnore
    private String gender;

    private String sensitiveData;


    public PersonDTO() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getBirthDay() {
        return this.birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSensitiveData() {
        return this.sensitiveData;
    }

    public void setSensitiveData(String sensitiveData) {
        this.sensitiveData = sensitiveData;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PersonDTO)) {
            return false;
        }
        PersonDTO personDTO = (PersonDTO) o;
        return Objects.equals(id, personDTO.id) && Objects.equals(firstName, personDTO.firstName) && Objects.equals(lastName, personDTO.lastName) && Objects.equals(phoneNumber, personDTO.phoneNumber) && Objects.equals(birthDay, personDTO.birthDay) && Objects.equals(address, personDTO.address) && Objects.equals(gender, personDTO.gender) && Objects.equals(sensitiveData, personDTO.sensitiveData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, phoneNumber, birthDay, address, gender, sensitiveData);
    }
}
