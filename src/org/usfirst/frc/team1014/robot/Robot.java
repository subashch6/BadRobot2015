package org.usfirst.frc.team1014.robot;

import java.io.IOException;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.vision.AxisCamera;

import org.usfirst.frc.team1014.robot.commands.CommandBase;
import org.usfirst.frc.team1014.robot.commands.DriveGroup;
import org.usfirst.frc.team1014.robot.commands.autonomous.AutoTurn;
import org.usfirst.frc.team1014.robot.commands.autonomous.DriveSquare;
import org.usfirst.frc.team1014.robot.commands.autonomous.DriveStraightForward;
import org.usfirst.frc.team1014.smartdashboard.Dashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;

    Command teleCommand;
    SendableChooser autoChooser;
    NetworkTable table = NetworkTable.getTable("SmartDashboard");
	public static AxisCamera camera = new AxisCamera("10.10.14.11");
    /**
     * This function is run when the robot is first started up and should be
      * used for any initialization code.
     */
    public void robotInit() {
    	
    	Dashboard.setup(table);
    	while(!table.getBoolean("grabberLevelSet"))
    	{
    		
    	}
    	CommandBase.init(table);
        // instantiate the command used for the autonomous period
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
    	Dashboard.parameterSetup(table);
    	Dashboard.init(table);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        Dashboard.update(table);
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.

        Scheduler.getInstance().add(new DriveGroup());
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}