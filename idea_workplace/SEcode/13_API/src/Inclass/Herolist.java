package Inclass;

public class Herolist extends  man{
    private String name;

    public Herolist(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Herolist{" +
                "name='" + name + '\'' +
                '}';
    }
    public  void eatfood(String s,myinter mi1){
        mi1.method(s);
    }

}
