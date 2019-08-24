package demo.fragment;

class Dep2Factory {

    public int getAge() {
        return age;
    }

    private int age;

    public Dep2Factory(int age) {
        this.age = age;
    }

    public static Dep2Factory newInstance() {
        return new Dep2Factory(32);
    }
}
