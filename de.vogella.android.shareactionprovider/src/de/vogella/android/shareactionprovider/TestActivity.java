package de.vogella.android.shareactionprovider;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ShareActionProvider;

public class TestActivity extends Activity {
	private ShareActionProvider provider;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.mymenu, menu);
		provider = (ShareActionProvider) menu.findItem(R.id.menu_share)
				.getActionProvider();
		doShare();
		return true;
	}

	public void doShare() {
		Intent intent = new Intent(Intent.ACTION_SEND);
		intent.setType("text/plain");
		intent.putExtra(Intent.EXTRA_TEXT, "Message");
		provider.setShareIntent(intent);
	}
}
