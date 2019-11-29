package linklist;

public class MergeTwoSortSingleLinkList {

    public static SingleLinkList<Integer> merge(SingleLinkList<Integer> list1, SingleLinkList<Integer> list2) {
        SingleLinkList<Integer> result = new SingleLinkList();
        while (list1.getSize() > 0 && list2.getSize() > 0) {
            int i = 1;
            if (list1.get(i).compareTo(list2.get(i)) > 0) {
                result.addLast(list2.get(i));
                list2.remove(i);
            } else {
                result.addLast(list1.get(i));
                list1.remove(i);
            }
        }
        if (list1.getSize() > 0) {
            for (int i = 1; i <= list1.getSize(); i++) {
                result.addLast(list1.get(i));
            }
        } else {
            for (int i = 1; i <= list2.getSize(); i++) {
                result.addLast(list2.get(i));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SingleLinkList<Integer> list1 = new SingleLinkList<>();
        SingleLinkList<Integer> list2 = new SingleLinkList<>();
        for (int i= 1;i<10;i=i+2){
            list1.addLast(i);
        }
        list1.display();

        for (int i= 1;i<20;i=i+5){
            list2.addLast(i);
        }
        list2.display();
        SingleLinkList<Integer> merge = merge(list1, list2);
        merge.display();
    }
}
