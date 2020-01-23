/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import frc.robot.commands.DriveWithJoystick;

public class DriveTrain extends SubsystemBase {
  // Random Numbers, do not work and might delete some
  // JM = Jedi Master PD = Padawan
  // Setting Up Speed Control Group
    Talon m_frontLeft = new Talon(RobotMap.LEFT_MASTER_DRIVE_TALON);
    Talon m_rearLeft = new Talon(RobotMap.LEFT_SLAVE_DRIVE_TALON);
    SpeedControllerGroup gb_left = new SpeedControllerGroup(m_frontLeft, m_rearLeft);
 
    Talon m_frontRight = new Talon(RobotMap.RIGHT_MASTER_DRIVE_TALON);
    Talon m_rearRight = new Talon(RobotMap.RIGHT_SLAVE_DRIVE_TALON);
    SpeedControllerGroup gb_right = new SpeedControllerGroup(m_frontRight, m_rearRight);
 
    DifferentialDrive m_drive = new DifferentialDrive(gb_left, gb_right);

    public DriveTrain(){
      
      //Talon mMarkLeftJM = new Talon(13);
      
      //mMarkLeftJM.close();
    }
      public void arcadeDrive(double xSpeed, double zRotation, boolean squaredInputs)
      {
      }
    
      public void tankDrive(double leftSpeed, double rightSpeed, boolean squaredInputs)
      {

      }
    
      public double getVelocity()
      {
        return 0;
        // return mRightMaster.getSensorCollection().getQuadratureVelocity() *
        // 10 * Math.PI * 6 / 4096;
      }
    
      public void resetEncoder()
      {
        //mRightMaster.getSensorCollection().setQuadraturePosition(0, 0);
      }
    
      public void initDefaultCommand()
    	{
		    // Set the default command for a subsystem here.
		    setDefaultCommand(new DriveWithJoystick());
	    }
    
      public void report()
      {
        //fill in later
      }
    
      @Override
      public void periodic() 
        {
    
        }
}

