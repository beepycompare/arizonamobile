package ru.mrlargha.arizonaui.mobile.presentation.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.mobile.domain.obj.EmojiItem;
import ru.mrlargha.commonui.utils.StringKt;
/* compiled from: MobilePhoneMessengerEmojiAdapter.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0014\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\u0014\u0010\u0016\u001a\u00020\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0018J\u0006\u0010\u0019\u001a\u00020\u0006R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/adapter/MobilePhoneMessengerEmojiAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/arizonaui/mobile/presentation/adapter/MobilePhoneMessengerEmojiViewHolder;", "onEmojiSelect", "Lkotlin/Function1;", "Lru/mrlargha/arizonaui/mobile/domain/obj/EmojiItem;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getOnEmojiSelect", "()Lkotlin/jvm/functions/Function1;", "emojiList", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "addData", "emojis", "", "clearData", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MobilePhoneMessengerEmojiAdapter extends RecyclerView.Adapter<MobilePhoneMessengerEmojiViewHolder> {
    private final List<EmojiItem> emojiList;
    private final Function1<EmojiItem, Unit> onEmojiSelect;

    public MobilePhoneMessengerEmojiAdapter() {
        this(null, 1, null);
    }

    public /* synthetic */ MobilePhoneMessengerEmojiAdapter(Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Function1() { // from class: ru.mrlargha.arizonaui.mobile.presentation.adapter.MobilePhoneMessengerEmojiAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = MobilePhoneMessengerEmojiAdapter._init_$lambda$0((EmojiItem) obj);
                return _init_$lambda$0;
            }
        } : function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(EmojiItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    public final Function1<EmojiItem, Unit> getOnEmojiSelect() {
        return this.onEmojiSelect;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MobilePhoneMessengerEmojiAdapter(Function1<? super EmojiItem, Unit> onEmojiSelect) {
        Intrinsics.checkNotNullParameter(onEmojiSelect, "onEmojiSelect");
        this.onEmojiSelect = onEmojiSelect;
        this.emojiList = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MobilePhoneMessengerEmojiViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.emoji_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new MobilePhoneMessengerEmojiViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(MobilePhoneMessengerEmojiViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final EmojiItem emojiItem = this.emojiList.get(i);
        holder.getBinding().emojiTv.setText(StringKt.getEmojiByUnicode(emojiItem.getUnicodeAndroid()));
        holder.getBinding().getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.adapter.MobilePhoneMessengerEmojiAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MobilePhoneMessengerEmojiAdapter.onBindViewHolder$lambda$2(MobilePhoneMessengerEmojiAdapter.this, emojiItem, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$2(MobilePhoneMessengerEmojiAdapter mobilePhoneMessengerEmojiAdapter, EmojiItem emojiItem, View view) {
        mobilePhoneMessengerEmojiAdapter.onEmojiSelect.invoke(emojiItem);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.emojiList.size();
    }

    public final void addData(List<EmojiItem> emojis) {
        Intrinsics.checkNotNullParameter(emojis, "emojis");
        this.emojiList.clear();
        this.emojiList.addAll(emojis);
        notifyDataSetChanged();
    }

    public final void clearData() {
        this.emojiList.clear();
        notifyDataSetChanged();
    }
}
