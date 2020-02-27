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
import frc.robot.Commands.*;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveTrain extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public WPI_TalonFX _leftMaster = new WPI_TalonFX(RobotMap.DRIVETRAIN_LEFT_FRONT);
    public WPI_TalonFX _rightMaster = new WPI_TalonFX(RobotMap.DRIVETRAIN_RIGHT_FRONT);
    public WPI_TalonFX  _leftFollow = new WPI_TalonFX (RobotMap.DRIVETRAIN_LEFT_BACK);
    public WPI_TalonFX  _rightFollow = new WPI_TalonFX (RobotMap.DRIVETRAIN_RIGHT_BACK);
    public DifferentialDrive _drive = new DifferentialDrive(_leftMaster, _rightMaster);
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
     System.out.print("init drivetrain");
    }

    @Override
    public void initDefaultCommand() {
     // System.out.println("default command");      

       setDefaultCommand(new ArcadeDrive());
    }
  
  
      public void driveAround() {
        // Update motor speed to passed in value
        
       // _drive.arcadeDrive(-forward, turn);
      }

      public void arcadeDrive(double speed, double turn){
        //System.out.println(speed);
        _drive.arcadeDrive(-speed, turn);
      }
        
  }