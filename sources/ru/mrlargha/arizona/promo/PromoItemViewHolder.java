package ru.mrlargha.arizona.promo;

import android.os.CountDownTimer;
import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.feature.arizona.promo.databinding.PromoItemBinding;
/* compiled from: PromoAdapter.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lru/mrlargha/arizona/promo/PromoItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "rewardItemsAdapter", "Lru/mrlargha/arizona/promo/RewardItemsAdapter;", "getRewardItemsAdapter", "()Lru/mrlargha/arizona/promo/RewardItemsAdapter;", "binding", "Lru/mrlargha/feature/arizona/promo/databinding/PromoItemBinding;", "getBinding", "()Lru/mrlargha/feature/arizona/promo/databinding/PromoItemBinding;", "timer", "Landroid/os/CountDownTimer;", "getTimer", "()Landroid/os/CountDownTimer;", "setTimer", "(Landroid/os/CountDownTimer;)V", NotificationCompat.CATEGORY_PROMO}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PromoItemViewHolder extends RecyclerView.ViewHolder {
    private final PromoItemBinding binding;
    private final RewardItemsAdapter rewardItemsAdapter;
    private CountDownTimer timer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PromoItemViewHolder(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        RewardItemsAdapter rewardItemsAdapter = new RewardItemsAdapter();
        this.rewardItemsAdapter = rewardItemsAdapter;
        PromoItemBinding bind = PromoItemBinding.bind(view);
        bind.rv.setAdapter(rewardItemsAdapter);
        Intrinsics.checkNotNullExpressionValue(bind, "apply(...)");
        this.binding = bind;
    }

    public final RewardItemsAdapter getRewardItemsAdapter() {
        return this.rewardItemsAdapter;
    }

    public final PromoItemBinding getBinding() {
        return this.binding;
    }

    public final CountDownTimer getTimer() {
        return this.timer;
    }

    public final void setTimer(CountDownTimer countDownTimer) {
        this.timer = countDownTimer;
    }
}
