class Player {
	String firstName
	String lastName
        String userName
	String email
	String phone
        String password
        String confirmPassword

	static transients = [ 'name','confirmPassword' ]
//	static hasMany = [levels:Level]
	static constraints = {
		firstName blank:false
		lastName blank:false
                userName(blank:false,unique:true)
                password(blank:false)	
                email blank:true, matches:/\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*([,;]\s*\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*)*/
		phone matches:/\d{10}/
	}
        public String getName(){
            return firstName+"."+lastName

        }
         public String toString(){
            return getName()

        }
}
