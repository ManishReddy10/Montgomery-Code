// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;


public class Drivetrain extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  public final WPI_TalonFX m_leftMaster;

  public final WPI_TalonFX m_rightMaster;

  public final WPI_TalonFX m_leftSlave;

  public final WPI_TalonFX m_rightSlave;

  private final MotorControllerGroup m_right;
  private final MotorControllerGroup m_left;
  private final DifferentialDrive m_diffDrive;

  public final AHRS m_navx;

  public Drivetrain() {
    m_leftMaster = new WPI_TalonFX(DriveConstants.dtFrontLeftPort);
    m_rightMaster = new WPI_TalonFX(DriveConstants.dtFrontRightPort);
    m_leftSlave = new WPI_TalonFX(DriveConstants.dtBackLeftPort);
    m_rightSlave = new WPI_TalonFX(DriveConstants.dtBackRightPort);

    m_rightMaster.setNeutralMode(NeutralMode.Brake);
    m_rightSlave.setNeutralMode(NeutralMode.Brake);
    m_leftMaster.setNeutralMode(NeutralMode.Brake);
    m_rightSlave.setNeutralMode(NeutralMode.Brake);

    m_right = new MotorControllerGroup(m_rightMaster, m_rightSlave);
    m_left = new MotorControllerGroup(m_leftMaster, m_leftSlave);
    m_diffDrive = new DifferentialDrive(m_left, m_right);

    m_left.setInverted(true);

    m_navx = new AHRS();
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public CommandBase exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }
  public double getEncoderMeters() {
    
    return m_leftMaster.getSelectedSensorPosition() * DriveConstants.encoderMetersPerTick;
    
}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    
  }

  public void setMotors(double leftSpeed, double rightSpeed) {
    m_left.set(-leftSpeed);
    m_right.set(-rightSpeed);
  }

  public void stopDriveMotors() {
    m_leftMaster.stopMotor();
    m_leftSlave.stopMotor();
    m_rightMaster.stopMotor();
    m_rightSlave.stopMotor();
  }

  public double getPitch() {
    return m_navx.getPitch();
  }

  public void resetGyro() {
    m_navx.reset();
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public void arcadeDrive(final double forward, final double turn) {
    m_diffDrive.arcadeDrive(forward * DriveConstants.driveSpeed, turn * DriveConstants.turnSpeed, true);
  }
}
