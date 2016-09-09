package com.shine.wechat;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import rx.Observable;

/**
 * @desc:
 * @author: jiangcy
 * @date: 16-9-9
 * @time: 上午9:24
 */
public interface WechatService {
	@GET("/txapi/weixin/wxhot") Call<WeChatResult> getHotArticle(@Header("apikey") String apiKey, @Query("num") int num,
			@Query("rand") int rand, @Query("word") String word, @Query("page") int page,
			@Query("src") String src);

	@GET("/txapi/weixin/wxhot") Observable<WeChatResult> getHotArticleRx(@Header("apikey") String apiKey,
			@Query("num") int num, @Query("rand") int rand, @Query("word") String word, @Query("page") int page,
			@Query("src") String src);
	@GET("/txapi/weixin/wxhot") Call<String> getHotArticleStr(@Header("apikey") String apiKey,
			@Query("num") int num, @Query("rand") int rand, @Query("word") String word, @Query("page") int page,
			@Query("src") String src);
}
