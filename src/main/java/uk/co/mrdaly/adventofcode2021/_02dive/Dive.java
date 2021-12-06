package uk.co.mrdaly.adventofcode2021._02dive;

import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dive {

    private int horizontalPosition;
    private int depth;
    private int aim;

    public int partOne(List<String> input) {
        process(input, instruction -> {
            String command = instruction.command;
            int amount = instruction.amount;

            if (command.equals("forward")) {
                horizontalPosition += amount;
            } else if (command.equals("up")) {
                depth -= amount;
            } else if (command.equals("down")) {
                depth += amount;
            }
            return null;
        });

        return horizontalPosition * depth;
    }

    private void process(List<String> input, Function<Instruction, Void> function) {
        input.stream()
                .map(this::parseInstruction)
                .forEach(function::apply);
    }

    private Instruction parseInstruction(String step) {
        final Pattern compile = Pattern.compile("(\\w+)\\s(\\d+)");
        Matcher matcher = compile.matcher(step);
        matcher.find();
        String instruction = matcher.group(1);
        int amount = Integer.parseInt(matcher.group(2));
        return new Instruction(instruction, amount);
    }

    public int partTwo(List<String> input) {
        process(input, instruction -> {
            String command = instruction.command;
            int amount = instruction.amount;

            if (command.equals("forward")) {
                horizontalPosition += amount;
                depth += (amount * aim);
            } else if (command.equals("up")) {
                aim -= amount;
            } else if (command.equals("down")) {
                aim += amount;
            }
            return null;
        });
        return horizontalPosition * depth;
    }


    private static class Instruction {
        private String command;
        private int amount;

        public Instruction(String command, int amount) {
            this.command = command;
            this.amount = amount;
        }
    }


}
