package com.example.calc.Calc;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calc.CalcHistory.CalcHistory10;
import com.example.calc.MathExpression.MathExpression10;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 * Created by Артём on 22.08.2018.
 */

public class Calc10
{
    public TextView m_calcDialogDisplay;
    public TextView m_calcHistoryDisplay;
    private MathExpression10 m_currentmathExpression;
    private char m_decimalSeparator;
    private boolean m_NeedClearDialogDisplay;

    private Context m_context;
    private CalcHistory10 m_calcHistory10;

    public Calc10(Context context)
    {
        m_context = context;
        //Initialize();
    }

    public void Initialize()
    {
        m_calcHistory10 = new CalcHistory10();
        m_currentmathExpression = new MathExpression10(m_context);
        m_NeedClearDialogDisplay = true;

        DecimalFormat format = (DecimalFormat) DecimalFormat.getInstance();
        DecimalFormatSymbols symbols = format.getDecimalFormatSymbols();
        m_decimalSeparator = symbols.getDecimalSeparator();
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

    public void Input_Point()
    {
        if (m_NeedClearDialogDisplay)
            m_calcDialogDisplay.setText("");
        m_NeedClearDialogDisplay = false;

        String str = m_calcDialogDisplay.getText().toString();
        if (!str.contains("."))
            m_calcDialogDisplay.append(".");
    }

    public void Input_AllClear()
    {
        m_NeedClearDialogDisplay = true;
        //m_operandStr.delete(0, m_operandStr.length()-1);
        m_calcDialogDisplay.setText("");
    }
    public void Input_ADD()
    {
        if (m_NeedClearDialogDisplay == false && (m_currentmathExpression.mathOperandSet == MathExpression10.MathOperandSet.OneOperandSet))
            Input_EQUALS();
        m_currentmathExpression.AddOperation(MathExpression10.MathOperation.ADD);

        if (m_currentmathExpression.NeedAddOperand())
        {
            if (m_NeedClearDialogDisplay == true )
            {
                if (!m_calcHistory10.IsEmply())
                    m_currentmathExpression.AddOperand(m_calcHistory10.GetLastAnswer());
            }
            else
            {
                String str = m_calcDialogDisplay.getText().toString();
                if (m_decimalSeparator == ',')
                    str = str.replace(",", ".");
                m_currentmathExpression.AddOperand(Double.parseDouble(str));
            }
        }
        m_NeedClearDialogDisplay = true;
    }
    public void Input_SUBTRACT()
    {
        if (m_NeedClearDialogDisplay == false && (m_currentmathExpression.mathOperandSet == MathExpression10.MathOperandSet.OneOperandSet))
            Input_EQUALS();
        m_currentmathExpression.AddOperation(MathExpression10.MathOperation.SUBTRACT);

        if (m_currentmathExpression.NeedAddOperand())
        {
            if (m_NeedClearDialogDisplay == true )
            {
                if (!m_calcHistory10.IsEmply())
                    m_currentmathExpression.AddOperand(m_calcHistory10.GetLastAnswer());
            }
            else
            {
                String str = m_calcDialogDisplay.getText().toString();
                if (m_decimalSeparator == ',')
                    str = str.replace(",", ".");
                m_currentmathExpression.AddOperand(Double.parseDouble(str));
            }
        }
        m_NeedClearDialogDisplay = true;
    }
    public void Input_MULTIPLY()
    {
        if (m_NeedClearDialogDisplay == false && (m_currentmathExpression.mathOperandSet == MathExpression10.MathOperandSet.OneOperandSet))
            Input_EQUALS();
        m_currentmathExpression.AddOperation(MathExpression10.MathOperation.MULTIPLY);

        if (m_currentmathExpression.NeedAddOperand())
        {
            if (m_NeedClearDialogDisplay == true )
            {
                if (!m_calcHistory10.IsEmply())
                    m_currentmathExpression.AddOperand(m_calcHistory10.GetLastAnswer());
            }
            else
            {
                String str = m_calcDialogDisplay.getText().toString();
                if (m_decimalSeparator == ',')
                    str = str.replace(",", ".");
                m_currentmathExpression.AddOperand(Double.parseDouble(str));
            }
        }
        m_NeedClearDialogDisplay = true;
    }
    public void Input_DIVISION()
    {
        if (m_NeedClearDialogDisplay == false && (m_currentmathExpression.mathOperandSet == MathExpression10.MathOperandSet.OneOperandSet))
            Input_EQUALS();
        m_currentmathExpression.AddOperation(MathExpression10.MathOperation.DIVISION);
        if (m_currentmathExpression.NeedAddOperand())
        {
            if (m_NeedClearDialogDisplay == true )
            {
                if (!m_calcHistory10.IsEmply())
                    m_currentmathExpression.AddOperand(m_calcHistory10.GetLastAnswer());
            }
            else
            {
                String str = m_calcDialogDisplay.getText().toString();
                if (m_decimalSeparator == ',')
                    str = str.replace(",", ".");
                m_currentmathExpression.AddOperand(Double.parseDouble(str));
            }
        }
        m_NeedClearDialogDisplay = true;
    }
    public void Input_EQUALS()
    {
        String str = m_calcDialogDisplay.getText().toString();
        if (str.equals("") || !m_currentmathExpression.IsSetMathOperation()) return;
        m_calcDialogDisplay.setText("");
        if (m_decimalSeparator==',')
            str = str.replace(",", ".");
        m_currentmathExpression.AddOperand(Double.parseDouble(str));
        m_calcDialogDisplay.setText(String.format("%.6f", m_currentmathExpression.GetAnswer()));
        m_NeedClearDialogDisplay = true;

        m_calcHistory10.AddMathExpression(m_currentmathExpression, m_calcHistoryDisplay);
        m_currentmathExpression = new MathExpression10(m_context);
    }
    public void Input_SINGCHANGE()
    {
        if (m_NeedClearDialogDisplay == false)
        {
            String str = m_calcDialogDisplay.getText().toString();
            if (str.equals("") || str == null || str.equals(".")) return;
            if (m_decimalSeparator == ',')
                str = str.replace(",", ".");
            double numb = Double.parseDouble(str);
            numb *= -1;
            if ((int)numb != numb)
                m_calcDialogDisplay.setText(Double.toString(numb));
            else
                m_calcDialogDisplay.setText(Integer.toString((int) numb));
        }
        else
        {
            m_currentmathExpression.AddOperation(MathExpression10.MathOperation.SINGCHANGE);
            if (m_NeedClearDialogDisplay == true )
            {
                if (!m_calcHistory10.IsEmply())
                    m_currentmathExpression.AddOperand(m_calcHistory10.GetLastAnswer());
                else return;
            }
            else
            {
                String str = m_calcDialogDisplay.getText().toString();
                if (m_decimalSeparator == ',')
                    str = str.replace(",", ".");
                m_currentmathExpression.AddOperand(Double.parseDouble(str));
            }
            m_calcDialogDisplay.setText(String.format("%.6f", m_currentmathExpression.GetAnswer()));
            m_NeedClearDialogDisplay = true;

            m_calcHistory10.AddMathExpression(m_currentmathExpression, m_calcHistoryDisplay);
            m_currentmathExpression = new MathExpression10(m_context);
        }
    }
    public void Input_LOG()
    {
        if (m_NeedClearDialogDisplay == false && (m_currentmathExpression.mathOperandSet == MathExpression10.MathOperandSet.OneOperandSet))
            Input_EQUALS();
        m_currentmathExpression.AddOperation(MathExpression10.MathOperation.LOG);
        if (m_NeedClearDialogDisplay == true )
        {
            if (!m_calcHistory10.IsEmply())
                m_currentmathExpression.AddOperand(m_calcHistory10.GetLastAnswer());
            else return;
        }
        else
        {
            String str = m_calcDialogDisplay.getText().toString();
            if (m_decimalSeparator == ',')
                str = str.replace(",", ".");
            m_currentmathExpression.AddOperand(Double.parseDouble(str));
        }
        m_calcDialogDisplay.setText(String.format("%.6f", m_currentmathExpression.GetAnswer()));
        m_NeedClearDialogDisplay = true;

        m_calcHistory10.AddMathExpression(m_currentmathExpression, m_calcHistoryDisplay);
        m_currentmathExpression = new MathExpression10(m_context);
    }
    public void Input_EXP()
    {
        if (m_NeedClearDialogDisplay == false && (m_currentmathExpression.mathOperandSet == MathExpression10.MathOperandSet.OneOperandSet))
            Input_EQUALS();
        m_currentmathExpression.AddOperation(MathExpression10.MathOperation.EXP);
        if (m_NeedClearDialogDisplay == true )
        {
            if (!m_calcHistory10.IsEmply())
                m_currentmathExpression.AddOperand(m_calcHistory10.GetLastAnswer());
            else return;
        }
        else
        {
            String str = m_calcDialogDisplay.getText().toString();
            if (m_decimalSeparator == ',')
                str = str.replace(",", ".");
            m_currentmathExpression.AddOperand(Double.parseDouble(str));
        }
        m_calcDialogDisplay.setText(String.format("%.6f", m_currentmathExpression.GetAnswer()));
        m_NeedClearDialogDisplay = true;

        m_calcHistory10.AddMathExpression(m_currentmathExpression, m_calcHistoryDisplay);
        m_currentmathExpression = new MathExpression10(m_context);
    }
    public void Input_POW()
    {
        if (m_NeedClearDialogDisplay == false && (m_currentmathExpression.mathOperandSet == MathExpression10.MathOperandSet.OneOperandSet))
            Input_EQUALS();
        m_currentmathExpression.AddOperation(MathExpression10.MathOperation.POW);

        if (m_currentmathExpression.NeedAddOperand())
        {
            if (m_NeedClearDialogDisplay == true )
            {
                if (!m_calcHistory10.IsEmply())
                    m_currentmathExpression.AddOperand(m_calcHistory10.GetLastAnswer());
            }
            else
            {
                String str = m_calcDialogDisplay.getText().toString();
                if (m_decimalSeparator == ',')
                    str = str.replace(",", ".");
                m_currentmathExpression.AddOperand(Double.parseDouble(str));
            }
        }
        m_NeedClearDialogDisplay = true;
    }
    public void Input_FACTORIAL()
    {
        if (m_NeedClearDialogDisplay == false && (m_currentmathExpression.mathOperandSet == MathExpression10.MathOperandSet.OneOperandSet))
            Input_EQUALS();
        m_currentmathExpression.AddOperation(MathExpression10.MathOperation.FACTORIAL);
        double operand;
        if (m_NeedClearDialogDisplay == true )
        {
            if (!m_calcHistory10.IsEmply())
                operand = m_calcHistory10.GetLastAnswer();
            else return;
        }
        else
        {
            String str = m_calcDialogDisplay.getText().toString();
            if (m_decimalSeparator == ',')
                str = str.replace(",", ".");
            m_currentmathExpression.AddOperand(Double.parseDouble(str));
            operand = Double.parseDouble(str);
        }

        if ( (int)operand != operand )
        {
            Toast.makeText(m_context, "Факториал может быть только целого числа", Toast.LENGTH_LONG).show();
            return;
        }
        m_calcDialogDisplay.setText("");
        m_currentmathExpression.AddOperand(operand);
        m_calcDialogDisplay.setText(String.format("%.0f", m_currentmathExpression.GetAnswer()));
        m_NeedClearDialogDisplay = true;

        m_calcHistory10.AddMathExpression(m_currentmathExpression, m_calcHistoryDisplay);
        m_currentmathExpression = new MathExpression10(m_context);
    }
    public void Input_SIN()
    {
        if (m_NeedClearDialogDisplay == false && (m_currentmathExpression.mathOperandSet == MathExpression10.MathOperandSet.OneOperandSet))
            Input_EQUALS();
        m_currentmathExpression.AddOperation(MathExpression10.MathOperation.SIN);
        if (m_NeedClearDialogDisplay == true )
        {
            if (!m_calcHistory10.IsEmply())
                m_currentmathExpression.AddOperand(m_calcHistory10.GetLastAnswer());
            else return;
        }
        else
        {
            String str = m_calcDialogDisplay.getText().toString();
            if (m_decimalSeparator == ',')
                str = str.replace(",", ".");
            m_currentmathExpression.AddOperand(Double.parseDouble(str));
        }
        m_calcDialogDisplay.setText(String.format("%.6f", m_currentmathExpression.GetAnswer()));
        m_NeedClearDialogDisplay = true;

        m_calcHistory10.AddMathExpression(m_currentmathExpression, m_calcHistoryDisplay);
        m_currentmathExpression = new MathExpression10(m_context);
    }
    public void Input_COS()
    {
        if (m_NeedClearDialogDisplay == false && (m_currentmathExpression.mathOperandSet == MathExpression10.MathOperandSet.OneOperandSet))
            Input_EQUALS();
        m_currentmathExpression.AddOperation(MathExpression10.MathOperation.COS);
        if (m_NeedClearDialogDisplay == true )
        {
            if (!m_calcHistory10.IsEmply())
                m_currentmathExpression.AddOperand(m_calcHistory10.GetLastAnswer());
            else return;
        }
        else
        {
            String str = m_calcDialogDisplay.getText().toString();
            if (m_decimalSeparator == ',')
                str = str.replace(",", ".");
            m_currentmathExpression.AddOperand(Double.parseDouble(str));
        }
        m_calcDialogDisplay.setText(String.format("%.6f", m_currentmathExpression.GetAnswer()));
        m_NeedClearDialogDisplay = true;

        m_calcHistory10.AddMathExpression(m_currentmathExpression, m_calcHistoryDisplay);
        m_currentmathExpression = new MathExpression10(m_context);
    }
    public void Input_TAN()
    {
        if (m_NeedClearDialogDisplay == false && (m_currentmathExpression.mathOperandSet == MathExpression10.MathOperandSet.OneOperandSet))
            Input_EQUALS();
        m_currentmathExpression.AddOperation(MathExpression10.MathOperation.TAN);
        if (m_NeedClearDialogDisplay == true )
        {
            if (!m_calcHistory10.IsEmply())
                m_currentmathExpression.AddOperand(m_calcHistory10.GetLastAnswer());
            else return;
        }
        else
        {
            String str = m_calcDialogDisplay.getText().toString();
            if (m_decimalSeparator == ',')
                str = str.replace(",", ".");
            m_currentmathExpression.AddOperand(Double.parseDouble(str));
        }
        m_calcDialogDisplay.setText(String.format("%.6f", m_currentmathExpression.GetAnswer()));
        m_NeedClearDialogDisplay = true;

        m_calcHistory10.AddMathExpression(m_currentmathExpression, m_calcHistoryDisplay);
        m_currentmathExpression = new MathExpression10(m_context);
    }
    public void Input_CalcHistory_BackwardHistory()
    {
        m_calcHistory10.BackwardHistory(m_calcHistoryDisplay, m_calcDialogDisplay);
    }
    public void Input_CalcHistory_ForwardHistory()
    {
        m_calcHistory10.ForwardHistory(m_calcHistoryDisplay, m_calcDialogDisplay);
    }
}
