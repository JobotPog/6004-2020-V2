/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  public Joystick _driver = new Joystick(RobotMap.OI_DRIVER_CONTROLLER); 
  public XboxController _operator = new XboxController(RobotMap.OI_OP_CONTROLLER);
  public XboxController _squishy = new XboxController(RobotMap.OI_SQUISHY);

  
public Button LADDriveFwd = new JoystickButton(_operator, 6);
public Button LADHold = new JoystickButton(_operator, 5);
public Button LADRearHold = new JoystickButton(_operator, 3);
public Button LADUpdateAll = new JoystickButton(_operator, 4);

public Button Button5 = new JoystickButton(_driver,5);
public Button Button3 = new JoystickButton(_driver,3);
public Button Button4 = new JoystickButton(_driver,4);
public Button Button6 = new JoystickButton(_driver,6);
public Button Button2 = new JoystickButton(_driver,2);

  public OI () {
    Button5.whileHeld(new PivotCmd(15));
    Button3.whileHeld(new PivotCmd(-15));

    Button4.whileHeld(new ElevatorCmd(15));
    Button6.whileHeld(new ElevatorCmd(-15));

    Button2.whileHeld(new IntakeCmd(10));


    
  }
}
