package com.example.rahms.ui.rahms;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rahms.R;

import java.util.List;

public class RecyclerViewConfig {

    private Context mContext;
    private SensorsAdapter mSensorsAdapter;

    public void setConfig(RecyclerView recyclerView, Context context, List<RAHMS> rahms, List<String> keys) {
        mContext = context;
        mSensorsAdapter = new SensorsAdapter(rahms, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mSensorsAdapter);
    }

    class SensorItemView extends RecyclerView .ViewHolder{

        private TextView textViewBME280H;
        private TextView textViewBME280P;
        private TextView textViewBME280T;
        private TextView textViewCCS811CO2;
        private TextView textViewCCS811tVOC;
        private TextView textViewLDR;
        private TextView textViewSoilMoisture;
        private TextView textViewSoilTemp;
        private TextView nodeName;

        private String key;

        public SensorItemView(ViewGroup parent){
            super(LayoutInflater.from(mContext).inflate(R.layout.sensors_item, parent, false));

            textViewBME280H = (TextView) itemView.findViewById(R.id.textViewBME280H);
            textViewBME280P = (TextView) itemView.findViewById(R.id.textViewBME280P);
            textViewBME280T = (TextView) itemView.findViewById(R.id.textViewBME280T);
            textViewCCS811CO2 = (TextView) itemView.findViewById(R.id.textViewCCS811CO2);
            textViewCCS811tVOC = (TextView) itemView.findViewById(R.id.textViewCCS811TVOC);
            textViewLDR = (TextView) itemView.findViewById(R.id.textViewLDR);
            textViewSoilMoisture = (TextView) itemView.findViewById(R.id.textViewSoilMoisture);
            textViewSoilTemp = (TextView) itemView.findViewById(R.id.textViewSoilTemp);
            nodeName = (TextView) itemView.findViewById(R.id.node_name);

        }

        public void bind(RAHMS rahms, String key){
            double twoDecimalHum = Math.round(rahms.getBME280_Hum()*100)/100.00;
            double twoDecimalPres = Math.round(rahms.getBME280_Pres()*100)/100.00;
            double twoDecimalTemp = Math.round(rahms.getBME280_Temp()*100)/100.00;

            textViewBME280H.setText(String.valueOf(twoDecimalHum));
            textViewBME280P.setText(String.valueOf(twoDecimalPres));
            textViewBME280T.setText(String.valueOf(twoDecimalTemp));
            textViewCCS811CO2.setText(rahms.getCCS811_CO2().toString());
            textViewCCS811tVOC.setText(rahms.getCCS811_tVOC().toString());
            textViewSoilTemp.setText(rahms.getSoil_Temp().toString());
            textViewSoilMoisture.setText(rahms.getSoil_Moisture().toString());
            textViewLDR.setText(rahms.getLDR().toString());

            nodeName.setText(key);
            this.key = key;

        }
    }
    class SensorsAdapter extends RecyclerView.Adapter<SensorItemView>{
        private List<RAHMS> mSensorList;
        private List<String> mKeys;

        public SensorsAdapter(List<RAHMS> mSensorList, List<String> mKeys) {
            this.mSensorList = mSensorList;
            this.mKeys = mKeys;
        }

        @NonNull
        @Override
        public SensorItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new SensorItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull SensorItemView holder, int position) {
                holder.bind(mSensorList.get(position), mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mSensorList.size();
        }
    }
}
