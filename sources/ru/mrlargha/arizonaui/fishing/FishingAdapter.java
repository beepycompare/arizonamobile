package ru.mrlargha.arizonaui.fishing;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.arizona.common.utils.EasyAnimation;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.databinding.FishingItemBinding;
import ru.mrlargha.arizonaui.fishing.FishingScreen;
/* compiled from: FishingAdapter.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0019\u001aB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\u0014\u0010\u0016\u001a\u00020\f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u0018R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lru/mrlargha/arizonaui/fishing/FishingAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/arizonaui/fishing/FishingAdapter$ViewHolder;", "<init>", "()V", "fishInfoList", "Ljava/util/ArrayList;", "Lru/mrlargha/arizonaui/fishing/FishingScreen$Companion$FishInfo;", "Lkotlin/collections/ArrayList;", "onItemClickListener", "Lru/mrlargha/arizonaui/fishing/FishingAdapter$OnItemClickListener;", "setOnItemClickListener", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "addItems", "infoList", "", "OnItemClickListener", "ViewHolder", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FishingAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final ArrayList<FishingScreen.Companion.FishInfo> fishInfoList = new ArrayList<>();
    private OnItemClickListener onItemClickListener;

    /* compiled from: FishingAdapter.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lru/mrlargha/arizonaui/fishing/FishingAdapter$OnItemClickListener;", "", "callback", "", "id", "", "type", "", "isPressed", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface OnItemClickListener {
        void callback(int i, String str, boolean z);
    }

    public final void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        Intrinsics.checkNotNullParameter(onItemClickListener, "onItemClickListener");
        this.onItemClickListener = onItemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.fishing_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new ViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        FishingScreen.Companion.FishInfo fishInfo = this.fishInfoList.get(i);
        Intrinsics.checkNotNullExpressionValue(fishInfo, "get(...)");
        final FishingScreen.Companion.FishInfo fishInfo2 = fishInfo;
        final FishingItemBinding binding = holder.getBinding();
        if (!Intrinsics.areEqual(fishInfo2.getType(), "empty")) {
            binding.itemImg.setImageResource(fishInfo2.getImg());
        } else {
            binding.itemImg.setImageDrawable(null);
        }
        if (Intrinsics.areEqual(fishInfo2.getType(), "fish") && fishInfo2.isPressed()) {
            binding.acceptMask.setVisibility(0);
        } else {
            binding.acceptMask.setVisibility(8);
        }
        EasyAnimation easyAnimation = EasyAnimation.INSTANCE;
        ConstraintLayout fishingItem = binding.fishingItem;
        Intrinsics.checkNotNullExpressionValue(fishingItem, "fishingItem");
        EasyAnimation.animateClick$default(easyAnimation, fishingItem, 0L, new Function0() { // from class: ru.mrlargha.arizonaui.fishing.FishingAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit onBindViewHolder$lambda$1$lambda$0;
                onBindViewHolder$lambda$1$lambda$0 = FishingAdapter.onBindViewHolder$lambda$1$lambda$0(FishingScreen.Companion.FishInfo.this, binding, this);
                return onBindViewHolder$lambda$1$lambda$0;
            }
        }, null, 5, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$1$lambda$0(FishingScreen.Companion.FishInfo fishInfo, FishingItemBinding fishingItemBinding, FishingAdapter fishingAdapter) {
        fishInfo.setPressed(true);
        if (Intrinsics.areEqual(fishInfo.getType(), "fish")) {
            fishingItemBinding.acceptMask.setVisibility(0);
        } else if (Intrinsics.areEqual(fishInfo.getType(), "trash") || Intrinsics.areEqual(fishInfo.getType(), "bomb")) {
            fishInfo.setImg(R.drawable.fishing_bomb);
            fishInfo.setType("bomb");
            fishingItemBinding.acceptMask.setVisibility(8);
        } else {
            fishInfo.setType("empty");
            fishingItemBinding.acceptMask.setVisibility(8);
        }
        OnItemClickListener onItemClickListener = fishingAdapter.onItemClickListener;
        if (onItemClickListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onItemClickListener");
            onItemClickListener = null;
        }
        onItemClickListener.callback(fishInfo.getId(), fishInfo.getType(), true);
        fishingAdapter.notifyItemChanged(fishingAdapter.fishInfoList.indexOf(fishInfo));
        return Unit.INSTANCE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.fishInfoList.size();
    }

    /* compiled from: FishingAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lru/mrlargha/arizonaui/fishing/FishingAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "binding", "Lru/mrlargha/arizonaui/databinding/FishingItemBinding;", "getBinding", "()Lru/mrlargha/arizonaui/databinding/FishingItemBinding;", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final FishingItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            FishingItemBinding bind = FishingItemBinding.bind(view);
            Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
            this.binding = bind;
        }

        public final FishingItemBinding getBinding() {
            return this.binding;
        }
    }

    public final void addItems(List<FishingScreen.Companion.FishInfo> infoList) {
        Intrinsics.checkNotNullParameter(infoList, "infoList");
        this.fishInfoList.clear();
        this.fishInfoList.addAll(infoList);
        notifyDataSetChanged();
    }
}
