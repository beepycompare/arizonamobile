package com.arizona.launcher;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FileCheckServiceFlow.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.FileCheckServiceFlow$requestFullCheck$task$1", f = "FileCheckServiceFlow.kt", i = {}, l = {61}, m = "invokeSuspend", n = {}, nl = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT}, s = {}, v = 2)
/* loaded from: classes3.dex */
public final class FileCheckServiceFlow$requestFullCheck$task$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Boolean> $releaseOperation;
    final /* synthetic */ long $token;
    int label;
    final /* synthetic */ FileCheckServiceFlow this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileCheckServiceFlow$requestFullCheck$task$1(FileCheckServiceFlow fileCheckServiceFlow, long j, Function0<Boolean> function0, Continuation<? super FileCheckServiceFlow$requestFullCheck$task$1> continuation) {
        super(1, continuation);
        this.this$0 = fileCheckServiceFlow;
        this.$token = j;
        this.$releaseOperation = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new FileCheckServiceFlow$requestFullCheck$task$1(this.this$0, this.$token, this.$releaseOperation, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((FileCheckServiceFlow$requestFullCheck$task$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v4, types: [kotlin.Unit, java.lang.Object] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object performFullCheck;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                performFullCheck = this.this$0.performFullCheck(this.$token, this.$releaseOperation, this);
                if (performFullCheck == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            this.$releaseOperation.invoke();
            this = Unit.INSTANCE;
            return this;
        } catch (Throwable th) {
            this.$releaseOperation.invoke();
            throw th;
        }
    }
}
