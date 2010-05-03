import org.apache.commons.lang.StringUtils
import ladder.*


class BootStrap {
	BootStrap(){
		LadderUtils.init()

	}
     def init = { servletContext ->
         /** create ladders
         def ls=new LadderService()
         Ladder mixLadder=ls.createLadder("mix doubles",1,2,3,4,10)
         mixLadder.save()
         Ladder singleLadder=ls.createLadder("singles",1,2,3,4,5,6,10)
         singleLadder.save()
         **/
     }
     def destroy = {
     }
} 