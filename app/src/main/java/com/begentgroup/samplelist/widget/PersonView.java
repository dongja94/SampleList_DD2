package com.begentgroup.samplelist.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.begentgroup.samplelist.R;
import com.begentgroup.samplelist.data.Person;

/**
 * Created by Administrator on 2016-07-13.
 */
public class PersonView extends FrameLayout {
    public PersonView(Context context) {
        this(context, null);
    }

    public PersonView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    ImageView photoView;
    TextView nameView, ageView;

    private void init() {
//        LayoutInflater inflater = LayoutInflater.from(getContext());
//        inflater.inflate(R.layout.view_person, this);
        inflate(getContext(), R.layout.view_person, this);
        photoView = (ImageView)findViewById(R.id.image_photo);
        nameView = (TextView)findViewById(R.id.text_name);
        ageView = (TextView)findViewById(R.id.text_age);
    }

    Person person;
    public void setPerson(Person person) {
        this.person = person;
        nameView.setText(person.getName());
        ageView.setText(""+person.getAge());
        photoView.setImageDrawable(person.getPhoto());
    }

    public Person getPerson() {
        return person;
    }


}
