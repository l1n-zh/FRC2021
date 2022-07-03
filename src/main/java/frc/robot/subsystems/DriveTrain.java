package frc.robot.subsystems;


import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;

import frc.robot.components.SparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.I2C;
import static frc.robot.Constants.DriveConstants.*;

public class DriveTrain extends SubsystemBase {

  private final DifferentialDrive drive;
  private final CANSparkMax leftFrontMotor, leftRearMotor, rightFrontMotor, rightRearMotor;
  private final CANEncoder leftEncoder, rightEncoder;
  private final GearBox gearBox = new GearBox();
  private final AHRS gyro = new AHRS(I2C.Port.kOnboard);
  private final DifferentialDriveOdometry odometry;

  public DriveTrain() {
    leftFrontMotor  = SparkMax.getMotor(Motor.kLeftFront);
    leftRearMotor   = SparkMax.getMotor(Motor.kLeftRear);
    rightFrontMotor = SparkMax.getMotor(Motor.kRightFront);
    rightRearMotor  = SparkMax.getMotor(Motor.kRightRear);

    leftEncoder  = SparkMax.getEncoder(Motor.kLeftFront);
    rightEncoder = SparkMax.getEncoder(Motor.kRightFront);

    drive = new DifferentialDrive(
      new SpeedControllerGroup(leftFrontMotor, leftRearMotor),
      new SpeedControllerGroup(rightFrontMotor, rightRearMotor)
    );

    odometry = new DifferentialDriveOdometry(gyro.getRotation2d());
    initialize();
  }
  
  private void initialize(){
    gyro.reset();
    drive.setDeadband(0.05);
  }

  @Override
  public void periodic() {
    var pose = odometry.update(gyro.getRotation2d(), leftEncoder.getPosition(), rightEncoder.getPosition());
  }

  public void drive(double x, double y){
    drive.arcadeDrive(-x, y);
  }

  public void setMaxOutput(double maxOutput) {
    drive.setMaxOutput(maxOutput);
  }

  public void speedChange(GearBox.Gear gear) {
    gearBox.shift(gear);
  }

  public void speedChange(){
    gearBox.shift();
  }

}
