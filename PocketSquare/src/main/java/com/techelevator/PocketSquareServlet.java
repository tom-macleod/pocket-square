package com.techelevator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
 
public class PocketSquareServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String page = request.getParameter("page");
		
		switch(page) {
		
		case "0" : 
			pageOne(request, response);
			break;
		case "1" :
			pageTwo(request, response);
			break;
		case "2" :
			pageThree(request, response);
			break;
		case "3" :
			pageFour(request, response);
			break;
		case "4" :
			finalPage(request, response);
			break;
		}
		
    }
    
    private void pageOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	useDispatcherForNextQuestionPage(request, response, "/WEB-INF/question1.jsp");
    }
    
    private void pageTwo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	ScoreTracker scoreTracker = new ScoreTracker();
    	Integer firstAnswer = Integer.parseInt(request.getParameter("question1"));
    	scoreTracker.setScore(firstAnswer);
    	request.getSession().setAttribute("scoreTracker", scoreTracker);
    	useDispatcherForNextQuestionPage(request, response, "/WEB-INF/question2.jsp");
    }
    
    private void pageThree(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Integer secondAnswer = Integer.parseInt(request.getParameter("question2"));
    	setScore(request, secondAnswer);
    	useDispatcherForNextQuestionPage(request, response, "/WEB-INF/question3.jsp");
    }
    
    private void pageFour(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Integer thirdAnswer = Integer.parseInt(request.getParameter("question3"));
    	setScore(request, thirdAnswer);
    	useDispatcherForNextQuestionPage(request, response, "/WEB-INF/question4.jsp");
    }
    
    private void finalPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Integer fourthAnswer = Integer.parseInt(request.getParameter("question4"));
    	setScore(request, fourthAnswer);
    	ScoreTracker scoreTracker = (ScoreTracker) request.getSession().getAttribute("scoreTracker");
    	Integer finalScore = scoreTracker.getScore();
    		if(finalScore >= 12) {
    			useDispatcherForNextQuestionPage(request, response, "/WEB-INF/result1.jsp");
    		} else if(finalScore >= 9 && finalScore < 12) {
    			useDispatcherForNextQuestionPage(request, response, "/WEB-INF/result2.jsp");
    		} else if(finalScore >= 5 && finalScore < 9) {
    			useDispatcherForNextQuestionPage(request, response, "/WEB-INF/result3.jsp");
    		} else if(finalScore >= 1 && finalScore < 5) {
    			useDispatcherForNextQuestionPage(request, response, "/WEB-INF/result4.jsp");
    		} else {
    			useDispatcherForNextQuestionPage(request, response, "/WEB-INF/result5.jsp");
    		}
    	
    }
    
    
    
    private void setScore(HttpServletRequest request, Integer answer) {
    	ScoreTracker scoreTracker = (ScoreTracker) request.getSession().getAttribute("scoreTracker");
    	scoreTracker.setScore(scoreTracker.getScore() + answer);
    }
    
    private void useDispatcherForNextQuestionPage(HttpServletRequest request, HttpServletResponse response, String jspName) throws ServletException, IOException {
    	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jspName);
    	dispatcher.forward(request, response);
    }
    
}