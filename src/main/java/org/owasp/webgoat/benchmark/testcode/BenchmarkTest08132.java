package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08132")
public class BenchmarkTest08132 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = new Test().doSomething(param);
		
		float rand = new java.util.Random().nextFloat();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextFloat() executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map8283 = new java.util.HashMap<String,Object>();
		map8283.put("keyA-8283", "a_Value"); // put some stuff in the collection
		map8283.put("keyB-8283", param.toString()); // put it in a collection
		map8283.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map8283.get("keyB-8283"); // get it back out
		bar = (String)map8283.get("keyA-8283"); // get safe value back out

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass