package com.yangbw.libtest.api

import com.yangbw.libtest.base.BaseRes
import com.yangbw.libtest.module.login.UserData
import com.yangbw.libtest.module.details.DetailsData
import com.yangbw.libtest.module.home.BannerInfo
import com.yangbw.libtest.module.home.HomeData
import com.yangbw.libtest.module.home.UpdateVersion
import com.yangbw.libtest.module.mine.MineData
import retrofit2.http.*

/**
 * @author yangbw
 * @date 2020-03-16.
 * module：接口
 * description： 这里用的接口来自https://github.com/MZCretin/RollToolsApi，感谢MZCretin
 */
interface ApiService {

    @POST("api/login")
    @FormUrlEncoded
    suspend fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ): BaseRes<UserData>

    @POST("api/register")
    @FormUrlEncoded
    suspend fun register(
        @Field("username") username: String,
        @Field("password") password: String
    ): BaseRes<String>

    @GET("api/banners")
    suspend fun banners(): BaseRes<List<BannerInfo>>

    @GET("api/homes")
    suspend fun homes(@Query("pageNo") pageNo: Int): BaseRes<List<HomeData>>

    @GET("api/updateVersion")
    suspend fun updateVersion(@Query("versionCode") versonCode: Int): BaseRes<UpdateVersion>

    @GET("api/homeDetails")
    suspend fun homeDetails(@Query("id") id: String): BaseRes<DetailsData>

    @POST("api/userInfo")
    suspend fun userInfo(): BaseRes<MineData>
}