package frc.robot.commands;

import frc.robot.Constants.DriveConstants;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveForwardCmd extends CommandBase {
    private final Drivetrain drivetrain;
    private final double distance;
    private double initialPosition;
    Timer timer = new Timer();
    private double seconds;

    public DriveForwardCmd(Drivetrain driveSubsystem, double distance) {
        this.drivetrain = driveSubsystem;
        this.distance = distance;
        addRequirements(driveSubsystem);
    }

    @Override
    public void initialize() {
        timer.start();
        initialPosition = drivetrain.getEncoderMeters();
        System.out.println("DriveForwardCmd started!");
    }

    @Override
    public void execute() {
        drivetrain.setMotors(DriveConstants.kAutoDriveForwardSpeed, DriveConstants.kAutoDriveForwardSpeed);
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.setMotors(0, 0);
        System.out.println("DriveForwardCmd ended!");
    }

    @Override
    public boolean isFinished() {
        double currentPosition = drivetrain.getEncoderMeters();
        double traveledDistance = currentPosition - initialPosition;
        return traveledDistance >= distance;
    }
}
