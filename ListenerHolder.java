
/**
* ListenerHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from MessageServer.idl
* Tuesday, September 8, 2015 2:56:05 PM CDT
*/

public final class ListenerHolder implements org.omg.CORBA.portable.Streamable
{
  public Listener value = null;

  public ListenerHolder ()
  {
  }

  public ListenerHolder (Listener initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = ListenerHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    ListenerHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return ListenerHelper.type ();
  }

}