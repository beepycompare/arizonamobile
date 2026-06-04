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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.settings.SettingsInteractor$getSettings$1", f = "SettingsInteractor.kt", i = {0, 0, 0}, l = {361}, m = "invokeSuspend", n = {"$this$getSuspend$iv", "key$iv", "notification"}, nl = {118}, s = {"L$0", "L$1", "Z$0"}, v = 2)
/* loaded from: classes5.dex */
public final class SettingsInteractor$getSettings$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
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
        SettingsInteractor settingsInteractor;
        LocalRepository localRepository2;
        boolean z;
        SettingState normalizeLoadedSettings;
        MutableStateFlow mutableStateFlow;
        Object value;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            localRepository = this.this$0.localRepository;
            boolean areNotificationsEnabled = NotificationManagerCompat.from(localRepository.getContext()).areNotificationsEnabled();
            settingsInteractor = this.this$0;
            localRepository2 = settingsInteractor.localRepository;
            LocalRepository localRepository3 = localRepository2;
            this.L$0 = SpillingKt.nullOutSpilledVariable(localRepository3);
            this.L$1 = SpillingKt.nullOutSpilledVariable(SettingsInteractor.SettingsKey);
            this.L$2 = settingsInteractor;
            this.Z$0 = areNotificationsEnabled;
            this.label = 1;
            Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new SettingsInteractor$getSettings$1$invokeSuspend$$inlined$getSuspend$1(localRepository3, SettingsInteractor.SettingsKey, null), this);
            if (withContext == coroutine_suspended) {
                return coroutine_suspended;
            }
            z = areNotificationsEnabled;
            obj = withContext;
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            z = this.Z$0;
            settingsInteractor = (SettingsInteractor) this.L$2;
            String str = (String) this.L$1;
            IKeyValueRepository iKeyValueRepository = (IKeyValueRepository) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        SettingState settingState = (SettingState) obj;
        if (settingState == null) {
            settingState = SettingState.Companion.init(this.this$0.isTablet());
        }
        normalizeLoadedSettings = settingsInteractor.normalizeLoadedSettings(settingState, z);
        mutableStateFlow = this.this$0.stateStore;
        do {
            value = mutableStateFlow.getValue();
            SettingState settingState2 = (SettingState) value;
        } while (!mutableStateFlow.compareAndSet(value, normalizeLoadedSettings));
        return Unit.INSTANCE;
    }
}
