import com.sun.xml.internal.ws.client.sei.StubAsyncHandler;
import com.yzq.po.Dept;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.jaxb.SourceType;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * @author ASUS
 * @create 2019-11-20=10:08
 */
public class Test {
    @org.junit.Test
    public void test(){
        //1.获取sessionFactory 会话工厂
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        //2.生产会话 通过open session 获取session对象
        Session session=sessionFactory.openSession();
        //3.开启事务
        Transaction transaction = session.beginTransaction();
        //执行查询 get(要查询的实体类型，参数）
        Dept deptEntity = session.get(Dept.class, 1);
        System.out.println("deptEntity"+deptEntity);
        transaction.commit();//提交事务
        session.close();
        session=sessionFactory.openSession();
        transaction=session.beginTransaction();
        Dept load = session.get(Dept.class, 1);
        System.out.println(load);
        //执行查询  hql语句

        //查询全部
        Query query1=session.createQuery("from com.yzq.po.Dept");
        List<Dept> list=query1.list();
        for(Dept dept:list){
            System.out.println("stu"+dept);
        }


        Query query=session.createQuery("from Dept where id=3");
        Object o = query.uniqueResult();
        System.out.println(o);

        String hql2="from Dept where id=:id";
        Query q2 = session.createQuery(hql2);
        q2.setParameter("id",2);


    }
}
