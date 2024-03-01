// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.ShooterCommands;

import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;

public class ShooterUp extends Command {
  private final Double targetAngle = (-45.0 + 16.0);
  private final Double marginOfError = 2.0;

  private static int countRan = 0;

  private final CANSparkMax m;
  private final Shooter s;

  /** Creates a new ShooterUp. */
  public ShooterUp(Shooter s) {
    this.s = s;
    this.m = s.getshooterPivot();
    addRequirements(s);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    SmartDashboard.putString("shooter up", "starting");
    // m.set(0.5);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SmartDashboard.putString("shooter up", "executing loop " + countRan++);

    s.setshooterSpeed(-0.5);
    if (s.getshooterPivot().getEncoder().getPosition() <= targetAngle - marginOfError) {
      SmartDashboard.putString(
          "shooter do", "go up" + s.getshooterPivot().getEncoder().getPosition());
      s.setpivotShooterSpeed(-0.1);
    } else if (s.getshooterPivot().getEncoder().getPosition() >= targetAngle + marginOfError) {
      SmartDashboard.putString(
          "shooter do", "go down" + s.getshooterPivot().getEncoder().getPosition());
      s.setpivotShooterSpeed(0.1);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    SmartDashboard.putString("shooter up", "finished" + countRan);

    SmartDashboard.putString(
        "shooter do", "stay put" + s.getshooterPivot().getEncoder().getPosition());
    // s.setpivotShooterSpeed(0.0);
  }
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    SmartDashboard.putString("shooter up", "checking if finished" + countRan);
    if ((s.getshooterPivot().getEncoder().getPosition() <= targetAngle + marginOfError)
        && (s.getshooterPivot().getEncoder().getPosition() >= targetAngle - marginOfError)) {
      return true;
    } else {
      return false;
    }
  }
}
