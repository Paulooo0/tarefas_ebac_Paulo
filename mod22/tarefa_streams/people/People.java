package tarefa_streams.people;

public class People {
    private String name;
    private String gender;

    public People() {
    }

    public People(String name, String gender) {
        this.name = name;
        this.gender = gender;        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
