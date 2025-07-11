package ru.mrlargha.arizonaui.donate.presentation.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.vending.expansion.downloader.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.databinding.DonateItemBinding;
import ru.mrlargha.arizonaui.donate.domain.obj.DonateItem;
import ru.mrlargha.arizonaui.donate.domain.obj.DonateItemStatus;
import ru.mrlargha.commonui.utils.StringKt;
/* compiled from: DonateAdapter.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002-.B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0018J\u000e\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0016J\u0018\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0018\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u001fH\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002J\b\u0010'\u001a\u00020\u001fH\u0016J\u0006\u0010(\u001a\u00020\u001aJ\u0014\u0010)\u001a\u00020\u001a2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00070+J\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00070+R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lru/mrlargha/arizonaui/donate/presentation/adapter/DonateAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/arizonaui/donate/presentation/adapter/DonateHolder;", "<init>", "()V", "donateList", "Ljava/util/ArrayList;", "Lru/mrlargha/arizonaui/donate/domain/obj/DonateItem;", "Lkotlin/collections/ArrayList;", "itemsBinding", "Lru/mrlargha/arizonaui/databinding/DonateItemBinding;", "getItemsBinding", "()Lru/mrlargha/arizonaui/databinding/DonateItemBinding;", "setItemsBinding", "(Lru/mrlargha/arizonaui/databinding/DonateItemBinding;)V", "parent", "Landroid/view/ViewGroup;", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lru/mrlargha/arizonaui/donate/presentation/adapter/DonateAdapter$OnItemClickListener;", "currentListener", "Lru/mrlargha/arizonaui/donate/presentation/adapter/DonateAdapter$OnCurrentItemListener;", "setOnCurrentItemClickListener", "", "currentItemListener", "setOnItemClickListener", "onCreateViewHolder", "viewType", "", "onBindViewHolder", "holder", "position", "calculateTimeRemaining", "", "unixTime", "", "getItemCount", "clearItems", "addItem", "donateProduct", "", "getActuallyList", "OnItemClickListener", "OnCurrentItemListener", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DonateAdapter extends RecyclerView.Adapter<DonateHolder> {
    private OnCurrentItemListener currentListener;
    private ArrayList<DonateItem> donateList = new ArrayList<>();
    public DonateItemBinding itemsBinding;
    private OnItemClickListener listener;
    public ViewGroup parent;

    /* compiled from: DonateAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lru/mrlargha/arizonaui/donate/presentation/adapter/DonateAdapter$OnCurrentItemListener;", "", "onCurrentItemClick", "", "position", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface OnCurrentItemListener {
        void onCurrentItemClick(int i);
    }

    /* compiled from: DonateAdapter.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lru/mrlargha/arizonaui/donate/presentation/adapter/DonateAdapter$OnItemClickListener;", "", "onItemClick", "", "position", "", "binding", "Lru/mrlargha/arizonaui/databinding/DonateItemBinding;", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface OnItemClickListener {
        void onItemClick(int i, DonateItemBinding donateItemBinding);
    }

    public final DonateItemBinding getItemsBinding() {
        DonateItemBinding donateItemBinding = this.itemsBinding;
        if (donateItemBinding != null) {
            return donateItemBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("itemsBinding");
        return null;
    }

    public final void setItemsBinding(DonateItemBinding donateItemBinding) {
        Intrinsics.checkNotNullParameter(donateItemBinding, "<set-?>");
        this.itemsBinding = donateItemBinding;
    }

    public final ViewGroup getParent() {
        ViewGroup viewGroup = this.parent;
        if (viewGroup != null) {
            return viewGroup;
        }
        Intrinsics.throwUninitializedPropertyAccessException("parent");
        return null;
    }

    public final void setParent(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
        this.parent = viewGroup;
    }

    public final void setOnCurrentItemClickListener(OnCurrentItemListener currentItemListener) {
        Intrinsics.checkNotNullParameter(currentItemListener, "currentItemListener");
        this.currentListener = currentItemListener;
    }

    public final void setOnItemClickListener(OnItemClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public DonateHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.donate_item, parent, false);
        setParent(parent);
        DonateItemBinding bind = DonateItemBinding.bind(inflate);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        setItemsBinding(bind);
        Intrinsics.checkNotNull(inflate);
        return new DonateHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(DonateHolder holder, int i) {
        Integer currencyType;
        Intrinsics.checkNotNullParameter(holder, "holder");
        DonateItem donateItem = this.donateList.get(i);
        Intrinsics.checkNotNullExpressionValue(donateItem, "get(...)");
        DonateItem donateItem2 = donateItem;
        OnItemClickListener onItemClickListener = this.listener;
        if (onItemClickListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            onItemClickListener = null;
        }
        OnCurrentItemListener onCurrentItemListener = this.currentListener;
        if (onCurrentItemListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentListener");
            onCurrentItemListener = null;
        }
        holder.bind(donateItem2, onItemClickListener, onCurrentItemListener);
        holder.getBinding().donateBuyButton.setVisibility(4);
        holder.getBinding().donateItemBackground.setBackground(ContextCompat.getDrawable(getParent().getContext(), R.drawable.ic_item_bg));
        holder.getBinding().marketItem.setAlpha(1.0f);
        holder.getBinding().marketPrice.setAlpha(1.0f);
        holder.getBinding().itemTittle.setAlpha(1.0f);
        holder.getBinding().donateAzIcon.setAlpha(1.0f);
        holder.getBinding().donateDiscountNotify.setVisibility(4);
        if (this.donateList.get(i).getDiscount() > 0) {
            holder.getBinding().donateDiscountNotify.setVisibility(0);
            holder.getBinding().donateDiscountNotify.setText(Constants.FILENAME_SEQUENCE_SEPARATOR + this.donateList.get(i).getDiscount() + "% скидка");
        }
        if (this.donateList.get(i).getDiscount() == 0 && this.donateList.get(i).getSpecialOffer()) {
            holder.getBinding().donateDiscountNotify.setVisibility(0);
            holder.getBinding().donateDiscountNotify.setText("специальное предложение");
            holder.getBinding().donateDiscountNotify.setTextSize(5.0f);
            holder.getBinding().donateDiscountNotify.setBackground(ContextCompat.getDrawable(getParent().getContext(), R.drawable.donate_special_offer_notify));
        }
        if (this.donateList.get(i).getOnClicked()) {
            holder.getBinding().donateBuyButton.setVisibility(0);
            holder.getBinding().donateItemBackground.setBackground(ContextCompat.getDrawable(holder.getBinding().cardView.getContext(), R.drawable.ic_donate_item_clicked));
            holder.getBinding().marketItem.setAlpha(0.5f);
            holder.getBinding().marketPrice.setAlpha(0.5f);
            holder.getBinding().itemTittle.setAlpha(0.5f);
            holder.getBinding().donateAzIcon.setAlpha(0.5f);
        }
        if (this.donateList.get(i).isSeason()) {
            holder.getBinding().donateDiscountNotify.setVisibility(0);
            holder.getBinding().donateDiscountNotify.setText("СЕЗОННАЯ КОЛЛЕКЦИЯ");
        }
        int price = this.donateList.get(i).getDiscount() > 0 ? this.donateList.get(i).getPrice() - ((this.donateList.get(i).getDiscount() * this.donateList.get(i).getPrice()) / 100) : this.donateList.get(i).getPrice();
        if (this.donateList.get(i).getCurrencyType() == null || ((currencyType = this.donateList.get(i).getCurrencyType()) != null && currencyType.intValue() == 0)) {
            holder.getBinding().donateAzIcon.setVisibility(0);
            holder.getBinding().marketPrice.setText(String.valueOf(price));
        } else {
            holder.getBinding().donateAzIcon.setVisibility(8);
            holder.getBinding().marketPrice.setText(price + " ₽");
        }
        if (this.donateList.get(i).getText() != null) {
            holder.getBinding().statusText.setVisibility(0);
            holder.getBinding().statusText.setText(this.donateList.get(i).getText());
        } else {
            Long unix = this.donateList.get(i).getUnix();
            if (unix == null || unix.longValue() != 0) {
                holder.getBinding().statusText.setVisibility(0);
                TextView textView = holder.getBinding().statusText;
                Long unix2 = this.donateList.get(i).getUnix();
                textView.setText(unix2 != null ? calculateTimeRemaining(unix2.longValue()) : null);
            } else {
                holder.getBinding().statusText.setVisibility(8);
            }
        }
        holder.getBinding().statusContainer.setVisibility(8);
        String status = this.donateList.get(i).getStatus();
        if (Intrinsics.areEqual(status, DonateItemStatus.AVAILABLE.getStatus())) {
            holder.getBinding().statusContainer.setVisibility(8);
        } else if (Intrinsics.areEqual(status, DonateItemStatus.PURCHASED.getStatus())) {
            holder.getBinding().statusContainer.setVisibility(0);
            holder.getBinding().statusIc.setImageResource(R.drawable.donate_shop_check_ic);
            holder.getBinding().donateDiscountNotify.setVisibility(0);
            holder.getBinding().donateDiscountNotify.setText("Куплен");
            holder.getBinding().donateDiscountNotify.setBackground(ContextCompat.getDrawable(getParent().getContext(), R.drawable.donate_green_notify));
        } else if (Intrinsics.areEqual(status, DonateItemStatus.DISABLED.getStatus())) {
            holder.getBinding().statusContainer.setVisibility(0);
            holder.getBinding().statusIc.setImageResource(R.drawable.donate_shop_lock_ic);
            holder.getBinding().donateDiscountNotify.setVisibility(0);
            holder.getBinding().donateDiscountNotify.setText("Заблокировано");
            holder.getBinding().donateDiscountNotify.setBackground(ContextCompat.getDrawable(getParent().getContext(), R.drawable.donate_discount_notify));
        } else if (Intrinsics.areEqual(status, DonateItemStatus.RESERVED.getStatus())) {
            holder.getBinding().statusContainer.setVisibility(0);
            holder.getBinding().statusIc.setImageResource(R.drawable.donate_shop_shield_ic);
            holder.getBinding().donateDiscountNotify.setVisibility(0);
            holder.getBinding().donateDiscountNotify.setText("Ждет оплаты");
            holder.getBinding().donateDiscountNotify.setBackground(ContextCompat.getDrawable(getParent().getContext(), R.drawable.donate_special_offer_notify));
        } else if (Intrinsics.areEqual(status, DonateItemStatus.COOLDOWN.getStatus())) {
            holder.getBinding().statusContainer.setVisibility(0);
            holder.getBinding().statusIc.setImageResource(R.drawable.donate_shop_timer_ic);
            holder.getBinding().donateDiscountNotify.setVisibility(0);
            holder.getBinding().donateDiscountNotify.setText("Подождите");
            holder.getBinding().donateDiscountNotify.setBackground(ContextCompat.getDrawable(getParent().getContext(), R.drawable.donate_discount_notify));
        } else if (Intrinsics.areEqual(status, DonateItemStatus.WAITING.getStatus())) {
            holder.getBinding().statusContainer.setVisibility(0);
            holder.getBinding().statusIc.setImageResource(R.drawable.donate_shop_timer_ic);
            holder.getBinding().donateDiscountNotify.setVisibility(0);
            holder.getBinding().donateDiscountNotify.setText("Ожидание");
            holder.getBinding().donateDiscountNotify.setBackground(ContextCompat.getDrawable(getParent().getContext(), R.drawable.donate_special_offer_notify));
        }
    }

    private final String calculateTimeRemaining(long j) {
        long abs = Math.abs((j * 1000) - System.currentTimeMillis());
        long hours = TimeUnit.MILLISECONDS.toHours(abs) % 24;
        return hours + " ч " + (TimeUnit.MILLISECONDS.toMinutes(abs) % 60) + " м";
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.donateList.size();
    }

    public final void clearItems() {
        this.donateList.clear();
        notifyDataSetChanged();
    }

    public final void addItem(List<DonateItem> donateProduct) {
        Intrinsics.checkNotNullParameter(donateProduct, "donateProduct");
        this.donateList.addAll(donateProduct);
        System.out.println((Object) ("FROM SERVER " + StringKt.toStringJson(this.donateList)));
        notifyDataSetChanged();
    }

    public final List<DonateItem> getActuallyList() {
        return this.donateList;
    }
}
