package ladder
class DefaultReason  extends EntityBase{
    String code
    String comments

    static constraints = {
    }

    public String toString(){
        return code
    }
}
