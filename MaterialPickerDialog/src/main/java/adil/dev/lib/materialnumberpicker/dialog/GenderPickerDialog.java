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
import adil.dev.lib.materialnumberpicker.adapter.GenderAdapter;


/**
 * Created by Adil on 08/01/2016.
 */
public class GenderPickerDialog extends Dialog {
    Context mContext;
    GenderPickerDialog.OnGenderSelectListener onSelectingGender;

    public GenderPickerDialog(Context context) {
        super(context);
        this.mContext = context;
    }

    static GenderPickerDialog instance = null;

    public void setOnSelectingGender(GenderPickerDialog.OnGenderSelectListener onSelectingGender) {
        this.onSelectingGender = onSelectingGender;
    }

    public static GenderPickerDialog getInstance() {
        return instance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.gender_picker_dialog);
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        instance = this;
        initViews();
        initValues();
        initValuesInViews();
        setOnClickListener();
    }

    RecyclerView recyclerView;
    TextView okView, cancelView,selectedTextView;

    private void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        okView = (TextView) findViewById(R.id.ok);
        cancelView = (TextView) findViewById(R.id.cancel);
        selectedTextView = (TextView) findViewById(R.id.dialog_selected_value);
    }

    private void initValues() {
        selectedString= mContext.getString(R.string.MPD_male);
    }

    String selectedString="";
    private void initValuesInViews() {
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setItemViewCacheSize(2);
        selectedTextView.setText(selectedString);
        GenderAdapter adapter = new GenderAdapter(mContext);
        adapter.setOnItemClickCallBack(new GenderAdapter.ItemClickCallBack() {
            @Override
            public void onItemClicked(String gender) {
                selectedString=gender;
                selectedTextView.setText(selectedString);
            }
        });
        recyclerView.setAdapter(adapter);
    }

    private void setOnClickListener() {
        cancelView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        okView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSelectingGender.onSelectingGender(selectedString);
                dismiss();
            }
        });
    }

    public interface OnGenderSelectListener {
        public void onSelectingGender(String value);
    }

}
