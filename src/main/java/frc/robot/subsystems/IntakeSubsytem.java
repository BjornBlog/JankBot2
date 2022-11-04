package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Constants.DriveConstants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
public class IntakeSubsytem extends SubsystemBase
{
    public IntakeSubsytem()
    {
        
    }
    private final WPI_TalonSRX m_intake = new WPI_TalonSRX(DriveConstants.intake);
    public void intake(double speed)
    {
        m_intake.set(speed);
    }
}
