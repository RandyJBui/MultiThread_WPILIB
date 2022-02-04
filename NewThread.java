public class NewThread implements Runnable{
  WPI_TalonSRX motor = new WPI_TalonSRX(4);
  public void run(){
    
    while(true){
      if(Robot.joystickVal(1) <-.2 || Robot.joystickVal(1) > .2{
        motor.set(ControlMode.PercentOutput, Robot.joystickVal(1));
      }else{
        motor.set(0);
    }
    
    
  }
}
