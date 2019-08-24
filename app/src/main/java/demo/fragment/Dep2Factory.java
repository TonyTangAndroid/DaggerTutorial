package demo.fragment;

import javax.inject.Inject;

class Dep2Factory {

    @Inject
    public Dep2Factory() {
        this.age = 32;
    }

    public int getAge() {
        return age;
    }

    private int age;


}
