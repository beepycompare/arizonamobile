package ru.mrlargha.arizonaui.mobile.presentation.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.mobile.domain.obj.MobilePhoneDriverOrder;
/* compiled from: MobilePhoneDriverOrdersAdapter.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\u0014\u0010\u0016\u001a\u00020\f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u0018J\u0006\u0010\u0019\u001a\u00020\fR\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/adapter/MobilePhoneDriverOrdersAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/arizonaui/mobile/presentation/adapter/MobilePhoneDriverOrdersViewHolder;", "<init>", "()V", "orders", "Ljava/util/ArrayList;", "Lru/mrlargha/arizonaui/mobile/domain/obj/MobilePhoneDriverOrder;", "Lkotlin/collections/ArrayList;", "onChoseOrderClickListener", "Lru/mrlargha/arizonaui/mobile/presentation/adapter/MobilePhoneDriverOrdersAdapter$OnChoseOrderClickListener;", "setOnChoseOrderClickListener", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "addOrders", "ordersList", "", "clearOrders", "OnChoseOrderClickListener", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MobilePhoneDriverOrdersAdapter extends RecyclerView.Adapter<MobilePhoneDriverOrdersViewHolder> {
    private OnChoseOrderClickListener onChoseOrderClickListener;
    private final ArrayList<MobilePhoneDriverOrder> orders = new ArrayList<>();

    /* compiled from: MobilePhoneDriverOrdersAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/adapter/MobilePhoneDriverOrdersAdapter$OnChoseOrderClickListener;", "", "callback", "", "position", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface OnChoseOrderClickListener {
        void callback(int i);
    }

    public final void setOnChoseOrderClickListener(OnChoseOrderClickListener onChoseOrderClickListener) {
        Intrinsics.checkNotNullParameter(onChoseOrderClickListener, "onChoseOrderClickListener");
        this.onChoseOrderClickListener = onChoseOrderClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MobilePhoneDriverOrdersViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.mobile_phone_driver_order, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new MobilePhoneDriverOrdersViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(MobilePhoneDriverOrdersViewHolder holder, final int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.getDriverOrder().driverClientName.setText(this.orders.get(i).getName());
        holder.getDriverOrder().driverRate.setText(String.valueOf(this.orders.get(i).getRating()));
        holder.getDriverOrder().driverDistnace.setText(this.orders.get(i).getDistance() + " м");
        holder.getDriverOrder().driverOrderItem.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.adapter.MobilePhoneDriverOrdersAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MobilePhoneDriverOrdersAdapter.onBindViewHolder$lambda$0(MobilePhoneDriverOrdersAdapter.this, i, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(MobilePhoneDriverOrdersAdapter mobilePhoneDriverOrdersAdapter, int i, View view) {
        if (mobilePhoneDriverOrdersAdapter.orders.isEmpty()) {
            return;
        }
        OnChoseOrderClickListener onChoseOrderClickListener = mobilePhoneDriverOrdersAdapter.onChoseOrderClickListener;
        if (onChoseOrderClickListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onChoseOrderClickListener");
            onChoseOrderClickListener = null;
        }
        onChoseOrderClickListener.callback(mobilePhoneDriverOrdersAdapter.orders.get(i).getId());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.orders.size();
    }

    public final void addOrders(List<MobilePhoneDriverOrder> ordersList) {
        Intrinsics.checkNotNullParameter(ordersList, "ordersList");
        ArrayList arrayList = new ArrayList();
        int size = this.orders.size();
        if (this.orders.isEmpty()) {
            this.orders.addAll(ordersList);
            notifyItemRangeInserted(size, this.orders.size());
            return;
        }
        for (MobilePhoneDriverOrder mobilePhoneDriverOrder : ordersList) {
            if (!this.orders.contains(mobilePhoneDriverOrder)) {
                arrayList.add(mobilePhoneDriverOrder);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.orders.addAll(ordersList);
        notifyItemRangeInserted(size, this.orders.size());
    }

    public final void clearOrders() {
        this.orders.clear();
        notifyDataSetChanged();
    }
}
