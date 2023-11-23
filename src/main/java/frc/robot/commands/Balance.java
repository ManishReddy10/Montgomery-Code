package frc.robot.commands;


import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Constants.kBalancing;
import frc.robot.subsystems.Drivetrain;

public class Balance extends PIDCommand {

    private boolean isBalanced = false;


    private static double kP = kBalancing.kP;
    private static double kI = kBalancing.kI;
    private static double kD = kBalancing.kD;

    public Balance(Drivetrain drive) {
        
        super(
            new PIDController(kP, kI, kD),
            drive::getPitch,
            kBalancing.targetPitch,
            output -> drive.arcadeDrive(output, 0),
            drive
        );

        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(drive);


        getController().enableContinuousInput(-kBalancing.maxAngle, kBalancing.maxAngle);
        getController().setTolerance(kBalancing.angleTolerance);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }
    @Override
    public void execute() {
        super.execute();
        if (getController().atSetpoint()) {
            if (!isBalanced) {
                isBalanced = true;
            }
        } else {
            if (isBalanced) {
                isBalanced = false;
            }
        }
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
    // // Returns true when the command should end.
    // @Override
    // public boolean isFinished() {
    //     return getController().atSetpoint() && Math.abs(m_drivetrain.getLeftVelocity()) < 0.01;
    // }

}

/*REFERENCE: https://github.com/FRC5409/2023-Bishop/blob/main/src/main/java/frc/robot/commands/auto/OneConeOnePickupConeAuto.java */