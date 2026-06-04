package ru.mrlargha.arizona.rating;

import android.app.Activity;
import android.widget.TextView;
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
import ru.mrlargha.feature.arizona.item.rating.R;
import ru.mrlargha.feature.arizona.item.rating.databinding.RatingScreenBinding;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ItemRatingScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.arizona.rating.ItemRatingScreen$search$1", f = "ItemRatingScreen.kt", i = {}, l = {177, 178}, m = "invokeSuspend", n = {}, nl = {178, 187}, s = {}, v = 2)
/* loaded from: classes6.dex */
public final class ItemRatingScreen$search$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $quality;
    final /* synthetic */ String $text;
    Object L$0;
    int label;
    final /* synthetic */ ItemRatingScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemRatingScreen$search$1(ItemRatingScreen itemRatingScreen, int i, String str, Continuation<? super ItemRatingScreen$search$1> continuation) {
        super(2, continuation);
        this.this$0 = itemRatingScreen;
        this.$quality = i;
        this.$text = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ItemRatingScreen$search$1(this.this$0, this.$quality, this.$text, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ItemRatingScreen$search$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0043, code lost:
        if (r13 == r0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0066, code lost:
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new ru.mrlargha.arizona.rating.ItemRatingScreen$search$1.AnonymousClass1(r12.this$0, null), r12) == r0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0068, code lost:
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ItemRatingScreen itemRatingScreen;
        RatingApi ratingApi;
        boolean z;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            itemRatingScreen = this.this$0;
            ratingApi = itemRatingScreen.api;
            z = this.this$0.sortOrder;
            this.L$0 = itemRatingScreen;
            this.label = 1;
            obj = RatingApi.getCarsList$default(ratingApi, 0, z, this.$quality, this.$text, this, 1, null);
        } else if (i != 1) {
            if (i == 2) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            itemRatingScreen = (ItemRatingScreen) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        itemRatingScreen.apiData = (List) obj;
        this.L$0 = null;
        this.label = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ItemRatingScreen.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "ru.mrlargha.arizona.rating.ItemRatingScreen$search$1$1", f = "ItemRatingScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    /* renamed from: ru.mrlargha.arizona.rating.ItemRatingScreen$search$1$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ItemRatingScreen this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ItemRatingScreen itemRatingScreen, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = itemRatingScreen;
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
            RatingScreenBinding ratingScreenBinding;
            List list;
            RatingScreenBinding ratingScreenBinding2;
            RatingScreenBinding ratingScreenBinding3;
            Activity targetActivity;
            List list2;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ratingScreenBinding = this.this$0.binding;
                ratingScreenBinding.loaderBar.setVisibility(8);
                list = this.this$0.apiData;
                boolean isEmpty = list.isEmpty();
                ItemRatingScreen itemRatingScreen = this.this$0;
                if (!isEmpty) {
                    list2 = itemRatingScreen.apiData;
                    itemRatingScreen.addData(list2);
                } else {
                    ratingScreenBinding2 = itemRatingScreen.binding;
                    ratingScreenBinding2.searchNotFound.setVisibility(0);
                    ratingScreenBinding3 = this.this$0.binding;
                    TextView textView = ratingScreenBinding3.searchText;
                    targetActivity = this.this$0.getTargetActivity();
                    textView.setText(targetActivity.getString(R.string.rating_not_found_transport));
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
