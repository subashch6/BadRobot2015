package org.usfirst.frc.team1014.smartdashboard;
import org.usfirst.frc.team1014.robot.commands.autonomous.AutoTurn;
import org.usfirst.frc.team1014.robot.commands.autonomous.DriveStraightForward;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public  class Dashboard 
{
	public static void update(SendableChooser chooser)
	{
		chooser.addDefault("DriveForward", new DriveStraightForward(1,.5));
		chooser.addObject("Turn", new AutoTurn(360));
		SmartDashboard.putData("chooser", chooser);
	}
	
}
