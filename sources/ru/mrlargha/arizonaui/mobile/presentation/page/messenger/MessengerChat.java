package ru.mrlargha.arizonaui.mobile.presentation.page.messenger;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.arizona.common.model.AvatarData;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.Charsets;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.databinding.MessengerChatLayoutBinding;
import ru.mrlargha.arizonaui.databinding.MessengerInputFieldLayoutBinding;
import ru.mrlargha.arizonaui.databinding.MobilePhoneBinding;
import ru.mrlargha.arizonaui.databinding.MobilePhoneMessengerChatPageBinding;
import ru.mrlargha.arizonaui.mobile.domain.enums.MobilePhonePage;
import ru.mrlargha.arizonaui.mobile.domain.obj.ContactInfo;
import ru.mrlargha.arizonaui.mobile.domain.obj.EmojiItem;
import ru.mrlargha.arizonaui.mobile.domain.obj.MessageInfo;
import ru.mrlargha.arizonaui.mobile.domain.obj.MobilePhoneObjectKt;
import ru.mrlargha.arizonaui.mobile.presentation.HistoryManager;
import ru.mrlargha.arizonaui.mobile.presentation.MobileController;
import ru.mrlargha.arizonaui.mobile.presentation.MobilePhone;
import ru.mrlargha.arizonaui.mobile.presentation.adapter.MobilePhoneMessengerChatAdapter;
import ru.mrlargha.arizonaui.mobile.presentation.adapter.MobilePhoneMessengerChatMenuAdapter;
import ru.mrlargha.arizonaui.mobile.presentation.adapter.MobilePhoneMessengerEmojiAdapter;
import ru.mrlargha.arizonaui.mobile.presentation.page.messenger.api.MessagesApi;
import ru.mrlargha.arizonaui.mobile.presentation.page.messenger.api.obj.ChatMessageApiResponse;
import ru.mrlargha.arizonaui.mobile.presentation.page.messenger.api.obj.ContactApiResponse;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.elements.CustomKeyboard;
import ru.mrlargha.commonui.utils.DateConverter;
import ru.mrlargha.commonui.utils.StringKt;
import ru.mrlargha.commonui.utils.recycle_view.PaginationScrollListener;
/* compiled from: MessengerChat.kt */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0012\n\u0002\b\u001d\u0018\u0000 f2\u00020\u0001:\u0002fgB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u00105\u001a\u000206H\u0002J\u0010\u00107\u001a\u0002062\u0006\u00108\u001a\u00020%H\u0002J\u0010\u00109\u001a\u0002062\u0006\u0010:\u001a\u00020;H\u0002J\b\u0010<\u001a\u000206H\u0002J\b\u0010=\u001a\u000206H\u0002J\b\u0010>\u001a\u000206H\u0002J\b\u0010?\u001a\u000206H\u0002J\b\u0010@\u001a\u000206H\u0002J\b\u0010A\u001a\u000206H\u0002J\b\u0010B\u001a\u000206H\u0002J\b\u0010C\u001a\u000206H\u0002J\b\u0010D\u001a\u000206H\u0002J\b\u0010E\u001a\u000206H\u0002J\b\u0010F\u001a\u000206H\u0002J\b\u0010G\u001a\u000206H\u0002J\b\u0010H\u001a\u000206H\u0016J\b\u0010I\u001a\u000206H\u0016J\b\u0010J\u001a\u00020KH\u0002J\u0010\u0010L\u001a\u00020K2\u0006\u0010M\u001a\u00020\tH\u0002J\u0010\u0010N\u001a\u00020K2\u0006\u0010O\u001a\u00020\u0016H\u0002J\b\u0010P\u001a\u000206H\u0002J\u0010\u0010Q\u001a\u0002062\u0006\u0010O\u001a\u00020\u0016H\u0002J\b\u0010R\u001a\u000206H\u0002J\u001e\u0010S\u001a\u0002062\u0006\u0010T\u001a\u00020\t2\u0006\u0010M\u001a\u00020\t2\u0006\u0010O\u001a\u00020\u0016J\u0006\u0010U\u001a\u000206J\u0006\u0010V\u001a\u000206J\u0006\u0010W\u001a\u000206J\u0006\u0010X\u001a\u000206J\u0006\u0010Y\u001a\u000206J\u0006\u0010Z\u001a\u000206J\u0006\u0010[\u001a\u000206J\u0006\u0010\\\u001a\u000206J\u0006\u0010]\u001a\u000206J\b\u0010^\u001a\u000206H\u0002J\u0010\u0010_\u001a\u0002062\u0006\u0010M\u001a\u00020\tH\u0002J\b\u0010`\u001a\u000206H\u0002J\b\u0010a\u001a\u000206H\u0002J\b\u0010b\u001a\u000206H\u0002J\b\u0010c\u001a\u000206H\u0002J\u000e\u0010d\u001a\u0002062\u0006\u0010\u0019\u001a\u00020\tJ\u000e\u0010e\u001a\u0002062\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010!\u001a\n \u0012*\u0004\u0018\u00010\"0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010,\u001a\u00020%8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0014\u0010/\u001a\u00020%8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b0\u0010.R\u0014\u00101\u001a\u00020%8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b2\u0010.R\u0014\u00103\u001a\u00020%8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b4\u0010.¨\u0006h"}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/page/messenger/MessengerChat;", "Lru/mrlargha/arizonaui/mobile/presentation/MobileController;", "contactInfo", "Lru/mrlargha/arizonaui/mobile/domain/obj/ContactInfo;", "<init>", "(Lru/mrlargha/arizonaui/mobile/domain/obj/ContactInfo;)V", "isPaginationLoading", "", "paginationPage", "", "mobileChatPhone", "Lru/mrlargha/arizonaui/mobile/presentation/MobilePhone;", "context", "Landroid/app/Activity;", "phoneBinding", "Lru/mrlargha/arizonaui/databinding/MobilePhoneBinding;", "sharedPreferences", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "frontendNotifier", "Lru/mrlargha/commonui/core/IBackendNotifier;", "token", "", "requestMessage", "isRefreshToken", "dialogId", "Ljava/lang/Integer;", "page", "Landroidx/constraintlayout/widget/ConstraintLayout;", "pageBinding", "Lru/mrlargha/arizonaui/databinding/MobilePhoneMessengerChatPageBinding;", "retrofit", "Lretrofit2/Retrofit;", "api", "Lru/mrlargha/arizonaui/mobile/presentation/page/messenger/api/MessagesApi;", "startedMenuList", "", "Lru/mrlargha/arizonaui/mobile/presentation/page/messenger/MenuChatItem;", "chatAdapter", "Lru/mrlargha/arizonaui/mobile/presentation/adapter/MobilePhoneMessengerChatAdapter;", "menuAdapter", "Lru/mrlargha/arizonaui/mobile/presentation/adapter/MobilePhoneMessengerChatMenuAdapter;", "emojiAdapter", "Lru/mrlargha/arizonaui/mobile/presentation/adapter/MobilePhoneMessengerEmojiAdapter;", "blockMenuItem", "getBlockMenuItem", "()Lru/mrlargha/arizonaui/mobile/presentation/page/messenger/MenuChatItem;", "contactMenuItem", "getContactMenuItem", "pinMenuItem", "getPinMenuItem", "notificationMenuItem", "getNotificationMenuItem", "prepareInput", "", "onClickChatMenuItem", "menuItem", "onClickEmoji", "emoji", "Lru/mrlargha/arizonaui/mobile/domain/obj/EmojiItem;", "contactCall", "prepareHeader", "preparePage", "requestToken", "loadNextPage", "requestMessages", "showChatMenu", "showEmptyMessages", "showLoader", "showChat", "showBlockContact", "showInputLayout", "renderPage", "removePage", "getUserIdJson", "", "messageIdToJson", "messageId", "messageToJson", "message", "sendChatId", "sendMessage", "closeChatEvent", "onNewMessage", "userId", "callContactStatus", "removeMessageStatus", "notifyContactStatus", "clearMessagesStatus", "pinContactStatus", "blockContact", "addContactAction", "removeContactAction", "sendMessageSuccess", "contactAddOrRemove", "messageRemove", "contactDisableNotifications", "contactClearMessages", "contactBlock", "contactPin", "updateDialog", "updateToken", "Companion", "InputCustomKeyboardListener", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MessengerChat implements MobileController {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "MessengerChat";
    private final MessagesApi api;
    private final MobilePhoneMessengerChatAdapter chatAdapter;
    private ContactInfo contactInfo;
    private final Activity context;
    private Integer dialogId;
    private final MobilePhoneMessengerEmojiAdapter emojiAdapter;
    private final IBackendNotifier frontendNotifier;
    private boolean isPaginationLoading;
    private boolean isRefreshToken;
    private final MobilePhoneMessengerChatMenuAdapter menuAdapter;
    private final MobilePhone mobileChatPhone;
    private final ConstraintLayout page;
    private final MobilePhoneMessengerChatPageBinding pageBinding;
    private int paginationPage;
    private final MobilePhoneBinding phoneBinding;
    private String requestMessage;
    private Retrofit retrofit;
    private final SharedPreferences sharedPreferences;
    private final List<MenuChatItem> startedMenuList;
    private String token;

    /* compiled from: MessengerChat.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MenuId.values().length];
            try {
                iArr[MenuId.ADD_REMOVE_CONTACT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MenuId.CALL_CONTACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MenuId.CLEAR_MESSAGES.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MenuId.NOTIFICATIONS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MenuId.PIN_CONTACT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[MenuId.BLOCK_CONTACT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final void callContactStatus() {
    }

    public final void removeMessageStatus() {
    }

    public MessengerChat(ContactInfo contactInfo) {
        Intrinsics.checkNotNullParameter(contactInfo, "contactInfo");
        this.contactInfo = contactInfo;
        this.paginationPage = 1;
        MobileController orCreatePage = HistoryManager.Companion.getOrCreatePage(MobilePhonePage.MOBILE_PHONE_PAGE.getId());
        Intrinsics.checkNotNull(orCreatePage, "null cannot be cast to non-null type ru.mrlargha.arizonaui.mobile.presentation.MobilePhone");
        MobilePhone mobilePhone = (MobilePhone) orCreatePage;
        this.mobileChatPhone = mobilePhone;
        Activity context = mobilePhone.getContext();
        this.context = context;
        this.phoneBinding = mobilePhone.getBinding();
        this.sharedPreferences = context.getSharedPreferences(Messenger.MESSENGER_PREFS, 0);
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type ru.mrlargha.commonui.core.IBackendNotifier");
        this.frontendNotifier = (IBackendNotifier) context;
        this.token = "";
        this.requestMessage = "";
        this.isRefreshToken = true;
        View inflate = context.getLayoutInflater().inflate(R.layout.mobile_phone_messenger_chat_page, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.page = constraintLayout;
        MobilePhoneMessengerChatPageBinding bind = MobilePhoneMessengerChatPageBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.pageBinding = bind;
        Retrofit.Builder addConverterFactory = new Retrofit.Builder().baseUrl("http://messenger.arizona-five.com/messenger/").addConverterFactory(GsonConverterFactory.create());
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(null, 1, null);
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(httpLoggingInterceptor);
        Unit unit = Unit.INSTANCE;
        Retrofit build = addConverterFactory.client(builder.build()).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        this.retrofit = build;
        this.api = (MessagesApi) build.create(MessagesApi.class);
        this.startedMenuList = CollectionsKt.mutableListOf(getContactMenuItem(), new MenuChatItem(MenuId.CALL_CONTACT, ru.mrlargha.commonui.R.drawable.ic_phone_messenger, "Позвонить", -1), new MenuChatItem(MenuId.CLEAR_MESSAGES, ru.mrlargha.commonui.R.drawable.ic_clear_history_messenger, "Очистить переписку", -1), getNotificationMenuItem(), getPinMenuItem(), getBlockMenuItem());
        this.chatAdapter = new MobilePhoneMessengerChatAdapter(new Function1() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.messenger.MessengerChat$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit chatAdapter$lambda$1;
                chatAdapter$lambda$1 = MessengerChat.chatAdapter$lambda$1((MessageInfo) obj);
                return chatAdapter$lambda$1;
            }
        });
        this.menuAdapter = new MobilePhoneMessengerChatMenuAdapter(new Function1() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.messenger.MessengerChat$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit menuAdapter$lambda$2;
                menuAdapter$lambda$2 = MessengerChat.menuAdapter$lambda$2(MessengerChat.this, (MenuChatItem) obj);
                return menuAdapter$lambda$2;
            }
        });
        this.emojiAdapter = new MobilePhoneMessengerEmojiAdapter(new Function1() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.messenger.MessengerChat$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit emojiAdapter$lambda$3;
                emojiAdapter$lambda$3 = MessengerChat.emojiAdapter$lambda$3(MessengerChat.this, (EmojiItem) obj);
                return emojiAdapter$lambda$3;
            }
        });
        sendChatId();
        preparePage();
        prepareInput();
        prepareHeader();
        requestMessages();
    }

    /* compiled from: MessengerChat.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/page/messenger/MessengerChat$Companion;", "", "<init>", "()V", "TAG", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit chatAdapter$lambda$1(MessageInfo it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit menuAdapter$lambda$2(MessengerChat messengerChat, MenuChatItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        messengerChat.onClickChatMenuItem(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit emojiAdapter$lambda$3(MessengerChat messengerChat, EmojiItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        messengerChat.onClickEmoji(it);
        return Unit.INSTANCE;
    }

    private final MenuChatItem getBlockMenuItem() {
        String str;
        MenuId menuId = MenuId.BLOCK_CONTACT;
        int i = ru.mrlargha.commonui.R.drawable.ic_block_messenger;
        if (this.contactInfo.isBlockedByMe()) {
            str = "Разблокировать";
        } else {
            str = "Заблокировать";
        }
        return new MenuChatItem(menuId, i, str, Color.parseColor("#B94C4C"));
    }

    private final MenuChatItem getContactMenuItem() {
        int i;
        String str;
        MenuId menuId = MenuId.ADD_REMOVE_CONTACT;
        if (Intrinsics.areEqual((Object) this.contactInfo.isContact(), (Object) true)) {
            i = ru.mrlargha.commonui.R.drawable.ic_remove_user_messenger;
        } else {
            i = ru.mrlargha.commonui.R.drawable.ic_add_user_messenger;
        }
        if (Intrinsics.areEqual((Object) this.contactInfo.isContact(), (Object) true)) {
            str = "Убрать из контактов";
        } else {
            str = "Добавить в контакты";
        }
        return new MenuChatItem(menuId, i, str, -1);
    }

    private final MenuChatItem getPinMenuItem() {
        String str;
        MenuId menuId = MenuId.PIN_CONTACT;
        int i = ru.mrlargha.commonui.R.drawable.ic_paperclip;
        if (this.contactInfo.isAttached()) {
            str = "Убрать из избранных";
        } else {
            str = "Добавить в избранные";
        }
        return new MenuChatItem(menuId, i, str, -1);
    }

    private final MenuChatItem getNotificationMenuItem() {
        int i;
        String str;
        MenuId menuId = MenuId.NOTIFICATIONS;
        if (this.contactInfo.isNotificationsAllowed()) {
            i = ru.mrlargha.commonui.R.drawable.ic_notification_off;
        } else {
            i = ru.mrlargha.commonui.R.drawable.ic_notification_on;
        }
        if (this.contactInfo.isNotificationsAllowed()) {
            str = "Выключить уведомления";
        } else {
            str = "Включить уведомления";
        }
        return new MenuChatItem(menuId, i, str, -1);
    }

    private final void prepareInput() {
        if (this.contactInfo.m10369isBlocked()) {
            showBlockContact();
        }
        final MessengerInputFieldLayoutBinding messengerInputFieldLayoutBinding = this.pageBinding.inputFieldChatLayout;
        messengerInputFieldLayoutBinding.messageEditText.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.messenger.MessengerChat$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessengerChat.prepareInput$lambda$7$lambda$4(MessengerChat.this, messengerInputFieldLayoutBinding, view);
            }
        });
        messengerInputFieldLayoutBinding.sendBtn.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.messenger.MessengerChat$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessengerChat.prepareInput$lambda$7$lambda$5(MessengerInputFieldLayoutBinding.this, this, view);
            }
        });
        messengerInputFieldLayoutBinding.emojiBtn.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.messenger.MessengerChat$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessengerChat.prepareInput$lambda$7$lambda$6(MessengerInputFieldLayoutBinding.this, view);
            }
        });
        messengerInputFieldLayoutBinding.emojiBar.setAdapter(this.emojiAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void prepareInput$lambda$7$lambda$4(MessengerChat messengerChat, MessengerInputFieldLayoutBinding messengerInputFieldLayoutBinding, View view) {
        messengerChat.frontendNotifier.showCustomKeyboardForEditText(new InputCustomKeyboardListener(), messengerInputFieldLayoutBinding.messageEditText.getText().toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void prepareInput$lambda$7$lambda$5(MessengerInputFieldLayoutBinding messengerInputFieldLayoutBinding, MessengerChat messengerChat, View view) {
        String obj = messengerInputFieldLayoutBinding.messageEditText.getText().toString();
        if (obj.length() > 0) {
            messengerChat.sendMessage(obj);
            messengerInputFieldLayoutBinding.messageEditText.getText().clear();
            TextView messageLimitText = messengerChat.pageBinding.inputFieldChatLayout.messageLimitText;
            Intrinsics.checkNotNullExpressionValue(messageLimitText, "messageLimitText");
            messageLimitText.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void prepareInput$lambda$7$lambda$6(MessengerInputFieldLayoutBinding messengerInputFieldLayoutBinding, View view) {
        RecyclerView emojiBar = messengerInputFieldLayoutBinding.emojiBar;
        Intrinsics.checkNotNullExpressionValue(emojiBar, "emojiBar");
        RecyclerView recyclerView = emojiBar;
        RecyclerView emojiBar2 = messengerInputFieldLayoutBinding.emojiBar;
        Intrinsics.checkNotNullExpressionValue(emojiBar2, "emojiBar");
        recyclerView.setVisibility(emojiBar2.getVisibility() == 0 ? 8 : 0);
        RecyclerView emojiBar3 = messengerInputFieldLayoutBinding.emojiBar;
        Intrinsics.checkNotNullExpressionValue(emojiBar3, "emojiBar");
        if (emojiBar3.getVisibility() == 0) {
            messengerInputFieldLayoutBinding.emojiBtn.setColorFilter(Color.parseColor("#4A8EF4"));
        } else {
            messengerInputFieldLayoutBinding.emojiBtn.setColorFilter(Color.parseColor("#AAAAAA"));
        }
    }

    private final void onClickChatMenuItem(MenuChatItem menuChatItem) {
        switch (WhenMappings.$EnumSwitchMapping$0[menuChatItem.getId().ordinal()]) {
            case 1:
                contactAddOrRemove();
                return;
            case 2:
                contactCall();
                return;
            case 3:
                contactClearMessages();
                return;
            case 4:
                contactDisableNotifications();
                return;
            case 5:
                contactPin();
                return;
            case 6:
                contactBlock();
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final void onClickEmoji(EmojiItem emojiItem) {
        MessengerInputFieldLayoutBinding messengerInputFieldLayoutBinding = this.pageBinding.inputFieldChatLayout;
        int emojiWithTextLength = StringKt.emojiWithTextLength(this.pageBinding.inputFieldChatLayout.messageEditText.getText().toString()) + 8;
        if (emojiWithTextLength > 0) {
            TextView messageLimitText = this.pageBinding.inputFieldChatLayout.messageLimitText;
            Intrinsics.checkNotNullExpressionValue(messageLimitText, "messageLimitText");
            messageLimitText.setVisibility(0);
            this.pageBinding.inputFieldChatLayout.messageLimitText.setText(emojiWithTextLength + "/200");
        } else {
            TextView messageLimitText2 = this.pageBinding.inputFieldChatLayout.messageLimitText;
            Intrinsics.checkNotNullExpressionValue(messageLimitText2, "messageLimitText");
            messageLimitText2.setVisibility(8);
        }
        messengerInputFieldLayoutBinding.messageEditText.getText().append((CharSequence) StringKt.getEmojiByUnicode(emojiItem.getUnicodeAndroid()));
    }

    private final void contactCall() {
        this.frontendNotifier.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), -1, 44, getUserIdJson());
    }

    private final void prepareHeader() {
        MobilePhoneMessengerChatPageBinding mobilePhoneMessengerChatPageBinding = this.pageBinding;
        mobilePhoneMessengerChatPageBinding.headerBack.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.messenger.MessengerChat$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessengerChat.prepareHeader$lambda$11$lambda$9(MessengerChat.this, view);
            }
        });
        mobilePhoneMessengerChatPageBinding.avatar.updateData(new AvatarData(this.contactInfo.getAvatarUrl(), this.contactInfo.getStatus().getColor(), this.contactInfo.getContactBackground().getBackground(), null, 8, null));
        mobilePhoneMessengerChatPageBinding.contactName.setText(this.contactInfo.getContactName());
        mobilePhoneMessengerChatPageBinding.contactId.setText(this.contactInfo.getId() == -1 ? "В сети" : this.contactInfo.getIdText());
        mobilePhoneMessengerChatPageBinding.headerSettingsBtn.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.messenger.MessengerChat$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessengerChat.this.showChatMenu();
            }
        });
        AppCompatImageView icAttach = mobilePhoneMessengerChatPageBinding.icAttach;
        Intrinsics.checkNotNullExpressionValue(icAttach, "icAttach");
        icAttach.setVisibility(this.contactInfo.isAttached() ? 0 : 8);
        AppCompatImageView icNotificationOff = mobilePhoneMessengerChatPageBinding.icNotificationOff;
        Intrinsics.checkNotNullExpressionValue(icNotificationOff, "icNotificationOff");
        icNotificationOff.setVisibility(this.contactInfo.isNotificationsAllowed() ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void prepareHeader$lambda$11$lambda$9(MessengerChat messengerChat, View view) {
        LinearLayout root = messengerChat.pageBinding.menuChatLayout.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        if (root.getVisibility() == 0) {
            if (messengerChat.chatAdapter.getItemCount() > 0) {
                messengerChat.showChat();
                return;
            } else {
                messengerChat.showEmptyMessages();
                return;
            }
        }
        messengerChat.closeChatEvent();
        messengerChat.removePage();
        HistoryManager.Companion.getOrCreatePage(MobilePhonePage.MESSENGER_APP.getId());
    }

    private final void preparePage() {
        String string = this.sharedPreferences.getString("token", "");
        this.token = string != null ? string : "";
        this.pageBinding.chatLayout.messages.setAdapter(this.chatAdapter);
        this.pageBinding.menuChatLayout.menuList.setAdapter(this.menuAdapter);
        this.phoneBinding.phoneBackground.setBackgroundColor(Color.parseColor("#1A1A1A"));
        this.pageBinding.getRoot().setLayoutParams(new ConstraintLayout.LayoutParams(-1, -1));
        this.phoneBinding.phoneCaseContainer.addView(this.pageBinding.getRoot());
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this.phoneBinding.phoneCaseContainer);
        constraintSet.connect(this.pageBinding.getRoot().getId(), 1, this.phoneBinding.phoneCaseContainer.getId(), 1);
        constraintSet.connect(this.pageBinding.getRoot().getId(), 2, this.phoneBinding.phoneCaseContainer.getId(), 2);
        constraintSet.connect(this.pageBinding.getRoot().getId(), 3, this.phoneBinding.phoneTopBarContainer.getId(), 4);
        constraintSet.applyTo(this.phoneBinding.phoneCaseContainer);
        this.menuAdapter.addMenuItems(this.startedMenuList);
        this.emojiAdapter.addData(MobilePhoneObjectKt.getEmojiItems());
        MessengerChatLayoutBinding messengerChatLayoutBinding = this.pageBinding.chatLayout;
        RecyclerView recyclerView = messengerChatLayoutBinding.messages;
        final RecyclerView.LayoutManager layoutManager = messengerChatLayoutBinding.messages.getLayoutManager();
        recyclerView.addOnScrollListener(new PaginationScrollListener(layoutManager) { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.messenger.MessengerChat$preparePage$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(true, (LinearLayoutManager) layoutManager);
                Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            }

            @Override // ru.mrlargha.commonui.utils.recycle_view.PaginationScrollListener
            protected void loadMoreItems() {
                int i;
                MessengerChat.this.isPaginationLoading = true;
                i = MessengerChat.this.paginationPage;
                MessengerChat.this.paginationPage = i + 1;
                MessengerChat.this.loadNextPage();
            }

            @Override // ru.mrlargha.commonui.utils.recycle_view.PaginationScrollListener
            public boolean isLoading() {
                boolean z;
                z = MessengerChat.this.isPaginationLoading;
                return z;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestToken() {
        IBackendNotifier iBackendNotifier = this.frontendNotifier;
        int id = UIElementID.ARIZONA_MOBILE_PHONE.getId();
        byte[] bytes = "".getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        iBackendNotifier.clickedWrapper(id, -1, 39, bytes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadNextPage() {
        if (this.token.length() == 0) {
            return;
        }
        MessagesApi.DefaultImpls.getChatMessages$default(this.api, this.token, String.valueOf(this.contactInfo.getId()), 0, this.paginationPage, 4, null).enqueue(new Callback<List<? extends ChatMessageApiResponse>>() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.messenger.MessengerChat$loadNextPage$1
            @Override // retrofit2.Callback
            public void onResponse(Call<List<? extends ChatMessageApiResponse>> call, Response<List<? extends ChatMessageApiResponse>> response) {
                MobilePhoneMessengerChatAdapter mobilePhoneMessengerChatAdapter;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (response.code() == 401) {
                    MessengerChat.this.requestToken();
                    return;
                }
                List<? extends ChatMessageApiResponse> body = response.body();
                if (body != null) {
                    List<? extends ChatMessageApiResponse> list = body;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    for (ChatMessageApiResponse chatMessageApiResponse : list) {
                        arrayList.add(chatMessageApiResponse.toModel());
                    }
                    ArrayList arrayList2 = arrayList;
                    MessengerChat messengerChat = MessengerChat.this;
                    messengerChat.isPaginationLoading = false;
                    if (arrayList2.isEmpty()) {
                        return;
                    }
                    mobilePhoneMessengerChatAdapter = messengerChat.chatAdapter;
                    mobilePhoneMessengerChatAdapter.addMessages(arrayList2);
                    messengerChat.pageBinding.chatLayout.messages.scrollToPosition(arrayList2.size() - 1);
                }
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<List<? extends ChatMessageApiResponse>> call, Throwable error) {
                Activity activity;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(error, "error");
                activity = MessengerChat.this.context;
                Toast.makeText(activity, "Ошибка получения сообщений: " + error.getMessage(), 0).show();
                Log.e("MessengerChat", "api messages error: " + error.getMessage(), error);
            }
        });
    }

    private final void requestMessages() {
        if (this.token.length() == 0) {
            Log.e(TAG, "token is empty from shared preferences");
            return;
        }
        this.chatAdapter.clearMessages();
        showLoader();
        MessagesApi.DefaultImpls.getChatMessages$default(this.api, this.token, String.valueOf(this.contactInfo.getId()), 0, 0, 12, null).enqueue(new Callback<List<? extends ChatMessageApiResponse>>() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.messenger.MessengerChat$requestMessages$1
            @Override // retrofit2.Callback
            public void onResponse(Call<List<? extends ChatMessageApiResponse>> call, Response<List<? extends ChatMessageApiResponse>> response) {
                Activity activity;
                MobilePhoneMessengerChatAdapter mobilePhoneMessengerChatAdapter;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (!response.isSuccessful()) {
                    activity = MessengerChat.this.context;
                    Toast.makeText(activity, "Ошибка получения сообщений: " + response.message(), 0).show();
                    return;
                }
                List<? extends ChatMessageApiResponse> body = response.body();
                if (body != null) {
                    List<? extends ChatMessageApiResponse> list = body;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    for (ChatMessageApiResponse chatMessageApiResponse : list) {
                        arrayList.add(chatMessageApiResponse.toModel());
                    }
                    ArrayList arrayList2 = arrayList;
                    MessengerChat messengerChat = MessengerChat.this;
                    if (arrayList2.isEmpty()) {
                        messengerChat.showEmptyMessages();
                        return;
                    }
                    mobilePhoneMessengerChatAdapter = messengerChat.chatAdapter;
                    mobilePhoneMessengerChatAdapter.addMessages(arrayList2);
                    messengerChat.showChat();
                }
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<List<? extends ChatMessageApiResponse>> call, Throwable error) {
                Activity activity;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(error, "error");
                activity = MessengerChat.this.context;
                Toast.makeText(activity, "Ошибка получения сообщений: " + error.getMessage(), 0).show();
                Log.e("MessengerChat", "api messages error: " + error.getMessage(), error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showChatMenu() {
        MobilePhoneMessengerChatPageBinding mobilePhoneMessengerChatPageBinding = this.pageBinding;
        RelativeLayout root = mobilePhoneMessengerChatPageBinding.emptyChatLayout.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(8);
        LinearLayout root2 = mobilePhoneMessengerChatPageBinding.chatLayout.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "getRoot(...)");
        root2.setVisibility(8);
        RelativeLayout root3 = mobilePhoneMessengerChatPageBinding.loaderChatLayout.getRoot();
        Intrinsics.checkNotNullExpressionValue(root3, "getRoot(...)");
        root3.setVisibility(8);
        LinearLayout root4 = mobilePhoneMessengerChatPageBinding.menuChatLayout.getRoot();
        Intrinsics.checkNotNullExpressionValue(root4, "getRoot(...)");
        root4.setVisibility(0);
        AppCompatImageView headerSettingsBtn = mobilePhoneMessengerChatPageBinding.headerSettingsBtn;
        Intrinsics.checkNotNullExpressionValue(headerSettingsBtn, "headerSettingsBtn");
        headerSettingsBtn.setVisibility(8);
        LinearLayout root5 = mobilePhoneMessengerChatPageBinding.inputFieldChatLayout.getRoot();
        Intrinsics.checkNotNullExpressionValue(root5, "getRoot(...)");
        root5.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showEmptyMessages() {
        MobilePhoneMessengerChatPageBinding mobilePhoneMessengerChatPageBinding = this.pageBinding;
        RelativeLayout root = mobilePhoneMessengerChatPageBinding.emptyChatLayout.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(0);
        LinearLayout root2 = mobilePhoneMessengerChatPageBinding.menuChatLayout.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "getRoot(...)");
        root2.setVisibility(8);
        LinearLayout root3 = mobilePhoneMessengerChatPageBinding.chatLayout.getRoot();
        Intrinsics.checkNotNullExpressionValue(root3, "getRoot(...)");
        root3.setVisibility(8);
        AppCompatImageView headerSettingsBtn = mobilePhoneMessengerChatPageBinding.headerSettingsBtn;
        Intrinsics.checkNotNullExpressionValue(headerSettingsBtn, "headerSettingsBtn");
        headerSettingsBtn.setVisibility(0);
        RelativeLayout root4 = mobilePhoneMessengerChatPageBinding.loaderChatLayout.getRoot();
        Intrinsics.checkNotNullExpressionValue(root4, "getRoot(...)");
        root4.setVisibility(8);
        LinearLayout root5 = mobilePhoneMessengerChatPageBinding.inputFieldChatLayout.getRoot();
        Intrinsics.checkNotNullExpressionValue(root5, "getRoot(...)");
        root5.setVisibility(0);
    }

    private final void showLoader() {
        MobilePhoneMessengerChatPageBinding mobilePhoneMessengerChatPageBinding = this.pageBinding;
        RelativeLayout root = mobilePhoneMessengerChatPageBinding.loaderChatLayout.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(0);
        AppCompatImageView headerSettingsBtn = mobilePhoneMessengerChatPageBinding.headerSettingsBtn;
        Intrinsics.checkNotNullExpressionValue(headerSettingsBtn, "headerSettingsBtn");
        headerSettingsBtn.setVisibility(8);
        LinearLayout root2 = mobilePhoneMessengerChatPageBinding.chatLayout.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "getRoot(...)");
        root2.setVisibility(8);
        RelativeLayout root3 = mobilePhoneMessengerChatPageBinding.emptyChatLayout.getRoot();
        Intrinsics.checkNotNullExpressionValue(root3, "getRoot(...)");
        root3.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showChat() {
        MobilePhoneMessengerChatPageBinding mobilePhoneMessengerChatPageBinding = this.pageBinding;
        if (this.contactInfo.getId() == -1) {
            AppCompatImageView headerSettingsBtn = mobilePhoneMessengerChatPageBinding.headerSettingsBtn;
            Intrinsics.checkNotNullExpressionValue(headerSettingsBtn, "headerSettingsBtn");
            headerSettingsBtn.setVisibility(8);
        } else {
            AppCompatImageView headerSettingsBtn2 = mobilePhoneMessengerChatPageBinding.headerSettingsBtn;
            Intrinsics.checkNotNullExpressionValue(headerSettingsBtn2, "headerSettingsBtn");
            headerSettingsBtn2.setVisibility(0);
        }
        LinearLayout root = mobilePhoneMessengerChatPageBinding.chatLayout.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(0);
        LinearLayout root2 = mobilePhoneMessengerChatPageBinding.inputFieldChatLayout.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "getRoot(...)");
        root2.setVisibility(0);
        RelativeLayout root3 = mobilePhoneMessengerChatPageBinding.loaderChatLayout.getRoot();
        Intrinsics.checkNotNullExpressionValue(root3, "getRoot(...)");
        root3.setVisibility(8);
        RelativeLayout root4 = mobilePhoneMessengerChatPageBinding.emptyChatLayout.getRoot();
        Intrinsics.checkNotNullExpressionValue(root4, "getRoot(...)");
        root4.setVisibility(8);
        LinearLayout root5 = mobilePhoneMessengerChatPageBinding.menuChatLayout.getRoot();
        Intrinsics.checkNotNullExpressionValue(root5, "getRoot(...)");
        root5.setVisibility(8);
        mobilePhoneMessengerChatPageBinding.chatLayout.messages.scrollToPosition(this.chatAdapter.getItemCount() - 1);
    }

    private final void showBlockContact() {
        MessengerInputFieldLayoutBinding messengerInputFieldLayoutBinding = this.pageBinding.inputFieldChatLayout;
        LinearLayout blockUserContainer = messengerInputFieldLayoutBinding.blockUserContainer;
        Intrinsics.checkNotNullExpressionValue(blockUserContainer, "blockUserContainer");
        blockUserContainer.setVisibility(0);
        LinearLayout inputContainer = messengerInputFieldLayoutBinding.inputContainer;
        Intrinsics.checkNotNullExpressionValue(inputContainer, "inputContainer");
        inputContainer.setVisibility(8);
        if (this.contactInfo.isBlockedByMe()) {
            messengerInputFieldLayoutBinding.blockUserTitle.setText("Вы заблокировали контакт");
            messengerInputFieldLayoutBinding.blockUserDescription.setText("Пользователь не может вам написать");
            return;
        }
        messengerInputFieldLayoutBinding.blockUserTitle.setText("Вы не можете отправлять сообщения");
        messengerInputFieldLayoutBinding.blockUserDescription.setText("Пользователь ограничил доступ");
        TextView blockUserDescription = messengerInputFieldLayoutBinding.blockUserDescription;
        Intrinsics.checkNotNullExpressionValue(blockUserDescription, "blockUserDescription");
        blockUserDescription.setVisibility(this.contactInfo.getId() == -1 ? 8 : 0);
    }

    private final void showInputLayout() {
        MessengerInputFieldLayoutBinding messengerInputFieldLayoutBinding = this.pageBinding.inputFieldChatLayout;
        LinearLayout blockUserContainer = messengerInputFieldLayoutBinding.blockUserContainer;
        Intrinsics.checkNotNullExpressionValue(blockUserContainer, "blockUserContainer");
        blockUserContainer.setVisibility(8);
        LinearLayout inputContainer = messengerInputFieldLayoutBinding.inputContainer;
        Intrinsics.checkNotNullExpressionValue(inputContainer, "inputContainer");
        inputContainer.setVisibility(0);
    }

    @Override // ru.mrlargha.arizonaui.mobile.presentation.MobileController
    public void renderPage() {
        this.page.setVisibility(0);
    }

    @Override // ru.mrlargha.arizonaui.mobile.presentation.MobileController
    public void removePage() {
        HistoryManager.Companion.clearThisPage(MobilePhonePage.MESSENGER_CHAT.getId());
        this.page.removeAllViews();
    }

    private final byte[] getUserIdJson() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", this.contactInfo.getId());
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "toString(...)");
        byte[] bytes = jSONObject2.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return bytes;
    }

    private final byte[] messageIdToJson(int i) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", i);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "toString(...)");
        byte[] bytes = jSONObject2.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return bytes;
    }

    private final byte[] messageToJson(String str) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(TypedValues.TransitionType.S_TO, this.contactInfo.getId());
        jSONObject.put("text", str);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "toString(...)");
        byte[] bytes = jSONObject2.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return bytes;
    }

    private final void sendChatId() {
        this.frontendNotifier.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), -1, 53, getUserIdJson());
        Log.d("send", "open: " + getUserIdJson());
    }

    private final void sendMessage(String str) {
        this.requestMessage = StringKt.emojiToUnicodeFormat(str);
        this.frontendNotifier.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), -1, 38, messageToJson(this.requestMessage));
    }

    private final void closeChatEvent() {
        this.frontendNotifier.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), -1, 54, getUserIdJson());
        Log.d("send", "close: " + getUserIdJson());
    }

    public final void onNewMessage(int i, int i2, String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (this.contactInfo.getId() != i) {
            return;
        }
        this.chatAdapter.addMessage(new MessageInfo(i2, StringKt.unicodeFormatToEmoji(message), DateConverter.Companion.formattedTimeToday(), System.currentTimeMillis(), false, true));
        this.pageBinding.chatLayout.messages.scrollToPosition(this.chatAdapter.getItemCount() - 1);
    }

    public final void notifyContactStatus() {
        ContactInfo contactInfo = this.contactInfo;
        contactInfo.setNotificationsAllowed(!contactInfo.isNotificationsAllowed());
        int changeMenuItem = this.menuAdapter.changeMenuItem(getNotificationMenuItem());
        if (changeMenuItem != -1) {
            this.startedMenuList.set(changeMenuItem, getNotificationMenuItem());
            AppCompatImageView icNotificationOff = this.pageBinding.icNotificationOff;
            Intrinsics.checkNotNullExpressionValue(icNotificationOff, "icNotificationOff");
            icNotificationOff.setVisibility(!this.contactInfo.isNotificationsAllowed() ? 0 : 8);
        }
    }

    public final void clearMessagesStatus() {
        this.chatAdapter.clearMessages();
        showEmptyMessages();
        Toast.makeText(this.context, "Переписка очищена", 0).show();
    }

    public final void pinContactStatus() {
        ContactInfo contactInfo = this.contactInfo;
        contactInfo.setAttached(!contactInfo.isAttached());
        int changeMenuItem = this.menuAdapter.changeMenuItem(getPinMenuItem());
        if (changeMenuItem != -1) {
            this.startedMenuList.set(changeMenuItem, getPinMenuItem());
            AppCompatImageView icAttach = this.pageBinding.icAttach;
            Intrinsics.checkNotNullExpressionValue(icAttach, "icAttach");
            icAttach.setVisibility(this.contactInfo.isAttached() ? 0 : 8);
        }
    }

    public final void blockContact() {
        Boolean isBlocked = this.contactInfo.isBlocked();
        if (isBlocked != null) {
            this.contactInfo.setBlocked(Boolean.valueOf(!isBlocked.booleanValue()));
            int changeMenuItem = this.menuAdapter.changeMenuItem(getBlockMenuItem());
            if (changeMenuItem != -1) {
                this.startedMenuList.set(changeMenuItem, getBlockMenuItem());
            }
            if (this.contactInfo.m10369isBlocked()) {
                showBlockContact();
            } else {
                showInputLayout();
            }
        }
    }

    public final void addContactAction() {
        this.contactInfo.setContact(true);
        int changeMenuItem = this.menuAdapter.changeMenuItem(getContactMenuItem());
        if (changeMenuItem != -1) {
            this.startedMenuList.set(changeMenuItem, getContactMenuItem());
        }
    }

    public final void removeContactAction() {
        this.contactInfo.setContact(false);
        int changeMenuItem = this.menuAdapter.changeMenuItem(getContactMenuItem());
        if (changeMenuItem != -1) {
            this.startedMenuList.set(changeMenuItem, getContactMenuItem());
        }
    }

    public final void sendMessageSuccess() {
        if (this.requestMessage.length() > 0) {
            this.chatAdapter.addMessage(new MessageInfo(this.contactInfo.getId(), StringKt.unicodeFormatToEmoji(this.requestMessage), DateConverter.Companion.formattedTimeToday(), System.currentTimeMillis(), true, true));
            this.pageBinding.chatLayout.messages.scrollToPosition(this.chatAdapter.getItemCount() - 1);
            LinearLayout root = this.pageBinding.chatLayout.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            if (root.getVisibility() == 0) {
                return;
            }
            showChat();
        }
    }

    private final void contactAddOrRemove() {
        this.frontendNotifier.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), -1, Intrinsics.areEqual((Object) this.contactInfo.isContact(), (Object) true) ? 40 : 41, getUserIdJson());
    }

    private final void messageRemove(int i) {
        this.frontendNotifier.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), -1, 47, messageIdToJson(i));
    }

    private final void contactDisableNotifications() {
        this.frontendNotifier.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), -1, 46, getUserIdJson());
    }

    private final void contactClearMessages() {
        this.frontendNotifier.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), -1, 45, getUserIdJson());
    }

    private final void contactBlock() {
        this.frontendNotifier.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), -1, 42, getUserIdJson());
    }

    private final void contactPin() {
        this.frontendNotifier.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), -1, 43, getUserIdJson());
    }

    public final void updateDialog(int i) {
        this.dialogId = Integer.valueOf(i);
        MessagesApi.DefaultImpls.getMessage$default(this.api, this.token, Integer.valueOf(i), 0, 0, 12, null).enqueue(new Callback<List<? extends ContactApiResponse>>() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.messenger.MessengerChat$updateDialog$1
            @Override // retrofit2.Callback
            public void onResponse(Call<List<? extends ContactApiResponse>> call, Response<List<? extends ContactApiResponse>> response) {
                ContactApiResponse contactApiResponse;
                ContactInfo model;
                ContactInfo contactInfo;
                MobilePhoneMessengerChatAdapter mobilePhoneMessengerChatAdapter;
                String formatTimestamp$default;
                MobilePhoneMessengerChatAdapter mobilePhoneMessengerChatAdapter2;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                int code = response.code();
                if (code != 200) {
                    if (code != 401) {
                        return;
                    }
                    MessengerChat.this.isRefreshToken = true;
                    MessengerChat.this.requestToken();
                    return;
                }
                List<? extends ContactApiResponse> body = response.body();
                if (body == null || (contactApiResponse = (ContactApiResponse) CollectionsKt.firstOrNull((List<? extends Object>) body)) == null || (model = contactApiResponse.toModel()) == null) {
                    return;
                }
                MessengerChat messengerChat = MessengerChat.this;
                int id = model.getId();
                contactInfo = messengerChat.contactInfo;
                if (id != contactInfo.getId()) {
                    return;
                }
                mobilePhoneMessengerChatAdapter = messengerChat.chatAdapter;
                int nextInt = Random.Default.nextInt();
                String text = model.getText();
                if (model.getTimestamp() == null) {
                    formatTimestamp$default = "";
                } else {
                    DateConverter.Companion companion = DateConverter.Companion;
                    Long timestamp = model.getTimestamp();
                    Intrinsics.checkNotNull(timestamp);
                    formatTimestamp$default = DateConverter.Companion.formatTimestamp$default(companion, timestamp.longValue(), false, 2, null);
                }
                Long timestamp2 = model.getTimestamp();
                mobilePhoneMessengerChatAdapter.addMessage(new MessageInfo(nextInt, text, formatTimestamp$default, timestamp2 != null ? timestamp2.longValue() : System.currentTimeMillis(), model.isMe(), false));
                RecyclerView recyclerView = messengerChat.pageBinding.chatLayout.messages;
                mobilePhoneMessengerChatAdapter2 = messengerChat.chatAdapter;
                recyclerView.scrollToPosition(mobilePhoneMessengerChatAdapter2.getItemCount() - 1);
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<List<? extends ContactApiResponse>> call, Throwable error) {
                Activity activity;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(error, "error");
                activity = MessengerChat.this.context;
                Toast.makeText(activity, "Ошибка получения сообщения: " + error.getMessage(), 0).show();
                Log.e("MessengerChat", "api messages error: " + error.getMessage(), error);
            }
        });
    }

    public final void updateToken(String token) {
        Integer num;
        Intrinsics.checkNotNullParameter(token, "token");
        this.token = token;
        if (this.isRefreshToken && (num = this.dialogId) != null) {
            Intrinsics.checkNotNull(num);
            updateDialog(num.intValue());
        } else if (this.isPaginationLoading) {
            loadNextPage();
        } else {
            requestMessages();
        }
    }

    /* compiled from: MessengerChat.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u0012\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016¨\u0006\u0014"}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/page/messenger/MessengerChat$InputCustomKeyboardListener;", "Lru/mrlargha/commonui/elements/CustomKeyboard$InputListener;", "<init>", "(Lru/mrlargha/arizonaui/mobile/presentation/page/messenger/MessengerChat;)V", "t_OnInputEnd", "", "str", "", "t_BinderIsEmpty", "", "t_GetKeyboardHistorySize", "", "t_GetKeyboardHistoryText", FirebaseAnalytics.Param.INDEX, "t_SetChatType", "t_SetLastString", "std", "t_SetChatHeight", "height", "closeKeyboard", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final class InputCustomKeyboardListener implements CustomKeyboard.InputListener {
        @Override // ru.mrlargha.commonui.elements.CustomKeyboard.InputListener
        public void closeKeyboard() {
        }

        @Override // ru.mrlargha.commonui.elements.CustomKeyboard.InputListener
        public boolean t_BinderIsEmpty() {
            return false;
        }

        @Override // ru.mrlargha.commonui.elements.CustomKeyboard.InputListener
        public int t_GetKeyboardHistorySize() {
            return 0;
        }

        @Override // ru.mrlargha.commonui.elements.CustomKeyboard.InputListener
        public String t_GetKeyboardHistoryText(int i) {
            return null;
        }

        @Override // ru.mrlargha.commonui.elements.CustomKeyboard.InputListener
        public void t_SetChatHeight(int i) {
        }

        @Override // ru.mrlargha.commonui.elements.CustomKeyboard.InputListener
        public void t_SetChatType(int i) {
        }

        @Override // ru.mrlargha.commonui.elements.CustomKeyboard.InputListener
        public void t_SetLastString(String str) {
        }

        public InputCustomKeyboardListener() {
        }

        @Override // ru.mrlargha.commonui.elements.CustomKeyboard.InputListener
        public void t_OnInputEnd(String str) {
            MessengerChat.this.pageBinding.inputFieldChatLayout.messageEditText.setText(str);
            Integer valueOf = str != null ? Integer.valueOf(StringKt.emojiWithTextLength(str)) : null;
            if (valueOf == null || valueOf.intValue() <= 0) {
                TextView messageLimitText = MessengerChat.this.pageBinding.inputFieldChatLayout.messageLimitText;
                Intrinsics.checkNotNullExpressionValue(messageLimitText, "messageLimitText");
                messageLimitText.setVisibility(8);
                return;
            }
            TextView messageLimitText2 = MessengerChat.this.pageBinding.inputFieldChatLayout.messageLimitText;
            Intrinsics.checkNotNullExpressionValue(messageLimitText2, "messageLimitText");
            messageLimitText2.setVisibility(0);
            MessengerChat.this.pageBinding.inputFieldChatLayout.messageLimitText.setText(valueOf + "/200");
        }
    }
}
