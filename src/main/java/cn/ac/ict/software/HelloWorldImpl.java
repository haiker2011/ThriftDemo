package cn.ac.ict.software;

import org.apache.thrift.TException;

public class HelloWorldImpl implements HelloWorldService.Iface{
    @Override
    public String sayHello(User user) throws TException {
        return "Hi,My name is " + user.username + " and My age is " + user.age;
    }

}
