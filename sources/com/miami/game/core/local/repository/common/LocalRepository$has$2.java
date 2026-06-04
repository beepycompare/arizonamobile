package com.miami.game.core.local.repository.common;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.datastore.core.DataStore;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LocalRepository.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.local.repository.common.LocalRepository$has$2", f = "LocalRepository.kt", i = {}, l = {67}, m = "invokeSuspend", n = {}, nl = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT}, s = {}, v = 2)
/* loaded from: classes5.dex */
public final class LocalRepository$has$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $key;
    int label;
    final /* synthetic */ LocalRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalRepository$has$2(LocalRepository localRepository, String str, Continuation<? super LocalRepository$has$2> continuation) {
        super(2, continuation);
        this.this$0 = localRepository;
        this.$key = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocalRepository$has$2(this.this$0, this.$key, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((LocalRepository$has$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        DataStore dataStore;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            dataStore = this.this$0.dataStorePreferences;
            this.label = 1;
            obj = FlowKt.firstOrNull(new LocalRepository$has$2$invokeSuspend$$inlined$map$1(dataStore.getData(), this.$key), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Boxing.boxBoolean(Intrinsics.areEqual(obj, Boxing.boxBoolean(true)));
    }
}
