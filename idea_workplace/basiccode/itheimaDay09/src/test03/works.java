package test03;

public abstract  class works {
    private String name;
    private String Num;
    public abstract void work();

    public works(String name, String num) {
        this.name = name;
        Num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return Num;
    }

    public void setNum(String num) {
        Num = num;
    }
}
