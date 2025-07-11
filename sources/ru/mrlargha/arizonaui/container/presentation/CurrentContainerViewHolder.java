package ru.mrlargha.arizonaui.container.presentation;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.arizonaui.databinding.AuctionCurrentItemBinding;
/* compiled from: CurrentContainerAdapter.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lru/mrlargha/arizonaui/container/presentation/CurrentContainerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "auctionCurrentItemBinding", "Lru/mrlargha/arizonaui/databinding/AuctionCurrentItemBinding;", "getAuctionCurrentItemBinding", "()Lru/mrlargha/arizonaui/databinding/AuctionCurrentItemBinding;", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CurrentContainerViewHolder extends RecyclerView.ViewHolder {
    private final AuctionCurrentItemBinding auctionCurrentItemBinding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CurrentContainerViewHolder(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        AuctionCurrentItemBinding bind = AuctionCurrentItemBinding.bind(view);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.auctionCurrentItemBinding = bind;
    }

    public final AuctionCurrentItemBinding getAuctionCurrentItemBinding() {
        return this.auctionCurrentItemBinding;
    }
}
