package com.miami.game.feature.home.ui.compose;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: PlayContent.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.feature.home.ui.compose.PlayContentKt$PlayContent$1$1", f = "PlayContent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class PlayContentKt$PlayContent$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<String> $checkingFilesState;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayContentKt$PlayContent$1$1(MutableState<String> mutableState, Continuation<? super PlayContentKt$PlayContent$1$1> continuation) {
        super(2, continuation);
        this.$checkingFilesState = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PlayContentKt$PlayContent$1$1 playContentKt$PlayContent$1$1 = new PlayContentKt$PlayContent$1$1(this.$checkingFilesState, continuation);
        playContentKt$PlayContent$1$1.L$0 = obj;
        return playContentKt$PlayContent$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PlayContentKt$PlayContent$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayContent.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.miami.game.feature.home.ui.compose.PlayContentKt$PlayContent$1$1$1", f = "PlayContent.kt", i = {}, l = {46, 48, 50}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.miami.game.feature.home.ui.compose.PlayContentKt$PlayContent$1$1$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MutableState<String> $checkingFilesState;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(MutableState<String> mutableState, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$checkingFilesState = mutableState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$checkingFilesState, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x003a, code lost:
            if (kotlinx.coroutines.DelayKt.delay(15000, r7) == r0) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x004d, code lost:
            if (kotlinx.coroutines.DelayKt.delay(15000, r7) == r0) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0060, code lost:
            if (kotlinx.coroutines.DelayKt.delay(15000, r7) == r0) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0062, code lost:
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
                this.$checkingFilesState.setValue("Проверка наличия обновления...");
                this.label = 1;
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else if (i != 2) {
                if (i == 3) {
                    ResultKt.throwOnFailure(obj);
                    this.$checkingFilesState.setValue("Подготовка к обновлению...");
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
                this.$checkingFilesState.setValue("Проверяем файлы обновления...");
                this.label = 3;
            }
            this.$checkingFilesState.setValue("Загружаем информацию обновления...");
            this.label = 2;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(this.$checkingFilesState, null), 3, null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
