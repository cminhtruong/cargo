package app.el_even.com.cargo

import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import app.el_even.com.cargo.network.GithubRepo
import app.el_even.com.cargo.overview.GithubRepoAdapter
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val uri = imgUrl.toUri().buildUpon().scheme("https").build()
        //Glide.with(imgView.context).load(imgUrl).into(imgView)
        Picasso.get().load(uri).into(imgView)
    }
}


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<GithubRepo>?) {
    val adapter = recyclerView.adapter as GithubRepoAdapter
    adapter.submitList(data)
}

@BindingAdapter("textValue")
fun bindTextView(textView: TextView, text: String?) {
    textView.text = text
}
