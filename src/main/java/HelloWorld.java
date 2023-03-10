import java.io.StringWriter;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

public class HelloWorld
{
    public static void main( String[] args )
            throws Exception
    {
        /*  first, get and initialize an engine  */
        VelocityEngine ve = new VelocityEngine();
        //set classpath loader to resources folder
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER,"classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());

        ve.init();
        /*  next, get the Template  */
        Template t = ve.getTemplate( "helloworld.vm" );
        /*  create a context and add data */
        VelocityContext context = new VelocityContext();
        context.put("name", "Razman");
        context.put("company", "XXXX");
        /* now render the template into a StringWriter */
        StringWriter writer = new StringWriter();
        t.merge( context, writer );
        /* show the World */
        System.out.println( writer.toString() );
    }
}