import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;
import java.util.Scanner;

public class Daysmatter
{
   public static void daojishiMode (String date, Scanner sc)
   {
      String [] targetDate = date.split("/");
      int year = Integer.parseInt(targetDate[0]);
      int month = Integer.parseInt(targetDate[1]);
      int day = Integer.parseInt(targetDate[2]);
      LocalDate currentDate = LocalDate.now();
      LocalDate futureDate = LocalDate.of(year,month,day);
      Period period = Period.between(currentDate, futureDate);

      System.out.print("倒计时原因： ");
      String reason = sc.nextLine().trim();
      System.out.printf("距离" + reason + "还有 %d 年 %d 月 %d 日",period.getYears(),period.getMonths(),period.getDays());

   }


   public static void dateCalculator (String firstDate, String secondDate)
   {
      String [] firstTarget = firstDate.split("/");
      String [] secondTarget = secondDate.split("/");
      int firstYear = Integer.parseInt(firstTarget[0]);
      int firstMonth = Integer.parseInt(firstTarget[1]);
      int firstDay = Integer.parseInt(firstTarget[2]);
      int secondYear = Integer.parseInt(secondTarget[0]);
      int secondMonth = Integer.parseInt(secondTarget[1]);
      int secondDay = Integer.parseInt(secondTarget[2]);
      LocalDate firstTargetDate = LocalDate.of(firstYear,firstMonth,firstDay);
      LocalDate secondTargetDate = LocalDate.of(secondYear,secondMonth,secondDay);
      Period p = Period.between(firstTargetDate, secondTargetDate);
      if (firstTargetDate.isBefore(secondTargetDate))
      {
         System.out.printf("还有 %d 年 %d 月 %d 日",p.getYears(),p.getMonths(),p.getDays());
      }
      else if (firstTargetDate.isAfter(secondTargetDate))
      {
         System.out.printf("已经过去 %d 年 %d 月 %d 日",Math.abs(p.getYears()),Math.abs(p.getMonths()),Math.abs(p.getDays()));
      }

   }
//回国计时专用
   public static void studyAbroad (String date, Scanner sc)
   {
      String [] targetDate = date.split("/");
      int year = Integer.parseInt(targetDate[0]);
      int month = Integer.parseInt(targetDate[1]);
      int day = Integer.parseInt(targetDate[2]);
      LocalDate currentDate = LocalDate.now();
      LocalDate futureDate = LocalDate.of(year,month,day);
      Period period = Period.between(currentDate, futureDate);

      System.out.printf("%d 年 %d 月 %d 日",period.getYears(),period.getMonths(),period.getDays());
   }

   public static void main(String[] args)
   {
      Scanner sc = new Scanner(System.in);
      System.out.println("倒计时模式 / 时间差模式");
      System.out.print("模式选择：");
      String mode = sc.nextLine();
      if (Objects.equals(mode, "倒计时模式"))
      {
         System.out.print("请输入具体日期：");
         String date  = sc.nextLine().trim();
         daojishiMode(date,sc);
      }
      else if (Objects.equals(mode,"时间差模式"))
      {
         System.out.print("请输入第一个目标日期： ");
         String firstDate = sc.nextLine().trim();
         System.out.print("请输入第二个目标日期： ");
         String secondDate = sc.nextLine().trim();
         while (firstDate.equals(secondDate))
         {
            System.out.println("");
            System.out.println("起始日期和最终日期相同，请重新检查您的输入！");
            System.out.println("");
            try {
               Thread.sleep(3000);
            }
            catch (InterruptedException e)
            {
               throw new RuntimeException(e);
            }
            System.out.print("请输入第一个目标日期： ");
            firstDate = sc.nextLine().trim();
            System.out.print("请输入第二个目标日期： ");
            secondDate = sc.nextLine().trim();
            if(!firstDate.equals(secondDate))
            {
               break;
            }
         }
         dateCalculator(firstDate,secondDate);
      }
      else if (Objects.equals(mode,"留学") || Objects.equals(mode,"回家")|| Objects.equals(mode,"回国"))
      {
         System.out.print("请输入具体日期：");
         String date  = sc.nextLine().trim();
         System.out.print("还有 ");
         studyAbroad(date,sc);
         System.out.print("就回国了！！！坚持！！！");
      }
      else
      {
         System.exit(0);
      }
      System.out.println("");
      System.out.println("作者：孙杰一");
   }

}
