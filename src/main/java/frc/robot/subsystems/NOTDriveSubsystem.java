// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
// import software ultrasonics
import edu.wpi.first.wpilibj.Ultrasonic;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class NOTDriveSubsystem extends SubsystemBase {
  TalonSRX lMotor = new TalonSRX(3);
  TalonSRX rMotor = new TalonSRX(4);
  Ultrasonic m_ultrasonic = new Ultrasonic(4, 5);
  double error = 0;
  double target = 1000; //mm
  double k = 0.000001;
  double speed = 0;

  public void setMotors(double lMotorSpeed, double rMotorSpeed, Boolean isSpeedMode) {
    m_ultrasonic.setAutomaticMode(true);

    double dist = m_ultrasonic.getRangeMM();
    error = target - dist;
    speed = k * error;
    
    System.out.println("Distance: " + dist + "\nSpeed: " + speed);

    if (isSpeedMode) {
      lMotor.set(TalonSRXControlMode.Velocity, speed);
      rMotor.set(TalonSRXControlMode.Velocity, speed);
    } else {
      lMotor.set(TalonSRXControlMode.Velocity, speed);
      rMotor.set(TalonSRXControlMode.Velocity, speed);
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