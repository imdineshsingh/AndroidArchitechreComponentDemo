package com.dinesh.sheduleit.readNotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.dinesh.sheduleit.R;
import com.dinesh.sheduleit.databinding.ActivityShowNotificationBinding;

public class NotificationReaderActivity extends AppCompatActivity {

    private ActivityShowNotificationBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_show_notification);

        LocalBroadcastManager.getInstance(this).registerReceiver(onNotice, new IntentFilter("Msg"));

    }
    private BroadcastReceiver onNotice= new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "Notification Received", Toast.LENGTH_SHORT).show();
            String pack = intent.getStringExtra("package");
            String title = intent.getStringExtra("title");
            String text = intent.getStringExtra("text");



            TableRow tr = new TableRow(getApplicationContext());
            tr.setLayoutParams(new TableRow.LayoutParams( TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
            TextView textview = new TextView(getApplicationContext());
            textview.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT,1.0f));
            textview.setTextSize(20);
            textview.setTextColor(Color.parseColor("#0B0719"));
            textview.setText(Html.fromHtml(pack +"<br><b>" + title + " : </b>" + text));
            tr.addView(textview);
            binding.tab.addView(tr);




        }
    };

}
