package com.example.calc.CalcHistory

import android.widget.TextView
import com.example.calc.MathExpression.MathExpression_2_8_16
import com.example.calc.MathExpression.NumberSystem
import java.util.ArrayList

class CalcHistory2_8_16(
        public val numberSystem: NumberSystem
)
{
    var mathExpressions: ArrayList<MathExpression_2_8_16> = ArrayList<MathExpression_2_8_16>()
    private var numberOfHistory: Int = -1

    val LongToString = fun(numberSystem: NumberSystem, number: Long): String
    {
        when(numberSystem)
        {
            NumberSystem.BIN -> return java.lang.Long.toBinaryString(number)
            NumberSystem.OCT -> return java.lang.Long.toOctalString(number)
            NumberSystem.HEX -> return java.lang.Long.toHexString(number)
        }
    }

    fun AddMathExpression(mathExpression: MathExpression_2_8_16, historyDisplay: TextView)
    {
        Delete_lastHistorys()
        mathExpressions.add(mathExpression)
        historyDisplay.append("\n" + mathExpression.toString())
        numberOfHistory++
    }

    fun GetLastAnswer(): Long { return mathExpressions[numberOfHistory].GetAnswer() }

    private fun Delete_lastHistorys()
    {
        for (i in mathExpressions.size - 1 downTo numberOfHistory + 1) {
            mathExpressions.removeAt(i)
        }
    }

    fun BackwardHistory(historyDisplay: TextView, dialogDisplay: TextView)
    {
        if (numberOfHistory < 0) return
        numberOfHistory--
        historyDisplay.text = ""
        dialogDisplay.text = ""
        for (i in 0..numberOfHistory)
            historyDisplay.append("\n" + mathExpressions[i].toString())
        if (numberOfHistory < 0) return
        dialogDisplay.text = LongToString(numberSystem, mathExpressions[numberOfHistory].GetAnswer())

    }

    fun ForwardHistory(historyDisplay: TextView, dialogDisplay: TextView)
    {
        if (numberOfHistory + 1 >= mathExpressions.size) return
        numberOfHistory++
        historyDisplay.text = ""
        dialogDisplay.text = ""
        for (i in 0..numberOfHistory)
            historyDisplay.append("\n" + mathExpressions[i].toString())
        if (numberOfHistory < 0) return
        dialogDisplay.text = LongToString(numberSystem, mathExpressions[numberOfHistory].GetAnswer())
    }

    fun IsEmply(): Boolean { return numberOfHistory == -1 }
}