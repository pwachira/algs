package algs;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.NoSuchElementException;

public class StackOps {

    interface Stack<T> {
        void push(T t);
        T pop();
        int size();
    }

    class StackImpl<T> implements Stack<T>{

        class Node {
            T t;
            Node next = null;

        }

        public Node first;
        private int size =  0;
        public  StackImpl() {

        }
        @Override
        public void push(T t) {

            Node node = new Node();
            node.t = t;
            if (first != null) {
                node.next = first;
            }
            first = node;
            size++;

        }

        @Override
        public T pop() throws NoSuchElementException {
            if (first == null) throw new NoSuchElementException();
            Node popped = first;
            first = popped.next;
            size--;
            return popped.t;

        }

        @Override
        public int size() {
            return size;
        }

    }

    public static void main(String[] args) {

        Stack<Integer> stack = new StackOps().new StackImpl<Integer>();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.pop();
        int p = stack.pop();

        System.out.println(p);
        System.out.println(stack.size());

        assertThat(p, is(4));
        assertThat(stack.size(),is(1));

    }
}
