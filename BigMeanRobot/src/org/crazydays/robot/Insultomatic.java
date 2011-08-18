package org.crazydays.robot;


import java.lang.reflect.Field;
import java.text.MessageFormat;

import android.content.Context;

/**
 * Insultomatic
 */
public class Insultomatic
{
    /** context */
    protected Context context;

    /**
     * Insultomatic constructor.
     * 
     * @param context Context
     */
    public Insultomatic(Context context)
    {
        this.context = context;
    }

    /**
     * Get insult.
     * 
     * @return Insult
     */
    public String getInsult()
    {
        try {
            return context.getString(getRId());
        } catch (Exception e) {
            return context.getString(R.string.insult_00000000);
        }
    }

    private int getRId()
        throws IllegalArgumentException, IllegalAccessException,
        SecurityException, NoSuchFieldException
    {
        Field field =
            R.string.class.getField(MessageFormat.format(
                "insult_{0,number,00000000}", getInsultId()));
        return field.getInt(null);
    }

    private int getInsultId()
    {
        return (int) (Math.random() * getInsultCount());
    }

    private int getInsultCount()
    {
        return Integer.parseInt(context.getString(R.string.insult_count));
    }
}
