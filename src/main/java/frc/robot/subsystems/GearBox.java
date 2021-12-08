package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.Constants.DriveConstants.*;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;

public class GearBox {
    private final DoubleSolenoid solenoid;

    public enum Gear{
        LOW,HIGH;
    }

    public GearBox() {
        solenoid = new DoubleSolenoid(Solenoid.kForward.value, Solenoid.kReverse.value);
    }

    public void shift (Gear gear) {
        switch (gear) {
          case LOW: solenoid.set(kOff);
          case HIGH: solenoid.set(kForward); 
        }
    }

}
