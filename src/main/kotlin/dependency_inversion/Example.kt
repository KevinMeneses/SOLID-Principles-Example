package dependency_inversion

/**
 * This is the example of what is incorrect.
 */
class IncorrectExample {
    /**
     * This is incorrect because this use case is depending on a concretion of profile repository
     * that fetches a profile from a database, and it may need to change datasource in the future.
     */
    class GetProfileUseCase(
        private val localProfileRepository: LocalProfileRepository
    ) {
        fun execute() = localProfileRepository.getProfile()
    }

    class LocalProfileRepository {
        fun getProfile() {
            println("fetching profile from database...")
        }
    }
}

/**
 * This is the example of what is correct.
 */
class CorrectExample {
    /**
     * This is correct because now we do not care about profile data details, we just depend on an abstraction
     * and while the concrete class can change, this use case does not know anything about it.
     */
    class GetProfileUseCase(
        private val profileRepository: ProfileRepository
    ) {
        fun execute() = profileRepository.getProfile()
    }

    interface ProfileRepository {
        fun getProfile()
    }

    class LocalProfileRepository: ProfileRepository {
        override fun getProfile() {
            println("fetching profile from database...")
        }
    }
}