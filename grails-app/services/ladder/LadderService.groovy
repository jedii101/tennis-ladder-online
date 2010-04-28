package ladder

class LadderService {
    def createLadder(String _name,int...numberOfPositionsForEachLevel) {
        Ladder ladder=new Ladder(name:_name)
        int currentLevel=0

        numberOfPositionsForEachLevel.each(){
             Level l=new Level(level:currentLevel++)
            for(_pos in 1..it){
                LevelPosition lp=new LevelPosition(pos:_pos,ladder:ladder)
                l.addToLevelposition(lp)
            }
            ladder.addToLevels(l)
        }
        return ladder
//        for(_level in 0..numberOfPositionsForEachLevel.size){
//            Level l=new Level(_level);
//
//            currentLevel++
//        }
    }
}