package com.interfacesgraficas.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.preference.PreferenceFragmentCompat;

import com.interfacesgraficas.R;

public class SettingsFragment extends PreferenceFragmentCompat
{
    private Context context;

    @Override
    public void onCreatePreferences(Bundle bundle, String s) {
        // Load the Preferences from the XML file
        addPreferencesFromResource(R.xml.app_preferences);

    }
}
