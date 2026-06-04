package ru.mrlargha.arizonaui.ghetto;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.mrlargha.arizonaui.ghetto.data.CaptureCount;
import ru.mrlargha.arizonaui.ghetto.data.CaptureData;
import ru.mrlargha.arizonaui.ghetto.data.MapData;
import ru.mrlargha.arizonaui.ghetto.data.RatingData;
/* compiled from: GhettoApi.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H§@b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0002\u0010\u0005J\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003H§@b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000b¢\u0006\u0002\u0010\u0005J4\u0010\f\u001a\u00020\r2\u0016\b\u0003\u0010\u000e\u001a\u00020\u000f:\f\b\u0010\u0012\b\b\u0007\u0012\u0004\b\b(\u0011H§@b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0013¢\u0006\u0002\u0010\u0012J\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0003H§@b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0016¢\u0006\u0002\u0010\u0005¨\u0006\u0017À\u0006\u0003"}, d2 = {"Lru/mrlargha/arizonaui/ghetto/GhettoApi;", "", "getMap", "", "Lru/mrlargha/arizonaui/ghetto/data/MapData;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lretrofit2/http/GET;", "value", "client/ghetto/getMap", "getCaptures", "Lru/mrlargha/arizonaui/ghetto/data/CaptureData;", "client/ghetto/getCaptures", "getCaptureCount", "Lru/mrlargha/arizonaui/ghetto/data/CaptureCount;", "fraction", "", "Lretrofit2/http/Query;", "fraction_id", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "client/ghetto/getCaptureCount", "getRating", "Lru/mrlargha/arizonaui/ghetto/data/RatingData;", "client/ghetto/getRating", "ArizonaUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface GhettoApi {
    @GET("client/ghetto/getCaptureCount")
    Object getCaptureCount(@Query("fraction_id") int i, Continuation<? super CaptureCount> continuation);

    @GET("client/ghetto/getCaptures")
    Object getCaptures(Continuation<? super List<CaptureData>> continuation);

    @GET("client/ghetto/getMap")
    Object getMap(Continuation<? super List<MapData>> continuation);

    @GET("client/ghetto/getRating")
    Object getRating(Continuation<? super List<RatingData>> continuation);

    /* compiled from: GhettoApi.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object getCaptureCount$default(GhettoApi ghettoApi, int i, Continuation continuation, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                i = 0;
            }
            return ghettoApi.getCaptureCount(i, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCaptureCount");
    }
}
