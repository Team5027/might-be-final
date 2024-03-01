// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.ShooterCommands;

import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;

public class StopBottomMotors extends Command {

  private final CANSparkMax m;
  private final Shooter s;

  /** Creates a new ShooterUp. */
  public StopBottomMotors(Shooter s) {
    this.s = s;
    this.m = s.getshooterPivot();
    addRequirements(s);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    SmartDashboard.putString(" stopping bottom motors", "starting");

    // m.set(0.5);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SmartDashboard.putString(" stopping bottom motors", "executing");
    //SmartDashboard.putString("can u see me team2", "executing");
    s.setshooterSpeed(0.0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    SmartDashboard.putString(" stopping bottom motors", "finished");

    // s.setshooterSpeed(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    SmartDashboard.putString(" stopping bottom motors", "checking if finished");

    return true;
  }
}
