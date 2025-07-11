package ru.mrlargha.commonui.elements.inventory.presentation;

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
@DebugMetadata(c = "ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$updateInfoToDatabase$1", f = "InventoryScreen.kt", i = {0, 0}, l = {1965}, m = "invokeSuspend", n = {"it", "$i$a$-let-InventoryScreen$updateInfoToDatabase$1$1"}, s = {"L$0", "I$0"})
/* loaded from: classes5.dex */
public final class InventoryScreen$updateInfoToDatabase$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ InventoryItem $item;
    int I$0;
    Object L$0;
    int label;
    final /* synthetic */ InventoryScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InventoryScreen$updateInfoToDatabase$1(InventoryItem inventoryItem, InventoryScreen inventoryScreen, Continuation<? super InventoryScreen$updateInfoToDatabase$1> continuation) {
        super(2, continuation);
        this.$item = inventoryItem;
        this.this$0 = inventoryScreen;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InventoryScreen$updateInfoToDatabase$1(this.$item, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InventoryScreen$updateInfoToDatabase$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        AppDatabase appDatabase;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            InventoryItem inventoryItem = this.$item;
            if (inventoryItem != null) {
                appDatabase = this.this$0.db;
                InventoryItemDao inventoryItemDao = appDatabase.inventoryItemDao();
                InventoryItemEntity entity = InventoryItemKt.toEntity(inventoryItem);
                this.L$0 = SpillingKt.nullOutSpilledVariable(inventoryItem);
                this.I$0 = 0;
                this.label = 1;
                if (inventoryItemDao.updateInfo(entity, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            InventoryItem inventoryItem2 = (InventoryItem) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
