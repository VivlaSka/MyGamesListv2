package be.ehb.matheodexelle.mygameslistv2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.ViewHolder> {
    public interface ItemClicked {
        void onItemClicked(int idex);
    }
    ItemClicked activity;

    private ArrayList<Game> games;

    public GameAdapter(Context context, ArrayList<Game> list){
        games = list;
        activity = (ItemClicked)context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvGameName,tvGameDesc,tvGameDev;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            tvGameName = itemView.findViewById(R.id.tvGameName);
            tvGameDesc = itemView.findViewById(R.id.tvGameDesc);
            tvGameDev = itemView.findViewById(R.id.tvGameDev);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.onItemClicked(games.indexOf((Game)v.getTag()));
                }
            });
        }
    }

    @NonNull
    @Override
    public GameAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout, viewGroup, false);

        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull GameAdapter.ViewHolder viewHolder, int i) {
        viewHolder.itemView.setTag(games.get(i));
        viewHolder.tvGameName.setText(games.get(i).getName());
        viewHolder.tvGameDesc.setText(games.get(i).getDescription());
        viewHolder.tvGameDev.setText(games.get(i).getDev());
    }
    @Override
    public int getItemCount() {
        return games.size();
    }
}
