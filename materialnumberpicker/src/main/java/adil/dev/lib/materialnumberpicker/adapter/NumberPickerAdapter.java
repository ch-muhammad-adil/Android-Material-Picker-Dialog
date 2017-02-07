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
    ValueAvailableListener valueAvailableListener;
    NumberPickerAdapter instance;

    public NumberPickerAdapter(Context context, ItemClickCallBack itemClickCallBack,ValueAvailableListener valueAvailableListener, int start, int last) {
        this.mContext = context;
        inflater = LayoutInflater.from(context);
        this.itemClickCallBack = itemClickCallBack;
        this.valueAvailableListener=valueAvailableListener;
        initList(start,last);
        instance = this;
    }

    @Override
    public DialogViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DialogViewHolder(inflater.inflate(R.layout.picker_item, parent, false));
    }

    public void findForItemToShow(int value){
        int position=-1;
        for(int i=0;i<dataList.size();i++){
            if(dataList.get(i).getValue()==value){
                position=i;
                break;
            }
        }
        if(position!=-1){
            if(focusedItem<=-1) {
                focusedItem=position;
                dataList.get(position).setHasFocus(true);
                notifyItemChanged(position);
            }else{
                dataList.get(focusedItem).setHasFocus(false);
                notifyItemChanged(focusedItem);
                focusedItem=position;
                dataList.get(position).setHasFocus(true);
                notifyItemChanged(position);
            }
            valueAvailableListener.onValueAvailable(position);
        }

    }

    @Override
    public void onBindViewHolder(DialogViewHolder holder, int position) {
        holder.number.setText(dataList.get(position).getValue()+"");
        if (dataList.get(position).isHasFocus()) {
            holder.number.setBackgroundResource(R.drawable.ic_round_shape_selected);
            holder.number.setTextColor(ContextCompat.getColor(mContext,R.color.MPD_pickerItemTextColorSelected));
        } else {
            holder.number.setBackgroundResource(R.drawable.ic_round_shape_unselected);
            holder.number.setTextColor(ContextCompat.getColor(mContext,R.color.MPD_pickerItemTextColorUnSelected));
        }
    }

    private void initList(int start,int last) {
        for (int i=start;i<=last;i++){
            dataList.add(new IntervalModel(i,false));
        }
        dataList.get(0).setHasFocus(true);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    int focusedItem = 0;

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
                itemClickCallBack.onItemClicked(dataList.get(getLayoutPosition()).getValue(),getLayoutPosition());
            }
        }
    }

    public interface ItemClickCallBack {
        public void onItemClicked(int value,int position);
    }
    public interface ValueAvailableListener{
        public void onValueAvailable(int position);
    }

}
