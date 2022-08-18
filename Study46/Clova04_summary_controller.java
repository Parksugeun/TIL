package com.campus.clova.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Clova04_summary_controller {
	
	@RequestMapping("/clova/summary")
	public String summary() {
		return "clova/summary";
	}
	@RequestMapping(value="/clova/summaryOk", method=RequestMethod.POST)
	public String summaryOk(@RequestParam("title") String title, @RequestParam("content") String content) {
		//타이틀,컨텐츠 -> 보낸데이터를 받아야한다. 
		
		//////////
		StringBuffer reqStr = new StringBuffer();
        String clientId = "2gvgooduud";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "tJAUZJhq9IRyw7CrGpJWJlkhsQBBiRPbrhwHSFUf";//애플리케이션 클라이언트 시크릿값";
        
        //버퍼 아래서 이동(원래있던 복사한 파일)
        BufferedReader br = null;//전송받은 정보가 있는 InputStream
        StringBuffer response = new StringBuffer();  //버퍼 아래서 이동(원래있던 복사한 파일)

        try {
        	//클라우드로 보낼 데이터를 준비한다.
        	JSONObject document = new JSONObject();//처음에 프로젝트 만들때 org.json을 추가했다. | 이객체안에 title, content 내용을 넣는다.
        	document.put("title", title);
        	document.put("content", content);
        	
        	JSONObject option = new JSONObject();
        	option.put("language", "ko");
        	option.put("model", "news");
        	option.put("tone", 3);
        	option.put("summaryCount", 3);
        	
        	JSONObject body = new JSONObject();
        	body.put("document", document);
        	body.put("option", option);
        	
        	String jsonStr = body.toString();
        	System.out.println("jsonString"+ jsonStr);
        	//-------------------------
        	
            String apiURL = "https://naveropenapi.apigw.ntruss.com/text-summary/v1/summarize"; // 얼굴 감지
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            
            con.setUseCaches(false);
            con.setDoOutput(true);
            con.setDoInput(true);
            
            // multipart request
            // String boundary = "---" + System.currentTimeMillis() + "---";
            con.setRequestMethod("POST");//전송을 포스트 방식 
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
            con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
            
            DataOutputStream dos = new DataOutputStream(con.getOutputStream()); 
            dos.write(jsonStr.getBytes());
            dos.flush();
            dos.close();
            
            //데이터 보내기 끝 
            
            //데이터 받기: 응답받기 
            
            int responseCode = con.getResponseCode();
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 오류 발생
                System.out.println("error!!!!!!! responseCode= " + responseCode);
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            }
            //전송받은 InputStream의 값을 읽어내기
            String inputLine;
            if(br != null) {
                //StringBuffer response = new StringBuffer();//위로 보낸다.
                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                }
                br.close();
                //System.out.println(response.toString());
            } 
//            else {
//                System.out.println("error !!!");
//            }
        } catch (Exception e) {
            System.out.println(e);
        }
		//////////
        System.out.println("summary->"+ response.toString());
		
		return null;
	}
}
