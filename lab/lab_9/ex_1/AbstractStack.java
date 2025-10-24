package lab.lab_9.ex_1;

public interface AbstractStack<T> {
    public T peek() throws IndexOutOfBoundsException;
    public T pop() throws IndexOutOfBoundsException;
    public void push(T element);
    public long length();
}