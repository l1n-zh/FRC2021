package frc.robot.components;


public class XboxController {
    public enum Button {
        kBumperLeft(5),
        kBumperRight(6),
        kStickLeft(9),
        kStickRight(10),
        kA(1),
        kB(2),
        kX(3),
        kY(4),
        kBack(7),
        kStart(8);
    
        @SuppressWarnings({"MemberName", "PMD.SingularField"})
        public final int value;
    
        Button(int value) {
          this.value = value;
    }
    
    public enum Axis {
        kLeftX(0),
        kRightX(4),
        kLeftY(1),
        kRightY(5),
        kLeftTrigger(2),
        kRightTrigger(3);
    
        @SuppressWarnings({"MemberName", "PMD.SingularField"})
        public final int value;
    
        Axis(int value) {
            this.value = value;
        }
    }
}
}
