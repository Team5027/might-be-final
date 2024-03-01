package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Climber;

public class ClimberCommand extends Command {

  public static Command JoystickButton(Climber climberSubsystem, Object object) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'JoystickButton'");
  }
  /*private final Climber climberSubsystem;
  private final double speed;

  public ClimberCommand(Climber climberSubsystem, double speed) {
    this.climberSubsystem = climberSubsystem;
    this.speed = speed;
    addRequirements(climberSubsystem);
  }

  @Override
  public void initialize() {
    System.out.println("ArmCommand started!");
  }

  @Override
  public void execute() {
    climberSubsystem.setMotor(speed);
  }

  @Override
  public void end(boolean interrupted) {
    climberSubsystem.setMotor(0);
    System.out.println("ArmCommand ended!");
  }

  @Override
  public boolean isFinished() {
    return false;
  }*/
}
