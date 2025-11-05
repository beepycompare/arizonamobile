package ru.mrlargha.feature.battlepassWinter2025;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.mrlargha.feature.battlepassWinter2025.data.AwardItemData;
import ru.mrlargha.feature.battlepassWinter2025.data.CommonTaskInfo;
/* compiled from: WinterBattlePassApi.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lru/mrlargha/feature/battlepassWinter2025/WinterBattlePassApi;", "", "getCommonTasks", "", "Lru/mrlargha/feature/battlepassWinter2025/data/CommonTaskInfo;", "key", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPremiumTasks", "getDefaultBP", "Lru/mrlargha/feature/battlepassWinter2025/data/AwardItemData;", "getGoldBP", "battle-pass_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface WinterBattlePassApi {
    @GET("/client/json/table/get")
    Object getCommonTasks(@Query("key") String str, Continuation<? super List<CommonTaskInfo>> continuation);

    @GET("/client/json/table/get")
    Object getDefaultBP(@Query("key") String str, Continuation<? super List<AwardItemData>> continuation);

    @GET("/client/json/table/get")
    Object getGoldBP(@Query("key") String str, Continuation<? super List<AwardItemData>> continuation);

    @GET("/client/json/table/get")
    Object getPremiumTasks(@Query("key") String str, Continuation<? super List<CommonTaskInfo>> continuation);

    /* compiled from: WinterBattlePassApi.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object getGoldBP$default(WinterBattlePassApi winterBattlePassApi, String str, Continuation continuation, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = "battlepass_awards_gold";
            }
            return winterBattlePassApi.getGoldBP(str, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getGoldBP");
    }
}
