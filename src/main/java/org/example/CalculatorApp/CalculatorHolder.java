package CalculatorApp;

/**
* CalculatorApp/CalculatorHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Calculator.idl
* lunes 13 de marzo de 2023 15H51' CST
*/

public final class CalculatorHolder implements org.omg.CORBA.portable.Streamable
{
  public CalculatorApp.Calculator value = null;

  public CalculatorHolder ()
  {
  }

  public CalculatorHolder (CalculatorApp.Calculator initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = CalculatorApp.CalculatorHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    CalculatorApp.CalculatorHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return CalculatorApp.CalculatorHelper.type ();
  }

}
