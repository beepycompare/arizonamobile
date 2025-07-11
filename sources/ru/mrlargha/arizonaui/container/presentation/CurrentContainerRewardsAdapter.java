package ru.mrlargha.arizonaui.container.presentation;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.container.domain.obj.ContainerPrize;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.utils.FirebaseConfigHelper;
/* compiled from: CurrentContainerRewardsAdapter.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0006H\u0016J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0006H\u0016J\b\u0010\u001d\u001a\u00020\u0006H\u0016J\u0014\u0010\u001e\u001a\u00020\u001a2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000f0 R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lru/mrlargha/arizonaui/container/presentation/CurrentContainerRewardsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/arizonaui/container/presentation/CurrentContainerRewardsViewHolder;", "targetActivity", "Landroid/app/Activity;", "backendId", "", "<init>", "(Landroid/app/Activity;I)V", "getTargetActivity", "()Landroid/app/Activity;", "getBackendId", "()I", "listItem", "Ljava/util/ArrayList;", "Lru/mrlargha/arizonaui/container/domain/obj/ContainerPrize;", "Lkotlin/collections/ArrayList;", "context", "Landroid/content/Context;", "sendServerEvent", "Lru/mrlargha/commonui/core/IBackendNotifier;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "getItemCount", "addItems", FirebaseAnalytics.Param.ITEMS, "", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CurrentContainerRewardsAdapter extends RecyclerView.Adapter<CurrentContainerRewardsViewHolder> {
    private final int backendId;
    private Context context;
    private final ArrayList<ContainerPrize> listItem;
    private final IBackendNotifier sendServerEvent;
    private final Activity targetActivity;

    public final int getBackendId() {
        return this.backendId;
    }

    public final Activity getTargetActivity() {
        return this.targetActivity;
    }

    public CurrentContainerRewardsAdapter(Activity targetActivity, int i) {
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        this.targetActivity = targetActivity;
        this.backendId = i;
        this.listItem = new ArrayList<>();
        Intrinsics.checkNotNull(targetActivity, "null cannot be cast to non-null type ru.mrlargha.commonui.core.IBackendNotifier");
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
        holder.getContainerPrizeItemBinding().acItemCard.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.container.presentation.CurrentContainerRewardsAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CurrentContainerRewardsAdapter.onBindViewHolder$lambda$0(CurrentContainerRewardsAdapter.this, i, view);
            }
        });
        ConstraintLayout constraintLayout = holder.getContainerPrizeItemBinding().cpiBg;
        Context context = null;
        if (this.listItem.get(i).getStatus() == 0) {
            Context context2 = this.context;
            if (context2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
            } else {
                context = context2;
            }
            drawable = ContextCompat.getDrawable(context, R.drawable.auction_item_bg);
        } else {
            Context context3 = this.context;
            if (context3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
            } else {
                context = context3;
            }
            drawable = ContextCompat.getDrawable(context, R.drawable.active_shape_bg);
        }
        constraintLayout.setBackground(drawable);
        holder.getContainerPrizeItemBinding().acItemTittle.setText(this.listItem.get(i).getTitle());
        Picasso picasso = Picasso.get();
        String resourceUrl = FirebaseConfigHelper.INSTANCE.getResourceUrl();
        picasso.load(resourceUrl + "projects/arizona-rp/assets/images/donate/" + this.listItem.get(i).getImage() + ".webp").placeholder(R.drawable.item).into(holder.getContainerPrizeItemBinding().acItemImage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(CurrentContainerRewardsAdapter currentContainerRewardsAdapter, int i, View view) {
        currentContainerRewardsAdapter.sendServerEvent.clickedWrapper(currentContainerRewardsAdapter.backendId, i, 0);
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
