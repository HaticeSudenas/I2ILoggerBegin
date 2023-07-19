package com.hatice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalTime;
import java.util.logging.Level;

public class myTimerLoggins {

    static final Logger logger = LogManager.getLogger();
    static private int saniyeSayac;
    static private int dakikaSayac;
    public static void main(String[] args) {

        LocalTime previousTime = LocalTime.now().minusSeconds(1);
        while(true){
            LocalTime currentTime = LocalTime.now();

            if(previousTime.getSecond() != currentTime.getSecond() ){
                if(currentTime.getSecond() != 0){
                    logger.debug("saniye değişti");
                }
            }
            if(previousTime.getMinute() != currentTime.getMinute()){
                if(currentTime.getMinute() != 0){
                    logger.info("dakika değişti");
                }

            }
            if(previousTime.getHour() != currentTime.getHour() ){
                logger.error("saat değişti");
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                java.util.logging.Logger.getLogger(myTimerLoggins.class.getName()).log(Level.SEVERE, null, ex);
            }
            previousTime = currentTime;//şimdiki zamanı önceki zaman olarak atayıp bir sonraki tura geçiyoruz
        }
        // Logger logger = LogManager.getLogger();
        // logger.info("selamlar");

        /*Timer timer = new Timer();
        Calendar calendar = Calendar.getInstance();
         saniyeSayac=calendar.get(Calendar.SECOND);
          dakikaSayac=calendar.get(Calendar.MINUTE);
        TimerTask task =new TimerTask() {

            @Override
            public void run() {
                if(dakikaSayac == 100){
                    timer.cancel();
                    return;
                }
                if(dakikaSayac == 60){
                    logger.error("saat mesajı");
                    dakikaSayac =0;
                    return;
                }
                if(saniyeSayac == 0){
                    logger.info("dakika mesajı");
                    dakikaSayac++;
                    saniyeSayac = 0;
                    return;
                }

                logger.debug("saniye mesajı");
                saniyeSayac++;
            }
        };

        timer.schedule(task,new Date(),1000);*/







    }
}
