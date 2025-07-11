package ru.mrlargha.arizonaui.container.presentation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.container.domain.obj.ContainerRewards;
import ru.mrlargha.commonui.utils.FirebaseConfigHelper;
/* compiled from: CurrentContainerAdapter.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\rH\u0016J\b\u0010\u0012\u001a\u00020\rH\u0016J\u0014\u0010\u0013\u001a\u00020\u000f2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0014J\u0006\u0010\u0015\u001a\u00020\u000fR\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lru/mrlargha/arizonaui/container/presentation/CurrentContainerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/arizonaui/container/presentation/CurrentContainerViewHolder;", "<init>", "()V", "containerItemList", "Ljava/util/ArrayList;", "Lru/mrlargha/arizonaui/container/domain/obj/ContainerRewards;", "Lkotlin/collections/ArrayList;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "addItems", "", "clearItems", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CurrentContainerAdapter extends RecyclerView.Adapter<CurrentContainerViewHolder> {
    private ArrayList<ContainerRewards> containerItemList = new ArrayList<>();

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public CurrentContainerViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.auction_current_item, parent, false);
        Intrinsics.checkNotNull(inflate);
        return new CurrentContainerViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(CurrentContainerViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.getAuctionCurrentItemBinding().acItemTittle.setText(this.containerItemList.get(i).getTittle());
        Picasso picasso = Picasso.get();
        String resourceUrl = FirebaseConfigHelper.INSTANCE.getResourceUrl();
        picasso.load(resourceUrl + "projects/arizona-rp/assets/images/donate/" + this.containerItemList.get(i).getImage() + ".webp").placeholder(R.drawable.item).into(holder.getAuctionCurrentItemBinding().acItemImage);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.containerItemList.size();
    }

    public final void addItems(List<ContainerRewards> containerItemList) {
        Intrinsics.checkNotNullParameter(containerItemList, "containerItemList");
        this.containerItemList.addAll(containerItemList);
        notifyDataSetChanged();
    }

    public final void clearItems() {
        this.containerItemList.clear();
        notifyDataSetChanged();
    }
}
