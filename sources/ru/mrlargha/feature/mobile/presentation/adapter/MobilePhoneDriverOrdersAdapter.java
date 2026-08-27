package ru.mrlargha.feature.mobile.presentation.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.feature.mobile.R;
import ru.mrlargha.feature.mobile.domain.obj.MobilePhoneDriverOrder;
/* compiled from: MobilePhoneDriverOrdersAdapter.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0016J\u0014\u0010\u0014\u001a\u00020\n2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016J\u0006\u0010\u0018\u001a\u00020\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/adapter/MobilePhoneDriverOrdersAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/feature/mobile/presentation/adapter/MobilePhoneDriverOrdersViewHolder;", "<init>", "()V", "orders", "Lru/mrlargha/feature/mobile/presentation/adapter/MobilePhoneDriverOrdersData;", "onChoseOrderClickListener", "Lru/mrlargha/feature/mobile/presentation/adapter/MobilePhoneDriverOrdersAdapter$OnChoseOrderClickListener;", "setOnChoseOrderClickListener", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "addOrders", "ordersList", "", "Lru/mrlargha/feature/mobile/domain/obj/MobilePhoneDriverOrder;", "clearOrders", "OnChoseOrderClickListener", "mobile"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MobilePhoneDriverOrdersAdapter extends RecyclerView.Adapter<MobilePhoneDriverOrdersViewHolder> {
    private OnChoseOrderClickListener onChoseOrderClickListener;
    private final MobilePhoneDriverOrdersData orders = new MobilePhoneDriverOrdersData();

    /* compiled from: MobilePhoneDriverOrdersAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/adapter/MobilePhoneDriverOrdersAdapter$OnChoseOrderClickListener;", "", "callback", "", "orderId", "", "mobile"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
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
    public void onBindViewHolder(final MobilePhoneDriverOrdersViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final MobilePhoneDriverOrder mobilePhoneDriverOrder = this.orders.get(i);
        holder.getDriverOrder().driverClientName.setText(mobilePhoneDriverOrder.getName());
        holder.getDriverOrder().driverRate.setText(String.valueOf(mobilePhoneDriverOrder.getRating()));
        holder.getDriverOrder().driverDistnace.setText(holder.itemView.getContext().getString(R.string.mobile_driver_distance_meters, Integer.valueOf(mobilePhoneDriverOrder.getDistance())));
        holder.getDriverOrder().driverOrderItem.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.mobile.presentation.adapter.MobilePhoneDriverOrdersAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MobilePhoneDriverOrdersAdapter.onBindViewHolder$lambda$0(MobilePhoneDriverOrdersViewHolder.this, this, mobilePhoneDriverOrder, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void onBindViewHolder$lambda$0(MobilePhoneDriverOrdersViewHolder mobilePhoneDriverOrdersViewHolder, MobilePhoneDriverOrdersAdapter mobilePhoneDriverOrdersAdapter, MobilePhoneDriverOrder mobilePhoneDriverOrder, View view) {
        if (mobilePhoneDriverOrdersViewHolder.getBindingAdapterPosition() == -1 || !mobilePhoneDriverOrdersAdapter.orders.containsOrder(mobilePhoneDriverOrder.getId())) {
            return;
        }
        OnChoseOrderClickListener onChoseOrderClickListener = mobilePhoneDriverOrdersAdapter.onChoseOrderClickListener;
        if (onChoseOrderClickListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onChoseOrderClickListener");
            onChoseOrderClickListener = null;
        }
        onChoseOrderClickListener.callback(mobilePhoneDriverOrder.getId());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.orders.getSize();
    }

    public final void addOrders(List<MobilePhoneDriverOrder> ordersList) {
        Intrinsics.checkNotNullParameter(ordersList, "ordersList");
        OrderInsertion appendNew = this.orders.appendNew(ordersList);
        if (appendNew == null) {
            return;
        }
        notifyItemRangeInserted(appendNew.getPositionStart(), appendNew.getItemCount());
    }

    public final void clearOrders() {
        this.orders.clear();
        notifyDataSetChanged();
    }
}
