package org.usfirst.frc.team1014.logger;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class AllRobotData 
{
	@Element (name = "driveTrainData")
	private DriveTrainData driveTrainData;
	
	public AllRobotData(DriveTrainData driveTrainData)
	{
		this.driveTrainData = driveTrainData;
	}
	public void update(DriveTrainData driveTrainData)
	{
		this.driveTrainData = driveTrainData;
	}
	
}

