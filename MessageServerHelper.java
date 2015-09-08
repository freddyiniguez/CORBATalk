
/**
* MessageServerHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from MessageServer.idl
* Tuesday, September 8, 2015 2:56:05 PM CDT
*/

abstract public class MessageServerHelper
{
  private static String  _id = "IDL:MessageServer:1.0";

  public static void insert (org.omg.CORBA.Any a, MessageServer that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static MessageServer extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (MessageServerHelper.id (), "MessageServer");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static MessageServer read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_MessageServerStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, MessageServer value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static MessageServer narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof MessageServer)
      return (MessageServer)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      _MessageServerStub stub = new _MessageServerStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static MessageServer unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof MessageServer)
      return (MessageServer)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      _MessageServerStub stub = new _MessageServerStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}