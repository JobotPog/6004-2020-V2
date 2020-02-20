/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Commands;
import frc.robot.OI;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.networktables.*;
//NAVX
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.controller.PIDController;


/**
 * An example command.  You can replace me with your own command.
 */
public class ArcadeDrive extends Command {
  private boolean driverVision, tapeVision, cargoVision, cargoSeen, tapeSeen   ;
  private NetworkTableEntry tapeDetected, cargoDetected, tapeYaw, cargoYaw, videoTimestamp, driveWanted,tapeWanted,cargoWanted;
  private double targetAngle;
  NetworkTableInstance instance;
  NetworkTable chickenVision;
  boolean autoBalanceXMode;
  boolean autoBalanceYMode;
  static final double kOffBalanceAngleThresholdDegrees = 10;
  static final double kOonBalanceAngleThresholdDegrees = 5;
  //NAVX
  AHRS ahrs;
  double rotateToAngleRate;
  PIDController turnController;
  static final double kP = 0.03;
  static final double kI = 0.00;
  static final double kD = 0.00;
  static final double kF = 0.00;
  static final double kToleranceDegrees = 2.0f;

  public ArcadeDrive() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.driveSub);

    try {
        /* Communicate w/navX-MXP via the MXP SPI Bus.                                     */
        /* Alternatively:  I2C.Port.kMXP, SerialPort.Port.kMXP or SerialPort.Port.kUSB     */
        /* See http://navx-mxp.kauailabs.com/guidance/selecting-an-interface/ for details. */
        ahrs = new AHRS(SPI.Port.kMXP); 
    } catch (RuntimeException ex ) {
      System.out.println("Error instantiating navX-MXP:  " + ex.getMessage());
    }


  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.driveSub.initDefaultCommand();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //System.out.println("aracde command");
    System.out.println("arcade drive called");
    boolean driveslow = Robot.m_oi._driver.getRawButton(1);
    double forward = 1 * Robot.m_oi._driver.getY();
    double turn = Robot.m_oi._driver.getTwist();

    //This code is all about vision tracking!!!
    // If button 1 is pressed, then it will track cargo
    if (driveslow) {
      //slow down inputs for better control
      if(forward > .45) forward=.45;
      if(forward < -.45) forward=-.45;
      if(turn > .45) turn=.55;
      if(turn < -.45) turn=-.55;

    } else  {
      //leave inputs be and don't adjust


    }

    Robot.driveSub.arcadeDrive(forward, turn);

        
  //System.out.println("command call");
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
