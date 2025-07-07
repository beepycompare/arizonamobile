package ru.mrlargha.commonui.elements.inventory.presentation.dialog;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.databinding.SelectorDialogBinding;
import ru.mrlargha.commonui.elements.inventory.domain.models.InventoryItem;
import ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen;
import ru.mrlargha.commonui.utils.ActionTypes;
import ru.mrlargha.commonui.utils.ConstantsKt;
import ru.mrlargha.commonui.utils.ItemsInfo;
import ru.mrlargha.commonui.utils.StringKt;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: SelectorDialog.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0016\u0010\u001b\u001a\u00020\u00182\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u001dH\u0002J \u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lru/mrlargha/commonui/elements/inventory/presentation/dialog/SelectorDialog;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "item", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "guardId", "<init>", "(Landroid/app/Activity;ILru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;I)V", "selectorDialog", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getSelectorDialog", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "binding", "Lru/mrlargha/commonui/databinding/SelectorDialogBinding;", "firstBits", "secondBits", "thirdBits", "fourthBits", "fifthBits", "sixthBits", "closeDialog", "", "twoTypeCode", "bits", "setItemVisibility", "list", "", "sendData", "defineText", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SelectorDialog extends SAMPUIElement {
    private final SelectorDialogBinding binding;
    private int fifthBits;
    private int firstBits;
    private int fourthBits;
    private int secondBits;
    private final ConstraintLayout selectorDialog;
    private int sixthBits;
    private int thirdBits;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectorDialog(Activity targetActivity, int i, final InventoryItem item, final int i2) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        Intrinsics.checkNotNullParameter(item, "item");
        View inflate = LayoutInflater.from(targetActivity).inflate(R.layout.selector_dialog, (ViewGroup) null, false);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.selectorDialog = constraintLayout;
        SelectorDialogBinding bind = SelectorDialogBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        addViewToConstraintLayout(constraintLayout, -1, -1);
        setPosition(SAMPUIElement.PositionType.CENTER, 0, 0);
        Integer bits = item.getBits();
        if (bits != null) {
            twoTypeCode(bits.intValue(), item);
        }
        bind.btnClose.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.dialog.SelectorDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectorDialog.this.closeDialog();
            }
        });
        if (item.getItem() != null && item.getItem().intValue() > UtilsKt.getItemsName().size()) {
            bind.tvItemName.setText("Предмет");
        } else {
            TextView textView = bind.tvItemName;
            List<ItemsInfo> itemsName = UtilsKt.getItemsName();
            Integer item2 = item.getItem();
            textView.setText(itemsName.get(item2 != null ? item2.intValue() : 0).getName());
        }
        bind.btnFirstItem.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.dialog.SelectorDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectorDialog._init_$lambda$2(SelectorDialog.this, item, i2, view);
            }
        });
        bind.btnSecondItem.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.dialog.SelectorDialog$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectorDialog._init_$lambda$3(SelectorDialog.this, item, i2, view);
            }
        });
        bind.btnThirdItem.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.dialog.SelectorDialog$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectorDialog._init_$lambda$4(SelectorDialog.this, item, i2, view);
            }
        });
        bind.btnFourthItem.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.dialog.SelectorDialog$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectorDialog._init_$lambda$5(SelectorDialog.this, item, i2, view);
            }
        });
        bind.btnFifthItem.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.dialog.SelectorDialog$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectorDialog._init_$lambda$6(SelectorDialog.this, item, i2, view);
            }
        });
        bind.btnSixthItem.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.dialog.SelectorDialog$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectorDialog._init_$lambda$7(SelectorDialog.this, item, i2, view);
            }
        });
        if (item.getItem_type() != null && item.getItem_type().intValue() < ConstantsKt.getItemsDescription().size()) {
            bind.tvItemDescription.setText(UtilsKt.getItemsDescription(targetActivity).get(item.getItem_type().intValue()));
        } else {
            bind.tvItemDescription.setText("");
        }
    }

    public final ConstraintLayout getSelectorDialog() {
        return this.selectorDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$2(SelectorDialog selectorDialog, InventoryItem inventoryItem, int i, View view) {
        selectorDialog.sendData(inventoryItem, selectorDialog.firstBits, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$3(SelectorDialog selectorDialog, InventoryItem inventoryItem, int i, View view) {
        selectorDialog.sendData(inventoryItem, selectorDialog.secondBits, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$4(SelectorDialog selectorDialog, InventoryItem inventoryItem, int i, View view) {
        selectorDialog.sendData(inventoryItem, selectorDialog.thirdBits, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$5(SelectorDialog selectorDialog, InventoryItem inventoryItem, int i, View view) {
        selectorDialog.sendData(inventoryItem, selectorDialog.fourthBits, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$6(SelectorDialog selectorDialog, InventoryItem inventoryItem, int i, View view) {
        selectorDialog.sendData(inventoryItem, selectorDialog.fifthBits, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$7(SelectorDialog selectorDialog, InventoryItem inventoryItem, int i, View view) {
        selectorDialog.sendData(inventoryItem, selectorDialog.sixthBits, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void closeDialog() {
        InventoryScreen.Companion.setDialogVisible(false);
        ConstraintLayout parentLayout = this.binding.parentLayout;
        Intrinsics.checkNotNullExpressionValue(parentLayout, "parentLayout");
        parentLayout.setVisibility(8);
    }

    private final void twoTypeCode(int i, InventoryItem inventoryItem) {
        EnumSet<ActionTypes> allOf = EnumSet.allOf(ActionTypes.class);
        Intrinsics.checkNotNullExpressionValue(allOf, "allOf(...)");
        ArrayList arrayList = new ArrayList();
        for (ActionTypes actionTypes : allOf) {
            if ((actionTypes.getValue() & i) > 0) {
                arrayList.add(Integer.valueOf(actionTypes.ordinal()));
            }
        }
        setItemVisibility(arrayList);
    }

    private final void setItemVisibility(List<Integer> list) {
        int pow;
        int pow2;
        int pow3;
        int pow4;
        int pow5;
        SelectorDialogBinding selectorDialogBinding = this.binding;
        list.remove(Integer.valueOf(ActionTypes.INVENTORY_BUTTON_TYPE_CLOSE.ordinal()));
        if (list.get(0).intValue() == ActionTypes.INVENTORY_BUTTON_TYPE_USE.ordinal()) {
            selectorDialogBinding.btnFirstItem.setBackgroundResource(R.drawable.rectangle_yellow_selector);
            selectorDialogBinding.btnFirstItem.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_baseline_done_24, 0, 0, 0);
            selectorDialogBinding.btnFirstItem.setText(defineText(list.get(0).intValue()));
            selectorDialogBinding.btnFirstItem.setTextColor(getTargetActivity().getResources().getColor(R.color.black));
            this.firstBits = ActionTypes.INVENTORY_BUTTON_TYPE_USE.getValue();
        } else {
            selectorDialogBinding.btnFirstItem.setText(defineText(list.get(0).intValue()));
            this.firstBits = (int) Math.pow(2.0d, list.get(0).intValue());
        }
        if (list.size() > 1) {
            if (list.get(1).intValue() == ActionTypes.INVENTORY_BUTTON_TYPE_PUT_ON.ordinal()) {
                pow5 = ActionTypes.INVENTORY_BUTTON_TYPE_PUT_ON.getValue();
            } else {
                pow5 = (int) Math.pow(2.0d, list.get(1).intValue());
            }
            this.secondBits = pow5;
            selectorDialogBinding.btnSecondItem.setText(defineText(list.get(1).intValue()));
        } else {
            TextView btnSecondItem = selectorDialogBinding.btnSecondItem;
            Intrinsics.checkNotNullExpressionValue(btnSecondItem, "btnSecondItem");
            btnSecondItem.setVisibility(8);
        }
        if (list.size() > 2) {
            TextView btnThirdItem = selectorDialogBinding.btnThirdItem;
            Intrinsics.checkNotNullExpressionValue(btnThirdItem, "btnThirdItem");
            btnThirdItem.setVisibility(0);
            if (list.get(2).intValue() == ActionTypes.INVENTORY_BUTTON_TYPE_PUT.ordinal()) {
                pow4 = ActionTypes.INVENTORY_BUTTON_TYPE_PUT.getValue();
            } else {
                pow4 = (int) Math.pow(2.0d, list.get(2).intValue());
            }
            this.thirdBits = pow4;
            selectorDialogBinding.btnThirdItem.setText(defineText(list.get(2).intValue()));
        } else {
            TextView btnThirdItem2 = selectorDialogBinding.btnThirdItem;
            Intrinsics.checkNotNullExpressionValue(btnThirdItem2, "btnThirdItem");
            btnThirdItem2.setVisibility(8);
        }
        if (list.size() > 3) {
            TextView btnFourthItem = selectorDialogBinding.btnFourthItem;
            Intrinsics.checkNotNullExpressionValue(btnFourthItem, "btnFourthItem");
            btnFourthItem.setVisibility(0);
            if (list.get(3).intValue() == ActionTypes.INVENTORY_A_BUTTON_TYPE_TAKE_ON.ordinal()) {
                pow3 = ActionTypes.INVENTORY_A_BUTTON_TYPE_TAKE_ON.getValue();
            } else {
                pow3 = (int) Math.pow(2.0d, list.get(3).intValue());
            }
            this.fourthBits = pow3;
            selectorDialogBinding.btnFourthItem.setText(defineText(list.get(3).intValue()));
        } else {
            TextView btnFourthItem2 = selectorDialogBinding.btnFourthItem;
            Intrinsics.checkNotNullExpressionValue(btnFourthItem2, "btnFourthItem");
            btnFourthItem2.setVisibility(8);
        }
        if (list.size() > 4) {
            TextView btnFifthItem = selectorDialogBinding.btnFifthItem;
            Intrinsics.checkNotNullExpressionValue(btnFifthItem, "btnFifthItem");
            btnFifthItem.setVisibility(0);
            if (list.get(4).intValue() == ActionTypes.INVENTORY_BUTTON_TYPE_TAKE.ordinal()) {
                pow2 = ActionTypes.INVENTORY_BUTTON_TYPE_TAKE.getValue();
            } else {
                pow2 = (int) Math.pow(2.0d, list.get(4).intValue());
            }
            this.fifthBits = pow2;
            selectorDialogBinding.btnFifthItem.setText(defineText(list.get(4).intValue()));
        } else {
            TextView btnFifthItem2 = selectorDialogBinding.btnFifthItem;
            Intrinsics.checkNotNullExpressionValue(btnFifthItem2, "btnFifthItem");
            btnFifthItem2.setVisibility(8);
        }
        if (list.size() > 5) {
            TextView btnSixthItem = selectorDialogBinding.btnSixthItem;
            Intrinsics.checkNotNullExpressionValue(btnSixthItem, "btnSixthItem");
            btnSixthItem.setVisibility(0);
            if (list.get(5).intValue() == ActionTypes.INVENTORY_BUTTON_TYPE_SELL.ordinal()) {
                pow = ActionTypes.INVENTORY_BUTTON_TYPE_SELL.getValue();
            } else {
                pow = (int) Math.pow(2.0d, list.get(5).intValue());
            }
            this.sixthBits = pow;
            selectorDialogBinding.btnSixthItem.setText(defineText(list.get(5).intValue()));
            return;
        }
        TextView btnSixthItem2 = selectorDialogBinding.btnSixthItem;
        Intrinsics.checkNotNullExpressionValue(btnSixthItem2, "btnSixthItem");
        btnSixthItem2.setVisibility(8);
    }

    private final void sendData(InventoryItem inventoryItem, int i, int i2) {
        int backendID = getBackendID();
        int inventoryType = inventoryItem.getInventoryType();
        Log.d("TAG_SELECTOR", "backendID: " + backendID + " ==== type: " + inventoryType + " ; slot: " + inventoryItem.getSlot() + " ; bits: " + i + " ; id: " + i2);
        IBackendNotifier notifier = getNotifier();
        int id = UIElementID.INVENTORY.getId();
        byte[] bytes = StringKt.toStringJson(new SendSelectedData(inventoryItem.getInventoryType(), inventoryItem.getSlot(), i, i2)).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        notifier.clickedWrapper(id, -1, 3, bytes);
        closeDialog();
    }

    private final String defineText(int i) {
        return i == ActionTypes.INVENTORY_BUTTON_TYPE_USE.ordinal() ? "Использовать" : i == ActionTypes.INVENTORY_BUTTON_TYPE_PUT_ON.ordinal() ? "Надеть" : i == ActionTypes.INVENTORY_BUTTON_TYPE_DROP.ordinal() ? "Выкинуть" : i == ActionTypes.INVENTORY_BUTTON_TYPE_SPLIT.ordinal() ? "Разделить" : i == ActionTypes.INVENTORY_BUTTON_TYPE_INFO.ordinal() ? "Информация" : i == ActionTypes.INVENTORY_BUTTON_TYPE_ITEM_OPEN.ordinal() ? "Открыть" : i == ActionTypes.INVENTORY_BUTTON_TYPE_ITEM_CLOSE.ordinal() ? "Закрыть" : i == ActionTypes.INVENTORY_A_BUTTON_TYPE_TAKE_ON.ordinal() ? "Снять" : i == ActionTypes.INVENTORY_A_BUTTON_TYPE_CLEAR.ordinal() ? "Очистить" : i == ActionTypes.INVENTORY_A_BUTTON_TYPE_INSTALL.ordinal() ? "Установить" : i == ActionTypes.INVENTORY_A_BUTTON_TYPE_EDIT.ordinal() ? "Изменить" : i == ActionTypes.INVENTORY_A_BUTTON_TYPE_OPEN.ordinal() ? "Открыть" : i == ActionTypes.INVENTORY_A_BUTTON_TYPE_RENT.ordinal() ? "Арендовать" : i == ActionTypes.INVENTORY_A_BUTTON_TYPE_COLOR.ordinal() ? "Изменить цвет" : i == ActionTypes.INVENTORY_BUTTON_TYPE_PUT.ordinal() ? "Положить" : i == ActionTypes.INVENTORY_BUTTON_TYPE_TAKE.ordinal() ? "Забрать" : i == ActionTypes.INVENTORY_BUTTON_TYPE_SELL.ordinal() ? "Продать" : i == ActionTypes.INVENTORY_BUTTON_TYPE_PUT_IN_GIFT.ordinal() ? "Поместить" : i == ActionTypes.INVENT_BUTTON_TYPE_SEND.ordinal() ? "Передать" : "";
    }
}
