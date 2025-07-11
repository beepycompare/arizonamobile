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
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import ru.mrlargha.commonui.elements.battlepassWinter2025.data.BattlePassShopData;
import ru.mrlargha.commonui.utils.UtilsKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShopAdapter.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.battlepassWinter2025.ShopAdapter$addShopItems$1", f = "ShopAdapter.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {82}, m = "invokeSuspend", n = {"$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "it", "$i$f$map", "$i$f$mapTo", "$i$a$-map-ShopAdapter$addShopItems$1$resultList$1"}, s = {"L$0", "L$1", "L$2", "L$4", "L$5", "I$0", "I$1", "I$2"})
/* loaded from: classes5.dex */
public final class ShopAdapter$addShopItems$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<BattlePassShopData> $shopList;
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00c9  */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.util.Collection] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0096 -> B:15:0x0097). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object obj3;
        ArrayList arrayList;
        int i;
        Iterator it;
        int i2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            List<BattlePassShopData> list = this.$shopList;
            obj2 = list;
            obj3 = obj2;
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            i = 0;
            it = list.iterator();
            i2 = 0;
            if (it.hasNext()) {
            }
        } else if (i3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            i = this.I$1;
            i2 = this.I$0;
            BattlePassShopData battlePassShopData = (BattlePassShopData) this.L$5;
            it = (Iterator) this.L$3;
            ?? r8 = (Collection) this.L$2;
            obj2 = (Iterable) this.L$1;
            obj3 = (Iterable) this.L$0;
            ResultKt.throwOnFailure(obj);
            ArrayList arrayList2 = (Collection) this.L$6;
            Bitmap bitmap = (Bitmap) obj;
            battlePassShopData.setSavedName(battlePassShopData.getItemId() > UtilsKt.getItemsName().size() - 1 ? UtilsKt.getItemsName().get(battlePassShopData.getItemId()).getName() : "unknown");
            battlePassShopData.setSavedImage(bitmap);
            arrayList2.add(battlePassShopData);
            arrayList = r8;
            if (it.hasNext()) {
                Object next = it.next();
                battlePassShopData = (BattlePassShopData) next;
                this.L$0 = SpillingKt.nullOutSpilledVariable(obj3);
                this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
                this.L$2 = arrayList;
                this.L$3 = it;
                this.L$4 = SpillingKt.nullOutSpilledVariable(next);
                this.L$5 = battlePassShopData;
                this.L$6 = arrayList;
                this.I$0 = i2;
                this.I$1 = i;
                this.I$2 = 0;
                this.label = 1;
                obj = BuildersKt.withContext(Dispatchers.getIO(), new ShopAdapter$addShopItems$1$resultList$1$bitmap$1(battlePassShopData, null), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                r8 = arrayList;
                arrayList2 = arrayList;
                Bitmap bitmap2 = (Bitmap) obj;
                battlePassShopData.setSavedName(battlePassShopData.getItemId() > UtilsKt.getItemsName().size() - 1 ? UtilsKt.getItemsName().get(battlePassShopData.getItemId()).getName() : "unknown");
                battlePassShopData.setSavedImage(bitmap2);
                arrayList2.add(battlePassShopData);
                arrayList = r8;
                if (it.hasNext()) {
                    ArrayList<BattlePassShopData> shopItemList = this.this$0.getShopItemList();
                    ArrayList arrayList3 = new ArrayList();
                    for (Object obj4 : arrayList) {
                        if (((BattlePassShopData) obj4).getItemId() != 0) {
                            arrayList3.add(obj4);
                        }
                    }
                    shopItemList.addAll(arrayList3);
                    this.this$0.notifyDataSetChanged();
                    return Unit.INSTANCE;
                }
            }
        }
    }
}
