package com.example.footballapp.util

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.footballapp.R
import com.example.footballapp.model.State
import com.example.footballapp.ui.base.BaseAdapter

@BindingAdapter(value = ["app:showWhenLoading"])
fun <T> showWhenLoading(view:View , status: State<T>?){
    if (status is com.example.footballapp.model.Status.State.Loading){
        view.visibility = View.VISIBLE
    }else{
        view.visibility = View.GONE
    }
}

@BindingAdapter(value = ["app:showWhenError"])
fun <T> showWhenError(view:View , status: State<T>?){
    if (status is com.example.footballapp.model.Status.State.Error){
        view.visibility = View.VISIBLE
    }else{
        view.visibility = View.GONE
    }
}

@BindingAdapter(value = ["app:showWhenSuccess"])
fun <T> showWhenSuccess(view:View , status: State<T>?){
    if (status is com.example.footballapp.model.Status.State.Success){
        view.visibility = View.VISIBLE
    }else{
        view.visibility = View.GONE
    }
}

@BindingAdapter(value = ["app:imgUrl"])
fun setImageUrl(view: ImageView,url:String?){
    Glide.with(view)
        .load(url)
        .placeholder(R.drawable.ic_error)
        .error(R.drawable.ic_downloading)
        .into(view)
}

@BindingAdapter(value = ["app:items"])
fun <T> setRecyclerItems(view: RecyclerView, items:List<T>?){
    if(items != null)
        (view.adapter as BaseAdapter<T>?)?.setItem(items)
    else
        (view.adapter as BaseAdapter<T>?)?.setItem(emptyList())

}