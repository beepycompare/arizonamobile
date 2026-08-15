package com.google.firebase.sessions.settings;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
/* compiled from: SettingsCache.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/google/firebase/sessions/settings/SessionConfigs;", "it"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.google.firebase.sessions.settings.SettingsCacheImpl$updateConfigs$2", f = "SettingsCache.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class SettingsCacheImpl$updateConfigs$2 extends SuspendLambda implements Function2<SessionConfigs, Continuation<? super SessionConfigs>, Object> {
    final /* synthetic */ SessionConfigs $sessionConfigs;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsCacheImpl$updateConfigs$2(SessionConfigs sessionConfigs, Continuation<? super SettingsCacheImpl$updateConfigs$2> continuation) {
        super(2, continuation);
        this.$sessionConfigs = sessionConfigs;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SettingsCacheImpl$updateConfigs$2(this.$sessionConfigs, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SessionConfigs sessionConfigs, Continuation<? super SessionConfigs> continuation) {
        return ((SettingsCacheImpl$updateConfigs$2) create(sessionConfigs, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return this.$sessionConfigs;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
