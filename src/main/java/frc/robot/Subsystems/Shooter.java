/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/


package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import frc.robot.RobotMap;
import frc.robot.Commands.*;
import com.ctre.phoenix.motorcontrol.ControlMode;


/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Shooter extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
      VictorSPX ShooterSPX = new VictorSPX(RobotMap.SHOOTER);
  
    @Override
    public void initDefaultCommand() {
      // Set the default command for a subsystem here.
       setDefaultCommand(new ShooterAxis());
    }
  
  
      public void update(double p_val) {
        // Update motor speed to passed in value
        ShooterSPX.set(ControlMode.PercentOutput,p_val);
      }
  
  }

