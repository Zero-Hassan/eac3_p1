package hassanzerouali.ioc.cat.eac3_p1_zerouali_hassan;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import hassanzerouali.ioc.cat.eac3_p1_zerouali_hassan.data.DataUtils;

public class MainActivity extends AppCompatActivity {


    private boolean mWide=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(DataUtils.RECEPT_ITEMS));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        if(findViewById(R.id.recept_detail_container)!=null)  mWide=true;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }






    class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter
            <SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final List<DataUtils.Recept> mValues;

        SimpleItemRecyclerViewAdapter(List<DataUtils.Recept> items) {
            mValues = items;
        }


        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recept_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mItem = mValues.get(position);
            holder.mIdView.setText(String.valueOf(position + 1));
            holder.mContentView.setText(mValues.get(position).recept_title);
            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // en caso que es una pantalla ancha
                    if (mWide) {

                        // obtenir la position del receta seleccionada
                        int selectedRecept = holder.getAdapterPosition();

                        //instanciar el fragmento
                        DetailFragment fragment =
                                DetailFragment.newInstance(selectedRecept);
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.recept_detail_container, fragment)
                                .addToBackStack(null)
                                .commit();
                    }

                    // en caso de pantallas pequñas
                    else {
                        // enviar la position del elemento seleccionado a la actividad detailes
                        Context context = v.getContext();
                        Intent intent = new Intent(context,
                                DetailActivity.class);
                        intent.putExtra(DataUtils.RECEPT_ID_KEY,
                                holder.getAdapterPosition());
                        context.startActivity(intent);
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            final View mView;
            final TextView mIdView;
            final TextView mContentView;
            DataUtils.Recept mItem;

            ViewHolder(View view) {
                super(view);
                mView = view;
                mIdView = (TextView) view.findViewById(R.id.id);
                mContentView = (TextView) view.findViewById(R.id.content);
            }
        }
    }


}
