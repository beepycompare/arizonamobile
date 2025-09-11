package ru.mrlargha.commonui.elements.animation.presentation;

import androidx.compose.runtime.ComposerKt;
import com.arizona.game.BuildConfig;
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
import ru.mrlargha.commonui.elements.animation.domain.obj.AnimationApi;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AnimationMenu.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.animation.presentation.AnimationMenu$initRetrofit$1", f = "AnimationMenu.kt", i = {}, l = {200, ComposerKt.providerKey}, m = "invokeSuspend", n = {}, s = {}, v = 1)
/* loaded from: classes5.dex */
public final class AnimationMenu$initRetrofit$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ AnimationMenu this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnimationMenu$initRetrofit$1(AnimationMenu animationMenu, Continuation<? super AnimationMenu$initRetrofit$1> continuation) {
        super(2, continuation);
        this.this$0 = animationMenu;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AnimationMenu$initRetrofit$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AnimationMenu$initRetrofit$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0060, code lost:
        if (r14 == r0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0082, code lost:
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new ru.mrlargha.commonui.elements.animation.presentation.AnimationMenu$initRetrofit$1.AnonymousClass1(r13.this$0, null), r13) == r0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0084, code lost:
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        AnimationMenu animationMenu;
        AnimationApi animationApi;
        AnimationApi animationApi2;
        String token;
        int i;
        boolean z;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            animationMenu = this.this$0;
            animationApi = animationMenu.api;
            if (animationApi == null) {
                Intrinsics.throwUninitializedPropertyAccessException("api");
                animationApi2 = null;
            } else {
                animationApi2 = animationApi;
            }
            token = this.this$0.getToken();
            i = this.this$0.serverId;
            z = this.this$0.isArizonaType;
            String str = z ? BuildConfig.FLAVOR : "rodina";
            this.L$0 = animationMenu;
            this.label = 1;
            obj = AnimationApi.getAnimations$default(animationApi2, token, str, i, null, this, 8, null);
        } else if (i2 != 1) {
            if (i2 == 2) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            animationMenu = (AnimationMenu) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        animationMenu.animationListApi = (List) obj;
        this.L$0 = null;
        this.label = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnimationMenu.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "ru.mrlargha.commonui.elements.animation.presentation.AnimationMenu$initRetrofit$1$1", f = "AnimationMenu.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: ru.mrlargha.commonui.elements.animation.presentation.AnimationMenu$initRetrofit$1$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AnimationMenu this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(AnimationMenu animationMenu, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = animationMenu;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0.mergeAnimations();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
