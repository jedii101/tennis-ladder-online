import org.apache.commons.lang.StringUtils


class BootStrap {

     def init = { servletContext ->
         String.metaClass.mixin StringUtils
     }
     def destroy = {
     }
} 