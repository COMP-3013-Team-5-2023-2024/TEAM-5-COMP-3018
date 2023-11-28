package com.example.periodtracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class QAAdaptor extends RecyclerView.Adapter<QAAdaptor.ViewHolder> {

    ArrayList<QuestionAnswerData> questionAnswerList;
    Context context;

    public QAAdaptor(ArrayList<QuestionAnswerData> questionAnswerList, Context context) {
        this.questionAnswerList = questionAnswerList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.question_answer_item, parent, false);
        return new QAAdaptor.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        QuestionAnswerData data = questionAnswerList.get(position);
        holder.questionText.setText(data.question);
        holder.questionText.setText(data.answer);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.changeState();
            }
        });
    }

    @Override
    public int getItemCount() {
        return questionAnswerList.size();
    }

    public enum QAState {
        Question,
        Answer
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        QAState state = QAState.Question;

        LinearLayout answerLayout, questionLayout;

        TextView answerText, questionText;

        public ViewHolder(View view) {
            super(view);
            answerText = view.findViewById(R.id.question_answer_answer_text);
            questionText = view.findViewById(R.id.question_answer_question_text);
            answerLayout = view.findViewById(R.id.question_answer_answer_layout);
            questionLayout = view.findViewById(R.id.question_answer_question_layout);
        }

        public void changeState() {
            if (state == QAState.Question) {
                state = QAState.Answer;
                answerLayout.setVisibility(View.VISIBLE);
                questionLayout.setVisibility(View.GONE);
                return;
            }
            state = QAState.Question;
            answerLayout.setVisibility(View.GONE);
            questionLayout.setVisibility(View.VISIBLE);
        }
    }
}

