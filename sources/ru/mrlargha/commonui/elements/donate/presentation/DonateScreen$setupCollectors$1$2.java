package ru.mrlargha.commonui.elements.donate.presentation;

import android.util.Log;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.databinding.DonateScreenBinding;
import ru.mrlargha.commonui.elements.donate.presentation.DonateScreen;
import ru.mrlargha.commonui.elements.donate.presentation.UiState;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateItemModelUi;
import ru.mrlargha.commonui.elements.donate.presentation.pages.DonatePage;
import ru.mrlargha.commonui.elements.donate.utils.DonateUtilsKt;
import ru.mrlargha.commonui.utils.StringKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DonateScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.donate.presentation.DonateScreen$setupCollectors$1$2", f = "DonateScreen.kt", i = {}, l = {371}, m = "invokeSuspend", n = {}, nl = {415}, s = {}, v = 2)
/* loaded from: classes6.dex */
public final class DonateScreen$setupCollectors$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $currentSessionGeneration;
    final /* synthetic */ DonateStates $sessionStates;
    final /* synthetic */ DonateScreenBinding $this_with;
    int label;
    final /* synthetic */ DonateScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DonateScreen$setupCollectors$1$2(DonateStates donateStates, DonateScreen donateScreen, long j, DonateScreenBinding donateScreenBinding, Continuation<? super DonateScreen$setupCollectors$1$2> continuation) {
        super(2, continuation);
        this.$sessionStates = donateStates;
        this.this$0 = donateScreen;
        this.$currentSessionGeneration = j;
        this.$this_with = donateScreenBinding;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DonateScreen$setupCollectors$1$2(this.$sessionStates, this.this$0, this.$currentSessionGeneration, this.$this_with, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DonateScreen$setupCollectors$1$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DonateScreen.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "ru.mrlargha.commonui.elements.donate.presentation.DonateScreen$setupCollectors$1$2$1", f = "DonateScreen.kt", i = {}, l = {372}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    /* renamed from: ru.mrlargha.commonui.elements.donate.presentation.DonateScreen$setupCollectors$1$2$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $currentSessionGeneration;
        final /* synthetic */ DonateStates $sessionStates;
        final /* synthetic */ DonateScreenBinding $this_with;
        int label;
        final /* synthetic */ DonateScreen this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(DonateStates donateStates, DonateScreen donateScreen, long j, DonateScreenBinding donateScreenBinding, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$sessionStates = donateStates;
            this.this$0 = donateScreen;
            this.$currentSessionGeneration = j;
            this.$this_with = donateScreenBinding;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$sessionStates, this.this$0, this.$currentSessionGeneration, this.$this_with, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<UiState<List<DonateItemModelUi>>> itemState = this.$sessionStates.getItemState();
                final DonateScreen donateScreen = this.this$0;
                final DonateStates donateStates = this.$sessionStates;
                final long j = this.$currentSessionGeneration;
                final DonateScreenBinding donateScreenBinding = this.$this_with;
                this.label = 1;
                if (itemState.collect(new FlowCollector() { // from class: ru.mrlargha.commonui.elements.donate.presentation.DonateScreen.setupCollectors.1.2.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((UiState) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(UiState<? extends List<DonateItemModelUi>> uiState, Continuation<? super Unit> continuation) {
                        boolean isCurrentSession;
                        boolean z;
                        DonateScreen.Pages pages;
                        Map map;
                        DonateScreen.Pages pages2;
                        IBackendNotifier notifier;
                        DonateScreen.Pages pages3;
                        DonateScreen.Pages pages4;
                        isCurrentSession = DonateScreen.this.isCurrentSession(donateStates, j);
                        if (isCurrentSession) {
                            if (uiState instanceof UiState.Loading) {
                                pages4 = DonateScreen.this.currentPage;
                                if (pages4 != DonateScreen.Pages.PAYPASS) {
                                    FrameLayout pagesContainer = donateScreenBinding.pagesContainer;
                                    Intrinsics.checkNotNullExpressionValue(pagesContainer, "pagesContainer");
                                    pagesContainer.setVisibility(4);
                                    ProgressBar pageProgressBar = donateScreenBinding.pageProgressBar;
                                    Intrinsics.checkNotNullExpressionValue(pageProgressBar, "pageProgressBar");
                                    pageProgressBar.setVisibility(0);
                                }
                                LinearLayout errorPlaceholderItems = donateScreenBinding.errorPlaceholderItems;
                                Intrinsics.checkNotNullExpressionValue(errorPlaceholderItems, "errorPlaceholderItems");
                                errorPlaceholderItems.setVisibility(8);
                                Boxing.boxInt(Log.d(DonateUtilsKt.DONATE_TAG, "loading"));
                            } else if (uiState instanceof UiState.Error) {
                                pages3 = DonateScreen.this.currentPage;
                                if (pages3 != DonateScreen.Pages.PAYPASS) {
                                    FrameLayout pagesContainer2 = donateScreenBinding.pagesContainer;
                                    Intrinsics.checkNotNullExpressionValue(pagesContainer2, "pagesContainer");
                                    pagesContainer2.setVisibility(8);
                                    ProgressBar pageProgressBar2 = donateScreenBinding.pageProgressBar;
                                    Intrinsics.checkNotNullExpressionValue(pageProgressBar2, "pageProgressBar");
                                    pageProgressBar2.setVisibility(8);
                                    LinearLayout errorPlaceholderItems2 = donateScreenBinding.errorPlaceholderItems;
                                    Intrinsics.checkNotNullExpressionValue(errorPlaceholderItems2, "errorPlaceholderItems");
                                    errorPlaceholderItems2.setVisibility(0);
                                }
                                Boxing.boxInt(Log.e(DonateUtilsKt.DONATE_TAG, "error items: " + ((UiState.Error) uiState).getMessage()));
                            } else if (!(uiState instanceof UiState.Successful)) {
                                throw new NoWhenBranchMatchedException();
                            } else {
                                LinearLayout errorPlaceholderItems3 = donateScreenBinding.errorPlaceholderItems;
                                Intrinsics.checkNotNullExpressionValue(errorPlaceholderItems3, "errorPlaceholderItems");
                                errorPlaceholderItems3.setVisibility(8);
                                z = DonateScreen.this.isHasUpdate;
                                if (!z) {
                                    DonateScreen.this.isHasUpdate = true;
                                    Log.e(DonateUtilsKt.DONATE_TAG, "data: initData: " + ((List) ((UiState.Successful) uiState).getData()).size());
                                    notifier = DonateScreen.this.getNotifier();
                                    notifier.clickedWrapper(DonateScreen.this.getBackendID(), 0, 6);
                                }
                                pages = DonateScreen.this.currentPage;
                                if (pages == DonateScreen.Pages.PAYPASS) {
                                    return Unit.INSTANCE;
                                }
                                if (!z || !((Collection) ((UiState.Successful) uiState).getData()).isEmpty()) {
                                    map = DonateScreen.this.pages;
                                    pages2 = DonateScreen.this.currentPage;
                                    DonatePage donatePage = (DonatePage) map.get(pages2);
                                    if (donatePage != null) {
                                        donatePage.onBackendMessage(DonateSubIds.ITEM_INIT.getSubIds(), StringKt.toStringJson(((UiState.Successful) uiState).getData()));
                                    }
                                }
                                Unit unit = Unit.INSTANCE;
                            }
                            return Unit.INSTANCE;
                        }
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.$sessionStates, this.this$0, this.$currentSessionGeneration, this.$this_with, null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
