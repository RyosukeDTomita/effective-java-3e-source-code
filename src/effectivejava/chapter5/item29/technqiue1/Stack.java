package effectivejava.chapter5.item29.technqiue1;
import effectivejava.chapter5.item29.EmptyStackException;

import java.util.Arrays;

/**
 * ジェネリック型を使ったスタック実装
 */
public class Stack<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    /**
     * アノテーションで型安全性を保証することで、コンパイルエラーを抑止している。
     * Type safety: Unchecked cast from Object[] to E[]
     */
    @SuppressWarnings("unchecked")
    public Stack() {
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size == 0)
            throw new EmptyStackException();
        E result = elements[--size];
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
        // データ投入
        Stack<String> stack = new Stack<>();
        stack.push("Hello");
        stack.push("World");
        // データ取り出し
        while (!stack.isEmpty())
            System.out.println(stack.pop().toUpperCase());
    }
}
