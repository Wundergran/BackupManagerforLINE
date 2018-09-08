package no.wunderapps.backupmanagerline.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import no.wunderapps.backupmanagerline.data.ChatBackup

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel
	private var chatsBackedUp : MutableLiveData<MutableList<ChatBackup>>? = null

	fun getChats() : MutableLiveData<MutableList<ChatBackup>>? {
		return null
	}
}
