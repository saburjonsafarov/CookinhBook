package tj.kpittu.cookinhbook.core

import androidx.lifecycle.ViewModel
import tj.kpittu.cookinhbook.repository.MainRepository

abstract class BaseViewModel:ViewModel() {
protected var repository: MainRepository = MainRepository()


}