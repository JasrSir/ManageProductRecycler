package com.limox.jesus.recicledview_application.settings;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.limox.jesus.recicledview_application.R;

/**
 * Created by usuario on 2/11/16.
 */

public class AccountSettings_Activity extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.account_settings);
    }
}
