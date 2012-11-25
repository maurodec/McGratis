/* Copyright (c) 2012 Mauro de Carvalho <mauro.dec@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mdc.mcds;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;

public class SmsManager {
    public static final Uri SMS_PROVIDER = Uri.parse("content://sms");

    public static final String BODY = "body";
    public static final String DATE = "date";
    public static final String TYPE = "type";
    public static final String READ = "read";
    public static final String ADDRESS = "address";

    public static final int INBOX = 0x01;
    public static final int SENT = 0x02;

    public static void WriteMessage(Context c, String body, String address,
            long date, int type, boolean read) {
        ContentValues values = new ContentValues();

        values.put(SmsManager.BODY, body);
        values.put(SmsManager.DATE, date);
        values.put(SmsManager.TYPE, type);
        values.put(SmsManager.ADDRESS, address);
        values.put(SmsManager.READ, read ? "1" : "0");

        c.getContentResolver().insert(SMS_PROVIDER, values);
    }
}
