package com.example.calc.MathExpression

import android.content.Context
import android.widget.Toast

enum class NumberSystem
{
    BIN, OCT, HEX
}

public class MathExpression_2_8_16(
        private val context: Context,
        public val numberSystem: NumberSystem
)
{
    enum class MathOperation { NOT, ADD, SUBTRACT, MULTIPLY, DIVISION, POW, SINGCHANGE, LOG, EXP, FACTORIAL, SIN, COS, TAN }
    enum class MathOperandSet { OperandNotSet, OneOperandSet, TwoOperandSet }
    enum class TypeMathExpression { NOTSET, WithOneOperand, WithTwoOperand }


    val LongToString = fun(numberSystem: NumberSystem, number: Long): String
    {
        when(numberSystem)
        {
            NumberSystem.BIN -> return java.lang.Long.toBinaryString(number)
            NumberSystem.OCT -> return java.lang.Long.toOctalString(number)
            NumberSystem.HEX -> return java.lang.Long.toHexString(number)
        }
    }


    //private val LongToString: fun(): Unit = Unit
    private var operand1: Long = 0
    private var operand2: Long = 0
    private var answer: Long = 0
    private lateinit var str_MathExpression: String
    private var m_isSetAnswer: Boolean = false
    public var mathOperation: MathOperation = MathOperation.NOT
    public var mathOperandSet: MathOperandSet = MathOperandSet.OperandNotSet
    public var typeMathExpression: TypeMathExpression = TypeMathExpression.NOTSET

    val Operand1: Long
        get() = operand1
    val Operand2: Long
        get() = operand2
    val Answer: Long
        get() = answer

    override fun toString(): String { return str_MathExpression }

    fun IsSetMathOperation(): Boolean { return mathOperation != MathOperation.NOT; }

    fun IsSetMathExpression(): Boolean
    {
        val isSetMathOperation = IsSetMathOperation()
        if (!isSetMathOperation)
            return false

        if (typeMathExpression == TypeMathExpression.WithOneOperand && mathOperandSet == MathOperandSet.OneOperandSet)
            return true

        if (typeMathExpression == TypeMathExpression.WithTwoOperand && mathOperandSet == MathOperandSet.TwoOperandSet)
            return true
        return false
    }

    fun NeedAddOperand(): Boolean { return mathOperandSet == MathOperandSet.OperandNotSet
    }

    fun GetAnswer(): Long
    {
        if (!IsSetMathExpression())
        {
            Toast.makeText(context, "Математическое выражение задано не правильно", Toast.LENGTH_LONG).show()
            throw NullPointerException("Математическое выражение задано не правильно")
        }

        when (mathOperation) {
            MathOperation.ADD -> {
                answer = operand1 + operand2
                str_MathExpression = LongToString(numberSystem, operand1) + "+" + LongToString(numberSystem, operand2) + "=" + LongToString(numberSystem, answer)
            }
            MathOperation.SUBTRACT -> {
                answer = operand1 - operand2
                str_MathExpression = LongToString(numberSystem, operand1) + "-" + LongToString(numberSystem, operand2) + "=" + LongToString(numberSystem, answer)
            }
            MathOperation.MULTIPLY -> {
                answer = operand1 * operand2
                str_MathExpression = LongToString(numberSystem, operand1) + "*" + LongToString(numberSystem, operand2) + "=" + LongToString(numberSystem, answer)
            }
            MathOperation.DIVISION -> {
                answer = operand1 / operand2
                str_MathExpression = LongToString(numberSystem, operand1) + "/" + LongToString(numberSystem, operand2) + "=" + LongToString(numberSystem, answer)
            }
            MathOperation.POW -> {
                answer = Math.round(Math.pow(operand1.toDouble(), operand2.toDouble()))
                str_MathExpression = LongToString(numberSystem, operand1) + "^" + "(" + LongToString(numberSystem, operand2) + ")=" + LongToString(numberSystem, answer)
            }
            MathOperation.SINGCHANGE -> {
                answer = -1 * operand1
                str_MathExpression = LongToString(numberSystem, answer)
            }
            MathOperation.LOG -> {
                answer = Math.round(Math.log10(operand1.toDouble()))
                str_MathExpression = "Log(" + LongToString(numberSystem, operand1) + ")=" + LongToString(numberSystem, answer)
            }
            MathOperation.EXP -> {
                answer = Math.round(Math.exp(operand1.toDouble()))
                str_MathExpression = "exp(" + LongToString(numberSystem, operand1) + ")=" + LongToString(numberSystem, answer)
            }
            MathOperation.FACTORIAL -> {
                answer = GetFactorial(operand1)
                str_MathExpression = LongToString(numberSystem, operand1) + "!=" + LongToString(numberSystem, answer)
            }
            MathOperation.SIN -> {
                answer = Math.round(Math.sin(operand1.toDouble()))
                str_MathExpression = "sin(" + LongToString(numberSystem, operand1) + ")=" + LongToString(numberSystem, answer)
            }
            MathOperation.COS -> {
                answer = Math.round(Math.cos(operand1.toDouble()))
                str_MathExpression = "cos(" + LongToString(numberSystem, operand1) + ")=" + LongToString(numberSystem, answer)
            }
            MathOperation.TAN -> {
                answer = Math.round(Math.tan(operand1.toDouble()))
                str_MathExpression = "tan(" + LongToString(numberSystem, operand1) + ")=" + LongToString(numberSystem, answer)
            }
        }
        m_isSetAnswer = true
        return answer
    }

    private fun GetFactorial(a: Long): Long
    {
        var a = a
        var result: Long
        result = 1
        while (a > 1) {
            result *= a--
        }
        return result
    }

    fun AddOperand(operand: Long)
    {
        if (mathOperandSet == MathOperandSet.OperandNotSet)
        {
            operand1 = operand
            mathOperandSet = MathOperandSet.OneOperandSet
        }
        else
            if (mathOperandSet == MathOperandSet.OneOperandSet && typeMathExpression == TypeMathExpression.WithTwoOperand)
        {
            operand2 = operand
            mathOperandSet = MathOperandSet.TwoOperandSet
        }
        else
            if (mathOperandSet == MathOperandSet.OneOperandSet && typeMathExpression == TypeMathExpression.WithOneOperand) //на тот случай, когда выбрали операцию с 2мя операндами, а затем передумали и выбрали операцию с одним операндом
        {
            return
        }
        else
        {
            Toast.makeText(context, "Ошибка в добавлении операнда", Toast.LENGTH_LONG).show()
            throw NullPointerException("Ошибка в добавлении операнда")
        }
    }

    fun AddOperation(operation: MathOperation)
    {
        mathOperation = operation

        when (operation) {
            MathOperation.NOT -> return
            MathOperation.ADD, MathOperation.SUBTRACT, MathOperation.MULTIPLY, MathOperation.DIVISION, MathOperation.POW -> typeMathExpression = TypeMathExpression.WithTwoOperand
            MathOperation.SINGCHANGE, MathOperation.LOG, MathOperation.EXP, MathOperation.FACTORIAL, MathOperation.SIN, MathOperation.COS, MathOperation.TAN -> typeMathExpression = TypeMathExpression.WithOneOperand
        }
    }

}
