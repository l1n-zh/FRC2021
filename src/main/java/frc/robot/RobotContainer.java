// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import frc.robot.Constants.*;
import static edu.wpi.first.wpilibj.XboxController.Button;


public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveTrain driveTrain = new DriveTrain();

  private final XboxController driverController = new XboxController(OIConstants.kDriverControllerPort);

  private Command autoCommand;
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    driveTrain.setDefaultCommand(
      new RunCommand(
          () ->
          driveTrain.drive(
                  driverController.getX(Hand.kLeft), driverController.getY(Hand.kLeft)),
                  driveTrain));
  }
  
  private void configureButtonBindings() {
  
    new JoystickButton(driverController, Button.kStickLeft.value)
    .whenPressed(() -> driveTrain.speedChange());
    new JoystickButton(driverController, Button.kBumperRight.value);
  }


  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return autoCommand;
  }
}
