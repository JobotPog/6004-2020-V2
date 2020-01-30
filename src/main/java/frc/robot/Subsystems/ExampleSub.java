/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/


/*----------------------------------
Import all packages here
*/

package frc.robot.Subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.Commands.*;

/*----------------------------------
Create your subsytem name here.
IT MUST BE THE SAME NAME AS THE JAVA FILE!
*/

public class ExampleSub extends Subsystem {
    
    /*----------------------------------
    Create any motor controller inits here
    eg VictorSPX myvictor = new VictorSPX(RobotMap.myvictor);
    */


    /*----------------------------------
    This is the INIT call for this subsystem.
    You MUST delcaire things here that survive the first call 
    for the robot init.  
    eg _leftMaster.configFactoryDefault();        
    */
    public ExampleSub(){
      //System.out.print("init this subsystem");
    }


    /*----------------------------------
    Use this for things that typically take controller input
    or must do a "thing" when the robot inits.
    Not always needed
    */
    @Override
    public void initDefaultCommand() {
     // System.out.println("default command");      

       setDefaultCommand(new ExampleCmd());
    }
  

    /*----------------------------------
    Put your "do action" functions here
    eg drive, shoot, climb
    */
  
    public void doaction() {
    // Update motor speed to passed in value    
    // _drive.arcadeDrive(-forward, turn);
    }

        
  }