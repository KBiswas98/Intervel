


package com.musk.android.intervel.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.musk.android.intervel.Movie.Movies;
import com.musk.android.intervel.R;

import java.util.List;

public class RecyclerAdaptar extends RecyclerView.Adapter<RecyclerAdaptar.ViewHolder> {
    private static final String TAG = "RecyclerAdaptar";
    private Context mContext;
    private List<Movies> mMovies;
//    private ProgressBar progressBar;

    public RecyclerAdaptar(Context mContext, List<Movies> mMovies) {
        this.mContext = mContext;
        this.mMovies = mMovies;
//        this.progressBar = progressBar;
    }

    @NonNull
    @Override
    public RecyclerAdaptar.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        view = layoutInflater.inflate(R.layout.item_recyclerview,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdaptar.ViewHolder viewHolder, int i) {
        viewHolder.movieName.setText(mMovies.get(i).getMovieName());
        viewHolder.movieReating.setText(Double.toString(mMovies.get(i).getReating()));

//        this.progressBar.setVisibility(View.VISIBLE);
        Glide.with(mContext).load(mMovies.get(i).getThumbnail()).listener(new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                Log.d(TAG, "onException: ");
                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                Log.d(TAG, "onResourceReady: ");
                return false;
            }
        }).into(viewHolder.movieThumbneil);
//        this.progressBar.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView movieName,movieReating;
        ImageView movieThumbneil;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            movieName = (TextView)itemView.findViewById(R.id.card_movie_name);
            movieReating = (TextView)itemView.findViewById(R.id.card_movie_reating);
            movieThumbneil = (ImageView) itemView.findViewById(R.id.card_movie_image);
            cardView = (CardView)itemView.findViewById(R.id.gried_card);
        }
    }
}





















































//package com.musk.android.intervel.utils;
//
//import android.content.Context;
//import android.support.annotation.NonNull;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import com.musk.android.intervel.R;
//
//public class RecyclerAdaptar extends RecyclerView.Adapter<RecyclerAdaptar.ViewHolder>  {
//    private String[] mData;
//    private LayoutInflater mInflater;
//    private ItemClickListener mClickListener;
//
//    // data is passed into the constructor
//    public RecyclerAdaptar(Context context, String[] data) {
//        this.mInflater = LayoutInflater.from(context);
//        this.mData = data;
//    }
//
//    // inflates the cell layout from xml when needed
//    @Override
//    @NonNull
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = mInflater.inflate(R.layout.item_recyclerview, parent, false);
//        return new ViewHolder(view);
//    }
//
//    // binds the data to the TextView in each cell
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        holder.myTextView.setText(mData[position]);
//    }
//
//
//    // total number of cells
//    @Override
//    public int getItemCount() {
//        return mData.length;
//    }
//
//
//    // stores and recycles views as they are scrolled off screen
//    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
//        TextView myTextView;
//
//        ViewHolder(View itemView) {
//            super(itemView);
//            myTextView = itemView.findViewById(R.id.info_text);
//            itemView.setOnClickListener(this);
//        }
//
//        @Override
//        public void onClick(View view) {
//            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
//        }
//    }
//
//    // convenience method for getting data at click position
//    public String getItem(int id) {
//        return mData[id];
//    }
//
//    // allows clicks events to be caught
//    public void setClickListener(ItemClickListener itemClickListener) {
//        this.mClickListener = itemClickListener;
//    }
//
//    // parent activity will implement this method to respond to click events
//    public interface ItemClickListener {
//        void onItemClick(View view, int position);
//    }
//}
