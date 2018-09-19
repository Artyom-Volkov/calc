package com.example.calc;

import android.annotation.TargetApi;
import android.content.Context;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import com.example.calc.BinNumberSystem.Calc2;
import com.example.calc.DecimalNumberSystem.Calc10;
import com.example.calc.HexNumberSystem.Calc16;
import com.example.calc.OctNumberSystem.Calc8;

/**
 * Created by Артём on 22.08.2018.
 */

public class CalcKeyboardView extends KeyboardView implements KeyboardView.OnKeyboardActionListener
{
    enum NumberSystem{BIN, OCT, DEC, HEX}

    private Keyboard calcKeyboard1, calcKeyboard2;
    public Calc10 calc10;
    public Calc2 calc2;
    public Calc8 calc8;
    public Calc16 calc16;
    private NumberSystem m_numberSystem;
    private Context m_context;

    public NumberSystem GetNumberSystem()
    {
        return m_numberSystem;
    }
    public CalcKeyboardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeViews(context);
    }

    public CalcKeyboardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeViews(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CalcKeyboardView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initializeViews(context);
    }

    private void initializeViews(Context context)
    {
        m_context = context;
        m_numberSystem = NumberSystem.DEC;
        calc2 = new Calc2(context);
        calc10 = new Calc10(context);
        calc8 = new Calc8(context);
        calc16 = new Calc16(context);
        InitializeForNumberSystem(m_numberSystem, context);


    }

    public void InitializeForNumberSystemWithoutNewCalc(NumberSystem numberSystem, Context context)
    {
        switch (numberSystem)
        {
            case BIN:
            {
                m_numberSystem = NumberSystem.BIN;
                calcKeyboard1 = new Keyboard(context,R.layout.calc_keyboard_2_1);
                calcKeyboard2 = new Keyboard(context,R.layout.calc_keyboard_2_2);
            }
            break;
            case DEC:
            {
                m_numberSystem = NumberSystem.DEC;
                calcKeyboard1 = new Keyboard(context,R.layout.calc_keyboard_10_1);
                calcKeyboard2 = new Keyboard(context,R.layout.calc_keyboard_10_2);
            }
            break;
            case OCT:
            {
                m_numberSystem = NumberSystem.OCT;
                calcKeyboard1 = new Keyboard(context,R.layout.calc_keyboard_8_1);
                calcKeyboard2 = new Keyboard(context,R.layout.calc_keyboard_8_2);
            }
            break;
            case HEX:
            {
                m_numberSystem = NumberSystem.HEX;
                calcKeyboard1 = new Keyboard(context,R.layout.calc_keyboard_16_1);
                calcKeyboard2 = new Keyboard(context,R.layout.calc_keyboard_16_2);
            }
        }

        this.setKeyboard( calcKeyboard1 );

        // Do not show the preview balloons
        //mKeyboardView.setPreviewEnabled(false);

        // Install the key handler
        this.setOnKeyboardActionListener(this);
        this.setVisibility(View.VISIBLE);
        this.setEnabled(true);
    }

    private void InitializeForNumberSystem(NumberSystem numberSystem, Context context)
    {
        switch (numberSystem)
        {
            case BIN:
            {
                m_numberSystem = NumberSystem.BIN;
                calcKeyboard1 = new Keyboard(context,R.layout.calc_keyboard_2_1);
                calcKeyboard2 = new Keyboard(context,R.layout.calc_keyboard_2_2);
                calc2.Initialize();
            }
            break;
            case DEC:
            {
                m_numberSystem = NumberSystem.DEC;
                calcKeyboard1 = new Keyboard(context,R.layout.calc_keyboard_10_1);
                calcKeyboard2 = new Keyboard(context,R.layout.calc_keyboard_10_2);
                calc10.Initialize();
            }
            break;
            case OCT:
            {
                m_numberSystem = NumberSystem.OCT;
                calcKeyboard1 = new Keyboard(context,R.layout.calc_keyboard_8_1);
                calcKeyboard2 = new Keyboard(context,R.layout.calc_keyboard_8_2);
                calc8.Initialize();
            }
            break;
            case HEX:
            {
                m_numberSystem = NumberSystem.HEX;
                calcKeyboard1 = new Keyboard(context,R.layout.calc_keyboard_16_1);
                calcKeyboard2 = new Keyboard(context,R.layout.calc_keyboard_16_2);
                calc16.Initialize();
            }
        }

        this.setKeyboard( calcKeyboard1 );

        // Do not show the preview balloons
        //mKeyboardView.setPreviewEnabled(false);

        // Install the key handler
        this.setOnKeyboardActionListener(this);
        this.setVisibility(View.VISIBLE);
        this.setEnabled(true);
    }

    @Override
    public void onPress(int primaryCode) {

    }

    @Override
    public void onRelease(int primaryCode) {

    }

    @Override
    public void onKey(int primaryCode, int[] keyCodes)
    {
        switch (m_numberSystem)
        {
            case DEC: onKeyDEC(primaryCode, keyCodes); break;
            case BIN: onKeyBIN(primaryCode, keyCodes); break;
            case OCT: onKeyOCT(primaryCode, keyCodes);break;
            case HEX: onKeyHEX(primaryCode, keyCodes);break;
        }
    }

    private void onKeyDEC(int primaryCode, int[] keyCodes)
    {
        switch (primaryCode)
        {
            case 20: this.setKeyboard(calcKeyboard2);break;
            case 32: this.setKeyboard(calcKeyboard1);break;
            case 0: calc10.Input_0(); break;
            case 1: calc10.Input_1(); break;
            case 2: calc10.Input_2(); break;
            case 3: calc10.Input_3(); break;
            case 4: calc10.Input_4(); break;
            case 5: calc10.Input_5(); break;
            case 6: calc10.Input_6(); break;
            case 7: calc10.Input_7(); break;
            case 8: calc10.Input_8(); break;
            case 9: calc10.Input_9(); break;
            case 16: calc10.Input_Point(); break;
            case 17: ChangeNumberSystem();break;
            case 18: calc10.Input_SINGCHANGE();break;
            case 19: calc10.Input_AllClear(); break;
            case 22: calc10.Input_SUBTRACT(); break;
            case 21: calc10.Input_ADD(); break;
            case 23: calc10.Input_MULTIPLY(); break;
            case 24: calc10.Input_DIVISION(); break;
            case 25: calc10.Input_LOG();break;
            case 26: calc10.Input_EXP();break;
            case 27: calc10.Input_POW();break;
            case 28: calc10.Input_FACTORIAL();break;
            case 29: calc10.Input_SIN();break;
            case 30: calc10.Input_COS();break;
            case 31: calc10.Input_TAN();break;
            case 33: calc10.Input_EQUALS(); break;
            case 34: calc10.Input_CalcHistory_BackwardHistory();break;
            case 35: calc10.Input_CalcHistory_ForwardHistory();break;
        }
    }

    private void onKeyBIN(int primaryCode, int[] keyCodes)
    {
        switch (primaryCode)
        {
            case 20: this.setKeyboard(calcKeyboard2);break;
            case 32: this.setKeyboard(calcKeyboard1);break;
            case 0: calc2.Input_0(); break;
            case 1: calc2.Input_1(); break;
            case 17: ChangeNumberSystem();break;
            case 18: calc2.Input_SINGCHANGE();break;
            case 19: calc2.Input_AllClear(); break;
            case 22: calc2.Input_SUBTRACT(); break;
            case 21: calc2.Input_ADD(); break;
            case 23: calc2.Input_MULTIPLY(); break;
            case 24: calc2.Input_DIVISION(); break;
            case 25: calc2.Input_LOG();break;
            case 26: calc2.Input_EXP();break;
            case 27: calc2.Input_POW();break;
            case 28: calc2.Input_FACTORIAL();break;
            case 29: calc2.Input_SIN();break;
            case 30: calc2.Input_COS();break;
            case 31: calc2.Input_TAN();break;
            case 33: calc2.Input_EQUALS(); break;
            case 34: calc2.Input_CalcHistory_BackwardHistory();break;
            case 35: calc2.Input_CalcHistory_ForwardHistory();break;
        }
    }

    private void onKeyOCT(int primaryCode, int[] keyCodes)
    {
        switch (primaryCode)
        {
            case 20: this.setKeyboard(calcKeyboard2);break;
            case 32: this.setKeyboard(calcKeyboard1);break;
            case 0: calc8.Input_0(); break;
            case 1: calc8.Input_1(); break;
            case 2: calc8.Input_2(); break;
            case 3: calc8.Input_3(); break;
            case 4: calc8.Input_4(); break;
            case 5: calc8.Input_5(); break;
            case 6: calc8.Input_6(); break;
            case 7: calc8.Input_7(); break;
            case 17: ChangeNumberSystem();break;
            case 18: calc8.Input_SINGCHANGE();break;
            case 19: calc8.Input_AllClear(); break;
            case 22: calc8.Input_SUBTRACT(); break;
            case 21: calc8.Input_ADD(); break;
            case 23: calc8.Input_MULTIPLY(); break;
            case 24: calc8.Input_DIVISION(); break;
            case 25: calc8.Input_LOG();break;
            case 26: calc8.Input_EXP();break;
            case 27: calc8.Input_POW();break;
            case 28: calc8.Input_FACTORIAL();break;
            case 29: calc8.Input_SIN();break;
            case 30: calc8.Input_COS();break;
            case 31: calc8.Input_TAN();break;
            case 33: calc8.Input_EQUALS(); break;
            case 34: calc8.Input_CalcHistory_BackwardHistory();break;
            case 35: calc8.Input_CalcHistory_ForwardHistory();break;
        }
    }

    private void onKeyHEX(int primaryCode, int[] keyCodes)
    {
        switch (primaryCode)
        {
            case 20: this.setKeyboard(calcKeyboard2);break;
            case 32: this.setKeyboard(calcKeyboard1);break;
            case 0: calc16.Input_0(); break;
            case 1: calc16.Input_1(); break;
            case 2: calc16.Input_2(); break;
            case 3: calc16.Input_3(); break;
            case 4: calc16.Input_4(); break;
            case 5: calc16.Input_5(); break;
            case 6: calc16.Input_6(); break;
            case 7: calc16.Input_7(); break;
            case 8: calc16.Input_8(); break;
            case 9: calc16.Input_9(); break;
            case 10: calc16.Input_A(); break;
            case 11: calc16.Input_B(); break;
            case 12: calc16.Input_C(); break;
            case 13: calc16.Input_D(); break;
            case 14: calc16.Input_E(); break;
            case 15: calc16.Input_F(); break;
            case 17: ChangeNumberSystem();break;
            case 18: calc16.Input_SINGCHANGE();break;
            case 19: calc16.Input_AllClear(); break;
            case 22: calc16.Input_SUBTRACT(); break;
            case 21: calc16.Input_ADD(); break;
            case 23: calc16.Input_MULTIPLY(); break;
            case 24: calc16.Input_DIVISION(); break;
            case 25: calc16.Input_LOG();break;
            case 26: calc16.Input_EXP();break;
            case 27: calc16.Input_POW();break;
            case 28: calc16.Input_FACTORIAL();break;
            case 29: calc16.Input_SIN();break;
            case 30: calc16.Input_COS();break;
            case 31: calc16.Input_TAN();break;
            case 33: calc16.Input_EQUALS(); break;
            case 34: calc16.Input_CalcHistory_BackwardHistory();break;
            case 35: calc16.Input_CalcHistory_ForwardHistory();break;
        }
    }

    private void ChangeNumberSystem()
    {
        switch (m_numberSystem)
        {
            case DEC: InitializeForNumberSystem(NumberSystem.BIN, m_context); break;
            case BIN: InitializeForNumberSystem(NumberSystem.OCT, m_context); break;
            case OCT: InitializeForNumberSystem(NumberSystem.HEX, m_context); break;
            case HEX: InitializeForNumberSystem(NumberSystem.DEC, m_context);break;
        }
    }



    @Override
    public void onText(CharSequence text) {

    }

    @Override
    public void swipeLeft() {

    }

    @Override
    public void swipeRight() {

    }

    @Override
    public void swipeDown() {

    }

    @Override
    public void swipeUp() {

    }
}
