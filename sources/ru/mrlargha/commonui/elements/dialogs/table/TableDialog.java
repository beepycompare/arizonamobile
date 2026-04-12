package ru.mrlargha.commonui.elements.dialogs.table;

import android.app.Activity;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.databinding.TableDialogBinding;
import ru.mrlargha.commonui.elements.dialogs.AbstractDialog;
import ru.mrlargha.commonui.elements.dialogs.IAutocompleteStateProvider;
import ru.mrlargha.commonui.utils.ConverterKt;
/* compiled from: TableDialog.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aBS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\t\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0005¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\n \u0014*\u0004\u0018\u00010\u00130\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/table/TableDialog;", "Lru/mrlargha/commonui/elements/dialogs/AbstractDialog;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "caption", "Landroid/text/SpannableString;", "tableData", "", "Lru/mrlargha/commonui/elements/dialogs/table/TableCell;", "leftButtonText", "rightButtonText", "useFirstRowAsHeader", "", "sampDialogId", "<init>", "(Landroid/app/Activity;ILandroid/text/SpannableString;Ljava/util/List;Landroid/text/SpannableString;Landroid/text/SpannableString;ZI)V", "dialogLayout", "Landroid/view/View;", "kotlin.jvm.PlatformType", "binding", "Lru/mrlargha/commonui/databinding/TableDialogBinding;", "maxLengthInRow", "adapter", "Lru/mrlargha/commonui/elements/dialogs/table/DialogTableAdapter;", "Companion", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class TableDialog extends AbstractDialog {
    public static final Companion Companion = new Companion(null);
    private static final Map<Integer, Integer> savedRows = new LinkedHashMap();
    private final DialogTableAdapter adapter;
    private final TableDialogBinding binding;
    private final View dialogLayout;
    private int maxLengthInRow;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TableDialog(final Activity targetActivity, int i, SpannableString caption, List<? extends List<TableCell>> tableData, SpannableString leftButtonText, SpannableString rightButtonText, final boolean z, final int i2) {
        super(targetActivity, i, i2);
        Integer num;
        int intValue;
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        Intrinsics.checkNotNullParameter(caption, "caption");
        Intrinsics.checkNotNullParameter(tableData, "tableData");
        Intrinsics.checkNotNullParameter(leftButtonText, "leftButtonText");
        Intrinsics.checkNotNullParameter(rightButtonText, "rightButtonText");
        Activity activity = targetActivity;
        View dialogLayout = LayoutInflater.from(activity).inflate(R.layout.table_dialog, (ViewGroup) null, false);
        this.dialogLayout = dialogLayout;
        TableDialogBinding bind = TableDialogBinding.bind(dialogLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        this.adapter = new DialogTableAdapter(tableData, z, targetActivity, null, null, null, 56, null);
        Intrinsics.checkNotNullExpressionValue(dialogLayout, "dialogLayout");
        addViewToConstraintLayout(dialogLayout, -1, -1);
        if (tableData.size() > 7) {
            bind.recyclerView.getLayoutParams().height = ConverterKt.dpToPx(250, targetActivity);
        }
        if (!tableData.isEmpty() && ((List) CollectionsKt.first((List<? extends Object>) tableData)).size() == 1) {
            for (List<TableCell> list : tableData) {
                for (TableCell tableCell : list) {
                    if (this.maxLengthInRow < tableCell.getText().length()) {
                        this.maxLengthInRow = tableCell.getText().length();
                    }
                }
            }
            int dimension = (int) this.binding.getRoot().getContext().getResources().getDimension(R.dimen._290sdp);
            int i3 = this.maxLengthInRow;
            if (i3 <= 37) {
                int dpToPx = ConverterKt.dpToPx(200, targetActivity);
                bind.recyclerView.getLayoutParams().width = dimension <= dpToPx ? dpToPx : dimension;
            } else {
                int dpToPx2 = ConverterKt.dpToPx(i3 * 6, targetActivity);
                bind.recyclerView.getLayoutParams().width = dimension <= dpToPx2 ? dpToPx2 : dimension;
            }
        }
        bind.recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        bind.caption.setText(caption);
        bind.recyclerView.setAdapter(this.adapter);
        if (((IAutocompleteStateProvider) targetActivity).getAutocompleteState() && (num = savedRows.get(Integer.valueOf(i2))) != null && (intValue = num.intValue()) < this.adapter.getItemCount()) {
            this.adapter.setSelectedItemId(intValue);
            this.adapter.notifyItemChanged(intValue);
            bind.recyclerView.scrollToPosition(intValue);
        }
        setVisibility(true);
        SpannableString spannableString = leftButtonText;
        if (spannableString.length() == 0) {
            bind.buttons.button1.setVisibility(8);
        } else {
            bind.buttons.tvAccept.setText(spannableString);
            bind.buttons.button1.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dialogs.table.TableDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TableDialog.lambda$0$1(targetActivity, i2, this, z, view);
                }
            });
        }
        SpannableString spannableString2 = rightButtonText;
        if (spannableString2.length() == 0) {
            bind.buttons.button2.setVisibility(8);
        } else {
            bind.buttons.tvCancel.setText(spannableString2);
            bind.buttons.button2.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dialogs.table.TableDialog$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TableDialog.lambda$0$2(TableDialog.this, i2, z, view);
                }
            });
        }
        bind.btnCancel.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dialogs.table.TableDialog$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TableDialog.lambda$0$3(TableDialog.this, i2, z, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$0$1(Activity activity, int i, TableDialog tableDialog, boolean z, View view) {
        int selectedItemId;
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.dialogs.IAutocompleteStateProvider");
        if (((IAutocompleteStateProvider) activity).getAutocompleteState()) {
            savedRows.put(Integer.valueOf(i), Integer.valueOf(tableDialog.adapter.getSelectedItemId()));
        }
        IBackendNotifier notifier = tableDialog.getNotifier();
        if (tableDialog.adapter.getSelectedItemId() > -1 && z) {
            selectedItemId = tableDialog.adapter.getSelectedItemId() - 1;
        } else {
            selectedItemId = tableDialog.adapter.getSelectedItemId();
        }
        byte[] bytes = tableDialog.adapter.getSelectedRowText().getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        notifier.onDialogResponseWrapper(i, 1, selectedItemId, bytes);
        tableDialog.getNotifier().destroyDialog();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$0$2(TableDialog tableDialog, int i, boolean z, View view) {
        int selectedItemId;
        IBackendNotifier notifier = tableDialog.getNotifier();
        if (tableDialog.adapter.getSelectedItemId() > -1 && z) {
            selectedItemId = tableDialog.adapter.getSelectedItemId() - 1;
        } else {
            selectedItemId = tableDialog.adapter.getSelectedItemId();
        }
        byte[] bytes = tableDialog.adapter.getSelectedRowText().getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        notifier.onDialogResponseWrapper(i, 0, selectedItemId, bytes);
        tableDialog.getNotifier().destroyDialog();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$0$3(TableDialog tableDialog, int i, boolean z, View view) {
        int selectedItemId;
        IBackendNotifier notifier = tableDialog.getNotifier();
        if (tableDialog.adapter.getSelectedItemId() > -1 && z) {
            selectedItemId = tableDialog.adapter.getSelectedItemId() - 1;
        } else {
            selectedItemId = tableDialog.adapter.getSelectedItemId();
        }
        byte[] bytes = tableDialog.adapter.getSelectedRowText().getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        notifier.onDialogResponseWrapper(i, 0, selectedItemId, bytes);
        tableDialog.getNotifier().destroyDialog();
    }

    /* compiled from: TableDialog.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/table/TableDialog$Companion;", "", "<init>", "()V", "savedRows", "", "", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
