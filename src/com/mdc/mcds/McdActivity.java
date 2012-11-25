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

import java.util.Calendar;
import java.util.Date;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

public class McdActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_mcd);
    }

    public void mcd1(View v) {
        this.sendSms(R.string.mcd1, R.string.r_mcd1);
    }

    public void mcd2(View v) {
        this.sendSms(R.string.mcd2, R.string.r_mcd2);
    }

    private void sendSms(int m1, int m2) {
        String body;
        final String address = "989";

        body = this.getString(m1);
        SmsManager.WriteMessage(this, body, address, new Date().getTime() - 30,
                SmsManager.SENT, true);

        body = String.format(this.getString(m2),
                (int) (10000 + (Math.random() * 40000)),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH),
                Calendar.getInstance().get(Calendar.MONTH) + 1,
                Calendar.getInstance().get(Calendar.YEAR) - 2000);
        SmsManager.WriteMessage(this, body, address, new Date().getTime(),
                SmsManager.INBOX, true);

        this.showDone();
    }

    private void showDone() {
        new AlertDialog.Builder(this)
        .setMessage(R.string.sucess)
        .setTitle(R.string.burp)
        .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                McdActivity.this.finish();
            }
        })
        .setIcon(R.drawable.symbol_check)
        .setCancelable(false)
        .create()
        .show();
    }
}
