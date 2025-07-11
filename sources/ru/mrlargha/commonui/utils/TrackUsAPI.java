package ru.mrlargha.commonui.utils;

import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import kotlin.Metadata;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
/* compiled from: TrackUsAPI.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001J|\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020\u00062\b\b\u0001\u0010\r\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010\u0010\u001a\u00020\u0006H'¨\u0006\u0011À\u0006\u0003"}, d2 = {"Lru/mrlargha/commonui/utils/TrackUsAPI;", "", "sendTrackUsReq", "Lretrofit2/Call;", "Lokhttp3/ResponseBody;", "bidID", "", "goalId", "attrType", "isAttributed", "tracker", "bundle", CommonUrlParts.MODEL, "os", "osVer", "lang", "type", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface TrackUsAPI {
    @GET("conv")
    Call<ResponseBody> sendTrackUsReq(@Query("x") String str, @Query("goal_id") String str2, @Query("attr_type") String str3, @Query("is_attributed") String str4, @Query("tracker") String str5, @Query("bundle") String str6, @Query("model") String str7, @Query("os") String str8, @Query("os_ver") String str9, @Query("lang") String str10, @Query("type") String str11);
}
