package com.shine.wechat;

import android.util.Log;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * @desc:
 * @author: jiangcy
 * @date: 16-9-9
 * @time: 上午9:05
 */
public enum WeChatApi {
	instance;
	private String baseurl = "http://apis.baidu.com";
	private String baiduApiKey = "8471427c1e726ff7e0cfadd3166c08a8";

	public void getHotArticle(int num, int rand, String word, int page, String src) {
		Retrofit retrofit = new Retrofit
				.Builder()
				.addConverterFactory(GsonConverterFactory.create())
				.baseUrl(baseurl).build();
		WechatService service = retrofit.create(WechatService.class);
		Call<WeChatResult> call = service.getHotArticle(baiduApiKey, num, rand, word, page, src);
		call.enqueue(new Callback<WeChatResult>() {
			@Override public void onResponse(Call<WeChatResult> call, Response<WeChatResult> response) {
				Log.e("jiangcy", "call   " + call.toString());
				WeChatResult result = response.body();
				Log.e("jiangcy", "response " + result.toString());
			}

			@Override public void onFailure(Call<WeChatResult> call, Throwable t) {
				try {
					Log.e("jiangcy", "" + call.toString());
				} catch (Exception e) {
				}
				Log.e("jiangcy", "   " + t.toString());
			}
		});
	}

	public void getHotArticleRx(int num, int rand, String word, int page, String src) {
		Retrofit retrofit = new Retrofit
				.Builder()
				.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
				.addConverterFactory(GsonConverterFactory.create())
				.baseUrl(baseurl).build();
		WechatService service = retrofit.create(WechatService.class);
		Observable<WeChatResult> resultObser = service.getHotArticleRx(baiduApiKey, num, rand, word, page, src);
		resultObser.subscribeOn(Schedulers.newThread()
		).subscribe(new Action1<WeChatResult>() {
			@Override public void call(WeChatResult weChatResult) {
				Log.e("jiangcy", "" + weChatResult.toString());
			}
		}, new Action1<Throwable>() {
			@Override public void call(Throwable throwable) {
				Log.e("jiangcy", "" + throwable.toString());
			}
		}, new Action0() {
			@Override public void call() {
				Log.e("jiangcy", "call");
			}
		});
	}

	public void getHotArticleRxJack(int num, int rand, String word, int page, String src) {
		Retrofit retrofit = new Retrofit
				.Builder()
				.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
				.addConverterFactory(JacksonConverterFactory.create())
				.baseUrl(baseurl).build();
		WechatService service = retrofit.create(WechatService.class);
		Observable<WeChatResult> resultObser = service.getHotArticleRx(baiduApiKey, num, rand, word, page, src);
		resultObser.subscribeOn(Schedulers.newThread()
		).subscribe(new Action1<WeChatResult>() {
			@Override public void call(WeChatResult weChatResult) {
				Log.e("jiangcy", "" + weChatResult.toString());
			}
		}, new Action1<Throwable>() {
			@Override public void call(Throwable throwable) {
				Log.e("jiangcy", "" + throwable.toString());
			}
		}, new Action0() {
			@Override public void call() {
				Log.e("jiangcy", "call");
			}
		});
	}
	public void getHotArticleRxString(int num, int rand, String word, int page, String src) {
		Retrofit retrofit = new Retrofit
				.Builder()
				.addConverterFactory(new ToStringConverterFactory())
				.baseUrl(baseurl).build();
		WechatService service = retrofit.create(WechatService.class);
		Call<String> resultObser = service.getHotArticleStr(baiduApiKey, num, rand, word, page, src);
		resultObser.enqueue(new Callback<String>() {
			@Override public void onResponse(Call<String> call, Response<String> response) {
				Log.e("jiangcy", "ToStringConverterFactory : " + response.body().toString());
			}

			@Override public void onFailure(Call<String> call, Throwable t) {

			}
		});
	}
}
