package ru.mrlargha.event;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.media3.common.MediaItem;
import androidx.media3.exoplayer.ExoPlayer;
import com.facebook.widget.FacebookDialog;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
import com.squareup.picasso.Picasso;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.TimeConverterKt;
import ru.mrlargha.commonui.utils.UtilsKt;
import ru.mrlargha.commonui.utils.ui.ArizonaRetrofit;
import ru.mrlargha.event.adapters.AwardsAdapter;
import ru.mrlargha.event.adapters.QuestAdapter;
import ru.mrlargha.event.adapters.ShopAdapter;
import ru.mrlargha.event.data.AwardItemData;
import ru.mrlargha.event.data.EasterItem;
import ru.mrlargha.event.data.EventData;
import ru.mrlargha.event.data.MainInfo;
import ru.mrlargha.event.data.QuestData;
import ru.mrlargha.event.data.RatingData;
import ru.mrlargha.event.data.ShipData;
import ru.mrlargha.event.data.ShopItem;
import ru.mrlargha.event.data.ShopResult;
import ru.mrlargha.feature.arizona.cases.pages.adapters.CasesSameCasesAdapter;
import ru.mrlargha.feature.event.R;
import ru.mrlargha.feature.event.databinding.EventEventsItemBinding;
import ru.mrlargha.feature.event.databinding.EventMainResultScreenBinding;
import ru.mrlargha.feature.event.databinding.EventMainScreenBinding;
import ru.mrlargha.feature.event.databinding.EventPriseItemEventBinding;
import ru.mrlargha.feature.event.databinding.EventScreenBinding;
import ru.mrlargha.feature.event.databinding.EventShopSceenBinding;
import ru.mrlargha.feature.event.databinding.EventTopbarBinding;
import ru.mrlargha.feature.event.databinding.PiratesShipScreenBinding;
import ru.mrlargha.feature.event.databinding.PiratesShipUpgradeItemBinding;
import ru.mrlargha.pirates.UtilKt;
import ru.mrlargha.pirates.adapters.RatingAdapter;
/* compiled from: EventScreen.kt */
@Metadata(d1 = {"\u0000æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0003klmB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0016J\u0018\u00102\u001a\u00020/2\u0006\u00103\u001a\u00020%2\u0006\u00104\u001a\u00020\u0006H\u0016J\u0010\u00105\u001a\u00020/2\u0006\u00103\u001a\u000206H\u0002J\u0016\u00107\u001a\u00020/2\f\u00108\u001a\b\u0012\u0004\u0012\u0002090\u001aH\u0002J\u0010\u0010:\u001a\u00020/2\u0006\u0010;\u001a\u00020%H\u0002J \u0010<\u001a\u00020/2\u0006\u0010=\u001a\u00020>2\u0006\u00103\u001a\u00020?2\u0006\u0010@\u001a\u00020\u0006H\u0002J\u0016\u0010A\u001a\u00020/2\f\u00108\u001a\b\u0012\u0004\u0012\u00020B0\u001aH\u0002J\u0010\u0010C\u001a\u00020/2\u0006\u00108\u001a\u00020\u001dH\u0002J\u0016\u0010D\u001a\u00020/2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020F0\u001aH\u0002J\u0010\u0010G\u001a\u00020/2\u0006\u00108\u001a\u00020HH\u0002J\u0010\u0010I\u001a\u00020/2\u0006\u00108\u001a\u00020HH\u0002J\u0016\u0010J\u001a\u00020/2\f\u00108\u001a\b\u0012\u0004\u0012\u00020K0\u001aH\u0002J\u0016\u0010L\u001a\u00020/2\f\u00108\u001a\b\u0012\u0004\u0012\u00020K0\u001aH\u0002J\u0016\u0010M\u001a\u00020/2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00060\u001aH\u0002J\u0016\u0010O\u001a\u00020/2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002J\u0010\u0010Q\u001a\u00020/2\u0006\u0010R\u001a\u00020\u0006H\u0002J\u0018\u0010S\u001a\u00020/2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020KH\u0002J\u0018\u0010W\u001a\u00020/2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020KH\u0002J\u000e\u0010X\u001a\u00020%2\u0006\u0010Y\u001a\u00020\u0006J\u0018\u0010Z\u001a\u00020/2\u0006\u0010T\u001a\u00020[2\u0006\u0010\\\u001a\u00020]H\u0002J\b\u0010^\u001a\u00020/H\u0002J\b\u0010_\u001a\u00020/H\u0002J\u0010\u0010`\u001a\u00020/2\u0006\u0010V\u001a\u00020BH\u0002J\u0010\u0010a\u001a\u00020/2\u0006\u0010V\u001a\u00020FH\u0002J\u0018\u0010b\u001a\u00020/2\u0006\u0010c\u001a\u00020%2\u0006\u0010T\u001a\u00020\nH\u0002J\b\u0010d\u001a\u00020/H\u0002J\b\u0010e\u001a\u00020/H\u0002J\b\u0010f\u001a\u00020/H\u0002J\b\u0010g\u001a\u00020/H\u0002J\u0010\u0010h\u001a\u00020/2\u0006\u0010i\u001a\u00020jH\u0002R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010$\u001a\u00020%¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010(\u001a\u00020)¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006n"}, d2 = {"Lru/mrlargha/event/EventScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "Lru/mrlargha/commonui/elements/authorization/presentation/InterfaceController;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "screen", "Landroid/view/View;", "kotlin.jvm.PlatformType", "binding", "Lru/mrlargha/feature/event/databinding/EventScreenBinding;", "textSelectedColor", "completeColor", "questAdapter", "Lru/mrlargha/event/adapters/QuestAdapter;", "shopAdapter", "Lru/mrlargha/event/adapters/ShopAdapter;", "levelItemsAdapter", "Lru/mrlargha/event/adapters/AwardsAdapter;", "timersList", "", "Landroid/os/CountDownTimer;", "_bpUsualData", "", "Lru/mrlargha/event/data/AwardItemData;", "battlePassInfo", "Lru/mrlargha/event/data/MainInfo;", "eventPosition", "", "player", "Landroidx/media3/exoplayer/ExoPlayer;", "ratingAdapter", "Lru/mrlargha/pirates/adapters/RatingAdapter;", "url", "", "getUrl", "()Ljava/lang/String;", "client", "Lru/mrlargha/commonui/utils/ui/ArizonaRetrofit;", "getClient", "()Lru/mrlargha/commonui/utils/ui/ArizonaRetrofit;", "api", "Lru/mrlargha/event/EventApi;", "setVisible", "", "visible", "", "onBackendMessageHandled", "data", "subId", "setShipInfo", "Lru/mrlargha/event/data/ShipData;", "setRatingInfo", "info", "Lru/mrlargha/event/data/RatingData;", "setRatingTime", "time", "setShipUpgrade", "elementBinding", "Lru/mrlargha/feature/event/databinding/PiratesShipUpgradeItemBinding;", "Lru/mrlargha/event/data/ShipData$ShipComponent;", "stage", "setListQuest", "Lru/mrlargha/event/data/QuestData;", "setMainPageInfo", "setShopInfo", "items", "Lru/mrlargha/event/data/ShopItem;", "setShopResult", "Lru/mrlargha/event/data/ShopResult;", "setMainResult", "setListEvent", "Lru/mrlargha/event/data/EventData;", "updateListEvent", "updateBpAwards", "awardsStatusList", "updateLevelItems", "pairList", "onClaimItem", "position", "updateEvent", "view", "Lru/mrlargha/feature/event/databinding/EventEventsItemBinding;", "item", "setEvent", "formatSeconds", "seconds", "setPriseItem", "Lru/mrlargha/feature/event/databinding/EventPriseItemEventBinding;", "prise", "Lru/mrlargha/event/data/EasterItem;", "stopVideo", "setVideo", "onTaskItemClick", "onShopItemClick", "onPriseInfo", "text", "setupAdapters", "clearAdapters", "clearTimers", "setupNavigation", "navigateTo", "nav", "Lru/mrlargha/event/EventScreen$Navigation;", "EasterBites", "Navigation", "Spawner", "event"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class EventScreen extends SAMPUIElement implements InterfaceController {
    private List<AwardItemData> _bpUsualData;
    private final EventApi api;
    private MainInfo battlePassInfo;
    private final EventScreenBinding binding;
    private final ArizonaRetrofit client;
    private final int completeColor;
    private final Map<Integer, Integer> eventPosition;
    private final AwardsAdapter levelItemsAdapter;
    private ExoPlayer player;
    private final QuestAdapter questAdapter;
    private final RatingAdapter ratingAdapter;
    private final View screen;
    private final ShopAdapter shopAdapter;
    private final int textSelectedColor;
    private final List<CountDownTimer> timersList;
    private final String url;

    /* compiled from: EventScreen.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Navigation.values().length];
            try {
                iArr[Navigation.Main.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Navigation.Task.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Navigation.Events.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Navigation.Shop.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Navigation.Video.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setEvent$lambda$0$2$1(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setEvent$lambda$0$8(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateEvent$lambda$0$2$1(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateEvent$lambda$0$2$2(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateEvent$lambda$0$8(View view) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EventScreen(Activity targetActivity, int i) {
        super(targetActivity, i);
        String str;
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View screen = targetActivity.getLayoutInflater().inflate(R.layout.event_screen, (ViewGroup) null);
        this.screen = screen;
        EventScreenBinding bind = EventScreenBinding.bind(screen);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        this.textSelectedColor = Color.parseColor("#354463");
        int color = ContextCompat.getColor(targetActivity, R.color.main);
        this.completeColor = color;
        this.questAdapter = new QuestAdapter(color, new Function1() { // from class: ru.mrlargha.event.EventScreen$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EventScreen.questAdapter$lambda$0(EventScreen.this, (QuestData) obj);
            }
        }, new Function2() { // from class: ru.mrlargha.event.EventScreen$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return EventScreen.questAdapter$lambda$1(EventScreen.this, (String) obj, (View) obj2);
            }
        });
        this.shopAdapter = new ShopAdapter(new Function1() { // from class: ru.mrlargha.event.EventScreen$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EventScreen.shopAdapter$lambda$0(EventScreen.this, (ShopItem) obj);
            }
        });
        this.levelItemsAdapter = new AwardsAdapter(color, new Function2() { // from class: ru.mrlargha.event.EventScreen$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return EventScreen.levelItemsAdapter$lambda$0(EventScreen.this, ((Boolean) obj).booleanValue(), ((Integer) obj2).intValue());
            }
        });
        this.timersList = new ArrayList();
        this._bpUsualData = CollectionsKt.emptyList();
        this.eventPosition = new LinkedHashMap();
        this.ratingAdapter = new RatingAdapter();
        if (UtilsKt.isArizonaType()) {
            str = FirebaseConfigHelper.getProjectResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null) + "systems/battlepass/easter-2026/";
        } else {
            str = FirebaseConfigHelper.getProjectResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null) + "systems/battlepass/";
        }
        String str2 = str;
        this.url = str2;
        ArizonaRetrofit arizonaRetrofit = new ArizonaRetrofit(targetActivity, i);
        this.client = arizonaRetrofit;
        this.api = (EventApi) ArizonaRetrofit.create$default(arizonaRetrofit, EventApi.class, false, str2, null, 10, null);
        Intrinsics.checkNotNullExpressionValue(screen, "screen");
        addViewToConstraintLayout(screen, -1, -1);
        setupNavigation();
        setupAdapters();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit questAdapter$lambda$0(EventScreen eventScreen, QuestData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        eventScreen.onTaskItemClick(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit questAdapter$lambda$1(EventScreen eventScreen, String text, View view) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(view, "view");
        eventScreen.onPriseInfo(text, view);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit shopAdapter$lambda$0(EventScreen eventScreen, ShopItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        eventScreen.onShopItemClick(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit levelItemsAdapter$lambda$0(EventScreen eventScreen, boolean z, int i) {
        eventScreen.onClaimItem(i);
        return Unit.INSTANCE;
    }

    public final String getUrl() {
        return this.url;
    }

    public final ArizonaRetrofit getClient() {
        return this.client;
    }

    @Override // ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController
    public void setVisible(boolean z) {
        stopVideo();
        clearAdapters();
        clearTimers();
        this.binding.getRoot().setVisibility(z ? 0 : 8);
        this.binding.getRoot().setVisibility(z ? 0 : 8);
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessageHandled(String data, int i) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(data, "data");
        switch (i) {
            case 0:
                Integer intOrNull = StringsKt.toIntOrNull(data);
                int intValue = intOrNull != null ? intOrNull.intValue() : 1;
                if (intValue == EasterBites.Main.getValue()) {
                    navigateTo(Navigation.Main);
                    return;
                } else if (intValue == EasterBites.Task.getValue()) {
                    navigateTo(Navigation.Task);
                    return;
                } else if (intValue == EasterBites.Shop.getValue()) {
                    navigateTo(Navigation.Shop);
                    return;
                } else if (intValue == EasterBites.Event.getValue()) {
                    navigateTo(Navigation.Events);
                    return;
                } else if (intValue == EasterBites.Ship.getValue()) {
                    navigateTo(Navigation.Ship);
                    return;
                } else if (intValue == EasterBites.Rating.getValue()) {
                    navigateTo(Navigation.Rating);
                    return;
                } else {
                    return;
                }
            case 1:
                setListQuest(MapperKt.toListModel(data, QuestData.class));
                return;
            case 2:
                setListEvent(MapperKt.toListModel(data, EventData.class));
                return;
            case 3:
                updateListEvent(CollectionsKt.listOf(MapperKt.toModel(data, EventData.class)));
                return;
            case 4:
            default:
                return;
            case 5:
                setMainPageInfo((MainInfo) MapperKt.toModel(data, MainInfo.class));
                return;
            case 6:
                setMainResult((ShopResult) MapperKt.toModel(data, ShopResult.class));
                return;
            case 7:
                setShopResult((ShopResult) MapperKt.toModel(data, ShopResult.class));
                return;
            case 8:
                if (MapperKt.isJsonValid(data)) {
                    JsonArray asJsonArray = ((JsonElement) MapperKt.getGson().fromJson(data, (Class<Object>) JsonElement.class)).getAsJsonArray();
                    Intrinsics.checkNotNull(asJsonArray);
                    JsonArray<JsonElement> jsonArray = asJsonArray;
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonArray, 10));
                    for (JsonElement jsonElement : jsonArray) {
                        arrayList2.add(MapperKt.getGson().fromJson(jsonElement, (Class<Object>) ShopItem.class));
                    }
                    arrayList = arrayList2;
                } else {
                    arrayList = CollectionsKt.emptyList();
                }
                setShopInfo(arrayList);
                return;
            case 9:
                this.binding.topElements.moneyText.setText(data);
                return;
            case 10:
                setShipInfo((ShipData) MapperKt.toModel(data, ShipData.class));
                return;
            case 11:
                setRatingInfo(MapperKt.toListModel(data, RatingData.class));
                return;
            case 12:
                setRatingTime(data);
                return;
        }
    }

    private final void setShipInfo(ShipData shipData) {
        PiratesShipScreenBinding piratesShipScreenBinding = this.binding.ship;
        piratesShipScreenBinding.progressBar.setPercentWidth(shipData.getExp() / shipData.getMaxExp());
        piratesShipScreenBinding.currentExp.setText(String.valueOf(shipData.getExp()));
        piratesShipScreenBinding.maxExp.setText(String.valueOf(shipData.getMaxExp()));
        piratesShipScreenBinding.level.setText(getTargetActivity().getString(R.string.event_level, new Object[]{Integer.valueOf(shipData.getLevel())}));
        piratesShipScreenBinding.upgrade1.getRoot().setVisibility(8);
        piratesShipScreenBinding.upgrade2.getRoot().setVisibility(8);
        piratesShipScreenBinding.upgrade3.getRoot().setVisibility(8);
        piratesShipScreenBinding.upgrade4.getRoot().setVisibility(8);
        ShipData.ShipComponent shipComponent = (ShipData.ShipComponent) CollectionsKt.getOrNull(shipData.getComponents(), 0);
        if (shipComponent != null) {
            piratesShipScreenBinding.upgrade1.getRoot().setVisibility(0);
            PiratesShipUpgradeItemBinding upgrade1 = piratesShipScreenBinding.upgrade1;
            Intrinsics.checkNotNullExpressionValue(upgrade1, "upgrade1");
            setShipUpgrade(upgrade1, shipComponent, shipData.getStage());
        }
        ShipData.ShipComponent shipComponent2 = (ShipData.ShipComponent) CollectionsKt.getOrNull(shipData.getComponents(), 1);
        if (shipComponent2 != null) {
            piratesShipScreenBinding.upgrade2.getRoot().setVisibility(0);
            PiratesShipUpgradeItemBinding upgrade2 = piratesShipScreenBinding.upgrade2;
            Intrinsics.checkNotNullExpressionValue(upgrade2, "upgrade2");
            setShipUpgrade(upgrade2, shipComponent2, shipData.getStage());
        }
        ShipData.ShipComponent shipComponent3 = (ShipData.ShipComponent) CollectionsKt.getOrNull(shipData.getComponents(), 2);
        if (shipComponent3 != null) {
            piratesShipScreenBinding.upgrade3.getRoot().setVisibility(0);
            PiratesShipUpgradeItemBinding upgrade3 = piratesShipScreenBinding.upgrade3;
            Intrinsics.checkNotNullExpressionValue(upgrade3, "upgrade3");
            setShipUpgrade(upgrade3, shipComponent3, shipData.getStage());
        }
        ShipData.ShipComponent shipComponent4 = (ShipData.ShipComponent) CollectionsKt.getOrNull(shipData.getComponents(), 3);
        if (shipComponent4 != null) {
            piratesShipScreenBinding.upgrade4.getRoot().setVisibility(0);
            PiratesShipUpgradeItemBinding upgrade32 = piratesShipScreenBinding.upgrade3;
            Intrinsics.checkNotNullExpressionValue(upgrade32, "upgrade3");
            setShipUpgrade(upgrade32, shipComponent4, shipData.getStage());
        }
    }

    private final void setRatingInfo(List<RatingData> list) {
        this.ratingAdapter.addAllItems(list);
    }

    private final void setRatingTime(String str) {
        Integer intOrNull = StringsKt.toIntOrNull(str);
        int intValue = intOrNull != null ? intOrNull.intValue() : 0;
        EventScreenBinding eventScreenBinding = this.binding;
        if (intValue > 0) {
            eventScreenBinding.rating.time.setVisibility(0);
            this.binding.rating.timedesc.setVisibility(0);
            this.binding.rating.time.setText(UtilKt.formatDurationLocalized$default(getTargetActivity(), Integer.parseInt(str), false, 4, null));
            return;
        }
        eventScreenBinding.rating.time.setVisibility(8);
        this.binding.rating.timedesc.setVisibility(8);
    }

    private final void setShipUpgrade(PiratesShipUpgradeItemBinding piratesShipUpgradeItemBinding, final ShipData.ShipComponent shipComponent, int i) {
        int i2;
        piratesShipUpgradeItemBinding.text.setText(shipComponent.getTitle());
        piratesShipUpgradeItemBinding.buttonText.setText(String.valueOf(shipComponent.getPrice()));
        piratesShipUpgradeItemBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.event.EventScreen$$ExternalSyntheticLambda17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventScreen.setShipUpgrade$lambda$0$0(EventScreen.this, shipComponent, view);
            }
        });
        String image = shipComponent.getImage();
        int hashCode = image.hashCode();
        if (hashCode == -1326217028) {
            if (image.equals("dollar")) {
                i2 = R.drawable.pirates_dollar;
            }
            i2 = R.drawable.event_coin;
        } else if (hashCode == -522905897) {
            if (image.equals("az_coin")) {
                i2 = ru.mrlargha.commonui.R.drawable.ic_az_coins;
            }
            i2 = R.drawable.event_coin;
        } else {
            if (hashCode == 108864568 && image.equals("ruble")) {
                i2 = UtilsKt.isArizonaType() ? R.drawable.pirates_dollar : R.drawable.pirates_ruble;
            }
            i2 = R.drawable.event_coin;
        }
        piratesShipUpgradeItemBinding.currency.setImageResource(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setShipUpgrade$lambda$0$0(EventScreen eventScreen, ShipData.ShipComponent shipComponent, View view) {
        SAMPUIElement.notifyClick$default(eventScreen, shipComponent.getId(), 6, null, 4, null);
    }

    private final void setListQuest(List<QuestData> list) {
        this.questAdapter.addAllItems(list);
    }

    private final void setMainPageInfo(MainInfo mainInfo) {
        this.battlePassInfo = mainInfo;
        updateBpAwards(mainInfo.getAvailableToReceive());
        EventMainScreenBinding eventMainScreenBinding = this.binding.main;
        eventMainScreenBinding.levelPassText.setText(String.valueOf(mainInfo.getLevel()));
        TextView textView = eventMainScreenBinding.mainExperienceText;
        int exp = mainInfo.getExp();
        textView.setText(exp + "/" + mainInfo.getMaxExp());
        eventMainScreenBinding.progressExperience.setMax(mainInfo.getMaxExp());
        eventMainScreenBinding.progressExperience.setProgress(mainInfo.getExp());
        eventMainScreenBinding.remainingTimeTextMain.setText(TimeConverterKt.mainPageTimeConvert(mainInfo.getTimestampEnd()));
    }

    private final void setShopInfo(List<ShopItem> list) {
        this.shopAdapter.clearList();
        this.shopAdapter.addAllItems(list);
    }

    private final void setShopResult(ShopResult shopResult) {
        EventShopSceenBinding eventShopSceenBinding = this.binding.shop;
        eventShopSceenBinding.result.setVisibility(0);
        eventShopSceenBinding.rvItems.setVisibility(8);
        eventShopSceenBinding.awardName.setText(shopResult.getName());
        eventShopSceenBinding.tvDescription.setText(shopResult.getCaption());
        if (UtilsKt.isArizonaType()) {
            Picasso picasso = Picasso.get();
            String projectResourceUrl$default = FirebaseConfigHelper.getProjectResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null);
            picasso.load(projectResourceUrl$default + "/systems/battlepass/easter-2026/" + shopResult.getImage() + ".webp").into(eventShopSceenBinding.ivAward);
        } else {
            Picasso picasso2 = Picasso.get();
            String projectResourceUrl$default2 = FirebaseConfigHelper.getProjectResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null);
            picasso2.load(projectResourceUrl$default2 + "/systems/battlepass/items/" + shopResult.getImage() + ".webp").into(eventShopSceenBinding.ivAward);
        }
        eventShopSceenBinding.count.setText(getTargetActivity().getString(R.string.event_count_amount, new Object[]{Integer.valueOf(shopResult.getCount())}));
    }

    private final void setMainResult(ShopResult shopResult) {
        EventMainResultScreenBinding eventMainResultScreenBinding = this.binding.resultMain;
        eventMainResultScreenBinding.getRoot().setVisibility(0);
        eventMainResultScreenBinding.awardName.setText(shopResult.getName());
        eventMainResultScreenBinding.tvDescription.setText(shopResult.getCaption());
        if (UtilsKt.isArizonaType()) {
            Picasso picasso = Picasso.get();
            String projectResourceUrl$default = FirebaseConfigHelper.getProjectResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null);
            picasso.load(projectResourceUrl$default + "/systems/battlepass/easter-2026/" + shopResult.getImage() + ".webp").into(eventMainResultScreenBinding.ivAward);
        } else {
            Picasso picasso2 = Picasso.get();
            String projectResourceUrl$default2 = FirebaseConfigHelper.getProjectResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null);
            picasso2.load(projectResourceUrl$default2 + "/systems/battlepass/items/" + shopResult.getImage() + ".webp").into(eventMainResultScreenBinding.ivAward);
        }
        eventMainResultScreenBinding.count.setText(getTargetActivity().getString(R.string.event_count_amount, new Object[]{Integer.valueOf(shopResult.getCount())}));
    }

    private final void setListEvent(List<EventData> list) {
        EventData eventData = (EventData) CollectionsKt.getOrNull(list, 0);
        if (eventData != null) {
            EventEventsItemBinding event1 = this.binding.events.event1;
            Intrinsics.checkNotNullExpressionValue(event1, "event1");
            setEvent(event1, eventData);
            this.eventPosition.put(Integer.valueOf(eventData.getId()), 1);
        }
        EventData eventData2 = (EventData) CollectionsKt.getOrNull(list, 1);
        if (eventData2 != null) {
            EventEventsItemBinding event2 = this.binding.events.event2;
            Intrinsics.checkNotNullExpressionValue(event2, "event2");
            setEvent(event2, eventData2);
            this.eventPosition.put(Integer.valueOf(eventData2.getId()), 2);
        }
        EventData eventData3 = (EventData) CollectionsKt.getOrNull(list, 2);
        if (eventData3 != null) {
            EventEventsItemBinding event3 = this.binding.events.event3;
            Intrinsics.checkNotNullExpressionValue(event3, "event3");
            setEvent(event3, eventData3);
            this.eventPosition.put(Integer.valueOf(eventData3.getId()), 3);
        }
    }

    private final void updateListEvent(List<EventData> list) {
        Object obj;
        Object obj2;
        Object obj3;
        List<EventData> list2 = list;
        Iterator<T> it = list2.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it.next();
            Integer num = this.eventPosition.get(Integer.valueOf(((EventData) obj2).getId()));
            if (num != null && num.intValue() == 1) {
                break;
            }
        }
        EventData eventData = (EventData) obj2;
        if (eventData != null) {
            EventEventsItemBinding event1 = this.binding.events.event1;
            Intrinsics.checkNotNullExpressionValue(event1, "event1");
            updateEvent(event1, eventData);
        }
        Iterator<T> it2 = list2.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj3 = null;
                break;
            }
            obj3 = it2.next();
            Integer num2 = this.eventPosition.get(Integer.valueOf(((EventData) obj3).getId()));
            if (num2 != null && num2.intValue() == 2) {
                break;
            }
        }
        EventData eventData2 = (EventData) obj3;
        if (eventData2 != null) {
            EventEventsItemBinding event2 = this.binding.events.event2;
            Intrinsics.checkNotNullExpressionValue(event2, "event2");
            updateEvent(event2, eventData2);
        }
        Iterator<T> it3 = list2.iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            Object next = it3.next();
            Integer num3 = this.eventPosition.get(Integer.valueOf(((EventData) next).getId()));
            if (num3 != null && num3.intValue() == 3) {
                obj = next;
                break;
            }
        }
        EventData eventData3 = (EventData) obj;
        if (eventData3 != null) {
            EventEventsItemBinding event3 = this.binding.events.event3;
            Intrinsics.checkNotNullExpressionValue(event3, "event3");
            updateEvent(event3, eventData3);
        }
    }

    private final void updateBpAwards(List<Integer> list) {
        BuildersKt__Builders_commonKt.launch$default(this.client.getScope(), Dispatchers.getIO(), null, new EventScreen$updateBpAwards$1(this, list, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateLevelItems(List<AwardItemData> list) {
        AwardsAdapter awardsAdapter = this.levelItemsAdapter;
        MainInfo mainInfo = this.battlePassInfo;
        awardsAdapter.setData(list, mainInfo != null ? mainInfo.getLevel() : 0);
    }

    private final void onClaimItem(int i) {
        SAMPUIElement.notifyClick$default(this, i, 5, null, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object, ru.mrlargha.event.EventScreen$updateEvent$1$10$timer$1] */
    private final void updateEvent(final EventEventsItemBinding eventEventsItemBinding, final EventData eventData) {
        EasterItem easterItem;
        EasterItem easterItem2;
        EasterItem easterItem3;
        if (eventData.getName() != null) {
            eventEventsItemBinding.tvEventName.setText(eventData.getName());
        }
        if (eventData.getDescription() != null) {
            eventEventsItemBinding.tvEventDescription.setText(eventData.getDescription());
        }
        if (eventData.getButtonType() != null) {
            eventEventsItemBinding.btnJoin.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.event.EventScreen$$ExternalSyntheticLambda21
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EventScreen.updateEvent$lambda$0$2$0(EventScreen.this, eventData, view);
                }
            });
            String buttonType = eventData.getButtonType();
            switch (buttonType.hashCode()) {
                case -1512431652:
                    if (buttonType.equals("event_started")) {
                        eventEventsItemBinding.btnJoin.setBackgroundResource(R.drawable.event_event_btn_bg_transparent);
                        eventEventsItemBinding.btnJoin.setText(getTargetActivity().getString(R.string.event_started));
                        eventEventsItemBinding.btnJoin.setTextColor(Color.parseColor("#BE3D3D3D"));
                        eventEventsItemBinding.btnJoin.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.event.EventScreen$$ExternalSyntheticLambda23
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                EventScreen.updateEvent$lambda$0$2$2(view);
                            }
                        });
                        break;
                    }
                    break;
                case -1500192018:
                    if (buttonType.equals("players_limit")) {
                        eventEventsItemBinding.btnJoin.setBackgroundResource(R.drawable.event_event_btn_bg_transparent);
                        eventEventsItemBinding.btnJoin.setText(getTargetActivity().getString(R.string.event_participants_limit));
                        eventEventsItemBinding.btnJoin.setTextColor(Color.parseColor("#9016191D"));
                        eventEventsItemBinding.btnJoin.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.event.EventScreen$$ExternalSyntheticLambda22
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                EventScreen.updateEvent$lambda$0$2$1(view);
                            }
                        });
                        break;
                    }
                    break;
                case -1367724422:
                    if (buttonType.equals(FacebookDialog.COMPLETION_GESTURE_CANCEL)) {
                        eventEventsItemBinding.btnJoin.setBackgroundResource(R.drawable.event_event_btn_bg_white);
                        eventEventsItemBinding.btnJoin.setText(getTargetActivity().getString(R.string.event_cancel));
                        eventEventsItemBinding.btnJoin.setTextColor(Color.parseColor("#3D3D3D"));
                        break;
                    }
                    break;
                case 3267882:
                    if (buttonType.equals("join")) {
                        eventEventsItemBinding.btnJoin.setBackgroundResource(R.drawable.event_event_btn_bg);
                        eventEventsItemBinding.btnJoin.setText(getTargetActivity().getString(R.string.event_join));
                        eventEventsItemBinding.btnJoin.setTextColor(Color.parseColor("#3D3D3D"));
                        break;
                    }
                    break;
            }
        }
        if (eventData.getAttempts() != null) {
            eventEventsItemBinding.tvAttemptsAvailable.setText(eventData.getAttempts().getCurrent() + "/" + eventData.getAttempts().getMax());
            eventEventsItemBinding.playersContainer.setVisibility(8);
        }
        if (eventData.getPlayers() != null) {
            eventEventsItemBinding.playersContainer.setVisibility(0);
            eventEventsItemBinding.tvParticipants.setText(eventData.getPlayers().getCurrent() + "/" + eventData.getPlayers().getMax());
        }
        List<EasterItem> items = eventData.getItems();
        if (items != null && (easterItem3 = (EasterItem) CollectionsKt.getOrNull(items, 0)) != null) {
            EventPriseItemEventBinding item1 = eventEventsItemBinding.item1;
            Intrinsics.checkNotNullExpressionValue(item1, "item1");
            setPriseItem(item1, easterItem3);
        }
        List<EasterItem> items2 = eventData.getItems();
        if (items2 != null && (easterItem2 = (EasterItem) CollectionsKt.getOrNull(items2, 1)) != null) {
            EventPriseItemEventBinding item2 = eventEventsItemBinding.item2;
            Intrinsics.checkNotNullExpressionValue(item2, "item2");
            setPriseItem(item2, easterItem2);
        }
        List<EasterItem> items3 = eventData.getItems();
        if (items3 != null && (easterItem = (EasterItem) CollectionsKt.getOrNull(items3, 2)) != null) {
            EventPriseItemEventBinding item3 = eventEventsItemBinding.item3;
            Intrinsics.checkNotNullExpressionValue(item3, "item3");
            setPriseItem(item3, easterItem);
        }
        eventEventsItemBinding.errorOverlay.setVisibility(8);
        eventEventsItemBinding.errorOverlay.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.event.EventScreen$$ExternalSyntheticLambda24
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventScreen.updateEvent$lambda$0$8(view);
            }
        });
        String timer = eventData.getTimer();
        if (timer != null) {
            Integer intOrNull = StringsKt.toIntOrNull(timer);
            int intValue = intOrNull != null ? intOrNull.intValue() : 0;
            if (intValue > 0) {
                eventEventsItemBinding.errorOverlay.setVisibility(0);
                eventEventsItemBinding.tvErrorText.setText(getTargetActivity().getString(R.string.event_available_in, new Object[]{formatSeconds(intValue)}));
                final long j = intValue * 1000;
                ?? r2 = new CountDownTimer(j) { // from class: ru.mrlargha.event.EventScreen$updateEvent$1$10$timer$1
                    @Override // android.os.CountDownTimer
                    public void onTick(long j2) {
                        Activity targetActivity;
                        TextView textView = EventEventsItemBinding.this.tvErrorText;
                        targetActivity = this.getTargetActivity();
                        textView.setText(targetActivity.getString(R.string.event_available_in, new Object[]{this.formatSeconds((int) (j2 / 1000))}));
                    }

                    @Override // android.os.CountDownTimer
                    public void onFinish() {
                        EventEventsItemBinding.this.errorOverlay.setVisibility(8);
                    }
                };
                r2.start();
                this.timersList.add(r2);
            }
        }
        String error = eventData.getError();
        if (error != null) {
            eventEventsItemBinding.errorOverlay.setVisibility(0);
            eventEventsItemBinding.tvErrorText.setText(error);
        }
        String image = eventData.getImage();
        if (image != null) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new EventScreen$updateEvent$1$12$1(image, eventEventsItemBinding, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateEvent$lambda$0$2$0(EventScreen eventScreen, EventData eventData, View view) {
        SAMPUIElement.notifyClick$default(eventScreen, eventData.getId(), 3, null, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object, ru.mrlargha.event.EventScreen$setEvent$1$10$timer$1] */
    private final void setEvent(final EventEventsItemBinding eventEventsItemBinding, final EventData eventData) {
        EasterItem easterItem;
        EasterItem easterItem2;
        EasterItem easterItem3;
        if (eventData.getName() != null) {
            eventEventsItemBinding.tvEventName.setText(eventData.getName());
        }
        if (eventData.getDescription() != null) {
            eventEventsItemBinding.tvEventDescription.setText(eventData.getDescription());
        }
        if (eventData.getButtonType() != null) {
            eventEventsItemBinding.btnJoin.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.event.EventScreen$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EventScreen.setEvent$lambda$0$2$0(EventScreen.this, eventData, view);
                }
            });
            String buttonType = eventData.getButtonType();
            int hashCode = buttonType.hashCode();
            if (hashCode != -1500192018) {
                if (hashCode != -1367724422) {
                    if (hashCode == 3267882 && buttonType.equals("join")) {
                        eventEventsItemBinding.btnJoin.setBackgroundResource(R.drawable.event_event_btn_bg);
                        eventEventsItemBinding.btnJoin.setText(getTargetActivity().getString(R.string.event_join));
                        eventEventsItemBinding.btnJoin.setTextColor(Color.parseColor("#3D3D3D"));
                    }
                } else if (buttonType.equals(FacebookDialog.COMPLETION_GESTURE_CANCEL)) {
                    eventEventsItemBinding.btnJoin.setBackgroundResource(R.drawable.event_event_btn_bg_white);
                    eventEventsItemBinding.btnJoin.setText(getTargetActivity().getString(R.string.event_cancel));
                    eventEventsItemBinding.btnJoin.setTextColor(Color.parseColor("#3D3D3D"));
                }
            } else if (buttonType.equals("players_limit")) {
                eventEventsItemBinding.btnJoin.setBackgroundResource(R.drawable.event_event_btn_bg_transparent);
                eventEventsItemBinding.btnJoin.setText(getTargetActivity().getString(R.string.event_players_limit));
                eventEventsItemBinding.btnJoin.setTextColor(Color.parseColor("#BE3D3D3D"));
                eventEventsItemBinding.btnJoin.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.event.EventScreen$$ExternalSyntheticLambda11
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        EventScreen.setEvent$lambda$0$2$1(view);
                    }
                });
            }
        }
        LinearLayout linearLayout = eventEventsItemBinding.attempsContainer;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        if (eventData.getAttempts() != null) {
            LinearLayout linearLayout2 = eventEventsItemBinding.attempsContainer;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
            }
            eventEventsItemBinding.tvAttemptsAvailable.setText(eventData.getAttempts().getCurrent() + "/" + eventData.getAttempts().getMax());
        }
        eventEventsItemBinding.playersContainer.setVisibility(8);
        if (eventData.getPlayers() != null) {
            eventEventsItemBinding.playersContainer.setVisibility(0);
            eventEventsItemBinding.tvParticipants.setText(eventData.getPlayers().getCurrent() + "/" + eventData.getPlayers().getMax());
        }
        List<EasterItem> items = eventData.getItems();
        if (items != null && (easterItem3 = (EasterItem) CollectionsKt.getOrNull(items, 0)) != null) {
            EventPriseItemEventBinding item1 = eventEventsItemBinding.item1;
            Intrinsics.checkNotNullExpressionValue(item1, "item1");
            setPriseItem(item1, easterItem3);
        }
        List<EasterItem> items2 = eventData.getItems();
        if (items2 != null && (easterItem2 = (EasterItem) CollectionsKt.getOrNull(items2, 1)) != null) {
            EventPriseItemEventBinding item2 = eventEventsItemBinding.item2;
            Intrinsics.checkNotNullExpressionValue(item2, "item2");
            setPriseItem(item2, easterItem2);
        }
        List<EasterItem> items3 = eventData.getItems();
        if (items3 != null && (easterItem = (EasterItem) CollectionsKt.getOrNull(items3, 2)) != null) {
            EventPriseItemEventBinding item3 = eventEventsItemBinding.item3;
            Intrinsics.checkNotNullExpressionValue(item3, "item3");
            setPriseItem(item3, easterItem);
        }
        eventEventsItemBinding.errorOverlay.setVisibility(8);
        eventEventsItemBinding.errorOverlay.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.event.EventScreen$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventScreen.setEvent$lambda$0$8(view);
            }
        });
        String timer = eventData.getTimer();
        if (timer != null) {
            Integer intOrNull = StringsKt.toIntOrNull(timer);
            int intValue = intOrNull != null ? intOrNull.intValue() : 0;
            if (intValue > 0) {
                eventEventsItemBinding.errorOverlay.setVisibility(0);
                eventEventsItemBinding.tvErrorText.setText(getTargetActivity().getString(R.string.event_available_in, new Object[]{formatSeconds(intValue)}));
                final long j = intValue * 1000;
                ?? r2 = new CountDownTimer(j) { // from class: ru.mrlargha.event.EventScreen$setEvent$1$10$timer$1
                    @Override // android.os.CountDownTimer
                    public void onTick(long j2) {
                        Activity targetActivity;
                        TextView textView = EventEventsItemBinding.this.tvErrorText;
                        targetActivity = this.getTargetActivity();
                        textView.setText(targetActivity.getString(R.string.event_available_in, new Object[]{this.formatSeconds((int) (j2 / 1000))}));
                    }

                    @Override // android.os.CountDownTimer
                    public void onFinish() {
                        EventEventsItemBinding.this.errorOverlay.setVisibility(8);
                    }
                };
                r2.start();
                this.timersList.add(r2);
            }
        }
        String error = eventData.getError();
        if (error != null) {
            eventEventsItemBinding.errorOverlay.setVisibility(0);
            eventEventsItemBinding.tvErrorText.setText(error);
        }
        String image = eventData.getImage();
        if (image != null) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new EventScreen$setEvent$1$12$1(image, eventEventsItemBinding, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setEvent$lambda$0$2$0(EventScreen eventScreen, EventData eventData, View view) {
        SAMPUIElement.notifyClick$default(eventScreen, eventData.getId(), 3, null, 4, null);
    }

    public final String formatSeconds(int i) {
        int i2 = i / 86400;
        int i3 = (i % 86400) / 3600;
        int i4 = (i % 3600) / 60;
        int i5 = i % 60;
        ArrayList arrayList = new ArrayList();
        if (i2 > 0) {
            String string = getTargetActivity().getString(R.string.event_time_day_short, new Object[]{Integer.valueOf(i2)});
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            arrayList.add(string);
        }
        if (i3 > 0) {
            String string2 = getTargetActivity().getString(R.string.event_time_hour_short, new Object[]{Integer.valueOf(i3)});
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            arrayList.add(string2);
        }
        if (i4 > 0) {
            String string3 = getTargetActivity().getString(R.string.event_time_minute_short, new Object[]{Integer.valueOf(i4)});
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            arrayList.add(string3);
        }
        if (i2 == 0 && i5 > 0) {
            String string4 = getTargetActivity().getString(R.string.event_time_second_short, new Object[]{Integer.valueOf(i5)});
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            arrayList.add(string4);
        }
        if (arrayList.isEmpty()) {
            String string5 = getTargetActivity().getString(R.string.event_time_zero);
            Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
            arrayList.add(string5);
        }
        return CollectionsKt.joinToString$default(arrayList, " ", null, null, 0, null, null, 62, null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final void setPriseItem(EventPriseItemEventBinding eventPriseItemEventBinding, final EasterItem easterItem) {
        int i;
        String str;
        String color = easterItem.getColor();
        switch (color.hashCode()) {
            case -976943172:
                if (color.equals("purple")) {
                    i = ru.mrlargha.commonui.R.drawable.rarity_purple;
                    break;
                }
                i = ru.mrlargha.commonui.R.drawable.rarity_default;
                break;
            case 112785:
                if (color.equals(CasesSameCasesAdapter.NEW)) {
                    i = ru.mrlargha.commonui.R.drawable.rarity_red;
                    break;
                }
                i = ru.mrlargha.commonui.R.drawable.rarity_default;
                break;
            case 3002044:
                if (color.equals("aqua")) {
                    i = ru.mrlargha.commonui.R.drawable.rarity_aqua;
                    break;
                }
                i = ru.mrlargha.commonui.R.drawable.rarity_default;
                break;
            case 3178592:
                if (color.equals("gold")) {
                    i = ru.mrlargha.commonui.R.drawable.rarity_gold;
                    break;
                }
                i = ru.mrlargha.commonui.R.drawable.rarity_default;
                break;
            case 3441014:
                if (color.equals("pink")) {
                    i = ru.mrlargha.commonui.R.drawable.rarity_pink;
                    break;
                }
                i = ru.mrlargha.commonui.R.drawable.rarity_default;
                break;
            default:
                i = ru.mrlargha.commonui.R.drawable.rarity_default;
                break;
        }
        String color2 = easterItem.getColor();
        switch (color2.hashCode()) {
            case -976943172:
                if (color2.equals("purple")) {
                    str = "#6881FF";
                    break;
                }
                str = "#FFFFFF";
                break;
            case 112785:
                if (color2.equals(CasesSameCasesAdapter.NEW)) {
                    str = "#FF3600";
                    break;
                }
                str = "#FFFFFF";
                break;
            case 3002044:
                if (color2.equals("aqua")) {
                    str = "#6FF5FF";
                    break;
                }
                str = "#FFFFFF";
                break;
            case 3178592:
                if (color2.equals("gold")) {
                    str = "#FFBA00";
                    break;
                }
                str = "#FFFFFF";
                break;
            case 3441014:
                if (color2.equals("pink")) {
                    str = "#E500FF";
                    break;
                }
                str = "#FFFFFF";
                break;
            default:
                str = "#FFFFFF";
                break;
        }
        eventPriseItemEventBinding.bg.setBackgroundResource(i);
        eventPriseItemEventBinding.rarity.setBackgroundColor(Color.parseColor(str));
        if (UtilsKt.isArizonaType()) {
            Picasso picasso = Picasso.get();
            String projectResourceUrl$default = FirebaseConfigHelper.getProjectResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null);
            picasso.load(projectResourceUrl$default + "assets/images/donate/" + easterItem.getItemid() + ".webp").into(eventPriseItemEventBinding.imagePrise);
        } else {
            Picasso picasso2 = Picasso.get();
            String projectResourceUrl$default2 = FirebaseConfigHelper.getProjectResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null);
            picasso2.load(projectResourceUrl$default2 + "systems/battlepass/items/" + easterItem.getItemid() + ".webp").into(eventPriseItemEventBinding.imagePrise);
        }
        eventPriseItemEventBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.event.EventScreen$$ExternalSyntheticLambda19
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventScreen.setPriseItem$lambda$0$0(EventScreen.this, easterItem, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setPriseItem$lambda$0$0(EventScreen eventScreen, EasterItem easterItem, View view) {
        String name = easterItem.getName();
        Intrinsics.checkNotNull(view);
        eventScreen.onPriseInfo(name, view);
    }

    private final void stopVideo() {
        this.binding.video.playerView.setVisibility(8);
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            exoPlayer.stop();
        }
        ExoPlayer exoPlayer2 = this.player;
        if (exoPlayer2 != null) {
            exoPlayer2.release();
        }
        this.player = null;
    }

    private final void setVideo() {
        try {
            ExoPlayer exoPlayer = this.player;
            if (exoPlayer != null) {
                exoPlayer.stop();
            }
            ExoPlayer exoPlayer2 = this.player;
            if (exoPlayer2 != null) {
                exoPlayer2.release();
            }
            this.player = null;
            this.binding.video.playerView.setVisibility(0);
            File file = new File(getTargetActivity().getExternalFilesDir(null), "/SAMP/easter_video.webm");
            if (file.exists()) {
                Uri parse = Uri.parse(file.getPath());
                Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
                ExoPlayer build = new ExoPlayer.Builder(getTargetActivity()).build();
                Intrinsics.checkNotNullExpressionValue(build, "build(...)");
                this.player = build;
                this.binding.video.playerView.setPlayer(build);
                MediaItem fromUri = MediaItem.fromUri(parse);
                Intrinsics.checkNotNullExpressionValue(fromUri, "fromUri(...)");
                build.setMediaItem(fromUri);
                build.prepare();
                build.play();
                return;
            }
            Toast.makeText(getTargetActivity(), getTargetActivity().getString(R.string.event_video_not_found), 1).show();
        } catch (Exception e) {
            Toast.makeText(getTargetActivity(), getTargetActivity().getString(R.string.event_video_error), 1).show();
            e.printStackTrace();
            Log.e("videoEasterBinding", "Can't start video");
        }
    }

    private final void onTaskItemClick(QuestData questData) {
        SAMPUIElement.notifyClick$default(this, questData.getId(), 2, null, 4, null);
    }

    private final void onShopItemClick(ShopItem shopItem) {
        SAMPUIElement.notifyClick$default(this, shopItem.getId(), 4, null, 4, null);
    }

    private final void onPriseInfo(final String str, final View view) {
        Log.d("onPriseInfo", str);
        final EventScreenBinding eventScreenBinding = this.binding;
        view.post(new Runnable() { // from class: ru.mrlargha.event.EventScreen$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                EventScreen.onPriseInfo$lambda$0$0(view, eventScreenBinding, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPriseInfo$lambda$0$0(View view, final EventScreenBinding eventScreenBinding, final String str) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        final float width = iArr[0] + (view.getWidth() / 2);
        final float height = iArr[1] + (view.getHeight() / 2);
        Log.d("onPriseInfo", width + " , " + height);
        eventScreenBinding.infoText.post(new Runnable() { // from class: ru.mrlargha.event.EventScreen$$ExternalSyntheticLambda25
            @Override // java.lang.Runnable
            public final void run() {
                EventScreen.onPriseInfo$lambda$0$0$0(EventScreenBinding.this, width, height, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPriseInfo$lambda$0$0$0(final EventScreenBinding eventScreenBinding, float f, float f2, String str) {
        eventScreenBinding.infoText.setX(f);
        eventScreenBinding.infoText.setY(f2 - eventScreenBinding.infoText.getHeight());
        eventScreenBinding.infoText.setText(str);
        eventScreenBinding.infoTextBg.setVisibility(0);
        eventScreenBinding.infoTextBg.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.event.EventScreen$$ExternalSyntheticLambda20
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventScreen.onPriseInfo$lambda$0$0$0$0(EventScreenBinding.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPriseInfo$lambda$0$0$0$0(EventScreenBinding eventScreenBinding, View view) {
        eventScreenBinding.infoTextBg.setVisibility(8);
    }

    private final void setupAdapters() {
        EventScreenBinding eventScreenBinding = this.binding;
        eventScreenBinding.task.rvTask.setAdapter(this.questAdapter);
        eventScreenBinding.main.rvPrice.setAdapter(this.levelItemsAdapter);
        eventScreenBinding.shop.rvItems.setAdapter(this.shopAdapter);
        eventScreenBinding.rating.rv.setAdapter(this.ratingAdapter);
    }

    private final void clearAdapters() {
        this.questAdapter.clearList();
        this.ratingAdapter.clearList();
    }

    private final void clearTimers() {
        for (CountDownTimer countDownTimer : this.timersList) {
            countDownTimer.cancel();
        }
    }

    private final void setupNavigation() {
        EventTopbarBinding eventTopbarBinding = this.binding.topElements;
        eventTopbarBinding.tabMain.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.event.EventScreen$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventScreen.setupNavigation$lambda$0$0(EventScreen.this, view);
            }
        });
        eventTopbarBinding.tabShop.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.event.EventScreen$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventScreen.setupNavigation$lambda$0$1(EventScreen.this, view);
            }
        });
        eventTopbarBinding.tabTask.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.event.EventScreen$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventScreen.setupNavigation$lambda$0$2(EventScreen.this, view);
            }
        });
        this.binding.ship.rating.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.event.EventScreen$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventScreen.setupNavigation$lambda$0$3$0(EventScreen.this, view);
            }
        });
        this.binding.rating.back.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.event.EventScreen$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventScreen.setupNavigation$lambda$0$4$0(EventScreen.this, view);
            }
        });
        eventTopbarBinding.backButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.event.EventScreen$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventScreen.setupNavigation$lambda$0$5(EventScreen.this, view);
            }
        });
        Picasso.get().load(FirebaseConfigHelper.INSTANCE.getProjectResourceUrl(false) + (UtilsKt.isArizonaType() ? "/systems/battlepass/easter-2026/preview.webp" : "/systems/pirate-event/preview.webp")).into(this.binding.main.ivVideo);
        this.binding.main.ivVideo.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.event.EventScreen$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SAMPUIElement.notifyClick$default(EventScreen.this, 1, 10, null, 4, null);
            }
        });
        this.binding.topElements.tabVideoBack.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.event.EventScreen$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventScreen.setupNavigation$lambda$2(EventScreen.this, view);
            }
        });
        final EventShopSceenBinding eventShopSceenBinding = this.binding.shop;
        eventShopSceenBinding.resultBack.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.event.EventScreen$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventScreen.setupNavigation$lambda$3$0(EventShopSceenBinding.this, view);
            }
        });
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new EventScreen$setupNavigation$4$2(eventShopSceenBinding, this, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new EventScreen$setupNavigation$4$3(eventShopSceenBinding, this, null), 3, null);
        final EventMainResultScreenBinding eventMainResultScreenBinding = this.binding.resultMain;
        eventMainResultScreenBinding.resultBack.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.event.EventScreen$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventScreen.setupNavigation$lambda$4$0(EventMainResultScreenBinding.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$0$0(EventScreen eventScreen, View view) {
        SAMPUIElement.notifyClick$default(eventScreen, EasterBites.Main.getValue(), 1, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$0$1(EventScreen eventScreen, View view) {
        SAMPUIElement.notifyClick$default(eventScreen, EasterBites.Shop.getValue(), 1, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$0$2(EventScreen eventScreen, View view) {
        SAMPUIElement.notifyClick$default(eventScreen, EasterBites.Task.getValue(), 1, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$0$3$0(EventScreen eventScreen, View view) {
        SAMPUIElement.notifyClick$default(eventScreen, EasterBites.Rating.getValue(), 1, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$0$4$0(EventScreen eventScreen, View view) {
        SAMPUIElement.notifyClick$default(eventScreen, EasterBites.Ship.getValue(), 1, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$0$5(EventScreen eventScreen, View view) {
        eventScreen.stopVideo();
        SAMPUIElement.notifyClick$default(eventScreen, 0, 0, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void setupNavigation$lambda$2(EventScreen eventScreen, View view) {
        eventScreen.navigateTo(Navigation.Main);
        eventScreen.stopVideo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$3$0(EventShopSceenBinding eventShopSceenBinding, View view) {
        eventShopSceenBinding.result.setVisibility(8);
        eventShopSceenBinding.rvItems.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$4$0(EventMainResultScreenBinding eventMainResultScreenBinding, View view) {
        eventMainResultScreenBinding.getRoot().setVisibility(8);
    }

    private final void navigateTo(Navigation navigation) {
        clearAdapters();
        this.binding.main.getRoot().setVisibility(8);
        this.binding.task.getRoot().setVisibility(8);
        this.binding.events.getRoot().setVisibility(8);
        this.binding.shop.getRoot().setVisibility(8);
        this.binding.video.getRoot().setVisibility(8);
        this.binding.resultMain.getRoot().setVisibility(8);
        this.binding.ship.getRoot().setVisibility(8);
        this.binding.rating.getRoot().setVisibility(8);
        this.binding.shop.result.setVisibility(8);
        this.binding.bg.setBackgroundResource(R.drawable.event_main_bg2);
        this.binding.infoTextBg.setVisibility(8);
        EventTopbarBinding eventTopbarBinding = this.binding.topElements;
        eventTopbarBinding.tabsContainer.setVisibility(0);
        eventTopbarBinding.videoTabsContainer.setVisibility(8);
        eventTopbarBinding.tabMain.setBackgroundResource(R.drawable.event_tab_unselect_bg);
        eventTopbarBinding.tabShop.setBackgroundResource(R.drawable.event_tab_unselect_bg);
        eventTopbarBinding.tabTask.setBackgroundResource(R.drawable.event_tab_unselect_bg);
        eventTopbarBinding.tabMain.setTextColor(-1);
        eventTopbarBinding.tabShop.setTextColor(-1);
        eventTopbarBinding.tabTask.setTextColor(-1);
        int i = WhenMappings.$EnumSwitchMapping$0[navigation.ordinal()];
        if (i == 1) {
            this.binding.bg.setBackgroundResource(R.drawable.event_main_bg);
            this.binding.main.getRoot().setVisibility(0);
            this.binding.topElements.tabMain.setBackgroundResource(R.drawable.event_main_tab_select_bg);
            this.binding.topElements.tabMain.setTextColor(this.textSelectedColor);
        } else if (i == 2) {
            clearTimers();
            this.binding.task.getRoot().setVisibility(0);
            this.binding.topElements.tabTask.setBackgroundResource(R.drawable.event_main_tab_select_bg);
            this.binding.topElements.tabTask.setTextColor(this.textSelectedColor);
        } else if (i == 3) {
            this.binding.events.getRoot().setVisibility(0);
        } else if (i == 4) {
            this.binding.shop.getRoot().setVisibility(0);
            this.binding.topElements.tabShop.setBackgroundResource(R.drawable.event_main_tab_select_bg);
            this.binding.topElements.tabShop.setTextColor(this.textSelectedColor);
        } else if (i != 5) {
        } else {
            this.binding.video.getRoot().setVisibility(0);
            this.binding.topElements.tabsContainer.setVisibility(8);
            this.binding.topElements.moneyContainer.setVisibility(8);
            this.binding.topElements.videoTabsContainer.setVisibility(0);
            setVideo();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: EventScreen.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lru/mrlargha/event/EventScreen$EasterBites;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Main", "Task", "Event", "Shop", "Ship", "Rating", "event"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class EasterBites {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ EasterBites[] $VALUES;
        private final int value;
        public static final EasterBites Main = new EasterBites("Main", 0, 1);
        public static final EasterBites Task = new EasterBites("Task", 1, 2);
        public static final EasterBites Event = new EasterBites("Event", 2, 4);
        public static final EasterBites Shop = new EasterBites("Shop", 3, 8);
        public static final EasterBites Ship = new EasterBites("Ship", 4, 32);
        public static final EasterBites Rating = new EasterBites("Rating", 5, 64);

        private static final /* synthetic */ EasterBites[] $values() {
            return new EasterBites[]{Main, Task, Event, Shop, Ship, Rating};
        }

        public static EnumEntries<EasterBites> getEntries() {
            return $ENTRIES;
        }

        public static EasterBites valueOf(String str) {
            return (EasterBites) Enum.valueOf(EasterBites.class, str);
        }

        public static EasterBites[] values() {
            return (EasterBites[]) $VALUES.clone();
        }

        private EasterBites(String str, int i, int i2) {
            this.value = i2;
        }

        public final int getValue() {
            return this.value;
        }

        static {
            EasterBites[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: EventScreen.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lru/mrlargha/event/EventScreen$Navigation;", "", "<init>", "(Ljava/lang/String;I)V", "Main", "Task", "Events", "Shop", "Video", "Ship", "Rating", "event"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Navigation {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Navigation[] $VALUES;
        public static final Navigation Main = new Navigation("Main", 0);
        public static final Navigation Task = new Navigation("Task", 1);
        public static final Navigation Events = new Navigation("Events", 2);
        public static final Navigation Shop = new Navigation("Shop", 3);
        public static final Navigation Video = new Navigation("Video", 4);
        public static final Navigation Ship = new Navigation("Ship", 5);
        public static final Navigation Rating = new Navigation("Rating", 6);

        private static final /* synthetic */ Navigation[] $values() {
            return new Navigation[]{Main, Task, Events, Shop, Video, Ship, Rating};
        }

        public static EnumEntries<Navigation> getEntries() {
            return $ENTRIES;
        }

        public static Navigation valueOf(String str) {
            return (Navigation) Enum.valueOf(Navigation.class, str);
        }

        public static Navigation[] values() {
            return (Navigation[]) $VALUES.clone();
        }

        private Navigation(String str, int i) {
        }

        static {
            Navigation[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    /* compiled from: EventScreen.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lru/mrlargha/event/EventScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "correctIds", "", "Lru/mrlargha/commonui/core/UIElementID;", "getCorrectIds", "()Ljava/util/Set;", "event"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        private final Set<UIElementID> correctIds = SetsKt.setOf((Object[]) new UIElementID[]{UIElementID.ARIZONA_EVENT, UIElementID.RODINA_EVENT});

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new EventScreen(targetActivity, i);
        }

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public Set<UIElementID> getCorrectIds() {
            return this.correctIds;
        }
    }
}
