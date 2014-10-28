package yt.javi.modernartandroidapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {
    private final String url = "http://www.moma.org";
    	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.main, menu);
	return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
	// Handle action bar item clicks here. The action bar will
	// automatically handle clicks on the Home/Up button, so long
	// as you specify a parent activity in AndroidManifest.xml.
	int id = item.getItemId();
	if (id == R.id.action_about) {
	    showAboutDialog();
	}
	return super.onOptionsItemSelected(item);
    }

    private void showAboutDialog() {
	AlertDialog.Builder builder = new AlertDialog.Builder(this);

	builder.setTitle(R.string.dialog_tilte)
		.setMessage(R.string.dialog_message)
		.setPositiveButton(R.string.button_visit_moma,
			new DialogInterface.OnClickListener() {
			    public void onClick(DialogInterface dialog,
				    int which) {
				Intent visitWebsite = new Intent(Intent.ACTION_VIEW);
				visitWebsite.setData(Uri.parse(url));
				startActivity(visitWebsite);
			    }
			})
		.setNegativeButton(R.string.button_not_now,
			new DialogInterface.OnClickListener() {
			    public void onClick(DialogInterface dialog,
				    int which) {
				dialog.cancel();
			    }
			}).show();

    }
}
