package com.campus.clova.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController  //responseBody안해도 됌
public class Clova05_sentiment_controller {
	
	@GetMapping("/clova/sentiment")
	public ModelAndView sentiment() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("clova/sentiment");
		return mav;
	}
	@PostMapping("/clova/sentimentOk")
	public HashMap sentimentOk(@RequestParam("content") String content) {
		//----------------
		
		String clientId = "zejn0nuoby";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "HHPBJfv9XrCaZbGLIWpStKWeIqHwg7aoCrC7eMJA";//애플리케이션 클라이언트 시크릿값";
        
        //버퍼 아래서 이동(원래있던 복사한 파일)
        BufferedReader br = null;//전송받은 정보가 있는 InputStream
        StringBuffer response = new StringBuffer();  //버퍼 아래서 이동(원래있던 복사한 파일)
        
        HashMap map = new HashMap();
        
        
        try {
        	//클라우드로 보낼 데이터를 준비한다. 제이슨은 {key:value}형식으로 된것이 제이슨 오브젝이다.
        	JSONObject jsonData = new JSONObject();//처음에 프로젝트 만들때 org.json을 추가했다. | 이객체안에 title, content 내용을 넣는다.
        	jsonData.put("content", content);
        	
        	String jsonStr = jsonData.toString(); //문자열로 바꾼것 {"content":"글내용..."}
        	System.out.println("jsonString"+ jsonStr);
        	//-------------------------
        	
            String apiURL = "https://naveropenapi.apigw.ntruss.com/sentiment-analysis/v1/analyze"; // 감정분석
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            
            con.setUseCaches(false);
            con.setDoOutput(true);
            con.setDoInput(true);
            
            // multipart request
            // String boundary = "---" + System.currentTimeMillis() + "---";
            con.setRequestMethod("POST");//전송을 포스트 방식 
            
            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
            con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
            con.setRequestProperty("Content-Type", "application/json");
            
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
		//-----------------
        System.out.println(response.toString());
        //**************************
        JSONObject jsonResult = new JSONObject(response.toString());
        // 전체 감정분석
        JSONObject document = jsonResult.getJSONObject("document");
        SentimentVO analVO = new SentimentVO();
        analVO.setSentiment(document.getString("sentiment"));
        
        JSONObject confidence = document.getJSONObject("confidence");
        analVO.setNeutral(confidence.getDouble("neutral"));
        analVO.setPositive(confidence.getDouble("positive"));
        analVO.setNegative(confidence.getDouble("negative"));
        
        //문장별 감정분석
        JSONArray sentencesArray = jsonResult.getJSONArray("sentences");
        
        //문장별 감정분석을 VO에 추가하고 VO를 list에 추가한다.
        List<SentimentVO> sentimentList = new ArrayList<SentimentVO>();
        for(int i=0; i<sentencesArray.length(); i++) {
        	JSONObject obj = sentencesArray.getJSONObject(i);
        	
        	SentimentVO vo = new SentimentVO();
        	vo.setContent(obj.getString("content"));
        	vo.setSentiment(obj.getString("sentiment"));
        	
        	JSONObject conObj = obj.getJSONObject("confidence");
        	vo.setNeutral(conObj.getDouble("neutral"));
        	vo.setPositive(conObj.getDouble("positive"));
        	vo.setNegative(conObj.getDouble("negative"));
        	
        	sentimentList.add(vo);// 반복되기전에 리스트로 vo를 넣고 반복
        }
        
        map.put("analVO", analVO);
        map.put("list", sentimentList);
        
        //**************************
        System.out.println("vo-->"+ analVO.toString());
        
        return map;
	}
}
