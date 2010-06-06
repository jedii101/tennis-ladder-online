package ladder


class LadderJob {
     static triggers = {
    cron name: 'myTrigger', cronExpression: "0 25 2 * * ?"
  }
 def group = "MyGroup"
    //def timeout = 5000l // execute job once in 5 seconds
    //def startDelay=60000
    def ls=new LadderService()

    def execute() {
        ls.refreshStatus();
    }
}
