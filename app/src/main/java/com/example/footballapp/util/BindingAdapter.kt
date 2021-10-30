package com.example.footballapp.util


import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.footballapp.R
import com.example.footballapp.model.State
import com.example.footballapp.ui.base.BaseAdapter
import com.example.footballapp.ui.home.HomeNestedAdapter
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

@BindingAdapter(value = ["app:showWhenLoading"])
fun <T> showWhenLoading(view: View, status: State<T>?) {
    if (status is State.Loading) {
        view.visibility = View.VISIBLE
    } else {
        view.visibility = View.GONE
    }
}

@BindingAdapter(value = ["app:showWhenError"])
fun <T> showWhenError(view: View, status: State<T>?) {
    if (status is State.Error) {
        view.visibility = View.VISIBLE
    } else {
        view.visibility = View.GONE
    }
}

@BindingAdapter(value = ["app:showWhenSuccess"])
fun <T> showWhenSuccess(view: View, status: State<T>?) {
    if (status is State.Success) {
        view.visibility = View.VISIBLE
    } else {
        view.visibility = View.GONE
    }
}

@BindingAdapter(value = ["app:imgUrl"])
fun setImageUrl(view: ImageView, url: String?) {
    Glide.with(view)
        .load(url)
        .placeholder(R.drawable.ic_error)
        .error(R.drawable.ic_downloading)
        .into(view)
}

@BindingAdapter(value = ["app:items"])
fun <T> setRecyclerItems(view: RecyclerView, items: List<T>?) {
    if (items != null) {
            Log.i("hhhhhhhhhhhhhhhhhhRecyc" , items.toString())
        (view.adapter as BaseAdapter<T>?)?.setItem(items)
    } else {
        (view.adapter as BaseAdapter<T>?)?.setItem(emptyList())
    }
}


@BindingAdapter(value = ["app:itemsNested"])
fun <T> setRecyclerItemsNested(view: RecyclerView, items: List<T>?) {
    if (items != null) {
        Log.i("hhhhhhhhhhhhhhhhhhRecyc" , items.toString())
        (view.adapter as HomeNestedAdapter)!!.setItem(listOf(items))
    } else {
        (view.adapter as HomeNestedAdapter?)?.setItem(emptyList())
    }
}


@BindingAdapter(value = ["firstTeamGoals", "secondTeamGoals"])
fun <T> viewBGWith2Values(view: View, firstTeamGoals: Int? = 0, secondTeamGoals: Int? = 0) {
    when {
        firstTeamGoals!! > secondTeamGoals!! -> {
            view.setBackgroundColor(ContextCompat.getColor(view.context, R.color.green))
        }
        firstTeamGoals < secondTeamGoals -> {
            view.setBackgroundColor(ContextCompat.getColor(view.context, R.color.red))
        }
        else -> {
            view.setBackgroundColor(ContextCompat.getColor(view.context, R.color.yellow))
        }
    }
}

@BindingAdapter(value = ["setFormattedDate"])
fun <T> setFormattedDate(view: TextView, dateStr: String? ) {

    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH)
    val date = LocalDate.parse(dateStr, formatter)
    view.text  = date.toString()
}

//@BindingAdapter("app:onCardClicked")
//fun navigate(view: View, playerID: Int?) {
//    view.setOnClickListener { Toast.makeText(view.context, playerID.toString(), Toast.LENGTH_SHORT).show() }
//
//    val action = ScorersFragmentDirections.actionScorersFragmentToPlayerDetailsFragment(
//        playerID ?: 3754
//    )
//    Navigation.findNavController(view).navigate(action)
//}