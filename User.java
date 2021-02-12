
public class User {

    private final String username,password,first_name,last_name,email,gender,month_of_birth;
    private final int phone_number,day_of_birth,year_of_birth;

    public User(String username,String first_name,String last_name,int phone_number,String email,String password,
                String gender,int day_of_birth,String month_of_birth,int year_of_birth)
    {
        this.username=username;
        this.password=password;
        this.first_name=first_name;
        this.last_name=last_name;
        this.phone_number=phone_number;
        this.email=email;
        this.gender=gender;
        this.day_of_birth=day_of_birth;
        this.month_of_birth=month_of_birth;
        this.year_of_birth=year_of_birth;
    }

    public String getUsername(){return username;}
    public String getFirst_name(){return first_name;}
    public String getLast_name(){return last_name;}
    public int getPhone_number(){return phone_number;}
    public String getEmail(){return email;}
    public String getPassword(){return password;}
    public String getGender(){return gender;}
    public int getDay_of_birth(){return day_of_birth;}
    public String getMonth_of_birth(){return month_of_birth;}
    public int getYear_of_birth(){return year_of_birth;}

}
