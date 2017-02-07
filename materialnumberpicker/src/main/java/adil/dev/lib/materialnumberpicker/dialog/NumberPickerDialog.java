package adil.dev.lib.materialnumberpicker.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import adil.dev.lib.materialnumberpicker.R;
import adil.dev.lib.materialnumberpicker.adapter.NumberPickerAdapter;

/**
 * Created by Adil on 26/11/2015.
 */
public class NumberPickerDialog extends Dialog implements NumberPickerAdapter.ItemClickCallBack{

    Context mContext;
    int selectNumber=0;
    int start=0;
    int last=0;
    NumberPickerCallBack callBack;
    private static NumberPickerDialog instance=null;
    public NumberPickerDialog(Context context, int start, int last,NumberPickerCallBack callBack) {
        super(context);
        this.callBack=callBack;
        this.mContext=context;
        this.selectNumber=start;
        this.start=start;
        this.last=last;
    }

    public static NumberPickerDialog getInstance(){
        return instance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.interval_picker_dialog);
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        instance=this;
        initViews();
        initValues();
        initValuesInViews();
        setOnClickListener();
    }

    RecyclerView recyclerView;
    TextView okView,cancelView,selectedTextView;
    private void initViews(){
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        okView=(TextView)findViewById(R.id.ok);
        cancelView=(TextView)findViewById(R.id.cancel);
        selectedTextView = (TextView) findViewById(R.id.dialog_selected_value);
    }
    private void initValues(){

    }
    private void initValuesInViews(){
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        if(last-start<=-1)
            recyclerView.setItemViewCacheSize(100000);
        else
            recyclerView.setItemViewCacheSize(last - start);
        recyclerView.setAdapter(new NumberPickerAdapter(mContext,this,start,last));
    }
    private void setOnClickListener(){
        cancelView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        okView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.onSelectingValue(selectNumber);
                dismiss();
            }
        });
    }

    @Override
    public void onItemClicked(int selectedNumber) {
        this.selectNumber=selectedNumber;
        selectedTextView.setText(String.valueOf(selectedNumber));
    }

    public interface NumberPickerCallBack {
        public void onSelectingValue(int value);
    }
}
