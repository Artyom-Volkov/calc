package com.example.calc.OctNumberSystem;


import android.content.Context;
import android.widget.Toast;

/**
 * Created by Артём on 24.08.2018.
 */


public class MathExpression8
{
    enum MathOperation{NOT ,ADD, SUBTRACT, MULTIPLY, DIVISION, POW, SINGCHANGE, LOG, EXP, FACTORIAL, SIN, COS, TAN}
    enum MathOperandSet{OperandNotSet, OneOperandSet, TwoOperandSet}
    enum TypeMathExpression{NOTSET, WithOneOperand, WithTwoOperand}

    public long operand1, operand2, answer;

    private String str_MathExpression;
    public MathOperation mathOperation;
    public MathOperandSet mathOperandSet;
    public TypeMathExpression typeMathExpression;
    private boolean m_isSetAnswer;
    private Context m_context;

    public MathExpression8(Context context)
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

    public long GetAnswer()
    {
        if (!IsSetMathExpression())
        {
            Toast.makeText(m_context, "Математическое выражение задано не правильно", Toast.LENGTH_LONG).show();
            throw new NullPointerException("Математическое выражение задано не правильно");
        }

        switch (mathOperation)
        {
            case ADD: answer = operand1+operand2; str_MathExpression = Long.toOctalString(operand1) + "+" + Long.toOctalString(operand2)+"="+ Long.toOctalString(answer);break;
            case SUBTRACT: answer = operand1-operand2; str_MathExpression = Long.toOctalString(operand1) + "-" + Long.toOctalString(operand2)+"="+ Long.toOctalString(answer);break;
            case MULTIPLY: answer = operand1*operand2; str_MathExpression = Long.toOctalString(operand1) + "*" + Long.toOctalString(operand2)+"="+ Long.toOctalString(answer);break;
            case DIVISION: answer = operand1/operand2; str_MathExpression = Long.toOctalString(operand1) + "/" + Long.toOctalString(operand2)+"="+ Long.toOctalString(answer);break;
            case POW: answer = Math.round ( Math.pow(operand1, operand2)); str_MathExpression = Long.toOctalString(operand1) + "^" +"(" +Long.toOctalString(operand2)+")="+ Long.toOctalString(answer);break;
            case SINGCHANGE: answer = (-1) * operand1; str_MathExpression = Long.toOctalString(answer);break;
            case LOG: answer = Math.round ( Math.log10(operand1)); str_MathExpression = "Log(" + Long.toOctalString(operand1) + ")=" + Long.toOctalString(answer);break;
            case EXP: answer = Math.round ( Math.exp(operand1)); str_MathExpression = "exp(" + Long.toOctalString(operand1) + ")=" + Long.toOctalString(answer);break;
            case FACTORIAL: answer = GetFactorial(operand1); str_MathExpression = Long.toOctalString(operand1) + "!=" + Long.toOctalString(answer); break;
            case SIN: answer = Math.round ( Math.sin(operand1)); str_MathExpression = "sin(" + Long.toOctalString(operand1) + ")=" + Long.toOctalString(answer); break;
            case COS: answer = Math.round ( Math.cos(operand1)); str_MathExpression = "cos(" + Long.toOctalString(operand1) + ")=" + Long.toOctalString(answer);break;
            case TAN: answer = Math.round ( Math.tan(operand1)); str_MathExpression = "tan(" + Long.toOctalString(operand1) + ")=" + Long.toOctalString(answer);break;
        }
        m_isSetAnswer = true;
        return answer;
    }

    public boolean IsSetAnswer(){ return m_isSetAnswer;}

    private long GetFactorial(long a)
    {
        long result;
        for (result = 1; a > 1; result *= (a--));
        return result;
    }

    public void AddOperand(long operand)
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
