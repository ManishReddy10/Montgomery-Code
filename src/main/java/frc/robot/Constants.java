// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static final class DriveConstants {
    //ports for drivetrain
    public static final int dtFrontLeftPort = 1;
    public static final int dtBackLeftPort = 2;
    public static final int dtFrontRightPort = 3;
    public static final int dtBackRightPort = 4;
    
    public static final double distancePerRevolution = 5.0893801; 
    /**  meters (This is just the circumference need to figure out actual distance per revolution accounting for gearbox)  */
    
    public static final int ticksPerRevolution = 2048;
    public static final double encoderMetersPerTick = distancePerRevolution / ticksPerRevolution; //0.00248504888 At the moment


    public static final double driveSpeed = 0.7;
    public static final double turnSpeed = 0.7;
    

    public static final double kAutoDriveForwardSpeed = 0.5;
    public static final double kAutoDriveForwardDistance = 1.5;
  }
  
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }

  public static final class kBalancing {
    public static final double targetPitch                  = 0;
    public static final double maxAngle                     = 33.25;
    public static final double angleTolerance               = 1.5;

    public static final double kP                           = 0.0318; //0.0319 from newmarket
    public static final double kI                           = 0;
    public static final double kD                           = 0;
}

}
