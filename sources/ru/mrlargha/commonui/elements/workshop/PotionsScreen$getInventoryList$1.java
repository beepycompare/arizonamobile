package ru.mrlargha.commonui.elements.workshop;

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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import ru.mrlargha.commonui.domain.db.AppDatabase;
import ru.mrlargha.commonui.domain.db.inventory.InventoryItemEntity;
import ru.mrlargha.commonui.elements.inventory.domain.models.InventoryItemKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PotionsScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.workshop.PotionsScreen$getInventoryList$1", f = "PotionsScreen.kt", i = {}, l = {822}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class PotionsScreen$getInventoryList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ PotionsScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PotionsScreen$getInventoryList$1(PotionsScreen potionsScreen, Continuation<? super PotionsScreen$getInventoryList$1> continuation) {
        super(2, continuation);
        this.this$0 = potionsScreen;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PotionsScreen$getInventoryList$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PotionsScreen$getInventoryList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        AppDatabase appDatabase;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            appDatabase = this.this$0.db;
            Flow<List<InventoryItemEntity>> collectInventoryList = appDatabase.inventoryItemDao().getCollectInventoryList();
            final PotionsScreen potionsScreen = this.this$0;
            this.label = 1;
            if (collectInventoryList.collect(new FlowCollector() { // from class: ru.mrlargha.commonui.elements.workshop.PotionsScreen$getInventoryList$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((List) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(List<InventoryItemEntity> list, Continuation<? super Unit> continuation) {
                    List list2;
                    PotionsScreen potionsScreen2 = PotionsScreen.this;
                    List<InventoryItemEntity> list3 = list;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
                    for (InventoryItemEntity inventoryItemEntity : list3) {
                        arrayList.add(InventoryItemKt.toUi(inventoryItemEntity));
                    }
                    potionsScreen2.inventoryList = CollectionsKt.toMutableList((Collection) arrayList);
                    list2 = PotionsScreen.this.inventoryItemList;
                    if (list2.isEmpty()) {
                        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(PotionsScreen.this, null), continuation);
                        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
                    }
                    return Unit.INSTANCE;
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: PotionsScreen.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "ru.mrlargha.commonui.elements.workshop.PotionsScreen$getInventoryList$1$1$2", f = "PotionsScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: ru.mrlargha.commonui.elements.workshop.PotionsScreen$getInventoryList$1$1$2  reason: invalid class name */
                /* loaded from: classes5.dex */
                public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    int label;
                    final /* synthetic */ PotionsScreen this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass2(PotionsScreen potionsScreen, Continuation<? super AnonymousClass2> continuation) {
                        super(2, continuation);
                        this.this$0 = potionsScreen;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass2(this.this$0, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label == 0) {
                            ResultKt.throwOnFailure(obj);
                            this.this$0.addLockedItems();
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
