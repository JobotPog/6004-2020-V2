/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.OI;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;


import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.*;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveTrain extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    WPI_TalonFX _leftMaster = new WPI_TalonFX(RobotMap.DRIVETRAIN_LEFT_FRONT);
    WPI_TalonFX _rightMaster = new WPI_TalonFX(RobotMap.DRIVETRAIN_RIGHT_FRONT);
    WPI_TalonFX  _leftFollow = new WPI_TalonFX (RobotMap.DRIVETRAIN_LEFT_BACK);
    WPI_TalonFX  _rightFollow = new WPI_TalonFX (RobotMap.DRIVETRAIN_RIGHT_BACK);
    DifferentialDrive _drive = new DifferentialDrive(_leftMaster, _rightMaster);
    public static OI m_oi;

    public DriveTrain(){
      // Set the default command for a subsystem here.
      _leftMaster.configFactoryDefault();
      _rightMaster.configFactoryDefault();
      _leftFollow.configFactoryDefault();
      _rightFollow.configFactoryDefault();
      
      _leftFollow.follow(_leftMaster);
      _rightFollow.follow(_rightMaster);
      
      _leftMaster.setInverted(false); // <<<<<< Adjust this until robot drives forward when stick is forward
      _rightMaster.setInverted(true); // <<<<<< Adjust this until robot drives forward when stick is forward
      _leftFollow.setInverted(InvertType.FollowMaster);
      _rightFollow.setInverted(InvertType.FollowMaster);
      _drive.setRightSideInverted(false); // do not change this
     //setDefaultCommand(new liftAxis());
    }

    @Override
    public void initDefaultCommand() {
      

       driveAround();
    }
  
  
      public void driveAround() {
        // Update motor speed to passed in value
        double forward = 1 * m_oi._driver.getY();
        double turn = m_oi._driver.getTwist();
  
        _drive.arcadeDrive(-forward, turn);
      }
        
  }