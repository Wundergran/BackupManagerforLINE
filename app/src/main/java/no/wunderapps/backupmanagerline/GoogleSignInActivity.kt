package no.wunderapps.backupmanagerline

import android.content.Intent
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task


abstract class GoogleSignInActivity : AppCompatActivity() {
	companion object {
		private const val LOG_TAG = "GoogleSignInActivity.kt"
		private const val SIGN_IN_REQUEST = 1
	}

	private var signInClient : GoogleSignInClient? = null
	private var googleSignInAccount : GoogleSignInAccount? = null

	fun signInGoogle () {
		googleSignInAccount = GoogleSignIn.getLastSignedInAccount(applicationContext)
		if (googleSignInAccount == null) {
			generateNewSignInRequest()
		} else {
			onGoogleSignIn()
		}
	}
	private fun generateNewSignInRequest () {
		val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
				.build()
		signInClient = GoogleSignIn.getClient(applicationContext, gso)

		val googleIntent = signInClient?.signInIntent
		startActivityForResult(googleIntent, SIGN_IN_REQUEST)
	}

	private fun onGoogleSignIn () {
		Log.d(LOG_TAG, "Successfully signed in: ${googleSignInAccount?.displayName}")
	}

	private fun handleSignInResult (result: Task<GoogleSignInAccount>) {
		try {
			googleSignInAccount = result.getResult(ApiException::class.java)
			onGoogleSignIn()
		} catch (err: ApiException) {
			Log.e(LOG_TAG, "Err signing in: ${err.statusCode}")
		}
	}

	override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
		super.onActivityResult(requestCode, resultCode, data)

		if (requestCode == SIGN_IN_REQUEST) {
			val task = GoogleSignIn.getSignedInAccountFromIntent(data)
			handleSignInResult(task)
		}

	}
}