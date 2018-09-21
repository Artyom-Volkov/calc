package com.example.calc.Calc;

import android.content.Context;
import android.widget.TextView;

import com.example.calc.CalcHistory.CalcHistory2_8_16;
import com.example.calc.MathExpression.MathExpression_2_8_16;
import com.example.calc.MathExpression.NumberSystem;

/**
 * Created by Артём on 22.08.2018.
 */

public class Calc16
{
    public TextView m_calcDialogDisplay;
    public TextView m_calcHistoryDisplay;
    private MathExpression_2_8_16 m_currentmathExpression;
    private boolean m_NeedClearDialogDisplay;

    private Context m_context;
    private CalcHistory2_8_16 m_calcHistory16;

    public Calc16(Context context)
    {
        m_context = context;
        Initialize();
    }

    public void Initialize()
    {
        m_calcHistory16 = new CalcHistory2_8_16(NumberSystem.HEX);
        m_currentmathExpression = new MathExpression_2_8_16(m_context, NumberSystem.HEX);
        m_NeedClearDialogDisplay = true;
        if (m_calcDialogDisplay!=null)
            m_calcDialogDisplay.setText("");
        if (m_calcHistoryDisplay!=null)
            m_calcHistoryDisplay.setText("");
    }


    public void Input_0()
    {
        if (m_NeedClearDialogDisplay)
            m_calcDialogDisplay.setText("");
        m_NeedClearDialogDisplay = false;
        m_calcDialogDisplay.append("0");
    }
    public void Input_1()
    {
        if (m_NeedClearDialogDisplay)
            m_calcDialogDisplay.setText("");
        m_NeedClearDialogDisplay = false;
        m_calcDialogDisplay.append("1");
    }

    public void Input_2()
    {
        if (m_NeedClearDialogDisplay)
            m_calcDialogDisplay.setText("");
        m_NeedClearDialogDisplay = false;
        m_calcDialogDisplay.append("2");
    }
    public void Input_3()
    {
        if (m_NeedClearDialogDisplay)
            m_calcDialogDisplay.setText("");
        m_NeedClearDialogDisplay = false;
        m_calcDialogDisplay.append("3");
    }
    public void Input_4()
    {
        if (m_NeedClearDialogDisplay)
            m_calcDialogDisplay.setText("");
        m_NeedClearDialogDisplay = false;
        m_calcDialogDisplay.append("4");
    }
    public void Input_5()
    {
        if (m_NeedClearDialogDisplay)
            m_calcDialogDisplay.setText("");
        m_NeedClearDialogDisplay = false;
        m_calcDialogDisplay.append("5");
    }
    public void Input_6()
    {
        if (m_NeedClearDialogDisplay)
            m_calcDialogDisplay.setText("");
        m_NeedClearDialogDisplay = false;
        m_calcDialogDisplay.append("6");
    }
    public void Input_7()
    {
        if (m_NeedClearDialogDisplay)
            m_calcDialogDisplay.setText("");
        m_NeedClearDialogDisplay = false;
        m_calcDialogDisplay.append("7");
    }
    public void Input_8()
    {
        if (m_NeedClearDialogDisplay)
            m_calcDialogDisplay.setText("");
        m_NeedClearDialogDisplay = false;
        m_calcDialogDisplay.append("8");
    }
    public void Input_9()
    {
        if (m_NeedClearDialogDisplay)
            m_calcDialogDisplay.setText("");
        m_NeedClearDialogDisplay = false;
        m_calcDialogDisplay.append("9");
    }
    public void Input_A()
    {
        if (m_NeedClearDialogDisplay)
            m_calcDialogDisplay.setText("");
        m_NeedClearDialogDisplay = false;
        m_calcDialogDisplay.append("a");
    }
    public void Input_B()
    {
        if (m_NeedClearDialogDisplay)
            m_calcDialogDisplay.setText("");
        m_NeedClearDialogDisplay = false;
        m_calcDialogDisplay.append("b");
    }
    public void Input_C()
    {
        if (m_NeedClearDialogDisplay)
            m_calcDialogDisplay.setText("");
        m_NeedClearDialogDisplay = false;
        m_calcDialogDisplay.append("c");
    }
    public void Input_D()
    {
        if (m_NeedClearDialogDisplay)
            m_calcDialogDisplay.setText("");
        m_NeedClearDialogDisplay = false;
        m_calcDialogDisplay.append("d");
    }
    public void Input_E()
    {
        if (m_NeedClearDialogDisplay)
            m_calcDialogDisplay.setText("");
        m_NeedClearDialogDisplay = false;
        m_calcDialogDisplay.append("e");
    }
    public void Input_F()
    {
        if (m_NeedClearDialogDisplay)
            m_calcDialogDisplay.setText("");
        m_NeedClearDialogDisplay = false;
        m_calcDialogDisplay.append("f");
    }

    public void Input_AllClear()
    {
        m_NeedClearDialogDisplay = true;
        //m_operandStr.delete(0, m_operandStr.length()-1);
        m_calcDialogDisplay.setText("");
    }
    public void Input_ADD()
    {
        if (m_NeedClearDialogDisplay == false && (m_currentmathExpression.getMathOperandSet() == MathExpression_2_8_16.MathOperandSet.OneOperandSet))
            Input_EQUALS();
        m_currentmathExpression.AddOperation(MathExpression_2_8_16.MathOperation.ADD);

        if (m_currentmathExpression.NeedAddOperand())
        {
            if (m_NeedClearDialogDisplay == true )
            {
                if (!m_calcHistory16.IsEmply())
                    m_currentmathExpression.AddOperand(m_calcHistory16.GetLastAnswer());
            }
            else
            {
                String str = m_calcDialogDisplay.getText().toString();
                //Long.parseLong(str, 16)
                m_currentmathExpression.AddOperand(Long.parseLong(str, 16));
            }
        }
        m_NeedClearDialogDisplay = true;
    }
    public void Input_SUBTRACT()
    {
        if (m_NeedClearDialogDisplay == false && (m_currentmathExpression.getMathOperandSet() == MathExpression_2_8_16.MathOperandSet.OneOperandSet))
            Input_EQUALS();
        m_currentmathExpression.AddOperation(MathExpression_2_8_16.MathOperation.SUBTRACT);

        if (m_currentmathExpression.NeedAddOperand())
        {
            if (m_NeedClearDialogDisplay == true )
            {
                if (!m_calcHistory16.IsEmply())
                    m_currentmathExpression.AddOperand(m_calcHistory16.GetLastAnswer());
            }
            else
            {
                String str = m_calcDialogDisplay.getText().toString();
                m_currentmathExpression.AddOperand(Long.parseLong(str, 16));
            }
        }
        m_NeedClearDialogDisplay = true;
    }
    public void Input_MULTIPLY()
    {
        if (m_NeedClearDialogDisplay == false && (m_currentmathExpression.getMathOperandSet() == MathExpression_2_8_16.MathOperandSet.OneOperandSet))
            Input_EQUALS();
        m_currentmathExpression.AddOperation(MathExpression_2_8_16.MathOperation.MULTIPLY);

        if (m_currentmathExpression.NeedAddOperand())
        {
            if (m_NeedClearDialogDisplay == true )
            {
                if (!m_calcHistory16.IsEmply())
                    m_currentmathExpression.AddOperand(m_calcHistory16.GetLastAnswer());
            }
            else
            {
                String str = m_calcDialogDisplay.getText().toString();
                m_currentmathExpression.AddOperand(Long.parseLong(str, 16));
            }
        }
        m_NeedClearDialogDisplay = true;
    }
    public void Input_DIVISION()
    {
        if (m_NeedClearDialogDisplay == false && (m_currentmathExpression.getMathOperandSet() == MathExpression_2_8_16.MathOperandSet.OneOperandSet))
            Input_EQUALS();
        m_currentmathExpression.AddOperation(MathExpression_2_8_16.MathOperation.DIVISION);
        if (m_currentmathExpression.NeedAddOperand())
        {
            if (m_NeedClearDialogDisplay == true )
            {
                if (!m_calcHistory16.IsEmply())
                    m_currentmathExpression.AddOperand(m_calcHistory16.GetLastAnswer());
            }
            else
            {
                String str = m_calcDialogDisplay.getText().toString();
                m_currentmathExpression.AddOperand(Long.parseLong(str, 16));
            }
        }
        m_NeedClearDialogDisplay = true;
    }
    public void Input_EQUALS()
    {
        String str = m_calcDialogDisplay.getText().toString();
        if (str.equals("") || !m_currentmathExpression.IsSetMathOperation()) return;
        m_calcDialogDisplay.setText("");
        m_currentmathExpression.AddOperand(Long.parseLong(str, 16));
        m_calcDialogDisplay.setText(Long.toHexString(m_currentmathExpression.GetAnswer()));
        m_NeedClearDialogDisplay = true;

        m_calcHistory16.AddMathExpression(m_currentmathExpression, m_calcHistoryDisplay);
        m_currentmathExpression = new MathExpression_2_8_16(m_context, NumberSystem.HEX);
    }
    public void Input_SINGCHANGE()
    {
        if (m_NeedClearDialogDisplay == false)
        {
            String str = m_calcDialogDisplay.getText().toString();
            if (str.equals("") || str == null) return;
            long numb = Long.parseLong(str, 16);
            numb *= -1;
            m_calcDialogDisplay.setText(Long.toString((int) numb));
        }
        else
        {
            m_currentmathExpression.AddOperation(MathExpression_2_8_16.MathOperation.SINGCHANGE);
            if (m_NeedClearDialogDisplay == true )
            {
                if (!m_calcHistory16.IsEmply())
                    m_currentmathExpression.AddOperand(m_calcHistory16.GetLastAnswer());
                else return;
            }
            else
            {
                String str = m_calcDialogDisplay.getText().toString();
                m_currentmathExpression.AddOperand(Long.parseLong(str, 16));
            }
            m_calcDialogDisplay.setText(Long.toHexString(m_currentmathExpression.GetAnswer()));
            m_NeedClearDialogDisplay = true;

            m_calcHistory16.AddMathExpression(m_currentmathExpression, m_calcHistoryDisplay);
            m_currentmathExpression = new MathExpression_2_8_16(m_context, NumberSystem.HEX);
        }
    }
    public void Input_LOG()
    {
        if (m_NeedClearDialogDisplay == false && (m_currentmathExpression.getMathOperandSet() == MathExpression_2_8_16.MathOperandSet.OneOperandSet))
            Input_EQUALS();
        m_currentmathExpression.AddOperation(MathExpression_2_8_16.MathOperation.LOG);
        if (m_NeedClearDialogDisplay == true )
        {
            if (!m_calcHistory16.IsEmply())
                m_currentmathExpression.AddOperand(m_calcHistory16.GetLastAnswer());
            else return;
        }
        else
        {
            String str = m_calcDialogDisplay.getText().toString();
            m_currentmathExpression.AddOperand(Long.parseLong(str, 16));
        }
        m_calcDialogDisplay.setText(Long.toHexString(m_currentmathExpression.GetAnswer()));
        m_NeedClearDialogDisplay = true;

        m_calcHistory16.AddMathExpression(m_currentmathExpression, m_calcHistoryDisplay);
        m_currentmathExpression = new MathExpression_2_8_16(m_context, NumberSystem.HEX);
    }
    public void Input_EXP()
    {
        if (m_NeedClearDialogDisplay == false && (m_currentmathExpression.getMathOperandSet() == MathExpression_2_8_16.MathOperandSet.OneOperandSet))
            Input_EQUALS();
        m_currentmathExpression.AddOperation(MathExpression_2_8_16.MathOperation.EXP);
        if (m_NeedClearDialogDisplay == true )
        {
            if (!m_calcHistory16.IsEmply())
                m_currentmathExpression.AddOperand(m_calcHistory16.GetLastAnswer());
            else return;
        }
        else
        {
            String str = m_calcDialogDisplay.getText().toString();
            m_currentmathExpression.AddOperand(Long.parseLong(str, 16));
        }
        m_calcDialogDisplay.setText(Long.toHexString(m_currentmathExpression.GetAnswer()));
        m_NeedClearDialogDisplay = true;

        m_calcHistory16.AddMathExpression(m_currentmathExpression, m_calcHistoryDisplay);
        m_currentmathExpression = new MathExpression_2_8_16(m_context, NumberSystem.HEX);
    }
    public void Input_POW()
    {
        if (m_NeedClearDialogDisplay == false && (m_currentmathExpression.getMathOperandSet() == MathExpression_2_8_16.MathOperandSet.OneOperandSet))
            Input_EQUALS();
        m_currentmathExpression.AddOperation(MathExpression_2_8_16.MathOperation.POW);

        if (m_currentmathExpression.NeedAddOperand())
        {
            if (m_NeedClearDialogDisplay == true )
            {
                if (!m_calcHistory16.IsEmply())
                    m_currentmathExpression.AddOperand(m_calcHistory16.GetLastAnswer());
            }
            else
            {
                String str = m_calcDialogDisplay.getText().toString();
                m_currentmathExpression.AddOperand(Long.parseLong(str, 16));
            }
        }
        m_NeedClearDialogDisplay = true;
    }
    public void Input_FACTORIAL()
    {
        if (m_NeedClearDialogDisplay == false && (m_currentmathExpression.getMathOperandSet() == MathExpression_2_8_16.MathOperandSet.OneOperandSet))
            Input_EQUALS();
        m_currentmathExpression.AddOperation(MathExpression_2_8_16.MathOperation.FACTORIAL);
        long operand;
        if (m_NeedClearDialogDisplay == true )
        {
            if (!m_calcHistory16.IsEmply())
                operand = m_calcHistory16.GetLastAnswer();
            else return;
        }
        else
        {
            String str = m_calcDialogDisplay.getText().toString();
            m_currentmathExpression.AddOperand(Long.parseLong(str, 16));
            operand = Long.parseLong(str, 16);
        }
        m_calcDialogDisplay.setText("");
        m_currentmathExpression.AddOperand(operand);
        m_calcDialogDisplay.setText(Long.toHexString(m_currentmathExpression.GetAnswer()));
        m_NeedClearDialogDisplay = true;

        m_calcHistory16.AddMathExpression(m_currentmathExpression, m_calcHistoryDisplay);
        m_currentmathExpression = new MathExpression_2_8_16(m_context, NumberSystem.HEX);
    }
    public void Input_SIN()
    {
        if (m_NeedClearDialogDisplay == false && (m_currentmathExpression.getMathOperandSet() == MathExpression_2_8_16.MathOperandSet.OneOperandSet))
            Input_EQUALS();
        m_currentmathExpression.AddOperation(MathExpression_2_8_16.MathOperation.SIN);
        if (m_NeedClearDialogDisplay == true )
        {
            if (!m_calcHistory16.IsEmply())
                m_currentmathExpression.AddOperand(m_calcHistory16.GetLastAnswer());
            else return;
        }
        else
        {
            String str = m_calcDialogDisplay.getText().toString();
            m_currentmathExpression.AddOperand(Long.parseLong(str, 16));
        }
        m_calcDialogDisplay.setText(Long.toHexString(m_currentmathExpression.GetAnswer()));
        m_NeedClearDialogDisplay = true;

        m_calcHistory16.AddMathExpression(m_currentmathExpression, m_calcHistoryDisplay);
        m_currentmathExpression = new MathExpression_2_8_16(m_context, NumberSystem.HEX);
    }
    public void Input_COS()
    {
        if (m_NeedClearDialogDisplay == false && (m_currentmathExpression.getMathOperandSet() == MathExpression_2_8_16.MathOperandSet.OneOperandSet))
            Input_EQUALS();
        m_currentmathExpression.AddOperation(MathExpression_2_8_16.MathOperation.COS);
        if (m_NeedClearDialogDisplay == true )
        {
            if (!m_calcHistory16.IsEmply())
                m_currentmathExpression.AddOperand(m_calcHistory16.GetLastAnswer());
            else return;
        }
        else
        {
            String str = m_calcDialogDisplay.getText().toString();
            m_currentmathExpression.AddOperand(Long.parseLong(str, 16));
        }
        m_calcDialogDisplay.setText(Long.toHexString(m_currentmathExpression.GetAnswer()));
        m_NeedClearDialogDisplay = true;

        m_calcHistory16.AddMathExpression(m_currentmathExpression, m_calcHistoryDisplay);
        m_currentmathExpression = new MathExpression_2_8_16(m_context, NumberSystem.HEX);
    }
    public void Input_TAN()
    {
        if (m_NeedClearDialogDisplay == false && (m_currentmathExpression.getMathOperandSet() == MathExpression_2_8_16.MathOperandSet.OneOperandSet))
            Input_EQUALS();
        m_currentmathExpression.AddOperation(MathExpression_2_8_16.MathOperation.TAN);
        if (m_NeedClearDialogDisplay == true )
        {
            if (!m_calcHistory16.IsEmply())
                m_currentmathExpression.AddOperand(m_calcHistory16.GetLastAnswer());
            else return;
        }
        else
        {
            String str = m_calcDialogDisplay.getText().toString();
            m_currentmathExpression.AddOperand(Long.parseLong(str, 16));
        }
        m_calcDialogDisplay.setText(Long.toHexString(m_currentmathExpression.GetAnswer()));
        //Long.toHexString(m_currentmathExpression.GetAnswer());
        m_NeedClearDialogDisplay = true;

        m_calcHistory16.AddMathExpression(m_currentmathExpression, m_calcHistoryDisplay);
        m_currentmathExpression = new MathExpression_2_8_16(m_context, NumberSystem.HEX);
    }
    public void Input_CalcHistory_BackwardHistory()
    {
        m_calcHistory16.BackwardHistory(m_calcHistoryDisplay, m_calcDialogDisplay);
    }
    public void Input_CalcHistory_ForwardHistory()
    {
        m_calcHistory16.ForwardHistory(m_calcHistoryDisplay, m_calcDialogDisplay);
    }
}
