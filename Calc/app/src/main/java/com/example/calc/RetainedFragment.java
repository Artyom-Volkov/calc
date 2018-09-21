package com.example.calc;

import android.app.Fragment;
import android.os.Bundle;

import com.example.calc.Calc.Calc2;
import com.example.calc.Calc.Calc10;
import com.example.calc.Calc.Calc16;
import com.example.calc.Calc.Calc8;

/**
 * Created by Артём on 28.08.2018.
 */

public class RetainedFragment  extends Fragment
{
    private String m_text_DialogDisplay, m_text_HistoryDisplay;
    private CalcKeyboardView.NumberSystem m_numberSystem;
    private Calc2 m_calc2;
    private Calc8 m_calc8;
    private Calc10 m_calc10;
    private Calc16 m_calc16;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // retain this fragment
        setRetainInstance(true);
    }

    public void setData(String text_DialogDisplay, String text_HistoryDisplay,
                        CalcKeyboardView.NumberSystem numberSystem, Calc2 calc2,
                        Calc8 calc8, Calc10 calc10, Calc16 calc16 )
    {
        //this.data = data;
        m_text_DialogDisplay = text_DialogDisplay;
        m_text_HistoryDisplay = text_HistoryDisplay;
        m_numberSystem = numberSystem;
        m_calc2 = calc2;
        m_calc8 = calc8;
        m_calc10 = calc10;
        m_calc16 = calc16;
    }

    public CalcKeyboardView.NumberSystem GetNumberSystem()
    {
        return m_numberSystem;
    }

    public String GetTextDialogDisplay()
    {
        return m_text_DialogDisplay;
    }

    public String GetHistoryDisplay()
    {
        return m_text_HistoryDisplay;
    }

    public Calc2 GetCalc2()
    {
        return m_calc2;
    }

    public Calc8 GetCalc8()
    {
        return m_calc8;
    }

    public Calc10 GetCalc10()
    {
        return m_calc10;
    }

    public Calc16 GetCalc16()
    {
        return m_calc16;
    }
}
