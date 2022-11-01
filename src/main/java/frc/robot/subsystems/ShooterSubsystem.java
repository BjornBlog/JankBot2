package frc.robot.subsystems;
import edu.wpi.first.wpilibj.Encoder;
import frc.robot.Constants.DriveConstants;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase
{
    public ShooterSubsystem()
    { 
        
    }
    private final PWMSparkMax m_shooter = new PWMSparkMax(DriveConstants.shooterMotor);
}