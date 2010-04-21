class Message {
    String message
    Date created
    Player createBy
    boolean isSystem=false;

    Team from
    Team to

    Message parent
    String type

    static belongsTo = [ schedule:MatchSchedule ]

    static constraints = {
        parent(nullable:true)
        to(nullable:true)
        schedule(nullable:true)
        type(inList:["CHALLENGE", "ACCEPT"] )
    }
    static mapping = {
	sort created:"desc"
	}
    public String format(){
        return "on ${created} From ${createBy}:${message}"
    }
}
