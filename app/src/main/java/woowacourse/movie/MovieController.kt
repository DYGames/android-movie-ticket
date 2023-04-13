package woowacourse.movie

import android.content.Context
import android.widget.ImageView
import android.widget.TextView
import woowacourse.movie.domain.Movie
import java.time.format.DateTimeFormatter

class MovieController(
    private val context: Context,
    private val movie: Movie,
    private val poster: ImageView? = null,
    private val title: TextView? = null,
    private val date: TextView? = null,
    private val runningTime: TextView? = null,
    private val description: TextView? = null
) {
    fun render() {
        poster?.setImageResource(movie.picture)
        title?.text = movie.title

        val dateFormat = DateTimeFormatter.ofPattern(context.getString(R.string.movie_date_format))
        date?.text = context.getString(R.string.movie_date).format(
            dateFormat.format(movie.date.startDate), dateFormat.format(movie.date.endDate)
        )
        runningTime?.text = context.getString(R.string.movie_running_time).format(movie.runningTime)
        description?.text = movie.description
    }
}
