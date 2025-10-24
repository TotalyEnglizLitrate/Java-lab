package lab.lab_9.ex_1;

import java.util.ArrayList;

public class Stack<T> implements AbstractStack<T> {
    protected ArrayList<T> stack;

    Stack() {
        stack = new ArrayList<T>();
    }

    @Override
    public T peek() throws IndexOutOfBoundsException {
        if (stack.size() == 0) {
            throw new IndexOutOfBoundsException("Empty Stack!");
        }

        return stack.get(stack.size() - 1);
    }

    @Override
    public T pop() throws IndexOutOfBoundsException {
        if (stack.size() == 0) {
            throw new IndexOutOfBoundsException("Empty Stack!");
        }

        return stack.remove(stack.size() - 1);
    }

    @Override
    public void push(T element) {
        stack.add(element);
    }

    @Override
    public long length() {
        return stack.size();
    }
}