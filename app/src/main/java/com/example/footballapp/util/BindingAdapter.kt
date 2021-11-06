package com.example.footballapp.util

import android.view.View
import android.webkit.WebView
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.footballapp.R
import com.example.footballapp.model.State
import com.example.footballapp.ui.base.BaseAdapter
import com.example.footballapp.ui.home.HomeItems
import com.example.footballapp.ui.home.HomeNestedAdapter
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*


@BindingAdapter(value = ["app:showWhenLoading"])
fun <T> showWhenLoading(view: View, status: State<T>?) {
    view.isVisible = (status is State.Loading)
}

@BindingAdapter(value = ["app:showWhenError"])
fun <T> showWhenError(view: View, status: State<T>?) {
    view.isVisible = (status is State.Error)
}

@BindingAdapter(value = ["app:showWhenSuccess"])
fun <T> showWhenSuccess(view: View, status: State<T>?) {
    view.isVisible = (status is State.Success)
}
@BindingAdapter(value = ["app:imgUrl"])
fun setImageUrl(view: ImageView, url: String?) {
    Glide.with(view)
        .load(url)
        .placeholder(R.drawable.ic_error)
        .error(R.drawable.ic_downloading)
        .into(view)
}


@BindingAdapter(value = ["app:webUrl"])
fun setWebViewUrl(view: WebView, url: String?) {
    val data =
        "<img src='$url' style='width:100%; height=130%; margin-left: auto; margin-right: auto; margin-top:4px;' />"
    url?.let { view.loadData(data, "text/html", "utf-8") }
}

@BindingAdapter(value = ["app:isExistData"])
fun ifDataEmpty(view: TextView, data: Any?) {
    data?.let { view.text = it.toString() }
}
//@BindingAdapter(value = ["app:isExistData"])
//fun ifDataEmpty(view: WebView, url: String?) {
//    view.isVisible = (url != null)
//}
@BindingAdapter(value = ["app:items"])
fun <T> setRecyclerItems(view: RecyclerView, items: List<T>?) {
    if (items != null) {
        (view.adapter as BaseAdapter<T>?)?.setItem(items)
    } else {
        (view.adapter as BaseAdapter<T>?)?.setItem(emptyList())
    }
}


@BindingAdapter(value = ["app:stateMatch"])
fun setBackgroundColor(view: ConstraintLayout, state: String?) {
    state?.let { view.setBackgroundResource(StateMatches.valueOf(state).cardColor) }
}

@BindingAdapter(value = ["app:ifStateLive"])
fun displayIfLive(view: View, state: String?) {
    view.isVisible = (state == StateMatches.valueOf("LIVE").name ||
            state == StateMatches.valueOf("IN_PLAY").name)
}

@BindingAdapter(value = ["firstTeamGoals", "secondTeamGoals"])
fun viewBGWith2Values(view: View, firstTeamGoals: Int? = 0, secondTeamGoals: Int? = 0) {
@BindingAdapter(value = ["firstHomeTeamGoals", "firstAwayTeamGoals"])
fun <T> awayViewBGWith2Values(view: View, firstTeamGoals: Int? = 0, secondTeamGoals: Int? = 0) {
    when {
        firstTeamGoals!! > secondTeamGoals!! -> {
            view.setBackgroundColor(ContextCompat.getColor(view.context, R.color.red))
        }
        firstTeamGoals < secondTeamGoals -> {
            view.setBackgroundColor(ContextCompat.getColor(view.context, R.color.green))
        }
        else -> {
            view.setBackgroundColor(ContextCompat.getColor(view.context, R.color.yellow))
        }
    }
}

@BindingAdapter(value = ["secondHomeTeamGoals", "secondAwayTeamGoals"])
fun <T> homeViewBGWith2Values(view: View, firstTeamGoals: Int? = 0, secondTeamGoals: Int? = 0) {
    when {
        firstTeamGoals!! > secondTeamGoals!! -> view.setBackgroundResource(R.color.green)
        firstTeamGoals < secondTeamGoals -> view.setBackgroundResource(R.color.red)
        else -> view.setBackgroundResource(R.color.yellow)
    }
}

@BindingAdapter(value = ["setBackgroundColor"])
fun setBackgroundColor(view: View, booleanValue : Boolean){
    if (booleanValue) view.setBackgroundColor(ContextCompat.getColor(view.context, R.color.green))
    else  view.setBackgroundColor(ContextCompat.getColor(view.context, R.color.red))

}

@BindingAdapter(value = ["setFormattedDate"])
fun setFormattedDate(view: TextView, dateStr: String?) {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH)
    view.text = LocalDate.parse(dateStr, formatter).toString()
}



