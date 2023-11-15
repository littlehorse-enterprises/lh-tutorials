/*
 * App.java
 * This class serves as the entry point for the LittleHorse Quickstart application.
 * It handles the registration of workflows and task workers.
 */

package lh.quickstart;

import java.io.IOException;
import io.littlehorse.sdk.common.config.LHConfig;
import io.littlehorse.sdk.worker.LHTaskWorker;

public class App {

    /**
     * Registers the workflow with the LittleHorse server.
     * This involves setting up the task worker and registering the workflow specification.
     */
    private static void registerWorkflow() throws IOException {
        // Configuration for LittleHorse
        LHConfig config = new LHConfig();

        // Register the 'greet' task with the task worker
        LHTaskWorker worker = new LHTaskWorker(new Greeter(), "greet", config);
        worker.registerTaskDef(true);

        // Initialize and register the workflow specification
        QuickstartWorkflow quickstart = new QuickstartWorkflow();
        quickstart.getWorkflow().registerWfSpec(config.getBlockingStub());
    }

    /**
     * Registers and starts the task worker.
     * @param config The configuration for the LittleHorse setup.
     */
    private static void registerAndStartWorker(LHConfig config) throws IOException {
        // Initialize the task worker for the 'greet' task
        LHTaskWorker worker = new LHTaskWorker(new Greeter(), "greet", config);
        worker.registerTaskDef(true);

        System.out.println("Done registering task definition, now starting worker");

        // Ensure the worker is properly closed during shutdown
        Runtime.getRuntime().addShutdownHook(new Thread(worker::close));

        // Start the worker to listen for tasks
        worker.start();
    }

    /**
     * The main method - the starting point of the application.
     * It interprets command line arguments to determine whether to register workflows or start the worker.
     * @param args Command line arguments.
     */
    public static void main(String[] args) throws IOException {

        // Check for correct command line arguments
        if (args.length != 1 || (!args[0].equals("register") && !args[0].equals("worker"))){
            System.err.println("Please provide one argument: either 'register' or 'worker' ");
            System.exit(1);
        }

        // Perform actions based on the provided argument
        if (args[0].equals("register")) {
            // Register the workflow
            registerWorkflow();
        } else {
            // Set up configuration and start the task worker
            LHConfig config = new LHConfig();
            registerAndStartWorker(config);
            System.out.println("Done starting the worker!");
        }
    }
}
