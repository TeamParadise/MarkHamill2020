/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
//import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.XboxController;
//import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class DriveWithJoystick extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DriveTrain m_drive;
  private final Joystick m_joyStick ;
  
  /**
   * Creates a new DriveWithController.
   */
  public DriveWithJoystick(DriveTrain drive, Joystick joystick) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_drive = drive;
    m_joyStick = joystick;

    addRequirements(m_drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // Get data from the controller
    double move = m_joyStick.getY();
    double rotate = m_joyStick.getZ();
    DriverStation.reportError("LS:" + String.valueOf(m_drive.limitSwitch.get()), false);
    DriverStation.reportError("M "+String.valueOf(move), false);
    // DriverStation.reportError("R "+String.valueOf(rotate), false);
    
    // Process the data
    move = -move;

    // Tell the drive subsystem
   // m_drive.arcadeDrive(move, rotate);
    
  }


  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
  
}
