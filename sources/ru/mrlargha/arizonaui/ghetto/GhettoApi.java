package ru.mrlargha.arizonaui.ghetto;

import com.arizona.game.BuildConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import ru.mrlargha.arizonaui.ghetto.data.CaptureCount;
import ru.mrlargha.arizonaui.ghetto.data.CaptureData;
import ru.mrlargha.arizonaui.ghetto.data.MapData;
import ru.mrlargha.arizonaui.ghetto.data.RatingData;
/* compiled from: GhettoApi.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\b\b\u0003\u0010\b\u001a\u00020\tH§@¢\u0006\u0002\u0010\nJ2\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\b\b\u0003\u0010\b\u001a\u00020\tH§@¢\u0006\u0002\u0010\nJ6\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\b\b\u0003\u0010\b\u001a\u00020\t2\b\b\u0003\u0010\u000f\u001a\u00020\tH§@¢\u0006\u0002\u0010\u0010J2\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\b\b\u0003\u0010\b\u001a\u00020\tH§@¢\u0006\u0002\u0010\n¨\u0006\u0013À\u0006\u0003"}, d2 = {"Lru/mrlargha/arizonaui/ghetto/GhettoApi;", "", "getMap", "", "Lru/mrlargha/arizonaui/ghetto/data/MapData;", "token", "", "project", "id", "", "(Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCaptures", "Lru/mrlargha/arizonaui/ghetto/data/CaptureData;", "getCaptureCount", "Lru/mrlargha/arizonaui/ghetto/data/CaptureCount;", "fraction", "(Ljava/lang/String;Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRating", "Lru/mrlargha/arizonaui/ghetto/data/RatingData;", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface GhettoApi {
    @GET("getCaptureCount")
    Object getCaptureCount(@Header("Authorization") String str, @Query("project") String str2, @Query("server") int i, @Query("fraction_id") int i2, Continuation<? super CaptureCount> continuation);

    @GET("getCaptures")
    Object getCaptures(@Header("Authorization") String str, @Query("project") String str2, @Query("server") int i, Continuation<? super List<CaptureData>> continuation);

    @GET("getMap")
    Object getMap(@Header("Authorization") String str, @Query("project") String str2, @Query("server") int i, Continuation<? super List<MapData>> continuation);

    @GET("getRating")
    Object getRating(@Header("Authorization") String str, @Query("project") String str2, @Query("server") int i, Continuation<? super List<RatingData>> continuation);

    /* compiled from: GhettoApi.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object getMap$default(GhettoApi ghettoApi, String str, String str2, int i, Continuation continuation, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                str2 = BuildConfig.FLAVOR;
            }
            if ((i2 & 4) != 0) {
                i = 0;
            }
            return ghettoApi.getMap(str, str2, i, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMap");
    }

    static /* synthetic */ Object getCaptures$default(GhettoApi ghettoApi, String str, String str2, int i, Continuation continuation, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                str2 = BuildConfig.FLAVOR;
            }
            if ((i2 & 4) != 0) {
                i = 0;
            }
            return ghettoApi.getCaptures(str, str2, i, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCaptures");
    }

    static /* synthetic */ Object getCaptureCount$default(GhettoApi ghettoApi, String str, String str2, int i, int i2, Continuation continuation, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                str2 = BuildConfig.FLAVOR;
            }
            return ghettoApi.getCaptureCount(str, str2, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCaptureCount");
    }

    static /* synthetic */ Object getRating$default(GhettoApi ghettoApi, String str, String str2, int i, Continuation continuation, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                str2 = BuildConfig.FLAVOR;
            }
            if ((i2 & 4) != 0) {
                i = 0;
            }
            return ghettoApi.getRating(str, str2, i, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getRating");
    }
}
