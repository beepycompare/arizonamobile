package ru.mrlargha.commonui.elements.dialogs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.databinding.DialogBankHistoryItemBinding;
/* compiled from: DialogBankHistory.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/DialogBankHistoryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/commonui/elements/dialogs/DialogBankHistoryAdapter$ViewHolder;", "<init>", "()V", "items", "", "Lru/mrlargha/commonui/elements/dialogs/DialogBankHistoryRow;", "submitList", "", "newItems", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "ViewHolder", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
final class DialogBankHistoryAdapter extends RecyclerView.Adapter<ViewHolder> {
    private List<DialogBankHistoryRow> items = CollectionsKt.emptyList();

    public final void submitList(List<DialogBankHistoryRow> newItems) {
        Intrinsics.checkNotNullParameter(newItems, "newItems");
        this.items = newItems;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        DialogBankHistoryItemBinding inflate = DialogBankHistoryItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new ViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.items.get(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    /* compiled from: DialogBankHistory.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/DialogBankHistoryAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/commonui/databinding/DialogBankHistoryItemBinding;", "<init>", "(Lru/mrlargha/commonui/databinding/DialogBankHistoryItemBinding;)V", "bind", "", "row", "Lru/mrlargha/commonui/elements/dialogs/DialogBankHistoryRow;", "Companion", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private static final Companion Companion = new Companion(null);
        private static final String EMPTY_CELL = "-";
        private final DialogBankHistoryItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(DialogBankHistoryItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }

        public final void bind(DialogBankHistoryRow row) {
            Intrinsics.checkNotNullParameter(row, "row");
            DialogBankHistoryItemBinding dialogBankHistoryItemBinding = this.binding;
            TextView textView = dialogBankHistoryItemBinding.dialogBankHistoryItemId;
            String id = row.getId();
            if (StringsKt.isBlank(id)) {
                id = "-";
            }
            textView.setText(id);
            dialogBankHistoryItemBinding.dialogBankHistoryItemIcon.setImageResource(row.operationIconRes());
            TextView textView2 = dialogBankHistoryItemBinding.dialogBankHistoryItemType;
            Context context = dialogBankHistoryItemBinding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            textView2.setText(row.operationTitle(context));
            dialogBankHistoryItemBinding.dialogBankHistoryItemPercent.setText(row.commissionBadgeText());
            TextView dialogBankHistoryItemPercent = dialogBankHistoryItemBinding.dialogBankHistoryItemPercent;
            Intrinsics.checkNotNullExpressionValue(dialogBankHistoryItemPercent, "dialogBankHistoryItemPercent");
            dialogBankHistoryItemPercent.setVisibility(!StringsKt.isBlank(row.commissionBadgeText()) ? 0 : 8);
            TextView textView3 = dialogBankHistoryItemBinding.dialogBankHistoryItemTarget;
            String target = row.getTarget();
            if (StringsKt.isBlank(target)) {
                target = "-";
            }
            textView3.setText(target);
            dialogBankHistoryItemBinding.dialogBankHistoryItemAmount.setText(row.amountText());
            TextView textView4 = dialogBankHistoryItemBinding.dialogBankHistoryItemDate;
            String date = row.getDate();
            textView4.setText(StringsKt.isBlank(date) ? "-" : date);
        }

        /* compiled from: DialogBankHistory.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/DialogBankHistoryAdapter$ViewHolder$Companion;", "", "<init>", "()V", "EMPTY_CELL", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes6.dex */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }
}
