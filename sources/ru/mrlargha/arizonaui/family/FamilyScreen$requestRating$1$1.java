package ru.mrlargha.arizonaui.family;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import ru.mrlargha.arizonaui.databinding.FamilyMainBinding;
import ru.mrlargha.arizonaui.databinding.FamilyRatingBinding;
import ru.mrlargha.arizonaui.databinding.FamilyTopbarBinding;
import ru.mrlargha.arizonaui.family.adapters.RatingAdapter;
import ru.mrlargha.arizonaui.family.data.FamilyData;
import ru.mrlargha.arizonaui.family.data.RatingItem;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FamilyScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.arizonaui.family.FamilyScreen$requestRating$1$1", f = "FamilyScreen.kt", i = {}, l = {564}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class FamilyScreen$requestRating$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $page;
    int label;
    final /* synthetic */ FamilyScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FamilyScreen$requestRating$1$1(FamilyScreen familyScreen, int i, Continuation<? super FamilyScreen$requestRating$1$1> continuation) {
        super(2, continuation);
        this.this$0 = familyScreen;
        this.$page = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FamilyScreen$requestRating$1$1(this.this$0, this.$page, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FamilyScreen$requestRating$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FamilyMainBinding familyMainBinding;
        FamilyMainBinding familyMainBinding2;
        FamilyData familyData;
        RatingAdapter ratingAdapter;
        RatingAdapter ratingAdapter2;
        RatingAdapter ratingAdapter3;
        RatingAdapter ratingAdapter4;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new FamilyScreen$requestRating$1$1$list$1(this.this$0, this.$page, null), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        List<RatingItem> list = (List) obj;
        familyMainBinding = this.this$0.binding;
        FamilyRatingBinding familyRatingBinding = familyMainBinding.rating;
        int i2 = this.$page;
        FamilyScreen familyScreen = this.this$0;
        familyRatingBinding.loaderBar.setVisibility(8);
        if (list.isEmpty() && i2 == 1) {
            familyRatingBinding.empty.setVisibility(0);
        } else {
            familyRatingBinding.empty.setVisibility(8);
            familyMainBinding2 = familyScreen.binding;
            FamilyTopbarBinding familyTopbarBinding = familyMainBinding2.topbar;
            familyData = familyScreen.familyData;
            if (familyData != null) {
                ratingAdapter = familyScreen.ratingAdapter;
                int top = ratingAdapter.getTop(familyData.getTitle());
                if (top > 0) {
                    familyTopbarBinding.ratingTop.setText((top + 1) + " месте");
                } else if (i2 < 5) {
                    ratingAdapter2 = familyScreen.ratingAdapter;
                    ratingAdapter2.setPage(i2 + 1);
                    ratingAdapter3 = familyScreen.ratingAdapter;
                    familyScreen.requestRating(ratingAdapter3.getPage());
                    familyTopbarBinding.ratingTop.setText("100+ месте");
                }
            }
        }
        if (!list.isEmpty()) {
            ratingAdapter4 = this.this$0.ratingAdapter;
            ratingAdapter4.addAllItems(list);
        }
        return Unit.INSTANCE;
    }
}
