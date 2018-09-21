import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 三扇门问题
 */
public class ThreeDoors {
    public static void main(String[] args) {

        //不重新选择最终选对的次数
        int count1 = 0;
        //重新选择最终选对的次数
        int count2 = 0;
        Random random = new Random();

        //不重新选择的情况
        for (int i = 0; i < 10000; i++) {
            //供选择的3个选项
            List<Integer> selections = new ArrayList<>();
            selections.add(1);
            selections.add(2);
            selections.add(3);
            int selectionCount = selections.size();

            int select = selections.get(random.nextInt(selectionCount));
            int correct = selections.get(random.nextInt(selectionCount));

            if (select == correct) {
                count1++;
            }
        }

        //重新选择的情况
        for (int i = 0; i < 10000; i++) {
            //供选择的3个选项
            List<Integer> selections = new ArrayList<>();
            selections.add(1);
            selections.add(2);
            selections.add(3);
            int selectionCount = selections.size();

            int select = selections.get(random.nextInt(selectionCount));
            int correct = selections.get(random.nextInt(selectionCount));

            for (Integer del : selections) {
                if (del != correct && del != select) {
                    selections.remove(del);
                    break;
                }
            }
            for (int change : selections) {
                if (change != select) {
                    select = change;
                    break;
                }
            }
            if (select == correct) {
                count2++;
            }
        }

        System.out.println("分别进行10000次试验：");
        System.out.println("不重新选择的情况下选对的次数为：" + count1);
        System.out.println("重新选择的情况下选对的次数为：" + count2);
    }
}
