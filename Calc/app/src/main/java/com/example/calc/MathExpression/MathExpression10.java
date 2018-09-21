package com.example.calc.MathExpression;


import android.content.Context;
import android.widget.Toast;

/**
 * Created by Артём on 24.08.2018.
 */


public class MathExpression10
{
    public enum MathOperation{NOT ,ADD, SUBTRACT, MULTIPLY, DIVISION, POW, SINGCHANGE, LOG, EXP, FACTORIAL, SIN, COS, TAN}//
    public enum MathOperandSet{OperandNotSet, OneOperandSet, TwoOperandSet}//
    enum TypeMathExpression{NOTSET, WithOneOperand, WithTwoOperand}//

    public double operand1, operand2, answer;//
    private String str_MathExpression;
    public MathOperation mathOperation;
    public MathOperandSet mathOperandSet;
    public TypeMathExpression typeMathExpression;
    private boolean m_isSetAnswer;
    private Context m_context;

    public MathExpression10(Context context)
    {
        m_context = context;
        typeMathExpression = TypeMathExpression.NOTSET;
        mathOperandSet = MathOperandSet.OperandNotSet;
        mathOperation = MathOperation.NOT;
        str_MathExpression = null;
        m_isSetAnswer = false;
    }

    @Override
    public String toString()
    {
        return str_MathExpression;
    }

    public boolean IsSetMathOperation()
    {
        return mathOperation!= MathOperation.NOT;
    }

    public boolean IsSetMathExpression()
    {
        boolean isSetMathOperation = IsSetMathOperation();
        if (!isSetMathOperation)
            return false;

        if (typeMathExpression == TypeMathExpression.WithOneOperand && mathOperandSet== MathOperandSet.OneOperandSet)
            return true;

        if (typeMathExpression == TypeMathExpression.WithTwoOperand && mathOperandSet== MathOperandSet.TwoOperandSet)
            return true;
        return false;
    }

    public boolean NeedAddOperand()
    {
        return mathOperandSet== MathOperandSet.OperandNotSet;
    }

    public double GetAnswer()
    {
        if (!IsSetMathExpression())
        {
            Toast.makeText(m_context, "Математическое выражение задано не правильно", Toast.LENGTH_LONG).show();
            throw new NullPointerException("Математическое выражение задано не правильно");
        }

        switch (mathOperation)
        {
            case ADD: answer = operand1+operand2; str_MathExpression = String.format("%.2f", operand1) + "+" + String.format("%.2f", operand2)+"="+ String.format("%.2f", answer);break;
            case SUBTRACT: answer = operand1-operand2; str_MathExpression = String.format("%.2f", operand1) + "-" + String.format("%.2f", operand2)+"="+ String.format("%.2f", answer);break;
            case MULTIPLY: answer = operand1*operand2; str_MathExpression = String.format("%.2f", operand1) + "*" + String.format("%.2f", operand2)+"="+ String.format("%.2f", answer);break;
            case DIVISION: answer = operand1/operand2; str_MathExpression = String.format("%.2f", operand1) + "/" + String.format("%.2f", operand2)+"="+ String.format("%.2f", answer);break;
            case POW: answer = Math.pow(operand1, operand2); str_MathExpression = String.format("%.2f", operand1) + "^" +"(" +String.format("%.2f", operand2)+")="+ String.format("%.2f", answer);break;
            case SINGCHANGE: answer = (-1) * operand1; str_MathExpression = String.format("%.2f", answer);break;
            case LOG: answer = Math.log10(operand1); str_MathExpression = "Log(" + String.format("%.2f", operand1) + ")=" + String.format("%.2f", answer);break;
            case EXP: answer = Math.exp(operand1); str_MathExpression = "exp(" + String.format("%.2f", operand1) + ")=" + String.format("%.2f", answer);break;
            case FACTORIAL: answer = GetFactorial(operand1); str_MathExpression = String.format("%.0f", operand1) + "!=" + String.format("%.0f", answer); break;
            case SIN: answer = Math.sin(operand1); str_MathExpression = "sin(" + String.format("%.2f", operand1) + ")=" + String.format("%.2f", answer); break;
            case COS: answer = Math.cos(operand1); str_MathExpression = "cos(" + String.format("%.2f", operand1) + ")=" + String.format("%.2f", answer);break;
            case TAN: answer = Math.tan(operand1); str_MathExpression = "tan(" + String.format("%.2f", operand1) + ")=" + String.format("%.2f", answer);break;
        }
        m_isSetAnswer = true;
        return answer;
    }

    public boolean IsSetAnswer(){ return m_isSetAnswer;}

    private double GetFactorial(double a)
    {
        if ( (int)a != a ) throw new NullPointerException("Факториал может быть только целого числа");
        int result;
        for (result = 1; a > 1; result *= (a--));
        return result;
    }

    public void AddOperand(double operand)
    {
        if (mathOperandSet == MathOperandSet.OperandNotSet)
        {
            operand1 = operand;
            mathOperandSet = MathOperandSet.OneOperandSet;
        }
        else
            if (mathOperandSet == MathOperandSet.OneOperandSet && typeMathExpression == TypeMathExpression.WithTwoOperand)
        {
            operand2 = operand;
            mathOperandSet = MathOperandSet.TwoOperandSet;
        }
        else
            if (mathOperandSet == MathOperandSet.OneOperandSet && typeMathExpression == TypeMathExpression.WithOneOperand)//на тот случай, когда выбрали операцию с 2мя операндами, а затем передумали и выбрали операцию с одним операндом
            {
                return;
            }
        else
            {
                Toast.makeText(m_context, "Ошибка в добавлении операнда", Toast.LENGTH_LONG).show();
                throw new NullPointerException("Ошибка в добавлении операнда");
            }
    }
    public void AddOperation(MathOperation operation)
    {
        mathOperation = operation;

        switch (operation)
        {
            case NOT:
                return;
            case ADD: case SUBTRACT: case MULTIPLY: case DIVISION: case POW:
                typeMathExpression = TypeMathExpression.WithTwoOperand;
                break;
            case SINGCHANGE: case LOG: case EXP: case FACTORIAL: case SIN: case COS: case TAN:
                typeMathExpression = TypeMathExpression.WithOneOperand;
                break;
        }
    }

}
