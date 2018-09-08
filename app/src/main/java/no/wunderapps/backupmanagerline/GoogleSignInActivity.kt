package no.wunderapps.backupmanagerline

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn


class GoogleSignInActivity : AppCompatActivity() {
	private final val SIGN_IN_REQUEST = 1

	fun signInGoogle () {
		generateNewSignInRequest()
	}
	fun generateNewSignInRequest () {

	}

	override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
		super.onActivityResult(requestCode, resultCode, data)

		if (requestCode == SIGN_IN_REQUEST) {
			val task = GoogleSignIn.getSignedInAccountFromIntent(data)

		}

	}
}