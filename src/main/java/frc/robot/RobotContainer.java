/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
//import frc.robot.subsystems.FakeSubsystem;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.RobotShooter;
import frc.robot.subsystems.ColorSensor;
import frc.robot.subsystems.DriveTrain;


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  
  //private final FakeSubsystem m_fake = new FakeSubsystem();
  public DriveTrain m_drive;
  public static Joystick m_Joystick;
  public ColorSensor m_colorSensor;
  private final Shooter m_shooter = new Shooter();
  public static int reportinterval = 50;
  
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    m_drive = new DriveTrain();
    m_colorSensor = new ColorSensor();
    
    

    // Set default commands
    //m_drive.setDefaultCommand(new DriveWithController(m_drive, m_joystick));
    //m_drive.m_RearRightTalon.set(1);
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link Joystick}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    m_Joystick = new Joystick(Constants.kControllerDriver);
    
    // Configure out shooter buttons
    
    RobotShooter m_RobotShooter = new RobotShooter(m_shooter);
    new JoystickButton(m_Joystick, Constants.IntakeBall).whileHeld(m_RobotShooter);
    new JoystickButton(m_Joystick), Constants.Outtake).whileheld(m_RobotShooter);
    //new JoystickButton(m_Joystick, Constants.IntakeBall).whenReleased(m_RobotShooter.end(false));
    //new JoystickButton(m_Joystick, ).whenPressed(m_RobotShooter);
    //new JoystickButton(m_Joystick, ).cancelWhenPressed(m_RobotShooter);

    /*
    // Set a random number when pressed, set to 0 when released
    new JoystickButton(m_controller, Button.kA.value)
        .whenPressed(() -> m_fake.setRandomNumber())
        .whenReleased(() -> m_fake.stopRandomNumber());

    // Set a random number when pressed, set to 0 when released
    new JoystickButton(m_controller, Button.kB.value)
        .whenPressed(() -> m_fake.setState("B Pressed"))
        .whenReleased(() -> m_fake.setState(""));
    */
    }

  public static double getYSpeed()
  {
    if (Math.abs(m_Joystick.getRawAxis(0)) >= .2) 
    {
    //m_Joystick.putNumber("Yaxis", m_Joystick.getRawAxis(1));
    return (m_Joystick.getRawAxis(0));
    }
    return 0.0;
  }
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
