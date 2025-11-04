package org.emp.gl.clients;
import java.beans.PropertyChangeEvent;

import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;
public class CompteARebours implements TimerChangeListener{

    private int value;
    private TimerService Service;
    public CompteARebours(int val,TimerService Service)
    {   
        this.Service = Service;
        this.value = val;
    }
    // @Override
    // public void propertyChange(String prop,Object oldVal, Object newVal)
    // {
    //     switch (prop) {
    //         case SECONDE_PROP:
    //                 if (this.value > 0) {
    //                     this.value -= 1;
    //                     System.out.println("Value : "+ this.value);
    //                 }else if (this.value == 0){
    //                     System.out.println("Value reached 0");
    //                     Service.removeTimeChangeListener(this);
    //                 }
    //             break;
    //         default:
    //             break;
    //     }
    // }
    @Override
    public  void propertyChange(PropertyChangeEvent event)
    {
        switch (event.getPropertyName()) {
            case SECONDE_PROP:
                if (this.value > 0) {
                        this.value -= 1;
                        System.out.println("Value : "+ this.value);
                    }else if (this.value == 0){
                        System.out.println("Value reached 0");
                        Service.removeTimeChangeListener(this);
                    }
                break;
        
            default:
                break;
        }

    }
}
