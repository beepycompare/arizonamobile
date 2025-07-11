package ru.mrlargha.arizonaui.mobile.presentation.page.messenger;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.arizona.common.model.AvatarData;
import com.arizona.common.ui.AvatarView;
import com.arizona.launcher.model.settings.SettingsConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.databinding.MessengerMessagesLayoutBinding;
import ru.mrlargha.arizonaui.databinding.MessengerNewCorrespondenceLayoutBinding;
import ru.mrlargha.arizonaui.databinding.MessengerProfileLayoutBinding;
import ru.mrlargha.arizonaui.databinding.MobilePhoneBinding;
import ru.mrlargha.arizonaui.databinding.MobilePhoneMessengerPageBinding;
import ru.mrlargha.arizonaui.mobile.domain.enums.MobilePhonePage;
import ru.mrlargha.arizonaui.mobile.domain.obj.AvatarBackground;
import ru.mrlargha.arizonaui.mobile.domain.obj.ContactInfo;
import ru.mrlargha.arizonaui.mobile.domain.obj.SettingsInfo;
import ru.mrlargha.arizonaui.mobile.presentation.HistoryManager;
import ru.mrlargha.arizonaui.mobile.presentation.MobileController;
import ru.mrlargha.arizonaui.mobile.presentation.MobilePhone;
import ru.mrlargha.arizonaui.mobile.presentation.adapter.ColorItem;
import ru.mrlargha.arizonaui.mobile.presentation.adapter.MobilePhoneMessengerColorsAdapter;
import ru.mrlargha.arizonaui.mobile.presentation.adapter.MobilePhoneMessengerContactsAdapter;
import ru.mrlargha.arizonaui.mobile.presentation.page.messenger.Messenger;
import ru.mrlargha.arizonaui.mobile.presentation.page.messenger.api.MessagesApi;
import ru.mrlargha.arizonaui.mobile.presentation.page.messenger.api.MessengerRetrofitClient;
import ru.mrlargha.arizonaui.mobile.presentation.page.messenger.api.obj.ContactApiResponse;
import ru.mrlargha.arizonaui.mobile.presentation.page.messenger.api.obj.SettingsApiResponse;
import ru.mrlargha.arizonaui.mobile.presentation.page.messenger.api.obj.SettingsRequest;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.domain.model.MessageStatus;
import ru.mrlargha.commonui.elements.CustomKeyboard;
import ru.mrlargha.commonui.utils.StringKt;
import ru.mrlargha.commonui.utils.recycle_view.PaginationScrollListener;
/* compiled from: Messenger.kt */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 V2\u00020\u00012\u00020\u0002:\u0003VWXB\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0004H\u0002J\b\u0010-\u001a\u00020.H\u0002J\u0012\u0010/\u001a\u00020.2\b\u00100\u001a\u0004\u0018\u00010\fH\u0002J\b\u00101\u001a\u00020.H\u0002J\b\u00102\u001a\u00020.H\u0002J\b\u00103\u001a\u00020.H\u0002J\b\u00104\u001a\u00020.H\u0002J\b\u00105\u001a\u00020.H\u0002J\b\u00106\u001a\u00020.H\u0002J\u0018\u00107\u001a\u00020.2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\tH\u0016J\b\u0010;\u001a\u00020.H\u0002J!\u0010<\u001a\u00020.2\u0006\u0010\u0018\u001a\u00020\f2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0002\u0010>J\b\u0010?\u001a\u00020.H\u0002J\u0010\u0010@\u001a\u00020.2\u0006\u0010A\u001a\u00020BH\u0002J\b\u0010C\u001a\u00020.H\u0002J\b\u0010D\u001a\u00020.H\u0002J\b\u0010E\u001a\u00020.H\u0002J\b\u0010F\u001a\u00020.H\u0002J\u0010\u0010G\u001a\u00020.2\u0006\u0010\u001b\u001a\u00020&H\u0002J\b\u0010H\u001a\u00020.H\u0016J\b\u0010I\u001a\u00020.H\u0016J\u0006\u0010J\u001a\u00020.J\u000e\u0010K\u001a\u00020.2\u0006\u0010L\u001a\u00020MJ\u0010\u0010N\u001a\u00020.2\u0006\u0010L\u001a\u00020MH\u0002J\u000e\u0010O\u001a\u00020.2\u0006\u0010\u0018\u001a\u00020\fJ\u0006\u0010P\u001a\u00020.J\u0006\u0010Q\u001a\u00020.J\u0016\u0010R\u001a\u00020.2\u0006\u0010S\u001a\u00020\u00042\u0006\u0010T\u001a\u00020\fJ\u000e\u0010U\u001a\u00020.2\u0006\u0010=\u001a\u00020\u0004R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\n \u0015*\u0004\u0018\u00010\u001e0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Y"}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/page/messenger/Messenger;", "Lru/mrlargha/arizonaui/mobile/presentation/MobileController;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "notificationMessageId", "", "<init>", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "isPaginationLoading", "", "paginationPage", "searchNickname", "", "mobilePhone", "Lru/mrlargha/arizonaui/mobile/presentation/MobilePhone;", "context", "Landroid/app/Activity;", "phoneBinding", "Lru/mrlargha/arizonaui/databinding/MobilePhoneBinding;", "sharedPreferences", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "frontendNotifier", "Lru/mrlargha/commonui/core/IBackendNotifier;", "token", "userIdForAddContact", "isRefreshToken", "page", "Landroidx/constraintlayout/widget/ConstraintLayout;", "api", "Lru/mrlargha/arizonaui/mobile/presentation/page/messenger/api/MessagesApi;", "pageBinding", "Lru/mrlargha/arizonaui/databinding/MobilePhoneMessengerPageBinding;", "contactsAdapter", "Lru/mrlargha/arizonaui/mobile/presentation/adapter/MobilePhoneMessengerContactsAdapter;", "colorsAdapter", "Lru/mrlargha/arizonaui/mobile/presentation/adapter/MobilePhoneMessengerColorsAdapter;", "currentPage", "Lru/mrlargha/arizonaui/mobile/presentation/page/messenger/Messenger$Page;", "previousPage", "currentSettings", "Lru/mrlargha/arizonaui/mobile/presentation/page/messenger/api/obj/SettingsRequest;", "getUserIdJson", "", "id", "loadNextPage", "", "requestContacts", SettingsConstants.NICKNAME, "showMessagesLoader", "showContacts", "showEmptySearchedContacts", "openChatEvent", "requestToken", "prepareSettings", "onCheckedChanged", "buttonView", "Landroid/widget/CompoundButton;", "isChecked", "preparePage", "loadChats", "dialogId", "(Ljava/lang/String;Ljava/lang/Integer;)V", "loadSettings", "updateSettingsInfo", "settings", "Lru/mrlargha/arizonaui/mobile/domain/obj/SettingsInfo;", "setupEmptyPages", "setupNewCorrespondencePage", "setupMessagesPage", "prepareHeader", "updatePage", "renderPage", "removePage", "contactSettingsUpdate", "onOpenNewChat", "contactInfo", "Lru/mrlargha/arizonaui/mobile/domain/obj/ContactInfo;", "contactAddOrRemove", "addToken", "addContactAction", "removeContactAction", "onNewMessage", "userId", "newMessage", "updateDialog", "Companion", "Page", "InputCustomKeyboardListener", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Messenger implements MobileController, CompoundButton.OnCheckedChangeListener {
    public static final Companion Companion = new Companion(null);
    public static final int JWT_EXPIRED = 401;
    public static final String MESSENGER_PREFS = "messenger";
    private static final int MIN_SYMBOLS_SEARCH = 3;
    public static final String TAG = "Messenger";
    public static final String TOKEN_PREFS = "token";
    private final MessagesApi api;
    private final MobilePhoneMessengerColorsAdapter colorsAdapter;
    private final MobilePhoneMessengerContactsAdapter contactsAdapter;
    private final Activity context;
    private Page currentPage;
    private SettingsRequest currentSettings;
    private final IBackendNotifier frontendNotifier;
    private boolean isPaginationLoading;
    private boolean isRefreshToken;
    private final MobilePhone mobilePhone;
    private Integer notificationMessageId;
    private final ConstraintLayout page;
    private final MobilePhoneMessengerPageBinding pageBinding;
    private final MobilePhoneBinding phoneBinding;
    private Page previousPage;
    private final SharedPreferences sharedPreferences;
    private String token;
    private int userIdForAddContact;
    private int paginationPage = 1;
    private String searchNickname = "";

    /* compiled from: Messenger.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Page.values().length];
            try {
                iArr[Page.MESSAGES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Page.MY_CONTACTS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Page.CONTACTS_SEARCH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Page.EMPTY_MESSAGES.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Page.SETTINGS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Page.EMPTY_CONTACTS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[Page.NEW_CORRESPONDENCE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[Page.LOADING.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final void contactSettingsUpdate() {
    }

    public Messenger(Integer num) {
        this.notificationMessageId = num;
        MobileController orCreatePage = HistoryManager.Companion.getOrCreatePage(MobilePhonePage.MOBILE_PHONE_PAGE.getId());
        Intrinsics.checkNotNull(orCreatePage, "null cannot be cast to non-null type ru.mrlargha.arizonaui.mobile.presentation.MobilePhone");
        MobilePhone mobilePhone = (MobilePhone) orCreatePage;
        this.mobilePhone = mobilePhone;
        Activity context = mobilePhone.getContext();
        this.context = context;
        this.phoneBinding = mobilePhone.getBinding();
        this.sharedPreferences = context.getSharedPreferences(MESSENGER_PREFS, 0);
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type ru.mrlargha.commonui.core.IBackendNotifier");
        this.frontendNotifier = (IBackendNotifier) context;
        this.token = "";
        this.userIdForAddContact = -1;
        View inflate = context.getLayoutInflater().inflate(R.layout.mobile_phone_messenger_page, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.page = constraintLayout;
        this.api = MessengerRetrofitClient.INSTANCE.getApi();
        MobilePhoneMessengerPageBinding bind = MobilePhoneMessengerPageBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.pageBinding = bind;
        this.contactsAdapter = new MobilePhoneMessengerContactsAdapter(new Function1() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.messenger.Messenger$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit contactsAdapter$lambda$0;
                contactsAdapter$lambda$0 = Messenger.contactsAdapter$lambda$0(Messenger.this, (ContactInfo) obj);
                return contactsAdapter$lambda$0;
            }
        }, new Function1() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.messenger.Messenger$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit contactsAdapter$lambda$1;
                contactsAdapter$lambda$1 = Messenger.contactsAdapter$lambda$1(Messenger.this, (ContactInfo) obj);
                return contactsAdapter$lambda$1;
            }
        });
        this.colorsAdapter = new MobilePhoneMessengerColorsAdapter(new Function1() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.messenger.Messenger$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit colorsAdapter$lambda$3;
                colorsAdapter$lambda$3 = Messenger.colorsAdapter$lambda$3(Messenger.this, (ColorItem) obj);
                return colorsAdapter$lambda$3;
            }
        });
        this.currentPage = Page.LOADING;
        this.previousPage = Page.LOADING;
        this.currentSettings = new SettingsRequest(0, 0, 3, null);
        this.isRefreshToken = false;
        preparePage();
        prepareHeader();
        prepareSettings();
        setupEmptyPages();
        setupNewCorrespondencePage();
        setupMessagesPage();
        requestToken();
    }

    /* compiled from: Messenger.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/page/messenger/Messenger$Companion;", "", "<init>", "()V", "MESSENGER_PREFS", "", "TOKEN_PREFS", "MIN_SYMBOLS_SEARCH", "", "TAG", "JWT_EXPIRED", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit contactsAdapter$lambda$1(Messenger messenger, ContactInfo it) {
        Intrinsics.checkNotNullParameter(it, "it");
        messenger.contactAddOrRemove(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit contactsAdapter$lambda$0(Messenger messenger, ContactInfo it) {
        Intrinsics.checkNotNullParameter(it, "it");
        messenger.onOpenNewChat(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit colorsAdapter$lambda$3(Messenger messenger, ColorItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        messenger.pageBinding.settingsLayout.avatar.updateBackgroundColor(it.getColor().getBackground());
        messenger.currentSettings = SettingsRequest.copy$default(messenger.currentSettings, it.getColor().ordinal(), 0, 2, null);
        Log.d("okhttp.OkHttpClient", "[MobilePhoneMessengerColorsAdapter] click");
        IBackendNotifier iBackendNotifier = messenger.frontendNotifier;
        int id = UIElementID.ARIZONA_MOBILE_PHONE.getId();
        byte[] bytes = StringKt.toStringJson(messenger.currentSettings).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        iBackendNotifier.clickedWrapper(id, -1, 48, bytes);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: Messenger.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/page/messenger/Messenger$Page;", "", "page", "", "title", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getPage", "()I", "getTitle", "()Ljava/lang/String;", "EMPTY_MESSAGES", "EMPTY_CONTACTS", "MESSAGES", "NEW_CORRESPONDENCE", "CONTACTS_SEARCH", "MY_CONTACTS", "LOADING", "SETTINGS", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Page {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Page[] $VALUES;
        private final int page;
        private final String title;
        public static final Page EMPTY_MESSAGES = new Page("EMPTY_MESSAGES", 0, R.id.empty_messages_layout, "Сообщения");
        public static final Page EMPTY_CONTACTS = new Page("EMPTY_CONTACTS", 1, R.id.empty_contacts_layout, "Контакты");
        public static final Page MESSAGES = new Page("MESSAGES", 2, R.id.messages_layout, "Сообщения");
        public static final Page NEW_CORRESPONDENCE = new Page("NEW_CORRESPONDENCE", 3, R.id.new_correspondence_layout, "Сообщения");
        public static final Page CONTACTS_SEARCH = new Page("CONTACTS_SEARCH", 4, R.id.messages_layout, "Поиск");
        public static final Page MY_CONTACTS = new Page("MY_CONTACTS", 5, R.id.messages_layout, "Контакты");
        public static final Page LOADING = new Page("LOADING", 6, R.id.loading_layout, "Сообщения");
        public static final Page SETTINGS = new Page("SETTINGS", 7, R.id.settings_layout, "Настройки");

        private static final /* synthetic */ Page[] $values() {
            return new Page[]{EMPTY_MESSAGES, EMPTY_CONTACTS, MESSAGES, NEW_CORRESPONDENCE, CONTACTS_SEARCH, MY_CONTACTS, LOADING, SETTINGS};
        }

        public static EnumEntries<Page> getEntries() {
            return $ENTRIES;
        }

        public static Page valueOf(String str) {
            return (Page) Enum.valueOf(Page.class, str);
        }

        public static Page[] values() {
            return (Page[]) $VALUES.clone();
        }

        private Page(String str, int i, int i2, String str2) {
            this.page = i2;
            this.title = str2;
        }

        public final int getPage() {
            return this.page;
        }

        public final String getTitle() {
            return this.title;
        }

        static {
            Page[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    private final byte[] getUserIdJson(int i) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", i);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "toString(...)");
        byte[] bytes = jSONObject2.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return bytes;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadNextPage() {
        if (this.token.length() == 0 || this.searchNickname.length() == 0) {
            return;
        }
        MessagesApi.findContact$default(this.api, this.token, this.searchNickname, 0, this.paginationPage, 4, null).enqueue(new Callback<List<? extends ContactApiResponse>>() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.messenger.Messenger$loadNextPage$1
            @Override // retrofit2.Callback
            public void onResponse(Call<List<? extends ContactApiResponse>> call, Response<List<? extends ContactApiResponse>> response) {
                MobilePhoneMessengerContactsAdapter mobilePhoneMessengerContactsAdapter;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                List<? extends ContactApiResponse> body = response.body();
                if (body != null) {
                    List<? extends ContactApiResponse> list = body;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    for (ContactApiResponse contactApiResponse : list) {
                        arrayList.add(contactApiResponse.toModel());
                    }
                    ArrayList arrayList2 = arrayList;
                    Messenger messenger = Messenger.this;
                    messenger.isPaginationLoading = false;
                    if (arrayList2.isEmpty()) {
                        return;
                    }
                    mobilePhoneMessengerContactsAdapter = messenger.contactsAdapter;
                    mobilePhoneMessengerContactsAdapter.addData(arrayList2);
                }
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<List<? extends ContactApiResponse>> call, Throwable error) {
                Activity activity;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(error, "error");
                activity = Messenger.this.context;
                Toast.makeText(activity, "Ошибка получения контактов: " + error.getMessage(), 0).show();
                Log.e(Messenger.TAG, "get messages error: " + error.getMessage(), error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestContacts(String str) {
        if (this.token.length() == 0) {
            return;
        }
        this.contactsAdapter.clearData();
        showMessagesLoader();
        if (str != null) {
            this.searchNickname = str;
        }
        MessagesApi.findContact$default(this.api, this.token, str, 0, this.paginationPage, 4, null).enqueue(new Callback<List<? extends ContactApiResponse>>() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.messenger.Messenger$requestContacts$2
            @Override // retrofit2.Callback
            public void onResponse(Call<List<? extends ContactApiResponse>> call, Response<List<? extends ContactApiResponse>> response) {
                MobilePhoneMessengerContactsAdapter mobilePhoneMessengerContactsAdapter;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                List<? extends ContactApiResponse> body = response.body();
                if (body != null) {
                    List<? extends ContactApiResponse> list = body;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    for (ContactApiResponse contactApiResponse : list) {
                        arrayList.add(contactApiResponse.toModel());
                    }
                    ArrayList arrayList2 = arrayList;
                    Messenger messenger = Messenger.this;
                    if (arrayList2.isEmpty()) {
                        if (messenger.currentPage == Messenger.Page.MY_CONTACTS) {
                            messenger.updatePage(Messenger.Page.EMPTY_CONTACTS);
                            return;
                        } else {
                            messenger.showEmptySearchedContacts();
                            return;
                        }
                    }
                    messenger.showContacts();
                    mobilePhoneMessengerContactsAdapter = messenger.contactsAdapter;
                    mobilePhoneMessengerContactsAdapter.addData(arrayList2);
                }
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<List<? extends ContactApiResponse>> call, Throwable error) {
                Activity activity;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(error, "error");
                activity = Messenger.this.context;
                Toast.makeText(activity, "Ошибка получения контактов: " + error.getMessage(), 0).show();
                Log.e(Messenger.TAG, "get messages error: " + error.getMessage(), error);
            }
        });
    }

    private final void showMessagesLoader() {
        MessengerMessagesLayoutBinding messengerMessagesLayoutBinding = this.pageBinding.messagesLayout;
        RecyclerView listMessages = messengerMessagesLayoutBinding.listMessages;
        Intrinsics.checkNotNullExpressionValue(listMessages, "listMessages");
        listMessages.setVisibility(8);
        LinearLayout emptySearchContainer = messengerMessagesLayoutBinding.emptySearchContainer;
        Intrinsics.checkNotNullExpressionValue(emptySearchContainer, "emptySearchContainer");
        emptySearchContainer.setVisibility(8);
        LinearLayout loaderContainer = messengerMessagesLayoutBinding.loaderContainer;
        Intrinsics.checkNotNullExpressionValue(loaderContainer, "loaderContainer");
        loaderContainer.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showContacts() {
        MessengerMessagesLayoutBinding messengerMessagesLayoutBinding = this.pageBinding.messagesLayout;
        RecyclerView listMessages = messengerMessagesLayoutBinding.listMessages;
        Intrinsics.checkNotNullExpressionValue(listMessages, "listMessages");
        listMessages.setVisibility(0);
        LinearLayout emptySearchContainer = messengerMessagesLayoutBinding.emptySearchContainer;
        Intrinsics.checkNotNullExpressionValue(emptySearchContainer, "emptySearchContainer");
        emptySearchContainer.setVisibility(8);
        LinearLayout loaderContainer = messengerMessagesLayoutBinding.loaderContainer;
        Intrinsics.checkNotNullExpressionValue(loaderContainer, "loaderContainer");
        loaderContainer.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showEmptySearchedContacts() {
        MessengerMessagesLayoutBinding messengerMessagesLayoutBinding = this.pageBinding.messagesLayout;
        LinearLayout loaderContainer = messengerMessagesLayoutBinding.loaderContainer;
        Intrinsics.checkNotNullExpressionValue(loaderContainer, "loaderContainer");
        loaderContainer.setVisibility(8);
        RecyclerView listMessages = messengerMessagesLayoutBinding.listMessages;
        Intrinsics.checkNotNullExpressionValue(listMessages, "listMessages");
        listMessages.setVisibility(8);
        LinearLayout emptySearchContainer = messengerMessagesLayoutBinding.emptySearchContainer;
        Intrinsics.checkNotNullExpressionValue(emptySearchContainer, "emptySearchContainer");
        emptySearchContainer.setVisibility(0);
    }

    private final void openChatEvent() {
        IBackendNotifier iBackendNotifier = this.frontendNotifier;
        int id = UIElementID.ARIZONA_MOBILE_PHONE.getId();
        byte[] bytes = "".getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        iBackendNotifier.clickedWrapper(id, -1, 53, bytes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestToken() {
        IBackendNotifier iBackendNotifier = this.frontendNotifier;
        int id = UIElementID.ARIZONA_MOBILE_PHONE.getId();
        byte[] bytes = "".getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        iBackendNotifier.clickedWrapper(id, -1, 39, bytes);
    }

    private final void prepareSettings() {
        MessengerProfileLayoutBinding messengerProfileLayoutBinding = this.pageBinding.settingsLayout;
        messengerProfileLayoutBinding.colorsRv.setAdapter(this.colorsAdapter);
        MobilePhoneMessengerColorsAdapter mobilePhoneMessengerColorsAdapter = this.colorsAdapter;
        EnumEntries<AvatarBackground> entries = AvatarBackground.getEntries();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(entries, 10));
        for (AvatarBackground avatarBackground : entries) {
            arrayList.add(new ColorItem(avatarBackground, false));
        }
        mobilePhoneMessengerColorsAdapter.addData(arrayList);
        messengerProfileLayoutBinding.notificationSwitch.setOnCheckedChangeListener(this);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton buttonView, boolean z) {
        Intrinsics.checkNotNullParameter(buttonView, "buttonView");
        this.currentSettings = SettingsRequest.copy$default(this.currentSettings, 0, z ? 1 : 0, 1, null);
        IBackendNotifier iBackendNotifier = this.frontendNotifier;
        int id = UIElementID.ARIZONA_MOBILE_PHONE.getId();
        byte[] bytes = StringKt.toStringJson(this.currentSettings).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        iBackendNotifier.clickedWrapper(id, -1, 48, bytes);
    }

    private final void preparePage() {
        HistoryManager.Companion.push(MobilePhonePage.MESSENGER_APP.getId());
        this.phoneBinding.phoneBackground.setBackgroundColor(Color.parseColor("#1A1A1A"));
        this.pageBinding.getRoot().setLayoutParams(new ConstraintLayout.LayoutParams(-1, -1));
        this.phoneBinding.phoneCaseContainer.addView(this.pageBinding.getRoot());
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this.phoneBinding.phoneCaseContainer);
        constraintSet.connect(this.pageBinding.getRoot().getId(), 1, this.phoneBinding.phoneCaseContainer.getId(), 1);
        constraintSet.connect(this.pageBinding.getRoot().getId(), 2, this.phoneBinding.phoneCaseContainer.getId(), 2);
        constraintSet.connect(this.pageBinding.getRoot().getId(), 3, this.phoneBinding.phoneTopBarContainer.getId(), 4);
        constraintSet.applyTo(this.phoneBinding.phoneCaseContainer);
    }

    static /* synthetic */ void loadChats$default(Messenger messenger, String str, Integer num, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        messenger.loadChats(str, num);
    }

    private final void loadChats(String str, final Integer num) {
        MessagesApi.getMessages$default(this.api, str, 0, 0, null, 14, null).enqueue(new Callback<List<? extends ContactApiResponse>>() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.messenger.Messenger$loadChats$1
            @Override // retrofit2.Callback
            public void onResponse(Call<List<? extends ContactApiResponse>> call, Response<List<? extends ContactApiResponse>> response) {
                MobilePhoneMessengerContactsAdapter mobilePhoneMessengerContactsAdapter;
                MobilePhoneMessengerContactsAdapter mobilePhoneMessengerContactsAdapter2;
                Integer num2;
                Object obj;
                Integer num3;
                MobilePhoneMessengerContactsAdapter mobilePhoneMessengerContactsAdapter3;
                Activity activity;
                MobilePhoneMessengerContactsAdapter mobilePhoneMessengerContactsAdapter4;
                MobilePhoneMessengerContactsAdapter mobilePhoneMessengerContactsAdapter5;
                Activity activity2;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                int code = response.code();
                if (code != 200) {
                    if (code != 401) {
                        activity2 = Messenger.this.context;
                        Toast.makeText(activity2, "Ошибка получения сообщений: " + response.message(), 0).show();
                        return;
                    }
                    Messenger.this.isRefreshToken = true;
                    Messenger.this.requestToken();
                    return;
                }
                List<? extends ContactApiResponse> body = response.body();
                if (body != null) {
                    List<? extends ContactApiResponse> list = body;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    for (ContactApiResponse contactApiResponse : list) {
                        arrayList.add(contactApiResponse.toModel());
                    }
                    ArrayList arrayList2 = arrayList;
                    Integer num4 = num;
                    Messenger messenger = Messenger.this;
                    if (num4 != null) {
                        mobilePhoneMessengerContactsAdapter3 = messenger.contactsAdapter;
                        Iterator<ContactInfo> it = mobilePhoneMessengerContactsAdapter3.getContacts().iterator();
                        int i = 0;
                        while (true) {
                            if (!it.hasNext()) {
                                i = -1;
                                break;
                            }
                            int id = it.next().getId();
                            if (num4 != null && id == num4.intValue()) {
                                break;
                            }
                            i++;
                        }
                        if (i != -1) {
                            mobilePhoneMessengerContactsAdapter5 = messenger.contactsAdapter;
                            mobilePhoneMessengerContactsAdapter5.updateData(i, (ContactInfo) arrayList2.get(i));
                            return;
                        }
                        Iterator it2 = arrayList2.iterator();
                        int i2 = 0;
                        while (true) {
                            if (!it2.hasNext()) {
                                i2 = -1;
                                break;
                            }
                            int id2 = ((ContactInfo) it2.next()).getId();
                            if (num4 != null && id2 == num4.intValue()) {
                                break;
                            }
                            i2++;
                        }
                        if (i2 != -1) {
                            mobilePhoneMessengerContactsAdapter4 = messenger.contactsAdapter;
                            mobilePhoneMessengerContactsAdapter4.updateNewData((ContactInfo) arrayList2.get(i2));
                            return;
                        }
                        activity = messenger.context;
                        Toast.makeText(activity, "Произошла ошибка добавления нового диалога", 0).show();
                        return;
                    }
                    mobilePhoneMessengerContactsAdapter = messenger.contactsAdapter;
                    mobilePhoneMessengerContactsAdapter.clearData();
                    if (arrayList2.isEmpty()) {
                        messenger.updatePage(Messenger.Page.EMPTY_MESSAGES);
                        return;
                    }
                    mobilePhoneMessengerContactsAdapter2 = messenger.contactsAdapter;
                    mobilePhoneMessengerContactsAdapter2.addData(arrayList2);
                    messenger.updatePage(Messenger.Page.MESSAGES);
                    num2 = messenger.notificationMessageId;
                    if (num2 != null) {
                        Iterator it3 = arrayList2.iterator();
                        while (true) {
                            if (!it3.hasNext()) {
                                obj = null;
                                break;
                            }
                            obj = it3.next();
                            int id3 = ((ContactInfo) obj).getId();
                            num3 = messenger.notificationMessageId;
                            if (num3 != null && id3 == num3.intValue()) {
                                break;
                            }
                        }
                        ContactInfo contactInfo = (ContactInfo) obj;
                        if (contactInfo != null) {
                            messenger.onOpenNewChat(contactInfo);
                        }
                        messenger.notificationMessageId = null;
                    }
                }
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<List<? extends ContactApiResponse>> call, Throwable error) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(error, "error");
                Log.e(Messenger.TAG, "get messages error: " + error.getMessage(), error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadSettings() {
        this.api.getSettings(this.token).enqueue(new Callback<SettingsApiResponse>() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.messenger.Messenger$loadSettings$1
            @Override // retrofit2.Callback
            public void onResponse(Call<SettingsApiResponse> call, Response<SettingsApiResponse> response) {
                Activity activity;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (!response.isSuccessful()) {
                    activity = Messenger.this.context;
                    Toast.makeText(activity, "Ошибка получения настроек: " + response.message(), 0).show();
                    Log.e(Messenger.TAG, "get get settings error: " + response.message());
                    return;
                }
                SettingsApiResponse body = response.body();
                if (body != null) {
                    Messenger messenger = Messenger.this;
                    messenger.updatePage(Messenger.Page.SETTINGS);
                    messenger.updateSettingsInfo(body.toModel());
                }
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<SettingsApiResponse> call, Throwable error) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(error, "error");
                Log.e(Messenger.TAG, "get settings error: " + error.getMessage(), error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSettingsInfo(SettingsInfo settingsInfo) {
        MessengerProfileLayoutBinding messengerProfileLayoutBinding = this.pageBinding.settingsLayout;
        messengerProfileLayoutBinding.name.setText(settingsInfo.getName());
        if (settingsInfo.getPhone() != null) {
            TextView phone = messengerProfileLayoutBinding.phone;
            Intrinsics.checkNotNullExpressionValue(phone, "phone");
            phone.setVisibility(0);
            messengerProfileLayoutBinding.phone.setText(settingsInfo.getPhone());
        } else {
            TextView phone2 = messengerProfileLayoutBinding.phone;
            Intrinsics.checkNotNullExpressionValue(phone2, "phone");
            phone2.setVisibility(8);
        }
        messengerProfileLayoutBinding.avatar.updateData(new AvatarData(settingsInfo.getAvatarUrl(), MessageStatus.ONLINE.getColor(), settingsInfo.getAvatarBackground().getBackground(), AvatarView.ScaleType.BIG));
        messengerProfileLayoutBinding.notificationSwitch.setOnCheckedChangeListener(null);
        messengerProfileLayoutBinding.notificationSwitch.setChecked(settingsInfo.isNotificationsEnabled());
        messengerProfileLayoutBinding.notificationSwitch.setOnCheckedChangeListener(this);
        this.colorsAdapter.selectColor(settingsInfo.getAvatarBackground().ordinal());
    }

    private final void setupEmptyPages() {
        this.pageBinding.emptyMessagesLayout.buttonNewChat.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.messenger.Messenger$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Messenger.setupEmptyPages$lambda$13$lambda$12(Messenger.this, view);
            }
        });
        this.pageBinding.emptyContactsLayout.buttonNewChat.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.messenger.Messenger$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Messenger.setupEmptyPages$lambda$15$lambda$14(Messenger.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupEmptyPages$lambda$13$lambda$12(Messenger messenger, View view) {
        messenger.updatePage(Page.NEW_CORRESPONDENCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupEmptyPages$lambda$15$lambda$14(Messenger messenger, View view) {
        messenger.updatePage(Page.NEW_CORRESPONDENCE);
    }

    private final void setupNewCorrespondencePage() {
        MessengerNewCorrespondenceLayoutBinding messengerNewCorrespondenceLayoutBinding = this.pageBinding.newCorrespondenceLayout;
        messengerNewCorrespondenceLayoutBinding.addFromContactsContainer.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.messenger.Messenger$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Messenger.setupNewCorrespondencePage$lambda$18$lambda$16(Messenger.this, view);
            }
        });
        messengerNewCorrespondenceLayoutBinding.findByNumberContainer.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.messenger.Messenger$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Messenger.setupNewCorrespondencePage$lambda$18$lambda$17(Messenger.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNewCorrespondencePage$lambda$18$lambda$16(Messenger messenger, View view) {
        messenger.updatePage(Page.MY_CONTACTS);
        messenger.pageBinding.messagesLayout.searchEditText.setText("");
        messenger.showMessagesLoader();
        messenger.requestContacts(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNewCorrespondencePage$lambda$18$lambda$17(Messenger messenger, View view) {
        messenger.contactsAdapter.clearData();
        messenger.pageBinding.messagesLayout.searchEditText.setText("");
        messenger.showContacts();
        messenger.updatePage(Page.CONTACTS_SEARCH);
    }

    private final void setupMessagesPage() {
        MessengerMessagesLayoutBinding messengerMessagesLayoutBinding = this.pageBinding.messagesLayout;
        messengerMessagesLayoutBinding.listMessages.setAdapter(this.contactsAdapter);
        RecyclerView recyclerView = messengerMessagesLayoutBinding.listMessages;
        final RecyclerView.LayoutManager layoutManager = messengerMessagesLayoutBinding.listMessages.getLayoutManager();
        recyclerView.addOnScrollListener(new PaginationScrollListener(layoutManager) { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.messenger.Messenger$setupMessagesPage$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(false, (LinearLayoutManager) layoutManager);
                Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            }

            @Override // ru.mrlargha.commonui.utils.recycle_view.PaginationScrollListener
            protected void loadMoreItems() {
                int i;
                if (Messenger.this.currentPage == Messenger.Page.CONTACTS_SEARCH) {
                    Messenger.this.isPaginationLoading = true;
                    Messenger messenger = Messenger.this;
                    i = messenger.paginationPage;
                    messenger.paginationPage = i + 1;
                    Messenger.this.loadNextPage();
                }
            }

            @Override // ru.mrlargha.commonui.utils.recycle_view.PaginationScrollListener
            public boolean isLoading() {
                boolean z;
                z = Messenger.this.isPaginationLoading;
                return z;
            }
        });
        RecyclerView.ItemAnimator itemAnimator = messengerMessagesLayoutBinding.listMessages.getItemAnimator();
        Intrinsics.checkNotNull(itemAnimator, "null cannot be cast to non-null type androidx.recyclerview.widget.SimpleItemAnimator");
        ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
        messengerMessagesLayoutBinding.searchEditText.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.messenger.Messenger$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Messenger.setupMessagesPage$lambda$20$lambda$19(Messenger.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupMessagesPage$lambda$20$lambda$19(Messenger messenger, View view) {
        messenger.frontendNotifier.showCustomKeyboardForEditText(new InputCustomKeyboardListener(), "");
    }

    private final void prepareHeader() {
        MobilePhoneMessengerPageBinding mobilePhoneMessengerPageBinding = this.pageBinding;
        mobilePhoneMessengerPageBinding.headerBack.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.messenger.Messenger$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Messenger.prepareHeader$lambda$24$lambda$21(Messenger.this, view);
            }
        });
        mobilePhoneMessengerPageBinding.headerSettingsBtn.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.messenger.Messenger$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Messenger.this.loadSettings();
            }
        });
        mobilePhoneMessengerPageBinding.headerAddBtn.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.messenger.Messenger$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Messenger.prepareHeader$lambda$24$lambda$23(Messenger.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void prepareHeader$lambda$24$lambda$21(Messenger messenger, View view) {
        if (messenger.currentPage == Page.MESSAGES || messenger.currentPage == Page.EMPTY_MESSAGES) {
            HistoryManager.Companion.clearAllHistory();
            HistoryManager.Companion.clearThisPage(MobilePhonePage.MESSENGER_APP.getId());
            HistoryManager.Companion.clearThisPage(MobilePhonePage.MESSENGER_CHAT.getId());
            messenger.page.removeAllViews();
            HistoryManager.Companion.getOrCreatePage(0);
            return;
        }
        if (messenger.previousPage == Page.MESSAGES) {
            loadChats$default(messenger, messenger.token, null, 2, null);
        }
        messenger.updatePage(messenger.previousPage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void prepareHeader$lambda$24$lambda$23(Messenger messenger, View view) {
        messenger.updatePage(Page.NEW_CORRESPONDENCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updatePage(Page page) {
        this.paginationPage = 1;
        this.pageBinding.headerTitle.setText(page.getTitle());
        LinearLayout root = this.pageBinding.messagesLayout.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(page == Page.MESSAGES || page == Page.CONTACTS_SEARCH || page == Page.MY_CONTACTS ? 0 : 8);
        RelativeLayout root2 = this.pageBinding.emptyMessagesLayout.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "getRoot(...)");
        root2.setVisibility(page == Page.EMPTY_MESSAGES ? 0 : 8);
        RelativeLayout root3 = this.pageBinding.emptyContactsLayout.getRoot();
        Intrinsics.checkNotNullExpressionValue(root3, "getRoot(...)");
        root3.setVisibility(page == Page.EMPTY_CONTACTS ? 0 : 8);
        RelativeLayout root4 = this.pageBinding.newCorrespondenceLayout.getRoot();
        Intrinsics.checkNotNullExpressionValue(root4, "getRoot(...)");
        root4.setVisibility(page == Page.NEW_CORRESPONDENCE ? 0 : 8);
        RelativeLayout root5 = this.pageBinding.loadingLayout.getRoot();
        Intrinsics.checkNotNullExpressionValue(root5, "getRoot(...)");
        root5.setVisibility(page == Page.LOADING ? 0 : 8);
        LinearLayout root6 = this.pageBinding.settingsLayout.getRoot();
        Intrinsics.checkNotNullExpressionValue(root6, "getRoot(...)");
        root6.setVisibility(page == Page.SETTINGS ? 0 : 8);
        AppCompatImageView headerSettingsBtn = this.pageBinding.headerSettingsBtn;
        Intrinsics.checkNotNullExpressionValue(headerSettingsBtn, "headerSettingsBtn");
        headerSettingsBtn.setVisibility(8);
        AppCompatImageView headerAddBtn = this.pageBinding.headerAddBtn;
        Intrinsics.checkNotNullExpressionValue(headerAddBtn, "headerAddBtn");
        headerAddBtn.setVisibility(8);
        switch (WhenMappings.$EnumSwitchMapping$0[page.ordinal()]) {
            case 1:
                if (this.currentPage == Page.NEW_CORRESPONDENCE) {
                    this.previousPage = Page.NEW_CORRESPONDENCE;
                }
                LinearLayout messengerSearchContainer = this.pageBinding.messagesLayout.messengerSearchContainer;
                Intrinsics.checkNotNullExpressionValue(messengerSearchContainer, "messengerSearchContainer");
                messengerSearchContainer.setVisibility(8);
                TextView resultSearchTitle = this.pageBinding.messagesLayout.resultSearchTitle;
                Intrinsics.checkNotNullExpressionValue(resultSearchTitle, "resultSearchTitle");
                resultSearchTitle.setVisibility(8);
                AppCompatImageView headerSettingsBtn2 = this.pageBinding.headerSettingsBtn;
                Intrinsics.checkNotNullExpressionValue(headerSettingsBtn2, "headerSettingsBtn");
                headerSettingsBtn2.setVisibility(0);
                AppCompatImageView headerAddBtn2 = this.pageBinding.headerAddBtn;
                Intrinsics.checkNotNullExpressionValue(headerAddBtn2, "headerAddBtn");
                headerAddBtn2.setVisibility(0);
                this.contactsAdapter.changeMode(false);
                break;
            case 2:
                if (this.currentPage == Page.NEW_CORRESPONDENCE) {
                    this.previousPage = Page.NEW_CORRESPONDENCE;
                }
                LinearLayout messengerSearchContainer2 = this.pageBinding.messagesLayout.messengerSearchContainer;
                Intrinsics.checkNotNullExpressionValue(messengerSearchContainer2, "messengerSearchContainer");
                messengerSearchContainer2.setVisibility(0);
                TextView resultSearchTitle2 = this.pageBinding.messagesLayout.resultSearchTitle;
                Intrinsics.checkNotNullExpressionValue(resultSearchTitle2, "resultSearchTitle");
                resultSearchTitle2.setVisibility(8);
                this.pageBinding.messagesLayout.searchEditText.requestFocus();
                this.contactsAdapter.changeMode(true);
                break;
            case 3:
                if (this.currentPage == Page.NEW_CORRESPONDENCE) {
                    this.previousPage = Page.NEW_CORRESPONDENCE;
                }
                LinearLayout messengerSearchContainer3 = this.pageBinding.messagesLayout.messengerSearchContainer;
                Intrinsics.checkNotNullExpressionValue(messengerSearchContainer3, "messengerSearchContainer");
                messengerSearchContainer3.setVisibility(0);
                TextView resultSearchTitle3 = this.pageBinding.messagesLayout.resultSearchTitle;
                Intrinsics.checkNotNullExpressionValue(resultSearchTitle3, "resultSearchTitle");
                resultSearchTitle3.setVisibility(0);
                this.pageBinding.messagesLayout.searchEditText.requestFocus();
                this.contactsAdapter.changeMode(true);
                break;
            case 4:
                AppCompatImageView headerSettingsBtn3 = this.pageBinding.headerSettingsBtn;
                Intrinsics.checkNotNullExpressionValue(headerSettingsBtn3, "headerSettingsBtn");
                headerSettingsBtn3.setVisibility(0);
                AppCompatImageView headerAddBtn3 = this.pageBinding.headerAddBtn;
                Intrinsics.checkNotNullExpressionValue(headerAddBtn3, "headerAddBtn");
                headerAddBtn3.setVisibility(0);
                this.previousPage = Page.LOADING;
                break;
            case 5:
                this.previousPage = this.currentPage;
                break;
            case 6:
                this.previousPage = Page.NEW_CORRESPONDENCE;
                break;
            case 7:
                this.previousPage = Page.MESSAGES;
                break;
            case 8:
                if (this.previousPage == Page.LOADING) {
                    removePage();
                    break;
                }
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        this.currentPage = page;
    }

    @Override // ru.mrlargha.arizonaui.mobile.presentation.MobileController
    public void renderPage() {
        this.page.setVisibility(0);
    }

    @Override // ru.mrlargha.arizonaui.mobile.presentation.MobileController
    public void removePage() {
        HistoryManager.Companion.clearThisPage(MobilePhonePage.MESSENGER_APP.getId());
        this.page.removeAllViews();
    }

    public final void onOpenNewChat(ContactInfo contactInfo) {
        Intrinsics.checkNotNullParameter(contactInfo, "contactInfo");
        openChatEvent();
        HistoryManager.Companion.putParams(contactInfo);
        removePage();
        HistoryManager.Companion.getOrCreatePage(MobilePhonePage.MESSENGER_CHAT.getId());
    }

    private final void contactAddOrRemove(ContactInfo contactInfo) {
        int i = Intrinsics.areEqual((Object) contactInfo.isContact(), (Object) true) ? 40 : 41;
        this.userIdForAddContact = contactInfo.getId();
        this.frontendNotifier.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), -1, i, getUserIdJson(contactInfo.getId()));
    }

    public final void addToken(String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        this.sharedPreferences.edit().putString("token", token).apply();
        this.token = token;
        loadChats$default(this, token, null, 2, null);
    }

    public final void addContactAction() {
        int i = this.userIdForAddContact;
        if (i != -1) {
            this.contactsAdapter.contactAddAction(i);
            this.userIdForAddContact = -1;
        }
    }

    public final void removeContactAction() {
        int i = this.userIdForAddContact;
        if (i != -1) {
            this.contactsAdapter.contactRemoveAction(i);
            this.userIdForAddContact = -1;
        }
    }

    public final void onNewMessage(int i, String newMessage) {
        Intrinsics.checkNotNullParameter(newMessage, "newMessage");
        this.contactsAdapter.onNewMessage(i, newMessage);
    }

    public final void updateDialog(int i) {
        if (this.token.length() == 0) {
            return;
        }
        loadChats(this.token, Integer.valueOf(i));
    }

    /* compiled from: Messenger.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u0012\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016¨\u0006\u0014"}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/page/messenger/Messenger$InputCustomKeyboardListener;", "Lru/mrlargha/commonui/elements/CustomKeyboard$InputListener;", "<init>", "(Lru/mrlargha/arizonaui/mobile/presentation/page/messenger/Messenger;)V", "t_OnInputEnd", "", "str", "", "t_BinderIsEmpty", "", "t_GetKeyboardHistorySize", "", "t_GetKeyboardHistoryText", FirebaseAnalytics.Param.INDEX, "t_SetChatType", "t_SetLastString", "std", "t_SetChatHeight", "height", "closeKeyboard", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
            Messenger.this.pageBinding.messagesLayout.searchEditText.setText(str);
            if (Messenger.this.currentPage == Page.MY_CONTACTS) {
                str = "";
            } else if (str == null) {
                return;
            }
            if (str.length() >= 3) {
                Messenger.this.requestContacts(str);
            } else {
                Messenger.this.showEmptySearchedContacts();
            }
        }
    }
}
