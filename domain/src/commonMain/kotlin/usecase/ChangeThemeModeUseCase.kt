package usecase

import repository.Repository

class ChangeThemeModeUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(value: String) = repository.changeThemeMode(value)

}