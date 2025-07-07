package ru.mrlargha.commonui.elements.battlepassWinter2025;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.GET;
import ru.mrlargha.commonui.elements.battlepassWinter2025.data.AwardItemData;
import ru.mrlargha.commonui.elements.battlepassWinter2025.data.CommonTaskInfo;
/* compiled from: WinterBattlePassApi.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H§@¢\u0006\u0002\u0010\u0005J\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H§@¢\u0006\u0002\u0010\u0005J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003H§@¢\u0006\u0002\u0010\u0005J\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0003H§@¢\u0006\u0002\u0010\u0005¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/battlepassWinter2025/WinterBattlePassApi;", "", "getCommonTasks", "", "Lru/mrlargha/commonui/elements/battlepassWinter2025/data/CommonTaskInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPremiumTasks", "getDefaultBP", "Lru/mrlargha/commonui/elements/battlepassWinter2025/data/AwardItemData;", "getGoldBP", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface WinterBattlePassApi {
    @GET("battlepass_new_mission_default.json")
    Object getCommonTasks(Continuation<? super List<CommonTaskInfo>> continuation);

    @GET("battlepass_new_level_default.json")
    Object getDefaultBP(Continuation<? super List<AwardItemData>> continuation);

    @GET("battlepass_new_level_gold.json")
    Object getGoldBP(Continuation<? super List<AwardItemData>> continuation);

    @GET("battlepass_new_mission_premium.json")
    Object getPremiumTasks(Continuation<? super List<CommonTaskInfo>> continuation);
}
