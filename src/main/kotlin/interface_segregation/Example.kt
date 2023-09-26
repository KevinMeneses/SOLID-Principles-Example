package interface_segregation

/**
 * This is the example of what is incorrect.
 */
class IncorrectExample {

    /**
     * This is wrong because not all animals can do all these actions.
     */
    interface Animal {
        fun fly()
        fun swim()
        fun run()
    }

    class Bird: Animal {
        override fun fly() {
            println("I am flying...")
        }

        override fun swim() {
            // empty because this bird cannot swim
        }

        override fun run() {
            // empty because this bird cannot run
        }
    }

    class Dog: Animal {
        override fun fly() {
            // empty because dogs cannot fly
        }

        override fun swim() {
            println("I am swimming...")
        }

        override fun run() {
            println("I am running...")
        }
    }
}

/**
 * This is the example of what is correct.
 */
class CorrectExample {

    /**
     * This is correct, now we have more specific interfaces with bounded responsibilities and there is no methods
     * left without an implementation.
     */
    interface Animal

    interface FlyingAnimal: Animal {
        fun fly()
    }

    interface SwimmingAnimal: Animal {
        fun swim()
    }

    interface RunningAnimal: Animal {
        fun run()
    }

    class Bird: FlyingAnimal {
        override fun fly() {
            println("I am flying...")
        }
    }

    class Dog: SwimmingAnimal, RunningAnimal {
        override fun swim() {
            println("I am swimming...")
        }

        override fun run() {
            println("I am running...")
        }
    }
}