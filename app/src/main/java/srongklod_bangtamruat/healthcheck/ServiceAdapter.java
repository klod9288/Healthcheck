package srongklod_bangtamruat.healthcheck;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ServiceViewHolder>{

    private Context context;
    private ArrayList<String> nameStringArrayList;
    private LayoutInflater layoutInflater;

    public ServiceAdapter(Context context, ArrayList<String> nameStringArrayList) {
        this.layoutInflater = LayoutInflater.from(context);
        this.nameStringArrayList = nameStringArrayList;
    }

    @NonNull
    @Override
    public ServiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.recycler_layout, parent, false);
        ServiceViewHolder serviceViewHolder = new ServiceViewHolder(view);

        return serviceViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceViewHolder holder, int position) {

        String name = nameStringArrayList.get(position);

        holder.textView.setText(name);

    }

    @Override
    public int getItemCount() {
        return nameStringArrayList.size();
    }

    class ServiceViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public ServiceViewHolder(View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.txtName);

        }
    }//ServiceViewHolder Class



}//Main Class
