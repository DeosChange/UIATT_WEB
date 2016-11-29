package com.uiatt.cases;

import com.uiatt.listener.Assertion;

public class TestDemo1 {
	public static void main(String[] args){
		String a="男 55岁";
		String b="男 55岁";
		Assertion.assertEquals(b, a, "\"所获取的被修改的第一条病例的年龄与修改时输入值不符\"，未修改成功或元素未找对，请检查！");
		System.out.print("1111");
	}

}
