public class Main {
    public static void main(String[] args) {
        BaseCreditManager[] baseCreditManagers = new BaseCreditManager[]
                {new TeacherCreditManager(),new AgricultureCreditManager(),new StudentCreditManager()};

        for (BaseCreditManager credit : baseCreditManagers)
        {
            System.out.println(credit.calculate(1000));
        }
    }
}