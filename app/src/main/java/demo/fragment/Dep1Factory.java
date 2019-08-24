package demo.fragment;

import javax.inject.Inject;

class Dep1Factory {

    public String getName() {
        return name;
    }

    private String name;

    @Inject
    public Dep1Factory() {
        this.name = "Tony";
    }


}
