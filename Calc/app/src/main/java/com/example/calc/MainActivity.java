package com.example.calc;

import android.app.FragmentManager;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ViewStubCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView textView_DialogDisplay, textView_HistoryDisplay;
    CalcKeyboardView calcKeyboardView;
    private RetainedFragment dataFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView_DialogDisplay = (TextView) findViewById(R.id.textView_DialogDisplay);
        textView_HistoryDisplay = (TextView) findViewById(R.id.textView_HistoryDisplay);
        calcKeyboardView = (CalcKeyboardView) findViewById(R.id.calckeyboardview);

        FragmentManager fm = getFragmentManager();
        dataFragment = (RetainedFragment) fm.findFragmentByTag("data");

        // create the fragment and data the first time
        if (dataFragment == null)
        {
            // add the fragment
            dataFragment = new RetainedFragment();
            fm.beginTransaction().add(dataFragment, "data").commit();
            // load the data from the web
            dataFragment.setData(textView_DialogDisplay.getText().toString(), textView_HistoryDisplay.getText().toString(),
                    calcKeyboardView.GetNumberSystem(), calcKeyboardView.calc2, calcKeyboardView.calc8,
                    calcKeyboardView.calc10, calcKeyboardView.calc16);
        }

        textView_DialogDisplay.setText(dataFragment.GetTextDialogDisplay());
        textView_HistoryDisplay.setText(dataFragment.GetHistoryDisplay());

        calcKeyboardView.calc2 = dataFragment.GetCalc2();
        calcKeyboardView.calc8 = dataFragment.GetCalc8();
        calcKeyboardView.calc10 = dataFragment.GetCalc10();
        calcKeyboardView.calc16 = dataFragment.GetCalc16();
        calcKeyboardView.InitializeForNumberSystemWithoutNewCalc(dataFragment.GetNumberSystem(), getApplicationContext());

        //calcKeyboardView.calc10 = new Calc10(getApplicationContext());
        calcKeyboardView.calc10.m_calcDialogDisplay = textView_DialogDisplay;
        calcKeyboardView.calc10.m_calcHistoryDisplay = textView_HistoryDisplay;

        //calcKeyboardView.calc2 = new Calc8(getApplicationContext());
        calcKeyboardView.calc2.m_calcDialogDisplay = textView_DialogDisplay;
        calcKeyboardView.calc2.m_calcHistoryDisplay = textView_HistoryDisplay;

        calcKeyboardView.calc8.m_calcDialogDisplay = textView_DialogDisplay;
        calcKeyboardView.calc8.m_calcHistoryDisplay = textView_HistoryDisplay;

        calcKeyboardView.calc16.m_calcDialogDisplay = textView_DialogDisplay;
        calcKeyboardView.calc16.m_calcHistoryDisplay = textView_HistoryDisplay;

    }

    public void onDestroy() {
        super.onDestroy();
        // store the data in the fragment

        // load the data from the web
        dataFragment.setData(textView_DialogDisplay.getText().toString(),
                textView_HistoryDisplay.getText().toString(),
                calcKeyboardView.GetNumberSystem(), calcKeyboardView.calc2, calcKeyboardView.calc8,
                calcKeyboardView.calc10, calcKeyboardView.calc16);
    }



}
