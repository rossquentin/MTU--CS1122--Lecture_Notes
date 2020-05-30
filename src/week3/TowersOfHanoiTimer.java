package week3;

import java.util.LinkedList;

/**
 * A simple timer to determine how long Towers of Hanoi will take on a system.
 * Your times may vary. This measures with real-time as opposed to CPU time, so it is
 * possible you'll get a few outliers for time where something takes significantly longer
 * than it otherwise should have. This is more common if you use the computer alongside this program.
 *
 * This is not a robust implementation, and was designed to be run on a Linux system with
 * java version 11+, though it may support versions as late as java version 8, though it may
 * work on other OSs, this is untested.
 *
 * This program makes the assumption that the main bottleneck will not be memory. It's unlikely, but
 * that may cause two threads to accidentally interfere.
 * @author Scott Pomerville
 */
public class TowersOfHanoiTimer{
    int rings;
    
    /**
     * A constructor. This simply preps the Towers object to be solved.
	  * @param rings The number of rings the tower should have.
     */
    public TowersOfHanoiTimer(int rings){
        this.rings = rings;
    }

    /**
     * This is a helper method.
     * It solves one step of the tower
     * Unlike the in-class version, I comment out the print statements, as
     * I/O is the slowest part of a typical program like this and I want to minimize
     * slowdown as much as possible.
     * 
     * @param disks The number of disks needed to be moved
     * @param src The source post disks need to be removed from
     * @param dst The destination post disks need to be moved to
     * @return the total number of calls to printMove that this call makes.
     */
    private long printMove(int disks, int src, int dest){
        if(disks == 1){
            //We would move a ring from src to dst here.
            return 1;
        }

        // Rods are represented with integers 1, 2, and 3
        // 1 + 2 + 3 = 6, so to get the remaining one, we just subtract. 
        int otherDest = 6 - src - dest;
        long calls1 = printMove(disks - 1, src, otherDest);
        //We would move a ring from src to dst here.
        long calls2 = printMove(disks - 1, otherDest, dest);
        return calls1 + calls2 + 1; //+1 for my own call
    }

    /**
     * Solves the Tower
     * @return the total times the printSolve method is called.
     */
    public long printSolve(){
        //The initial call is from post 1 to post 3.
        return printMove(rings, 1, 3);
    }


    /**
     * See how long a thread takes to execute the Towers of Hanoi for x disks.
     * @param disks The total count of disks on this set of Towers.
     */
    public static void measureHanoi(int disks){

		// Get the first time...
        long t1 = System.currentTimeMillis();

		// Solve the tower...
        TowersOfHanoiTimer tower = new TowersOfHanoiTimer(disks);
        long fake = tower.printSolve();

		// Get the second time and subtract the first time from it to get duration...
        long t2 = System.currentTimeMillis() - t1;
		
		// Convert
        long hrs = t2/3600000; // 3.6e6 millis in an hr
        long minutes = (t2%3600000)/60000; // 60000 millis in a minute
        float seconds = t2%(60000)/1000f; // leftovers being converted to seconds

        System.out.printf("Disks %d: Execution time - %dh %dm %fs%n",
                            disks, hrs, minutes, seconds);
        System.out.printf("         Total Calls to printMove: = %d%n", fake);
    }



    public static void main(String[] args){

        // The list of disks the system should try solving Towers of Hanoi with.
        int diskCounts[] = 
            { 5, 10, 15, 20, 25, 30, 35, 40}; //, 41, 42, 43, 44, 45};

        // Determine the number of cores I have available.
        int cores = Runtime.getRuntime().availableProcessors();
		
		// Don't schedule more threads than half the cores I have available.
        // I'd like to be able to keep using my computer while this runs...
        int avail = (cores <= 4) ? 1 : (cores/2)-1;
        System.out.println("CPU Cores on System: " + cores + "Max Cores Program Will Schedule: " + avail);

        // Have a queue to manage the currently running threads.
        LinkedList<Thread> threadQueue = new LinkedList<Thread>();

        // Issue a bunch of threads dedicated to solving their own version of Towers of Hanoi
		// so I can have multiple cores working on solving this instead of just one.
        for(int i = 0; i < diskCounts.length; i++){
            final int dCount = diskCounts[i];

            // Check to see if I have resources.
            if(threadQueue.size() >= avail){
                try{
                    // If I don't have the resources, wait until a thread is done...
                    threadQueue.poll().join();
                }
                catch (InterruptedException e){
                    System.err.println("Thread interrupted?!?");
                }
            }

            // Spin off a thread here that just measures Hanoi.
            Thread tmp = new Thread( ()-> { measureHanoi(dCount); });
            tmp.start(); // Start it
            threadQueue.add(tmp); // Add it to our monitored threads.
        }

        // Wait patiently for our threads to all finish.
        for(int i = 0; i < threadQueue.size(); i++){
            try{
                threadQueue.poll().join(); 
            }
            catch (InterruptedException e){
                System.err.println("Thread interrupted!?!?");
            }
        }

    }
}

