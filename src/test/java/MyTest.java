import com.dan.bean.Emp;
import com.dan.dao.EmpDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author lizhenyang
 * @desc
 * @create 2020-04-08 11:14
 */
public class MyTest {
    @Test
    public void test() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpDao mapper = sqlSession.getMapper(EmpDao.class);
        System.out.println(mapper);
        Emp emp = mapper.selectEmpByEmpno(1);
        System.out.println(emp);

        System.out.println("---------");
        Emp emp1 = new Emp();
        emp1.setEmpno(3);
        emp1.setEname("zhangsan3");
        System.out.println(mapper.save(emp1));
        sqlSession.close();
    }
}
