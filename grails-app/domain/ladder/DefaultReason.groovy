package ladder
class DefaultReason  implements EntityBase{
    String code
    String comments

    static constraints = {
    }

    public String toString(){
        return code
    }
}
