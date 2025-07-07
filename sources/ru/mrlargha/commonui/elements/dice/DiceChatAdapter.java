package ru.mrlargha.commonui.elements.dice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.DiceMessageItemBinding;
/* compiled from: DiceChatAdapter.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\fH\u0016J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0007J\u0006\u0010\u0014\u001a\u00020\u000fR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lru/mrlargha/commonui/elements/dice/DiceChatAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/commonui/elements/dice/DiceChatAdapter$DiceGameViewHolder;", "<init>", "()V", "messages", "", "Lru/mrlargha/commonui/elements/dice/DiceChatMessageData;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "", "holder", "position", "addMessages", "message", "clearChat", "DiceGameViewHolder", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DiceChatAdapter extends RecyclerView.Adapter<DiceGameViewHolder> {
    private final List<DiceChatMessageData> messages = new ArrayList();

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public DiceGameViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.dice_message_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new DiceGameViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.messages.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(DiceGameViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        DiceChatMessageData diceChatMessageData = this.messages.get(i);
        DiceMessageItemBinding binding = holder.getBinding();
        binding.messageNickname.setText(diceChatMessageData.getName() + StringUtils.PROCESS_POSTFIX_DELIMITER);
        binding.messageText.setText(diceChatMessageData.getText());
    }

    public final void addMessages(DiceChatMessageData message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.messages.add(message);
        notifyDataSetChanged();
    }

    public final void clearChat() {
        this.messages.clear();
        notifyDataSetChanged();
    }

    /* compiled from: DiceChatAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/dice/DiceChatAdapter$DiceGameViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "binding", "Lru/mrlargha/commonui/databinding/DiceMessageItemBinding;", "getBinding", "()Lru/mrlargha/commonui/databinding/DiceMessageItemBinding;", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DiceGameViewHolder extends RecyclerView.ViewHolder {
        private final DiceMessageItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DiceGameViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            DiceMessageItemBinding bind = DiceMessageItemBinding.bind(view);
            Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
            this.binding = bind;
        }

        public final DiceMessageItemBinding getBinding() {
            return this.binding;
        }
    }
}
