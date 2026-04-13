package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {
// name on hardware map "intake"
    private DcMotor motor;

    public Intake(HardwareMap hardwareMap) {
        motor = hardwareMap.get(DcMotor.class,"intake");
    }

    public void stop() {
        motor.setPower(0);
    }
    public void forward() {
        motor.setPower(0.6);
    }

    public void backward() {
        motor.setPower(-0.6);
    }




}

