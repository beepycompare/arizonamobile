package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.football;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.databinding.HudFootballItemBinding;
/* compiled from: HudFootballAdapter.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u000f\u0010B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\nH\u0016¨\u0006\u0011"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/football/HudFootballAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/football/HudFootballModel;", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/football/HudFootballAdapter$FootballViewHolder;", "<init>", "()V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "FootballViewHolder", "Companion", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HudFootballAdapter extends ListAdapter<HudFootballModel, FootballViewHolder> {
    public static final Companion Companion = new Companion(null);
    private static final HudFootballAdapter$Companion$diffUtilCallback$1 diffUtilCallback = new DiffUtil.ItemCallback<HudFootballModel>() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.football.HudFootballAdapter$Companion$diffUtilCallback$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(HudFootballModel oldItem, HudFootballModel newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem.getColor(), newItem.getColor());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(HudFootballModel oldItem, HudFootballModel newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    };

    public HudFootballAdapter() {
        super(diffUtilCallback);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public FootballViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        HudFootballItemBinding inflate = HudFootballItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new FootballViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(FootballViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        HudFootballModel hudFootballModel = getCurrentList().get(i);
        Intrinsics.checkNotNullExpressionValue(hudFootballModel, "get(...)");
        holder.onBind(hudFootballModel);
    }

    /* compiled from: HudFootballAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/football/HudFootballAdapter$FootballViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/commonui/databinding/HudFootballItemBinding;", "<init>", "(Lru/mrlargha/commonui/databinding/HudFootballItemBinding;)V", "getBinding", "()Lru/mrlargha/commonui/databinding/HudFootballItemBinding;", "onBind", "", CommonUrlParts.MODEL, "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/football/HudFootballModel;", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class FootballViewHolder extends RecyclerView.ViewHolder {
        private final HudFootballItemBinding binding;

        public final HudFootballItemBinding getBinding() {
            return this.binding;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FootballViewHolder(HudFootballItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }

        public final void onBind(HudFootballModel model) {
            Intrinsics.checkNotNullParameter(model, "model");
            HudFootballItemBinding hudFootballItemBinding = this.binding;
            hudFootballItemBinding.ivBg.setImageTintList(ColorStateList.valueOf(Color.parseColor(model.getColor())));
            hudFootballItemBinding.tvName.setText(model.getName());
            hudFootballItemBinding.tvScore.setText(String.valueOf(model.getScore()));
        }
    }

    /* compiled from: HudFootballAdapter.kt */
    @Metadata(d1 = {"\u0000\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/football/HudFootballAdapter$Companion;", "", "<init>", "()V", "diffUtilCallback", "ru/mrlargha/commonui/elements/hud/presentation/hud_screens/football/HudFootballAdapter$Companion$diffUtilCallback$1", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/football/HudFootballAdapter$Companion$diffUtilCallback$1;", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
