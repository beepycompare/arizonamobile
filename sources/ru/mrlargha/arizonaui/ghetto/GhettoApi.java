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
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H§@¢\u0006\u0002\u0010\u0005J\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003H§@¢\u0006\u0002\u0010\u0005J\u0018\u0010\b\u001a\u00020\t2\b\b\u0003\u0010\n\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\fJ\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003H§@¢\u0006\u0002\u0010\u0005¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lru/mrlargha/arizonaui/ghetto/GhettoApi;", "", "getMap", "", "Lru/mrlargha/arizonaui/ghetto/data/MapData;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCaptures", "Lru/mrlargha/arizonaui/ghetto/data/CaptureData;", "getCaptureCount", "Lru/mrlargha/arizonaui/ghetto/data/CaptureCount;", "fraction", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRating", "Lru/mrlargha/arizonaui/ghetto/data/RatingData;", "ArizonaUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
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
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
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
