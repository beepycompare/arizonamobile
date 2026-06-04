package com.arizona.launcher.util;

import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import kotlin.Metadata;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
/* compiled from: TrackUsAPI.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J¤\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0016\b\u0001\u0010\u0005\u001a\u00020\u0006:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t2\u0016\b\u0001\u0010\n\u001a\u00020\u0006:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b2\u0016\b\u0001\u0010\f\u001a\u00020\u0006:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r2\u0016\b\u0001\u0010\u000e\u001a\u00020\u0006:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000f2\u0016\b\u0001\u0010\u0010\u001a\u00020\u0006:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u00102\u0016\b\u0001\u0010\u0011\u001a\u00020\u0006:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u00112\u0016\b\u0001\u0010\u0012\u001a\u00020\u0006:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u00122\u0016\b\u0001\u0010\u0013\u001a\u00020\u0006:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u00132\u0016\b\u0001\u0010\u0014\u001a\u00020\u0006:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u00152\u0016\b\u0001\u0010\u0016\u001a\u00020\u0006:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u00162\u0016\b\u0001\u0010\u0017\u001a\u00020\u0006:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0017H'b\f\b\u0018\u0012\b\b\b\u0012\u0004\b\b(\u0019¨\u0006\u001aÀ\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/util/TrackUsAPI;", "", "sendTrackUsReq", "Lretrofit2/Call;", "Lokhttp3/ResponseBody;", "bidID", "", "Lretrofit2/http/Query;", "value", "x", "goalId", "goal_id", "attrType", "attr_type", "isAttributed", "is_attributed", "tracker", "bundle", CommonUrlParts.MODEL, "os", "osVer", "os_ver", "lang", "type", "Lretrofit2/http/GET;", "conv", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface TrackUsAPI {
    @GET("conv")
    Call<ResponseBody> sendTrackUsReq(@Query("x") String str, @Query("goal_id") String str2, @Query("attr_type") String str3, @Query("is_attributed") String str4, @Query("tracker") String str5, @Query("bundle") String str6, @Query("model") String str7, @Query("os") String str8, @Query("os_ver") String str9, @Query("lang") String str10, @Query("type") String str11);
}
