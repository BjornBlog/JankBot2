package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.Encoder;
import frc.robot.Constants.DriveConstants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase
{
    private final CANSparkMax m_shooter = new CANSparkMax(DriveConstants.shooterMotor, MotorType.kBrushless);
    public ShooterSubsystem()
    { 

    }
    public void shoot(double speed)
    {
        System.out.println(speed);
        m_shooter.set(speed);
    }
}