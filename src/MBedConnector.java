
import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;

import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MBedConnector
{

	public static final String port = "COM3";
	SerialWriter output;
	boolean isConnected = false;
	
    void connect ( String portName) throws Exception
    {
        CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
        if ( portIdentifier.isCurrentlyOwned() )
        {
            System.out.println("Error: Port is currently in use");
        }
        else
        {
            CommPort commPort = portIdentifier.open(this.getClass().getName(),2000);
            
            if ( commPort instanceof SerialPort )
            {
                SerialPort serialPort = (SerialPort) commPort;
                serialPort.setSerialPortParams(9600,SerialPort.DATABITS_8,SerialPort.STOPBITS_1,SerialPort.PARITY_NONE);
                isConnected = true;
                InputStream in = serialPort.getInputStream();
				OutputStream out = serialPort.getOutputStream();
                output = new SerialWriter(out);
                (new Thread(new SerialReader(in))).start();
                (new Thread(output)).start();
            }
            else
            {
                System.out.println("Error: Only serial ports are handled by this example.");
            }
        }     
    }
	
	void write(String s) {
		try {
			if (!isConnected)	connect(port);
			output.writeString(s);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
    
    /** */
    public static class SerialReader implements Runnable 
    {
        InputStream in;
        
        public SerialReader ( InputStream in )
        {
            this.in = in;
        }
        
        public void run ()
        {
            byte[] buffer = new byte[1024];
            int len = -1;
            try
            {
                while ( ( len = this.in.read(buffer)) > -1 )
                {
                    System.out.print(new String(buffer,0,len));
                }
            }
            catch ( IOException e )
            {
                e.printStackTrace();
            }            
        }
    }

    /** */
    public static class SerialWriter implements Runnable 
    {
        OutputStream out;
        
        public SerialWriter ( OutputStream out )
        {
            this.out = out;
        }
        
        public void run ()
        {
         
        }
		
		public void writeString(String s)
		{
			try
            {                
            	for (int i = 0; i < s.length(); i++)
				{
					this.out.write(s.charAt(i));
				}
				this.out.write('\n');
			}
            catch ( IOException e )
            {
                e.printStackTrace();
            }
		}
    }
	
	public static void test()
	{
        try
        {
			MBedConnector communicator = new MBedConnector();
			communicator.write("5");
			System.out.println("Wrote it.");
        }
        catch ( Exception e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}