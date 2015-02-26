package org.usfirst.frc.team1014.logger;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Logger
{
	
	
	BufferedWriter writer;
	
	public Logger(String fileName)
	{
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(fileName))));
		} catch (FileNotFoundException e) 
		
		{
			e.printStackTrace();
		}
		
	}
	
	
	public void write(double object)
	{
		try {
			writer.write(object + ", ");
		} catch (IOException e) 
		
		{
			e.printStackTrace();
		}
	}
	public void destroy()
	{
		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
