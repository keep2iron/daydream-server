package io.github.keep2iron.daydream.controller

import io.github.keep2iron.daydream.core.APIController
import io.github.keep2iron.daydream.entity.dto.BaseResponse
import io.github.keep2iron.daydream.entity.dto.Rank
import io.github.keep2iron.daydream.entity.dto.RankItem
import io.github.keep2iron.daydream.repository.MovieRepository
import io.github.keep2iron.daydream.util.Constants
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@APIController
class RankController {

    @Autowired
    lateinit var movieRepository: MovieRepository

    /**
     * 推荐排行
     */
    @RequestMapping("/rank/recommendRanks", method = [RequestMethod.GET, RequestMethod.POST])
    fun queryRankList(): BaseResponse<List<Rank>> {
        val ranks = mutableListOf<Rank>()
        ranks.add(Rank("本日榜单",
                "${Constants.HOST}/cover/weathering_with_you.jpg",
                listOf(
                        RankItem("天气之子", "9.9"),
                        RankItem("天气之子", "9.9"),
                        RankItem("天气之子", "9.9"),
                        RankItem("天气之子", "9.9"),
                        RankItem("天气之子", "9.9")
                )
        ))
        ranks.add(Rank("top榜单",
                "${Constants.HOST}/cover/the_shawshank_redemption.jpg",
                listOf(
                        RankItem("肖申克的救赎", "9.9"),
                        RankItem("肖申克的救赎", "9.9"),
                        RankItem("肖申克的救赎", "9.9"),
                        RankItem("肖申克的救赎", "9.9"),
                        RankItem("肖申克的救赎", "9.9")
                )
        ))
        ranks.add(Rank("本月榜单",
                "${Constants.HOST}/cover/the_shawshank_redemption.jpg",
                listOf(
                        RankItem("肖申克的救赎", "9.9"),
                        RankItem("肖申克的救赎", "9.9"),
                        RankItem("肖申克的救赎", "9.9"),
                        RankItem("肖申克的救赎", "9.9"),
                        RankItem("肖申克的救赎", "9.9")
                )
        ))

        return BaseResponse(value = ranks)
    }

}