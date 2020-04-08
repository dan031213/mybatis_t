import com.dan.bean.Account;
import com.dan.bean.Dog;
import com.dan.bean.Emp;
import com.dan.dao.AccountDao;
import com.dan.dao.DogDao;
import com.dan.dao.EmpDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lizhenyang
 * @desc
 * @create 2020-04-08 11:14
 */
public class MyTest2 {
    SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void test1() {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        DogDao mapper = sqlSession.getMapper(DogDao.class);
        System.out.println(mapper);
        Dog dog = mapper.selectDogById(1);
        System.out.println(dog);
        sqlSession.close();
    }
}
