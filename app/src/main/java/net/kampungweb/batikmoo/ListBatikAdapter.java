package net.kampungweb.batikmoo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListBatikAdapter extends RecyclerView.Adapter<ListBatikAdapter.ListViewHolder> {

    private ArrayList<Batik> listBatik;

    public ListBatikAdapter(ArrayList<Batik> listBatik) {
        this.listBatik = listBatik;
    }

    //Interface onItemClickListener
    private OnItemClickCallBack onItemClickCallBack;

    public void setOnItemClickCallBack(OnItemClickCallBack onItemClickCallBack){
        this.onItemClickCallBack = onItemClickCallBack;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_batik, parent, false);

        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Batik batik = listBatik.get(position);

        holder.tvBatikName.setText(batik.getName());
        holder.tvBatikFrom.setText(batik.getFrom());
        holder.tvBatikContent.setText(batik.getContent());

        Glide.with(holder.itemView.getContext())
                .load(batik.getPhoto())
                .apply(new RequestOptions().override(88,88))
                .into(holder.imgPhotoBatik);

        //onClickListener item batik
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallBack.onItemClicked(listBatik.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listBatik.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {

        ImageView imgPhotoBatik;
        TextView tvBatikName, tvBatikFrom, tvBatikContent;


        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPhotoBatik = itemView.findViewById(R.id.img_batik_photo);
            tvBatikName = itemView.findViewById(R.id.batik_name);
            tvBatikFrom = itemView.findViewById(R.id.batik_from);
            tvBatikContent = itemView.findViewById(R.id.batik_content);
        }
    }

    // Parameter Interface onClickItem
    public interface OnItemClickCallBack{
        void onItemClicked(Batik data);
    }
}
