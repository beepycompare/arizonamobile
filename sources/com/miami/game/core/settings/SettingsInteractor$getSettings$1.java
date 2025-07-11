package com.miami.game.core.settings;

import com.miami.game.core.local.repository.common.IKeyValueRepository;
import com.miami.game.core.local.repository.common.LocalRepository;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingsInteractor.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.settings.SettingsInteractor$getSettings$1", f = "SettingsInteractor.kt", i = {0, 0, 0}, l = {LockFreeTaskQueueCore.CLOSED_SHIFT}, m = "invokeSuspend", n = {"$this$getSuspend$iv", "key$iv", "$i$f$getSuspend"}, s = {"L$0", "L$1", "I$0"})
/* loaded from: classes4.dex */
public final class SettingsInteractor$getSettings$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ SettingsInteractor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsInteractor$getSettings$1(SettingsInteractor settingsInteractor, Continuation<? super SettingsInteractor$getSettings$1> continuation) {
        super(2, continuation);
        this.this$0 = settingsInteractor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SettingsInteractor$getSettings$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SettingsInteractor$getSettings$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        LocalRepository localRepository;
        MutableStateFlow mutableStateFlow;
        Object value;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            localRepository = this.this$0.localRepository;
            LocalRepository localRepository2 = localRepository;
            String settingsKey = SettingsInteractor.Companion.getSettingsKey();
            this.L$0 = SpillingKt.nullOutSpilledVariable(localRepository2);
            this.L$1 = SpillingKt.nullOutSpilledVariable(settingsKey);
            this.I$0 = 0;
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new SettingsInteractor$getSettings$1$invokeSuspend$$inlined$getSuspend$1(localRepository2, settingsKey, null), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            String str = (String) this.L$1;
            IKeyValueRepository iKeyValueRepository = (IKeyValueRepository) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        SettingState settingState = (SettingState) obj;
        if (settingState == null) {
            settingState = new SettingState(0.0f, 0, false, false, false, false, false, null, 255, null);
        }
        mutableStateFlow = this.this$0.stateStore;
        do {
            value = mutableStateFlow.getValue();
            SettingState settingState2 = (SettingState) value;
        } while (!mutableStateFlow.compareAndSet(value, settingState));
        return Unit.INSTANCE;
    }
}
