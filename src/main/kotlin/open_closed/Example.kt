package open_closed

/**
 * This is the example of what is incorrect.
 */
class IncorrectExample {

    enum class PaymentMethod {
        ACCOUNT_MONEY,
        DEBIT_CARD,
        CREDIT_CARD
    }

    /**
     * This is not extensible, it's bad.
     */
    class PaymentProcessor {
        /**
         * This is incorrect because if we want to add another payment method in the future,
         * we would need to modify this class to handle the new payment logic.
         */
        fun processPayment(method: PaymentMethod, amount: Double) {
            when (method) {
                PaymentMethod.ACCOUNT_MONEY -> println("paying $amount with account money")
                PaymentMethod.DEBIT_CARD -> println("paying $amount with debit card")
                PaymentMethod.CREDIT_CARD -> println("paying $amount with credit card")
            }
        }
    }
}

/**
 * This is the example of what is correct.
 */
class CorrectExample {

    /**
     * This is correct because if we want to add another payment method we just have to add it here and avoid
     * modifications in the client code, in this case, the payment processor.
     */
    enum class PaymentMethod(val processPayment: (amount: Double) -> Unit) {
        ACCOUNT_MONEY(
            { amount -> println("paying $amount with account money") }
        ),
        DEBIT_CARD(
            { amount -> println("paying $amount with debit card") }
        ),
        CREDIT_CARD(
            { amount -> println("paying $amount with credit card") }
        )
    }

    /**
     * This is now extensible, it's good.
     */
    class PaymentProcessor {
        fun processPayment(method: PaymentMethod, amount: Double) = method.processPayment(amount)
    }
}