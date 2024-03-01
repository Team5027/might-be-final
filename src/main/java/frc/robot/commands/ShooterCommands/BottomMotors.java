// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.ShooterCommands;

import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;

public class BottomMotors extends Command {
  private final CANSparkMax l;
  private final CANSparkMax r;
  private final CANSparkMax b;
  private final Shooter s;
  private final Joystick j;
  // private final JoystickButton z;
  // private final double speed = 0.5;
  /** Creates a new ShootSpeaker. */
  public BottomMotors(Shooter s) {
    // this.z=z;
    this.s = s;
    this.l = s.getleftShooterMotor();
    this.r = s.getrightShooterMotor();
    this.b = s.getbottomShooterMotor();
    this.j = s.getcontroller();
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(s);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    SmartDashboard.putString("bottom motors", "starting");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SmartDashboard.putString("bottom motors", "executing");
    //SmartDashboard.putString("can u see me team", "executing");
    s.setshooterSpeed(-0.5);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    SmartDashboard.putString("bottom motors", "end");

    // s.setshooterSpeed(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    SmartDashboard.putString("bottom motors", "checking if finished");
    return true;
  }
}
