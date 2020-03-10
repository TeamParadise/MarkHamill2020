/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ColorSensor extends SubsystemBase {
  /**
   * Creates a new ColorSensor.
   */
  private final I2C.Port i2cPort = I2C.Port.kOnboard;

  private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);

  private String lastcolor = "None";
  public int colorcount = 0;
  
  public ColorSensor() {
  
  }

  public boolean isYellow()
  {
    Color detectedColor = m_colorSensor.getColor();
    return (detectedColor.red > 0.3 && detectedColor.green > 0.5);
  }

  public boolean isRed()
  {
    Color detectedColor = m_colorSensor.getColor();
    return (detectedColor.red > detectedColor.green && detectedColor.red > detectedColor.blue && !isYellow());
  }

  public boolean isGreen()
  {
    Color detectedColor = m_colorSensor.getColor();
    return (detectedColor.green > detectedColor.red && detectedColor.green > detectedColor.blue && !isYellow());
  }

  public boolean isBlue()
  {
    Color detectedColor = m_colorSensor.getColor();
    return (detectedColor.blue > detectedColor.red && detectedColor.blue > detectedColor.green);
  }

  public String sColor()
  {
    if (isRed())
      return("Red");
    else if (isBlue())
      return("Blue");
    else if (isGreen())
      return("Green");
    else if (isYellow())
      return("Yellow");
    else return ("Huh?");
  }

  public String sRGB()
  {
    Color detectedColor = m_colorSensor.getColor();
    return String.valueOf(detectedColor.red) + "," + String.valueOf(detectedColor.green) + "," + String.valueOf(detectedColor.blue);
  }
  
  public boolean isClose()
  {
    int proximity = m_colorSensor.getProximity();
    return(proximity > 1000);
  }

  public String sIsClose()
  {
    return String.valueOf(isClose());
  }

  public void resetColor()
  {
    colorcount = 0;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    if (lastcolor != sColor())
    {
      lastcolor = sColor();
      colorcount++;
    }

    DriverStation.reportError(sColor() + /*"," + sRGB() +*/ ", " + sIsClose() + "," + String.valueOf(colorcount), false);


    
  }
}
