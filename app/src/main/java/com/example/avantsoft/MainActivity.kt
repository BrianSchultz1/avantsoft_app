package com.example.avantsoft

import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.avantsoft.domain.model.ApiResponse
import com.example.avantsoft.service.ApiService
import com.example.avantsoft.service.ServiceGenerator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        val serviceGenerator = ServiceGenerator.createService(ApiService::class.java)
        val call = serviceGenerator.getUsers()

        call.enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                val apiResponse = response.body()
                Log.d("API", apiResponse.toString())

                val users = apiResponse?.users?.map { it.toUser() } ?: emptyList()

                recyclerView.apply {
                    this.adapter = UserListAdapter(users)
                    layoutManager = GridLayoutManager(
                        this@MainActivity, 5, GridLayoutManager.HORIZONTAL, false,
                    )
                    itemAnimator = DefaultItemAnimator()
                    scrollToPosition(0)
                    addItemDecoration(
                        object : RecyclerView.ItemDecoration() {
                            override fun getItemOffsets(
                                outRect: Rect,
                                view: View,
                                parent: RecyclerView,
                                state: RecyclerView.State
                            ) {
                                super.getItemOffsets(outRect, view, parent, state)
                                outRect.set(32, 32, 32, 32)
                            }
                        }
                    )

                }

            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Log.d("API", "ERROR")
            }

        })
    }
}
