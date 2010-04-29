package ladder

class LadderService {
    def createLadder(String _name,int...numberOfPositionsForEachLevel) {
        Ladder ladder=new Ladder(name:_name)
        int currentLevel=0

        numberOfPositionsForEachLevel.each(){
             Level l=new Level(level:currentLevel++,ladder:ladder)
            for(_pos in 1..it){
                LevelPosition lp=new LevelPosition(pos:_pos,ladder:ladder,level:l)
                l.addToLevelposition(lp)
            }
            ladder.addToLevels(l)
        }
        return ladder

    }
    
    def fillLadder(Ladder ladder, Team...team){
    	    
    }
}