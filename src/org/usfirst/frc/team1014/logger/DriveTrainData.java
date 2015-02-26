package org.usfirst.frc.team1014.logger;

import org.simpleframework.xml.Element;

public class DriveTrainData 
{
	@Element (name = "frontLeftTalonSpeed")
	private double frontLeftTalonSpeed;
	
	@Element (name = "frontRightTalonSpeed")
	private double frontRightTalonSpeed;
	
	@Element (name = "backLeftTalonSpeed")
	private double backLeftTalonSpeed;
	
	@Element (name = "backRightTalonSpeed")
	private double backRightTalonSpeed;
	/**
	 * This is what assigns the values to the xml file parser.
	 * @param frontLeftTalonSpeed
	 * @param frontRightTalonSpeed
	 * @param backLeftTalonSpeed
	 * @param backRightTalonSpeed
	 */
	public DriveTrainData(double frontLeftTalonSpeed, double frontRightTalonSpeed, double backLeftTalonSpeed, double backRightTalonSpeed)
	{
		this.frontLeftTalonSpeed = frontLeftTalonSpeed;
		this.frontRightTalonSpeed = frontRightTalonSpeed;
		this.backLeftTalonSpeed = backLeftTalonSpeed;
		this.backRightTalonSpeed = backRightTalonSpeed;
	}
	public void update(double frontLeftTalonSpeed, double frontRightTalonSpeed, double backLeftTalonSpeed, double backRightTalonSpeed)
	{
		this.frontLeftTalonSpeed = frontLeftTalonSpeed;
		this.frontRightTalonSpeed = frontRightTalonSpeed;
		this.backLeftTalonSpeed = backLeftTalonSpeed;
		this.backRightTalonSpeed = backRightTalonSpeed;
	}
}
