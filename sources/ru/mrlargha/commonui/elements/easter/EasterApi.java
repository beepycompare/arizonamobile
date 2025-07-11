package ru.mrlargha.commonui.elements.easter;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.GET;
import ru.mrlargha.commonui.elements.easter.data.AwardItemData;
/* compiled from: EasterApi.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H§@¢\u0006\u0002\u0010\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lru/mrlargha/commonui/elements/easter/EasterApi;", "", "getDefaultBP", "", "Lru/mrlargha/commonui/elements/easter/data/AwardItemData;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface EasterApi {
    @GET("level_data.json")
    Object getDefaultBP(Continuation<? super List<AwardItemData>> continuation);
}
