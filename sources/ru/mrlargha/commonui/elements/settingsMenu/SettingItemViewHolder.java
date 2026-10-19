package ru.mrlargha.commonui.elements.settingsMenu;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.databinding.SettingItemBinding;
/* compiled from: SettingsAdapter.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\n\u001a\u00020\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lru/mrlargha/commonui/elements/settingsMenu/SettingItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "binding", "Lru/mrlargha/commonui/databinding/SettingItemBinding;", "getBinding", "()Lru/mrlargha/commonui/databinding/SettingItemBinding;", "getSettingItemPosition", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SettingItemViewHolder extends RecyclerView.ViewHolder {
    private final SettingItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingItemViewHolder(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        SettingItemBinding bind = SettingItemBinding.bind(view);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
    }

    public final SettingItemBinding getBinding() {
        return this.binding;
    }

    public final int getSettingItemPosition() {
        return getAbsoluteAdapterPosition();
    }
}
