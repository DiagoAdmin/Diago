package Assert_AJA;
import org.testng.Assert;
public class Verify_Test
{
	public void verifyTest(String s1,String s2)
	{
		/* buffer to hold your errors */
		StringBuffer errorBuffer = new StringBuffer();
		/* verification 1 */
		try
		{
			Assert.assertEquals(s1, s2);
			}
		catch(AssertionError e)
		{
			errorBuffer.append(e.getMessage() + "\n");
			}
		/* verification 2 */
		/*try
		 {
		 Assert.assertEquals("value2", "value!");
		 }
		 catch(AssertionError e)
		 {
		 errorBuffer.append(e.getMessage());
		 }*/
		if(errorBuffer.length() > 0)
		{
			throw new AssertionError(errorBuffer.toString());
			}
		}
	}