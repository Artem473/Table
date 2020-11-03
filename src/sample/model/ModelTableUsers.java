package sample.model;

public class ModelTableUsers {

    private String id;
    private String firstname;
    private String lastname;
    private String email;
    private String login;
    private String password;

    public ModelTableUsers (String id,String firstname,String lastname,String email, String login, String password){
    }
    public String getId(){
        return id;
    }
    public String getFirstname(){
        return firstname;
    }
    public String getLastname(){
        return lastname;
    }
    public String getEmail(){
        return email;
    }
    public String getLogin(){
        return login;
    }
    public String getPassword(){
        return password;
    }
}
