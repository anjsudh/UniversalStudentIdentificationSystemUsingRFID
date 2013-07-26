/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;
import java.util.*;
/**
 *
 * @author Nithya
 */
public class MarkBeanFactory {
    private static Marks[] m;
    public void setData(Marks[] p,int n)
    {
        m=new Marks[n+1];
        for(int i=0;i<=n;i++)
            m[i]=p[i];
    }
    public static Object[] getBeanArray()
    {
           return m; 
    }
    public static Collection getBeanCollection()
    {
        return Arrays.asList(m);
    }
}
