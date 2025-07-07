package ru.mrlargha.arizonaui.mobile.presentation.adapter;

import android.graphics.Color;
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
import ru.mrlargha.arizonaui.databinding.MobilePhoneMessengerMessageBinding;
import ru.mrlargha.arizonaui.mobile.domain.obj.MessageInfo;
/* compiled from: MobilePhoneMessengerChatAdapter.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0014\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0011H\u0016J\u0018\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0011H\u0016J\b\u0010\u001c\u001a\u00020\u0011H\u0016J\u000e\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0005J\u0014\u0010\u001f\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050 J\u0006\u0010!\u001a\u00020\u0006R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u000ej\b\u0012\u0004\u0012\u00020\u0005`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/adapter/MobilePhoneMessengerChatAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/arizonaui/mobile/presentation/adapter/MobilePhoneMessengerMessageViewHolder;", "onClickMessage", "Lkotlin/Function1;", "Lru/mrlargha/arizonaui/mobile/domain/obj/MessageInfo;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getOnClickMessage", "()Lkotlin/jvm/functions/Function1;", "isLoadingAdded", "", "messages", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "friendMessageColor", "", "myMessageColor", "friendTimeColor", "myTimeColor", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "addMessage", "message", "addMessages", "", "clearMessages", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MobilePhoneMessengerChatAdapter extends RecyclerView.Adapter<MobilePhoneMessengerMessageViewHolder> {
    private final int friendMessageColor;
    private final int friendTimeColor;
    private boolean isLoadingAdded;
    private final ArrayList<MessageInfo> messages;
    private final int myMessageColor;
    private final int myTimeColor;
    private final Function1<MessageInfo, Unit> onClickMessage;

    public MobilePhoneMessengerChatAdapter() {
        this(null, 1, null);
    }

    public /* synthetic */ MobilePhoneMessengerChatAdapter(Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Function1() { // from class: ru.mrlargha.arizonaui.mobile.presentation.adapter.MobilePhoneMessengerChatAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = MobilePhoneMessengerChatAdapter._init_$lambda$0((MessageInfo) obj);
                return _init_$lambda$0;
            }
        } : function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(MessageInfo it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    public final Function1<MessageInfo, Unit> getOnClickMessage() {
        return this.onClickMessage;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MobilePhoneMessengerChatAdapter(Function1<? super MessageInfo, Unit> onClickMessage) {
        Intrinsics.checkNotNullParameter(onClickMessage, "onClickMessage");
        this.onClickMessage = onClickMessage;
        this.messages = new ArrayList<>();
        this.friendMessageColor = Color.parseColor("#2F2F2F");
        this.myMessageColor = Color.parseColor("#4A8EF4");
        this.friendTimeColor = Color.parseColor("#AAAAAA");
        this.myTimeColor = Color.parseColor("#A3C8FF");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MobilePhoneMessengerMessageViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.mobile_phone_messenger_message, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new MobilePhoneMessengerMessageViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(MobilePhoneMessengerMessageViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        MessageInfo messageInfo = this.messages.get(i);
        Intrinsics.checkNotNullExpressionValue(messageInfo, "get(...)");
        final MessageInfo messageInfo2 = messageInfo;
        MobilePhoneMessengerMessageBinding binding = holder.getBinding();
        binding.messageText.setText(messageInfo2.getText());
        binding.time.setText(messageInfo2.getFormattedTime());
        if (messageInfo2.getSendByMe()) {
            binding.time.setTextColor(this.myTimeColor);
            binding.messageContainer.setCardBackgroundColor(this.myMessageColor);
        } else {
            binding.time.setTextColor(this.friendTimeColor);
            binding.messageContainer.setCardBackgroundColor(this.friendMessageColor);
        }
        holder.getBinding().getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.adapter.MobilePhoneMessengerChatAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MobilePhoneMessengerChatAdapter.onBindViewHolder$lambda$2(MobilePhoneMessengerChatAdapter.this, messageInfo2, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$2(MobilePhoneMessengerChatAdapter mobilePhoneMessengerChatAdapter, MessageInfo messageInfo, View view) {
        mobilePhoneMessengerChatAdapter.onClickMessage.invoke(messageInfo);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.messages.size();
    }

    public final void addMessage(MessageInfo message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.messages.add(message);
        notifyItemInserted(this.messages.size() - 1);
    }

    public final void addMessages(List<MessageInfo> messages) {
        Intrinsics.checkNotNullParameter(messages, "messages");
        this.messages.addAll(0, messages);
        notifyDataSetChanged();
    }

    public final void clearMessages() {
        this.messages.clear();
        notifyDataSetChanged();
    }
}
