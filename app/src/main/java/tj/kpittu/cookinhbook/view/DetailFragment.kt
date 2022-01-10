package tj.kpittu.cookinhbook.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import tj.kpittu.cookinhbook.R
import tj.kpittu.cookinhbook.model.ReceptModel
import tj.kpittu.cookinhbook.vm.DetailFragmentViewModel

class DetailFragment : Fragment() {
    lateinit var viewModel: DetailFragmentViewModel
    lateinit var icon: ImageView
    lateinit var title: TextView
    lateinit var description: TextView
    lateinit var subtitle: TextView
    var ident: Int = 0

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = ViewModelProvider(this).get(DetailFragmentViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_detail , container , false)
        icon = view.findViewById(R.id.iImageView)
        title = view.findViewById(R.id.tiTextView)
        description = view.findViewById(R.id.descTextView)
        subtitle = view.findViewById(R.id.subTextView)


        return view

    }

    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)

        viewModel.getRetceptById(ident).observe(viewLifecycleOwner , {
            icon.setImageResource(it.icon)
            title.text = it.title
            description.text = it.description
            subtitle.text = it.subtitle


        })

    }

    companion object {
        fun newInstance(id: Int): DetailFragment {
            val fragment = DetailFragment()
            fragment.ident = id
            return fragment
        }
    }


}