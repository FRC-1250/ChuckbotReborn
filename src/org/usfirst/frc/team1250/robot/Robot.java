/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1250.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 * So Basically...
 * I made this :)
 */

public class Robot extends IterativeRobot {
	private DifferentialDrive m_myRobot;
	private Joystick m_leftStick;
	private Joystick m_rightStick;
	private WPI_TalonSRX m_rightMaster;
	private WPI_TalonSRX m_rightFollow1;
	private WPI_TalonSRX m_rightFollow0;
	private WPI_TalonSRX m_leftMaster;
	private WPI_TalonSRX m_leftFollow1;
	private WPI_TalonSRX m_leftFollow0;
	private SpeedController g_rightGroup;  
	private SpeedController g_leftGroup;

	@Override
	public void robotInit() {
		//Talons and ID here
		m_rightMaster = new WPI_TalonSRX(10);
		m_rightFollow1 = new WPI_TalonSRX(11);
		m_rightFollow0 = new WPI_TalonSRX(12);
		m_leftMaster = new WPI_TalonSRX(13);
		m_leftFollow1 = new WPI_TalonSRX(14);
		m_leftFollow0 = new WPI_TalonSRX(15);
		//Groups Here
		g_rightGroup = new SpeedControllerGroup(m_rightMaster,m_rightFollow1,m_rightFollow0);
		g_leftGroup = new SpeedControllerGroup(m_leftMaster,m_leftFollow1,m_leftFollow0);
		//Drivetype Defined here
		m_myRobot = new DifferentialDrive(g_rightGroup, g_leftGroup);
		//Joysticks here
		m_leftStick = new Joystick(0);
		m_rightStick = new Joystick(1);
	}

	@Override
	public void teleopPeriodic() {
		m_myRobot.tankDrive(m_leftStick.getY(), m_rightStick.getY());
	}
}
