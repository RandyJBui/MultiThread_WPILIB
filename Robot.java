//ALL OF THIS WAS DONE ON GITHUB, MAKE SURE TO IMPORT THE CORRECT LIBRARIES
public class Robot extends TimedRobot {
  private static final byte[] _ports = {0,1,2,3,4,5}; //port numbers in an array
  private static final byte[] _buttons = {0,1,2,3,4}; //Private makes it so that only this class can use these variables, static means that its only initialized once, and final makes it so the variable doesnt change.
  private static final byte[] _axis = {1,2,3,4};
 //trying out arrays in order to manage complexity.

private static final String turnAuto = "turnAuto"; //used to pick autonomous code in the driverstation
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();
final WPI_TALONFX motor = new WPI_TalonFX(2);
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
   //Recalling newThread class, and converting it into thread wrapper class.
    NewThread thread = new NewThread();
    Thread threads = new Thread(thread);
    
    
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {}

  /**
   * This autonomous (along with the chooser code above) shows how to select between different
   * autonomous modes using the dashboard. The sendable chooser code works with the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
   * uncomment the getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to the switch structure
   * below with additional strings. If using the SendableChooser make sure to add them to the
   * chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() { // periodics mean that the code repeats, so right now the motor is set to run foward forever, if we want to do steps, it'll probably better to use timers in autoninit
    switch (m_autoSelected) {
      case kCustomAuto:
        // Put custom auto code here
        break;
        case turnAuto: //have to set autonomous option in driver station.

        _motor.set(1); // activate one motor.
        break;
      case kDefaultAuto:
      default: //default is what plays when nothing else is picked.
        _compressor.start();
        break;
       

    }
  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {
    //starting a thread that will never end, essentially now our drive train has its own autonomy.
    threads.start();
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    //this is the talonFX, we are using to test the concurrency of this system.
motor.set(1);
  }
  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}
}

public void joystickVal(int port){
  return joystick.getRawAxis(port);
}
