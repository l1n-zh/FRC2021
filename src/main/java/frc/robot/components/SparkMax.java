package frc.robot.components;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants.DriveConstants.Motor;

public class SparkMax {

    public static CANSparkMax factory (Motor motor){
        CANSparkMax controller = new CANSparkMax(motor.value, MotorType.kBrushed);
        controller.restoreFactoryDefaults();
        return controller;
    }

    public static CANSparkMax factory (Motor deviceID, MotorType type) {
        CANSparkMax controller = new CANSparkMax(Motor.kLeftFront.value, type);
        controller.restoreFactoryDefaults();
        return controller;
    }

}
