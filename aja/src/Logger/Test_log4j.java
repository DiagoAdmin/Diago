/*package Logger;
import org.apache.log4j.Logger;
import org.testng.Assert;
public class Test_log4j {
	static Logger log = Logger.getLogger(Test_log4j.class.getName());

	public static void main(String args[]) throws Exception
	{
		Logger logg=Logger.getLogger("devpinoyLogger");
		logg.debug("STARTING");
		logg.trace("Trace Message!");
	    logg.info("Info Message!");
	    logg.warn("Warn Message!");
	    logg.error("Error Message!");
	    logg.fatal("Fatal Message!");
	    Exception e1 = new Exception();
	    Exception e2 = new Exception(e1);
	    try{
	        Assert.assertEquals("ACR", "AC");
	        
	        }catch(Error e)
	        {
	        	logg.error("an exception was thrown", e);
	        	
	        }
	    catch(Exception e)
	    {
	    	logg.error("an exception was thrown", e2);
	    }
	}
	
}

*/