package com.staxter.mobilunity.model;

public class ResponseDto {

    private String id;
    private String firstName;
    private String lastName;
    private String userName;

    public ResponseDto() { }

    public ResponseDto(String id, String firstName, String lastName, String userName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public static ResponseDto apply(final User user) {
        return new ResponseDto(user.getId(), user.getFirstName(), user.getLastName(), user.getUserName());
    }

    @Override
    public String toString() {
        return "ResponseDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
