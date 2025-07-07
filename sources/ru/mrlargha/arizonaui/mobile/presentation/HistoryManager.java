package ru.mrlargha.arizonaui.mobile.presentation;

import com.adjust.sdk.Constants;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.arizonaui.mobile.domain.enums.MobilePhonePage;
import ru.mrlargha.arizonaui.mobile.domain.obj.ContactInfo;
import ru.mrlargha.arizonaui.mobile.presentation.page.MobilePhoneMainPage;
import ru.mrlargha.arizonaui.mobile.presentation.page.call.CallMenu;
import ru.mrlargha.arizonaui.mobile.presentation.page.call.CallReceive;
import ru.mrlargha.arizonaui.mobile.presentation.page.call.CallTalk;
import ru.mrlargha.arizonaui.mobile.presentation.page.carsharing.CarSharingCars;
import ru.mrlargha.arizonaui.mobile.presentation.page.carsharing.CarSharingInfo;
import ru.mrlargha.arizonaui.mobile.presentation.page.carsharing.CarSharingMain;
import ru.mrlargha.arizonaui.mobile.presentation.page.carsharing.CarSharingRented;
import ru.mrlargha.arizonaui.mobile.presentation.page.catch_app.CatchApp;
import ru.mrlargha.arizonaui.mobile.presentation.page.driver.DriverOrder;
import ru.mrlargha.arizonaui.mobile.presentation.page.driver.DriverOrders;
import ru.mrlargha.arizonaui.mobile.presentation.page.messenger.Messenger;
import ru.mrlargha.arizonaui.mobile.presentation.page.messenger.MessengerChat;
import ru.mrlargha.arizonaui.mobile.presentation.page.spotify.SpotifyPage;
import ru.mrlargha.arizonaui.mobile.presentation.page.uber.UberChoseTaxi;
import ru.mrlargha.arizonaui.mobile.presentation.page.uber.UberComplete;
import ru.mrlargha.arizonaui.mobile.presentation.page.uber.UberOrder;
import ru.mrlargha.arizonaui.mobile.presentation.page.uber.UberPreview;
/* compiled from: HistoryManager.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/HistoryManager;", "", "<init>", "()V", "Companion", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HistoryManager {
    public static final Companion Companion = new Companion(null);
    private static final LinkedList<Integer> historyManager = new LinkedList<>();
    private static final ConcurrentHashMap<Integer, MobileController> page = new ConcurrentHashMap<>();
    private static Object params;
    private static int thisPageId;

    /* compiled from: HistoryManager.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0006J\u000e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0001J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0006J\u0006\u0010\u0018\u001a\u00020\u0013J\r\u0010\u0019\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u001aJ\u0006\u0010\u001b\u001a\u00020\u0013J\u0016\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001eJ\u000e\u0010!\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u0006J\u0010\u0010\"\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0014\u001a\u00020\u0006J\u0006\u0010#\u001a\u00020\u0013J\u0010\u0010$\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0014\u001a\u00020\u0006J\u000e\u0010%\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0006J\u0010\u0010&\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u0006H\u0002R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/HistoryManager$Companion;", "", "<init>", "()V", "historyManager", "Ljava/util/LinkedList;", "", "getHistoryManager", "()Ljava/util/LinkedList;", "params", "getParams", "()Ljava/lang/Object;", "setParams", "(Ljava/lang/Object;)V", "value", "thisPageId", "getThisPageId", "()I", Constants.PUSH, "", "pageId", "putParams", "clearHistoryByKey", "key", "clearAllHistory", "getHistory", "()Ljava/lang/Integer;", "previousPage", "page", "Ljava/util/concurrent/ConcurrentHashMap;", "Lru/mrlargha/arizonaui/mobile/presentation/MobileController;", "putPage", "mobileController", "getOrCreatePage", "getPageIfExist", "clearAllPage", "clearThisPage", "removeViewsPage", "createPage", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LinkedList<Integer> getHistoryManager() {
            return HistoryManager.historyManager;
        }

        public final Object getParams() {
            return HistoryManager.params;
        }

        public final void setParams(Object obj) {
            HistoryManager.params = obj;
        }

        public final int getThisPageId() {
            return HistoryManager.thisPageId;
        }

        public final void push(int i) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            getHistoryManager().add(Integer.valueOf(i));
            linkedHashSet.addAll(getHistoryManager());
            getHistoryManager().clear();
            getHistoryManager().addAll(CollectionsKt.toList(linkedHashSet));
        }

        public final void putParams(Object params) {
            Intrinsics.checkNotNullParameter(params, "params");
            setParams(params);
        }

        public final void clearHistoryByKey(int i) {
            getHistoryManager().remove(Integer.valueOf(i));
        }

        public final void clearAllHistory() {
            getHistoryManager().clear();
        }

        public final Integer getHistory() {
            if (getHistoryManager().isEmpty()) {
                return null;
            }
            return getHistoryManager().getLast();
        }

        public final void previousPage() {
            if (getHistoryManager().size() - 1 > 0) {
                Integer num = getHistoryManager().get(getHistoryManager().size() - 1);
                Intrinsics.checkNotNullExpressionValue(num, "get(...)");
                MobileController pageIfExist = getPageIfExist(num.intValue());
                if (pageIfExist != null) {
                    pageIfExist.removePage();
                }
                getHistoryManager().removeLast();
                if (getHistoryManager().size() - 1 >= 0) {
                    Integer num2 = getHistoryManager().get(getHistoryManager().size() - 1);
                    Intrinsics.checkNotNullExpressionValue(num2, "get(...)");
                    getOrCreatePage(num2.intValue());
                }
            }
        }

        public final void putPage(int i, MobileController mobileController) {
            Intrinsics.checkNotNullParameter(mobileController, "mobileController");
            HistoryManager.page.put(Integer.valueOf(i), mobileController);
        }

        public final MobileController getOrCreatePage(int i) {
            MobileController mobileController = (MobileController) HistoryManager.page.get(Integer.valueOf(i));
            return mobileController == null ? createPage(i) : mobileController;
        }

        public final MobileController getPageIfExist(int i) {
            return (MobileController) HistoryManager.page.get(Integer.valueOf(i));
        }

        public final void clearAllPage() {
            Collection<MobileController> values = HistoryManager.page.values();
            Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
            for (MobileController mobileController : values) {
                mobileController.removePage();
            }
        }

        public final MobileController clearThisPage(int i) {
            return (MobileController) HistoryManager.page.remove(Integer.valueOf(i));
        }

        public final void removeViewsPage(int i) {
            setParams(null);
            MobileController mobileController = (MobileController) HistoryManager.page.get(Integer.valueOf(i));
            if (mobileController != null) {
                mobileController.removePage();
            }
        }

        private final MobileController createPage(int i) {
            HistoryManager.thisPageId = i;
            if (i == MobilePhonePage.MAIN_PAGE.getId()) {
                HistoryManager.page.put(Integer.valueOf(i), new MobilePhoneMainPage());
            } else if (i == MobilePhonePage.CALL_TYPE_PAGE.getId()) {
                HistoryManager.page.put(Integer.valueOf(i), new CallMenu());
            } else if (i == MobilePhonePage.CALL_RECEIVE_PAGE.getId()) {
                HistoryManager.page.put(Integer.valueOf(i), new CallReceive());
            } else if (i == MobilePhonePage.CALL_TALK_PAGE.getId()) {
                HistoryManager.page.put(Integer.valueOf(i), new CallTalk());
            } else if (i == MobilePhonePage.ARIZONAMOBIL_MAIN.getId()) {
                HistoryManager.page.put(Integer.valueOf(i), new CarSharingMain());
            } else if (i == MobilePhonePage.ARIZONAMOBIL_CAR_INFO.getId()) {
                HistoryManager.page.put(Integer.valueOf(i), new CarSharingInfo());
            } else if (i == MobilePhonePage.ARIZONAMOBIL_CARS.getId()) {
                HistoryManager.page.put(Integer.valueOf(i), new CarSharingCars());
            } else if (i == MobilePhonePage.ARIZONAMOBIL_RENTED.getId()) {
                HistoryManager.page.put(Integer.valueOf(i), new CarSharingRented());
            } else if (i == MobilePhonePage.UBER_PREVIEW.getId()) {
                HistoryManager.page.put(Integer.valueOf(i), new UberPreview());
            } else if (i == MobilePhonePage.UBER_CHOSE_TAXI.getId()) {
                HistoryManager.page.put(Integer.valueOf(i), new UberChoseTaxi());
            } else if (i == MobilePhonePage.UBER_ORDER.getId()) {
                HistoryManager.page.put(Integer.valueOf(i), new UberOrder());
            } else if (i == MobilePhonePage.UBER_COMPLETE.getId()) {
                HistoryManager.page.put(Integer.valueOf(i), new UberComplete());
            } else if (i == MobilePhonePage.DRIVER_ORDERS.getId()) {
                HistoryManager.page.put(Integer.valueOf(i), new DriverOrders());
            } else if (i == MobilePhonePage.DRIVER_ORDER.getId()) {
                HistoryManager.page.put(Integer.valueOf(i), new DriverOrder());
            } else if (i == MobilePhonePage.SPOTIFY_PAGE.getId()) {
                HistoryManager.page.put(Integer.valueOf(i), new SpotifyPage());
            } else if (i == MobilePhonePage.CATCH_APP.getId()) {
                HistoryManager.page.put(Integer.valueOf(i), new CatchApp());
            } else if (i == MobilePhonePage.MESSENGER_APP.getId()) {
                ConcurrentHashMap concurrentHashMap = HistoryManager.page;
                Integer valueOf = Integer.valueOf(i);
                Object params = getParams();
                concurrentHashMap.put(valueOf, new Messenger(params instanceof Integer ? (Integer) params : null));
            } else if (i != MobilePhonePage.MESSENGER_CHAT.getId()) {
                HistoryManager.page.put(0, new MobilePhoneMainPage());
            } else {
                Object params2 = getParams();
                if (params2 != null) {
                    HistoryManager.page.put(Integer.valueOf(i), new MessengerChat((ContactInfo) params2));
                }
            }
            MobileController mobileController = (MobileController) HistoryManager.page.get(Integer.valueOf(i));
            return mobileController == null ? new MobilePhoneMainPage() : mobileController;
        }
    }
}
