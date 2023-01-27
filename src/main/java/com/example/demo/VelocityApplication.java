package com.example.demo;

import java.io.File;
import java.io.StringWriter;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * https://www.baeldung.com/apache-velocity
 * https://www.baeldung.com/jackson-object-mapper-tutorial
 * https://www.javamonamour.org/2018/05/xml-parsing-with-jackson-fasterxml.html
 * 
 * https://brain.cdauth.eu/2011/03/29/why-apache-velocity-sucks/
 * 
 * @author pierl
 *
 */
@SpringBootApplication
public class VelocityApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(VelocityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("parsing JSON file ");
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("bikes.json").getFile());
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.readTree(file);
		System.out.println(jsonNode);
		Properties props = new Properties();
		props.setProperty("resource.loader", "file");
		//props.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		
		VelocityEngine velocityEngine = new VelocityEngine();
		// @DOC: http://velocity.apache.org/engine/1.7/developer-guide.html#configuring-resource-loaders
		String path = "";
	    props.put("file.resource.loader.path", path);
	    //props.setProperty("runtime.log.logsystem.class", "org.apache.velocity.runtime.log.NullLogSystem");
	    velocityEngine.init(props);
		
	    // do it with JSON only
		Template t = velocityEngine.getTemplate("C:\\Users\\Jerry\\Documents\\GitHub\\velocityjson\\src\\main\\resources\\templates\\index.vm");
		VelocityContext context = new VelocityContext();
		context.put("payload", jsonNode);
		StringWriter writer = new StringWriter();
		t.merge(context, writer);
		System.out.println("Velocity with JSON");
		System.out.println(writer.toString());
	
		
	}
}
