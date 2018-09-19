package com.example.calc.OctNumberSystem;

import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Артём on 23.08.2018.
 */

public class CalcHistory8
{
    public ArrayList<MathExpression8> mathExpressions;
    private int numberOfHistory;

    public CalcHistory8()
    {
        mathExpressions = new ArrayList<MathExpression8>();
        numberOfHistory = -1;
    }

    public void AddMathExpression(MathExpression8 mathExpression, TextView historyDisplay)
    {
        Delete_lastHistorys();
        mathExpressions.add(mathExpression);
        historyDisplay.append("\n"+mathExpression.toString());
        numberOfHistory++;
    }

    public long GetLastAnswer()
    {
        return mathExpressions.get(numberOfHistory).answer;
    }

    private void Delete_lastHistorys()
    {
        for (int i = mathExpressions.size()-1; i > numberOfHistory; i--)
        {
            mathExpressions.remove(i);
        }
    }

    public void BackwardHistory(TextView historyDisplay, TextView dialogDisplay)
    {
        if (numberOfHistory < 0) return;
        numberOfHistory--;
        historyDisplay.setText("");
        dialogDisplay.setText("");
        for (int i = 0; i <= numberOfHistory; i++)
            historyDisplay.append("\n"+mathExpressions.get(i).toString());
        if (numberOfHistory < 0) return;
        dialogDisplay.setText(Long.toOctalString(mathExpressions.get(numberOfHistory).answer));

    }

    public void ForwardHistory(TextView historyDisplay, TextView dialogDisplay)
    {
        if (numberOfHistory + 1 >= mathExpressions.size()) return;
        numberOfHistory++;
        historyDisplay.setText("");
        dialogDisplay.setText("");
        for (int i = 0; i <= numberOfHistory; i++)
            historyDisplay.append("\n"+mathExpressions.get(i).toString());
        if (numberOfHistory < 0) return;
        dialogDisplay.setText(Long.toOctalString(mathExpressions.get(numberOfHistory).answer));
    }

    public boolean IsEmply(){ return numberOfHistory==-1;}
}




