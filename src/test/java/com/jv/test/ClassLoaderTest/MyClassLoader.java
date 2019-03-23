package com.jv.test.ClassLoaderTest;

import org.junit.Test;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyClassLoader extends ClassLoader {
    private String classpath;

    public MyClassLoader(){
        super();
    }
    public MyClassLoader(String classpath) {

        this.classpath = classpath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
         System.out.println("findClass !");
         
        try {
            byte [] classDate=getDate(name);

            if(classDate==null){}

            else{
                //defineClass方法将字节码转化为类
                return defineClass(name,classDate,0,classDate.length);
            }

        } catch (IOException e) {

            e.printStackTrace();
        }

        return super.findClass(name);
    }

    private byte[] getDate(String className) throws IOException{
        InputStream in = null;
        ByteArrayOutputStream out = null;
        String path=classpath + File.separatorChar +
                className.replace('.',File.separatorChar)+".class";
        try {
            in=new FileInputStream(path);
            out=new ByteArrayOutputStream();
            byte[] buffer=new byte[2048];
            int len=0;
            while((len=in.read(buffer))!=-1){
                out.write(buffer,0,len);
            }
            return out.toByteArray();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally{
            in.close();
            out.close();
        }
        return null;
    }

    	public static void main(String[] args) throws Exception {
            User user = new User();
            user.printUserName("nameOne");

            System.out.println("class loader = " + user.getClass().getClassLoader());

            Thread.sleep(18 * 1000);

            user.printUserName("nameTwo");

            /**
             * 在热部署的时候，
             * 这是正常的jvm hotswap限制，因为它只允许修改方法体，不能有方法或属性的添加和删除。
             */
            User user2 = new User();
            user2.printUserName("nameThree");
             System.out.println("class loader = " + user2.getClass().getClassLoader());


       }
       public static void testLoader()throws Exception{
           //           MyClassLoader myClassLoader=new MyClassLoader("D:\\lib");
           MyClassLoader myClassLoader=new MyClassLoader("E:\\Git_Repository\\SSM\\target\\test-classes");

           //包名+类名

           for (int i = 0; i < 3; i ++){
//                Class c = myClassLoader.loadClass("com.jv.test.ClassLoaderTest.User");
               Class c = myClassLoader.findClass("com.jv.test.ClassLoaderTest.User");

               if(c!=null){
                   Object obj=c.newInstance();
                   Method method=c.getMethod("say", null);
                   method.invoke(obj, null);
                   System.out.println(c.getClassLoader().toString());
               }

               Thread.sleep(20 * 1000);
           }
       }




}
