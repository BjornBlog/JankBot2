// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import java.sql.Date;

//import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PS4Controller;
import frc.robot.Constants.DriveConstants;
//import frc.robot.Constants.DriveConstants;
import frc.robot.Constants.OIConstants;
// import frc.robot.commands.TurnToAngle;
// import frc.robot.commands.TurnToAngleProfiled;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.BeltSubsytem;
import frc.robot.subsystems.IntakeSubsytem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
//import edu.wpi.first.wpilibj2.command.PIDCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems
  private final DriveSubsystem m_robotDrive = new DriveSubsystem();
  private final ShooterSubsystem m_shooter = new ShooterSubsystem();
  private final IntakeSubsytem m_intake = new IntakeSubsytem();
  private final BeltSubsytem m_belt = new BeltSubsytem();
  // The driver's controller
  Joystick m_driverController = new Joystick(OIConstants.kDriverControllerPort);
  JoystickButton button1 = new JoystickButton(m_driverController, 1);
  JoystickButton button2 = new JoystickButton(m_driverController, 2);
  JoystickButton button3 = new JoystickButton(m_driverController, 3);
  JoystickButton button4 = new JoystickButton(m_driverController, 4);
  JoystickButton button5 = new JoystickButton(m_driverController, 5);
  JoystickButton button6 = new JoystickButton(m_driverController, 6);
  JoystickButton button7 = new JoystickButton(m_driverController, 7);
  JoystickButton button8 = new JoystickButton(m_driverController, 8);
  //FlightStick stick = new FlightStick(0);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    // Configure default commands
    // Set the default drive command to split-stick arcade drive
    m_robotDrive.setDefaultCommand(
        // A split-stick arcade command, with forward/backward controlled by the left
        // hand, and turning controlled by the right.
        new RunCommand(
            () ->
            
            m_robotDrive.arcadeDrive(
                    -m_driverController.getRawAxis(1), m_driverController.getRawAxis(0)),
            m_robotDrive));
            

  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link edu.wpi.first.wpilibj.GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link PS4Controller}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // Drive at half speed when the right bumper is held
    button5
        .whenPressed(() -> m_robotDrive.setMaxOutput(0.5))
        .whenReleased(() -> m_robotDrive.setMaxOutput(1));
    button1
        .whileHeld(() -> m_shooter.shoot((m_driverController.getRawAxis(3))))
        .whenReleased(() -> m_shooter.shoot(0));;
    button2
        .whileHeld(() -> m_intake.intake((m_driverController.getRawAxis(3))))
        .whenReleased(() -> m_intake.intake(0));
    button3
        .whileHeld(() -> m_belt.belt(.4))
        .whenReleased(() -> m_belt.belt(0));
    button4
        .whileHeld(() -> m_belt.belt(-.4))
        .whenReleased(() -> m_belt.belt(0));
    // Stabilize robot to drive straight with gyro when left bumper is held
    /*new JoystickButton(m_driverController, Button.kL1.value)
        .whenHeld(
            new PIDCommand(
                new PIDController(
                    DriveConstants.kStabilizationP,
                    DriveConstants.kStabilizationI,
                    DriveConstants.kStabilizationD),
                // Close the loop on the turn rate
                m_robotDrive::getTurnRate,
                // Setpoint is 0
                0,
                // Pipe the output to the turning controls
                output -> m_robotDrive.arcadeDrive(-m_driverController.getRawAxis(0), output),
                // Require the robot drive
                m_robotDrive));
                //button8.whileHeld(new run);
    // Turn to 90 degrees when the 'X' button is pressed, with a 5 second timeout
    new JoystickButton(m_driverController, Button.kCross.value)
        .whenPressed(new TurnToAngle(90, m_robotDrive).withTimeout(5));

    // Turn to -90 degrees with a profile when the Circle button is pressed, with a 5 second timeout
    new JoystickButton(m_driverController, Button.kCircle.value)
        .whenPressed(new TurnToAngleProfiled(-90, m_robotDrive).withTimeout(5));
    */
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // no auto
    return new RunCommand(() -> m_robotDrive.arcadeDrive(.5, 0), m_robotDrive).withTimeout(3);
  }
}
