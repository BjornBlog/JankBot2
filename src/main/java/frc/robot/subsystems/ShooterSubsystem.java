package frc.robot.subsystems;
import edu.wpi.first.wpilibj.Encoder;
import frc.robot.Constants.DriveConstants;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase
{
    private final PWMSparkMax m_shooter = new PWMSparkMax(DriveConstants.shooterMotor);
    public ShooterSubsystem()
    { 

    }
    public void shoot(double speed)
    {
        m_shooter.set(speed);
    }
}