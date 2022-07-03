package frc.robot.components;

import java.util.HashMap;
import java.util.Map;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants.DriveConstants.Motor;

public class SparkMax {
    private SparkMax(){}

    private static Map<Motor, CANSparkMax> motorInstances = new HashMap<>();
    private static Map<Motor, CANEncoder> encoderInstances = new HashMap<>();

    public static CANSparkMax getMotor (Motor motor) {
        var instance = motorInstances.get(motor);
        if (instance == null) return motorInstances.put(motor, createMotor(motor));
        return instance;
    }

    public static CANEncoder getEncoder (Motor motor) {
        CANEncoder instance = encoderInstances.get(motor);
        if (instance == null) return encoderInstances.put(motor, createEncoder(motor));
        return instance;
    }

    private static CANSparkMax createMotor (Motor motor){
        CANSparkMax controller = new CANSparkMax(motor.value, MotorType.kBrushless);

        controller.restoreFactoryDefaults();
        return controller;
    }

    private static CANEncoder createEncoder(Motor motor){
        var encoder = getMotor(motor).getEncoder();
        
        encoder.setPositionConversionFactor(1);
        encoder.setVelocityConversionFactor(1);
        return encoder;
    }
}
