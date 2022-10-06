// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class NOTDriveSubsystem extends SubsystemBase {
  TalonSRX lMotor = new TalonSRX(3);
  TalonSRX rMotor = new TalonSRX(4);

  public void setMotors(double lMotorSpeed, double rMotorSpeed, Boolean isSpeedMode) {
    System.out.println(isSpeedMode);
    if (isSpeedMode) {
      lMotor.set(TalonSRXControlMode.PercentOutput, lMotorSpeed*0.35);
      rMotor.set(TalonSRXControlMode.PercentOutput, rMotorSpeed*0.35);
    } else {
      lMotor.set(TalonSRXControlMode.PercentOutput, lMotorSpeed*0.25);
      rMotor.set(TalonSRXControlMode.PercentOutput, rMotorSpeed*0.25);
    }
  }

  /** Creates a new ExampleSubsystem. */
  public NOTDriveSubsystem() {
  
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}