package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Constants.DriveConstants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
public class BeltSubsytem extends SubsystemBase
{
    public BeltSubsytem()
    {

    }
    private final WPI_TalonSRX m_belt = new WPI_TalonSRX(DriveConstants.convayor);
}
