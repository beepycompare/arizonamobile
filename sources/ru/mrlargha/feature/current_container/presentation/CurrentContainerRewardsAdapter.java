package ru.mrlargha.feature.current_container.presentation;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.feature.current_container.R;
import ru.mrlargha.feature.current_container.domain.obj.ContainerPrize;
/* compiled from: CurrentContainerRewardsAdapter.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0006H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0006H\u0016J\b\u0010\u0019\u001a\u00020\u0006H\u0016J\u0014\u0010\u001a\u001a\u00020\u00162\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001cR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lru/mrlargha/feature/current_container/presentation/CurrentContainerRewardsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/feature/current_container/presentation/CurrentContainerRewardsViewHolder;", "targetActivity", "Landroid/app/Activity;", "backendId", "", "<init>", "(Landroid/app/Activity;I)V", "listItem", "Ljava/util/ArrayList;", "Lru/mrlargha/feature/current_container/domain/obj/ContainerPrize;", "Lkotlin/collections/ArrayList;", "context", "Landroid/content/Context;", "sendServerEvent", "Lru/mrlargha/commonui/core/IBackendNotifier;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "getItemCount", "addItems", "items", "", "current-container"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CurrentContainerRewardsAdapter extends RecyclerView.Adapter<CurrentContainerRewardsViewHolder> {
    private final int backendId;
    private Context context;
    private final ArrayList<ContainerPrize> listItem;
    private final IBackendNotifier sendServerEvent;

    public CurrentContainerRewardsAdapter(Activity targetActivity, int i) {
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        this.backendId = i;
        this.listItem = new ArrayList<>();
        this.sendServerEvent = (IBackendNotifier) targetActivity;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public CurrentContainerRewardsViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        this.context = context;
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.container_prize_item, parent, false);
        Intrinsics.checkNotNull(inflate);
        return new CurrentContainerRewardsViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(CurrentContainerRewardsViewHolder holder, final int i) {
        Drawable drawable;
        Intrinsics.checkNotNullParameter(holder, "holder");
        ContainerPrize containerPrize = this.listItem.get(i);
        Intrinsics.checkNotNullExpressionValue(containerPrize, "get(...)");
        ContainerPrize containerPrize2 = containerPrize;
        holder.getBinding().acItemCard.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.current_container.presentation.CurrentContainerRewardsAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r0.sendServerEvent.clickedWrapper(CurrentContainerRewardsAdapter.this.backendId, i, 0);
            }
        });
        ConstraintLayout constraintLayout = holder.getBinding().cpiBg;
        int status = containerPrize2.getStatus();
        Context context = this.context;
        if (status == 0) {
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                context = null;
            }
            drawable = ContextCompat.getDrawable(context, R.drawable.auction_item_bg);
        } else {
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                context = null;
            }
            drawable = ContextCompat.getDrawable(context, R.drawable.active_shape_bg);
        }
        constraintLayout.setBackground(drawable);
        holder.getBinding().acItemTittle.setText(containerPrize2.getTitle());
        Picasso.get().load(CurrentContainerCdnKt.getItemImageUrl(containerPrize2.getImage())).placeholder(R.drawable.item).error(R.drawable.item).into(holder.getBinding().acItemImage);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.listItem.size();
    }

    public final void addItems(List<ContainerPrize> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.listItem.clear();
        this.listItem.addAll(items);
    }
}
