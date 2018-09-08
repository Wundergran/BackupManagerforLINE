package no.wunderapps.backupmanagerline

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.main_fragment.*
import no.wunderapps.backupmanagerline.ui.main.MainFragment

class MainActivity : GoogleSignInActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.main_activity)

		// Start Google Play sign-in
		signInGoogle()
	}

	override fun onGoogleSignIn() {
		super.onGoogleSignIn()
		supportFragmentManager.beginTransaction()
				.replace(R.id.container, MainFragment.newInstance())
				.commitNow()
	}
}
