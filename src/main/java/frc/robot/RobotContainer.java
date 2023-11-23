// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.DriveConstants;
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.Balance;
import frc.robot.commands.DriveForwardCmd;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.Autons.LeftAndRightAuton;
import frc.robot.commands.DriveForward;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  private final Drivetrain m_drivetrainAuton = new Drivetrain();
  

  

  // The robot's subsystems and commands are defined here...
  private final Drivetrain m_drivetrain = new Drivetrain();
  private final XboxController m_drivercontroller = new XboxController(0);

  // Replace with CommandPS4Controller or CommandJoystick if needed

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {


    m_drivetrain.setDefaultCommand(new RunCommand(() ->
    m_drivetrain.arcadeDrive(
      -m_drivercontroller.getLeftY(), -m_drivercontroller.getRightX()), m_drivetrain));
    

    // Configure the trigger bindings
    configureBindings();
    
    
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    new Trigger(m_drivetrain::exampleCondition)
        .onTrue(new ExampleCommand(m_drivetrain));
    
    // private final Command C_DriveForward = new InstantCommand( () -> DriveForward() );

    

    // Schedule `exampleMethodComman  d` when the Xbox controller's B button is pressed,
    // cancelling on release.
   // m_drivercontroller.b().whileTrue(m_drivetrain.exampleMethodCommand());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */ 
  public Command getAutonomousCommand() {
    
    
    return new SequentialCommandGroup( //
            // new DriveForward(m_drivetrain, 0.75, 0.5), 
            // new DriveForward(m_drivetrain, 0.5, 0),
            // new DriveForward(m_drivetrain, 0.75, - 0.5),
            // new DriveForward(m_drivetrain, 0.5,  0),
            // new DriveForward(m_drivetrain, 4,  0.6)

            // new LeftAndRightAuton(m_drivetrain) 
            // YESSSS
            // new Balance(m_drivetrain)
            // YESSSSS
            // new DriveForward(m_drivetrain, 4.2, 0.4)

            //17 inches for 0.4 speed on 1 second
            // 34.25 inches for 0.5
            // 53 inches for 0.6 speed
            // new DriveForward(m_drivetrain, 1, 0.4)
            //76 in till community line tape
            //272.36in till borderline
            
    );


}
}
