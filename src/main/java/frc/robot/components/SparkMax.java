package frc.robot.components;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants.DriveConstants.Motor;

public class SparkMax {

    public static CANSparkMax factory (Motor motor){
        CANSparkMax controller = new CANSparkMax(motor.value, MotorType.kBrushless);
        controller.restoreFactoryDefaults();
        return controller;
    }

    public static CANSparkMax factory (Motor motor, Boolean inverted) {
        CANSparkMax controller = new CANSparkMax(motor.value, MotorType.kBrushless);
        controller.setInverted(inverted);
        controller.restoreFactoryDefaults();
        return controller;
    }

}
