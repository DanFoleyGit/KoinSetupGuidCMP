import androidx.lifecycle.ViewModel
import dependancies.MyRepository

class MyViewModel(
    private val repository: MyRepository
): ViewModel() {

    fun getHelloWorldString(): String {
        return repository.getHelloWorldString()
    }
}