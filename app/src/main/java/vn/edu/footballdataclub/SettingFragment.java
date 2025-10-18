package vn.edu.footballdataclub;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class SettingFragment extends Fragment {

    private String currentLang = "en";
    private Button btnChangeLang;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting, container, false);

        btnChangeLang = view.findViewById(R.id.btnChangeLang);

        // get current lang from SharedPreferences
        SharedPreferences prefs = requireActivity().getSharedPreferences("settings", Context.MODE_PRIVATE);
        currentLang = prefs.getString("lang", "en");

        updateButtonText();

        btnChangeLang.setOnClickListener(v -> {
            if (currentLang.equals("en")) {
                setLocale("fr");
                currentLang = "fr";
            } else {
                setLocale("en");
                currentLang = "en";
            }

            // save new lang
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("lang", currentLang);
            editor.apply();

            requireActivity().recreate(); // reload -> apply change
        });

        return view;
    }

    /** func change lang **/
    private void setLocale(String langCode) {
        Locale locale = new Locale(langCode);
        Locale.setDefault(locale);

        Configuration config = new Configuration();
        config.setLocale(locale);

        requireContext().getResources().updateConfiguration(
                config,
                requireContext().getResources().getDisplayMetrics()
        );
    }

    private void updateButtonText() {
        if (currentLang.equals("en")) {
//            btnChangeLang.setText("EN");
            btnChangeLang.setBackgroundResource(R.drawable.lang_en);
        } else {
//            btnChangeLang.setText("FR");
            btnChangeLang.setBackgroundResource(R.drawable.lang_fr);
        }
    }
}
