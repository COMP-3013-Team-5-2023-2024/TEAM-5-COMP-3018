package com.example.periodtracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * SymptomRecyclerViewAdapter is a recycler view adapter that displays stored symptoms to the user
 * allowing them to continually scroll down.
 */
public class SymptomRecyclerViewAdapter extends RecyclerView.Adapter<SymptomRecyclerViewAdapter.SymptomViewHolder> {

    /**
     * SymptomViewHolder represents one object contained inside SymptomRecyclerViewAdapter.
     */
    public class SymptomViewHolder extends RecyclerView.ViewHolder {

        private TextView dateText;
        private TextView symptomText;
        private TextView moodText;
        private SymptomsRecord record;

        /**
         * Constructs a new SymptomViewHolder.
         *
         * @param itemView View object to be bound to.
         */
        public SymptomViewHolder(View itemView) {
            super(itemView);
            dateText = itemView.findViewById(R.id.dateText);
            symptomText = itemView.findViewById(R.id.symptomsText);
            moodText = itemView.findViewById(R.id.moodText);
        }

        /**
         * Binds symptom record data to the view.
         *
         * @param record SymptomRecord data to be displayed.
         */
        public void bind(SymptomsRecord record) {
            this.record = record;
            String date = record.date.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
            dateText.setText(date);
            symptomText.setText(record.symptoms);
            moodText.setText(record.mood);
        }

    }

    private AppDatabase database;
    private SymptomsDao symptomsDao;
    private LayoutInflater layoutInflater;
    private List<SymptomsRecord> records;

    /**
     * Constructs a new SymptomRecyclerViewAdapter.
     *
     * @param context Current application context.
     */
    public SymptomRecyclerViewAdapter(Context context) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        database = Room.databaseBuilder(context, AppDatabase.class, context.getString(R.string.database_name))
                .allowMainThreadQueries()
                .build();
        symptomsDao = database.symptomsDAO();
        records = symptomsDao.getAll();
    }

    @Override
    public SymptomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View symptomView = layoutInflater.inflate(R.layout.symptom_layout, parent, false);
        return new SymptomViewHolder(symptomView);
    }

    @Override
    public void onBindViewHolder(SymptomViewHolder holder, int position) {
        holder.bind(records.get(position));
    }

    @Override
    public int getItemCount() {
        return records.size();
    }

}
