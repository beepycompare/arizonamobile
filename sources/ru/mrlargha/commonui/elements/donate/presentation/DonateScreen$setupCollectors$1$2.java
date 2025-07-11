package ru.mrlargha.commonui.elements.donate.presentation;

import android.util.Log;
import android.widget.FrameLayout;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.donate.presentation.DonateScreen$setupCollectors$1$2", f = "DonateScreen.kt", i = {}, l = {178}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class DonateScreen$setupCollectors$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DonateScreenBinding $this_with;
    int label;
    final /* synthetic */ DonateScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DonateScreen$setupCollectors$1$2(DonateScreen donateScreen, DonateScreenBinding donateScreenBinding, Continuation<? super DonateScreen$setupCollectors$1$2> continuation) {
        super(2, continuation);
        this.this$0 = donateScreen;
        this.$this_with = donateScreenBinding;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DonateScreen$setupCollectors$1$2(this.this$0, this.$this_with, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DonateScreen$setupCollectors$1$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DonateScreen.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "ru.mrlargha.commonui.elements.donate.presentation.DonateScreen$setupCollectors$1$2$1", f = "DonateScreen.kt", i = {}, l = {179}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: ru.mrlargha.commonui.elements.donate.presentation.DonateScreen$setupCollectors$1$2$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DonateScreenBinding $this_with;
        int label;
        final /* synthetic */ DonateScreen this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(DonateScreen donateScreen, DonateScreenBinding donateScreenBinding, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = donateScreen;
            this.$this_with = donateScreenBinding;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$this_with, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            DonateStates donateStates;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                donateStates = this.this$0.states;
                StateFlow<UiState<List<DonateItemModelUi>>> itemState = donateStates.getItemState();
                final DonateScreenBinding donateScreenBinding = this.$this_with;
                final DonateScreen donateScreen = this.this$0;
                this.label = 1;
                if (itemState.collect(new FlowCollector() { // from class: ru.mrlargha.commonui.elements.donate.presentation.DonateScreen.setupCollectors.1.2.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((UiState) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(UiState<? extends List<DonateItemModelUi>> uiState, Continuation<? super Unit> continuation) {
                        DonateScreenBinding donateScreenBinding2;
                        boolean z;
                        Map map;
                        DonateScreen.Pages pages;
                        boolean z2;
                        boolean z3;
                        Map map2;
                        DonateScreen.Pages pages2;
                        IBackendNotifier notifier;
                        if (uiState instanceof UiState.Loading) {
                            FrameLayout pagesContainer = DonateScreenBinding.this.pagesContainer;
                            Intrinsics.checkNotNullExpressionValue(pagesContainer, "pagesContainer");
                            pagesContainer.setVisibility(4);
                            ProgressBar pageProgressBar = DonateScreenBinding.this.pageProgressBar;
                            Intrinsics.checkNotNullExpressionValue(pageProgressBar, "pageProgressBar");
                            pageProgressBar.setVisibility(0);
                            Boxing.boxInt(Log.d(DonateUtilsKt.DONATE_TAG, "loading"));
                        } else if (uiState instanceof UiState.Error) {
                            FrameLayout pagesContainer2 = DonateScreenBinding.this.pagesContainer;
                            Intrinsics.checkNotNullExpressionValue(pagesContainer2, "pagesContainer");
                            pagesContainer2.setVisibility(8);
                            ProgressBar pageProgressBar2 = DonateScreenBinding.this.pageProgressBar;
                            Intrinsics.checkNotNullExpressionValue(pageProgressBar2, "pageProgressBar");
                            pageProgressBar2.setVisibility(8);
                            Boxing.boxInt(Log.e(DonateUtilsKt.DONATE_TAG, "error items: " + ((UiState.Error) uiState).getMessage()));
                        } else if (uiState instanceof UiState.Successful) {
                            z2 = donateScreen.isHasUpdate;
                            Log.i(DonateUtilsKt.DONATE_TAG, "successful items: " + z2);
                            z3 = donateScreen.isHasUpdate;
                            if (!z3) {
                                donateScreen.isHasUpdate = true;
                                notifier = donateScreen.getNotifier();
                                notifier.clickedWrapper(donateScreen.getBackendID(), 0, 6);
                            } else {
                                UiState.Successful successful = (UiState.Successful) uiState;
                                if (!((Collection) successful.getData()).isEmpty()) {
                                    map2 = donateScreen.pages;
                                    pages2 = donateScreen.currentPage;
                                    DonatePage donatePage = (DonatePage) map2.get(pages2);
                                    if (donatePage != null) {
                                        donatePage.onBackendMessage(DonateSubIds.ITEM_INIT.getSubIds(), StringKt.toStringJson(successful.getData()));
                                    }
                                }
                            }
                        } else if (uiState instanceof UiState.Update) {
                            donateScreenBinding2 = donateScreen.binding;
                            ProgressBar pageProgressBar3 = donateScreenBinding2.pageProgressBar;
                            Intrinsics.checkNotNullExpressionValue(pageProgressBar3, "pageProgressBar");
                            if (pageProgressBar3.getVisibility() == 0) {
                                UiState.Update update = (UiState.Update) uiState;
                                Log.i(DonateUtilsKt.DONATE_TAG, "successful items: " + ((List) update.getData()).size());
                                z = donateScreen.isHasUpdate;
                                if (!z && !((Collection) update.getData()).isEmpty()) {
                                    map = donateScreen.pages;
                                    pages = donateScreen.currentPage;
                                    DonatePage donatePage2 = (DonatePage) map.get(pages);
                                    if (donatePage2 != null) {
                                        donatePage2.onBackendMessage(DonateSubIds.ITEM_INIT.getSubIds(), StringKt.toStringJson(update.getData()));
                                    }
                                }
                                Log.i(DonateUtilsKt.DONATE_TAG, "update items: " + ((List) update.getData()).size());
                            }
                        } else {
                            throw new NoWhenBranchMatchedException();
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
            if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.this$0, this.$this_with, null), this) == coroutine_suspended) {
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
