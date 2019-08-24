package demo.fragment;

class Dep1Factory {

    public String getName() {
        return name;
    }

    private String name;

    public Dep1Factory(String name) {
        this.name = name;
    }

    public static Dep1Factory newInstance() {
        return new Dep1Factory("tony");
    }
}
