package com.example.periodtracker;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Optional;

public class Health extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);

        RecyclerView recyclerView1 = findViewById(R.id.health_page_recycle_view_1);
        RecyclerView recyclerView2 = findViewById(R.id.health_page_recycle_view_2);
        RecyclerView recyclerView3 = findViewById(R.id.health_page_recycle_view_3);

        // TODO (matthew fletcher) add a database for the questions / answers (should be stored on creation)

        ArrayList<QuestionAnswerData> qa1 = new ArrayList<>();
        qa1.add(new QuestionAnswerData("When can I get pregnant?", "You are the most fertile during ovulation approximately 10 to 16 days before your next period, but there is still a chance of getting pregnant during any point in your cycle.", Optional.empty()));
        qa1.add(new QuestionAnswerData("What does my discharge mean?", "Your discharge is normal if it does not have a strong / unpleasant smell, is clear / white, is thick and sticky and is slippery and wet.", Optional.empty()));
        qa1.add(new QuestionAnswerData("Are period cramps normal?", "Period cramps are normal. They can also be accompanied by headaches nausea and even loose stool. However, you should have it checked out if the pain is unbearable, new, consistent, or if could be related to a recent birth, miscarriage or abortion.", Optional.empty()));
        qa1.add(new QuestionAnswerData("Why are period poops a thing?", "There are two leading theories. Firstly, prostaglandins (which also cause muscles in your uterus to contract) may cause diarrhea. Secondly, higher levels of oestrogen can cause constipation, so if a pregnancy does not occur the hormones drop causing diarrhea.", Optional.empty()));

        ArrayList<QuestionAnswerData> qa2 = new ArrayList<>();
        qa2.add(new QuestionAnswerData("What are early signs of pregnancy?", "Missed / light periods, nausea, tiredness, sore breasts and strange cravings can all be signs, If you are having questions one of the best ways to find out is to use a home pregnancy test.", Optional.empty()));
        qa2.add(new QuestionAnswerData("What types of birth control are there?", "There are hormonal contraceptives such as the pill or implant, permanent options such as vasectomy or tubal ligation, you can use the morning after pill or a condom, or if you'd prefer to be natural then there is the pull out method or natural family planning.", Optional.empty()));
        qa2.add(new QuestionAnswerData("What to do after unprotected sex", "Explore emergency contraceptives such as plan B (if you do not wish to be pregnant). Have a pregnancy test (typically it is best to wait 3 weeks), get tested for STI's. If you where unable or unwilling to consent please connect with local police or campus resources.", Optional.empty()));
        qa2.add(new QuestionAnswerData("How to delay or stop a your period?", "You can do this hormonally by using continuous cycle pills or by skipping the placebo week of birth control. If you wish to reduce period pain you can use ibuprofen to reduce blood flow or heat massaging your abdomen.", Optional.empty()));

        ArrayList<QuestionAnswerData> qa3 = new ArrayList<>();
        qa3.add(new QuestionAnswerData("How to reduce hormonal bloating?", "Hormonal bloating is typically related to changes in estrogen which can cause the body to retain more water and salt. This can be reduced by, cutting down on salty foods, eating high potassium foods, drinking water and exercising.", Optional.empty()));
        qa3.add(new QuestionAnswerData("Spotting vs period bleeding", "Spotting and bleeding are not the same thing, spotting is the light bleeding that occurs outside of your regular menstrual cycle. Bleeding, on the other hand is a heavier blood flow that occurs during your period.", Optional.empty()));
        qa3.add(new QuestionAnswerData("How stress affects your period", "Stress can effect the timing of your period making it occur earlier later or even missing the period entirely. To reduce stress you can try meditation, breathing exercises or connecting with others and talking to them about how you feel.", Optional.empty()));
        qa3.add(new QuestionAnswerData("Is it safe to have sex during your period?", "Unless it troubles you, there's no reason to avoid sexual activity during your period though it can be a bit messy, it is safe.", Optional.empty()));

        recyclerView1.setAdapter(new QAAdaptor(qa1, getApplicationContext()));
        recyclerView2.setAdapter(new QAAdaptor(qa2, getApplicationContext()));
        recyclerView3.setAdapter(new QAAdaptor(qa3, getApplicationContext()));

        // add this to the bottom of pages for navigation
        // Initialize and assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Set to highlight current page
        bottomNavigationView.setSelectedItemId(R.id.health);

        // Perform item selected listener
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.today) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                overridePendingTransition(0, 0);
                return true;
            } else if (item.getItemId() == R.id.health) {
                return true;
            } else if (item.getItemId() == R.id.symptoms) {
                startActivity(new Intent(getApplicationContext(), SymptomsActivity.class));
                overridePendingTransition(0, 0);
                return true;
            } else {
                return false;
            }
        });
    }
}