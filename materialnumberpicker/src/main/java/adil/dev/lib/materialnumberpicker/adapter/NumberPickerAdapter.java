package adil.dev.lib.materialnumberpicker.adapter;

import android.content.Context;
import android.os.Vibrator;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import adil.dev.lib.materialnumberpicker.R;
import adil.dev.lib.materialnumberpicker.model.IntervalModel;


/**
 * Created by Adil on 26/11/2015.
 */
public class NumberPickerAdapter extends RecyclerView.Adapter<NumberPickerAdapter.DialogViewHolder> {

    Context mContext;
    LayoutInflater inflater;
    ArrayList<IntervalModel> dataList = new ArrayList<>();
    ItemClickCallBack itemClickCallBack;

    NumberPickerAdapter instance;

    public NumberPickerAdapter(Context context, ItemClickCallBack itemClickCallBack, int start, int last) {
        this.mContext = context;
        inflater = LayoutInflater.from(context);
        this.itemClickCallBack = itemClickCallBack;
        initList(start,last);
        instance = this;

    }

    @Override
    public DialogViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DialogViewHolder(inflater.inflate(R.layout.interval_picker_item, parent, false));
    }

    @Override
    public void onBindViewHolder(DialogViewHolder holder, int position) {
        holder.number.setText(dataList.get(position).getValue()+"");
        if(dataList.get(position).isHasFocus()){
            holder.itemParent.setCardBackgroundColor(ContextCompat.getColor(mContext,R.color.highlighter_transparent));
//            holder.number.setTextColor(mContext.getResources().getColor(R.color.counter_text_color));
            holder.number.setTextColor(ContextCompat.getColor(mContext,R.color.accentColor));
        } else {
            holder.itemParent.setCardBackgroundColor(ContextCompat.getColor(mContext,android.R.color.transparent));
            holder.number.setTextColor(ContextCompat.getColor(mContext,android.R.color.white));
        }
    }

    private void initList(int start,int last) {
        for (int i=start;i<=last;i++){
            dataList.add(new IntervalModel(i,false));
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    int focusedItem = -1;

    class DialogViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView number;
        CardView itemParent;


        public DialogViewHolder(View itemView) {
            super(itemView);
            number = (TextView) itemView.findViewById(R.id.text_number);
            itemParent = (CardView) itemView.findViewById(R.id.item_parent);
            itemParent.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {
            Vibrator vb = (Vibrator)   mContext.getSystemService(Context.VIBRATOR_SERVICE);
            vb.vibrate(30);
            if (v.getId() == R.id.item_parent) {
                if(focusedItem<=-1) {
                    focusedItem=getLayoutPosition();
                    dataList.get(getLayoutPosition()).setHasFocus(true);
                    notifyItemChanged(getLayoutPosition());
                }else{
                    dataList.get(focusedItem).setHasFocus(false);
                    notifyItemChanged(focusedItem);
                    focusedItem=getLayoutPosition();
                    dataList.get(getLayoutPosition()).setHasFocus(true);
                    notifyItemChanged(getLayoutPosition());
                }
                itemClickCallBack.onItemClicked(dataList.get(getLayoutPosition()).getValue());
            }
        }
    }

    public interface ItemClickCallBack {
        public void onItemClicked(int value);
    }

}
