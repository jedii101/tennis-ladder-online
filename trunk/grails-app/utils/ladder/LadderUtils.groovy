package ladder
import org.apache.commons.lang.StringUtils

//String.metaClass.mixin StringUtils
/**
 *
 * @author will
 */
class LadderUtils {
	static void init(){
//	String.metaClass.mixin StringUtils	
	}
    static String formatName(String name){
        return (null==name)?"":StringUtils.capitalize(name.toLowerCase());
    }
    
    static String dumpme(Object o){
       	   StringBuffer sb=new StringBuffer()
   	   o.properties.each{
   	   	   sb.append(it)
   	   	   sb.append("\n")
   	   	   //sb.append("${it.name}:${it.value}")
   	   }
   	   return sb.toString()	    
    }
	
}

