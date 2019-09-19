package com.example.sd.learningproject.Builder;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Builder设计模式的实现
 */
public class BuilderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Person.Builder builder = new Person.Builder();
        Person person = builder.name("mantianxing")
                .age(21)
                .isGirl(true)
                .build();

        Toast.makeText(this, person.getName() + "\n" + person.getAge() + "\n" + person.isGirl() + "\n", Toast.LENGTH_SHORT).show();
    }
}
