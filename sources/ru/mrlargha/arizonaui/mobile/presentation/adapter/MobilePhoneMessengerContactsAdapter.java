package ru.mrlargha.arizonaui.mobile.presentation.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.arizona.common.model.AvatarData;
import com.arizona.common.ui.AvatarView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.databinding.MobilePhoneMessengerItemContactBinding;
import ru.mrlargha.arizonaui.mobile.domain.obj.ContactInfo;
import ru.mrlargha.arizonaui.mobile.presentation.adapter.viewHolder.LoadingViewHolder;
import ru.mrlargha.commonui.utils.DateConverter;
import ru.mrlargha.commonui.utils.FirebaseConfigHelper;
/* compiled from: MobilePhoneMessengerContactsAdapter.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\r\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B3\u0012\u0014\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u000eH\u0016J\u0018\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u000eH\u0016J\b\u0010$\u001a\u00020\u000eH\u0016J\u000e\u0010%\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0011J\u0014\u0010&\u001a\u00020\u00062\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00050(J\u0016\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\u0005J\u000e\u0010,\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u0005J\u0006\u0010-\u001a\u00020\u0006J\u0010\u0010.\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u000eH\u0016J\u000e\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u000eJ\u000e\u00101\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u000eJ\u0016\u00102\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u000e2\u0006\u00104\u001a\u00020\u001cR\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u000e\u0010\r\u001a\u00020\u000eX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0013j\b\u0012\u0004\u0012\u00020\u0005`\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/adapter/MobilePhoneMessengerContactsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onNewChat", "Lkotlin/Function1;", "Lru/mrlargha/arizonaui/mobile/domain/obj/ContactInfo;", "", "onAddOrRemoveUser", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getOnNewChat", "()Lkotlin/jvm/functions/Function1;", "getOnAddOrRemoveUser", "loading", "", "item", "isLoadingAdded", "", "contacts", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getContacts", "()Ljava/util/ArrayList;", "isContacts", "()Z", "setContacts", "(Z)V", "avatarPlaceholderUrl", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "changeMode", "addData", "contactData", "", "updateData", "dialogIndex", "contactInfo", "updateNewData", "clearData", "getItemViewType", "contactAddAction", "userIdForAddContact", "contactRemoveAction", "onNewMessage", "userId", "newMessage", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MobilePhoneMessengerContactsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final String avatarPlaceholderUrl;
    private final ArrayList<ContactInfo> contacts;
    private boolean isContacts;
    private boolean isLoadingAdded;
    private final int item;
    private final int loading;
    private final Function1<ContactInfo, Unit> onAddOrRemoveUser;
    private final Function1<ContactInfo, Unit> onNewChat;

    public MobilePhoneMessengerContactsAdapter() {
        this(null, null, 3, null);
    }

    public /* synthetic */ MobilePhoneMessengerContactsAdapter(Function1 function1, Function1 function12, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Function1() { // from class: ru.mrlargha.arizonaui.mobile.presentation.adapter.MobilePhoneMessengerContactsAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = MobilePhoneMessengerContactsAdapter._init_$lambda$0((ContactInfo) obj);
                return _init_$lambda$0;
            }
        } : function1, (i & 2) != 0 ? new Function1() { // from class: ru.mrlargha.arizonaui.mobile.presentation.adapter.MobilePhoneMessengerContactsAdapter$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _init_$lambda$1;
                _init_$lambda$1 = MobilePhoneMessengerContactsAdapter._init_$lambda$1((ContactInfo) obj);
                return _init_$lambda$1;
            }
        } : function12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(ContactInfo it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    public final Function1<ContactInfo, Unit> getOnNewChat() {
        return this.onNewChat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$1(ContactInfo it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    public final Function1<ContactInfo, Unit> getOnAddOrRemoveUser() {
        return this.onAddOrRemoveUser;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MobilePhoneMessengerContactsAdapter(Function1<? super ContactInfo, Unit> onNewChat, Function1<? super ContactInfo, Unit> onAddOrRemoveUser) {
        Intrinsics.checkNotNullParameter(onNewChat, "onNewChat");
        Intrinsics.checkNotNullParameter(onAddOrRemoveUser, "onAddOrRemoveUser");
        this.onNewChat = onNewChat;
        this.onAddOrRemoveUser = onAddOrRemoveUser;
        this.item = 1;
        this.contacts = new ArrayList<>();
        this.avatarPlaceholderUrl = FirebaseConfigHelper.INSTANCE.getResourceUrl() + "projects/arizona-rp/assets/images/inventory/skins/256/-1.webp";
    }

    public final ArrayList<ContactInfo> getContacts() {
        return this.contacts;
    }

    public final boolean isContacts() {
        return this.isContacts;
    }

    public final void setContacts(boolean z) {
        this.isContacts = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        LoadingViewHolder loadingViewHolder;
        Intrinsics.checkNotNullParameter(parent, "parent");
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        if (i == this.item) {
            View inflate = from.inflate(R.layout.mobile_phone_messenger_item_contact, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            loadingViewHolder = new MobilePhoneMessengerMessagesViewHolder(inflate);
        } else if (i == this.loading) {
            View inflate2 = from.inflate(R.layout.item_progress, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "inflate(...)");
            loadingViewHolder = new LoadingViewHolder(inflate2);
        } else {
            loadingViewHolder = null;
        }
        if (loadingViewHolder == null) {
            View inflate3 = from.inflate(R.layout.item_progress, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate3, "inflate(...)");
            return new LoadingViewHolder(inflate3);
        }
        return loadingViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        ContactInfo contactInfo = this.contacts.get(i);
        Intrinsics.checkNotNullExpressionValue(contactInfo, "get(...)");
        final ContactInfo contactInfo2 = contactInfo;
        int itemViewType = getItemViewType(i);
        if (itemViewType == this.item) {
            MobilePhoneMessengerMessagesViewHolder mobilePhoneMessengerMessagesViewHolder = (MobilePhoneMessengerMessagesViewHolder) holder;
            MobilePhoneMessengerItemContactBinding binding = mobilePhoneMessengerMessagesViewHolder.getBinding();
            binding.contactName.setText(contactInfo2.getContactName());
            if (this.isContacts) {
                LinearLayout statusContainer = binding.statusContainer;
                Intrinsics.checkNotNullExpressionValue(statusContainer, "statusContainer");
                statusContainer.setVisibility(8);
                LinearLayout actionsContainer = binding.actionsContainer;
                Intrinsics.checkNotNullExpressionValue(actionsContainer, "actionsContainer");
                actionsContainer.setVisibility(0);
            } else {
                LinearLayout statusContainer2 = binding.statusContainer;
                Intrinsics.checkNotNullExpressionValue(statusContainer2, "statusContainer");
                statusContainer2.setVisibility(0);
                LinearLayout actionsContainer2 = binding.actionsContainer;
                Intrinsics.checkNotNullExpressionValue(actionsContainer2, "actionsContainer");
                actionsContainer2.setVisibility(8);
            }
            boolean z = true;
            if (Intrinsics.areEqual((Object) contactInfo2.isContact(), (Object) true)) {
                binding.addOrRemoveUserBtn.setImageDrawable(ContextCompat.getDrawable(binding.getRoot().getContext(), ru.mrlargha.commonui.R.drawable.ic_remove_user_messenger));
            } else {
                binding.addOrRemoveUserBtn.setImageDrawable(ContextCompat.getDrawable(binding.getRoot().getContext(), ru.mrlargha.commonui.R.drawable.ic_add_user_messenger));
            }
            binding.addOrRemoveUserBtn.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.adapter.MobilePhoneMessengerContactsAdapter$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MobilePhoneMessengerContactsAdapter.onBindViewHolder$lambda$4$lambda$2(MobilePhoneMessengerContactsAdapter.this, contactInfo2, view);
                }
            });
            binding.sendMessageBtn.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.adapter.MobilePhoneMessengerContactsAdapter$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MobilePhoneMessengerContactsAdapter.onBindViewHolder$lambda$4$lambda$3(MobilePhoneMessengerContactsAdapter.this, contactInfo2, view);
                }
            });
            AvatarView avatarView = binding.avatar;
            String avatarUrl = contactInfo2.getAvatarUrl();
            if (avatarUrl == null) {
                avatarUrl = this.avatarPlaceholderUrl;
            }
            avatarView.updateData(new AvatarData(avatarUrl, contactInfo2.getStatus().getColor(), contactInfo2.getContactBackground().getBackground(), null, 8, null));
            binding.lastTimeMessage.setText(contactInfo2.getFormattedTime());
            CardView messageStatus = binding.messageStatus;
            Intrinsics.checkNotNullExpressionValue(messageStatus, "messageStatus");
            messageStatus.setVisibility(!contactInfo2.getHasRead() && !contactInfo2.isMe() ? 0 : 8);
            AppCompatImageView icAttach = binding.icAttach;
            Intrinsics.checkNotNullExpressionValue(icAttach, "icAttach");
            icAttach.setVisibility(contactInfo2.isAttached() && !this.isContacts ? 0 : 8);
            AppCompatImageView icNotificationOff = binding.icNotificationOff;
            Intrinsics.checkNotNullExpressionValue(icNotificationOff, "icNotificationOff");
            AppCompatImageView appCompatImageView = icNotificationOff;
            if (contactInfo2.isNotificationsAllowed() || this.isContacts) {
                z = false;
            }
            appCompatImageView.setVisibility(z ? 0 : 8);
            if (this.isContacts) {
                binding.messageText.setEllipsize(null);
                AppCompatTextView appCompatTextView = binding.messageText;
                String phone = contactInfo2.getPhone();
                if (phone == null) {
                    phone = "";
                }
                appCompatTextView.setText(phone);
            } else {
                binding.messageText.setEllipsize(TextUtils.TruncateAt.END);
                binding.messageText.setText(contactInfo2.isMe() ? "Вы: " + contactInfo2.getText() : contactInfo2.getText());
            }
            mobilePhoneMessengerMessagesViewHolder.getBinding().getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.adapter.MobilePhoneMessengerContactsAdapter$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MobilePhoneMessengerContactsAdapter.onBindViewHolder$lambda$5(MobilePhoneMessengerContactsAdapter.this, contactInfo2, view);
                }
            });
        } else if (itemViewType == this.loading) {
            FrameLayout root = ((LoadingViewHolder) holder).getBinding().getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            root.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$4$lambda$2(MobilePhoneMessengerContactsAdapter mobilePhoneMessengerContactsAdapter, ContactInfo contactInfo, View view) {
        mobilePhoneMessengerContactsAdapter.onAddOrRemoveUser.invoke(contactInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$4$lambda$3(MobilePhoneMessengerContactsAdapter mobilePhoneMessengerContactsAdapter, ContactInfo contactInfo, View view) {
        mobilePhoneMessengerContactsAdapter.onNewChat.invoke(contactInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$5(MobilePhoneMessengerContactsAdapter mobilePhoneMessengerContactsAdapter, ContactInfo contactInfo, View view) {
        if (mobilePhoneMessengerContactsAdapter.isContacts) {
            return;
        }
        mobilePhoneMessengerContactsAdapter.onNewChat.invoke(contactInfo);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.contacts.size();
    }

    public final void changeMode(boolean z) {
        this.isContacts = z;
    }

    public final void addData(List<ContactInfo> contactData) {
        Intrinsics.checkNotNullParameter(contactData, "contactData");
        this.contacts.addAll(contactData);
        notifyDataSetChanged();
    }

    public final void updateData(int i, ContactInfo contactInfo) {
        Intrinsics.checkNotNullParameter(contactInfo, "contactInfo");
        this.contacts.set(i, contactInfo);
        notifyItemChanged(i);
    }

    public final void updateNewData(ContactInfo contactInfo) {
        Intrinsics.checkNotNullParameter(contactInfo, "contactInfo");
        int i = 0;
        if (contactInfo.isAttached()) {
            this.contacts.add(0, contactInfo);
        } else {
            Iterator<ContactInfo> it = this.contacts.iterator();
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                } else if (!it.next().isAttached()) {
                    break;
                } else {
                    i++;
                }
            }
            if (i != -1) {
                this.contacts.add(i, contactInfo);
            }
        }
        notifyDataSetChanged();
    }

    public final void clearData() {
        this.contacts.clear();
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return (i == this.contacts.size() + (-1) && this.isLoadingAdded) ? this.loading : this.item;
    }

    public final void contactAddAction(int i) {
        Iterator<ContactInfo> it = this.contacts.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            } else if (it.next().getId() == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 != -1) {
            ContactInfo contactInfo = this.contacts.get(i2);
            Intrinsics.checkNotNullExpressionValue(contactInfo, "get(...)");
            ContactInfo contactInfo2 = contactInfo;
            contactInfo2.setContact(true);
            this.contacts.set(i2, contactInfo2);
            notifyItemChanged(i2);
        }
    }

    public final void contactRemoveAction(int i) {
        Iterator<ContactInfo> it = this.contacts.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            } else if (it.next().getId() == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 != -1) {
            ContactInfo contactInfo = this.contacts.get(i2);
            Intrinsics.checkNotNullExpressionValue(contactInfo, "get(...)");
            ContactInfo contactInfo2 = contactInfo;
            contactInfo2.setContact(false);
            this.contacts.set(i2, contactInfo2);
            notifyItemChanged(i2);
        }
    }

    public final void onNewMessage(int i, String newMessage) {
        Intrinsics.checkNotNullParameter(newMessage, "newMessage");
        if (this.isContacts) {
            return;
        }
        Iterator<ContactInfo> it = this.contacts.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            } else if (it.next().getId() == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 != -1) {
            this.contacts.get(i2).setText(newMessage);
            this.contacts.get(i2).setFormattedTime(DateConverter.Companion.formattedTimeToday());
            this.contacts.get(i2).setTimestamp(Long.valueOf(System.currentTimeMillis()));
            notifyItemChanged(i2);
        }
    }
}
