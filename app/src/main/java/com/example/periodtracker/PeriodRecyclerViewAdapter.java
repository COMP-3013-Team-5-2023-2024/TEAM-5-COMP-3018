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

public class PeriodRecyclerViewAdapter extends RecyclerView.Adapter<PeriodRecyclerViewAdapter.PeriodViewHolder> {

    /**
     * SymptomViewHolder represents one object contained inside SymptomRecyclerViewAdapter.
     */
    public class PeriodViewHolder extends RecyclerView.ViewHolder {

        private TextView startText;
        private TextView endText;
        private PeriodRecord record;

        /**
         * Constructs a new PeriodViewHolder.
         *
         * @param itemView View object to be bound to.
         */
        public PeriodViewHolder(View itemView) {
            super(itemView);
            startText = itemView.findViewById(R.id.startDateText);
            endText = itemView.findViewById(R.id.endDateText);
        }

        /**
         * Binds period record data to the view.
         *
         * @param record PeriodRecord data to be displayed.
         */
        public void bind(PeriodRecord record) {
            this.record = record;
            startText.setText(this.record.startDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
            endText.setText(this.record.endDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
        }

    }

    private AppDatabase database;
    private PeriodDao periodDao;
    private LayoutInflater layoutInflater;
    private List<PeriodRecord> records;

    /**
     * Constructs a new PeriodRecyclerViewAdapter.
     *
     * @param context Current application context.
     */
    public PeriodRecyclerViewAdapter(Context context) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        database = Room.databaseBuilder(context, AppDatabase.class, context.getString(R.string.database_name))
                .allowMainThreadQueries()
                .build();
        periodDao = database.periodDao();
        records = periodDao.getAll();
    }

    @Override
    public PeriodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View periodView = layoutInflater.inflate(R.layout.symptom_layout, parent, false);
        return new PeriodViewHolder(periodView);
    }

    @Override
    public void onBindViewHolder(PeriodViewHolder holder, int position) {
        holder.bind(records.get(position));
    }

    @Override
    public int getItemCount() {
        return records.size();
    }

}
