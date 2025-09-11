package com.miami.game.core.settings;

import androidx.core.app.NotificationManagerCompat;
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
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingsInteractor.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.settings.SettingsInteractor$getSettings$1", f = "SettingsInteractor.kt", i = {0, 0, 0, 0}, l = {72}, m = "invokeSuspend", n = {"$this$getSuspend$iv", "key$iv", "notification", "$i$f$getSuspend"}, s = {"L$0", "L$1", "Z$0", "I$0"}, v = 1)
/* loaded from: classes4.dex */
public final class SettingsInteractor$getSettings$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    Object L$0;
    Object L$1;
    boolean Z$0;
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
        LocalRepository localRepository2;
        Object withContext;
        boolean z;
        MutableStateFlow mutableStateFlow;
        Object value;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            localRepository = this.this$0.localRepository;
            boolean areNotificationsEnabled = NotificationManagerCompat.from(localRepository.getContext()).areNotificationsEnabled();
            localRepository2 = this.this$0.localRepository;
            LocalRepository localRepository3 = localRepository2;
            String settingsKey = SettingsInteractor.Companion.getSettingsKey();
            this.L$0 = SpillingKt.nullOutSpilledVariable(localRepository3);
            this.L$1 = SpillingKt.nullOutSpilledVariable(settingsKey);
            this.Z$0 = areNotificationsEnabled;
            this.I$0 = 0;
            this.label = 1;
            withContext = BuildersKt.withContext(Dispatchers.getIO(), new SettingsInteractor$getSettings$1$invokeSuspend$$inlined$getSuspend$1(localRepository3, settingsKey, null), this);
            if (withContext == coroutine_suspended) {
                return coroutine_suspended;
            }
            z = areNotificationsEnabled;
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            boolean z2 = this.Z$0;
            String str = (String) this.L$1;
            IKeyValueRepository iKeyValueRepository = (IKeyValueRepository) this.L$0;
            ResultKt.throwOnFailure(obj);
            withContext = obj;
            z = z2;
        }
        SettingState settingState = (SettingState) withContext;
        SettingState settingState2 = settingState == null ? new SettingState(0.0f, 0, false, false, false, false, false, false, null, 511, null) : settingState;
        mutableStateFlow = this.this$0.stateStore;
        do {
            value = mutableStateFlow.getValue();
            SettingState settingState3 = (SettingState) value;
        } while (!mutableStateFlow.compareAndSet(value, SettingState.copy$default(settingState2, 0.0f, 0, false, false, false, false, false, z, null, 383, null)));
        return Unit.INSTANCE;
    }
}
