package com.prueba.javatest.util;


import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {
        @Test
        public void repeat_string_multiple_times(){
        Assert.assertEquals("holaholahola",StringUtil.repeat("hola", 3));
       // assertEquals(StringUtil.repeat("hola", 2), "hola");
            }
    @Test
    public void repeat_string_once(){
        Assert.assertEquals("hola",StringUtil.repeat("hola", 1));
       }
    @Test
    public void repeat_string_zero_times(){
        Assert.assertEquals("",StringUtil.repeat("hola", 0));
    }
    @Test(expected = IllegalArgumentException.class)
    public void repeat_negative_times(){
        Assert.assertEquals("",StringUtil.repeat("hola", -1));
    }


  @Test
  public void not_empty_string(){
   Assert.assertFalse(StringUtil.isEmpty("text"));
  }
    @Test
    public void null_string(){
        Assert.assertTrue(StringUtil.isEmpty(null));
    }
    @Test
    public void empty_string(){
        Assert.assertTrue(StringUtil.isEmpty(""));
    }

    @Test
    public void space_string(){
        Assert.assertTrue(StringUtil.isEmpty("    "));
    }

}