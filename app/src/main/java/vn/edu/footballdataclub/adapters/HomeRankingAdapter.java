package vn.edu.footballdataclub.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.edu.footballdataclub.Club;
import vn.edu.footballdataclub.R;

public class HomeRankingAdapter extends RecyclerView.Adapter<HomeRankingAdapter.ViewHolder>{
    private final List<Club> clubs;
    public HomeRankingAdapter(List<Club> clubs) {
        this.clubs = clubs;
    }
    @NonNull
    @Override
    public HomeRankingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_club, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeRankingAdapter.ViewHolder holder, int position) {
        Club club = clubs.get(position);
        holder.tvNo.setText(String.valueOf(club.rank));
        holder.tvClub.setText(club.name);
        holder.tvCountry.setText(club.country);
        holder.tvPoint.setText(String.valueOf(club.point));
        holder.imgClub.setImageResource(club.logoRes);
        holder.imgFlag.setImageResource(club.flagRes);

        if (club.rank == 1) {
            holder.tvNo.setBackgroundResource(R.drawable.bg_rank_1);
        } else if (club.rank == 2) {
            holder.tvNo.setBackgroundResource(R.drawable.bg_rank_2);
        } else if (club.rank == 3) {
            holder.tvNo.setBackgroundResource(R.drawable.bg_rank_3);
        } else {
            holder.tvNo.setBackgroundResource(R.drawable.ic_circle);
        }
    }

    @Override
    public int getItemCount() {
        return clubs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvNo, tvClub, tvCountry, tvPoint;
        ImageView imgClub, imgFlag;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNo = itemView.findViewById(R.id.tvNo);
            tvClub = itemView.findViewById(R.id.tvClub);
            tvCountry = itemView.findViewById(R.id.tvCountry);
            tvPoint = itemView.findViewById(R.id.tvPoint);
            imgClub = itemView.findViewById(R.id.imgClub);
            imgFlag = itemView.findViewById(R.id.imgFlag);
        }
    }
}
