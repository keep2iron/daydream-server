package io.github.keep2iron.daydream.entity.dto

data class Rank(
        /**
         * 榜单title
         */
        val rankTitle: String,
        /**
         * 榜单封面
         */
        val rankCover: String,
        /**
         * 排行榜
         */
        val rankList: List<RankItem>
)

data class RankItem(
        /**
         * 影片名字
         */
        val movieName: String,
        /**
         * 影片评分
         */
        val movieEvaluate: String
)