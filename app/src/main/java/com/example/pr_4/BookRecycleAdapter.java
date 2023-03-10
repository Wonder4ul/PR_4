package com.example.pr_4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BookRecycleAdapter  extends RecyclerView.Adapter<BookRecycleAdapter.ViewHolder>{

    private final LayoutInflater inflater;
    private final List<BookInfo> books;

    BookRecycleAdapter(Context context, List<BookInfo> books) {
        this.books = books;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public BookRecycleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BookRecycleAdapter.ViewHolder holder, int position) {
        BookInfo book = books.get(position);
        holder.picView.setImageResource(book.getPictureResource());
        holder.nameView.setText(book.getName());
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView picView;
        final TextView nameView;
        ViewHolder(View view){
            super(view);
            picView = view.findViewById(R.id.pic);
            nameView = view.findViewById(R.id.name);
        }
    }
}