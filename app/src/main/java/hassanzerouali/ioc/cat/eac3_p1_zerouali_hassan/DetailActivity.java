package hassanzerouali.ioc.cat.eac3_p1_zerouali_hassan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import hassanzerouali.ioc.cat.eac3_p1_zerouali_hassan.data.DataUtils;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if (savedInstanceState == null) {
            // Get the selected song position from the intent extra.
            int selectedRecept =
                    getIntent().getIntExtra(DataUtils.RECEPT_ID_KEY, 0);
            // Create instance of the detail fragment and add it to the activity
            // using a fragment transaction.
            DetailFragment fragment =
                    DetailFragment.newInstance(selectedRecept);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.recept_detail_container, fragment)
                    .commit();
        }
    }
}
