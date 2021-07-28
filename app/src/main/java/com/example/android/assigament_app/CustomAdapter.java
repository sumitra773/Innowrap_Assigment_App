package com.example.android.assigament_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context mContext;
    List<ItemModel> mItemModels;

    public CustomAdapter(Context context, List<ItemModel> itemModels) {
        mContext = context;
        mItemModels = itemModels;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        int layout = 0;
        RecyclerView.ViewHolder viewHolder;
        switch (viewType) {
            case 0:
                layout = R.layout.item_actionable;
                view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
                viewHolder = new ImageTypeViewHolder(view);
                break;
            case 1:
                layout = R.layout.item_video;
                view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
                viewHolder = new VideoTypeViewHolder(view);
                break;
            case 2:
                layout = R.layout.item_non_actionable;
                view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
                viewHolder = new TextTypeViewHolder(view);
                break;
            default:
                viewHolder = null;
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ItemModel model = mItemModels.get(position);
        switch (model.type) {
            case "ACTION": {
                Glide.with(mContext).load(model.img).into(((ImageTypeViewHolder) holder).image);
                ((ImageTypeViewHolder) holder).imageTextType.setText(model.subHeader);
                break;
            }
            case "VIDEO": {
                Glide.with(mContext).load(model.img).into(((VideoTypeViewHolder) holder).mImageVideo);
                break;
            }
            case "NON-ACTION": {
                ((TextTypeViewHolder) holder).header.setText(model.header);
                ((TextTypeViewHolder) holder).sub_header.setText(model.subHeader);
                break;

            }
        }
    }


    @Override
    public int getItemViewType(int position) {
        switch (mItemModels.get(position).type) {
            case "ACTION":
                return 0;
            case "VIDEO":
                return 1;
            case "NON-ACTION":
                return 2;
            default:
                return -1;
        }
    }

    @Override
    public int getItemCount() {
        return mItemModels.size();
    }

    public static class TextTypeViewHolder extends RecyclerView.ViewHolder {

        TextView header;
        TextView sub_header;


        public TextTypeViewHolder(View itemView) {
            super(itemView);

            this.header = (TextView) itemView.findViewById(R.id.tv_header);
            this.sub_header = itemView.findViewById(R.id.tv_sub_header);
        }
    }

    public static class ImageTypeViewHolder extends RecyclerView.ViewHolder {

        TextView imageTextType;
        ImageView image;

        public ImageTypeViewHolder(View itemView) {
            super(itemView);

            this.imageTextType = (TextView) itemView.findViewById(R.id.tv_header);
            this.image = (ImageView) itemView.findViewById(R.id.img);
        }
    }

    public static class VideoTypeViewHolder extends RecyclerView.ViewHolder {

        ImageView mImageVideo;

        public VideoTypeViewHolder(View itemView) {
            super(itemView);

            this.mImageVideo = itemView.findViewById(R.id.img_video);

        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mImageView;
        TextView title, header;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_view);
            title = itemView.findViewById(R.id.title);
            header = itemView.findViewById(R.id.header_title);
        }
    }
}
