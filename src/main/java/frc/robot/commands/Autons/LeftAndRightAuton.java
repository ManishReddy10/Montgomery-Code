// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autons;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveForward;
import frc.robot.subsystems.Drivetrain;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class LeftAndRightAuton extends SequentialCommandGroup {
  /** Creates a new LeftAndRightAuton. */
  Drivetrain drive;
  public LeftAndRightAuton(Drivetrain drive) {
    this.drive = drive;
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
            new DriveForward(drive, 0.75, 0.5), 
            new DriveForward(drive, 0.5, 0),
            new DriveForward(drive, 0.75, - 0.5),
            new DriveForward(drive, 0.5,  0),
            new DriveForward(drive, 4,  0.6)
    );
  }
}

