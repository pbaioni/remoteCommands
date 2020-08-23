package app.web.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/commands")
public class WebController {

	Runtime runtime = Runtime.getRuntime();
    
	@GetMapping("/shutdown")
    public String shutdown() throws IOException {
    	String[] cmd = new String[]{"/bin/sh", "/Users/paolobaioni/Scripts/shutdown.sh"};
        return execCommand(cmd);
    }
    
	@GetMapping("/testlink")
	@ResponseStatus(HttpStatus.OK)
    public String testlink()  {
		Calendar time = new GregorianCalendar();
		String result = toH1(time.getTime().toString());
		result += toH1("Link OK");
		return  result;
    }
	
    private String execCommand(String[] cmd)
    {
        try {
			Process proc = runtime.exec(cmd);
			String line;
			Calendar time = new GregorianCalendar();
			StringBuilder b = new StringBuilder(toH1(time.getTime().toString()));
		    BufferedReader input = new BufferedReader(new InputStreamReader(proc.getInputStream()));
		    while ((line = input.readLine()) != null) {
		        b.append(toH1(line));
		    }
		    input.close();
		    return b.toString();
		} catch (IOException e) {
			System.out.println("Error while executing command " + cmd);
			e.printStackTrace();
		}
        
        return "";
    }
    
    private String toH1(String line) {
    	return "<h1>"+line+"</h1>";
    }
    

	
}
