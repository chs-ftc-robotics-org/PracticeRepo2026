package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

@Config
public class Spindexer {
    public static double POSITION = 0;
    private final Servo spindexer;

    private int currentIndex = 0;
    private final double[] positions = {
            0.0460, // intake: 0
            0.0785, // launch: 1
            0.1100, // intake: 2
            0.1405, // launch: 0
            0.1740, // intake: 1
            0.2080, // launch: 2*8
    };

    public Spindexer (HardwareMap hardwareMap) {
        spindexer = hardwareMap.get(Servo.class, "launch.spin");
        spindexer.setDirection(Servo.Direction.FORWARD);
    }

    public void setPosition(double pos) {
        spindexer.setPosition(pos);
    }

    public void nextIndex() {
        this.currentIndex++;
        if (this.currentIndex >= 6) {
            this.currentIndex = 0;
        }

        spindexer.setPosition(positions[this.currentIndex]);
    }

    public void prevIndex() {
        this.currentIndex--;
        if (this.currentIndex <= -1) {
            this.currentIndex = 5;
        }

        spindexer.setPosition(positions[this.currentIndex]);
    }
}
//We tested 0.05 and it seemed pretty good



