package effectivejava.chapter5.item29.technqiue2;

import java.util.Arrays;
import effectivejava.chapter5.item29.EmptyStackException;

/**
 * ジェネリック型を使ったスタック実装(その2)
 */
public class Stack<E> {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    
    /**
     * その1ではこちらで型安全を保証するアノテーションを付与していたが、
     * こちらではObject配列をそのまま使う
     */
    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    /*
     * popメソッドで要素の取得時にキャストを行い、その無検査キャストの警告を抑止する。
     */
    public E pop() {
        if (size == 0)
            throw new EmptyStackException();

        @SuppressWarnings("unchecked") E result =
                (E) elements[--size];

        elements[size] = null; // Eliminate obsolete reference
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("Hello");
        stack.push("World");
        while (!stack.isEmpty())
            System.out.println(stack.pop().toUpperCase());
    }
}
