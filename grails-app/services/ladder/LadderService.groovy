package ladder

class LadderService {
    def createLadder(String _name,int...numberOfPositionsForEachLevel) {
        Ladder ladder=new Ladder(name:_name)
        int currentLevel=0
        for(_level in 0..numberOfPositionsForEachLevel.size){

            currentLevel++
        }
    }
}