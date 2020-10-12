//昨天做周赛，被动态数组的可变长度上了一课，刚好今天有群里老哥发了个代码。
//发现源码还是很有意思的，老哥的注释也比较有意思


package leetcode.editor.cn;
public class Array{ //  implements IArray<E>

    /**
     *  Array:
     *
     *      Analyze: 通用功能 ---> 增删改查
     *               拓展功能 ---> 动态扩容，队列，栈的实现
     *
     *      有很多
     */
    // 当前数组实存元素个数
    private int size;

    // 当前数组的大小
    private int capacity;

    private int[] array;

    // 无参构造器, 默认大小初始化为10
    public Array() {

        this(10);
    }

    // 有参构造器
    public Array(int capacity) {

        size = 0;
        this.capacity = capacity;
        array = new int[capacity];
    }



    // @Override
    public void add(int e) {

        /**
         * 拓展: 平时我们用JDK自带的Array的时候
         *       我们只需要调用array.add()方法就可以了，
         *       没有去关注过，到底插入的逻辑是什么？从前面插入还是后面插入的
         *
         *       下面我们就去看一下，知其然知其所以然，这才叫工程师，别他妈的，只当一个会用的人，那是傻子,看了眼jdk的源码
         *       说得很清楚了，插入到尾端，有两个很有意思的方法
         *
         *       确保size + 1
         *       1. ensureCapacityInternal(size + 1);
         *
         *       检查插入的下标是否符合预期
         *       2. rangeCheckForAdd(index);
         *
         *       因此，可以看出我们这里面的方法写少了，至少还需要一个add(index,e)这样子的方法,后续有需要再去接口进行拓展
         *
         */

        // 检查当前数组是否已经无法容纳新的元素
        // 这个size 和 capacity 就是一个小坑, 这个 == 和 >= 在底层运算到底差在那里呢？
        if (size == capacity)
            throw new IllegalArgumentException("当前数组无法容纳更多的元素，请及时扩容!");

        array[size] = e;
        size ++;
    }

    //    @Override
    public boolean add(int index, int e) {

        if (size >= capacity)
            throw new IllegalArgumentException("当前数组无法容纳更多的元素，请及时扩容!");

        if (index < 0 || index > size)
            throw new IllegalArgumentException("数组元素下标越界，请仔细检查核对!");

        // 坑点1： size不是数组的下标而是当前数组的元素个数

        // 坑点2： 数组的移动
        // 这里我们这样子去思考: 怎么去移动呢？举个简单的例子,我们过年回家打扑克的时候，当你抓到一张新牌的时候
        // 我们都下意识的将那个位置空出来，一般情况下都是向左拽牌，因为一般习惯性右手抓左手拿，为啥不向左拉？
        // 因为，左边顶住了已经，然而在我们向右拉的过程中也存在一个问题: 牌容易起叠，这个情况其实不难理解，因为拉牌的方式不对
        // 起叠是因为，你是从当前位置(待插入的位置)拉牌的，我们放慢这个过程，如果我们从最右边拉，一点点向左移动，看一下还会不会起叠？
        // 除非是小孩子！不然不会起叠的(有的人往上摆，有的人放在桌子上面！对不起这两个我也解释不了 - -!)，下面我们来继续写

        for (int i = size - 1; i >= index; i --) {

            array[i + 1] = array[i];
        }

        array[index] = e;
        size ++;
        return true;
    }

    //    @Override
    public int delete(int index) {

        if (index < 0 || index > size)
            throw new IllegalArgumentException("数组元素下标越界，请仔细检查核对!");

        // 坑点1： 数组的移动
        // 解析 :  数组的删除跟上面的还不大一样，删除相当于我们打斗地主中的出了一张牌(怀念卢姥爷)，过程为我们抽出了一张牌，结合实际如下
        // 别人出了一张3,我手里面正好有4，我就甩出去了，然后我发现我牌有空隙了，看着不大舒服，我就挪挪我的牌吧，我在挪的过程中(让我回想一下17张牌怎么被秒的)
        // 一般情况下都是把后面的整个当做一个整体，往左边撵(nian,我还能给你们标注拼音，好人不多了)一下，这里面有两个突出的部分
        //      1. 向左边撵
        //      2. 整体向左
        // 这里，我们我们简单解释下这两点吧
        //      1. 向左撵: 习惯性(。。。开个玩笑)，我们采用反证法，为什么以index为基准左边的元素不向右撵？这个就比较有意思了，我说下我的理解，一开始在学C语言的时候
        //         假定数组int[] a = new int[10],这样子一个数组，我们可以凭借 'a'就可以定位到这个数组！,a代表的是a[0],这个元素,我们可以把a理解为"指针头"或者理解为当前这个数组所占
        //         一块内存的起始位置，数组嘛内存地址必然连续，在Java中一个int类型的数据，占据4个字节的大小，假定当前数组的起始位置是0x1234,那么下一个连续的地址为: 0x1234 + 4个字节之后的位置
        //         而且,我们平常所说的a[0],a[1]..a[n-1]都是以基准为a[0]，内存的起始位置说的，所以左边的元素能不动就不动，你要是动了。。。麻烦也不小！就拿我们这个例子来说，你是舒服了，index左边的元素
        //         向右移动就好了，过程相当于我们上面说的add(index,e),那么重点来了，头指针在哪里？整体的移动暂且不谈，是不是内存中的所有元素都要向右移动一位？相当于浪费了1.5倍左右的空间，当然了，自己闲着无聊
        //         可以这么搞一下，再把内存地址打出来看看，所以正确的做法是: 基于index的元素右边的元素整体向左移动从左边第一个元素一点点移动
        //      2. 整体向左: 再来解释下这个问题，简单点说: 数组要求内存地址连续没了！就这么简单，在拓展下，就要说到链表了！这个是个好东西~以后会说的
        //      下面开始写代码

        int ret = array[index];

        for (int i = index; i < size - 1; i ++) {

            array[i] = array[i + 1];
        }

        size --;

        return ret;
    }

    //    @Override
    public void set(int index, int e) {

        // 这个方法比较容易,简单点的就是: 指定位置数组元素值的替换, 拓展一下，特定内存地址所指向的以前指向A，现在指向B了
        // 接着拓展: 我想吃火锅。。。, 在Java中我们一般都知道以下几个区域:
        //              A: 栈(栈溢出。。stackOverFlow,你到底是咋溢出的？这次暂不讨论)
        //              B: 堆
        //              C: 方法区(Ps: 我只知道这三个区域，这三个区域做什么的也有点了解，没有读过这方面的书，还有栈针。。。听说Java8又进行了改动，估计以后面试会遇到)
        //
        //      解析:简单理解就是我们在堆区域申请了一块内存空间，然后呢，在栈区域有变量指向了堆区域的这块内存(如果理解不了，理解为new一个对象即可)
        //           当我们调用set(index,e)的时候说白了就是以前堆区域的这个变量指向了A，现在不指向A了，改为指向B了
        //
        //      小拓展: A指向哪里了呢？ 按照我的理解最合理的应该为null,这样子方便JVM进行回收(这里面知识较多，什么虚引用，软引用。。记不清了),当然了如果你不标记为null
        //             也没关系，因为JVM会进行垃圾回收，当没有引用指向的时候先搞到Yong区，巴拉巴拉'标记清除'...
        //
        if (index < 0 || index > size)
            throw new IllegalArgumentException("位置不合理，请仔细检查核对!");

        // 实际上就一行代码，
        array[index] = e;

    }

    //    @Override
    public int find(int index) {

        if (index < 0 || index > size)
            throw new IllegalArgumentException("数组元素下标越界，请仔细检查核对!");

        // 这个方法也比较容易，说他简单吧也简单，说不简单也很难,下面我们说下简单版本以及复杂版本最后再说下所引出的问题是什么！
        //
        //      简单版本: 遍历数组查找元素
        //      复杂版本: 定位头元素，之后按照当前元素的类型进行内存的'跳跃',eg： 假定是int类型的数据，单个元素是4个字节如果我们要查找a[3]
        //               这个元素，那么a[3] = a[0] + 2 * 4个字节的元素
        //
        //      所引出的问题: 这个缺德吖，一个简单的查找引出了N + 1个问题(那个1是我的不满！！！), 排序问题，就是因为查找才产生的，数一数有多少个
        //
        //                  a. 快速排序
        //                  b. 简单排序
        //                  c. 冒泡排序
        //                  d. 堆排序
        //            就会这么多了,这次不说了，饭没吃呢，不然鬼知道啥时候写得完
        //
        //      Ps: 在实际应用中，查找是必不可少的，随着数据量的变化切换不同的算法必不可少，并且不同的数据结构也有影响
        //          针对队列而言，数组实现的队列和链表实现的队列在效率上就差了很多
        //
        //      不同的数据结构也不是万能的，有得必有失，慎重考虑，学习阶段，能用的上的知识，放心大胆的用就行了。。。 成长自己，快乐ta人！
        //      下面编程实现。

        return array[index];
    }

    @Override
    public String toString() {

        // 一个小问题: StringBuilder 与 StringBuffer的区别, 别想着百度，最正确的答案就在眼前点进去源码，明明白白的写着呢
        // 1. StringBuilder
        //      a. 线程不安全
        //      b. 主要的操作方法为: append, insert
        //      c. 当我们new一个StringBuilder()的时候实际上是分配了内存空间的Character(16)
        //      d. 出来的原因就是为了替换StringBuffer


        //
        // 2. StringBuffer
        //      a. 线程安全
        //

        StringBuilder res = new StringBuilder();

        res.append("Array \nsize：").append(size).append("\n");
        res.append("capacity: ").append(capacity).append("\n");
        res.append("Array[");

        for (int i = 0; i < size; i ++) {

            res.append(array[i]);

            if (i != size - 1) {
                res.append(", ");
            }

        }
        res.append("]");

        return res.toString();
    }

    //    @Override
    public void resize(int[] array , int capacity) {

        // 扩容: 这个思路比较简单容易，不进行过多的讲解
        //
        // 存在的坑: 对性能的影响 ---> 数组的震荡 ---> 频繁缩小/扩大数组

        int[] newArray = new int[capacity * size];

        // 将元素迁移到新数组,数组实现起来比较简单，后期链表，队列、堆、栈进行拓展(较为麻烦),需要拓展的地方先不改了，下次改进
        // 还有个如何防止震荡的问题

        for (int i = 0; i < size; i ++) {

            newArray[i] = array[i];
        }

        // 新老数组地址指向(上面说过这个问题了，不在重复赘述，主要是饿了，要去吃饭)
        this.array = newArray;
        this.capacity = size * 2;
    }


    public int[] getArray() {
        return array;
    }



    public static void main(String[] args) {
            Array array = new Array(11);
            for (int i = 0; i < 10; i ++) {
                array.add(i,i);
            }
            System.out.println(array);
            System.out.println("-----插入任意位置-----");
            // 插入任意位置
            array.add(2,100);
            System.out.println(array);
            // 删除一个元素
            System.out.println("-----删除一个元素-----");
            array.delete(1);
            System.out.println(array);
            // 查找一个元素
            System.out.println("-----查找一个元素-----");
            System.out.println( array.find(2));
            // 测试数组扩容
            System.out.println("-----测试数组扩容-----");
            array.resize(array.getArray(),2);
            System.out.println(array);
            // 插入任意位置
            array.add(2,102);
            array.add(3,103);
            array.add(4,104);
            System.out.println(array);
    }
}

