package woowacourse.movie

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import woowacourse.movie.domain.MovieDay
import woowacourse.movie.domain.Price
import woowacourse.movie.domain.ReservationDetail
import java.time.LocalDate

class MovieDayTest {

    @Test
    fun `무비데이(매월 10,20,30일)인 경우 10% 할인이 적용된다`() {
        // given
        val movieDay = MovieDay()
        val date = LocalDate.of(2023, 1, 10)
        val price = Price(13000)
        val reservationDetail = ReservationDetail(date, 1, price)

        // when
        val actual = movieDay.discount(reservationDetail).price.value

        // then
        val expected = 11700
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `무비데이(매월 10,20,30일)가 아닌 경우 10% 할인이 적용되지 않는다`() {
        // given
        val movieDay = MovieDay()
        val date = LocalDate.of(2023, 1, 11)
        val price = Price(13000)
        val reservationDetail = ReservationDetail(date, 1, price)

        // when
        val actual = movieDay.discount(reservationDetail).price.value

        // then
        val expected = 11700
        assertThat(actual).isNotEqualTo(expected)
    }
}
