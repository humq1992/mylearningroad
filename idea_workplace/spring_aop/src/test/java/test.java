import com.itheima.service.IAccountService;
import com.itheima.service.impl.AccountServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
        public static void main(String[] args) {
            ClassPathXmlApplicationContext cpa = new ClassPathXmlApplicationContext("bean.xml");
            IAccountService accountService = (IAccountService) cpa.getBean("accountService");
            accountService.saveaccount();
        }
    }


