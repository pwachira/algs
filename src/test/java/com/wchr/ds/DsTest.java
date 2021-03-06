package com.wchr.ds;

import org.junit.Test;

import com.wchr.ds.GraphOps;
import com.wchr.ds.StackOps;
import com.wchr.ds.GraphOps.Graph;
import com.wchr.ds.StackOps.Stack;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.List;

public class DsTest {
    @Test
    public void testGraph() {

            GraphOps ops = new GraphOps();
            Graph g = ops.new GraphImpl(7);
            g.addEdge(0,1);
            g.addEdge(0,2);
            g.addEdge(0,5);
            g.addEdge(0,6);
            g.addEdge(5,3);
            g.addEdge(5,4);
            g.addEdge(6,4);

            List<Integer> pathDFS = ops.new DFS(g).search(5);
            pathDFS.stream().forEach(v -> System.out.print(v+" "));
            System.out.print("\n");
            assertThat(pathDFS, is(Arrays.asList(5,0,1,2,6,4,3)));

            List<Integer> pathBFS = ops.new BFS(g).search(5);
            assertThat(pathBFS, is(Arrays.asList(5,0,3,4,1,2,6)));
            pathBFS.stream().forEach(v -> System.out.print(v+" "));
    }


    @Test
    public void testStack() {

        Stack<Integer> stack = new StackOps().new StackImpl<Integer>();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.pop();
        int p = stack.pop();

        System.out.println("\npopped: " + p);
        System.out.println("stack size after pop:"+stack.size());

        assertThat(p, is(4));
        assertThat(stack.size(),is(1));


    }
}
