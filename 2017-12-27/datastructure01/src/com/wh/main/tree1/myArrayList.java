package com.wh.main.tree1;

import java.util.ArrayList;
import java.util.Iterator;
/**
 * toString function orgin from abstractCollection.class
 * 
 * @author test
 *
 * @param <E>
 */
public class myArrayList<E> extends ArrayList<E>{
	 //  String conversion

    /**
     * Returns a string representation of this collection.  The string
     * representation consists of a list of the collection's elements in the
     * order they are returned by its iterator, enclosed in square brackets
     * (<tt>"[]"</tt>).  Adjacent elements are separated by the characters
     * <tt>", "</tt> (comma and space).  Elements are converted to strings as
     * by {@link String#valueOf(Object)}.
     *
     * @return a string representation of this collection
     */
    public String toString2() {
        Iterator<E> it = iterator();
        if (! it.hasNext())
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (;;) {
            E e = it.next();
            sb.append(e == this ? "(this Collection)" : e);
            if (! it.hasNext())
                return sb.append(']').toString();
            sb.append(',').append(' ');
        }
    }
    
    
    /**
     * 修改之后的toString方法
     */
    public String toString() {
        Iterator<E> it = iterator();
        if (! it.hasNext())
            return "";

        StringBuilder sb = new StringBuilder();
  
        for (;;) {
            E e = it.next();
            sb.append(e == this ? "(this Collection)" : e);
            if (! it.hasNext())
                return sb.toString();
            sb.append(',');
        }
    }
    
	

}
