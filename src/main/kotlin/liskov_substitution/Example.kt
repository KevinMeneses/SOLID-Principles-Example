package liskov_substitution

import java.lang.RuntimeException

/**
 * This is the example of what is incorrect.
 */
class IncorrectExample {

    open class SwimmingAnimal {
        open fun swim() {
            println("swimming...")
        }
    }

    /**
     * This class is wrong as it violates the Liskov Substitution principle
     * as a child class should implement all its parent methods.
     */
    class Bee: SwimmingAnimal() {
        override fun swim() {
            throw RuntimeException("Bees cannot swim")
        }
    }

    class Aquarium {
        fun start() {
            var swimmingAnimal = SwimmingAnimal()
            swimmingAnimal.swim()
            swimmingAnimal = Bee()
            // error, bees cannot swim. This subclass is not interchangeable with its parent.
            swimmingAnimal.swim()
        }
    }
}

/**
 * This is the example of what is correct.
 */
class CorrectExample {

    open class SwimmingAnimal {
        open fun swim() {
            println("swimming...")
        }
    }

    class Shark: SwimmingAnimal() {
        override fun swim() {
            println("swimming fast...")
        }
    }

    class Aquarium {
        fun start() {
            var swimmingAnimal = SwimmingAnimal()
            swimmingAnimal.swim()
            swimmingAnimal = Shark()
            // This is right because the child class shark implements swim method and can replace its parent class.
            swimmingAnimal.swim()
        }
    }
}