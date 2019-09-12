package com.example.sd.learningproject;

import java.util.List;

public class DynamicModule {

    private String code;
    private String name;
    private int layout;
    private List<Module> modules;

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLayout(int layout) {
        this.layout = layout;
    }

    public int getLayout() {
        return layout;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    public List<Module> getModules() {
        return modules;
    }
}
