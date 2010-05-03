package ladder
class Message  implements EntityBase{
    String message
    Date created=new Date()
    Player createBy
    boolean isSystem=false;

    Team from
    Team to

    Message parent
    String type

    static belongsTo = [ schedule:MatchSchedule ]

    static constraints = {
        parent(nullable:true)
	from(nullable:true)
        to(nullable:true)
        schedule(nullable:true)
        type(inList:["CHALLENGE", "ACCEPT","RESULT","SYSTEM","SYSTEM_TOP"] )
    }
    static mapping = {
	sort created:"desc"
	}
    public String format(){
        return "on ${created} From ${createBy}:${message}"
    }
}
