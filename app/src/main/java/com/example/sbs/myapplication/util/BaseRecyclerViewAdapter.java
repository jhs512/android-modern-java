package com.example.sbs.myapplication.util;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sbs.myapplication.BR;

import java.util.List;

public class BaseRecyclerViewAdapter<DT extends BaseRecyclerViewAdapter.HaveItemViewModel> extends RecyclerView.Adapter<BaseRecyclerViewAdapter.ViewHolder> {
    private LayoutInflater layoutInflater;
    private List<DT> items;
    private int itemLayoutId;

    public BaseRecyclerViewAdapter(int layoutId) {
        this.itemLayoutId = layoutId;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        ViewDataBinding binding =
                DataBindingUtil.inflate(layoutInflater, itemLayoutId, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public int getItemCount() {
        if (items == null) {
            return 0;
        }
        return items.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DT item = items.get(position);
        holder.binding.setVariable(BR.vm, item.getItemViewModel(itemLayoutId));
    }

    public void setItems(List items) {
        this.items = items;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewDataBinding binding;

        public ViewHolder(ViewDataBinding binding) {
            this(binding.getRoot());
            this.binding = binding;
        }

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public interface HaveItemViewModel {
        ViewModel getItemViewModel(int layoutId);
    }
}
