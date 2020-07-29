package me.perol.blog;

import me.perol.blog.entity.Visit;

public class InO {
    public static Long[] visitArray = new Long[]{1L, 1L};
    public static  synchronized void plusWebsite(){
        visitArray[0]+=1;
    }
    public static  synchronized void plusPixez(){
        visitArray[1]+=1;
    }
}
