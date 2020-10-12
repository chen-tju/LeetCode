package leetcode.editor.cn;

public class InstanceCounter {
    //private static int numInstances = 0;
    private static int numInstances = 0;
    protected static int getCount() {
        return numInstances;
    }

    private static void addInstance() {
        numInstances++;
    }

    InstanceCounter() {
        InstanceCounter.addInstance();
    }

    public static void main(String[] arguments) {
        System.out.println("Starting with " +
                InstanceCounter.getCount() + " instances");
        for (int i = 0; i < 500; ++i){
            new InstanceCounter(); //执行这句语句，就会调用add语句，这里要求add必须为static类型
        }
        System.out.println("Created " +
                InstanceCounter.getCount() + " instances");
    }
}