package com.amazon.customskill;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.amazon.customskill.AlexaSkillSpeechlet.RecognitionState;
import com.amazon.customskill.AlexaSkillSpeechlet.UserIntent;
import com.amazon.speech.json.SpeechletRequestEnvelope;
import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.LaunchRequest;
import com.amazon.speech.speechlet.SessionEndedRequest;
import com.amazon.speech.speechlet.SessionStartedRequest;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.speechlet.SpeechletV2;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.SsmlOutputSpeech;
import com.amazon.customskill.AlexaSkillSpeechlet.FirstTime;

public class checkUserInfo {
	static String currentTopicString = "Vocab1";
	static int topicDoneAlready = 0;
	private static Connection con = null;
	private static Statement stmt = null;
	{
		try {
		con = DBConnection.getConnection();
		stmt = con.createStatement();
		ResultSet rs = stmt
				.executeQuery("SELECT * FROM UserInfo WHERE id=1" + "");
		topicDoneAlready = rs.getInt(currentTopicString);
		if(topicDoneAlready == 1) {
			System.out.println("True");
			}else {
			System.out.println("False");
		}
		} catch (Exception e){
		e.printStackTrace();
	}

}
}