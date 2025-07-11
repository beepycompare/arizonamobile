package ru.mrlargha.commonui.elements.inventory.presentation;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import ru.mrlargha.commonui.domain.db.AppDatabase;
import ru.mrlargha.commonui.domain.db.inventory.InventoryItemDao;
import ru.mrlargha.commonui.domain.db.inventory.InventoryItemEntity;
import ru.mrlargha.commonui.elements.inventory.domain.models.InventoryItem;
import ru.mrlargha.commonui.elements.inventory.domain.models.InventoryItemKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InventoryScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$addInfoToDatabase$1", f = "InventoryScreen.kt", i = {0, 0, 0, 0, 0}, l = {1953}, m = "invokeSuspend", n = {"$this$forEach$iv", "element$iv", "it", "$i$f$forEach", "$i$a$-forEach-InventoryScreen$addInfoToDatabase$1$1"}, s = {"L$0", "L$3", "L$4", "I$0", "I$1"})
/* loaded from: classes5.dex */
public final class InventoryScreen$addInfoToDatabase$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<InventoryItem> $list;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ InventoryScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InventoryScreen$addInfoToDatabase$1(InventoryScreen inventoryScreen, List<InventoryItem> list, Continuation<? super InventoryScreen$addInfoToDatabase$1> continuation) {
        super(2, continuation);
        this.this$0 = inventoryScreen;
        this.$list = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InventoryScreen$addInfoToDatabase$1(this.this$0, this.$list, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InventoryScreen$addInfoToDatabase$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        AppDatabase appDatabase;
        Iterator it;
        Iterable iterable;
        InventoryScreen inventoryScreen;
        int i;
        AppDatabase appDatabase2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                appDatabase = this.this$0.db;
                appDatabase.inventoryItemDao().deleteAllItems();
                List<InventoryItem> list = this.$list;
                InventoryScreen inventoryScreen2 = this.this$0;
                it = list.iterator();
                iterable = list;
                inventoryScreen = inventoryScreen2;
                i = 0;
            } else if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                i = this.I$0;
                InventoryItem inventoryItem = (InventoryItem) this.L$4;
                it = (Iterator) this.L$2;
                inventoryScreen = (InventoryScreen) this.L$1;
                iterable = (Iterable) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            while (it.hasNext()) {
                Object next = it.next();
                InventoryItem inventoryItem2 = (InventoryItem) next;
                appDatabase2 = inventoryScreen.db;
                InventoryItemDao inventoryItemDao = appDatabase2.inventoryItemDao();
                InventoryItemEntity entity = InventoryItemKt.toEntity(inventoryItem2);
                this.L$0 = SpillingKt.nullOutSpilledVariable(iterable);
                this.L$1 = inventoryScreen;
                this.L$2 = it;
                this.L$3 = SpillingKt.nullOutSpilledVariable(next);
                this.L$4 = SpillingKt.nullOutSpilledVariable(inventoryItem2);
                this.I$0 = i;
                this.I$1 = 0;
                this.label = 1;
                if (inventoryItemDao.insertAll(entity, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Unit.INSTANCE;
    }
}
