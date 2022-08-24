package com.campus.clova.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Clova08_voice_controller {
	@GetMapping("/clova/voiceForm")
	public String voiceForm() {
		return "clova/voiceForm";
	}
	@PostMapping("/clova/voiceOk")
	@ResponseBody //에이젝스로 호출하고 있기 때문에
	public void voiceOk(@RequestParam("text") String text, HttpServletResponse res) {
		//////////////////
		String clientId = "73nfc5eeul";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "gH9BDQriaT7h6j1VrasqCiFXBGUdtN5rXOME2Svs";//애플리케이션 클라이언트 시크릿값";
        try {
            text = URLEncoder.encode(text, "UTF-8"); // 13자
            
            String apiURL = "https://naveropenapi.apigw.ntruss.com/tts-premium/v1/tts";
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            
            con.setRequestMethod("POST");
            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
            con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
            // post request
            String postParams = "speaker=nara&volume=0&speed=0&pitch=0&format=mp3&text=" + text;
            con.setDoOutput(true);
            
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(postParams);
            wr.flush();
            wr.close();
            
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                InputStream is = con.getInputStream();
                int read = 0;
                byte[] bytes = new byte[1024];
                // 랜덤한 이름으로 mp3 파일 생성
                String tempname = Long.valueOf(new Date().getTime()).toString();
                File f = new File(tempname + ".mp3");
                f.createNewFile();
                OutputStream outputStream = new FileOutputStream(f);
                
                //클라이언트에게 보내기 
                OutputStream os = res.getOutputStream();
                ///////
                
                while ((read =is.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, read);
                    os.write(bytes, 0, read);
                }
                is.close();
                os.close();
            } else {  // 오류 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                }
                br.close();
                System.out.println(response.toString());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
		/////////////////
		
	}
}
