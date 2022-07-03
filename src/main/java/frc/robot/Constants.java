// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */

public final class Constants {
  public static final class DriveConstants {
    public enum Motor {
      kLeftFront  (34),
      kLeftRear   (33),
      kRightFront (36),
      kRightRear  (31);

      public final int value;

      Motor(int value) {
        this.value = value;
      }
    }

    public enum SolenoidPort{
      kForward (0),
      kReverse (1);

      public final int value;
      SolenoidPort(int value) {
        this.value = value;
      }
    }

    public static final int kGyroPort = 1;
    public static final int kEncoderResolution = 42;
    public static final int kWheelRadius = 1;

  }

  public static final class OIConstants {
    public static final int kDriverControllerPort = 0;
  }
}
