package com.example.calc.BinNumberSystem;

import android.content.Context;
import android.widget.TextView;

/**
 * Created by Артём on 22.08.2018.
 */

public class Calc2
{
    public TextView m_calcDialogDisplay;
    public TextView m_calcHistoryDisplay;
    private MathExpression2 m_currentmathExpression;
    private boolean m_NeedClearDialogDisplay;

    private Context m_context;
    private CalcHistory2 m_calcHistory2;

    public Calc2(Context context)
    {
        m_context = context;
        Initialize();
    }

    public void Initialize()
    {
        m_calcHistory2 = new CalcHistory2();
        m_currentmathExpression = new MathExpression2(m_context);
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

    public void Input_AllClear()
    {
        m_NeedClearDialogDisplay = true;
        //m_operandStr.delete(0, m_operandStr.length()-1);
        m_calcDialogDisplay.setText("");
    }
    public void Input_ADD()
    {
        if (m_NeedClearDialogDisplay == false && (m_currentmathExpression.mathOperandSet == MathExpression2.MathOperandSet.OneOperandSet))
            Input_EQUALS();
        m_currentmathExpression.AddOperation(MathExpression2.MathOperation.ADD);

        if (m_currentmathExpression.NeedAddOperand())
        {
            if (m_NeedClearDialogDisplay == true )
            {
                if (!m_calcHistory2.IsEmply())
                    m_currentmathExpression.AddOperand(m_calcHistory2.GetLastAnswer());
            }
            else
            {
                String str = m_calcDialogDisplay.getText().toString();
                //Long.parseLong(str, 2)
                m_currentmathExpression.AddOperand(Long.parseLong(str, 2));
            }
        }
        m_NeedClearDialogDisplay = true;
    }
    public void Input_SUBTRACT()
    {
        if (m_NeedClearDialogDisplay == false && (m_currentmathExpression.mathOperandSet == MathExpression2.MathOperandSet.OneOperandSet))
            Input_EQUALS();
        m_currentmathExpression.AddOperation(MathExpression2.MathOperation.SUBTRACT);

        if (m_currentmathExpression.NeedAddOperand())
        {
            if (m_NeedClearDialogDisplay == true )
            {
                if (!m_calcHistory2.IsEmply())
                    m_currentmathExpression.AddOperand(m_calcHistory2.GetLastAnswer());
            }
            else
            {
                String str = m_calcDialogDisplay.getText().toString();
                m_currentmathExpression.AddOperand(Long.parseLong(str, 2));
            }
        }
        m_NeedClearDialogDisplay = true;
    }
    public void Input_MULTIPLY()
    {
        if (m_NeedClearDialogDisplay == false && (m_currentmathExpression.mathOperandSet == MathExpression2.MathOperandSet.OneOperandSet))
            Input_EQUALS();
        m_currentmathExpression.AddOperation(MathExpression2.MathOperation.MULTIPLY);

        if (m_currentmathExpression.NeedAddOperand())
        {
            if (m_NeedClearDialogDisplay == true )
            {
                if (!m_calcHistory2.IsEmply())
                    m_currentmathExpression.AddOperand(m_calcHistory2.GetLastAnswer());
            }
            else
            {
                String str = m_calcDialogDisplay.getText().toString();
                m_currentmathExpression.AddOperand(Long.parseLong(str, 2));
            }
        }
        m_NeedClearDialogDisplay = true;
    }
    public void Input_DIVISION()
    {
        if (m_NeedClearDialogDisplay == false && (m_currentmathExpression.mathOperandSet == MathExpression2.MathOperandSet.OneOperandSet))
            Input_EQUALS();
        m_currentmathExpression.AddOperation(MathExpression2.MathOperation.DIVISION);
        if (m_currentmathExpression.NeedAddOperand())
        {
            if (m_NeedClearDialogDisplay == true )
            {
                if (!m_calcHistory2.IsEmply())
                    m_currentmathExpression.AddOperand(m_calcHistory2.GetLastAnswer());
            }
            else
            {
                String str = m_calcDialogDisplay.getText().toString();
                m_currentmathExpression.AddOperand(Long.parseLong(str, 2));
            }
        }
        m_NeedClearDialogDisplay = true;
    }
    public void Input_EQUALS()
    {
        String str = m_calcDialogDisplay.getText().toString();
        if (str.equals("") || !m_currentmathExpression.IsSetMathOperation()) return;
        m_calcDialogDisplay.setText("");
        m_currentmathExpression.AddOperand(Long.parseLong(str, 2));
        m_calcDialogDisplay.setText(Long.toBinaryString(m_currentmathExpression.GetAnswer()));
        m_NeedClearDialogDisplay = true;

        m_calcHistory2.AddMathExpression(m_currentmathExpression, m_calcHistoryDisplay);
        m_currentmathExpression = new MathExpression2(m_context);
    }
    public void Input_SINGCHANGE()
    {
        if (m_NeedClearDialogDisplay == false)
        {
            String str = m_calcDialogDisplay.getText().toString();
            if (str.equals("") || str == null) return;
            long numb = Long.parseLong(str, 2);
            numb *= -1;
            m_calcDialogDisplay.setText(Long.toString((int) numb));
        }
        else
        {
            m_currentmathExpression.AddOperation(MathExpression2.MathOperation.SINGCHANGE);
            if (m_NeedClearDialogDisplay == true )
            {
                if (!m_calcHistory2.IsEmply())
                    m_currentmathExpression.AddOperand(m_calcHistory2.GetLastAnswer());
                else return;
            }
            else
            {
                String str = m_calcDialogDisplay.getText().toString();
                m_currentmathExpression.AddOperand(Long.parseLong(str, 2));
            }
            m_calcDialogDisplay.setText(Long.toBinaryString(m_currentmathExpression.GetAnswer()));
            m_NeedClearDialogDisplay = true;

            m_calcHistory2.AddMathExpression(m_currentmathExpression, m_calcHistoryDisplay);
            m_currentmathExpression = new MathExpression2(m_context);
        }
    }
    public void Input_LOG()
    {
        if (m_NeedClearDialogDisplay == false && (m_currentmathExpression.mathOperandSet == MathExpression2.MathOperandSet.OneOperandSet))
            Input_EQUALS();
        m_currentmathExpression.AddOperation(MathExpression2.MathOperation.LOG);
        if (m_NeedClearDialogDisplay == true )
        {
            if (!m_calcHistory2.IsEmply())
                m_currentmathExpression.AddOperand(m_calcHistory2.GetLastAnswer());
            else return;
        }
        else
        {
            String str = m_calcDialogDisplay.getText().toString();
            m_currentmathExpression.AddOperand(Long.parseLong(str, 2));
        }
        m_calcDialogDisplay.setText(Long.toBinaryString(m_currentmathExpression.GetAnswer()));
        m_NeedClearDialogDisplay = true;

        m_calcHistory2.AddMathExpression(m_currentmathExpression, m_calcHistoryDisplay);
        m_currentmathExpression = new MathExpression2(m_context);
    }
    public void Input_EXP()
    {
        if (m_NeedClearDialogDisplay == false && (m_currentmathExpression.mathOperandSet == MathExpression2.MathOperandSet.OneOperandSet))
            Input_EQUALS();
        m_currentmathExpression.AddOperation(MathExpression2.MathOperation.EXP);
        if (m_NeedClearDialogDisplay == true )
        {
            if (!m_calcHistory2.IsEmply())
                m_currentmathExpression.AddOperand(m_calcHistory2.GetLastAnswer());
            else return;
        }
        else
        {
            String str = m_calcDialogDisplay.getText().toString();
            m_currentmathExpression.AddOperand(Long.parseLong(str, 2));
        }
        m_calcDialogDisplay.setText(Long.toBinaryString(m_currentmathExpression.GetAnswer()));
        m_NeedClearDialogDisplay = true;

        m_calcHistory2.AddMathExpression(m_currentmathExpression, m_calcHistoryDisplay);
        m_currentmathExpression = new MathExpression2(m_context);
    }
    public void Input_POW()
    {
        if (m_NeedClearDialogDisplay == false && (m_currentmathExpression.mathOperandSet == MathExpression2.MathOperandSet.OneOperandSet))
            Input_EQUALS();
        m_currentmathExpression.AddOperation(MathExpression2.MathOperation.POW);

        if (m_currentmathExpression.NeedAddOperand())
        {
            if (m_NeedClearDialogDisplay == true )
            {
                if (!m_calcHistory2.IsEmply())
                    m_currentmathExpression.AddOperand(m_calcHistory2.GetLastAnswer());
            }
            else
            {
                String str = m_calcDialogDisplay.getText().toString();
                m_currentmathExpression.AddOperand(Long.parseLong(str, 2));
            }
        }
        m_NeedClearDialogDisplay = true;
    }
    public void Input_FACTORIAL()
    {
        if (m_NeedClearDialogDisplay == false && (m_currentmathExpression.mathOperandSet == MathExpression2.MathOperandSet.OneOperandSet))
            Input_EQUALS();
        m_currentmathExpression.AddOperation(MathExpression2.MathOperation.FACTORIAL);
        long operand;
        if (m_NeedClearDialogDisplay == true )
        {
            if (!m_calcHistory2.IsEmply())
                operand = m_calcHistory2.GetLastAnswer();
            else return;
        }
        else
        {
            String str = m_calcDialogDisplay.getText().toString();
            m_currentmathExpression.AddOperand(Long.parseLong(str, 2));
            operand = Long.parseLong(str, 2);
        }
        m_calcDialogDisplay.setText("");
        m_currentmathExpression.AddOperand(operand);
        m_calcDialogDisplay.setText(Long.toBinaryString(m_currentmathExpression.GetAnswer()));
        m_NeedClearDialogDisplay = true;

        m_calcHistory2.AddMathExpression(m_currentmathExpression, m_calcHistoryDisplay);
        m_currentmathExpression = new MathExpression2(m_context);
    }
    public void Input_SIN()
    {
        if (m_NeedClearDialogDisplay == false && (m_currentmathExpression.mathOperandSet == MathExpression2.MathOperandSet.OneOperandSet))
            Input_EQUALS();
        m_currentmathExpression.AddOperation(MathExpression2.MathOperation.SIN);
        if (m_NeedClearDialogDisplay == true )
        {
            if (!m_calcHistory2.IsEmply())
                m_currentmathExpression.AddOperand(m_calcHistory2.GetLastAnswer());
            else return;
        }
        else
        {
            String str = m_calcDialogDisplay.getText().toString();
            m_currentmathExpression.AddOperand(Long.parseLong(str, 2));
        }
        m_calcDialogDisplay.setText(Long.toBinaryString(m_currentmathExpression.GetAnswer()));
        m_NeedClearDialogDisplay = true;

        m_calcHistory2.AddMathExpression(m_currentmathExpression, m_calcHistoryDisplay);
        m_currentmathExpression = new MathExpression2(m_context);
    }
    public void Input_COS()
    {
        if (m_NeedClearDialogDisplay == false && (m_currentmathExpression.mathOperandSet == MathExpression2.MathOperandSet.OneOperandSet))
            Input_EQUALS();
        m_currentmathExpression.AddOperation(MathExpression2.MathOperation.COS);
        if (m_NeedClearDialogDisplay == true )
        {
            if (!m_calcHistory2.IsEmply())
                m_currentmathExpression.AddOperand(m_calcHistory2.GetLastAnswer());
            else return;
        }
        else
        {
            String str = m_calcDialogDisplay.getText().toString();
            m_currentmathExpression.AddOperand(Long.parseLong(str, 2));
        }
        m_calcDialogDisplay.setText(Long.toBinaryString(m_currentmathExpression.GetAnswer()));
        m_NeedClearDialogDisplay = true;

        m_calcHistory2.AddMathExpression(m_currentmathExpression, m_calcHistoryDisplay);
        m_currentmathExpression = new MathExpression2(m_context);
    }
    public void Input_TAN()
    {
        if (m_NeedClearDialogDisplay == false && (m_currentmathExpression.mathOperandSet == MathExpression2.MathOperandSet.OneOperandSet))
            Input_EQUALS();
        m_currentmathExpression.AddOperation(MathExpression2.MathOperation.TAN);
        if (m_NeedClearDialogDisplay == true )
        {
            if (!m_calcHistory2.IsEmply())
                m_currentmathExpression.AddOperand(m_calcHistory2.GetLastAnswer());
            else return;
        }
        else
        {
            String str = m_calcDialogDisplay.getText().toString();
            m_currentmathExpression.AddOperand(Long.parseLong(str, 2));
        }
        m_calcDialogDisplay.setText(Long.toBinaryString(m_currentmathExpression.GetAnswer()));
        m_NeedClearDialogDisplay = true;

        m_calcHistory2.AddMathExpression(m_currentmathExpression, m_calcHistoryDisplay);
        m_currentmathExpression = new MathExpression2(m_context);
    }
    public void Input_CalcHistory_BackwardHistory()
    {
        m_calcHistory2.BackwardHistory(m_calcHistoryDisplay, m_calcDialogDisplay);
    }
    public void Input_CalcHistory_ForwardHistory()
    {
        m_calcHistory2.ForwardHistory(m_calcHistoryDisplay, m_calcDialogDisplay);
    }
}
