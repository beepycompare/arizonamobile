package ru.mrlargha.commonui.elements.keyboard.inGameKeyboard;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.arizona.common.ui.KeyboardButton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.BindersAdapter;
import ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.models.BinderData;
/* compiled from: BindersAdapter.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B,\u0012#\b\u0002\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J\u0018\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0006H\u0016R)\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lru/mrlargha/commonui/elements/keyboard/inGameKeyboard/BindersAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/mrlargha/commonui/elements/keyboard/inGameKeyboard/models/BinderData;", "Lru/mrlargha/commonui/elements/keyboard/inGameKeyboard/BindersAdapter$BindDataViewHolder;", "click", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", TtmlNode.ATTR_ID, "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "BindDataViewHolder", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BindersAdapter extends ListAdapter<BinderData, BindDataViewHolder> {
    private final Function1<Integer, Unit> click;

    public BindersAdapter() {
        this(null, 1, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BindersAdapter(Function1<? super Integer, Unit> click) {
        super(new BindDataDiffCallback());
        Intrinsics.checkNotNullParameter(click, "click");
        this.click = click;
    }

    public /* synthetic */ BindersAdapter(Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Function1() { // from class: ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.BindersAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit unit;
                ((Integer) obj).intValue();
                unit = Unit.INSTANCE;
                return unit;
            }
        } : function1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BindDataViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.binder_buttoin_item_view, parent, false);
        Function1<Integer, Unit> function1 = this.click;
        Intrinsics.checkNotNull(inflate);
        return new BindDataViewHolder(function1, inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BindDataViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        BinderData item = getItem(i);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        holder.bind(item);
    }

    /* compiled from: BindersAdapter.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B2\u0012!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fR)\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lru/mrlargha/commonui/elements/keyboard/inGameKeyboard/BindersAdapter$BindDataViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "click", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", TtmlNode.ATTR_ID, "", "itemView", "Landroid/view/View;", "<init>", "(Lkotlin/jvm/functions/Function1;Landroid/view/View;)V", "bind", "item", "Lru/mrlargha/commonui/elements/keyboard/inGameKeyboard/models/BinderData;", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class BindDataViewHolder extends RecyclerView.ViewHolder {
        private final Function1<Integer, Unit> click;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public BindDataViewHolder(Function1<? super Integer, Unit> click, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(click, "click");
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.click = click;
        }

        public final void bind(final BinderData item) {
            Intrinsics.checkNotNullParameter(item, "item");
            View view = this.itemView;
            final KeyboardButton keyboardButton = view instanceof KeyboardButton ? (KeyboardButton) view : null;
            if (keyboardButton != null) {
                keyboardButton.setText(item.getBinderName());
                keyboardButton.setBinderButtonType(item.getBinderType());
                keyboardButton.onActionUp();
                keyboardButton.setOnTouchListener(new View.OnTouchListener() { // from class: ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.BindersAdapter$BindDataViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view2, MotionEvent motionEvent) {
                        boolean bind$lambda$0$0;
                        bind$lambda$0$0 = BindersAdapter.BindDataViewHolder.bind$lambda$0$0(KeyboardButton.this, this, item, view2, motionEvent);
                        return bind$lambda$0$0;
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean bind$lambda$0$0(KeyboardButton keyboardButton, BindDataViewHolder bindDataViewHolder, BinderData binderData, View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                keyboardButton.onActionDown();
            } else if (action == 1) {
                keyboardButton.onActionUp();
                bindDataViewHolder.click.invoke(Integer.valueOf(binderData.getId()));
            }
            return true;
        }
    }
}
