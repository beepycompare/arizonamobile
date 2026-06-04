package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.chicken_game;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.HudChickenGameItemBinding;
import ru.mrlargha.commonui.elements.donate.utils.DonateUtilsKt;
import ru.mrlargha.commonui.elements.hud.presentation.hud_screens.chicken_game.models.HudChickenGameRatingModel;
/* compiled from: HudChickenGameRatingAdapter.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00102\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u000f\u0010B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\nH\u0016¨\u0006\u0011"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/chicken_game/HudChickenGameRatingAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/chicken_game/models/HudChickenGameRatingModel;", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/chicken_game/HudChickenGameRatingAdapter$ChickenGameRatingViewHolder;", "<init>", "()V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "ChickenGameRatingViewHolder", "Companion", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HudChickenGameRatingAdapter extends ListAdapter<HudChickenGameRatingModel, ChickenGameRatingViewHolder> {
    private static final int FIRST_PLACE = 0;
    private static final int SECOND_PLACE = 1;
    private static final int THIRD_PLACE = 2;
    public static final Companion Companion = new Companion(null);
    private static final HudChickenGameRatingAdapter$Companion$diffUtilCallback$1 diffUtilCallback = new DiffUtil.ItemCallback<HudChickenGameRatingModel>() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.chicken_game.HudChickenGameRatingAdapter$Companion$diffUtilCallback$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(HudChickenGameRatingModel oldItem, HudChickenGameRatingModel newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(HudChickenGameRatingModel oldItem, HudChickenGameRatingModel newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.getId() == newItem.getId();
        }
    };

    public HudChickenGameRatingAdapter() {
        super(diffUtilCallback);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ChickenGameRatingViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        HudChickenGameItemBinding inflate = HudChickenGameItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new ChickenGameRatingViewHolder(this, inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ChickenGameRatingViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        HudChickenGameRatingModel hudChickenGameRatingModel = getCurrentList().get(i);
        Intrinsics.checkNotNullExpressionValue(hudChickenGameRatingModel, "get(...)");
        holder.onBind(hudChickenGameRatingModel, i);
    }

    /* compiled from: HudChickenGameRatingAdapter.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0002J&\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/chicken_game/HudChickenGameRatingAdapter$ChickenGameRatingViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/commonui/databinding/HudChickenGameItemBinding;", "<init>", "(Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/chicken_game/HudChickenGameRatingAdapter;Lru/mrlargha/commonui/databinding/HudChickenGameItemBinding;)V", "getBinding", "()Lru/mrlargha/commonui/databinding/HudChickenGameItemBinding;", "onBind", "", CommonUrlParts.MODEL, "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/chicken_game/models/HudChickenGameRatingModel;", "position", "", "initialize", "changeViewByPosition", "changeView", "dp", "color", "", "heartColor", "textCountColor", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public final class ChickenGameRatingViewHolder extends RecyclerView.ViewHolder {
        private final HudChickenGameItemBinding binding;
        final /* synthetic */ HudChickenGameRatingAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChickenGameRatingViewHolder(HudChickenGameRatingAdapter hudChickenGameRatingAdapter, HudChickenGameItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = hudChickenGameRatingAdapter;
            this.binding = binding;
        }

        public final HudChickenGameItemBinding getBinding() {
            return this.binding;
        }

        public final void onBind(HudChickenGameRatingModel model, int i) {
            Intrinsics.checkNotNullParameter(model, "model");
            initialize(model);
            changeViewByPosition(i);
        }

        private final void initialize(HudChickenGameRatingModel hudChickenGameRatingModel) {
            HudChickenGameItemBinding hudChickenGameItemBinding = this.binding;
            TextView textView = hudChickenGameItemBinding.tvGamerName;
            int position = hudChickenGameRatingModel.getPosition();
            textView.setText(position + ". " + hudChickenGameRatingModel.getName());
            hudChickenGameItemBinding.tvHeartCount.setText(String.valueOf(hudChickenGameRatingModel.getPoints()));
        }

        private final void changeViewByPosition(int i) {
            if (i == 0) {
                changeView(R.dimen._28sdp, "#FFA600", "#FF1D38", "#F4B328");
            } else if (i == 1) {
                changeView(R.dimen._24sdp, "#FFFFFF", "#FF1D38", "#F4B328");
            } else if (i == 2) {
                changeView(R.dimen._20sdp, "#DD886E", "#FF1D38", "#99FFFFFF");
            } else {
                changeView(R.dimen._18sdp, DonateUtilsKt.TRANSPARENT_COLOR, "#99FFFFFF", "#99FFFFFF");
            }
        }

        public final void changeView(int i, String color, String heartColor, String textCountColor) {
            Intrinsics.checkNotNullParameter(color, "color");
            Intrinsics.checkNotNullParameter(heartColor, "heartColor");
            Intrinsics.checkNotNullParameter(textCountColor, "textCountColor");
            HudChickenGameItemBinding hudChickenGameItemBinding = this.binding;
            float dimension = hudChickenGameItemBinding.getRoot().getContext().getResources().getDimension(i);
            int parseColor = Color.parseColor(color);
            int alphaComponent = ColorUtils.setAlphaComponent(parseColor, 102);
            int parseColor2 = Color.parseColor(heartColor);
            int parseColor3 = Color.parseColor(textCountColor);
            ViewGroup.LayoutParams layoutParams = hudChickenGameItemBinding.getRoot().getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
            layoutParams2.height = (int) dimension;
            hudChickenGameItemBinding.getRoot().setLayoutParams(layoutParams2);
            hudChickenGameItemBinding.bg.setBorder(parseColor);
            hudChickenGameItemBinding.bg.setBackground(alphaComponent);
            hudChickenGameItemBinding.ivHeartIc.setImageTintList(ColorStateList.valueOf(parseColor2));
            hudChickenGameItemBinding.tvHeartCount.setTextColor(parseColor3);
            hudChickenGameItemBinding.tvGamerName.setTextColor(-1);
        }
    }

    /* compiled from: HudChickenGameRatingAdapter.kt */
    @Metadata(d1 = {"\u0000\u001b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/chicken_game/HudChickenGameRatingAdapter$Companion;", "", "<init>", "()V", "FIRST_PLACE", "", "SECOND_PLACE", "THIRD_PLACE", "diffUtilCallback", "ru/mrlargha/commonui/elements/hud/presentation/hud_screens/chicken_game/HudChickenGameRatingAdapter$Companion$diffUtilCallback$1", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/chicken_game/HudChickenGameRatingAdapter$Companion$diffUtilCallback$1;", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
