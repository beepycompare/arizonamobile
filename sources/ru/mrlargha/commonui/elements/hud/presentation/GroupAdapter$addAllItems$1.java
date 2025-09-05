package ru.mrlargha.commonui.elements.hud.presentation;

import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import ru.mrlargha.commonui.elements.hud.presentation.models.GroupItem;
/* compiled from: GroupAdapter.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.hud.presentation.GroupAdapter$addAllItems$1", f = "GroupAdapter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class GroupAdapter$addAllItems$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<GroupItem> $items;
    int label;
    final /* synthetic */ GroupAdapter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupAdapter$addAllItems$1(GroupAdapter groupAdapter, List<GroupItem> list, Continuation<? super GroupAdapter$addAllItems$1> continuation) {
        super(2, continuation);
        this.this$0 = groupAdapter;
        this.$items = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GroupAdapter$addAllItems$1(this.this$0, this.$items, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GroupAdapter$addAllItems$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.this$0.getItemsList().addAll(this.$items);
        List<GroupItem> itemsList = this.this$0.getItemsList();
        if (itemsList.size() > 1) {
            CollectionsKt.sortWith(itemsList, new Comparator() { // from class: ru.mrlargha.commonui.elements.hud.presentation.GroupAdapter$addAllItems$1$invokeSuspend$$inlined$sortBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Integer.valueOf(((GroupItem) t).getId()), Integer.valueOf(((GroupItem) t2).getId()));
                }
            });
        }
        this.this$0.notifyDataSetChanged();
        return Unit.INSTANCE;
    }
}
