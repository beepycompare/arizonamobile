package ru.mrlargha.commonui.elements.donate.presentation.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.databinding.DonateDefaultItemBinding;
import ru.mrlargha.commonui.databinding.DonatePosterItemBinding;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateItemModel;
import ru.mrlargha.commonui.elements.donate.utils.CustomLinearLayoutManager;
import ru.mrlargha.commonui.elements.donate.utils.DonateUtilsKt;
/* compiled from: DonateAdapter.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u0014\u0015\u0016B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0014\u0010\u000f\u001a\u00060\u0010R\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0014\u0010\u0011\u001a\u00060\u0012R\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0016¨\u0006\u0017"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateItemModel;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "<init>", "()V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "createDefaultViewHolder", "Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateAdapter$DonateDefaultViewHolder;", "createPosterViewHolder", "Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateAdapter$DonatePosterViewHolder;", "getItemViewType", "DonateDefaultViewHolder", "DonatePosterViewHolder", "Companion", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DonateAdapter extends ListAdapter<DonateItemModel, RecyclerView.ViewHolder> {
    public static final int DEFAULT_TYPE = 0;
    public static final int POSTER_TYPE = 1;
    public static final Companion Companion = new Companion(null);
    private static final DonateAdapter$Companion$diffUtilCallback$1 diffUtilCallback = new DiffUtil.ItemCallback<DonateItemModel>() { // from class: ru.mrlargha.commonui.elements.donate.presentation.adapters.DonateAdapter$Companion$diffUtilCallback$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(DonateItemModel oldItem, DonateItemModel newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(DonateItemModel oldItem, DonateItemModel newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.getId() == newItem.getId();
        }
    };

    public DonateAdapter() {
        super(diffUtilCallback);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (i == 1) {
            return createPosterViewHolder(parent);
        }
        return createDefaultViewHolder(parent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof DonateDefaultViewHolder) {
            DonateItemModel donateItemModel = getCurrentList().get(i);
            Intrinsics.checkNotNullExpressionValue(donateItemModel, "get(...)");
            ((DonateDefaultViewHolder) holder).onBind(donateItemModel);
        } else if (holder instanceof DonatePosterViewHolder) {
            DonateItemModel donateItemModel2 = getCurrentList().get(i);
            Intrinsics.checkNotNullExpressionValue(donateItemModel2, "get(...)");
            ((DonatePosterViewHolder) holder).onBind(donateItemModel2);
        }
    }

    private final DonateDefaultViewHolder createDefaultViewHolder(ViewGroup viewGroup) {
        DonateDefaultItemBinding inflate = DonateDefaultItemBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        ViewGroup.LayoutParams layoutParams = inflate.getRoot().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.width = viewGroup.getMeasuredWidth() / 4;
        inflate.getRoot().setLayoutParams(marginLayoutParams);
        return new DonateDefaultViewHolder(this, inflate);
    }

    private final DonatePosterViewHolder createPosterViewHolder(ViewGroup viewGroup) {
        DonatePosterItemBinding inflate = DonatePosterItemBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        ViewGroup.LayoutParams layoutParams = inflate.getRoot().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.width = viewGroup.getMeasuredWidth() / 2;
        inflate.getRoot().setLayoutParams(marginLayoutParams);
        return new DonatePosterViewHolder(this, inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return getCurrentList().get(i).getType() == 1 ? 1 : 0;
    }

    /* compiled from: DonateAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateAdapter$DonateDefaultViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/commonui/databinding/DonateDefaultItemBinding;", "<init>", "(Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateAdapter;Lru/mrlargha/commonui/databinding/DonateDefaultItemBinding;)V", "onBind", "", CommonUrlParts.MODEL, "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateItemModel;", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final class DonateDefaultViewHolder extends RecyclerView.ViewHolder {
        final /* synthetic */ DonateAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DonateDefaultViewHolder(DonateAdapter donateAdapter, DonateDefaultItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = donateAdapter;
        }

        public final void onBind(DonateItemModel model) {
            Intrinsics.checkNotNullParameter(model, "model");
            Log.d("donate", "initAdapters: " + model);
        }
    }

    /* compiled from: DonateAdapter.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateAdapter$DonatePosterViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/commonui/databinding/DonatePosterItemBinding;", "<init>", "(Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateAdapter;Lru/mrlargha/commonui/databinding/DonatePosterItemBinding;)V", "getBinding", "()Lru/mrlargha/commonui/databinding/DonatePosterItemBinding;", "badgesAdapter", "Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateBadgesAdapter;", "onBind", "", CommonUrlParts.MODEL, "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateItemModel;", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final class DonatePosterViewHolder extends RecyclerView.ViewHolder {
        private final DonateBadgesAdapter badgesAdapter;
        private final DonatePosterItemBinding binding;
        final /* synthetic */ DonateAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DonatePosterViewHolder(DonateAdapter donateAdapter, DonatePosterItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = donateAdapter;
            this.binding = binding;
            this.badgesAdapter = new DonateBadgesAdapter();
        }

        public final DonatePosterItemBinding getBinding() {
            return this.binding;
        }

        public final void onBind(DonateItemModel model) {
            Intrinsics.checkNotNullParameter(model, "model");
            DonatePosterItemBinding donatePosterItemBinding = this.binding;
            Log.e("donate", model.getColorButton().toString());
            donatePosterItemBinding.tvSecondTitle.setColorList(model.getColorButton());
            Context context = donatePosterItemBinding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            Drawable buttonsGradientDrawable = DonateUtilsKt.getButtonsGradientDrawable(context, model.getColorButton());
            if (buttonsGradientDrawable != null) {
                donatePosterItemBinding.btnBuy.setBackground(buttonsGradientDrawable);
            }
            donatePosterItemBinding.rvTags.setLayoutManager(new CustomLinearLayoutManager());
            donatePosterItemBinding.rvTags.setAdapter(this.badgesAdapter);
            this.badgesAdapter.submitList(model.getBadges());
        }
    }

    /* compiled from: DonateAdapter.kt */
    @Metadata(d1 = {"\u0000\u001b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0003*\u0001\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateAdapter$Companion;", "", "<init>", "()V", "DEFAULT_TYPE", "", "POSTER_TYPE", "diffUtilCallback", "ru/mrlargha/commonui/elements/donate/presentation/adapters/DonateAdapter$Companion$diffUtilCallback$1", "Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateAdapter$Companion$diffUtilCallback$1;", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
