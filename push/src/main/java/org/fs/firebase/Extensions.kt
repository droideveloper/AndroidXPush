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
package org.fs.firebase

import android.os.Looper
import android.util.Log
import java.io.PrintWriter
import java.io.StringWriter


inline fun <reified T> T.isLogEnabled(): Boolean = BuildConfig.D
inline fun <reified T> T.getClassTag(): String = T::class.java.simpleName

inline fun <reified T> T.log(msg: String) = log(Log.DEBUG, msg)

inline fun <reified T> T.log(error: Throwable) {
  val str = StringWriter()
  val pwr = PrintWriter(str)
  error.printStackTrace(pwr)
  log(Log.ERROR, str.toString())
}

inline fun <reified T> T.log(level: Int, msg: String) {
  if (isLogEnabled()) {
    Log.println(level, getClassTag(), msg)
  }
}

val isUiThread: Boolean = Looper.myLooper() == Looper.getMainLooper()




