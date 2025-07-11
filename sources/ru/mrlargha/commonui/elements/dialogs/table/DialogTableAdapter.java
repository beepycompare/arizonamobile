package ru.mrlargha.commonui.elements.dialogs.table;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewGroupKt;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.elements.dialogs.table.DialogTableAdapter;
import ru.mrlargha.commonui.utils.ConverterKt;
/* compiled from: DialogTableAdapter.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"Bg\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004\u0012\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00070\r¢\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u0017\u001a\u00020\u0018J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000eH\u0016J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u000eH\u0016J\b\u0010!\u001a\u00020\u000eH\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00070\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/table/DialogTableAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/commonui/elements/dialogs/table/DialogTableAdapter$DialogRowViewHolder;", "rows", "", "Lru/mrlargha/commonui/elements/dialogs/table/TableCell;", "useFirstRowAsHeader", "", "targetActivity", "Landroid/app/Activity;", "weightsFormula", "", "maxLengthInRow", "", "", "needNewColumn", "<init>", "(Ljava/util/List;ZLandroid/app/Activity;Ljava/util/List;Ljava/util/Map;Ljava/util/Map;)V", "selectedItemId", "getSelectedItemId", "()I", "setSelectedItemId", "(I)V", "getSelectedRowText", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "getItemCount", "DialogRowViewHolder", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DialogTableAdapter extends RecyclerView.Adapter<DialogRowViewHolder> {
    private Map<Integer, Integer> maxLengthInRow;
    private Map<Integer, Boolean> needNewColumn;
    private List<? extends List<TableCell>> rows;
    private int selectedItemId;
    private final Activity targetActivity;
    private final boolean useFirstRowAsHeader;
    private final List<Float> weightsFormula;

    public /* synthetic */ DialogTableAdapter(List list, boolean z, Activity activity, List list2, LinkedHashMap linkedHashMap, LinkedHashMap linkedHashMap2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, z, activity, (i & 8) != 0 ? CollectionsKt.listOf(Float.valueOf(1.0f)) : list2, (i & 16) != 0 ? new LinkedHashMap() : linkedHashMap, (i & 32) != 0 ? new LinkedHashMap() : linkedHashMap2);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DialogTableAdapter(List<? extends List<TableCell>> rows, boolean z, Activity targetActivity, List<Float> weightsFormula, Map<Integer, Integer> maxLengthInRow, Map<Integer, Boolean> needNewColumn) {
        Intrinsics.checkNotNullParameter(rows, "rows");
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        Intrinsics.checkNotNullParameter(weightsFormula, "weightsFormula");
        Intrinsics.checkNotNullParameter(maxLengthInRow, "maxLengthInRow");
        Intrinsics.checkNotNullParameter(needNewColumn, "needNewColumn");
        this.rows = rows;
        this.useFirstRowAsHeader = z;
        this.targetActivity = targetActivity;
        this.weightsFormula = weightsFormula;
        this.maxLengthInRow = maxLengthInRow;
        this.needNewColumn = needNewColumn;
        this.selectedItemId = -1;
        List list = (List) CollectionsKt.firstOrNull((List<? extends Object>) rows);
        Integer valueOf = list != null ? Integer.valueOf(list.size()) : null;
        for (List<TableCell> list2 : this.rows) {
            int size = list2.size();
            if (valueOf == null || size != valueOf.intValue()) {
                throw new IllegalArgumentException("Incorrect table dimension");
            }
            while (r7.hasNext()) {
            }
        }
        if (this.useFirstRowAsHeader && this.rows.size() >= 2) {
            this.selectedItemId = 1;
        } else if (!this.rows.isEmpty()) {
            this.selectedItemId = 0;
        }
        this.maxLengthInRow = new LinkedHashMap();
        ArrayList<List> arrayList = new ArrayList();
        for (List<TableCell> list3 : this.rows) {
            int i = 0;
            for (TableCell tableCell : list3) {
                int i2 = i + 1;
                if (tableCell.getText().length() > 0) {
                    this.needNewColumn.put(Integer.valueOf(i), true);
                }
                i = i2;
            }
        }
        for (List<TableCell> list4 : this.rows) {
            ArrayList arrayList2 = new ArrayList();
            int i3 = 0;
            for (TableCell tableCell2 : list4) {
                int i4 = i3 + 1;
                if (this.needNewColumn.get(Integer.valueOf(i3)) != null && Intrinsics.areEqual((Object) this.needNewColumn.get(Integer.valueOf(i3)), (Object) true)) {
                    arrayList2.add(tableCell2);
                }
                i3 = i4;
            }
            if (!arrayList2.isEmpty()) {
                arrayList.add(arrayList2);
            }
        }
        for (List<TableCell> list5 : arrayList) {
            int i5 = 0;
            for (TableCell tableCell3 : list5) {
                int i6 = i5 + 1;
                if (this.maxLengthInRow.get(Integer.valueOf(i5)) != null) {
                    Integer num = this.maxLengthInRow.get(Integer.valueOf(i5));
                    Intrinsics.checkNotNull(num);
                    if (num.intValue() < tableCell3.getText().length()) {
                        this.maxLengthInRow.put(Integer.valueOf(i5), Integer.valueOf(tableCell3.getText().length()));
                    }
                } else {
                    this.maxLengthInRow.put(Integer.valueOf(i5), Integer.valueOf(tableCell3.getText().length()));
                }
                i5 = i6;
            }
        }
        this.rows = arrayList;
    }

    public final int getSelectedItemId() {
        return this.selectedItemId;
    }

    public final void setSelectedItemId(int i) {
        this.selectedItemId = i;
    }

    public final String getSelectedRowText() {
        int i = this.selectedItemId;
        if (i == -1) {
            return "";
        }
        try {
            return CollectionsKt.joinToString$default(this.rows.get(i), "\t", null, null, 0, null, new Function1() { // from class: ru.mrlargha.commonui.elements.dialogs.table.DialogTableAdapter$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    CharSequence selectedRowText$lambda$0;
                    selectedRowText$lambda$0 = DialogTableAdapter.getSelectedRowText$lambda$0((TableCell) obj);
                    return selectedRowText$lambda$0;
                }
            }, 30, null);
        } catch (ArrayIndexOutOfBoundsException unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence getSelectedRowText$lambda$0(TableCell it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getText();
    }

    /* compiled from: DialogTableAdapter.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\u001c\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/table/DialogTableAdapter$DialogRowViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "adapter", "Lru/mrlargha/commonui/elements/dialogs/table/DialogTableAdapter;", "<init>", "(Landroid/view/View;Lru/mrlargha/commonui/elements/dialogs/table/DialogTableAdapter;)V", "getAdapter", "()Lru/mrlargha/commonui/elements/dialogs/table/DialogTableAdapter;", TtmlNode.TAG_LAYOUT, "Landroid/widget/LinearLayout;", "getLayout", "()Landroid/widget/LinearLayout;", "bind", "", "cells", "", "Lru/mrlargha/commonui/elements/dialogs/table/TableCell;", "createCells", "amount", "", "weightsFormula", "", "Companion", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DialogRowViewHolder extends RecyclerView.ViewHolder {
        public static final Companion Companion = new Companion(null);
        private final DialogTableAdapter adapter;
        private final LinearLayout layout;

        public final DialogTableAdapter getAdapter() {
            return this.adapter;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DialogRowViewHolder(final View itemView, DialogTableAdapter adapter) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Intrinsics.checkNotNullParameter(adapter, "adapter");
            this.adapter = adapter;
            LinearLayout linearLayout = (LinearLayout) itemView;
            this.layout = linearLayout;
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dialogs.table.DialogTableAdapter$DialogRowViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogTableAdapter.DialogRowViewHolder._init_$lambda$1(DialogTableAdapter.DialogRowViewHolder.this, itemView, view);
                }
            });
        }

        public final LinearLayout getLayout() {
            return this.layout;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void _init_$lambda$1(DialogRowViewHolder dialogRowViewHolder, View view, View view2) {
            if (dialogRowViewHolder.adapter.useFirstRowAsHeader && dialogRowViewHolder.getAdapterPosition() == 0) {
                return;
            }
            int selectedItemId = dialogRowViewHolder.adapter.getSelectedItemId();
            dialogRowViewHolder.adapter.setSelectedItemId(dialogRowViewHolder.getAdapterPosition());
            dialogRowViewHolder.adapter.notifyItemChanged(selectedItemId);
            view2.setBackground(ResourcesCompat.getDrawable(view.getResources(), R.drawable.dialog_item_pressed_bg, view.getContext().getTheme()));
        }

        public final void bind(List<TableCell> cells) {
            Intrinsics.checkNotNullParameter(cells, "cells");
            int i = 0;
            for (View view : ViewGroupKt.getChildren(this.layout)) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                View view2 = view;
                if (this.adapter.useFirstRowAsHeader && getAdapterPosition() == 0) {
                    Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type android.widget.TextView");
                    ((TextView) view2).setText(cells.get(i).getText().toString());
                    if (this.layout.getBackground() != null) {
                        this.layout.setBackground(null);
                    }
                } else {
                    Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type android.widget.TextView");
                    ((TextView) view2).setText(cells.get(i).getText());
                    this.layout.setBackground(ResourcesCompat.getDrawable(this.itemView.getResources(), R.drawable.dialog_item_bg, this.itemView.getContext().getTheme()));
                }
                i = i2;
            }
            if (this.adapter.useFirstRowAsHeader && getAdapterPosition() == 0) {
                for (View view3 : ViewGroupKt.getChildren(this.layout)) {
                    Intrinsics.checkNotNull(view3, "null cannot be cast to non-null type android.widget.TextView");
                    ((TextView) view3).setTextColor(Color.parseColor("#b3b3b3"));
                }
            }
            if (this.adapter.getSelectedItemId() == getAdapterPosition()) {
                this.layout.setBackground(ResourcesCompat.getDrawable(this.itemView.getResources(), R.drawable.dialog_item_pressed_bg, this.itemView.getContext().getTheme()));
            }
        }

        public final void createCells(int i, List<Float> weightsFormula) {
            Object obj;
            Intrinsics.checkNotNullParameter(weightsFormula, "weightsFormula");
            for (int i2 = 0; i2 < i; i2++) {
                TextView textView = new TextView(this.itemView.getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, weightsFormula.get(i2 % weightsFormula.size()).floatValue());
                Intrinsics.checkNotNull(this.adapter.maxLengthInRow.get(Integer.valueOf(i2)));
                layoutParams.width = ConverterKt.dpToPx(((Number) obj).intValue() * 5.7f, this.adapter.targetActivity);
                layoutParams.gravity = GravityCompat.START;
                if (i2 == 0) {
                    layoutParams.setMarginStart(0);
                } else if (i2 == i - 1) {
                    layoutParams.setMarginStart(ConverterKt.dpToPx(7, this.adapter.targetActivity));
                } else {
                    layoutParams.setMarginStart(ConverterKt.dpToPx(7, this.adapter.targetActivity));
                }
                textView.setLayoutParams(layoutParams);
                textView.setTextAlignment(5);
                textView.setSingleLine();
                textView.setTextColor(-1);
                textView.setTextSize(1, 9.0f);
                this.layout.addView(textView);
            }
        }

        /* compiled from: DialogTableAdapter.kt */
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/table/DialogTableAdapter$DialogRowViewHolder$Companion;", "", "<init>", "()V", "from", "Lru/mrlargha/commonui/elements/dialogs/table/DialogTableAdapter$DialogRowViewHolder;", "parent", "Landroid/view/ViewGroup;", "adapter", "Lru/mrlargha/commonui/elements/dialogs/table/DialogTableAdapter;", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final DialogRowViewHolder from(ViewGroup parent, DialogTableAdapter adapter) {
                Intrinsics.checkNotNullParameter(parent, "parent");
                Intrinsics.checkNotNullParameter(adapter, "adapter");
                View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.table_row, parent, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
                return new DialogRowViewHolder(inflate, adapter);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public DialogRowViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        DialogRowViewHolder from = DialogRowViewHolder.Companion.from(parent, this);
        List list = (List) CollectionsKt.firstOrNull((List<? extends Object>) this.rows);
        from.createCells(list != null ? list.size() : 0, this.weightsFormula);
        return from;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(DialogRowViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.rows.get(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.rows.size();
    }
}
