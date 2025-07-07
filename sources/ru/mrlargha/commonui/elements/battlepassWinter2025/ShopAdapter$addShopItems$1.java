package ru.mrlargha.commonui.elements.battlepassWinter2025;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import ru.mrlargha.commonui.elements.battlepassWinter2025.data.BattlePassShopData;
import ru.mrlargha.commonui.utils.UtilsKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShopAdapter.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.battlepassWinter2025.ShopAdapter$addShopItems$1", f = "ShopAdapter.kt", i = {0, 0}, l = {82}, m = "invokeSuspend", n = {"destination$iv$iv", "it"}, s = {"L$0", "L$2"})
/* loaded from: classes5.dex */
public final class ShopAdapter$addShopItems$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<BattlePassShopData> $shopList;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ ShopAdapter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShopAdapter$addShopItems$1(List<BattlePassShopData> list, ShopAdapter shopAdapter, Continuation<? super ShopAdapter$addShopItems$1> continuation) {
        super(2, continuation);
        this.$shopList = list;
        this.this$0 = shopAdapter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShopAdapter$addShopItems$1(this.$shopList, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ShopAdapter$addShopItems$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x006c -> B:15:0x006d). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ArrayList arrayList;
        Iterator it;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            List<BattlePassShopData> list = this.$shopList;
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            it = list.iterator();
            if (it.hasNext()) {
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            arrayList = (Collection) this.L$3;
            BattlePassShopData battlePassShopData = (BattlePassShopData) this.L$2;
            it = (Iterator) this.L$1;
            Collection collection = (Collection) this.L$0;
            ResultKt.throwOnFailure(obj);
            Bitmap bitmap = (Bitmap) obj;
            battlePassShopData.setSavedName(battlePassShopData.getItemId() > UtilsKt.getItemsName().size() - 1 ? UtilsKt.getItemsName().get(battlePassShopData.getItemId()).getName() : "unknown");
            battlePassShopData.setSavedImage(bitmap);
            arrayList.add(battlePassShopData);
            arrayList = collection;
            if (it.hasNext()) {
                battlePassShopData = (BattlePassShopData) it.next();
                this.L$0 = arrayList;
                this.L$1 = it;
                this.L$2 = battlePassShopData;
                this.L$3 = arrayList;
                this.label = 1;
                obj = BuildersKt.withContext(Dispatchers.getIO(), new ShopAdapter$addShopItems$1$resultList$1$bitmap$1(battlePassShopData, null), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                collection = arrayList;
                Bitmap bitmap2 = (Bitmap) obj;
                battlePassShopData.setSavedName(battlePassShopData.getItemId() > UtilsKt.getItemsName().size() - 1 ? UtilsKt.getItemsName().get(battlePassShopData.getItemId()).getName() : "unknown");
                battlePassShopData.setSavedImage(bitmap2);
                arrayList.add(battlePassShopData);
                arrayList = collection;
                if (it.hasNext()) {
                    ArrayList<BattlePassShopData> shopItemList = this.this$0.getShopItemList();
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj2 : (List) arrayList) {
                        if (((BattlePassShopData) obj2).getItemId() != 0) {
                            arrayList2.add(obj2);
                        }
                    }
                    shopItemList.addAll(arrayList2);
                    this.this$0.notifyDataSetChanged();
                    return Unit.INSTANCE;
                }
            }
        }
    }
}
