package com.miami.game.core.settings;

import android.net.Uri;
import com.miami.game.core.local.repository.common.LocalRepository;
import com.miami.game.core.settings.game_test.GameTestSavedScript;
import com.miami.game.core.settings.game_test.GameTestScriptStorage;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingsInteractor.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.settings.SettingsInteractor$importGameTestScript$1", f = "SettingsInteractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
/* loaded from: classes5.dex */
public final class SettingsInteractor$importGameTestScript$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Uri $uri;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SettingsInteractor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsInteractor$importGameTestScript$1(SettingsInteractor settingsInteractor, Uri uri, Continuation<? super SettingsInteractor$importGameTestScript$1> continuation) {
        super(2, continuation);
        this.this$0 = settingsInteractor;
        this.$uri = uri;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SettingsInteractor$importGameTestScript$1 settingsInteractor$importGameTestScript$1 = new SettingsInteractor$importGameTestScript$1(this.this$0, this.$uri, continuation);
        settingsInteractor$importGameTestScript$1.L$0 = obj;
        return settingsInteractor$importGameTestScript$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SettingsInteractor$importGameTestScript$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m9919constructorimpl;
        LocalRepository localRepository;
        MutableStateFlow mutableStateFlow;
        LocalRepository localRepository2;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        SettingsInteractor settingsInteractor = this.this$0;
        Uri uri = this.$uri;
        try {
            Result.Companion companion = Result.Companion;
            localRepository = settingsInteractor.localRepository;
            GameTestSavedScript importScript = GameTestScriptStorage.importScript(localRepository.getContext(), uri);
            mutableStateFlow = settingsInteractor.stateStore;
            String displayName = importScript.getDisplayName();
            String fileName = importScript.getFileName();
            localRepository2 = settingsInteractor.localRepository;
            settingsInteractor.saveSettings(SettingState.copy$default((SettingState) mutableStateFlow.getValue(), 0.0f, 0, false, false, false, false, false, false, false, false, false, true, displayName, fileName, GameTestScriptStorage.listImportedScripts(localRepository2.getContext()), null, false, false, null, null, 1017855, null));
            settingsInteractor.showToast("Тестовый сценарий импортирован", 0);
            m9919constructorimpl = Result.m9919constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9919constructorimpl = Result.m9919constructorimpl(ResultKt.createFailure(th));
        }
        SettingsInteractor settingsInteractor2 = this.this$0;
        Throwable m9922exceptionOrNullimpl = Result.m9922exceptionOrNullimpl(m9919constructorimpl);
        if (m9922exceptionOrNullimpl != null) {
            String message = m9922exceptionOrNullimpl.getMessage();
            if (message == null) {
                message = "Не удалось импортировать сценарий";
            }
            settingsInteractor2.showToast(message, 1);
        }
        return Unit.INSTANCE;
    }
}
