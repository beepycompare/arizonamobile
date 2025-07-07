package com.miami.game.core.files.updater.domain;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.miami.game.core.files.updater.domain.model.FilesUpdaterState;
import java.util.List;
import kotlin.Metadata;
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
/* compiled from: FilesUpdaterInteractor.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.files.updater.domain.FilesUpdaterInteractor$updateState$1", f = "FilesUpdaterInteractor.kt", i = {}, l = {124}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class FilesUpdaterInteractor$updateState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FilesUpdaterInteractor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilesUpdaterInteractor$updateState$1(FilesUpdaterInteractor filesUpdaterInteractor, Continuation<? super FilesUpdaterInteractor$updateState$1> continuation) {
        super(2, continuation);
        this.this$0 = filesUpdaterInteractor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FilesUpdaterInteractor$updateState$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FilesUpdaterInteractor$updateState$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        Object value;
        Object finalValidationFiles;
        MutableStateFlow mutableStateFlow2;
        Object value2;
        MutableStateFlow mutableStateFlow3;
        Object value3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            mutableStateFlow = this.this$0.stateStore;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, FilesUpdaterState.copy$default((FilesUpdaterState) value, 0L, null, 0L, null, 0L, true, false, false, 0L, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, false, false, false, 8031, null)));
            this.label = 1;
            finalValidationFiles = this.this$0.finalValidationFiles(this);
            if (finalValidationFiles == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
            finalValidationFiles = obj;
        }
        if (!((List) finalValidationFiles).isEmpty()) {
            mutableStateFlow3 = this.this$0.stateStore;
            do {
                value3 = mutableStateFlow3.getValue();
            } while (!mutableStateFlow3.compareAndSet(value3, FilesUpdaterState.copy$default((FilesUpdaterState) value3, 0L, null, 0L, null, 0L, false, false, false, 0L, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, true, false, false, 7167, null)));
        } else {
            mutableStateFlow2 = this.this$0.stateStore;
            do {
                value2 = mutableStateFlow2.getValue();
            } while (!mutableStateFlow2.compareAndSet(value2, FilesUpdaterState.copy$default((FilesUpdaterState) value2, 0L, null, 0L, null, 0L, false, false, false, 0L, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, false, true, false, 6143, null)));
        }
        return Unit.INSTANCE;
    }
}
