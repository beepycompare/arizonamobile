package ru.mrlargha.commonui.elements.inventory.domain;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.mrlargha.commonui.utils.ItemsInfo;
/* compiled from: InventoryApi.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J:\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0016\b\u0003\u0010\u0005\u001a\u00020\u0006:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0005H§@b\f\b\n\u0012\b\b\b\u0012\u0004\b\b(\u000b¢\u0006\u0002\u0010\t¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lru/mrlargha/commonui/elements/inventory/domain/InventoryApi;", "", "get", "", "Lru/mrlargha/commonui/utils/ItemsInfo;", "key", "", "Lretrofit2/http/Query;", "value", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lretrofit2/http/GET;", "/client/json/table/get", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface InventoryApi {
    @GET("/client/json/table/get")
    Object get(@Query("key") String str, Continuation<? super List<ItemsInfo>> continuation);

    /* compiled from: InventoryApi.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object get$default(InventoryApi inventoryApi, String str, Continuation continuation, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = "inventory_items";
            }
            return inventoryApi.get(str, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: get");
    }
}
