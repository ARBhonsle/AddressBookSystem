package com.company;

/**
 * Class stores Contact Person's details
 */
public class PersonDetails {
    String firstName,lastName,address,city,state,email;
    int zipCode;
    long phoneNumber;

    public PersonDetails(){
    }

    public PersonDetails(String firstName,String lastName,String address,String city, String state, String email, int zipCode,long phoneNumber){
        setFirstName(firstName);
        setLastName(lastName);
        setAddress(address);
        setCity(city);
        setState(state);
        setEmail(email);
        setZipCode(zipCode);
        setPhoneNumber(phoneNumber);
    }

    public void setFirstName(String name){
        this.firstName=name;
    }
    public void setLastName(String name){
        this.lastName=name;
    }
    public void setAddress(String address){
        this.address=address;
    }
    public void setCity(String city){
        this.city=city;
    }
    public void setState(String state){
        this.state=state;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public void setZipCode(int zipCode){
        this.zipCode=zipCode;
    }
    public void setPhoneNumber(long phoneNumber){
        this.phoneNumber=phoneNumber;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getAddress() {
        return address;
    }
    public String getCity() {
        return city;
    }
    public String getState() {
        return state;
    }
    public String getEmail() {
        return email;
    }
    public int getZipCode() {
        return zipCode;
    }
    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void showDetails(){
        System.out.println("Person Name: "+this.getFirstName()+" "+this.getLastName()+"\nEmail: "+this.getEmail()+"\nPhone Number: "+this.getPhoneNumber()+"\nAddress: "+this.getAddress()+"\nCity: "+this.getCity()+"\nState: "+this.getState()+"\nZipCode: "+this.getZipCode());
    }
    public String getDetails(){
        return "Person Name: "+this.getFirstName()+" "+this.getLastName()+"\nEmail: "+this.getEmail()+"\nPhone Number: "+this.getPhoneNumber()+"\nAddress: "+this.getAddress()+"\nCity: "+this.getCity()+"\nState: "+this.getState()+"\nZipCode: "+this.getZipCode();
    }

}

