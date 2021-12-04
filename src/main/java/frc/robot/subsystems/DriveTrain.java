package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class DriveTrain extends SubsystemBase {

  private final DifferentialDrive drive;

  public DriveTrain () {
    SpeedControllerGroup leftMotors = new SpeedControllerGroup(
      new WPI_VictorSPX(DriveConstants.kLeftFrontMotorChannel),
      new WPI_VictorSPX(DriveConstants.kLeftRearMotorChannel)
    );
    SpeedControllerGroup rightMotors = new SpeedControllerGroup(
      new WPI_VictorSPX(DriveConstants.kRightFrontMotorChannel),
      new WPI_VictorSPX(DriveConstants.kRightRearMotorChannel)
    );
    this.drive = new DifferentialDrive(leftMotors, rightMotors);
  }


  public void arcadeDrive(double fwd, double rot) {
    drive.arcadeDrive(fwd, rot);
    drive.feed();
  }

  public void setMaxOutput(double maxOutput) {
    drive.setMaxOutput(maxOutput);
  }
}