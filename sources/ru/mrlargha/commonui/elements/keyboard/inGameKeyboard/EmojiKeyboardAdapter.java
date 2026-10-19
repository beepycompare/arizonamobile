package ru.mrlargha.commonui.elements.keyboard.inGameKeyboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.EmojiKeyboardAdapter;
import ru.mrlargha.commonui.utils.emoji.ChatEmoji;
/* compiled from: EmojiKeyboardAdapter.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B,\u0012#\b\u0002\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0010H\u0016R)\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lru/mrlargha/commonui/elements/keyboard/inGameKeyboard/EmojiKeyboardAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/mrlargha/commonui/elements/keyboard/inGameKeyboard/EmojiKeyboardItem;", "Lru/mrlargha/commonui/elements/keyboard/inGameKeyboard/EmojiKeyboardAdapter$EmojiViewHolder;", "click", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "emoji", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "EmojiViewHolder", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class EmojiKeyboardAdapter extends ListAdapter<EmojiKeyboardItem, EmojiViewHolder> {
    private final Function1<EmojiKeyboardItem, Unit> click;

    public EmojiKeyboardAdapter() {
        this(null, 1, null);
    }

    public /* synthetic */ EmojiKeyboardAdapter(Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Function1() { // from class: ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.EmojiKeyboardAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EmojiKeyboardAdapter._init_$lambda$0((EmojiKeyboardItem) obj);
            }
        } : function1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit _init_$lambda$0(EmojiKeyboardItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public EmojiKeyboardAdapter(Function1<? super EmojiKeyboardItem, Unit> click) {
        super(new EmojiDiffCallback());
        Intrinsics.checkNotNullParameter(click, "click");
        this.click = click;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public EmojiViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.keyboard_emoji_item_view, parent, false);
        Function1<EmojiKeyboardItem, Unit> function1 = this.click;
        Intrinsics.checkNotNull(inflate);
        return new EmojiViewHolder(function1, inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(EmojiViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        EmojiKeyboardItem item = getItem(i);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        holder.bind(item);
    }

    /* compiled from: EmojiKeyboardAdapter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B2\u0012!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004R)\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lru/mrlargha/commonui/elements/keyboard/inGameKeyboard/EmojiKeyboardAdapter$EmojiViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "click", "Lkotlin/Function1;", "Lru/mrlargha/commonui/elements/keyboard/inGameKeyboard/EmojiKeyboardItem;", "Lkotlin/ParameterName;", "name", "emoji", "", "itemView", "Landroid/view/View;", "<init>", "(Lkotlin/jvm/functions/Function1;Landroid/view/View;)V", "bind", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class EmojiViewHolder extends RecyclerView.ViewHolder {
        private final Function1<EmojiKeyboardItem, Unit> click;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public EmojiViewHolder(Function1<? super EmojiKeyboardItem, Unit> click, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(click, "click");
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.click = click;
        }

        public final void bind(final EmojiKeyboardItem emoji) {
            Intrinsics.checkNotNullParameter(emoji, "emoji");
            View view = this.itemView;
            TextView textView = view instanceof TextView ? (TextView) view : null;
            if (textView != null) {
                textView.setText(ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, emoji.getDisplayText(), 1.1f, null, 2, null));
                textView.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.EmojiKeyboardAdapter$EmojiViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        EmojiKeyboardAdapter.EmojiViewHolder.bind$lambda$0$0(EmojiKeyboardAdapter.EmojiViewHolder.this, emoji, view2);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$0$0(EmojiViewHolder emojiViewHolder, EmojiKeyboardItem emojiKeyboardItem, View view) {
            emojiViewHolder.click.invoke(emojiKeyboardItem);
        }
    }
}
