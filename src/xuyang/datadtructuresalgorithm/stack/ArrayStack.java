package xuyang.datadtructuresalgorithm.stack;

/**
 * @author Li Xuyang
 * @date : 2019/11/2 21:31
 */
public class ArrayStack {

    //栈的大小
    private int maxSize;

    //数组，数组模拟栈，数据就放在该数组
    private int[] stack;

    private int top = -1;

    //构造器
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;

        stack = new int[maxSize];
    }


    //栈满

    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈 push
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈 pop ,将栈顶的数据返回

    public int pop() {
        //先判断栈是否空
        if (isEmpty()) {
            throw new RuntimeException("栈空，没有数据");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //显示栈的情况，[遍历栈]，遍历时，需要从栈顶开始显示数据

    public void list() {
        if (isEmpty()) {
            System.out.println("栈空，不能显示数据");
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d] = %d\n", i, stack[i]);
        }

    }


}
