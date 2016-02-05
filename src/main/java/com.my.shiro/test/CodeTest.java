package com.my.shiro.test;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Administrator on 2016/2/3 0003.
 */
public class CodeTest {

    @Test
    public void test64(){
        String str = "hello";
        String base64Encoded = Base64.encodeToString(str.getBytes());
        String str2 = Base64.decodeToString(base64Encoded);
        Assert.assertEquals(str, str2);
    }

    @Test
    public void testHex(){
        String str = "hello";
        String base64Encoded = Hex.encodeToString(str.getBytes());
        String str2 = new String(Hex.decode(base64Encoded.getBytes()));
        Assert.assertEquals(str, str2);
    }

    @Test
    public void testMD5(){
        String str = "hello";
        String salt = "123";
        String md5 = new Md5Hash(str, salt).toString();//还可以转换为 toBase64()/toHex()
    }

    @Test
    public void test256(){
        String str = "hello";
        String salt = "123";
        String sha1 = new Sha256Hash(str, salt).toString();
    }

    @Test
    public void testsimpleHash(){
        String str = "hello";
        String salt = "123";
        //内部使用 MessageDigest
        String simpleHash = new SimpleHash("SHA-1", str, salt).toString();
    }
}
