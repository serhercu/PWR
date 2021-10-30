package Tutorials.Tut.Tut3.List8;

public class User {
    private int id;
    private String name;
    private String email;
    private String mobile;

    public boolean equals(User user){
        if(id == this.id && name == this.name && email == this.email && mobile == this.mobile){
            return true;
        } else { return false; }
    }
}
