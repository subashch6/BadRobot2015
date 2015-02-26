package org.usfirst.frc.team1014.robot.commands;

import edu.wpi.first.wpilibj.command.Command;





import edu.wpi.first.wpilibj.networktables.NetworkTable;




import org.usfirst.frc.team1014.logger.DriveTrainData;
//import MikeDriveTrain;
import org.usfirst.frc.team1014.robot.OI;
import org.usfirst.frc.team1014.robot.Robot;
import org.usfirst.frc.team1014.robot.RobotMap;
import org.usfirst.frc.team1014.robot.subsystems.Grabber;
import org.usfirst.frc.team1014.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1014.robot.subsystems.PancakeArm;
import org.usfirst.frc.team1014.robot.subsystems.WinchLift;

public abstract class CommandBase extends Command {
    public static OI oi;
    
    public static DriveTrain driveTrain;
    public static Grabber grabber;
    public static WinchLift winchLift;
    public static PancakeArm pancake;
    
    public static void init(NetworkTable table) {
        //Final Subsystems
    	
    	driveTrain = DriveTrain.getInstance();
    	grabber = Grabber.getInstance((int) table.getNumber("grabberLevel", 0));
    	winchLift = WinchLift.getInstance();
    	pancake = PancakeArm.getInstance();
    	//Robot.driveTrainData = new DriveTrainData(driveTrain.getFrontLeft().get(), driveTrain.getFrontRight().get(),
    			driveTrain.getBackLeft().get(), driveTrain.getBackRight().get());
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move i
        OI.init();

        // Show what command your subsystem is running on the SmartDashboard
        //SmartDashboard.putData(exampleSubsystem);
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
    
    protected abstract void initialize();
        
    
    public abstract String getConsoleIdentity();

}
