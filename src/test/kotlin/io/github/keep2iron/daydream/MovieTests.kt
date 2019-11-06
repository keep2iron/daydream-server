package io.github.keep2iron.daydream

import io.github.keep2iron.daydream.entity.pojo.Movie
import io.github.keep2iron.daydream.repository.MovieRepository
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class MovieTests {

    @Autowired
    lateinit var movieRepository: MovieRepository

    @Test
    fun testMovieAdd(){
        val movie1 = Movie(
                movieName = "天气之子",
                movieCover = "/static/cover/weathering_with_you.jpg",
                year = 2019,
                description = "《天气之子》（日语：天気の子，英语：Weathering With You）是日本动画家新海诚编剧并执导的动画电影，于2019年7月19日在日本上映。这是新海诚继《你的名字。》后时隔三年的又一部动画电影，也是他的第七部及进入令和时代后的首部动画电影[3][4][5]，更获得代表日本角逐第92届奥斯卡最佳国际影片奖的资格[6]。"
        )
        val movie2 = Movie(
                movieName = "肖申克的救赎",
                movieCover = "/static/cover/the_shawshank_redemption.jpg",
                year = 1994,
                description = "《肖申克的救赎》（英语：The Shawshank Redemption，香港译《月黑高飞》，台湾译《刺激1995》）是一部1994年上映的美国电影，由法兰克·戴伦邦特执导，改编自畅销作家斯蒂芬·金的原著作品《四季奇谭》中收录的《丽塔海华丝与肖申克监狱的救赎》。电影中的男主角安迪由蒂姆·罗宾斯饰演，男配角瑞德由摩根·弗里曼饰演，剧情主要围绕着一个因冤案入狱的银行家安迪，在肖申克监狱狱中的生活，阐述希望、自由、体制化等概念。"
        )
        movieRepository.save(movie1)
        movieRepository.save(movie2)
    }

    @Test
    fun testMovieDelete(){
        movieRepository.deleteAll()
    }

    @Test
    fun testMovieQuery(){
    }

}