package org.usfirst.frc.team1014.smartdashboard;

import org.usfirst.frc.team1014.robot.commands.autonomous.DriveSquare;
import org.usfirst.frc.team1014.robot.commands.autonomous.Turn180;
import org.usfirst.frc.team1014.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class Dashboard 
{
	/**
	 * used to put values into SmartDashboard
	 * @param table
	 */
	public static void setup(NetworkTable table)
	{
		table.putBoolean("180Turn", false);
		table.putBoolean("DriveSquare", false);
		table.putNumber("timeDrive", 0.0);
		table.putNumber("speedDrive", 0.0);
		table.putNumber("frontLeft", DriveTrain.getInstance().getFrontLeft().get());
		table.putNumber("frontRight", DriveTrain.getInstance().getFrontRight().get());
		table.putNumber("backLeft", DriveTrain.getInstance().getBackLeft().get());
		table.putNumber("backRight", DriveTrain.getInstance().getBackRight().get());
	}
	/**
	 * adds specified command group to the scheduler which is determined from the Smartdashboard inputs
	 * @param table
	 */
	public static void init(NetworkTable table)
	{
		if(table.getBoolean("180Turn"))
		{
			Scheduler.getInstance().add(new Turn180());
		}
		else if(table.getBoolean("DriveSquare"))
		{
			Scheduler.getInstance().add(new DriveSquare(table.getNumber("timeDrive"), table.getNumber("speedDrive"), 90));
		}
	}
	
	public static void update(NetworkTable table)
	{
		table.putNumber("frontLeft", DriveTrain.getInstance().getFrontLeft().get());
		table.putNumber("frontRight", DriveTrain.getInstance().getFrontRight().get());
		table.putNumber("backLeft", DriveTrain.getInstance().getBackLeft().get());
		table.putNumber("backRight", DriveTrain.getInstance().getBackRight().get());
	}
	
}



