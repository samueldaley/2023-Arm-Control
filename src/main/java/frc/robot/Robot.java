// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.DataLogManager;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {
    private RobotContainer m_robotContainer;

    String getMatchTypeString() {
        var s = DriverStation.getMatchType();
        switch(s) {
            case Practice:
                return "Practice";
            case Qualification:
                return "Qual";
            case Elimination:
                return "Elimination";
            default: return "Other";
        }

    }

    @Override
    public void robotInit() {
        LiveWindow.disableAllTelemetry();

        // only want this for debugging
        DataLogManager.logNetworkTables(true);

        // String name = String.format("%s-%s-%s.wpilog", DriverStation.getEventName(), getMatchTypeString(), DriverStation.getMatchNumber());

        DataLogManager.start();

        m_robotContainer = new RobotContainer(this);
    }

    @Override
    public void robotPeriodic() {
        // Runs the Scheduler. This is responsible for polling buttons, adding
        // newly-scheduled
        // commands, running already-scheduled commands, removing finished or
        // interrupted commands,
        // and running subsystem periodic() methods. This must be called from the
        // robot's periodic
        // block in order for anything in the Command-based framework to work.
        CommandScheduler.getInstance().run();
    }

    @Override
    public void disabledInit() {
    }

    @Override
    public void disabledPeriodic() {
    }

    @Override
    public void autonomousInit() {
    }

    @Override
    public void autonomousPeriodic() {
    }

    @Override
    public void teleopInit() {
        CommandScheduler.getInstance().cancelAll();
    }

    @Override
    public void teleopPeriodic() {
    }

    @Override
    public void testInit() {
        CommandScheduler.getInstance().cancelAll();
    }

    @Override
    public void testPeriodic() {
    }

    @Override
    public void simulationInit() {

    }

    @Override
    public void simulationPeriodic() {
    }
}
