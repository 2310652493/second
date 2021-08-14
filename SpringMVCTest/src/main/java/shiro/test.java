package shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

public class test {
    @Test
    public void Shiro(){
        //获取SecurityManager工厂并且加载shiro.ini文件
        Factory<org.apache.shiro.mgt.SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro.ini");
        //得到SecurityMangager实例并且绑定给SecurityUtils
        org.apache.shiro.mgt.SecurityManager manager=factory.getInstance();
        SecurityUtils.setSecurityManager(manager);
        //得到subject，并且用户名、密码认证Token(用户身份和凭证）
        Subject subject=SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken("wang","1");
        //捕获异常，查看信息
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        subject.logout();
    }
    @Test
    public void jdbc(){
        Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro.ini");

    }

}
