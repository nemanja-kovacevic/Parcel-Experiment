package net.nemanjakovacevic.parcelexperiment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.parceler.Parcels;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

/**
 * Created by nemanja on 3/19/15.
 */
public class OtherActivity extends Activity {

    private static final NumberFormat NUMBER_FORMAT = new DecimalFormat("###,###.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        Package aPackage;

        if(MainActivity.USE_SERIALIZATION){
            aPackage = (Package) getIntent().getSerializableExtra("package");
        } else {
            aPackage = Parcels.unwrap(getIntent().getParcelableExtra("package"));
        }

        long endTimestamp = System.nanoTime();

        String message = "Elapsed time in nanoseconds: %s";
        ((TextView)findViewById(R.id.elapsed_time_message)).setText(String.format(message, NUMBER_FORMAT.format(endTimestamp-MainActivity.START_TIMESTAMP)));
        recyclerView.setAdapter(new EmptyObjectAdapter(aPackage.getList()));
    }

}
