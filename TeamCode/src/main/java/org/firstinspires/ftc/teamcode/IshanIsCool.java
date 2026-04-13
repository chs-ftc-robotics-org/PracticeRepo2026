package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Ishan Is Cool")
public class IshanIsCool extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        Drivetrain drivetrain = new Drivetrain(hardwareMap);
        Spindexer spindexer = new Spindexer(hardwareMap);
        Odometry odometry = new Odometry(hardwareMap);
        Intake intake = new Intake(hardwareMap);

        waitForStart();


        while (opModeIsActive()) {
            drivetrain.move(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);
            //no changes were added here -- yes there were
            // goodbye
            if (gamepad1.a) spindexer.setPosition(0.5);
            if (gamepad1.b) spindexer.setPosition(0.7);
            if (gamepad1.dpadRightWasPressed()) {
                spindexer.nextIndex();
            }
            if (gamepad1.dpadLeftWasPressed()) {
                spindexer.prevIndex();
            }

            if (gamepad1.x) intake.forward();
            else if (gamepad1.y) intake.backward();
            else intake.stop();

            telemetry.addData("PositionX", odometry.positionX());
            telemetry.addData("PositionY", odometry.positionY());
            telemetry.addData("Orientation", odometry.orientation());
            telemetry.update();

            odometry.update();
        }
    }


}
