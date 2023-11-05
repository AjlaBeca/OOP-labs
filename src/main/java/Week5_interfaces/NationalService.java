package Week5_interfaces;
public interface NationalService{
    int getDaysLeft();
    void work();
}
class CivilService implements NationalService{
    private int daysLeft;
    public CivilService(){
        this.daysLeft=362;
    }

    @Override
    public int getDaysLeft() {
        return daysLeft;
    }

    @Override
    public void work() {
        if(daysLeft>0){
            daysLeft--;
        }
    }
}
class MilitaryService implements NationalService{
    private int daysLeft;
    public MilitaryService(int daysLeft){
        this.daysLeft=daysLeft;
    }

    @Override
    public int getDaysLeft() {
        return daysLeft;
    }

    @Override
    public void work() {
        if (daysLeft > 0) {
            daysLeft--;
        }
    }
}
class Main {
        public static void main(String[] args) {
            CivilService civilService = new CivilService();
            MilitaryService militaryService = new MilitaryService(180);

            System.out.println("Civil Service days left: " + civilService.getDaysLeft());
            System.out.println("Military Service days left: " + militaryService.getDaysLeft());

            civilService.work();
            militaryService.work();
            militaryService.work();
            militaryService.work();

            System.out.println("Civil Service days left:  " + civilService.getDaysLeft());
            System.out.println("Military Service days left : " + militaryService.getDaysLeft());
        }
    }
