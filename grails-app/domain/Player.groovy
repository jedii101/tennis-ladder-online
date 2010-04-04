

class Player {
    	
    static hasMany = [authorities: Authority]
    static belongsTo = Authority

    String firstName
    String lastName
    String userName
    String email
    String phone
    String password
    /** enabled */
    boolean enabled=true
    boolean emailShow=true

    /** description */
    String description = ''

    /** plain password to create a MD5 password */
    String pass = '[secret]'

    static transients = [ 'name','pass' ]
    //	static hasMany = [levels:Level]
    static constraints = {
        firstName blank:false
        lastName blank:false
        userName(blank:false,unique:true)
                
        email blank:true, matches:/\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*([,;]\s*\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*)*/
        phone matches:/\d{10}/
                
        enabled()
        emailShow()
        description blank:true
        password(blank:false, validator: {//@@NOTE:validator can not rename
                val, obj ->
                obj.properties['pass'] == val
            }
        )
    }
    public String getName(){//@@Note:String.metaClass.mixin StringUtils
        return LadderUtils.formatName(firstName)+"."+LadderUtils.formatName(lastName)

    }
    public String toString(){
        return getName()

    }

    public  String getUserName(){
        return firstName?.toLowerCase()+"_"+lastName?.toLowerCase()
    }
}
