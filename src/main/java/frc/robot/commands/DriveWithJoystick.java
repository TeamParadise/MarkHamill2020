package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

/**
 *
 */
public class DriveWithJoystick extends CommandBase
{


    public DriveWithJoystick()
	{
		requires(Robot.mDriveTrain);
	}

	private void requires(Object mDriveTrain) {
        
    }

    @Override
    public void execute() {
        
    }

	@Override
    public boolean isFinished() {
        return false;
    }

	
}
