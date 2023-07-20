// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.TestArmExtensionCommand;
import frc.robot.subsystems.ArmExtensionSubsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {
    public final ArmExtensionSubsystem m_armExtensionSubsystem = new ArmExtensionSubsystem();

    Robot m_robot;

    Joystick m_buttonBox = new Joystick(RobotMap.kButtonBox);

    // co-pilot box buttons
    JoystickButton m_testButtonExtension = new JoystickButton(m_buttonBox, RobotMap.kTestButtonExtension);

    /**
     * The container form the robot. Contains subsystems, OI devices, and commands.
     */
    public RobotContainer(Robot robot) {
        m_robot = robot;

        configureBindings();
        smartDashboardInit();
        registerSmartDashboardCalls();
    }

    public void smartDashboardInit() {
        SmartDashboard.putNumber("Test Arm Extension Target Position", 0);

        m_armExtensionSubsystem.smartDashboardInit();
    }

    public void registerSmartDashboardCalls() {
        m_robot.addPeriodic(() -> {
            m_armExtensionSubsystem.smartDashboardUpdate();
        }, 1, 0.303);
    }

    private void configureBindings() {
        m_testButtonExtension.onTrue(new TestArmExtensionCommand(m_armExtensionSubsystem));
    }
}
