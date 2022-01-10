package tj.kpittu.cookinhbook.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import tj.kpittu.cookinhbook.core.BaseViewModel
import tj.kpittu.cookinhbook.model.ReceptModel

class MainFragmentViewModel : BaseViewModel() {

    fun getRetcept(): LiveData<ArrayList<ReceptModel>> {
        val retcepts: MutableLiveData<ArrayList<ReceptModel>> = MutableLiveData()

        viewModelScope.launch {
            val retceptData = repository.getRecept()
            retcepts.postValue(retceptData)
        }

        return retcepts


    }
}