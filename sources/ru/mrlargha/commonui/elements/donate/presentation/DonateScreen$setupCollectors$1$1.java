package ru.mrlargha.commonui.elements.donate.presentation;

import android.widget.LinearLayout;
import android.widget.ProgressBar;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import ru.mrlargha.commonui.databinding.DonateScreenBinding;
import ru.mrlargha.commonui.elements.donate.presentation.DonateScreen$setupCollectors$1$1;
import ru.mrlargha.commonui.elements.donate.presentation.UiState;
import ru.mrlargha.commonui.elements.donate.presentation.adapters.DonateCategoryAdapter;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateCategoryModelUi;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DonateScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.donate.presentation.DonateScreen$setupCollectors$1$1", f = "DonateScreen.kt", i = {}, l = {249}, m = "invokeSuspend", n = {}, nl = {285}, s = {}, v = 2)
/* loaded from: classes6.dex */
public final class DonateScreen$setupCollectors$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DonateScreenBinding $this_with;
    int label;
    final /* synthetic */ DonateScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DonateScreen$setupCollectors$1$1(DonateScreen donateScreen, DonateScreenBinding donateScreenBinding, Continuation<? super DonateScreen$setupCollectors$1$1> continuation) {
        super(2, continuation);
        this.this$0 = donateScreen;
        this.$this_with = donateScreenBinding;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DonateScreen$setupCollectors$1$1(this.this$0, this.$this_with, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DonateScreen$setupCollectors$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DonateScreen.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "ru.mrlargha.commonui.elements.donate.presentation.DonateScreen$setupCollectors$1$1$1", f = "DonateScreen.kt", i = {}, l = {250}, m = "invokeSuspend", n = {}, nl = {284}, s = {}, v = 2)
    /* renamed from: ru.mrlargha.commonui.elements.donate.presentation.DonateScreen$setupCollectors$1$1$1  reason: invalid class name */
    /* loaded from: classes6.dex */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: DonateScreen.kt */
        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
        /* renamed from: ru.mrlargha.commonui.elements.donate.presentation.DonateScreen$setupCollectors$1$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C00811<T> implements FlowCollector {
            final /* synthetic */ DonateScreenBinding $this_with;
            final /* synthetic */ DonateScreen this$0;

            C00811(DonateScreenBinding donateScreenBinding, DonateScreen donateScreen) {
                this.$this_with = donateScreenBinding;
                this.this$0 = donateScreen;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return emit((UiState) obj, (Continuation<? super Unit>) continuation);
            }

            public final Object emit(UiState<? extends List<DonateCategoryModelUi>> uiState, Continuation<? super Unit> continuation) {
                DonateCategoryAdapter donateCategoryAdapter;
                boolean z;
                Integer num;
                DonateCategoryModelUi donateCategoryModelUi;
                if (uiState instanceof UiState.Loading) {
                    ProgressBar contentProgressBar = this.$this_with.contentProgressBar;
                    Intrinsics.checkNotNullExpressionValue(contentProgressBar, "contentProgressBar");
                    contentProgressBar.setVisibility(0);
                    LinearLayout contentContainer = this.$this_with.contentContainer;
                    Intrinsics.checkNotNullExpressionValue(contentContainer, "contentContainer");
                    contentContainer.setVisibility(8);
                    LinearLayout errorPlaceholder = this.$this_with.errorPlaceholder;
                    Intrinsics.checkNotNullExpressionValue(errorPlaceholder, "errorPlaceholder");
                    errorPlaceholder.setVisibility(8);
                } else if (uiState instanceof UiState.Error) {
                    ProgressBar contentProgressBar2 = this.$this_with.contentProgressBar;
                    Intrinsics.checkNotNullExpressionValue(contentProgressBar2, "contentProgressBar");
                    contentProgressBar2.setVisibility(8);
                    LinearLayout contentContainer2 = this.$this_with.contentContainer;
                    Intrinsics.checkNotNullExpressionValue(contentContainer2, "contentContainer");
                    contentContainer2.setVisibility(8);
                    LinearLayout errorPlaceholder2 = this.$this_with.errorPlaceholder;
                    Intrinsics.checkNotNullExpressionValue(errorPlaceholder2, "errorPlaceholder");
                    errorPlaceholder2.setVisibility(0);
                } else if (uiState instanceof UiState.Successful) {
                    UiState.Successful successful = (UiState.Successful) uiState;
                    this.this$0.categories = (List) successful.getData();
                    donateCategoryAdapter = this.this$0.categoryAdapter;
                    ArrayList arrayList = new ArrayList();
                    for (T t : (Iterable) successful.getData()) {
                        if (((DonateCategoryModelUi) t).getVisible()) {
                            arrayList.add(t);
                        }
                    }
                    final DonateScreen donateScreen = this.this$0;
                    donateCategoryAdapter.submitList(arrayList, new Runnable() { // from class: ru.mrlargha.commonui.elements.donate.presentation.DonateScreen$setupCollectors$1$1$1$1$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            DonateScreen$setupCollectors$1$1.AnonymousClass1.C00811.emit$lambda$1(DonateScreen.this);
                        }
                    });
                    z = this.this$0.hasInitializedCategory;
                    if (!z) {
                        num = this.this$0.pendingOpenCategoryId;
                        if (num == null && (donateCategoryModelUi = (DonateCategoryModelUi) CollectionsKt.firstOrNull((List<? extends Object>) successful.getData())) != null) {
                            DonateScreen donateScreen2 = this.this$0;
                            donateScreen2.hasInitializedCategory = true;
                            donateScreen2.selectCategory(donateCategoryModelUi, true);
                        }
                    }
                    ProgressBar contentProgressBar3 = this.$this_with.contentProgressBar;
                    Intrinsics.checkNotNullExpressionValue(contentProgressBar3, "contentProgressBar");
                    contentProgressBar3.setVisibility(8);
                    LinearLayout contentContainer3 = this.$this_with.contentContainer;
                    Intrinsics.checkNotNullExpressionValue(contentContainer3, "contentContainer");
                    contentContainer3.setVisibility(0);
                    LinearLayout errorPlaceholder3 = this.$this_with.errorPlaceholder;
                    Intrinsics.checkNotNullExpressionValue(errorPlaceholder3, "errorPlaceholder");
                    errorPlaceholder3.setVisibility(8);
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public static final void emit$lambda$1(DonateScreen donateScreen) {
                Integer num;
                num = donateScreen.pendingOpenCategoryId;
                if (num != null) {
                    int intValue = num.intValue();
                    donateScreen.pendingOpenCategoryId = null;
                    donateScreen.openCategory(Integer.valueOf(intValue));
                }
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            DonateStates donateStates;
            StateFlow<UiState<List<DonateCategoryModelUi>>> categoriesState;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                donateStates = this.this$0.states;
                if (donateStates == null || (categoriesState = donateStates.getCategoriesState()) == null) {
                    return Unit.INSTANCE;
                }
                this.label = 1;
                if (categoriesState.collect(new C00811(this.$this_with, this.this$0), this) == coroutine_suspended) {
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
