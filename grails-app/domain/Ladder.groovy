class Ladder {
    String name
    static hasMany = [levels:Level]
    static constraints = {
    }

    public String toString(){
        return name
    }
}
