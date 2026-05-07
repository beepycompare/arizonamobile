package ru.mrlargha.commonui.elements.inventory.presentation;

import android.widget.ProgressBar;
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
import ru.mrlargha.commonui.databinding.MainInventoryBinding;
import ru.mrlargha.commonui.elements.inventory.domain.InventoryApi;
import ru.mrlargha.commonui.utils.UtilsKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InventoryScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$initRetrofit$1", f = "InventoryScreen.kt", i = {}, l = {456, 457}, m = "invokeSuspend", n = {}, nl = {457, 461}, s = {}, v = 2)
/* loaded from: classes6.dex */
public final class InventoryScreen$initRetrofit$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ InventoryScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InventoryScreen$initRetrofit$1(InventoryScreen inventoryScreen, Continuation<? super InventoryScreen$initRetrofit$1> continuation) {
        super(2, continuation);
        this.this$0 = inventoryScreen;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InventoryScreen$initRetrofit$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InventoryScreen$initRetrofit$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0031, code lost:
        if (r6 == r0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0051, code lost:
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$initRetrofit$1.AnonymousClass1(r5.this$0, null), r5) == r0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0053, code lost:
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
            obj = InventoryApi.get$default(this.this$0.getApi(), null, this, 1, null);
        } else if (i != 1) {
            if (i == 2) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        UtilsKt.setItemsName((List) obj);
        this.label = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: InventoryScreen.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$initRetrofit$1$1", f = "InventoryScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    /* renamed from: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$initRetrofit$1$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ InventoryScreen this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(InventoryScreen inventoryScreen, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = inventoryScreen;
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
            MainInventoryBinding mainInventoryBinding;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                mainInventoryBinding = this.this$0.binding;
                ProgressBar progressBar = mainInventoryBinding.progressBar;
                Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
                progressBar.setVisibility(8);
                this.this$0.getNotifier().clickedWrapper(this.this$0.getBackendID(), 0, 10);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
