import org.apache.commons.lang.StringUtils

//String.metaClass.mixin StringUtils
/**
 *
 * @author will
 */
class LadderUtils {
    static String formatName(String name){
        return name?.toLowerCase()?.capitalize();
    }
	
}

