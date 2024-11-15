package usecase

import repository.Repository

class GetThemeUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke() = repository.getTheme()
}