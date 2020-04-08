import com.dan.bean.Account;
import com.dan.bean.Emp;
import com.dan.dao.AccountDao;
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
public class MyTest {
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
        EmpDao mapper = sqlSession.getMapper(EmpDao.class);
        System.out.println(mapper);
        Emp emp = mapper.selectEmpByEmpno(1);
        System.out.println(emp);
        System.out.println("---------");

        sqlSession.close();
    }

    @Test
    public void selectAllAccount() {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        AccountDao mapper = sqlSession.getMapper(AccountDao.class);
        System.out.println(mapper);
//        Emp emp = mapper.selectEmpByEmpno(1);
        ArrayList arrayList = mapper.selectAll();
        System.out.println(arrayList);
        sqlSession.close();
    }



    @Test
    public void selectAllAccountToMap() {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        AccountDao mapper = sqlSession.getMapper(AccountDao.class);
        System.out.println(mapper);
        Map<String, Account> stringAccountMap = mapper.selectAllToMap();
        System.out.println(stringAccountMap);
        sqlSession.close();
    }

    @Test
    public void testSave() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpDao mapper = sqlSession.getMapper(EmpDao.class);
        Emp emp1 = new Emp();
        emp1.setEmpno(5);
        emp1.setEname("zhangsan5");
        System.out.println(mapper.save(emp1));
        sqlSession.close();
    }

    @Test
    public void testSelectAccount() {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        AccountDao mapper = sqlSession.getMapper(AccountDao.class);
        System.out.println(mapper);
        Account account = mapper.selectById(2);
        System.out.println(account);
        sqlSession.close();
    }

    @Test
    public void testSelectAccountByNameAndPwd() {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        AccountDao mapper = sqlSession.getMapper(AccountDao.class);
        System.out.println(mapper);
        ArrayList<Account> accountArrayList = mapper.selectAccountByNameAndPwd("dabaomei", "123456");
        System.out.println(accountArrayList);
        sqlSession.close();
    }

    @Test
    public void testSelectAccountByNameAndPwd2() {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        AccountDao mapper = sqlSession.getMapper(AccountDao.class);
        System.out.println(mapper);
        Map<String, String> objectObjectMap = new HashMap<String, String>();
        objectObjectMap.put("loginName", "dabaomei");
        objectObjectMap.put("password", "123456");

        ArrayList<Account> accountArrayList = mapper.selectAccountByNameAndPwd2(objectObjectMap);
        System.out.println(accountArrayList);
        sqlSession.close();
    }

    @Test
    public void testSaveAccount() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AccountDao mapper = sqlSession.getMapper(AccountDao.class);
        Account account = new Account();
        account.setLoginName("dabaomei");
        account.setPassword("123456");
        System.out.println(mapper.addAccount(account));
        System.out.println(account);
        sqlSession.close();
    }
}
