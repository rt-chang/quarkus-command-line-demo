package org.acme;

import picocli.CommandLine;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
@CommandLine.Command 
public class HelloCommand implements Runnable, QuarkusApplication {

    @Inject
    CommandLine.IFactory factory;
    @CommandLine.Option(names = {"-n", "--name"}, description = "Who will we greet?", defaultValue = "World")
    String name;
    @CommandLine.Option(names = {"-d", "--day"}, description = "What day is it?", defaultValue = "unknown")
    String animal;

    private final GreetingService greetingService;

    public HelloCommand(GreetingService greetingService) { 
        this.greetingService = greetingService;
    }

    @Override
    public void run() {
        greetingService.sayHello(name, animal);
    }

    @Override
    public int run(String... args) throws Exception {
        return new CommandLine(this, factory).execute(args);
    }
}

@Dependent
class GreetingService {
    void sayHello(String name, String animal) {
        System.out.println("Hello " + name + "! Your animal is " + animal);
    }
}