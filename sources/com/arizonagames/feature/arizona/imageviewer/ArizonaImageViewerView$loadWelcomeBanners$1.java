package com.arizonagames.feature.arizona.imageviewer;

import android.util.Log;
import com.arizonagames.feature.arizona.imageviewer.databinding.ArizonaImageViewerBinding;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArizonaImageViewerView.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizonagames.feature.arizona.imageviewer.ArizonaImageViewerView$loadWelcomeBanners$1", f = "ArizonaImageViewerView.kt", i = {1, 2}, l = {86, 87, 94}, m = "invokeSuspend", n = {"loadedItems", "error"}, nl = {87, 90, 98}, s = {"L$0", "L$0"}, v = 2)
/* loaded from: classes3.dex */
public final class ArizonaImageViewerView$loadWelcomeBanners$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ ArizonaImageViewerView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArizonaImageViewerView$loadWelcomeBanners$1(ArizonaImageViewerView arizonaImageViewerView, Continuation<? super ArizonaImageViewerView$loadWelcomeBanners$1> continuation) {
        super(2, continuation);
        this.this$0 = arizonaImageViewerView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ArizonaImageViewerView$loadWelcomeBanners$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ArizonaImageViewerView$loadWelcomeBanners$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0066, code lost:
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.arizonagames.feature.arizona.imageviewer.ArizonaImageViewerView$loadWelcomeBanners$1.AnonymousClass1(r7.this$0, r8, null), r7) == r0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0091, code lost:
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.arizonagames.feature.arizona.imageviewer.ArizonaImageViewerView$loadWelcomeBanners$1.AnonymousClass2(r7.this$0, null), r7) != r0) goto L8;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        WelcomeBannersRepository welcomeBannersRepository;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
        } catch (CancellationException e) {
            throw e;
        } catch (Exception e2) {
            Log.e(ArizonaImageViewerView.TAG, "Unable to load welcome banners", e2);
            this.L$0 = SpillingKt.nullOutSpilledVariable(e2);
            this.label = 3;
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            welcomeBannersRepository = this.this$0.getWelcomeBannersRepository();
            this.label = 1;
            obj = welcomeBannersRepository.load(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            if (i == 2) {
                List list = (List) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else if (i != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                Exception exc = (Exception) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        } else {
            ResultKt.throwOnFailure(obj);
        }
        List list2 = (List) obj;
        this.L$0 = SpillingKt.nullOutSpilledVariable(list2);
        this.label = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ArizonaImageViewerView.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.arizonagames.feature.arizona.imageviewer.ArizonaImageViewerView$loadWelcomeBanners$1$1", f = "ArizonaImageViewerView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    /* renamed from: com.arizonagames.feature.arizona.imageviewer.ArizonaImageViewerView$loadWelcomeBanners$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<String> $loadedItems;
        int label;
        final /* synthetic */ ArizonaImageViewerView this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ArizonaImageViewerView arizonaImageViewerView, List<String> list, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = arizonaImageViewerView;
            this.$loadedItems = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$loadedItems, continuation);
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
                this.this$0.submitImageUrls(this.$loadedItems);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ArizonaImageViewerView.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.arizonagames.feature.arizona.imageviewer.ArizonaImageViewerView$loadWelcomeBanners$1$2", f = "ArizonaImageViewerView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    /* renamed from: com.arizonagames.feature.arizona.imageviewer.ArizonaImageViewerView$loadWelcomeBanners$1$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ArizonaImageViewerView this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ArizonaImageViewerView arizonaImageViewerView, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = arizonaImageViewerView;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ArizonaImageViewerBinding arizonaImageViewerBinding;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                arizonaImageViewerBinding = this.this$0.binding;
                arizonaImageViewerBinding.contentLoader.setVisibility(8);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
