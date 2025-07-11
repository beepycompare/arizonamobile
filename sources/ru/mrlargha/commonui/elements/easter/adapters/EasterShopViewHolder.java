package ru.mrlargha.commonui.elements.easter.adapters;

import android.os.CountDownTimer;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.databinding.EasterBattlePassShopItemBinding;
/* compiled from: ShopAdapter.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lru/mrlargha/commonui/elements/easter/adapters/EasterShopViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "timer", "Landroid/os/CountDownTimer;", "getTimer", "()Landroid/os/CountDownTimer;", "setTimer", "(Landroid/os/CountDownTimer;)V", "binding", "Lru/mrlargha/commonui/databinding/EasterBattlePassShopItemBinding;", "getBinding", "()Lru/mrlargha/commonui/databinding/EasterBattlePassShopItemBinding;", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EasterShopViewHolder extends RecyclerView.ViewHolder {
    private final EasterBattlePassShopItemBinding binding;
    private CountDownTimer timer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EasterShopViewHolder(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        EasterBattlePassShopItemBinding bind = EasterBattlePassShopItemBinding.bind(view);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
    }

    public final CountDownTimer getTimer() {
        return this.timer;
    }

    public final void setTimer(CountDownTimer countDownTimer) {
        this.timer = countDownTimer;
    }

    public final EasterBattlePassShopItemBinding getBinding() {
        return this.binding;
    }
}
