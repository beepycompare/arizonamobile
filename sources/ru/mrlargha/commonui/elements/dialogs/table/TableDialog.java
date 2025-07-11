package ru.mrlargha.commonui.elements.dialogs.table;

import android.app.Activity;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
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
import ru.mrlargha.commonui.elements.dialogs.AbstractDialog;
import ru.mrlargha.commonui.elements.dialogs.IAutocompleteStateProvider;
import ru.mrlargha.commonui.utils.ConverterKt;
/* compiled from: TableDialog.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eBS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\t\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0005¢\u0006\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/table/TableDialog;", "Lru/mrlargha/commonui/elements/dialogs/AbstractDialog;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "caption", "Landroid/text/SpannableString;", "tableData", "", "Lru/mrlargha/commonui/elements/dialogs/table/TableCell;", "leftButtonText", "rightButtonText", "useFirstRowAsHeader", "", "sampDialogId", "<init>", "(Landroid/app/Activity;ILandroid/text/SpannableString;Ljava/util/List;Landroid/text/SpannableString;Landroid/text/SpannableString;ZI)V", "dialogLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "captionTextView", "Landroid/widget/TextView;", "button1", "Landroid/widget/Button;", "button2", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "maxLengthInRow", "adapter", "Lru/mrlargha/commonui/elements/dialogs/table/DialogTableAdapter;", "Companion", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TableDialog extends AbstractDialog {
    public static final Companion Companion = new Companion(null);
    private static final Map<Integer, Integer> savedRows = new LinkedHashMap();
    private final DialogTableAdapter adapter;
    private final Button button1;
    private final Button button2;
    private final TextView captionTextView;
    private final ConstraintLayout dialogLayout;
    private int maxLengthInRow;
    private final RecyclerView recyclerView;

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
        View inflate = LayoutInflater.from(activity).inflate(R.layout.table_dialog, (ViewGroup) null, false);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.dialogLayout = constraintLayout;
        View findViewById = constraintLayout.findViewById(R.id.caption);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.captionTextView = (TextView) findViewById;
        View findViewById2 = constraintLayout.findViewById(R.id.button1);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.button1 = (Button) findViewById2;
        View findViewById3 = constraintLayout.findViewById(R.id.button2);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.button2 = (Button) findViewById3;
        View findViewById4 = constraintLayout.findViewById(R.id.recyclerView);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        RecyclerView recyclerView = (RecyclerView) findViewById4;
        this.recyclerView = recyclerView;
        this.adapter = new DialogTableAdapter(tableData, z, targetActivity, null, null, null, 56, null);
        addViewToConstraintLayout(constraintLayout, -1, -1);
        if (tableData.size() > 7) {
            recyclerView.getLayoutParams().height = ConverterKt.dpToPx((int) ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, targetActivity);
        }
        if (!tableData.isEmpty() && ((List) CollectionsKt.first((List<? extends Object>) tableData)).size() == 1) {
            for (List<TableCell> list : tableData) {
                for (TableCell tableCell : list) {
                    if (this.maxLengthInRow < tableCell.getText().length()) {
                        this.maxLengthInRow = tableCell.getText().length();
                    }
                }
            }
            if (this.maxLengthInRow <= 37) {
                this.recyclerView.getLayoutParams().width = ConverterKt.dpToPx(200, targetActivity);
            } else {
                this.recyclerView.getLayoutParams().width = ConverterKt.dpToPx(this.maxLengthInRow * 6, targetActivity);
            }
        }
        this.recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        this.captionTextView.setText(caption);
        this.recyclerView.setAdapter(this.adapter);
        if (((IAutocompleteStateProvider) targetActivity).getAutocompleteState() && (num = savedRows.get(Integer.valueOf(i2))) != null && (intValue = num.intValue()) < this.adapter.getItemCount()) {
            this.adapter.setSelectedItemId(intValue);
            this.adapter.notifyItemChanged(intValue);
            this.recyclerView.scrollToPosition(intValue);
        }
        setVisibility(true);
        SpannableString spannableString = leftButtonText;
        if (spannableString.length() == 0) {
            this.button1.setVisibility(8);
        } else {
            this.button1.setText(spannableString);
            this.button1.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dialogs.table.TableDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TableDialog._init_$lambda$1(targetActivity, i2, this, z, view);
                }
            });
        }
        SpannableString spannableString2 = rightButtonText;
        if (spannableString2.length() == 0) {
            this.button2.setVisibility(8);
            return;
        }
        this.button2.setText(spannableString2);
        this.button2.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dialogs.table.TableDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TableDialog._init_$lambda$2(TableDialog.this, i2, z, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(Activity activity, int i, TableDialog tableDialog, boolean z, View view) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$2(TableDialog tableDialog, int i, boolean z, View view) {
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
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/table/TableDialog$Companion;", "", "<init>", "()V", "savedRows", "", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
