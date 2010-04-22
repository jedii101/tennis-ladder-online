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
	
}

