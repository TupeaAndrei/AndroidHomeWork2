package com.example.secondhomework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.secondhomework.R
import com.example.secondhomework.adapters.UserAdapter
import com.example.secondhomework.models.User
import org.json.JSONArray
import org.json.JSONObject

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

    val userList :ArrayList<User> = ArrayList<User>()


    val userAdapter :UserAdapter = UserAdapter(userList)

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
        getPosts()
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

        userList.clear()

        userList.add(User("Tupik","andreichris55@yahoo.com"))
        userList.add(User("null","null@gmail.com"))
        userList.add(User("null2","null@gmail.com"))
        userList.add(User("null3","null@gmail.com"))
        userList.add(User("null4","null@gmail.com"))



        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = userAdapter
    }

    fun getPosts(){
        val queue = Volley.newRequestQueue(activity)

        val url = "https://jsonplaceholder.typicode.com/users";

        val getPostsRequest = StringRequest(
            Request.Method.GET,
            url,
            {response ->
                handlePostResponse(response)
            },
            {error->
                Toast.makeText(
                        activity,
                        "ERROR get posts failed with error: ${error.message}",
                        Toast.LENGTH_SHORT
                ).show()
            }
        )
        queue.add(getPostsRequest)
    }

    fun handlePostResponse(result:String){
        val postJsonArray = JSONArray(result)
        for (index in 0 until postJsonArray.length()){
            val postJson : JSONObject? = postJsonArray[index] as? JSONObject
            postJson?.let {
                val id = postJson.getLong("id")
                val username = postJson.getString("username")
                val email = postJson.getString("email")

                val postUser:User = User(username,email)
                userList.add(postUser)
            }
        }
        userAdapter.notifyDataSetChanged()
    }
}