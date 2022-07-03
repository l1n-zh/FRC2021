package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import static frc.robot.Constants.DriveConstants.SolenoidPort.*;

public class GearBox {
    private Solenoid rightSolenoid, leftSolenoid;

    public enum Gear {
        kLow(false, false),
        kHigh(true, true);

        public final boolean rStatus,lStatus;
        Gear(boolean lStatus, boolean rStatus) {
            this.lStatus = lStatus;
            this.rStatus = rStatus;
        }

    }

    public GearBox() {
        leftSolenoid = new Solenoid(kForward.value);
        rightSolenoid = new Solenoid(kReverse.value);
    }

    public void shift(Gear gear) {
        leftSolenoid.set(gear.rStatus);
        rightSolenoid.set(gear.lStatus);
    }

    public void shift(){
        leftSolenoid.toggle();
        rightSolenoid.toggle();
    }

}
