// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.IntakeCommands;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;

public class IntakePivot extends Command {
  private final CANSparkMax pivotMotor;
  private final RelativeEncoder intakeP;
  private final Intake intake;
  private final Joystick j;

  /** Creates a new IntakePivot. */
  public IntakePivot(Intake i) {
    this.intake = i;
    this.pivotMotor = i.getintakePivotMotor();
    this.intakeP = i.getintakePivotMotor().getEncoder();
    this.j = i.getcontroller();

    this.intakeP.setPositionConversionFactor(1.0);
    // this.intakeP.reset();
    addRequirements(i);
    // this.intakeP.setPositionConversionFactor(360.0);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // p.set(0.3);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // SmartDashboard.putNumber(
    //     "Intake Pivot Encoder Position", intakeP.getPositionConversionFactor());

    if (intake.getisForward()) {
      intake.getintakePivotMotor().set(-intake.getspeed());
    } else {
      intake.getintakePivotMotor().set(intake.getspeed());
    }

    SmartDashboard.putBoolean("current front limit", !intake.getfrontLimit().get());
    SmartDashboard.putBoolean("current back limit", !intake.getbackLimit().get());
    SmartDashboard.putNumber("current speed", intake.getspeed());
    SmartDashboard.putNumber(
        "intake encoder", intake.getintakePivotMotor().getEncoder().getPositionConversionFactor());

    // inverted help me
    if (!intake.getfrontLimit().get() && intake.getisForward()) {
      intake.setspeed(0);
      intake.setisForward(false);
      //  new IntakeFrontLimit(i);
    } else if (!intake.getbackLimit().get() && !intake.getisForward()) {
      intake.setspeed(0);
      intake.setisForward(true);
      // new IntakeBackLimit(i);
    }

    if (j.getRawButtonPressed(2)) {
      intake.setspeed(0.5);
    } else {
      // p.setIdleMode(IdleMode.kBrake);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intake.setspeed(0.0);
  }

  // Returns true when the command should end.//
  @Override
  public boolean isFinished() {
    return true;
  }
}
