/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class DriveTrain extends SubsystemBase {
  //#region Hardware
  public final WPI_TalonSRX m_FrontLeftTalon = new WPI_TalonSRX(Constants.kFrontLeftDriveTalon);
  public final WPI_TalonSRX m_FrontRightTalon = new WPI_TalonSRX(Constants.kFrontRigthDriveTalon);;
  public final WPI_TalonSRX m_RearLeftTalon = new WPI_TalonSRX(Constants.kRearRightDriveTalon);
  public final WPI_TalonSRX m_RearRightTalon = new WPI_TalonSRX(Constants.kRearLeftDriveTalon);
  public final DifferentialDrive m_DriveTrain;
  public SpeedControllerGroup m_LeftDrive = new SpeedControllerGroup(m_FrontLeftTalon, m_RearLeftTalon); 
  public SpeedControllerGroup m_RightDrive = new SpeedControllerGroup(m_FrontRightTalon, m_RearRightTalon);;
  

  //#endregion

  /**
   * Creates a new Drive.
   */
  public DriveTrain() {

    m_DriveTrain = new DifferentialDrive(m_LeftDrive , m_RightDrive);

    m_DriveTrain.setSafetyEnabled(false); 
    m_FrontLeftTalon.setSafetyEnabled(false);
    m_RearLeftTalon.setSafetyEnabled(false);
    m_FrontRightTalon.setSafetyEnabled(false);
    m_RearRightTalon.setSafetyEnabled(false);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    //m_RearLeftTalon.set(1);
    double speed = RobotContainer.m_Joystick.getY();
    double twist = RobotContainer.m_Joystick.getX();
    
    //m_RearRightTalon.set(speed);
    m_DriveTrain.arcadeDrive(speed , twist);
    double tspeed = m_RearRightTalon.getMotorOutputPercent();
   
    DriverStation.reportWarning(Double.toString(tspeed) + " " + Double.toString(twist), false);
  }

  /**
   * Drive using arcade drive joystick
   * @param move The speed and direction to move
   * @param rotate The speed and direction to rotate
   */
  public void arcadeDrive(double move, double rotate) {
    m_DriveTrain.arcadeDrive(move, rotate, false);
  }

  /**
   * Stop the drive from moving
   */
  public void stop() {
    //m_drive.stopMotor();
  }

public static void m_drive() {
}
}
