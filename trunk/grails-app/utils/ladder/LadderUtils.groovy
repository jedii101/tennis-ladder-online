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
    static List dumpStarted=new Vector();
    static List dumpEnded=new Vector();
    static String dumpme(Object o){
	    if(o==null){
		    return "null"
	    }
    	    String me=null
    	    if(!dumpStarted.contains(o)){
    	    	    dumpStarted.add(o)
    	     me= o.dump()
    	    dumpEnded.add(o)
    	    }else{
    	    	return "referenced"	    
    	    }
    	    if(dumpStarted.size()==dumpEnded.size()){
    	    	    //log.info("loop finished")
    	    	    dumpStarted.clear()
    	    	    dumpEnded.clear()
    	    	    me.replaceAll("<","\\\\n<")
    	    }
    	    return me
    	    /*
    	    dumpStarted.add(o)
       	   StringBuffer sb=new StringBuffer()

       	   sb.append("<")
   	   o.properties.each{

   	   	   try{
   	   	   	   if(!dumpStarted.contains(it)){
   	   	   sb.append(it)
   	   	   sb.append("\n")
   	   	   //sb.append("${it.name}:${it.value}")
   	   	   	   }
   	   	   }catch(Exception e){
   	   	   	e.printStackTrace()	   
   	   	   }
   	   }   
   	   sb.append(">\n")
   	   dumpEnded.add(o)
   	   return sb.toString()	    
 */
    }
    

}

