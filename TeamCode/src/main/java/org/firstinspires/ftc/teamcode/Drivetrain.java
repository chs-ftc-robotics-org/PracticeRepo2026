package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

@Config
public class Drivetrain {
    public static double SPEED_MULTIPLIER = 1.0;

    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private DcMotor backRight;

    public Drivetrain(HardwareMap hardwareMap) {
        // 0: fr
        // 1: bl
        // 2: fl
        // 3: br

        frontLeft = hardwareMap.get(DcMotor.class, "drive.fl");
        frontRight = hardwareMap.get(DcMotor.class, "drive.fr");
        backLeft = hardwareMap.get(DcMotor.class, "drive.bl");
        backRight = hardwareMap.get(DcMotor.class, "drive.br");

        frontLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void move(double forward, double sideways, double turn) {
        double adjustment = SPEED_MULTIPLIER;

        double fl = adjustment * (forward - sideways - turn);
        double fr = adjustment * (forward + sideways + turn);
        double bl = adjustment * (forward + sideways - turn);
        double br = adjustment * (forward - sideways + turn);

        frontLeft.setPower(fl);
        frontRight.setPower(fr);
        backLeft.setPower(bl);
        backRight.setPower(br);
    }
}
