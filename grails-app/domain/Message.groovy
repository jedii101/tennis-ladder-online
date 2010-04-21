class Message {
    String message
    Date created
    Player createBy
    boolean isSystem=false;

    Team from
    Team to
    MatchSchedule schedule
    Message parent
    
    static constraints = {
        parent(nullable:true)
        to(nullable:true)
        schedule(nullable:true)
    }

    public String format(){
        return "on ${created} From ${createBy}:${message}"
    }
}
