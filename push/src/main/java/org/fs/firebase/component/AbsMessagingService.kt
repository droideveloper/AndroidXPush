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

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import java.util.*
import java.util.concurrent.TimeUnit

abstract class AbsMessagingService: FirebaseMessagingService() {

  companion object {
    @JvmStatic private val calendar = Calendar.getInstance(TimeZone.getDefault())
  }

  override fun onMessageReceived(message: RemoteMessage?) {
    super.onMessageReceived(message)
    message?.let {
      notifyPayload(it.data)
    }
  }

  abstract fun activity(): Class<*>
  abstract fun notifyPayload(payload: Map<String, String>?)

  protected val notificationId: Long get() = (calendar.timeInMillis / TimeUnit.SECONDS.toMillis(1L) % Integer.MAX_VALUE)
}