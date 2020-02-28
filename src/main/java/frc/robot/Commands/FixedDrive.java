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
import edu.wpi.first.wpilibj.RobotController;

/**
 * An example command.  You can replace me with your own command.
 */
public class FixedDrive extends Command {
  
  public static Boolean reverse;
  private double m_timeout;

  public FixedDrive(double timeout) {
    // Use requires() here to declare subsystem dependencies
    m_timeout = timeout;
    requires(Robot.driveSub);
    System.out.println("run back init");
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.driveSub.initDefaultCommand();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    System.out.println("aracde command");
    //long millisecondsToRun = 2; // This should run 1000ms = 1 s.
    long initTime = RobotController.getFPGATime();
    while (RobotController.getFPGATime() - initTime <= m_timeout){
        // Place your code here.
        System.out.println("run back to thing");
        Robot.driveSub.arcadeDrive(.15, 0);
    }

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
