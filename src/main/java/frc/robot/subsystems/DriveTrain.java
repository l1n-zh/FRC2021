package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.components.SparkMax;
import edu.wpi.first.wpilibj.SpeedController;

import static frc.robot.Constants.DriveConstants.*;

public class DriveTrain extends SubsystemBase {

  private final DifferentialDrive drive;
  private final SpeedController leftFrontMotor, leftRearMotor, rightFrontMotor, rightRearMotor;
  private final GearBox gearBox = new GearBox();


  public DriveTrain() {
    leftFrontMotor = SparkMax.factory(Motor.kLeftFront);
    leftRearMotor = SparkMax.factory(Motor.kLeftRear);
    rightFrontMotor = SparkMax.factory(Motor.kRightFront);
    rightRearMotor = SparkMax.factory(Motor.kRightRear);

    drive = new DifferentialDrive(
      new SpeedControllerGroup(leftFrontMotor, leftRearMotor),
      new SpeedControllerGroup(rightFrontMotor, rightRearMotor)
    );
  }

  @Override
  public void periodic() {
  }

  public void drive(double fwd, double rot){
    drive.arcadeDrive(-fwd/2, rot/2);
  }

  public void setMaxOutput(double maxOutput) {
    drive.setMaxOutput(maxOutput);
  }

  public void speedChange(GearBox.Gear gear) {
    gearBox.shift(gear);
  }

}
