package ru.mrlargha.commonui.elements.easter;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.media3.common.MediaItem;
import androidx.media3.exoplayer.ExoPlayer;
import com.facebook.widget.FacebookDialog;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.squareup.picasso.Picasso;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.datetime.internal.DateCalculationsKt;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.databinding.EasterBattlePassEventItemBinding;
import ru.mrlargha.commonui.databinding.EasterBattlePassMainResultScreenBinding;
import ru.mrlargha.commonui.databinding.EasterBattlePassMainScreenBinding;
import ru.mrlargha.commonui.databinding.EasterBattlePassScreenBinding;
import ru.mrlargha.commonui.databinding.EasterBattlePassShopSceenBinding;
import ru.mrlargha.commonui.databinding.EasterBattlepassPriseItemEventBinding;
import ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController;
import ru.mrlargha.commonui.elements.battlepassWinter2025.utils.TimeConverterKt;
import ru.mrlargha.commonui.elements.easter.adapters.AwardsAdapter;
import ru.mrlargha.commonui.elements.easter.adapters.QuestAdapter;
import ru.mrlargha.commonui.elements.easter.adapters.ShopAdapter;
import ru.mrlargha.commonui.elements.easter.data.AwardItemData;
import ru.mrlargha.commonui.elements.easter.data.EasterItem;
import ru.mrlargha.commonui.elements.easter.data.EventData;
import ru.mrlargha.commonui.elements.easter.data.MainInfo;
import ru.mrlargha.commonui.elements.easter.data.QuestData;
import ru.mrlargha.commonui.elements.easter.data.ShopInfo;
import ru.mrlargha.commonui.elements.easter.data.ShopItem;
import ru.mrlargha.commonui.elements.easter.data.ShopResult;
import ru.mrlargha.commonui.elements.easter.data.ShopTopItem;
import ru.mrlargha.commonui.utils.FirebaseConfigHelper;
import ru.mrlargha.commonui.utils.MapperKt;
/* compiled from: EasterScreen.kt */
@Metadata(d1 = {"\u0000à\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0003defB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0012H\u0016J\u0018\u00104\u001a\u0002022\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u0006H\u0016J\b\u00108\u001a\u000202H\u0002J\u0016\u00109\u001a\u0002022\f\u0010:\u001a\b\u0012\u0004\u0012\u00020;0\u001dH\u0002J\u0010\u0010<\u001a\u0002022\u0006\u0010:\u001a\u00020 H\u0002J\u0010\u0010=\u001a\u0002022\u0006\u0010:\u001a\u00020>H\u0002J\u0010\u0010?\u001a\u0002022\u0006\u0010:\u001a\u00020@H\u0002J\u0010\u0010A\u001a\u0002022\u0006\u0010:\u001a\u00020@H\u0002J\u0016\u0010B\u001a\u0002022\f\u0010:\u001a\b\u0012\u0004\u0012\u00020C0\u001dH\u0002J\u0016\u0010D\u001a\u0002022\f\u0010:\u001a\b\u0012\u0004\u0012\u00020C0\u001dH\u0002J\u0016\u0010E\u001a\u0002022\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00060\u001dH\u0002J\u0016\u0010G\u001a\u0002022\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0002J\u0010\u0010I\u001a\u0002022\u0006\u0010J\u001a\u00020\u0006H\u0002J\u0018\u0010K\u001a\u0002022\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020CH\u0002J\u0018\u0010O\u001a\u0002022\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020CH\u0002J\u000e\u0010P\u001a\u0002062\u0006\u0010Q\u001a\u00020\u0006J\u0018\u0010R\u001a\u0002022\u0006\u0010L\u001a\u00020S2\u0006\u0010T\u001a\u00020UH\u0002J\b\u0010V\u001a\u000202H\u0002J\b\u0010W\u001a\u000202H\u0002J\u0010\u0010X\u001a\u0002022\u0006\u0010N\u001a\u00020;H\u0002J\u0010\u0010Y\u001a\u0002022\u0006\u0010N\u001a\u00020ZH\u0002J\u0018\u0010[\u001a\u0002022\u0006\u0010\\\u001a\u0002062\u0006\u0010L\u001a\u00020\nH\u0002J\b\u0010]\u001a\u000202H\u0002J\b\u0010^\u001a\u000202H\u0002J\b\u0010_\u001a\u000202H\u0002J\b\u0010`\u001a\u000202H\u0002J\u0010\u0010a\u001a\u0002022\u0006\u0010b\u001a\u00020cH\u0002R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u000b*\u0004\u0018\u00010\u00100\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010%\u001a\u00020&¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010)\u001a\u00020*¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020.X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082.¢\u0006\u0002\n\u0000¨\u0006g"}, d2 = {"Lru/mrlargha/commonui/elements/easter/EasterScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "Lru/mrlargha/commonui/elements/authorization/presentation/InterfaceController;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "screen", "Landroid/view/View;", "kotlin.jvm.PlatformType", "binding", "Lru/mrlargha/commonui/databinding/EasterBattlePassScreenBinding;", "textSelectedColor", "sharedPref", "Landroid/content/SharedPreferences;", "isArizonaType", "", "questAdapter", "Lru/mrlargha/commonui/elements/easter/adapters/QuestAdapter;", "shopAdapter", "Lru/mrlargha/commonui/elements/easter/adapters/ShopAdapter;", "levelItemsAdapter", "Lru/mrlargha/commonui/elements/easter/adapters/AwardsAdapter;", "timersList", "", "Landroid/os/CountDownTimer;", "_bpUsualData", "", "Lru/mrlargha/commonui/elements/easter/data/AwardItemData;", "battlePassInfo", "Lru/mrlargha/commonui/elements/easter/data/MainInfo;", "eventPosition", "", "player", "Landroidx/media3/exoplayer/ExoPlayer;", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getExceptionHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "retrofit", "Lretrofit2/Retrofit;", "api", "Lru/mrlargha/commonui/elements/easter/EasterApi;", "setVisible", "", "visible", "onBackendMessage", "data", "", "subId", "setupRetrofit", "setListQuest", "info", "Lru/mrlargha/commonui/elements/easter/data/QuestData;", "setMainPageInfo", "setShopInfo", "Lru/mrlargha/commonui/elements/easter/data/ShopInfo;", "setShopResult", "Lru/mrlargha/commonui/elements/easter/data/ShopResult;", "setMainResult", "setListEvent", "Lru/mrlargha/commonui/elements/easter/data/EventData;", "updateListEvent", "updateBpAwards", "awardsStatusList", "updateLevelItems", "pairList", "onClaimItem", "position", "updateEvent", "view", "Lru/mrlargha/commonui/databinding/EasterBattlePassEventItemBinding;", "item", "setEvent", "formatSeconds", "seconds", "setPriseItem", "Lru/mrlargha/commonui/databinding/EasterBattlepassPriseItemEventBinding;", "prise", "Lru/mrlargha/commonui/elements/easter/data/EasterItem;", "stopVideo", "setVideo", "onTaskItemClick", "onShopItemClick", "Lru/mrlargha/commonui/elements/easter/data/ShopItem;", "onPriseInfo", "text", "setupAdapters", "clearAdapters", "clearTimers", "setupNavigation", "navigateTo", "nav", "Lru/mrlargha/commonui/elements/easter/EasterScreen$Navigation;", "EasterBites", "Navigation", "Spawner", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EasterScreen extends SAMPUIElement implements InterfaceController {
    private List<AwardItemData> _bpUsualData;
    private EasterApi api;
    private MainInfo battlePassInfo;
    private final EasterBattlePassScreenBinding binding;
    private final Map<Integer, Integer> eventPosition;
    private final CoroutineExceptionHandler exceptionHandler;
    private final boolean isArizonaType;
    private final AwardsAdapter levelItemsAdapter;
    private ExoPlayer player;
    private final QuestAdapter questAdapter;
    private Retrofit retrofit;
    private final CoroutineScope scope;
    private final View screen;
    private final SharedPreferences sharedPref;
    private final ShopAdapter shopAdapter;
    private final int textSelectedColor;
    private final List<CountDownTimer> timersList;

    /* compiled from: EasterScreen.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
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
    public static final void setEvent$lambda$47$lambda$37$lambda$36(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setEvent$lambda$47$lambda$43(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateEvent$lambda$32$lambda$22$lambda$21(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateEvent$lambda$32$lambda$28(View view) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EasterScreen(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View screen = targetActivity.getLayoutInflater().inflate(R.layout.easter_battle_pass_screen, (ViewGroup) null);
        this.screen = screen;
        EasterBattlePassScreenBinding bind = EasterBattlePassScreenBinding.bind(screen);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        this.textSelectedColor = Color.parseColor("#1F2329");
        SharedPreferences sharedPreferences = targetActivity.getSharedPreferences("flavorType", 0);
        this.sharedPref = sharedPreferences;
        boolean z = sharedPreferences.getBoolean("isArizonaType", false);
        this.isArizonaType = z;
        this.questAdapter = new QuestAdapter(z, new Function1() { // from class: ru.mrlargha.commonui.elements.easter.EasterScreen$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit questAdapter$lambda$0;
                questAdapter$lambda$0 = EasterScreen.questAdapter$lambda$0(EasterScreen.this, (QuestData) obj);
                return questAdapter$lambda$0;
            }
        }, new Function2() { // from class: ru.mrlargha.commonui.elements.easter.EasterScreen$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit questAdapter$lambda$1;
                questAdapter$lambda$1 = EasterScreen.questAdapter$lambda$1(EasterScreen.this, (String) obj, (View) obj2);
                return questAdapter$lambda$1;
            }
        });
        this.shopAdapter = new ShopAdapter(z, new Function1() { // from class: ru.mrlargha.commonui.elements.easter.EasterScreen$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit shopAdapter$lambda$2;
                shopAdapter$lambda$2 = EasterScreen.shopAdapter$lambda$2(EasterScreen.this, (ShopItem) obj);
                return shopAdapter$lambda$2;
            }
        });
        this.levelItemsAdapter = new AwardsAdapter(new Function2() { // from class: ru.mrlargha.commonui.elements.easter.EasterScreen$$ExternalSyntheticLambda20
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit levelItemsAdapter$lambda$3;
                levelItemsAdapter$lambda$3 = EasterScreen.levelItemsAdapter$lambda$3(EasterScreen.this, ((Boolean) obj).booleanValue(), ((Integer) obj2).intValue());
                return levelItemsAdapter$lambda$3;
            }
        });
        this.timersList = new ArrayList();
        this._bpUsualData = CollectionsKt.emptyList();
        this.eventPosition = new LinkedHashMap();
        ExoPlayer build = new ExoPlayer.Builder(targetActivity).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        this.player = build;
        EasterScreen$special$$inlined$CoroutineExceptionHandler$1 easterScreen$special$$inlined$CoroutineExceptionHandler$1 = new EasterScreen$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key);
        this.exceptionHandler = easterScreen$special$$inlined$CoroutineExceptionHandler$1;
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)).plus(easterScreen$special$$inlined$CoroutineExceptionHandler$1));
        setupRetrofit();
        Intrinsics.checkNotNullExpressionValue(screen, "screen");
        addViewToConstraintLayout(screen, -1, -1);
        setupNavigation();
        setupAdapters();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit questAdapter$lambda$0(EasterScreen easterScreen, QuestData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        easterScreen.onTaskItemClick(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit questAdapter$lambda$1(EasterScreen easterScreen, String text, View view) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(view, "view");
        easterScreen.onPriseInfo(text, view);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit shopAdapter$lambda$2(EasterScreen easterScreen, ShopItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        easterScreen.onShopItemClick(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit levelItemsAdapter$lambda$3(EasterScreen easterScreen, boolean z, int i) {
        easterScreen.onClaimItem(i);
        return Unit.INSTANCE;
    }

    public final CoroutineExceptionHandler getExceptionHandler() {
        return this.exceptionHandler;
    }

    public final CoroutineScope getScope() {
        return this.scope;
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
    public void onBackendMessage(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        try {
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
                    setShopInfo((ShopInfo) MapperKt.toModel(data, ShopInfo.class));
                    return;
                case 9:
                    this.binding.moneyText.setText(data);
                    return;
            }
        } catch (Exception e) {
            Log.d("family_rodina", data + "  " + e.getMessage());
            e.printStackTrace();
            Toast.makeText(getTargetActivity(), "Ошибка в интерфейсе : " + getBackendID(), 1).show();
        }
    }

    private final void setupRetrofit() {
        String str;
        if (this.isArizonaType) {
            str = FirebaseConfigHelper.INSTANCE.getResourceUrl() + "projects/arizona-rp/systems/battlepass_holiday/";
        } else {
            str = FirebaseConfigHelper.INSTANCE.getResourceUrl() + "projects/rodina-rp/systems/battlepass/";
        }
        Retrofit build = new Retrofit.Builder().baseUrl(str).addConverterFactory(GsonConverterFactory.create()).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        this.retrofit = build;
        if (build == null) {
            Intrinsics.throwUninitializedPropertyAccessException("retrofit");
            build = null;
        }
        Object create = build.create(EasterApi.class);
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        this.api = (EasterApi) create;
    }

    private final void setListQuest(List<QuestData> list) {
        this.questAdapter.addAllItems(list);
    }

    private final void setMainPageInfo(MainInfo mainInfo) {
        this.battlePassInfo = mainInfo;
        updateBpAwards(mainInfo.getAvailableToReceive());
        EasterBattlePassMainScreenBinding easterBattlePassMainScreenBinding = this.binding.main;
        easterBattlePassMainScreenBinding.levelPassText.setText(String.valueOf(mainInfo.getLevel()));
        TextView textView = easterBattlePassMainScreenBinding.mainExperienceText;
        int exp = mainInfo.getExp();
        textView.setText(exp + RemoteSettings.FORWARD_SLASH_STRING + mainInfo.getMaxExp());
        easterBattlePassMainScreenBinding.progressExperience.setMax(mainInfo.getMaxExp());
        easterBattlePassMainScreenBinding.progressExperience.setProgress(mainInfo.getExp());
        easterBattlePassMainScreenBinding.remainingTimeTextMain.setText(TimeConverterKt.mainPageTimeConvert(mainInfo.getTimestampEnd()));
    }

    private final void setShopInfo(ShopInfo shopInfo) {
        this.shopAdapter.clearList();
        this.shopAdapter.addAllItems(shopInfo.getItems());
        EasterBattlePassShopSceenBinding easterBattlePassShopSceenBinding = this.binding.shop;
        TextView textView = easterBattlePassShopSceenBinding.top1name;
        ShopTopItem shopTopItem = (ShopTopItem) CollectionsKt.getOrNull(shopInfo.getTop(), 0);
        textView.setText(shopTopItem != null ? shopTopItem.getName() : null);
        TextView textView2 = easterBattlePassShopSceenBinding.top2name;
        ShopTopItem shopTopItem2 = (ShopTopItem) CollectionsKt.getOrNull(shopInfo.getTop(), 1);
        textView2.setText(shopTopItem2 != null ? shopTopItem2.getName() : null);
        TextView textView3 = easterBattlePassShopSceenBinding.top1desc;
        ShopTopItem shopTopItem3 = (ShopTopItem) CollectionsKt.getOrNull(shopInfo.getTop(), 0);
        textView3.setText(shopTopItem3 != null ? shopTopItem3.getDescription() : null);
        TextView textView4 = easterBattlePassShopSceenBinding.top2desc;
        ShopTopItem shopTopItem4 = (ShopTopItem) CollectionsKt.getOrNull(shopInfo.getTop(), 1);
        textView4.setText(shopTopItem4 != null ? shopTopItem4.getDescription() : null);
    }

    private final void setShopResult(ShopResult shopResult) {
        EasterBattlePassShopSceenBinding easterBattlePassShopSceenBinding = this.binding.shop;
        easterBattlePassShopSceenBinding.result.setVisibility(0);
        easterBattlePassShopSceenBinding.rvItems.setVisibility(8);
        easterBattlePassShopSceenBinding.awardName.setText(shopResult.getName());
        easterBattlePassShopSceenBinding.tvDescription.setText(shopResult.getCaption());
        if (this.isArizonaType) {
            Picasso picasso = Picasso.get();
            String resourceUrl = FirebaseConfigHelper.INSTANCE.getResourceUrl();
            picasso.load(resourceUrl + "/projects/arizona-rp/systems/battlepass_holiday/shop_image/" + shopResult.getImage() + ".webp").into(easterBattlePassShopSceenBinding.ivAward);
        } else {
            Picasso picasso2 = Picasso.get();
            String resourceUrl2 = FirebaseConfigHelper.INSTANCE.getResourceUrl();
            picasso2.load(resourceUrl2 + "/projects/rodina-rp/systems/battlepass/items/" + shopResult.getImage() + ".webp").into(easterBattlePassShopSceenBinding.ivAward);
        }
        easterBattlePassShopSceenBinding.count.setText(shopResult.getCount() + " шт.");
    }

    private final void setMainResult(ShopResult shopResult) {
        EasterBattlePassMainResultScreenBinding easterBattlePassMainResultScreenBinding = this.binding.resultMain;
        easterBattlePassMainResultScreenBinding.getRoot().setVisibility(0);
        easterBattlePassMainResultScreenBinding.awardName.setText(shopResult.getName());
        easterBattlePassMainResultScreenBinding.tvDescription.setText(shopResult.getCaption());
        if (this.isArizonaType) {
            Picasso picasso = Picasso.get();
            String resourceUrl = FirebaseConfigHelper.INSTANCE.getResourceUrl();
            picasso.load(resourceUrl + "/projects/arizona-rp/systems/battlepass_holiday/redwards/" + shopResult.getImage() + ".webp").into(easterBattlePassMainResultScreenBinding.ivAward);
        } else {
            Picasso picasso2 = Picasso.get();
            String resourceUrl2 = FirebaseConfigHelper.INSTANCE.getResourceUrl();
            picasso2.load(resourceUrl2 + "/projects/rodina-rp/systems/battlepass/items/" + shopResult.getImage() + ".webp").into(easterBattlePassMainResultScreenBinding.ivAward);
        }
        easterBattlePassMainResultScreenBinding.count.setText(shopResult.getCount() + " шт.");
    }

    private final void setListEvent(List<EventData> list) {
        EventData eventData = (EventData) CollectionsKt.getOrNull(list, 0);
        if (eventData != null) {
            EasterBattlePassEventItemBinding event1 = this.binding.events.event1;
            Intrinsics.checkNotNullExpressionValue(event1, "event1");
            setEvent(event1, eventData);
            this.eventPosition.put(Integer.valueOf(eventData.getId()), 1);
        }
        EventData eventData2 = (EventData) CollectionsKt.getOrNull(list, 1);
        if (eventData2 != null) {
            EasterBattlePassEventItemBinding event2 = this.binding.events.event2;
            Intrinsics.checkNotNullExpressionValue(event2, "event2");
            setEvent(event2, eventData2);
            this.eventPosition.put(Integer.valueOf(eventData2.getId()), 2);
        }
        EventData eventData3 = (EventData) CollectionsKt.getOrNull(list, 2);
        if (eventData3 != null) {
            EasterBattlePassEventItemBinding event3 = this.binding.events.event3;
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
            EasterBattlePassEventItemBinding event1 = this.binding.events.event1;
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
            EasterBattlePassEventItemBinding event2 = this.binding.events.event2;
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
            EasterBattlePassEventItemBinding event3 = this.binding.events.event3;
            Intrinsics.checkNotNullExpressionValue(event3, "event3");
            updateEvent(event3, eventData3);
        }
    }

    private final void updateBpAwards(List<Integer> list) {
        BuildersKt__Builders_commonKt.launch$default(this.scope, Dispatchers.getIO(), null, new EasterScreen$updateBpAwards$1(this, list, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateLevelItems(List<AwardItemData> list) {
        AwardsAdapter awardsAdapter = this.levelItemsAdapter;
        MainInfo mainInfo = this.battlePassInfo;
        awardsAdapter.setData(list, mainInfo != null ? mainInfo.getLevel() : 0, this.isArizonaType);
    }

    private final void onClaimItem(int i) {
        SAMPUIElement.notifyClick$default(this, i, 5, null, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v6, types: [ru.mrlargha.commonui.elements.easter.EasterScreen$updateEvent$1$10$timer$1, java.lang.Object] */
    private final void updateEvent(final EasterBattlePassEventItemBinding easterBattlePassEventItemBinding, final EventData eventData) {
        EasterItem easterItem;
        EasterItem easterItem2;
        EasterItem easterItem3;
        if (eventData.getName() != null) {
            easterBattlePassEventItemBinding.tvEventName.setText(eventData.getName());
        }
        if (eventData.getDescription() != null) {
            easterBattlePassEventItemBinding.tvEventDescription.setText(eventData.getDescription());
        }
        if (eventData.getButtonType() != null) {
            easterBattlePassEventItemBinding.btnJoin.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.easter.EasterScreen$$ExternalSyntheticLambda11
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EasterScreen.updateEvent$lambda$32$lambda$22$lambda$20(EasterScreen.this, eventData, view);
                }
            });
            String buttonType = eventData.getButtonType();
            if (buttonType != null) {
                int hashCode = buttonType.hashCode();
                if (hashCode != -1500192018) {
                    if (hashCode != -1367724422) {
                        if (hashCode == 3267882 && buttonType.equals("join")) {
                            easterBattlePassEventItemBinding.btnJoin.setBackgroundResource(R.drawable.easter_battle_pass_event_btn_bg);
                            easterBattlePassEventItemBinding.btnJoin.setText("Присоединиться");
                            easterBattlePassEventItemBinding.btnJoin.setTextColor(Color.parseColor("#3D3D3D"));
                        }
                    } else if (buttonType.equals(FacebookDialog.COMPLETION_GESTURE_CANCEL)) {
                        easterBattlePassEventItemBinding.btnJoin.setBackgroundResource(R.drawable.easter_battle_pass_event_btn_bg_white);
                        easterBattlePassEventItemBinding.btnJoin.setText("Отказаться от участия");
                        easterBattlePassEventItemBinding.btnJoin.setTextColor(Color.parseColor("#3D3D3D"));
                    }
                } else if (buttonType.equals("players_limit")) {
                    easterBattlePassEventItemBinding.btnJoin.setBackgroundResource(R.drawable.easter_battle_pass_event_btn_bg_transparent);
                    easterBattlePassEventItemBinding.btnJoin.setText("Лимит участников");
                    easterBattlePassEventItemBinding.btnJoin.setTextColor(Color.parseColor("#BE3D3D3D"));
                    easterBattlePassEventItemBinding.btnJoin.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.easter.EasterScreen$$ExternalSyntheticLambda15
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            EasterScreen.updateEvent$lambda$32$lambda$22$lambda$21(view);
                        }
                    });
                }
            }
        }
        if (eventData.getAttempts() != null) {
            easterBattlePassEventItemBinding.tvAttemptsAvailable.setText(eventData.getAttempts().getCurrent() + RemoteSettings.FORWARD_SLASH_STRING + eventData.getAttempts().getMax());
            easterBattlePassEventItemBinding.playersContainer.setVisibility(8);
        }
        if (eventData.getPlayers() != null) {
            easterBattlePassEventItemBinding.playersContainer.setVisibility(0);
            easterBattlePassEventItemBinding.tvParticipants.setText(eventData.getPlayers().getCurrent() + RemoteSettings.FORWARD_SLASH_STRING + eventData.getPlayers().getMax());
        }
        List<EasterItem> items = eventData.getItems();
        if (items != null && (easterItem3 = (EasterItem) CollectionsKt.getOrNull(items, 0)) != null) {
            EasterBattlepassPriseItemEventBinding item1 = easterBattlePassEventItemBinding.item1;
            Intrinsics.checkNotNullExpressionValue(item1, "item1");
            setPriseItem(item1, easterItem3);
        }
        List<EasterItem> items2 = eventData.getItems();
        if (items2 != null && (easterItem2 = (EasterItem) CollectionsKt.getOrNull(items2, 1)) != null) {
            EasterBattlepassPriseItemEventBinding item2 = easterBattlePassEventItemBinding.item2;
            Intrinsics.checkNotNullExpressionValue(item2, "item2");
            setPriseItem(item2, easterItem2);
        }
        List<EasterItem> items3 = eventData.getItems();
        if (items3 != null && (easterItem = (EasterItem) CollectionsKt.getOrNull(items3, 2)) != null) {
            EasterBattlepassPriseItemEventBinding item3 = easterBattlePassEventItemBinding.item3;
            Intrinsics.checkNotNullExpressionValue(item3, "item3");
            setPriseItem(item3, easterItem);
        }
        easterBattlePassEventItemBinding.errorOverlay.setVisibility(8);
        easterBattlePassEventItemBinding.errorOverlay.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.easter.EasterScreen$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EasterScreen.updateEvent$lambda$32$lambda$28(view);
            }
        });
        String timer = eventData.getTimer();
        if (timer != null) {
            Integer intOrNull = StringsKt.toIntOrNull(timer);
            int intValue = intOrNull != null ? intOrNull.intValue() : 0;
            if (intValue > 0) {
                easterBattlePassEventItemBinding.errorOverlay.setVisibility(0);
                easterBattlePassEventItemBinding.tvErrorText.setText("Будет доступно через\n" + formatSeconds(intValue));
                final long j = intValue * 1000;
                ?? r2 = new CountDownTimer(j) { // from class: ru.mrlargha.commonui.elements.easter.EasterScreen$updateEvent$1$10$timer$1
                    @Override // android.os.CountDownTimer
                    public void onTick(long j2) {
                        EasterBattlePassEventItemBinding.this.tvErrorText.setText("Будет доступно через\n" + this.formatSeconds((int) (j2 / 1000)));
                    }

                    @Override // android.os.CountDownTimer
                    public void onFinish() {
                        EasterBattlePassEventItemBinding.this.errorOverlay.setVisibility(8);
                    }
                };
                r2.start();
                this.timersList.add(r2);
            }
        }
        String error = eventData.getError();
        if (error != null) {
            easterBattlePassEventItemBinding.errorOverlay.setVisibility(0);
            easterBattlePassEventItemBinding.tvErrorText.setText(error);
        }
        String image = eventData.getImage();
        if (image != null) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new EasterScreen$updateEvent$1$12$1(easterBattlePassEventItemBinding, image, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateEvent$lambda$32$lambda$22$lambda$20(EasterScreen easterScreen, EventData eventData, View view) {
        SAMPUIElement.notifyClick$default(easterScreen, eventData.getId(), 3, null, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v6, types: [ru.mrlargha.commonui.elements.easter.EasterScreen$setEvent$1$10$timer$1, java.lang.Object] */
    private final void setEvent(final EasterBattlePassEventItemBinding easterBattlePassEventItemBinding, final EventData eventData) {
        EasterItem easterItem;
        EasterItem easterItem2;
        EasterItem easterItem3;
        if (eventData.getName() != null) {
            easterBattlePassEventItemBinding.tvEventName.setText(eventData.getName());
        }
        if (eventData.getDescription() != null) {
            easterBattlePassEventItemBinding.tvEventDescription.setText(eventData.getDescription());
        }
        if (eventData.getButtonType() != null) {
            easterBattlePassEventItemBinding.btnJoin.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.easter.EasterScreen$$ExternalSyntheticLambda9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EasterScreen.setEvent$lambda$47$lambda$37$lambda$35(EasterScreen.this, eventData, view);
                }
            });
            String buttonType = eventData.getButtonType();
            if (buttonType != null) {
                int hashCode = buttonType.hashCode();
                if (hashCode != -1500192018) {
                    if (hashCode != -1367724422) {
                        if (hashCode == 3267882 && buttonType.equals("join")) {
                            easterBattlePassEventItemBinding.btnJoin.setBackgroundResource(R.drawable.easter_battle_pass_event_btn_bg);
                            easterBattlePassEventItemBinding.btnJoin.setText("Присоединиться");
                            easterBattlePassEventItemBinding.btnJoin.setTextColor(Color.parseColor("#3D3D3D"));
                        }
                    } else if (buttonType.equals(FacebookDialog.COMPLETION_GESTURE_CANCEL)) {
                        easterBattlePassEventItemBinding.btnJoin.setBackgroundResource(R.drawable.easter_battle_pass_event_btn_bg_white);
                        easterBattlePassEventItemBinding.btnJoin.setText("Отказаться от участия");
                        easterBattlePassEventItemBinding.btnJoin.setTextColor(Color.parseColor("#3D3D3D"));
                    }
                } else if (buttonType.equals("players_limit")) {
                    easterBattlePassEventItemBinding.btnJoin.setBackgroundResource(R.drawable.easter_battle_pass_event_btn_bg_transparent);
                    easterBattlePassEventItemBinding.btnJoin.setText("Лимит участников");
                    easterBattlePassEventItemBinding.btnJoin.setTextColor(Color.parseColor("#BE3D3D3D"));
                    easterBattlePassEventItemBinding.btnJoin.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.easter.EasterScreen$$ExternalSyntheticLambda10
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            EasterScreen.setEvent$lambda$47$lambda$37$lambda$36(view);
                        }
                    });
                }
            }
        }
        LinearLayout linearLayout = easterBattlePassEventItemBinding.attempsContainer;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        if (eventData.getAttempts() != null) {
            LinearLayout linearLayout2 = easterBattlePassEventItemBinding.attempsContainer;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
            }
            easterBattlePassEventItemBinding.tvAttemptsAvailable.setText(eventData.getAttempts().getCurrent() + RemoteSettings.FORWARD_SLASH_STRING + eventData.getAttempts().getMax());
        }
        easterBattlePassEventItemBinding.playersContainer.setVisibility(8);
        if (eventData.getPlayers() != null) {
            easterBattlePassEventItemBinding.playersContainer.setVisibility(0);
            easterBattlePassEventItemBinding.tvParticipants.setText(eventData.getPlayers().getCurrent() + RemoteSettings.FORWARD_SLASH_STRING + eventData.getPlayers().getMax());
        }
        List<EasterItem> items = eventData.getItems();
        if (items != null && (easterItem3 = (EasterItem) CollectionsKt.getOrNull(items, 0)) != null) {
            EasterBattlepassPriseItemEventBinding item1 = easterBattlePassEventItemBinding.item1;
            Intrinsics.checkNotNullExpressionValue(item1, "item1");
            setPriseItem(item1, easterItem3);
        }
        List<EasterItem> items2 = eventData.getItems();
        if (items2 != null && (easterItem2 = (EasterItem) CollectionsKt.getOrNull(items2, 1)) != null) {
            EasterBattlepassPriseItemEventBinding item2 = easterBattlePassEventItemBinding.item2;
            Intrinsics.checkNotNullExpressionValue(item2, "item2");
            setPriseItem(item2, easterItem2);
        }
        List<EasterItem> items3 = eventData.getItems();
        if (items3 != null && (easterItem = (EasterItem) CollectionsKt.getOrNull(items3, 2)) != null) {
            EasterBattlepassPriseItemEventBinding item3 = easterBattlePassEventItemBinding.item3;
            Intrinsics.checkNotNullExpressionValue(item3, "item3");
            setPriseItem(item3, easterItem);
        }
        easterBattlePassEventItemBinding.errorOverlay.setVisibility(8);
        easterBattlePassEventItemBinding.errorOverlay.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.easter.EasterScreen$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EasterScreen.setEvent$lambda$47$lambda$43(view);
            }
        });
        String timer = eventData.getTimer();
        if (timer != null) {
            Integer intOrNull = StringsKt.toIntOrNull(timer);
            int intValue = intOrNull != null ? intOrNull.intValue() : 0;
            if (intValue > 0) {
                easterBattlePassEventItemBinding.errorOverlay.setVisibility(0);
                easterBattlePassEventItemBinding.tvErrorText.setText("Будет доступно через\n" + formatSeconds(intValue));
                final long j = intValue * 1000;
                ?? r2 = new CountDownTimer(j) { // from class: ru.mrlargha.commonui.elements.easter.EasterScreen$setEvent$1$10$timer$1
                    @Override // android.os.CountDownTimer
                    public void onTick(long j2) {
                        EasterBattlePassEventItemBinding.this.tvErrorText.setText("Будет доступно через\n" + this.formatSeconds((int) (j2 / 1000)));
                    }

                    @Override // android.os.CountDownTimer
                    public void onFinish() {
                        EasterBattlePassEventItemBinding.this.errorOverlay.setVisibility(8);
                    }
                };
                r2.start();
                this.timersList.add(r2);
            }
        }
        String error = eventData.getError();
        if (error != null) {
            easterBattlePassEventItemBinding.errorOverlay.setVisibility(0);
            easterBattlePassEventItemBinding.tvErrorText.setText(error);
        }
        String image = eventData.getImage();
        if (image != null) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new EasterScreen$setEvent$1$12$1(easterBattlePassEventItemBinding, image, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setEvent$lambda$47$lambda$37$lambda$35(EasterScreen easterScreen, EventData eventData, View view) {
        SAMPUIElement.notifyClick$default(easterScreen, eventData.getId(), 3, null, 4, null);
    }

    public final String formatSeconds(int i) {
        int i2 = i / 86400;
        int i3 = (i % 86400) / DateCalculationsKt.SECONDS_PER_HOUR;
        int i4 = (i % DateCalculationsKt.SECONDS_PER_HOUR) / 60;
        int i5 = i % 60;
        ArrayList arrayList = new ArrayList();
        if (i2 > 0) {
            arrayList.add(i2 + "д");
        }
        if (i3 > 0) {
            arrayList.add(i3 + "ч");
        }
        if (i4 > 0) {
            arrayList.add(i4 + "м");
        }
        if (i2 == 0 && i5 > 0) {
            arrayList.add(i5 + "с");
        }
        if (arrayList.isEmpty()) {
            arrayList.add("0с");
        }
        return CollectionsKt.joinToString$default(arrayList, " ", null, null, 0, null, null, 62, null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final void setPriseItem(EasterBattlepassPriseItemEventBinding easterBattlepassPriseItemEventBinding, final EasterItem easterItem) {
        int i;
        String str;
        String color = easterItem.getColor();
        switch (color.hashCode()) {
            case -976943172:
                if (color.equals("purple")) {
                    i = R.drawable.rarity_purple;
                    break;
                }
                i = R.drawable.rarity_default;
                break;
            case 112785:
                if (color.equals("red")) {
                    i = R.drawable.rarity_red;
                    break;
                }
                i = R.drawable.rarity_default;
                break;
            case 3002044:
                if (color.equals("aqua")) {
                    i = R.drawable.rarity_aqua;
                    break;
                }
                i = R.drawable.rarity_default;
                break;
            case 3178592:
                if (color.equals("gold")) {
                    i = R.drawable.rarity_gold;
                    break;
                }
                i = R.drawable.rarity_default;
                break;
            case 3441014:
                if (color.equals("pink")) {
                    i = R.drawable.rarity_pink;
                    break;
                }
                i = R.drawable.rarity_default;
                break;
            default:
                i = R.drawable.rarity_default;
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
                if (color2.equals("red")) {
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
        easterBattlepassPriseItemEventBinding.bg.setBackgroundResource(i);
        easterBattlepassPriseItemEventBinding.rarity.setBackgroundColor(Color.parseColor(str));
        if (this.isArizonaType) {
            Picasso picasso = Picasso.get();
            String resourceUrl = FirebaseConfigHelper.INSTANCE.getResourceUrl();
            picasso.load(resourceUrl + "/projects/arizona-rp/assets/images/donate/" + easterItem.getItemid() + ".webp").into(easterBattlepassPriseItemEventBinding.imagePrise);
        } else {
            Picasso picasso2 = Picasso.get();
            String resourceUrl2 = FirebaseConfigHelper.INSTANCE.getResourceUrl();
            picasso2.load(resourceUrl2 + "/projects/rodina-rp/systems/battlepass/items/" + easterItem.getItemid() + ".webp").into(easterBattlepassPriseItemEventBinding.imagePrise);
        }
        easterBattlepassPriseItemEventBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.easter.EasterScreen$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EasterScreen.setPriseItem$lambda$49$lambda$48(EasterScreen.this, easterItem, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setPriseItem$lambda$49$lambda$48(EasterScreen easterScreen, EasterItem easterItem, View view) {
        String name = easterItem.getName();
        Intrinsics.checkNotNull(view);
        easterScreen.onPriseInfo(name, view);
    }

    private final void stopVideo() {
        this.binding.video.playerView.setVisibility(8);
        this.player.stop();
        this.player.release();
    }

    private final void setVideo() {
        try {
            this.binding.video.playerView.setVisibility(0);
            File file = new File(getTargetActivity().getExternalFilesDir(null), "/SAMP/easter_video.mp4");
            if (file.exists()) {
                Uri parse = Uri.parse(file.getPath());
                Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
                ExoPlayer build = new ExoPlayer.Builder(getTargetActivity()).build();
                Intrinsics.checkNotNullExpressionValue(build, "build(...)");
                this.player = build;
                this.binding.video.playerView.setPlayer(this.player);
                MediaItem fromUri = MediaItem.fromUri(parse);
                Intrinsics.checkNotNullExpressionValue(fromUri, "fromUri(...)");
                this.player.setMediaItem(fromUri);
                this.player.prepare();
                this.player.play();
                return;
            }
            Toast.makeText(getTargetActivity(), "Видео файл не найден в памяти устройства. Сбросьте игру!", 1).show();
        } catch (Exception e) {
            Toast.makeText(getTargetActivity(), "Ошибка воспроизведения видео. Сбросьте игру!", 1).show();
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
        final EasterBattlePassScreenBinding easterBattlePassScreenBinding = this.binding;
        view.post(new Runnable() { // from class: ru.mrlargha.commonui.elements.easter.EasterScreen$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                EasterScreen.onPriseInfo$lambda$53$lambda$52(view, easterBattlePassScreenBinding, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPriseInfo$lambda$53$lambda$52(View view, final EasterBattlePassScreenBinding easterBattlePassScreenBinding, final String str) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        final float width = iArr[0] + (view.getWidth() / 2);
        final float height = iArr[1] + (view.getHeight() / 2);
        Log.d("onPriseInfo", width + " , " + height);
        easterBattlePassScreenBinding.infoText.post(new Runnable() { // from class: ru.mrlargha.commonui.elements.easter.EasterScreen$$ExternalSyntheticLambda21
            @Override // java.lang.Runnable
            public final void run() {
                EasterScreen.onPriseInfo$lambda$53$lambda$52$lambda$51(EasterBattlePassScreenBinding.this, width, height, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPriseInfo$lambda$53$lambda$52$lambda$51(final EasterBattlePassScreenBinding easterBattlePassScreenBinding, float f, float f2, String str) {
        easterBattlePassScreenBinding.infoText.setX(f);
        easterBattlePassScreenBinding.infoText.setY(f2 - easterBattlePassScreenBinding.infoText.getHeight());
        easterBattlePassScreenBinding.infoText.setText(str);
        easterBattlePassScreenBinding.infoTextBg.setVisibility(0);
        easterBattlePassScreenBinding.infoTextBg.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.easter.EasterScreen$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EasterScreen.onPriseInfo$lambda$53$lambda$52$lambda$51$lambda$50(EasterBattlePassScreenBinding.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPriseInfo$lambda$53$lambda$52$lambda$51$lambda$50(EasterBattlePassScreenBinding easterBattlePassScreenBinding, View view) {
        easterBattlePassScreenBinding.infoTextBg.setVisibility(8);
    }

    private final void setupAdapters() {
        EasterBattlePassScreenBinding easterBattlePassScreenBinding = this.binding;
        easterBattlePassScreenBinding.task.rvTask.setAdapter(this.questAdapter);
        easterBattlePassScreenBinding.main.rvPrice.setAdapter(this.levelItemsAdapter);
        easterBattlePassScreenBinding.shop.rvItems.setAdapter(this.shopAdapter);
    }

    private final void clearAdapters() {
        this.questAdapter.clearList();
    }

    private final void clearTimers() {
        for (CountDownTimer countDownTimer : this.timersList) {
            countDownTimer.cancel();
        }
    }

    private final void setupNavigation() {
        EasterBattlePassScreenBinding easterBattlePassScreenBinding = this.binding;
        easterBattlePassScreenBinding.tabMain.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.easter.EasterScreen$$ExternalSyntheticLambda22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EasterScreen.setupNavigation$lambda$61$lambda$56(EasterScreen.this, view);
            }
        });
        easterBattlePassScreenBinding.tabShop.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.easter.EasterScreen$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EasterScreen.setupNavigation$lambda$61$lambda$57(EasterScreen.this, view);
            }
        });
        easterBattlePassScreenBinding.tabTask.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.easter.EasterScreen$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EasterScreen.setupNavigation$lambda$61$lambda$58(EasterScreen.this, view);
            }
        });
        easterBattlePassScreenBinding.tabEvent.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.easter.EasterScreen$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EasterScreen.setupNavigation$lambda$61$lambda$59(EasterScreen.this, view);
            }
        });
        easterBattlePassScreenBinding.backButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.easter.EasterScreen$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EasterScreen.setupNavigation$lambda$61$lambda$60(EasterScreen.this, view);
            }
        });
        this.binding.main.ivVideo.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.easter.EasterScreen$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EasterScreen.setupNavigation$lambda$62(EasterScreen.this, view);
            }
        });
        this.binding.tabVideoBack.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.easter.EasterScreen$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EasterScreen.setupNavigation$lambda$63(EasterScreen.this, view);
            }
        });
        final EasterBattlePassShopSceenBinding easterBattlePassShopSceenBinding = this.binding.shop;
        easterBattlePassShopSceenBinding.resultBack.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.easter.EasterScreen$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EasterScreen.setupNavigation$lambda$65$lambda$64(EasterBattlePassShopSceenBinding.this, view);
            }
        });
        final EasterBattlePassMainResultScreenBinding easterBattlePassMainResultScreenBinding = this.binding.resultMain;
        easterBattlePassMainResultScreenBinding.resultBack.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.easter.EasterScreen$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EasterScreen.setupNavigation$lambda$67$lambda$66(EasterBattlePassMainResultScreenBinding.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$61$lambda$56(EasterScreen easterScreen, View view) {
        SAMPUIElement.notifyClick$default(easterScreen, EasterBites.Main.getValue(), 1, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$61$lambda$57(EasterScreen easterScreen, View view) {
        SAMPUIElement.notifyClick$default(easterScreen, EasterBites.Shop.getValue(), 1, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$61$lambda$58(EasterScreen easterScreen, View view) {
        SAMPUIElement.notifyClick$default(easterScreen, EasterBites.Task.getValue(), 1, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$61$lambda$59(EasterScreen easterScreen, View view) {
        SAMPUIElement.notifyClick$default(easterScreen, EasterBites.Event.getValue(), 1, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$61$lambda$60(EasterScreen easterScreen, View view) {
        easterScreen.stopVideo();
        SAMPUIElement.notifyClick$default(easterScreen, 0, 0, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$62(EasterScreen easterScreen, View view) {
        easterScreen.navigateTo(Navigation.Video);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$63(EasterScreen easterScreen, View view) {
        easterScreen.navigateTo(Navigation.Main);
        easterScreen.stopVideo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$65$lambda$64(EasterBattlePassShopSceenBinding easterBattlePassShopSceenBinding, View view) {
        easterBattlePassShopSceenBinding.result.setVisibility(8);
        easterBattlePassShopSceenBinding.rvItems.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$67$lambda$66(EasterBattlePassMainResultScreenBinding easterBattlePassMainResultScreenBinding, View view) {
        easterBattlePassMainResultScreenBinding.getRoot().setVisibility(8);
    }

    private final void navigateTo(Navigation navigation) {
        clearAdapters();
        this.binding.main.getRoot().setVisibility(8);
        this.binding.task.getRoot().setVisibility(8);
        this.binding.events.getRoot().setVisibility(8);
        this.binding.shop.getRoot().setVisibility(8);
        this.binding.video.getRoot().setVisibility(8);
        this.binding.resultMain.getRoot().setVisibility(8);
        this.binding.tabsContainer.setVisibility(0);
        this.binding.moneyContainer.setVisibility(0);
        this.binding.videoTabsContainer.setVisibility(8);
        this.binding.shop.result.setVisibility(8);
        this.binding.bg.setBackgroundResource(R.drawable.easter_battle_pass_main_bg2);
        this.binding.infoTextBg.setVisibility(8);
        EasterBattlePassScreenBinding easterBattlePassScreenBinding = this.binding;
        easterBattlePassScreenBinding.tabMain.setBackgroundResource(R.drawable.easter_battle_pass_tab_unselect_bg);
        easterBattlePassScreenBinding.tabShop.setBackgroundResource(R.drawable.easter_battle_pass_tab_unselect_bg);
        easterBattlePassScreenBinding.tabTask.setBackgroundResource(R.drawable.easter_battle_pass_tab_unselect_bg);
        easterBattlePassScreenBinding.tabEvent.setBackgroundResource(R.drawable.easter_battle_pass_tab_unselect_bg);
        easterBattlePassScreenBinding.tabMain.setTextColor(-1);
        easterBattlePassScreenBinding.tabShop.setTextColor(-1);
        easterBattlePassScreenBinding.tabTask.setTextColor(-1);
        easterBattlePassScreenBinding.tabEvent.setTextColor(-1);
        int i = WhenMappings.$EnumSwitchMapping$0[navigation.ordinal()];
        if (i == 1) {
            this.binding.bg.setBackgroundResource(R.drawable.easter_battle_pass_main_bg);
            this.binding.main.getRoot().setVisibility(0);
            this.binding.tabMain.setBackgroundResource(R.drawable.easter_battle_pass_main_tab_select_bg);
            this.binding.tabMain.setTextColor(this.textSelectedColor);
        } else if (i == 2) {
            clearTimers();
            this.binding.task.getRoot().setVisibility(0);
            this.binding.tabTask.setBackgroundResource(R.drawable.easter_battle_pass_main_tab_select_bg);
            this.binding.tabTask.setTextColor(this.textSelectedColor);
        } else if (i == 3) {
            this.binding.events.getRoot().setVisibility(0);
            this.binding.tabEvent.setBackgroundResource(R.drawable.easter_battle_pass_main_tab_select_bg);
            this.binding.tabEvent.setTextColor(this.textSelectedColor);
        } else if (i == 4) {
            this.binding.shop.getRoot().setVisibility(0);
            this.binding.tabShop.setBackgroundResource(R.drawable.easter_battle_pass_main_tab_select_bg);
            this.binding.tabShop.setTextColor(this.textSelectedColor);
        } else if (i != 5) {
            throw new NoWhenBranchMatchedException();
        } else {
            this.binding.video.getRoot().setVisibility(0);
            this.binding.tabsContainer.setVisibility(8);
            this.binding.moneyContainer.setVisibility(8);
            this.binding.videoTabsContainer.setVisibility(0);
            setVideo();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: EasterScreen.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lru/mrlargha/commonui/elements/easter/EasterScreen$EasterBites;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Main", "Task", "Event", "Shop", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class EasterBites {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ EasterBites[] $VALUES;
        private final int value;
        public static final EasterBites Main = new EasterBites("Main", 0, 1);
        public static final EasterBites Task = new EasterBites("Task", 1, 2);
        public static final EasterBites Event = new EasterBites("Event", 2, 4);
        public static final EasterBites Shop = new EasterBites("Shop", 3, 8);

        private static final /* synthetic */ EasterBites[] $values() {
            return new EasterBites[]{Main, Task, Event, Shop};
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
    /* compiled from: EasterScreen.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lru/mrlargha/commonui/elements/easter/EasterScreen$Navigation;", "", "<init>", "(Ljava/lang/String;I)V", "Main", "Task", "Events", "Shop", "Video", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Navigation {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Navigation[] $VALUES;
        public static final Navigation Main = new Navigation("Main", 0);
        public static final Navigation Task = new Navigation("Task", 1);
        public static final Navigation Events = new Navigation("Events", 2);
        public static final Navigation Shop = new Navigation("Shop", 3);
        public static final Navigation Video = new Navigation("Video", 4);

        private static final /* synthetic */ Navigation[] $values() {
            return new Navigation[]{Main, Task, Events, Shop, Video};
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

    /* compiled from: EasterScreen.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/easter/EasterScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new EasterScreen(targetActivity, i);
        }
    }
}
