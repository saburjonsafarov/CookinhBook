package tj.kpittu.cookinhbook.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import tj.kpittu.cookinhbook.R
import tj.kpittu.cookinhbook.model.ReceptModel
import tj.kpittu.cookinhbook.vm.MainFragmentViewModel


class MainFragment : Fragment(),View.OnClickListener {

    lateinit var viewModel:MainFragmentViewModel
    lateinit var linearLayout:LinearLayout


    override fun onAttach(context: Context) {
        super.onAttach(context)

        viewModel = ViewModelProvider(this).get(MainFragmentViewModel::class.java)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View? {

        val view =  inflater.inflate(R.layout.fragment_main , container , false)

        linearLayout = view.findViewById(R.id.linearItemsLayout)



        return view
    }

    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)

        viewModel.getRetcept().observe(viewLifecycleOwner,{
            addindItems(it)
        })
    }

    override fun onClick(v: View?) {

            v?.let {
                requireActivity().supportFragmentManager.beginTransaction().replace(R.id.container,DetailFragment.newInstance(it.getTag() as Int)).addToBackStack(null).commit()
            }

    }


    fun addindItems(items:ArrayList<ReceptModel>){
        linearLayout.removeAllViews()
        val inflater:LayoutInflater = LayoutInflater.from(context)
        items.forEach { el ->
            val itemView:View = inflater.inflate(R.layout.item_retcept, null)
            itemView.findViewById<ImageView>(R.id.iconImageView).setImageResource(el.icon)
            itemView.findViewById<TextView>(R.id.titleTextView).text = el.title
            itemView.findViewById<TextView>(R.id.descriptionTextView).text = el.description
            itemView.setOnClickListener(this)
            itemView.setTag(el.id)
            linearLayout.addView(itemView)

        }

    }

}