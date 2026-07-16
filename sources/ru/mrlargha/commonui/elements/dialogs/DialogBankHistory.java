package ru.mrlargha.commonui.elements.dialogs;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.databinding.DialogBankHistoryBinding;
import ru.mrlargha.commonui.utils.emoji.ChatEmoji;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* compiled from: DialogBankHistory.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 02\u00020\u0001:\u00010BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010!\u001a\u00020\u000eJ\u0010\u0010\"\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010#\u001a\u00020\u000eH\u0002J \u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020\u000eH\u0002J \u0010+\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010,\u001a\u00020\u000bH\u0002J\b\u0010-\u001a\u00020\u000eH\u0002J\u0010\u0010.\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\u000bH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/DialogBankHistory;", "Lru/mrlargha/commonui/elements/dialogs/AbstractDialog;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "caption", "", "infoData", "sampDialogId", "sendCloseResponse", "", "onClosed", "Lkotlin/Function0;", "", "<init>", "(Landroid/app/Activity;ILjava/lang/String;Ljava/lang/String;IZLkotlin/jvm/functions/Function0;)V", "dialogLayout", "Landroid/view/View;", "binding", "Lru/mrlargha/commonui/databinding/DialogBankHistoryBinding;", "payload", "Lru/mrlargha/commonui/elements/dialogs/DialogBankHistoryModel;", "adapter", "Lru/mrlargha/commonui/elements/dialogs/DialogBankHistoryAdapter;", "rows", "", "Lru/mrlargha/commonui/elements/dialogs/DialogBankHistoryRow;", "selectedTab", "Lru/mrlargha/commonui/elements/dialogs/DialogBankHistoryTab;", "allowedTabs", "", "isClosed", "closeSilently", TtmlNode.TEXT_EMPHASIS_MARK_OPEN, "setupUi", "bindTab", "tab", "card", "Lru/mrlargha/commonui/utils/ui/CustomCardView;", "text", "Landroid/widget/TextView;", "renderTabs", "updateTab", "isSelected", "renderRows", "dismiss", "sendResponse", "Companion", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DialogBankHistory extends AbstractDialog {
    private static final Companion Companion = new Companion(null);
    private static final String SELECTED_TAB_BG = "#FFFFFF";
    private static final String SELECTED_TAB_TEXT = "#2E3646";
    private static final String UNSELECTED_TAB_BG = "#00FFFFFF";
    private static final String UNSELECTED_TAB_TEXT = "#FFFFFF";
    private final DialogBankHistoryAdapter adapter;
    private Set<? extends DialogBankHistoryTab> allowedTabs;
    private final DialogBankHistoryBinding binding;
    private final View dialogLayout;
    private boolean isClosed;
    private final Function0<Unit> onClosed;
    private final DialogBankHistoryModel payload;
    private List<DialogBankHistoryRow> rows;
    private DialogBankHistoryTab selectedTab;
    private final boolean sendCloseResponse;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void _init_$lambda$0(View view) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogBankHistory(Activity targetActivity, int i, String caption, String infoData, int i2, boolean z, Function0<Unit> function0) {
        super(targetActivity, i, i2);
        DialogBankHistoryModel buildPayload;
        Set<? extends DialogBankHistoryTab> resolveAllowedTabs;
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        Intrinsics.checkNotNullParameter(caption, "caption");
        Intrinsics.checkNotNullParameter(infoData, "infoData");
        this.sendCloseResponse = z;
        this.onClosed = function0;
        View inflate = LayoutInflater.from(targetActivity).inflate(R.layout.dialog_bank_history, (ViewGroup) null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.dialogLayout = inflate;
        DialogBankHistoryBinding bind = DialogBankHistoryBinding.bind(inflate);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        buildPayload = DialogBankHistoryKt.buildPayload(caption, infoData);
        this.payload = buildPayload;
        this.adapter = new DialogBankHistoryAdapter();
        this.rows = CollectionsKt.emptyList();
        this.selectedTab = DialogBankHistoryTab.ALL;
        resolveAllowedTabs = DialogBankHistoryKt.resolveAllowedTabs(buildPayload.getAddType());
        this.allowedTabs = resolveAllowedTabs;
        addViewToConstraintLayout(inflate, -1, -1);
        setPosition(SAMPUIElement.PositionType.CENTER, 0, 0);
        setupUi();
        open(buildPayload);
        setVisibility(true);
        bind.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dialogs.DialogBankHistory$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogBankHistory._init_$lambda$0(view);
            }
        });
    }

    public /* synthetic */ DialogBankHistory(Activity activity, int i, String str, String str2, int i2, boolean z, Function0 function0, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity, i, str, str2, i2, (i3 & 32) != 0 ? true : z, (i3 & 64) != 0 ? null : function0);
    }

    public final void closeSilently() {
        dismiss(false);
    }

    private final void open(DialogBankHistoryModel dialogBankHistoryModel) {
        List<DialogBankHistoryRow> parseRows;
        Set<? extends DialogBankHistoryTab> resolveAllowedTabs;
        TextView textView = this.binding.dialogBankHistoryTitle;
        ChatEmoji chatEmoji = ChatEmoji.INSTANCE;
        String header = dialogBankHistoryModel.getHeader();
        if (StringsKt.isBlank(header)) {
            header = getTargetActivity().getString(R.string.dialog_bank_history_title);
            Intrinsics.checkNotNullExpressionValue(header, "getString(...)");
        }
        textView.setText(ChatEmoji.toSpannable$default(chatEmoji, header, 0.0f, null, 3, null));
        parseRows = DialogBankHistoryKt.parseRows(dialogBankHistoryModel.getBody());
        this.rows = parseRows;
        this.selectedTab = DialogBankHistoryTab.ALL;
        resolveAllowedTabs = DialogBankHistoryKt.resolveAllowedTabs(dialogBankHistoryModel.getAddType());
        this.allowedTabs = resolveAllowedTabs;
        renderTabs();
        renderRows();
    }

    private final void setupUi() {
        DialogBankHistoryBinding dialogBankHistoryBinding = this.binding;
        dialogBankHistoryBinding.dialogBankHistoryList.setLayoutManager(new LinearLayoutManager(getTargetActivity()));
        dialogBankHistoryBinding.dialogBankHistoryList.setAdapter(this.adapter);
        dialogBankHistoryBinding.dialogBankHistoryList.setItemAnimator(null);
        dialogBankHistoryBinding.dialogBankHistoryClose.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dialogs.DialogBankHistory$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogBankHistory.setupUi$lambda$0$0(DialogBankHistory.this, view);
            }
        });
        DialogBankHistoryTab dialogBankHistoryTab = DialogBankHistoryTab.ALL;
        CustomCardView dialogBankHistoryTabAll = dialogBankHistoryBinding.dialogBankHistoryTabAll;
        Intrinsics.checkNotNullExpressionValue(dialogBankHistoryTabAll, "dialogBankHistoryTabAll");
        TextView dialogBankHistoryTabAllText = dialogBankHistoryBinding.dialogBankHistoryTabAllText;
        Intrinsics.checkNotNullExpressionValue(dialogBankHistoryTabAllText, "dialogBankHistoryTabAllText");
        bindTab(dialogBankHistoryTab, dialogBankHistoryTabAll, dialogBankHistoryTabAllText);
        DialogBankHistoryTab dialogBankHistoryTab2 = DialogBankHistoryTab.DEPOSIT;
        CustomCardView dialogBankHistoryTabDeposit = dialogBankHistoryBinding.dialogBankHistoryTabDeposit;
        Intrinsics.checkNotNullExpressionValue(dialogBankHistoryTabDeposit, "dialogBankHistoryTabDeposit");
        TextView dialogBankHistoryTabDepositText = dialogBankHistoryBinding.dialogBankHistoryTabDepositText;
        Intrinsics.checkNotNullExpressionValue(dialogBankHistoryTabDepositText, "dialogBankHistoryTabDepositText");
        bindTab(dialogBankHistoryTab2, dialogBankHistoryTabDeposit, dialogBankHistoryTabDepositText);
        DialogBankHistoryTab dialogBankHistoryTab3 = DialogBankHistoryTab.TRANSFER;
        CustomCardView dialogBankHistoryTabTransfer = dialogBankHistoryBinding.dialogBankHistoryTabTransfer;
        Intrinsics.checkNotNullExpressionValue(dialogBankHistoryTabTransfer, "dialogBankHistoryTabTransfer");
        TextView dialogBankHistoryTabTransferText = dialogBankHistoryBinding.dialogBankHistoryTabTransferText;
        Intrinsics.checkNotNullExpressionValue(dialogBankHistoryTabTransferText, "dialogBankHistoryTabTransferText");
        bindTab(dialogBankHistoryTab3, dialogBankHistoryTabTransfer, dialogBankHistoryTabTransferText);
        DialogBankHistoryTab dialogBankHistoryTab4 = DialogBankHistoryTab.WITHDRAW;
        CustomCardView dialogBankHistoryTabWithdraw = dialogBankHistoryBinding.dialogBankHistoryTabWithdraw;
        Intrinsics.checkNotNullExpressionValue(dialogBankHistoryTabWithdraw, "dialogBankHistoryTabWithdraw");
        TextView dialogBankHistoryTabWithdrawText = dialogBankHistoryBinding.dialogBankHistoryTabWithdrawText;
        Intrinsics.checkNotNullExpressionValue(dialogBankHistoryTabWithdrawText, "dialogBankHistoryTabWithdrawText");
        bindTab(dialogBankHistoryTab4, dialogBankHistoryTabWithdraw, dialogBankHistoryTabWithdrawText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupUi$lambda$0$0(DialogBankHistory dialogBankHistory, View view) {
        dialogBankHistory.dismiss(dialogBankHistory.sendCloseResponse);
    }

    private final void bindTab(final DialogBankHistoryTab dialogBankHistoryTab, CustomCardView customCardView, TextView textView) {
        customCardView.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dialogs.DialogBankHistory$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogBankHistory.bindTab$lambda$0(DialogBankHistory.this, dialogBankHistoryTab, view);
            }
        });
        updateTab(customCardView, textView, dialogBankHistoryTab == this.selectedTab);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void bindTab$lambda$0(DialogBankHistory dialogBankHistory, DialogBankHistoryTab dialogBankHistoryTab, View view) {
        dialogBankHistory.selectedTab = dialogBankHistoryTab;
        dialogBankHistory.renderTabs();
        dialogBankHistory.renderRows();
    }

    private final void renderTabs() {
        DialogBankHistoryBinding dialogBankHistoryBinding = this.binding;
        CustomCardView dialogBankHistoryTabDeposit = dialogBankHistoryBinding.dialogBankHistoryTabDeposit;
        Intrinsics.checkNotNullExpressionValue(dialogBankHistoryTabDeposit, "dialogBankHistoryTabDeposit");
        dialogBankHistoryTabDeposit.setVisibility(this.allowedTabs.contains(DialogBankHistoryTab.DEPOSIT) ? 0 : 8);
        CustomCardView dialogBankHistoryTabTransfer = dialogBankHistoryBinding.dialogBankHistoryTabTransfer;
        Intrinsics.checkNotNullExpressionValue(dialogBankHistoryTabTransfer, "dialogBankHistoryTabTransfer");
        dialogBankHistoryTabTransfer.setVisibility(this.allowedTabs.contains(DialogBankHistoryTab.TRANSFER) ? 0 : 8);
        CustomCardView dialogBankHistoryTabWithdraw = dialogBankHistoryBinding.dialogBankHistoryTabWithdraw;
        Intrinsics.checkNotNullExpressionValue(dialogBankHistoryTabWithdraw, "dialogBankHistoryTabWithdraw");
        dialogBankHistoryTabWithdraw.setVisibility(this.allowedTabs.contains(DialogBankHistoryTab.WITHDRAW) ? 0 : 8);
        CustomCardView dialogBankHistoryTabAll = dialogBankHistoryBinding.dialogBankHistoryTabAll;
        Intrinsics.checkNotNullExpressionValue(dialogBankHistoryTabAll, "dialogBankHistoryTabAll");
        TextView dialogBankHistoryTabAllText = dialogBankHistoryBinding.dialogBankHistoryTabAllText;
        Intrinsics.checkNotNullExpressionValue(dialogBankHistoryTabAllText, "dialogBankHistoryTabAllText");
        updateTab(dialogBankHistoryTabAll, dialogBankHistoryTabAllText, this.selectedTab == DialogBankHistoryTab.ALL);
        CustomCardView dialogBankHistoryTabDeposit2 = dialogBankHistoryBinding.dialogBankHistoryTabDeposit;
        Intrinsics.checkNotNullExpressionValue(dialogBankHistoryTabDeposit2, "dialogBankHistoryTabDeposit");
        TextView dialogBankHistoryTabDepositText = dialogBankHistoryBinding.dialogBankHistoryTabDepositText;
        Intrinsics.checkNotNullExpressionValue(dialogBankHistoryTabDepositText, "dialogBankHistoryTabDepositText");
        updateTab(dialogBankHistoryTabDeposit2, dialogBankHistoryTabDepositText, this.selectedTab == DialogBankHistoryTab.DEPOSIT);
        CustomCardView dialogBankHistoryTabTransfer2 = dialogBankHistoryBinding.dialogBankHistoryTabTransfer;
        Intrinsics.checkNotNullExpressionValue(dialogBankHistoryTabTransfer2, "dialogBankHistoryTabTransfer");
        TextView dialogBankHistoryTabTransferText = dialogBankHistoryBinding.dialogBankHistoryTabTransferText;
        Intrinsics.checkNotNullExpressionValue(dialogBankHistoryTabTransferText, "dialogBankHistoryTabTransferText");
        updateTab(dialogBankHistoryTabTransfer2, dialogBankHistoryTabTransferText, this.selectedTab == DialogBankHistoryTab.TRANSFER);
        CustomCardView dialogBankHistoryTabWithdraw2 = dialogBankHistoryBinding.dialogBankHistoryTabWithdraw;
        Intrinsics.checkNotNullExpressionValue(dialogBankHistoryTabWithdraw2, "dialogBankHistoryTabWithdraw");
        TextView dialogBankHistoryTabWithdrawText = dialogBankHistoryBinding.dialogBankHistoryTabWithdrawText;
        Intrinsics.checkNotNullExpressionValue(dialogBankHistoryTabWithdrawText, "dialogBankHistoryTabWithdrawText");
        updateTab(dialogBankHistoryTabWithdraw2, dialogBankHistoryTabWithdrawText, this.selectedTab == DialogBankHistoryTab.WITHDRAW);
    }

    private final void updateTab(CustomCardView customCardView, TextView textView, boolean z) {
        String str = "#FFFFFF";
        customCardView.setBackground(Color.parseColor(z ? "#FFFFFF" : UNSELECTED_TAB_BG));
        if (z) {
            str = SELECTED_TAB_TEXT;
        }
        textView.setTextColor(Color.parseColor(str));
    }

    private final void renderRows() {
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.rows) {
            DialogBankHistoryRow dialogBankHistoryRow = (DialogBankHistoryRow) obj;
            if (this.selectedTab == DialogBankHistoryTab.ALL || this.selectedTab.getOperationTypes().contains(Integer.valueOf(dialogBankHistoryRow.getOperationType()))) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        this.adapter.submitList(arrayList2);
        TextView dialogBankHistoryEmpty = this.binding.dialogBankHistoryEmpty;
        Intrinsics.checkNotNullExpressionValue(dialogBankHistoryEmpty, "dialogBankHistoryEmpty");
        dialogBankHistoryEmpty.setVisibility(arrayList2.isEmpty() ? 0 : 8);
        RecyclerView dialogBankHistoryList = this.binding.dialogBankHistoryList;
        Intrinsics.checkNotNullExpressionValue(dialogBankHistoryList, "dialogBankHistoryList");
        dialogBankHistoryList.setVisibility(arrayList2.isEmpty() ? 8 : 0);
    }

    private final void dismiss(boolean z) {
        if (this.isClosed) {
            return;
        }
        this.isClosed = true;
        if (z) {
            getNotifier().onDialogResponseWrapper(getSampDialogId(), 0, -1, new byte[0]);
            getNotifier().destroyDialog();
        } else {
            removeFromLayout();
        }
        Function0<Unit> function0 = this.onClosed;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* compiled from: DialogBankHistory.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/DialogBankHistory$Companion;", "", "<init>", "()V", "SELECTED_TAB_BG", "", "UNSELECTED_TAB_BG", "SELECTED_TAB_TEXT", "UNSELECTED_TAB_TEXT", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
