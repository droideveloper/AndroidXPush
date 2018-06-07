/*
 * Firebase Cloud Messaging Kotlin Copyright (C) 2018 Fatih.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.fs.firebase.component

import android.app.IntentService
import android.content.Intent
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.messaging.FirebaseMessaging
import org.fs.firebase.R
import org.fs.firebase.log

class RegistrationService: IntentService(RegistrationService::class.java.simpleName) {

  companion object {
    @JvmStatic val PREF_PUSH_TOKEN_KEY = "pref.push.token.key"
  }



  override fun onHandleIntent(intent: Intent?) {
    try {
      val instance = FirebaseInstanceId.getInstance()
      val senderId = getString(R.string.gcm_defaultSenderId)
      val token = instance.getToken(senderId, FirebaseMessaging.INSTANCE_ID_SCOPE)

      // TODO persist this

    } catch (error: Throwable) {
      log(error)
    }
  }
}