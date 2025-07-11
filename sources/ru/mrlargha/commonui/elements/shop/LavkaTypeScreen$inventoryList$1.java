package ru.mrlargha.commonui.elements.shop;

import java.util.ArrayList;
import java.util.Collection;
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
import kotlinx.coroutines.CoroutineScope;
import ru.mrlargha.commonui.domain.db.AppDatabase;
import ru.mrlargha.commonui.domain.db.inventory.InventoryItemEntity;
import ru.mrlargha.commonui.elements.inventory.domain.models.InventoryItem;
import ru.mrlargha.commonui.elements.inventory.domain.models.InventoryItemKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LavkaTypeScreen.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.shop.LavkaTypeScreen$inventoryList$1", f = "LavkaTypeScreen.kt", i = {}, l = {96}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class LavkaTypeScreen$inventoryList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<InventoryItem>>, Object> {
    int label;
    final /* synthetic */ LavkaTypeScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LavkaTypeScreen$inventoryList$1(LavkaTypeScreen lavkaTypeScreen, Continuation<? super LavkaTypeScreen$inventoryList$1> continuation) {
        super(2, continuation);
        this.this$0 = lavkaTypeScreen;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LavkaTypeScreen$inventoryList$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<InventoryItem>> continuation) {
        return ((LavkaTypeScreen$inventoryList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        AppDatabase appDatabase;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            appDatabase = this.this$0.db;
            this.label = 1;
            obj = appDatabase.inventoryItemDao().getAll(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        List<InventoryItemEntity> list = (List) obj;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (InventoryItemEntity inventoryItemEntity : list) {
            arrayList.add(InventoryItemKt.toUi(inventoryItemEntity));
        }
        return CollectionsKt.toMutableList((Collection) arrayList);
    }
}
