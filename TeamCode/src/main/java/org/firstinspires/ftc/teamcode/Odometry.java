package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class Odometry {
    private GoBildaPinpointDriver pinpoint;

    public Odometry(HardwareMap hardwareMap) {
        pinpoint = hardwareMap.get(GoBildaPinpointDriver.class, "odometry");
        pinpoint.resetPosAndIMU();
    }

    public double positionX() {
        return pinpoint.getPosX(DistanceUnit.CM);
    }

    public double positionY() {
        return pinpoint.getPosY(DistanceUnit.CM);
    }

    public double orientation() {
        return pinpoint.getHeading(AngleUnit.DEGREES);
    }

    public void update() {
        pinpoint.update();
    }
}
