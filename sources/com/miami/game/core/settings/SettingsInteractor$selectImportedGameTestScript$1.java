package com.miami.game.core.settings;

import com.miami.game.core.local.repository.common.LocalRepository;
import com.miami.game.core.settings.game_test.GameTestSavedScript;
import com.miami.game.core.settings.game_test.GameTestScriptStorage;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingsInteractor.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.settings.SettingsInteractor$selectImportedGameTestScript$1", f = "SettingsInteractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
/* loaded from: classes5.dex */
public final class SettingsInteractor$selectImportedGameTestScript$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $fileName;
    int label;
    final /* synthetic */ SettingsInteractor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsInteractor$selectImportedGameTestScript$1(SettingsInteractor settingsInteractor, String str, Continuation<? super SettingsInteractor$selectImportedGameTestScript$1> continuation) {
        super(2, continuation);
        this.this$0 = settingsInteractor;
        this.$fileName = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SettingsInteractor$selectImportedGameTestScript$1(this.this$0, this.$fileName, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SettingsInteractor$selectImportedGameTestScript$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        LocalRepository localRepository;
        Object obj2;
        MutableStateFlow mutableStateFlow;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            localRepository = this.this$0.localRepository;
            List<GameTestSavedScript> listImportedScripts = GameTestScriptStorage.listImportedScripts(localRepository.getContext());
            String str = this.$fileName;
            Iterator<T> it = listImportedScripts.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj2 = null;
                    break;
                }
                obj2 = it.next();
                if (Intrinsics.areEqual(((GameTestSavedScript) obj2).getFileName(), str)) {
                    break;
                }
            }
            GameTestSavedScript gameTestSavedScript = (GameTestSavedScript) obj2;
            SettingsInteractor settingsInteractor = this.this$0;
            if (gameTestSavedScript == null) {
                settingsInteractor.showToast("Script not found", 1);
                this.this$0.getSettings();
                return Unit.INSTANCE;
            }
            mutableStateFlow = settingsInteractor.stateStore;
            this.this$0.saveSettings(SettingState.copy$default((SettingState) mutableStateFlow.getValue(), 0.0f, 0, false, false, false, false, false, false, false, false, false, true, gameTestSavedScript.getDisplayName(), gameTestSavedScript.getFileName(), listImportedScripts, null, false, null, null, 493567, null));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
