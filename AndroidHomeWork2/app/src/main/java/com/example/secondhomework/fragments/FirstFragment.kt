package com.example.secondhomework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.secondhomework.R
import com.example.secondhomework.adapters.UserAdapter
import com.example.secondhomework.models.User

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_first, container, false)
        setupRecyclerView(view)
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FirstFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                FirstFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }

    fun setupRecyclerView(view: View){
        val recyclerView = view.findViewById<RecyclerView>(R.id.user_rv);

        val linearLayoutManager = LinearLayoutManager(view.context);

        val userList :ArrayList<User> = ArrayList<User>()
        userList.add(User("1","Cristi","fdsiofjiso","andrichrioe@yahoo.com","lib","Cov","Covasna",
        "5454345","455","435","0669407","rjeorjgo","fjojfeiog","fjsdofsoi","das"));
        userList.add(User("2","Cristi","fdsiofjiso","andrichrioe@yahoo.com","lib","Cov","Covasna",
            "5454345","455","435","0669407","rjeorjgo","fjojfeiog","fjsdofsoi","das"));
        userList.add(User("3","Cristi","fdsiofjiso","andrichrioe@yahoo.com","lib","Cov","Covasna",
            "5454345","455","435","0669407","rjeorjgo","fjojfeiog","fjsdofsoi","das"));
        userList.add(User("4","Cristi","fdsiofjiso","andrichrioe@yahoo.com","lib","Cov","Covasna",
            "5454345","455","435","0669407","rjeorjgo","fjojfeiog","fjsdofsoi","das"));
        userList.add(User("5","Cristi","fdsiofjiso","andrichrioe@yahoo.com","lib","Cov","Covasna",
            "5454345","455","435","0669407","rjeorjgo","fjojfeiog","fjsdofsoi","das"));

        val userAdapter :UserAdapter = UserAdapter(userList)

        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = userAdapter
    }
}