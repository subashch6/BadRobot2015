package org.usfirst.frc.team1014.robot;

import java.io.File;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.usfirst.frc.team1014.logger.AllRobotData;
import org.usfirst.frc.team1014.logger.DriveTrainData;
import org.usfirst.frc.team1014.robot.commands.CommandBase;
import org.usfirst.frc.team1014.robot.commands.MikeDriveGroup;
import org.usfirst.frc.team1014.smartdashboard.Dashboard;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
//Axis Camera ip = 10.10.14.11, Username = root, Password = admin
public class Robot extends IterativeRobot {

	public static OI oi;
	//Serializer writer = new Persister();
	//File resultFile = new File("AllRobotData.xml");
	//public static DriveTrainData driveTrainData;
	//public static AllRobotData allRobotData;
    Command teleCommand;
    SendableChooser autoChooser;
    NetworkTable table = NetworkTable.getTable("SmartDashboard");

    /**
     * This function is run when the robot is first started up and should be
      * used for any initialization code.
     */
    public void robotInit() {
		
    	Dashboard.setup(table);
    	CommandBase.init(table);
    	//allRobotData = new AllRobotData(driveTrainData);
        // instantiate the command used for the autonomous period
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
    	//Scheduler.getInstance().add(new DriveSquare(.5, .2, 90));
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

        Scheduler.getInstance().add(new MikeDriveGroup());
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
        /*driveTrainData.update(CommandBase.driveTrain.getFrontLeft().get(), CommandBase.driveTrain.getFrontRight().get(),
    			CommandBase.driveTrain.getBackLeft().get(), CommandBase.driveTrain.getBackRight().get());
        allRobotData.update(driveTrainData);
        try {
			writer.write(allRobotData, resultFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/ 
        Dashboard.update(table);
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
