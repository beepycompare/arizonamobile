package ru.mrlargha.commonui.elements.dialogs;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.databinding.DialogBankTaxPaymentItemBinding;
import ru.mrlargha.commonui.elements.dialogs.DialogBankTaxPaymentAdapter;
import ru.mrlargha.commonui.utils.emoji.ChatEmoji;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* compiled from: DialogBankTaxPayment.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u001b\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0007\u0010\bJ\"\u0010\u000e\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\rJ\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005H\u0016J\u0018\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0005H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/DialogBankTaxPaymentAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/commonui/elements/dialogs/DialogBankTaxPaymentAdapter$ViewHolder;", "onToggle", "Lkotlin/Function1;", "", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "items", "", "Lru/mrlargha/commonui/elements/dialogs/DialogBankTaxPaymentInfo;", "selectedIds", "", "submitList", "newItems", "newSelectedIds", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "ViewHolder", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
final class DialogBankTaxPaymentAdapter extends RecyclerView.Adapter<ViewHolder> {
    private List<DialogBankTaxPaymentInfo> items;
    private final Function1<Integer, Unit> onToggle;
    private Set<Integer> selectedIds;

    /* JADX WARN: Multi-variable type inference failed */
    public DialogBankTaxPaymentAdapter(Function1<? super Integer, Unit> onToggle) {
        Intrinsics.checkNotNullParameter(onToggle, "onToggle");
        this.onToggle = onToggle;
        this.items = CollectionsKt.emptyList();
        this.selectedIds = SetsKt.emptySet();
    }

    public final void submitList(List<DialogBankTaxPaymentInfo> newItems, Set<Integer> newSelectedIds) {
        Intrinsics.checkNotNullParameter(newItems, "newItems");
        Intrinsics.checkNotNullParameter(newSelectedIds, "newSelectedIds");
        this.items = newItems;
        this.selectedIds = CollectionsKt.toSet(newSelectedIds);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        DialogBankTaxPaymentItemBinding inflate = DialogBankTaxPaymentItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new ViewHolder(inflate, this.onToggle);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        DialogBankTaxPaymentInfo dialogBankTaxPaymentInfo = this.items.get(i);
        holder.bind(dialogBankTaxPaymentInfo, this.selectedIds.contains(Integer.valueOf(dialogBankTaxPaymentInfo.getId())));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    /* compiled from: DialogBankTaxPayment.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/DialogBankTaxPaymentAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/commonui/databinding/DialogBankTaxPaymentItemBinding;", "onToggle", "Lkotlin/Function1;", "", "", "<init>", "(Lru/mrlargha/commonui/databinding/DialogBankTaxPaymentItemBinding;Lkotlin/jvm/functions/Function1;)V", "bind", "item", "Lru/mrlargha/commonui/elements/dialogs/DialogBankTaxPaymentInfo;", "selected", "", "Companion", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private static final Companion Companion = new Companion(null);
        private static final String EMPTY_CELL = "-";
        private static final String SELECTED_MARKER_BG = "#FFF000";
        private static final String SELECTED_ROW_BG = "#26FFFFFF";
        private static final String UNSELECTED_MARKER_BG = "#26FFFFFF";
        private static final String UNSELECTED_ROW_BG = "#12FFFFFF";
        private final DialogBankTaxPaymentItemBinding binding;
        private final Function1<Integer, Unit> onToggle;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public ViewHolder(DialogBankTaxPaymentItemBinding binding, Function1<? super Integer, Unit> onToggle) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            Intrinsics.checkNotNullParameter(onToggle, "onToggle");
            this.binding = binding;
            this.onToggle = onToggle;
        }

        public final void bind(final DialogBankTaxPaymentInfo item, boolean z) {
            Intrinsics.checkNotNullParameter(item, "item");
            DialogBankTaxPaymentItemBinding dialogBankTaxPaymentItemBinding = this.binding;
            dialogBankTaxPaymentItemBinding.bankTaxPaymentItemId.setText(String.valueOf(item.getId()));
            TextView textView = dialogBankTaxPaymentItemBinding.bankTaxPaymentItemName;
            ChatEmoji chatEmoji = ChatEmoji.INSTANCE;
            String name = item.getName();
            if (StringsKt.isBlank(name)) {
                name = "-";
            }
            textView.setText(ChatEmoji.toSpannable$default(chatEmoji, name, 0.0f, null, 3, null));
            dialogBankTaxPaymentItemBinding.bankTaxPaymentItemAmount.setText(DialogBankTaxPaymentKt.access$toDialogBankTaxPaymentMoneyText(item.getTax()));
            String str = "#26FFFFFF";
            dialogBankTaxPaymentItemBinding.bankTaxPaymentItem.setBackground(Color.parseColor(z ? "#26FFFFFF" : UNSELECTED_ROW_BG));
            CustomCardView customCardView = dialogBankTaxPaymentItemBinding.bankTaxPaymentItemMarker;
            if (z) {
                str = SELECTED_MARKER_BG;
            }
            customCardView.setBackground(Color.parseColor(str));
            ImageView bankTaxPaymentItemCheck = dialogBankTaxPaymentItemBinding.bankTaxPaymentItemCheck;
            Intrinsics.checkNotNullExpressionValue(bankTaxPaymentItemCheck, "bankTaxPaymentItemCheck");
            bankTaxPaymentItemCheck.setVisibility(z ? 0 : 8);
            dialogBankTaxPaymentItemBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dialogs.DialogBankTaxPaymentAdapter$ViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogBankTaxPaymentAdapter.ViewHolder.bind$lambda$0$1(DialogBankTaxPaymentAdapter.ViewHolder.this, item, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$0$1(ViewHolder viewHolder, DialogBankTaxPaymentInfo dialogBankTaxPaymentInfo, View view) {
            viewHolder.onToggle.invoke(Integer.valueOf(dialogBankTaxPaymentInfo.getId()));
        }

        /* compiled from: DialogBankTaxPayment.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/DialogBankTaxPaymentAdapter$ViewHolder$Companion;", "", "<init>", "()V", "EMPTY_CELL", "", "SELECTED_ROW_BG", "UNSELECTED_ROW_BG", "SELECTED_MARKER_BG", "UNSELECTED_MARKER_BG", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
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
