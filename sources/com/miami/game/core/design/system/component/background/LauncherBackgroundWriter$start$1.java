package com.miami.game.core.design.system.component.background;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackgroundManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.design.system.component.background.LauncherBackgroundWriter$start$1", f = "BackgroundManager.kt", i = {}, l = {102, 103}, m = "invokeSuspend", n = {}, nl = {103, -1}, s = {}, v = 2)
/* loaded from: classes5.dex */
public final class LauncherBackgroundWriter$start$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Job $initialJob;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LauncherBackgroundWriter$start$1(Job job, Continuation<? super LauncherBackgroundWriter$start$1> continuation) {
        super(2, continuation);
        this.$initialJob = job;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LauncherBackgroundWriter$start$1(this.$initialJob, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LauncherBackgroundWriter$start$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002c, code lost:
        if (r4.$initialJob.join(r4) == r0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0042, code lost:
        if (com.miami.game.core.connection.resolver.FirebaseConfigHelper.INSTANCE.getRemoteConfigUpdates().collect(com.miami.game.core.design.system.component.background.LauncherBackgroundWriter$start$1.AnonymousClass1.INSTANCE, r4) == r0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0044, code lost:
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
        } else if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            throw new KotlinNothingValueException();
        } else {
            ResultKt.throwOnFailure(obj);
        }
        this.label = 2;
    }
}
