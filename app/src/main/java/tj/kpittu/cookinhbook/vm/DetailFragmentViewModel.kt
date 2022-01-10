package tj.kpittu.cookinhbook.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import tj.kpittu.cookinhbook.core.BaseViewModel
import tj.kpittu.cookinhbook.model.ReceptModel

class DetailFragmentViewModel:BaseViewModel() {

    fun getRetceptById(id:Int):LiveData<ReceptModel>{
        val retsepts:MutableLiveData<ReceptModel> = MutableLiveData()
        viewModelScope.let {
            val retseptData = repository.getREceptById(id)
            retsepts.postValue(retseptData)

        }

        return retsepts

    }

}