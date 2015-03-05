package org.usfirst.frc.team1014.smartdashboard;

import org.usfirst.frc.team1014.robot.commands.CommandBase;
import org.usfirst.frc.team1014.robot.commands.autonomous.DriveSquare;
import org.usfirst.frc.team1014.robot.commands.autonomous.DriveStraightDistance;
import org.usfirst.frc.team1014.robot.commands.autonomous.DriveStraightForward;
import org.usfirst.frc.team1014.robot.commands.autonomous.Turn180;
import org.usfirst.frc.team1014.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1014.robot.subsystems.Grabber;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.image.NIVisionException;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.vision.AxisCamera;

public class Dashboard 
{
	/**
	 * used to put values into SmartDashboard
	 * @param table
	 */
	public static void setup(NetworkTable table)
	{
		table.putBoolean("DriveStraightForward", false);
		table.putBoolean("DriveSquare", false);
		table.putNumber("frontLeft", DriveTrain.getInstance().getFrontLeft().get());
		table.putNumber("frontRight", DriveTrain.getInstance().getFrontRight().get());
		table.putNumber("backLeft", DriveTrain.getInstance().getBackLeft().get());
		table.putNumber("backRight", DriveTrain.getInstance().getBackRight().get());
		table.putNumber("grabberLevel", 0);
		table.putBoolean("initializeKey", false);
		table.putBoolean("grabberLevelSet", false);
		try {
			table.putValue("cameraFrame", CommandBase.camera.getImage());
		} catch (NIVisionException e) {
			System.out.println("axis camera getImage failed in setup()");
			e.printStackTrace();
		}
		
	}
	
	/**
	 * adds specified command group to the scheduler which is determined from the Smartdashboard inputs
	 * @param table
	 */
	public static void parameterSetup(NetworkTable table)
	{
		while(!table.getBoolean("initializeKey"))
		{
			if(table.getBoolean("DriveStraightForward"))
			{
				
			}
			else if(table.getBoolean("DriveSquare"))
			{
				table.putNumber("timeDrive", 0.0);
				table.putNumber("speedDrive", 0.0);
			}
		}
	}
	
	/**
	 * 
	 * @param table
	 */
	public static void init(NetworkTable table)
	{
		if(table.getBoolean("DriveStraightForward"))
		{
			Scheduler.getInstance().add(new DriveStraightForward(1,.5));
		}
		else if(table.getBoolean("DriveSquare"))
		{
			Scheduler.getInstance().add(new DriveSquare(table.getNumber("timeDrive"), table.getNumber("speedDrive"), 90));
		}
	}
	
	/**
	 * used in the periodic methods in robotMain for constant update of values that can be used for debugging purposes.
	 * @param table
	 */
	public static void update(NetworkTable table)
	{
		table.putNumber("frontLeft", DriveTrain.getInstance().getFrontLeft().get());
		table.putNumber("frontRight", DriveTrain.getInstance().getFrontRight().get());
		table.putNumber("backLeft", DriveTrain.getInstance().getBackLeft().get());
		table.putNumber("backRight", DriveTrain.getInstance().getBackRight().get());
		table.putNumber("GrabberLevel", Grabber.getInstance().levelCount);
		try {
			table.putValue("cameraFrame", CommandBase.camera.getImage());
		} catch (NIVisionException e) {
			System.out.println("axis camera getImage failed in update()");
			e.printStackTrace();
		}
	}
	
	
}



