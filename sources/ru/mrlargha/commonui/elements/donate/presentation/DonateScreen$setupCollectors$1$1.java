package ru.mrlargha.commonui.elements.donate.presentation;

import android.widget.LinearLayout;
import android.widget.ProgressBar;
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
import kotlinx.metadata.internal.metadata.builtins.BuiltInsProtoBuf;
import ru.mrlargha.commonui.databinding.DonateScreenBinding;
import ru.mrlargha.commonui.elements.donate.presentation.UiState;
import ru.mrlargha.commonui.elements.donate.presentation.adapters.DonateCategoryAdapter;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateCategoryModelUi;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DonateScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.donate.presentation.DonateScreen$setupCollectors$1$1", f = "DonateScreen.kt", i = {}, l = {152}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
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
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "ru.mrlargha.commonui.elements.donate.presentation.DonateScreen$setupCollectors$1$1$1", f = "DonateScreen.kt", i = {}, l = {BuiltInsProtoBuf.PROPERTY_SETTER_ANNOTATION_FIELD_NUMBER}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: ru.mrlargha.commonui.elements.donate.presentation.DonateScreen$setupCollectors$1$1$1  reason: invalid class name */
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
                StateFlow<UiState<List<DonateCategoryModelUi>>> categoriesState = donateStates.getCategoriesState();
                final DonateScreenBinding donateScreenBinding = this.$this_with;
                final DonateScreen donateScreen = this.this$0;
                this.label = 1;
                if (categoriesState.collect(new FlowCollector() { // from class: ru.mrlargha.commonui.elements.donate.presentation.DonateScreen.setupCollectors.1.1.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((UiState) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(UiState<? extends List<DonateCategoryModelUi>> uiState, Continuation<? super Unit> continuation) {
                        DonateCategoryAdapter donateCategoryAdapter;
                        if (uiState instanceof UiState.Loading) {
                            ProgressBar contentProgressBar = DonateScreenBinding.this.contentProgressBar;
                            Intrinsics.checkNotNullExpressionValue(contentProgressBar, "contentProgressBar");
                            contentProgressBar.setVisibility(0);
                            LinearLayout contentContainer = DonateScreenBinding.this.contentContainer;
                            Intrinsics.checkNotNullExpressionValue(contentContainer, "contentContainer");
                            contentContainer.setVisibility(8);
                        } else if (uiState instanceof UiState.Error) {
                            ProgressBar contentProgressBar2 = DonateScreenBinding.this.contentProgressBar;
                            Intrinsics.checkNotNullExpressionValue(contentProgressBar2, "contentProgressBar");
                            contentProgressBar2.setVisibility(8);
                            LinearLayout contentContainer2 = DonateScreenBinding.this.contentContainer;
                            Intrinsics.checkNotNullExpressionValue(contentContainer2, "contentContainer");
                            contentContainer2.setVisibility(8);
                        } else if (uiState instanceof UiState.Successful) {
                            UiState.Successful successful = (UiState.Successful) uiState;
                            donateScreen.onCategoryClick((DonateCategoryModelUi) CollectionsKt.first((List<? extends Object>) successful.getData()));
                            donateCategoryAdapter = donateScreen.categoryAdapter;
                            donateCategoryAdapter.submitList((List) successful.getData());
                            ProgressBar contentProgressBar3 = DonateScreenBinding.this.contentProgressBar;
                            Intrinsics.checkNotNullExpressionValue(contentProgressBar3, "contentProgressBar");
                            contentProgressBar3.setVisibility(8);
                            LinearLayout contentContainer3 = DonateScreenBinding.this.contentContainer;
                            Intrinsics.checkNotNullExpressionValue(contentContainer3, "contentContainer");
                            contentContainer3.setVisibility(0);
                        } else if (!(uiState instanceof UiState.Update)) {
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
