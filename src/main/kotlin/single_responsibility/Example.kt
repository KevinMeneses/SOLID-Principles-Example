package single_responsibility

/**
 * This is the example of what is incorrect.
 */
class IncorrectExample {

    class WifiManager {
        fun connectToWifiNetwork() {
            println("connecting to a Wi-Fi network...")
        }

        /**
         * This method does not belong to this class as this class should only contain Wi-Fi related methods
         */
        fun connectToBluetooth() {
            println("connecting to a bluetooth device...")
        }
    }
}

/**
 * This is the example of what is correct.
 */
class CorrectExample {

    class WifiManager {
        fun connectToWifiNetwork() {
            println("connecting to a Wi-Fi network...")
        }
    }

    /**
     * The right thing to do is create another class that contains the bluetooth related logic.
     */
    class BluetoothManager {
        fun connectToBluetooth() {
            println("connecting to a bluetooth device...")
        }
    }
}
