class ThreadTester {
    public static void main(String args[]) throws Exception {
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("inside Thread1");
                for(int i=0;i<3;i++)
                {
                    System.out.println("inside Thread1: "+i);
                }
                System.out.println("Thread1 finished");
//                thread2.setDaemon(true);
                thread2.start();
            }

            Thread thread2=new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("inside Thread2");

                    for(int i=0;i<3;i++)
                    {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println("inside Thread2: "+i);
                    }
                    System.out.println("Thread2 finished");
                }
            });

        });



        thread1.setPriority(Thread.MIN_PRIORITY);
//        thread2.setPriority(Thread.MAX_PRIORITY);
//        thread2.setDaemon(true);
        thread1.start();
        Thread.sleep(3000);
        thread1.interrupt();

        System.out.println("Main thread finished");
    }
}