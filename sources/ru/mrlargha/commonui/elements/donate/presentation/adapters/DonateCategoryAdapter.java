package ru.mrlargha.commonui.elements.donate.presentation.adapters;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.databinding.DonateCategoryItemBinding;
import ru.mrlargha.commonui.elements.donate.presentation.adapters.DonateCategoryAdapter;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateCategoryModel;
import ru.mrlargha.commonui.elements.donate.utils.DonateUtilsKt;
/* compiled from: DonateCategoryAdapter.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0010\u0011B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\b\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u001c\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0007H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateCategoryAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateCategoryModel;", "Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateCategoryAdapter$DonateCategoryViewHolder;", "<init>", "()V", "selectItemPosition", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "DonateCategoryViewHolder", "Companion", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DonateCategoryAdapter extends ListAdapter<DonateCategoryModel, DonateCategoryViewHolder> {
    private static final long ANIMATION_DURATION = 3000;
    private static final long SELECT_ANIMATION_DURATION = 500;
    private int selectItemPosition;
    public static final Companion Companion = new Companion(null);
    private static final DonateCategoryAdapter$Companion$diffUtilCallback$1 diffUtilCallback = new DiffUtil.ItemCallback<DonateCategoryModel>() { // from class: ru.mrlargha.commonui.elements.donate.presentation.adapters.DonateCategoryAdapter$Companion$diffUtilCallback$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(DonateCategoryModel oldItem, DonateCategoryModel newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(DonateCategoryModel oldItem, DonateCategoryModel newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.getId() == newItem.getId();
        }
    };

    public DonateCategoryAdapter() {
        super(diffUtilCallback);
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
        DonateCategoryModel donateCategoryModel = getCurrentList().get(i);
        Intrinsics.checkNotNullExpressionValue(donateCategoryModel, "get(...)");
        holder.onBind(donateCategoryModel, i);
    }

    /* compiled from: DonateCategoryAdapter.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0014H\u0002J\b\u0010\u0018\u001a\u00020\tH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0019"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateCategoryAdapter$DonateCategoryViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/commonui/databinding/DonateCategoryItemBinding;", "<init>", "(Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateCategoryAdapter;Lru/mrlargha/commonui/databinding/DonateCategoryItemBinding;)V", "getBinding", "()Lru/mrlargha/commonui/databinding/DonateCategoryItemBinding;", "onBind", "", CommonUrlParts.MODEL, "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateCategoryModel;", "position", "", "initItem", "", "setTransfusionAnimation", "", "animate", "transfusionColor", "", "setupListeners", "setSelectItem", "color", "setDefaultItem", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

        public final void onBind(DonateCategoryModel model, int i) {
            Intrinsics.checkNotNullParameter(model, "model");
            initItem(model, i);
            setupListeners(i);
        }

        private final Object initItem(DonateCategoryModel donateCategoryModel, int i) {
            DonateCategoryItemBinding donateCategoryItemBinding = this.binding;
            DonateCategoryAdapter donateCategoryAdapter = this.this$0;
            donateCategoryItemBinding.tvCategoryTitle.setText(donateCategoryModel.getTitle());
            ImageView ivNewIc = donateCategoryItemBinding.ivNewIc;
            Intrinsics.checkNotNullExpressionValue(ivNewIc, "ivNewIc");
            ivNewIc.setVisibility(donateCategoryModel.isNew() ? 0 : 8);
            ImageView ivSelectBackground = donateCategoryItemBinding.ivSelectBackground;
            Intrinsics.checkNotNullExpressionValue(ivSelectBackground, "ivSelectBackground");
            ivSelectBackground.setVisibility(donateCategoryAdapter.selectItemPosition == i ? 0 : 8);
            String borderColor = donateCategoryModel.getBorderColor();
            if (borderColor != null) {
                setTransfusionAnimation(true, borderColor);
            } else {
                setTransfusionAnimation(false, DonateUtilsKt.TRANSPARENT_COLOR);
            }
            if (i == donateCategoryAdapter.selectItemPosition) {
                return Boolean.valueOf(setSelectItem(donateCategoryModel.getHoverColor()));
            }
            setDefaultItem();
            return Unit.INSTANCE;
        }

        private final boolean setTransfusionAnimation(final boolean z, final String str) {
            final DonateCategoryItemBinding donateCategoryItemBinding = this.binding;
            return donateCategoryItemBinding.getRoot().post(new Runnable() { // from class: ru.mrlargha.commonui.elements.donate.presentation.adapters.DonateCategoryAdapter$DonateCategoryViewHolder$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    DonateCategoryAdapter.DonateCategoryViewHolder.setTransfusionAnimation$lambda$4$lambda$3(DonateCategoryItemBinding.this, str, z);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setTransfusionAnimation$lambda$4$lambda$3(final DonateCategoryItemBinding donateCategoryItemBinding, final String str, boolean z) {
            ImageView imageView = donateCategoryItemBinding.ivBorder;
            Context context = donateCategoryItemBinding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            imageView.setImageDrawable(DonateUtilsKt.getBorderDrawableWithColor(context, str));
            float width = donateCategoryItemBinding.getRoot().getWidth();
            ImageView animationThumb = donateCategoryItemBinding.animationThumb;
            Intrinsics.checkNotNullExpressionValue(animationThumb, "animationThumb");
            ObjectAnimator translateAnimation = DonateUtilsKt.setTranslateAnimation(animationThumb, -width, width, 3000L, 3000L, true, new Function0() { // from class: ru.mrlargha.commonui.elements.donate.presentation.adapters.DonateCategoryAdapter$DonateCategoryViewHolder$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit transfusionAnimation$lambda$4$lambda$3$lambda$2;
                    transfusionAnimation$lambda$4$lambda$3$lambda$2 = DonateCategoryAdapter.DonateCategoryViewHolder.setTransfusionAnimation$lambda$4$lambda$3$lambda$2(DonateCategoryItemBinding.this, str);
                    return transfusionAnimation$lambda$4$lambda$3$lambda$2;
                }
            });
            if (z) {
                translateAnimation.start();
            } else {
                translateAnimation.end();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit setTransfusionAnimation$lambda$4$lambda$3$lambda$2(DonateCategoryItemBinding donateCategoryItemBinding, String str) {
            ImageView imageView = donateCategoryItemBinding.animationThumb;
            Context context = donateCategoryItemBinding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            imageView.setImageDrawable(DonateUtilsKt.getTransfusionDrawable(context, str));
            ImageView animationThumb = donateCategoryItemBinding.animationThumb;
            Intrinsics.checkNotNullExpressionValue(animationThumb, "animationThumb");
            animationThumb.setVisibility(0);
            return Unit.INSTANCE;
        }

        private final void setupListeners(final int i) {
            DonateCategoryItemBinding donateCategoryItemBinding = this.binding;
            final DonateCategoryAdapter donateCategoryAdapter = this.this$0;
            donateCategoryItemBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.donate.presentation.adapters.DonateCategoryAdapter$DonateCategoryViewHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DonateCategoryAdapter.DonateCategoryViewHolder.setupListeners$lambda$6$lambda$5(DonateCategoryAdapter.this, i, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setupListeners$lambda$6$lambda$5(DonateCategoryAdapter donateCategoryAdapter, int i, View view) {
            if (donateCategoryAdapter.selectItemPosition != i) {
                donateCategoryAdapter.notifyItemChanged(donateCategoryAdapter.selectItemPosition);
                donateCategoryAdapter.selectItemPosition = i;
                donateCategoryAdapter.notifyItemChanged(i);
            }
        }

        private final boolean setSelectItem(final String str) {
            final DonateCategoryItemBinding donateCategoryItemBinding = this.binding;
            return donateCategoryItemBinding.getRoot().post(new Runnable() { // from class: ru.mrlargha.commonui.elements.donate.presentation.adapters.DonateCategoryAdapter$DonateCategoryViewHolder$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    DonateCategoryAdapter.DonateCategoryViewHolder.setSelectItem$lambda$10$lambda$9(DonateCategoryItemBinding.this, str);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setSelectItem$lambda$10$lambda$9(final DonateCategoryItemBinding donateCategoryItemBinding, String str) {
            float width = donateCategoryItemBinding.getRoot().getWidth() / 2.0f;
            Context context = donateCategoryItemBinding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            Drawable selectCategoryDrawable = DonateUtilsKt.getSelectCategoryDrawable(context, str);
            if (selectCategoryDrawable != null) {
                donateCategoryItemBinding.ivSelectBackground.setImageDrawable(selectCategoryDrawable);
            }
            ImageView ivSelectBackground = donateCategoryItemBinding.ivSelectBackground;
            Intrinsics.checkNotNullExpressionValue(ivSelectBackground, "ivSelectBackground");
            DonateUtilsKt.setTranslateAnimation$default(ivSelectBackground, width, -width, 0L, 500L, false, new Function0() { // from class: ru.mrlargha.commonui.elements.donate.presentation.adapters.DonateCategoryAdapter$DonateCategoryViewHolder$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit selectItem$lambda$10$lambda$9$lambda$8;
                    selectItem$lambda$10$lambda$9$lambda$8 = DonateCategoryAdapter.DonateCategoryViewHolder.setSelectItem$lambda$10$lambda$9$lambda$8(DonateCategoryItemBinding.this);
                    return selectItem$lambda$10$lambda$9$lambda$8;
                }
            }, 20, null).start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit setSelectItem$lambda$10$lambda$9$lambda$8(DonateCategoryItemBinding donateCategoryItemBinding) {
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
    @Metadata(d1 = {"\u0000\u001b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\b\u0003*\u0001\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateCategoryAdapter$Companion;", "", "<init>", "()V", "ANIMATION_DURATION", "", "SELECT_ANIMATION_DURATION", "diffUtilCallback", "ru/mrlargha/commonui/elements/donate/presentation/adapters/DonateCategoryAdapter$Companion$diffUtilCallback$1", "Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateCategoryAdapter$Companion$diffUtilCallback$1;", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
