package com.example.pictureslist;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class Lista extends AppCompatActivity {
    private ListView listView;
   public static int[] images = {R.drawable.donatello, R.drawable.michaelangelo, R.drawable.shredder};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista);

        //-------Postavljanje slika------------//
        listView = (ListView) findViewById(R.id.listView);
        ImageAdapter adapter = new ImageAdapter();
        listView.setAdapter(adapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openDialog();
            }
        });



    }
    public void openDialog(){
        AlertDialog alert = new AlertDialog.Builder(Lista.this).create();
        alert.setTitle("No Internet access");
        alert.setMessage("You can't reach the discussion from the Offline mode");
        alert.setButton("OK", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
               Intent intent = new Intent(Lista.this, Unos.class);
               startActivity(intent);

            }
        });
        alert.show();
    }
}

class ImageAdapter extends BaseAdapter{

    @Override
    public int getCount() {
        return Lista.images.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.item, parent, false);
        }

        ImageView imageView= (ImageView) convertView.findViewById(R.id.imageView);

        imageView.setImageResource(Lista.images[position]);
        return convertView;

    }
}
