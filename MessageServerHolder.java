
/**
* MessageServerHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from MessageServer.idl
* Tuesday, September 8, 2015 2:56:05 PM CDT
*/

public final class MessageServerHolder implements org.omg.CORBA.portable.Streamable
{
  public MessageServer value = null;

  public MessageServerHolder ()
  {
  }

  public MessageServerHolder (MessageServer initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = MessageServerHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    MessageServerHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return MessageServerHelper.type ();
  }

}