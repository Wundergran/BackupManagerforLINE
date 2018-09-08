package no.wunderapps.backupmanagerline

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import no.wunderapps.backupmanagerline.ui.main.MainFragment

class MainActivity : GoogleSignInActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.main_activity)
		if (savedInstanceState == null) {
			supportFragmentManager.beginTransaction()
					.replace(R.id.container, MainFragment.newInstance())
					.commitNow()
		}

		// Handle Google Play sign-in
		signInGoogle()
	}

}
