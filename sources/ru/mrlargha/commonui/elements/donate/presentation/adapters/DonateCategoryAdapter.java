package ru.mrlargha.commonui.elements.donate.presentation.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.DonateCategoryItemBinding;
import ru.mrlargha.commonui.elements.donate.presentation.adapters.DonateCategoryAdapter;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateCategoryModelUi;
import ru.mrlargha.commonui.elements.donate.utils.DonateUtilsKt;
/* compiled from: DonateCategoryAdapter.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001a2\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0019\u001aB*\u0012!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\u0012\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000fH\u0016J\u001c\u0010\u0016\u001a\u00020\t2\n\u0010\u0017\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u000fH\u0016R,\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateCategoryAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateCategoryModelUi;", "Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateCategoryAdapter$DonateCategoryViewHolder;", "onClick", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", CommonUrlParts.MODEL, "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getOnClick", "()Lkotlin/jvm/functions/Function1;", "selectItemPosition", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "DonateCategoryViewHolder", "Companion", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DonateCategoryAdapter extends ListAdapter<DonateCategoryModelUi, DonateCategoryViewHolder> {
    private static final long SELECT_ANIMATION_DURATION = 500;
    private final Function1<DonateCategoryModelUi, Unit> onClick;
    private final CoroutineScope scope;
    private int selectItemPosition;
    public static final Companion Companion = new Companion(null);
    private static final DonateCategoryAdapter$Companion$diffUtilCallback$1 diffUtilCallback = new DiffUtil.ItemCallback<DonateCategoryModelUi>() { // from class: ru.mrlargha.commonui.elements.donate.presentation.adapters.DonateCategoryAdapter$Companion$diffUtilCallback$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(DonateCategoryModelUi oldItem, DonateCategoryModelUi newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(DonateCategoryModelUi oldItem, DonateCategoryModelUi newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.getId() == newItem.getId();
        }
    };

    public final Function1<DonateCategoryModelUi, Unit> getOnClick() {
        return this.onClick;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DonateCategoryAdapter(Function1<? super DonateCategoryModelUi, Unit> onClick) {
        super(diffUtilCallback);
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.onClick = onClick;
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public DonateCategoryViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        DonateCategoryItemBinding inflate = DonateCategoryItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new DonateCategoryViewHolder(this, inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(DonateCategoryViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        DonateCategoryModelUi donateCategoryModelUi = getCurrentList().get(i);
        Intrinsics.checkNotNullExpressionValue(donateCategoryModelUi, "get(...)");
        holder.onBind(donateCategoryModelUi, i);
    }

    /* compiled from: DonateCategoryAdapter.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0016\u0010\u0011\u001a\u00020\t2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0014H\u0002J\b\u0010\u0019\u001a\u00020\tH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001a"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateCategoryAdapter$DonateCategoryViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/commonui/databinding/DonateCategoryItemBinding;", "<init>", "(Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateCategoryAdapter;Lru/mrlargha/commonui/databinding/DonateCategoryItemBinding;)V", "getBinding", "()Lru/mrlargha/commonui/databinding/DonateCategoryItemBinding;", "onBind", "", CommonUrlParts.MODEL, "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateCategoryModelUi;", "position", "", "initItem", "isStartAnimation", "checkSelectItem", "setBorders", "transfusionColorList", "", "", "setupListeners", "setSelectItem", "", "color", "setDefaultItem", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final class DonateCategoryViewHolder extends RecyclerView.ViewHolder {
        private final DonateCategoryItemBinding binding;
        final /* synthetic */ DonateCategoryAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DonateCategoryViewHolder(DonateCategoryAdapter donateCategoryAdapter, DonateCategoryItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = donateCategoryAdapter;
            this.binding = binding;
        }

        public final DonateCategoryItemBinding getBinding() {
            return this.binding;
        }

        public final void onBind(DonateCategoryModelUi model, int i) {
            Intrinsics.checkNotNullParameter(model, "model");
            initItem(model, i);
            setupListeners(i);
        }

        private final void initItem(DonateCategoryModelUi donateCategoryModelUi, int i) {
            DonateCategoryItemBinding donateCategoryItemBinding = this.binding;
            DonateCategoryAdapter donateCategoryAdapter = this.this$0;
            donateCategoryItemBinding.tvCategoryTitle.setText(donateCategoryModelUi.getTitle());
            ImageView ivNewIc = donateCategoryItemBinding.ivNewIc;
            Intrinsics.checkNotNullExpressionValue(ivNewIc, "ivNewIc");
            ivNewIc.setVisibility(donateCategoryModelUi.isNew() ? 0 : 8);
            ImageView ivItem = donateCategoryItemBinding.ivItem;
            Intrinsics.checkNotNullExpressionValue(ivItem, "ivItem");
            DonateUtilsKt.setImageCategorySdn(ivItem, donateCategoryModelUi.getImage());
            ImageView ivCategoryBg = donateCategoryItemBinding.ivCategoryBg;
            Intrinsics.checkNotNullExpressionValue(ivCategoryBg, "ivCategoryBg");
            DonateUtilsKt.setBackgroundCategorySdn(ivCategoryBg, donateCategoryModelUi.getBackground());
            ImageView ivSelectBackground = donateCategoryItemBinding.ivSelectBackground;
            Intrinsics.checkNotNullExpressionValue(ivSelectBackground, "ivSelectBackground");
            ivSelectBackground.setVisibility(donateCategoryAdapter.selectItemPosition == i ? 0 : 8);
            isStartAnimation(donateCategoryModelUi);
            checkSelectItem(donateCategoryModelUi, i);
        }

        private final void isStartAnimation(DonateCategoryModelUi donateCategoryModelUi) {
            DonateCategoryItemBinding donateCategoryItemBinding = this.binding;
            List<String> borderColor = donateCategoryModelUi.getBorderColor();
            if (borderColor != null && !borderColor.isEmpty()) {
                ImageView animationThumb = donateCategoryItemBinding.animationThumb;
                Intrinsics.checkNotNullExpressionValue(animationThumb, "animationThumb");
                animationThumb.setVisibility(0);
                Glide.with(donateCategoryItemBinding.animationThumb).load(Integer.valueOf(R.raw.donate_item_animation)).into(donateCategoryItemBinding.animationThumb);
                setBorders(donateCategoryModelUi.getBorderColor());
                return;
            }
            ImageView animationThumb2 = donateCategoryItemBinding.animationThumb;
            Intrinsics.checkNotNullExpressionValue(animationThumb2, "animationThumb");
            animationThumb2.setVisibility(8);
            setBorders(CollectionsKt.listOf((Object[]) new String[]{DonateUtilsKt.TRANSPARENT_COLOR, DonateUtilsKt.TRANSPARENT_COLOR}));
        }

        private final void checkSelectItem(DonateCategoryModelUi donateCategoryModelUi, int i) {
            if (i == this.this$0.selectItemPosition) {
                setSelectItem(donateCategoryModelUi.getHoverColor());
            } else {
                setDefaultItem();
            }
        }

        private final void setBorders(List<String> list) {
            DonateCategoryItemBinding donateCategoryItemBinding = this.binding;
            ImageView imageView = donateCategoryItemBinding.ivBorder;
            Context context = donateCategoryItemBinding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            imageView.setImageDrawable(DonateUtilsKt.getGradientBorderDrawable(context, DonateUtilsKt.convertColorList(list)));
        }

        private final void setupListeners(final int i) {
            final DonateCategoryItemBinding donateCategoryItemBinding = this.binding;
            final DonateCategoryAdapter donateCategoryAdapter = this.this$0;
            donateCategoryItemBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.donate.presentation.adapters.DonateCategoryAdapter$DonateCategoryViewHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DonateCategoryAdapter.DonateCategoryViewHolder.setupListeners$lambda$4$lambda$3(DonateCategoryAdapter.this, i, donateCategoryItemBinding, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setupListeners$lambda$4$lambda$3(DonateCategoryAdapter donateCategoryAdapter, int i, DonateCategoryItemBinding donateCategoryItemBinding, View view) {
            if (donateCategoryAdapter.selectItemPosition != i) {
                donateCategoryAdapter.notifyItemChanged(donateCategoryAdapter.selectItemPosition);
                donateCategoryAdapter.selectItemPosition = i;
                donateCategoryAdapter.notifyItemChanged(i);
                Function1<DonateCategoryModelUi, Unit> onClick = donateCategoryAdapter.getOnClick();
                DonateCategoryModelUi donateCategoryModelUi = donateCategoryAdapter.getCurrentList().get(i);
                Intrinsics.checkNotNullExpressionValue(donateCategoryModelUi, "get(...)");
                onClick.invoke(donateCategoryModelUi);
                BuildersKt__Builders_commonKt.launch$default(donateCategoryAdapter.scope, null, null, new DonateCategoryAdapter$DonateCategoryViewHolder$setupListeners$1$1$1(donateCategoryItemBinding, null), 3, null);
            }
        }

        private final boolean setSelectItem(final String str) {
            final DonateCategoryItemBinding donateCategoryItemBinding = this.binding;
            return donateCategoryItemBinding.getRoot().post(new Runnable() { // from class: ru.mrlargha.commonui.elements.donate.presentation.adapters.DonateCategoryAdapter$DonateCategoryViewHolder$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    DonateCategoryAdapter.DonateCategoryViewHolder.setSelectItem$lambda$8$lambda$7(DonateCategoryItemBinding.this, str);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setSelectItem$lambda$8$lambda$7(final DonateCategoryItemBinding donateCategoryItemBinding, String str) {
            float width = donateCategoryItemBinding.getRoot().getWidth() / 2.0f;
            Context context = donateCategoryItemBinding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            Drawable selectCategoryDrawable = DonateUtilsKt.getSelectCategoryDrawable(context, str);
            if (selectCategoryDrawable != null) {
                donateCategoryItemBinding.ivSelectBackground.setImageDrawable(selectCategoryDrawable);
            }
            ImageView ivSelectBackground = donateCategoryItemBinding.ivSelectBackground;
            Intrinsics.checkNotNullExpressionValue(ivSelectBackground, "ivSelectBackground");
            DonateUtilsKt.setTranslateAnimation$default(ivSelectBackground, width, -width, 0L, 500L, false, new Function0() { // from class: ru.mrlargha.commonui.elements.donate.presentation.adapters.DonateCategoryAdapter$DonateCategoryViewHolder$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit selectItem$lambda$8$lambda$7$lambda$6;
                    selectItem$lambda$8$lambda$7$lambda$6 = DonateCategoryAdapter.DonateCategoryViewHolder.setSelectItem$lambda$8$lambda$7$lambda$6(DonateCategoryItemBinding.this);
                    return selectItem$lambda$8$lambda$7$lambda$6;
                }
            }, 20, null).start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit setSelectItem$lambda$8$lambda$7$lambda$6(DonateCategoryItemBinding donateCategoryItemBinding) {
            ImageView ivSelectBackground = donateCategoryItemBinding.ivSelectBackground;
            Intrinsics.checkNotNullExpressionValue(ivSelectBackground, "ivSelectBackground");
            ivSelectBackground.setVisibility(0);
            return Unit.INSTANCE;
        }

        private final void setDefaultItem() {
            DonateCategoryItemBinding donateCategoryItemBinding = this.binding;
            donateCategoryItemBinding.ivSelectBackground.setTranslationX(0.0f);
            ImageView ivSelectBackground = donateCategoryItemBinding.ivSelectBackground;
            Intrinsics.checkNotNullExpressionValue(ivSelectBackground, "ivSelectBackground");
            ivSelectBackground.setVisibility(8);
        }
    }

    /* compiled from: DonateCategoryAdapter.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\b\u0003*\u0001\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\t"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateCategoryAdapter$Companion;", "", "<init>", "()V", "SELECT_ANIMATION_DURATION", "", "diffUtilCallback", "ru/mrlargha/commonui/elements/donate/presentation/adapters/DonateCategoryAdapter$Companion$diffUtilCallback$1", "Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateCategoryAdapter$Companion$diffUtilCallback$1;", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
