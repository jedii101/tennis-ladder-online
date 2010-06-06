package ladder
/*
* Will Han: this class will be used as a cascade domain class saver to be used with mockDomain
*/
class CascadeDomainSaver{
    List savedRegistry=new Vector();//a registry remember what I saved
    boolean saveCascade(Object e){
	if(e instanceof EntityBase && (!savedRegistry.contains(e))){
		println("saved:${e}")
            e.save()
            savedRegistry.add(e)
            e.properties.each { prop, val ->
		if(val==null||prop==null||prop==~/metaClass|class/) return
  
		//println("saveCascade:${val},class:${val.class}")
		if(val instanceof Collection){
                   // println("collection found")
                    val.each{val1->
                        saveCascade(val1)//recursively save object
                    }
		}else{
                    saveCascade(val)//recursively save object
                }
            }
        }
        return true
    }
}
